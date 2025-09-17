package c.t;

import android.content.pm.ApplicationInfo;
import android.os.Process;
import android.util.Log;

public class t implements AbstractC0248Jl {
    private static final String TAG = "Aochuang";
    public static void a(c.t.C0225Io r16) {
        Log.d(TAG, "c.t.t.a调用了 00000000000000000000");
        ApplicationInfo application = r16.b;
        ClassLoader classLoader = r16.f259c;
        String d = r16.d;
        String e = r16.e;
        Log.d(TAG, "c.t.t.a调用了 d = "+ d +" e = " + e + " application = " + application.packageName);
        if (Process.myPid() != Process.myTid()) {
            return;
        }
    }
    public static void b(c.t.C0225Io r16) {
    }

}
