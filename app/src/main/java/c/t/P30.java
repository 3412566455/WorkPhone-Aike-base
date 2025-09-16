package c.t;

import android.content.pm.ApplicationInfo;

import c.t.tp.Bridge;

public class P30 extends AbstractC0098Dr{
    @Override
    public void a(C0072Cr cr) {
        Object currentActivityThread = CP.d(CP.e(ClassLoader.getSystemClassLoader(), "android.app.ActivityThread"), "currentActivityThread");
        if (CP.o(currentActivityThread, "mInstrumentation") == null) {
            Object o = CP.o(currentActivityThread, "mBoundApplication");
            ApplicationInfo applicationInfo = (ApplicationInfo) CP.o(o, "appInfo");
            String str = "android".equals(applicationInfo.packageName) ? "system" : applicationInfo.packageName;
            if (applicationInfo.sourceDir != null) {
                C0225Io io = new C0225Io(Bridge.d);
                io.d = str;
                io.e = (String) CP.o(o, "processName");
                Object loadedApk = CP.o(o, "info");
                io.f259c = (ClassLoader) CP.c(loadedApk, "getClassLoader");
                io.b = applicationInfo;
                AbstractC0251Jo.a(io);
            }
        }

    }
}
