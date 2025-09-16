package c.t.tp;

import android.util.Log;
import java.lang.reflect.Member;
import java.lang.reflect.InvocationTargetException;

import c.t.AbstractC0098Dr;
import c.t.AbstractC0248Jl;
import c.t.AbstractC2016u1;
import c.t.N4;

public class Bridge {
    // 日志标签
    private static final String TAG = "Bridge";

    public static final Object[] a = new Object[0];

    public static final N4 d = new N4();

    public static boolean f1442c = false;

    public static void a(Throwable th) {
        Log.d(TAG, "有人调用 (Bridge.a has been called)");
    }

    public static void b(Class cls, Object abstractC0405Pq) {
        Log.d(TAG, "有人调用 (Bridge.b has been called)");
    }

    public static void c(Class cls, String str, Object abstractC0405Pq) {
        Log.d(TAG, "有人调用 (Bridge.c has been called)");
    }

    public static Object d(Object abstractC0405Pq, AbstractC0098Dr member) {
        Log.d(TAG, "有人调用 (Bridge.d has been called)");
        return null;
    }

    public static native void doCommandNative(int i, Object obj);

    public static Object handleRuntimeEvent(Member member, Object obj, Object obj2, Object[] objArr) throws InvocationTargetException {
        Log.d(TAG, "有人调用 (Bridge.handleRuntimeEvent has been called)");
        return null;
    }

    public static native Object invokeNative(Member member, int i, Object obj, Object[] objArr);

    public static void main(String[] strArr, int i) {
        Log.d(TAG, "有人调用 (Bridge.main has been called)");
        Log.d(TAG, "Bridge.main has been called. Check Logcat for details.");

        boolean z;
        if ((i & 1) != 0) {
            z = true;
        } else {
            z = false;
        }
        if ((i & 2) != 0) {
            try {
                f1442c = true;
            } catch (Throwable th) {
                Log.e("Apollo", "Errors during initialization", th);
                return;
            }
        }
        try {
            if (z) {
                AbstractC2016u1.d();
                Object newInstance = AbstractC2016u1.class.getClassLoader().loadClass("c.t.t").newInstance();
                if (newInstance instanceof AbstractC0248Jl) {
                    AbstractC0248Jl jl = (AbstractC0248Jl) newInstance;
                    N4 n4 = d;
                    synchronized (n4) {
                        n4.a(jl);
                    }
                }
            }
        } catch (Throwable e) {
            Log.e("Apollo", "main error", e);
        }
    }

    private static native synchronized void proxyMethodNative(Member member, Class<?> cls, int i, Object obj);
}
