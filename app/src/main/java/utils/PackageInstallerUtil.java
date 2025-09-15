package utils;// utils.PackageInstallerUtil.java

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PackageInstallerUtil {
    private static final String TAG = "utils.PackageInstallerUtil";
    private static final String ACTION_INSTALL_RESULT = "com.apollo.safechat.INSTALL_RESULT_ACTION";

    /**
     * 模拟 os.c 方法.
     * @param context Context
     * @param apkFile 要安装的APK文件
     * @param timeoutSeconds 等待的超时时间（秒）
     * @return 1 表示成功, 负数表示失败或错误.
     */
    public static int installWithPackageInstaller(Context context, File apkFile, int timeoutSeconds) {
        if (!apkFile.exists()) {
            Log.e(TAG, "APK file does not exist: " + apkFile.getPath());
            return -1; // 自定义错误码：文件不存在
        }

        PackageInstaller packageInstaller = context.getPackageManager().getPackageInstaller();
        PackageInstaller.SessionParams params = new PackageInstaller.SessionParams(PackageInstaller.SessionParams.MODE_FULL_INSTALL);
        int sessionId = -1;
        InstallSessionCallback callback = null;

        try {
            sessionId = packageInstaller.createSession(params);
            callback = new InstallSessionCallback(sessionId);

            // 注册回调
            registerCallback(sessionId, callback);
            packageInstaller.registerSessionCallback(callback, new Handler(Looper.getMainLooper()));

            // 写入APK数据
            writeApkToSession(packageInstaller, sessionId, apkFile);

            // 提交安装
            commitSession(context, packageInstaller, sessionId);

            // 同步等待结果
            return waitForResult(callback, timeoutSeconds);

        } catch (IOException e) {
            Log.e(TAG, "IOException during installation", e);
            return -2; // 自定义错误码：IO异常
        } catch (Exception e) {
            Log.e(TAG, "Generic exception during installation", e);
            return -3; // 自定义错误码：通用异常
        } finally {
            // 清理工作
            if (callback != null) {
                packageInstaller.unregisterSessionCallback(callback);
                unregisterCallback(sessionId);
            }
            if (sessionId != -1) {
                // 确保无论成功失败都放弃会话，避免残留
                try {
                    packageInstaller.abandonSession(sessionId);
                } catch (Exception e) {
                    // ignore
                }
            }
        }
    }

    private static void registerCallback(int sessionId, InstallSessionCallback callback) {
        synchronized (InstallResultReceiver.sessionCallbacks) {
            InstallResultReceiver.sessionCallbacks.put(sessionId, callback);
        }
    }

    private static void unregisterCallback(int sessionId) {
        synchronized (InstallResultReceiver.sessionCallbacks) {
            InstallResultReceiver.sessionCallbacks.remove(sessionId);
        }
    }

    private static void writeApkToSession(PackageInstaller installer, int sessionId, File apkFile) throws IOException {
        long size = apkFile.length();
        try (PackageInstaller.Session session = installer.openSession(sessionId);
             InputStream in = new FileInputStream(apkFile)) {
            try (OutputStream out = session.openWrite("package", 0, size)) {
                byte[] buffer = new byte[8192];
                int c;
                while ((c = in.read(buffer)) != -1) {
                    out.write(buffer, 0, c);
                }
                session.fsync(out);
            }
        }
    }

    private static void commitSession(Context context, PackageInstaller installer, int sessionId) throws IOException {
        try (PackageInstaller.Session session = installer.openSession(sessionId)) {
            Intent intent = new Intent(context, InstallResultReceiver.class);
            intent.setAction(ACTION_INSTALL_RESULT);

            // PendingIntent.FLAG_UPDATE_CURRENT is important to deliver the latest extras
            int flags = PendingIntent.FLAG_UPDATE_CURRENT;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                flags |= PendingIntent.FLAG_MUTABLE;
            }
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, sessionId, intent, flags);
            session.commit(pendingIntent.getIntentSender());
        }
    }

    private static int waitForResult(InstallSessionCallback callback, int timeoutSeconds) {
        int loopCount = 0;
        while (callback.resultCode == -9999 && loopCount < timeoutSeconds) {
            SystemClock.sleep(1000);
            loopCount++;
        }
        // 如果超时后结果依然是初始值，则认为是超时失败
        if (callback.resultCode == -9999) {
            return -99; // 自定义错误码：超时
        }
        return callback.resultCode;
    }
}