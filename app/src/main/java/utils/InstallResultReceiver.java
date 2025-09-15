package utils;// utils.InstallResultReceiver.java

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;

public class InstallResultReceiver extends BroadcastReceiver {
    private static final String TAG = "InstallReceiver";

    // 使用静态 SparseArray 来存储回调，模拟原始代码的 'a'
    public static final SparseArray<InstallSessionCallback> sessionCallbacks = new SparseArray<>();

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            Log.e(TAG, "Extras are null, cannot process install result.");
            return;
        }

        int sessionId = extras.getInt(PackageInstaller.EXTRA_SESSION_ID, -1);
        InstallSessionCallback callback;

        synchronized (sessionCallbacks) {
            callback = sessionCallbacks.get(sessionId);
        }

        if (callback == null || callback.sessionId != sessionId) {
            Log.e(TAG, "No matching callback found for session ID: " + sessionId);
            return;
        }

        int status = extras.getInt(PackageInstaller.EXTRA_STATUS);
        String message = extras.getString(PackageInstaller.EXTRA_STATUS_MESSAGE);
        Log.d(TAG, "Install result received: sessionId=" + sessionId + ", status=" + status + ", message=" + message);

        switch (status) {
            case PackageInstaller.STATUS_PENDING_USER_ACTION:
                // 系统需要用户确认，从广播中取出Intent并启动它
                Intent confirmIntent = (Intent) extras.get(Intent.EXTRA_INTENT);
                confirmIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                try {
                    context.startActivity(confirmIntent);
                } catch (Exception e) {
                    Log.e(TAG, "Could not start confirmation activity", e);
                    callback.resultCode = -111; // 自定义错误码：无法启动确认界面
                }
                // 注意：此时安装流程尚未结束，resultCode不更新
                break;
            case PackageInstaller.STATUS_SUCCESS:
                // 安装成功
                callback.resultCode = 1;
                break;
            case PackageInstaller.STATUS_FAILURE:
            case PackageInstaller.STATUS_FAILURE_ABORTED:
            case PackageInstaller.STATUS_FAILURE_BLOCKED:
            case PackageInstaller.STATUS_FAILURE_CONFLICT:
            case PackageInstaller.STATUS_FAILURE_INCOMPATIBLE:
            case PackageInstaller.STATUS_FAILURE_INVALID:
            case PackageInstaller.STATUS_FAILURE_STORAGE:
                // 各种失败情况，统一映射为一个失败码
                callback.resultCode = -110; // 自定义错误码：通用安装失败
                break;
            default:
                callback.resultCode = -1; // 未知状态
                break;
        }
    }
}