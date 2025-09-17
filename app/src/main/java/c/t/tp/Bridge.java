package c.t.tp;

import android.util.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;

import c.t.AbstractC0098Dr;
import c.t.AbstractC0248Jl;
import c.t.AbstractC2016u1;
import c.t.C0072Cr;
import c.t.C2275xu;
import c.t.N4;

public class Bridge {
    // 日志标签
    private static final String TAG = "Aochuang";

    public static final Object[] a = new Object[0];
    public static final HashMap b = new HashMap();

    public static final N4 d = new N4();

    public static boolean f1442c = false;

    public static void a(Throwable th) {
        Log.e(TAG, "有人调用 (Bridge.a has been called)");
    }

    public static void b(Class cls, Object abstractC0405Pq) {
        Log.e(TAG, "有人调用 (Bridge.b has been called)");
    }

    public static void c(Class cls, String str, Object abstractC0405Pq) {
        Log.e(TAG, "有人调用 (Bridge.c has been called)");
    }

    public static Object d(Member member, AbstractC0098Dr dr) {
        Log.e(TAG, "有人调用 (Bridge.d has been called)");
//        N4 n4;
//        boolean z = true;
//        if (!((!(member instanceof Method) && !(member instanceof Constructor)) || Modifier.isAbstract(member.getModifiers()) || member.getDeclaringClass().isInterface())) {
//            Log.e(TAG, "有人调用 (Bridge.d has been called) 111111111111111111111111");
//            HashMap hashMap = b;
//            synchronized (hashMap) {
//                n4 = (N4) hashMap.get(member);
//                if (n4 == null) {
//                    n4 = new N4();
//                    hashMap.put(member, n4);
//                } else {
//                    z = false;
//                }
//            }
//            n4.a(dr);
//            Log.e(TAG, "有人调用 (Bridge.d has been called) n4.a");
//            if (z) {
//                Log.e(TAG, "有人调用 (Bridge.d has been called) z="+z);
//                Log.e(TAG, "有人调用 (Bridge.d has been called) member.getDeclaringClass="+member.getDeclaringClass()+" n4="+n4);
//                //有人调用 (Bridge.d has been called) member.getDeclaringClass=class android.app.ActivityThread n4=c.t.N4@c1f4a7c
//                //有人调用 (Bridge.d has been called) member.getDeclaringClass=class android.app.ConfigurationController n4=c.t.N4@561e84e
////                proxyMethodNative(member, member.getDeclaringClass(), 0, n4);
//            }
//            return new C2275xu(dr, member, 4);
//        }
        return null;
    }

    public static native void doCommandNative(int i, Object obj);

    public static Object handleRuntimeEvent(Member member, Object obj, Object obj2, Object[] objArr) throws InvocationTargetException {
        Log.e(TAG, "有人调用 (Bridge.handleRuntimeEvent has been called)");
//        Object[] objArr2 = ((N4) obj).a;
//        int length = objArr2.length;
//        boolean z = true;
//        if (length == 0) {
//            try {
//                return invokeNative(member, 1, obj2, objArr);
//            } catch (Throwable e) {
//            }
//        } else {
//            C0072Cr cr = new C0072Cr();
//            cr.e = member;
//            cr.g = obj2;
//            cr.b = objArr;
//            int i = 0;
//            while (true) {
//                try {
//                    ((AbstractC0098Dr) objArr2[i]).b(cr);
//                    if (cr.f) {
//                        i++;
//                        break;
//                    }
//                } catch (Throwable th) {
//                    a(th);
//                    cr.h(null);
//                    cr.f = false;
//                }
//                i++;
//                if (i >= length) {
//                    break;
//                }
//            }
//            if (!cr.f) {
//                try {
//                    cr.h(invokeNative(member, 1, obj2, objArr));
//                } catch (Throwable e2) {
//                    cr.d = e2.getCause();
//                    cr.f98c = null;
//                    cr.f = true;
//                }
//            }
//            int i2 = i - 1;
//            do {
//                Object obj3 = cr.f98c;
//                Throwable th2 = cr.d;
//                try {
//                    ((AbstractC0098Dr) objArr2[i2]).a(cr);
//                } catch (Throwable th3) {
//                    a(th3);
//                    if (th2 == null) {
//                        cr.h(obj3);
//                    } else {
//                        cr.d = th2;
//                        cr.f98c = null;
//                        cr.f = true;
//                    }
//                }
//                i2--;
//            } while (i2 >= 0);
//            Throwable th4 = cr.d;
//            if (th4 == null) {
//                z = false;
//            }
//            if (!z) {
//                return cr.f98c;
//            }
//        }
        return null;
    }

    public static native Object invokeNative(Member member, int i, Object obj, Object[] objArr);

    public static void main(String[] strArr, int i) {
        Log.e(TAG, "有人调用 (Bridge.main has been called)");
        Log.e(TAG, "Bridge.main has been called. Check Logcat for details. i=["+ i +"]");

        boolean z;
        if ((i & 1) != 0) {
            z = true;
        } else {
            z = false;
        }
        Log.e(TAG, "1111111111111111111"+"z = ["+z+"]");
        if ((i & 2) != 0) {
            try {
                f1442c = true;
            } catch (Throwable th) {
                Log.e(TAG, "Errors during initialization", th);
                return;
            }
        }
        Log.e(TAG, "1111111111111111111"+"f1442c = ["+f1442c+"]");
        try {
            if (z) {
                AbstractC2016u1.d();
                Object newInstance = AbstractC2016u1.class.getClassLoader().loadClass("c.t.t").newInstance();
                Log.e(TAG, "2222222222222222222");
                if (newInstance instanceof AbstractC0248Jl) {
                    Log.e(TAG, "33333333333333333333");
                    AbstractC0248Jl jl = (AbstractC0248Jl) newInstance;
                    N4 n4 = d;
                    synchronized (n4) {
                        Log.e(TAG, "4444444444444444444444");
                        n4.a(jl);
                        Log.e(TAG, "5555555555555555555555");
                    }
                }
            }
        } catch (Throwable e) {
            Log.e(TAG, "main error", e);
        }
    }

    private static native synchronized void proxyMethodNative(Member member, Class<?> cls, int i, Object obj);
}
