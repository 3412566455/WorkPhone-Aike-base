// InstallSessionCallback.java
package utils; // 建议为安装器创建一个单独的包

import android.content.pm.PackageInstaller;

public class InstallSessionCallback extends PackageInstaller.SessionCallback {
    // 初始状态，-9999表示“正在进行中”
    public volatile int resultCode = -9999;

    // 会话ID，用于识别
    public final int sessionId;

    // 一个简单的标志位，用于在回调中判断是否完成
    public volatile boolean isFinished = false;

    public InstallSessionCallback(int sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public void onCreated(int sessionId) {}

    @Override
    public void onBadgingChanged(int sessionId) {}

    @Override
    public void onActiveChanged(int sessionId, boolean active) {}

    @Override
    public void onProgressChanged(int sessionId, float progress) {}

    @Override
    public void onFinished(int sessionId, boolean success) {
        // onFinished 通常在用户做出选择后（允许或拒绝）或安装完成后被调用
        // 但我们主要依赖广播来获取更详细的状态
        isFinished = true;
    }
}