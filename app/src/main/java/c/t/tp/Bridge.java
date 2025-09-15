package c.t.tp;

import android.util.Log;
import java.lang.reflect.Member;
import java.lang.reflect.InvocationTargetException;

public class Bridge {
    // 日志标签
    private static final String TAG = "Bridge";

    public static final Object[] a = new Object[0];

    public static void a(Throwable th) {
        Log.d(TAG, "有人调用 (Bridge.a has been called)");
    }

    public static void b(Class cls, Object abstractC0405Pq) {
        Log.d(TAG, "有人调用 (Bridge.b has been called)");
    }

    public static void c(Class cls, String str, Object abstractC0405Pq) {
        Log.d(TAG, "有人调用 (Bridge.c has been called)");
    }

    public static Object d(Object abstractC0405Pq, Member member) {
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
    }

    private static native synchronized void proxyMethodNative(Member member, Class<?> cls, int i, Object obj);
}
