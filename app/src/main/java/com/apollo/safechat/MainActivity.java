package com.apollo.safechat; // 请确保包名与您的项目一致

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.apollo.safechat.R;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import c.t.tp.Bridge; // 假设这个Bridge类存在
import utils.PackageInstallerUtil;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "InstallChecker";
    private TextView tvStatus;
    private Button btnCheckAndInstall;
    private Button btnCallBridge;

    private final ActivityResultLauncher<Intent> requestInstallPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    if (getPackageManager().canRequestPackageInstalls()) {
                        showToastOnUI("权限已授予，请再次点击按钮以开始更新");
                    } else {
                        showToastOnUI("未授予安装未知应用的权限，无法更新");
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvStatus = findViewById(R.id.tvStatus);
        btnCheckAndInstall = findViewById(R.id.btnCheckAndInstall);
        btnCallBridge = findViewById(R.id.btnCallBridge);

        btnCheckAndInstall.setOnClickListener(v -> checkInstallationPath());

        btnCallBridge.setOnClickListener(v -> {
            new Thread(() -> {
                Bridge.main(new String[]{}, 4);
                showToastOnUI("已调用 Bridge.main，请查看 Logcat");
            }).start();
        });
    }

    private void checkInstallationPath() {
        ApplicationInfo appInfo = getApplicationInfo();
        String sourceDir = appInfo.sourceDir;
        String statusText = "当前安装路径: " + sourceDir;
        Log.d(TAG, statusText);

        if (sourceDir != null && sourceDir.startsWith("/data/app")) {
            statusText += "\n\n路径正确，无需更新。";
            tvStatus.setText(statusText);
            Toast.makeText(this, "已安装在正确目录", Toast.LENGTH_SHORT).show();
        } else {
            statusText += "\n\n路径不正确，准备调用更新...";
            tvStatus.setText(statusText);

            // 将耗时操作（文件复制）和安装请求放在子线程中
            new Thread(() -> {
                // 1. 先将APK复制到安全位置
                File copiedApk = copyApkToCache(sourceDir);

                if (copiedApk != null) {
                    showToastOnUI("APK 复制成功，准备更新...");
                    // 2. 触发双重策略的更新流程
                    triggerSelfUpdate(copiedApk);
                } else {
                    showToastOnUI("APK 复制失败，无法更新");
                    Log.e(TAG, "复制APK文件失败");
                }
            }).start();
        }
    }

    private File copyApkToCache(String sourceApkPath) {
        File sourceFile = new File(sourceApkPath);
        File destFile = new File(getCacheDir(), "update.apk");

        if (destFile.exists()) {
            destFile.delete();
        }

        try (InputStream in = new FileInputStream(sourceFile);
             OutputStream out = new FileOutputStream(destFile)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, bytesRead);
            }
            Log.d(TAG, "APK 已成功复制到: " + destFile.getAbsolutePath());
            return destFile;

        } catch (IOException e) {
            Log.e(TAG, "复制APK时出错", e);
            return null;
        }
    }

    /**
     * 触发自我更新流程，完全模拟Smali代码的双重策略
     * @param apkFile 已经复制到缓存目录的APK文件
     */
    private void triggerSelfUpdate(File apkFile) {
        // 步骤1: 检查“安装未知应用”权限 (两种方式都需要)


        // 步骤2: Plan A - 尝试使用 PackageInstallerUtil
//        Log.d(TAG, "Plan A: 尝试使用 PackageInstallerUtil 进行更新...");
//        // 设置30秒超时
//        int resultCode = PackageInstallerUtil.installWithPackageInstaller(this, apkFile, 30);
//        Log.d(TAG, "PackageInstallerUtil 返回结果码: " + resultCode);
//
//        // 步骤3: 根据Plan A的结果决定是否执行Plan B
//        if (resultCode == 1) {
//            // resultCode为1表示成功，或者系统已经接管并弹窗，流程正常
//            showToastOnUI("更新请求已成功提交给系统！");
//            Log.i(TAG, "Plan A 成功或已交由系统处理。");
//        } else {
//            // Plan A 失败，回退到 Plan B
//            showToastOnUI("Plan A 失败 (code: " + resultCode + "), 尝试 Plan B...");

        installApkWithIntentView(apkFile);
//        }
    }

    /**
     * Plan B: 使用传统的 Intent.ACTION_VIEW 方式来安装/更新 APK
     * @param apkFile 要安装的APK文件
     */
    private void installApkWithIntentView(File apkFile) {
        if (apkFile == null || !apkFile.exists()) {
            showToastOnUI("Plan B 失败: APK 文件不存在!");
            return;
        }

        // authority 必须与 AndroidManifest.xml 和 provider_paths.xml 中定义的一致
        Uri apkUri = FileProvider.getUriForFile(this, getPackageName() + ".provider", apkFile);

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        try {
            startActivity(intent);
        } catch (Exception e) {
            Log.e(TAG, "Plan B 失败: 启动安装程序失败", e);
            showToastOnUI("Plan B 失败: " + e.getMessage());
        }
    }

    private void showToastOnUI(final String message) {
        runOnUiThread(() -> Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show());
    }
}