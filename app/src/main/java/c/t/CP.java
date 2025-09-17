package c.t;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.WeakHashMap;

import c.t.tp.Bridge2;

public abstract class CP {
    public static final HashMap a = new HashMap();
    public static final HashMap b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public static final HashMap f83c = new HashMap();
    public static final WeakHashMap d = new WeakHashMap();

    public static void A(Object obj, Object obj2, String str) {
        try {
            i(str, obj.getClass()).set(obj, obj2);
        } catch (IllegalAccessException e) {
//            Bridge.a(e);
            throw new IllegalAccessError(e.getMessage());
        } catch (IllegalArgumentException e2) {
            throw e2;
        }
    }

    public static Class[] a(ClassLoader classLoader, Object[] objArr) {
        Class[] clsArr = null;
        for (int length = objArr.length - 1; length >= 0; length--) {
            Object obj = objArr[length];
            if (obj != null) {
                if (!(obj instanceof AbstractC0098Dr)) {
                    if (clsArr == null) {
                        clsArr = new Class[length + 1];
                    }
                    if (obj instanceof Class) {
                        clsArr[length] = (Class) obj;
                    } else if (obj instanceof String) {
                        clsArr[length] = e(classLoader, (String) obj);
                    } else {
//                        throw new AP("parameter type must either be specified as Class or String");
                    }
                }
            } else {
//                throw new AP("parameter type must not be null");
            }
        }
        return clsArr == null ? new Class[0] : clsArr;
    }

    public static String b(Class... clsArr) {
        StringBuilder sb = new StringBuilder("(");
        int length = clsArr.length;
        boolean z = true;
        for (int i = 0; i < length; i++) {
            Class cls = clsArr[i];
            if (z) {
                z = false;
            } else {
                sb.append(",");
            }
            sb.append(cls != null ? cls.getCanonicalName() : "null");
        }
        sb.append(")");
        return sb.toString();
    }

    public static Object c(Object obj, String str, Object... objArr) {
        try {
            return j(obj.getClass(), str, objArr).invoke(obj, objArr);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object d(Class cls, String str, Object... objArr) {
        try {
            return j(cls, str, objArr).invoke(null, objArr);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Class e(ClassLoader classLoader, String str) {
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        try {
            return a40.b(classLoader, str);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Class f(ClassLoader classLoader, String str) {
        try {
            return e(classLoader, str);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Constructor g(Class cls, Object... objArr) {
        Class[] clsArr = new Class[objArr.length];
        int i = 0;
        while (true) {
            Class<?> cls2 = null;
            if (i >= objArr.length) {
                break;
            }
            Object obj = objArr[i];
            if (obj != null) {
                cls2 = obj.getClass();
            }
            clsArr[i] = cls2;
            i++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getName());
        String o = AbstractC1360kB.o(sb, b(clsArr), "#bestmatch");
        HashMap hashMap = f83c;
        if (hashMap.containsKey(o)) {
            Constructor constructor = (Constructor) hashMap.get(o);
            if (constructor != null) {
                return constructor;
            }
            throw new NoSuchMethodError(o);
        }
        try {
            Constructor h = h(cls, clsArr);
            hashMap.put(o, h);
            return h;
        } catch (NoSuchMethodError unused) {
            Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
            int length = declaredConstructors.length;
            int i2 = 0;
            Constructor<?> constructor2 = null;
            while (true) {
                char c2 = 1;
                if (i2 >= length) {
                    break;
                }
                Constructor<?> constructor3 = declaredConstructors[i2];
                if (a40.d(clsArr, constructor3.getParameterTypes())) {
                    if (constructor2 != null) {
                        Class<?>[] parameterTypes = constructor3.getParameterTypes();
                        Class<?>[] parameterTypes2 = constructor2.getParameterTypes();
                        float a2 = m40.a(clsArr, parameterTypes);
                        float a3 = m40.a(clsArr, parameterTypes2);
                        if (a2 < a3) {
                            c2 = 65535;
                        } else if (a3 >= a2) {
                            c2 = 0;
                        }
                        if (c2 >= 0) {
                        }
                    }
                    constructor2 = constructor3;
                }
                i2++;
            }
            if (constructor2 != null) {
                constructor2.setAccessible(true);
                hashMap.put(o, constructor2);
                return constructor2;
            }
            NoSuchMethodError noSuchMethodError = new NoSuchMethodError(o);
            hashMap.put(o, null);
            throw noSuchMethodError;
        }
    }

    public static Constructor h(Class cls, Class... clsArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getName());
        String o = AbstractC1360kB.o(sb, b(clsArr), "#exact");
        HashMap hashMap = f83c;
        if (hashMap.containsKey(o)) {
            Constructor constructor = (Constructor) hashMap.get(o);
            if (constructor != null) {
                return constructor;
            }
            throw new NoSuchMethodError(o);
        }
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(clsArr);
            declaredConstructor.setAccessible(true);
            hashMap.put(o, declaredConstructor);
            return declaredConstructor;
        } catch (NoSuchMethodException unused) {
            hashMap.put(o, null);
            throw new NoSuchMethodError(o);
        }
    }

    public static Field i(String str, Class cls) {
        Field field;
        String str2 = cls.getName() + '#' + str;
        HashMap hashMap = a;
        try {
            if (hashMap.containsKey(str2)) {
                field = (Field) hashMap.get(str2);
                if (field == null) {
                    throw new NoSuchFieldError(str2);
                }
            } else {
                try {
                    field = cls.getDeclaredField(str);
                } catch (NoSuchFieldException e) {
                    while (true) {
                        cls = cls.getSuperclass();
                        if (cls == null || cls.equals(Object.class)) {
                            break;
                        }
                        try {
                            field = cls.getDeclaredField(str);
                            break;
                        } catch (NoSuchFieldException unused) {
                        }
                    }
                    throw e;
                }
                field.setAccessible(true);
                hashMap.put(str2, field);
            }
            return field;
        } catch (NoSuchFieldException unused2) {
            hashMap.put(str2, null);
            throw new NoSuchFieldError(str2);
        }
    }

    public static Method j(Class cls, String str, Object... objArr) {
        Method[] declaredMethods;
        char c2;
        Class[] clsArr = new Class[objArr.length];
        int i = 0;
        while (true) {
            Class<?> cls2 = null;
            if (i >= objArr.length) {
                break;
            }
            Object obj = objArr[i];
            if (obj != null) {
                cls2 = obj.getClass();
            }
            clsArr[i] = cls2;
            i++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getName());
        sb.append('#');
        sb.append(str);
        String o = AbstractC1360kB.o(sb, b(clsArr), "#bestmatch");
        HashMap hashMap = b;
        if (hashMap.containsKey(o)) {
            Method method = (Method) hashMap.get(o);
            if (method != null) {
                return method;
            }
            throw new NoSuchMethodError(o);
        }
        Class cls3 = cls;
        try {
            Method k = k(cls3, str, clsArr);
            hashMap.put(o, k);
            return k;
        } catch (NoSuchMethodError unused) {
            Method method2 = null;
            boolean z = true;
            while (true) {
                for (Method method3 : cls3.getDeclaredMethods()) {
                    if ((z || !Modifier.isPrivate(method3.getModifiers())) && method3.getName().equals(str) && a40.d(clsArr, method3.getParameterTypes())) {
                        if (method2 != null) {
                            Class<?>[] parameterTypes = method3.getParameterTypes();
                            Class<?>[] parameterTypes2 = method2.getParameterTypes();
                            float a2 = m40.a(clsArr, parameterTypes);
                            float a3 = m40.a(clsArr, parameterTypes2);
                            if (a2 < a3) {
                                c2 = 65535;
                            } else if (a3 < a2) {
                                c2 = 1;
                            } else {
                                c2 = 0;
                            }
                            if (c2 >= 0) {
                            }
                        }
                        method2 = method3;
                    }
                }
                cls3 = cls3.getSuperclass();
                if (cls3 == null) {
                    break;
                }
                z = false;
            }
            if (method2 != null) {
                method2.setAccessible(true);
                hashMap.put(o, method2);
                return method2;
            }
            NoSuchMethodError noSuchMethodError = new NoSuchMethodError(o);
            hashMap.put(o, null);
            throw noSuchMethodError;
        }
    }

    public static Method k(Class cls, String str, Class... clsArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getName());
        sb.append('#');
        sb.append(str);
        String o = AbstractC1360kB.o(sb, b(clsArr), "#exact");
        HashMap hashMap = b;
        if (hashMap.containsKey(o)) {
            Method method = (Method) hashMap.get(o);
            if (method != null) {
                return method;
            }
            throw new NoSuchMethodError(o);
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            hashMap.put(o, declaredMethod);
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            hashMap.put(o, null);
            throw new NoSuchMethodError(o);
        }
    }

    public static Object l(Object obj, String str) {
        Object obj2;
        WeakHashMap weakHashMap = d;
        synchronized (weakHashMap) {
            HashMap hashMap = (HashMap) weakHashMap.get(obj);
            if (hashMap == null) {
                return null;
            }
            synchronized (hashMap) {
                obj2 = hashMap.get(str);
            }
            return obj2;
        }
    }

    public static int m(Object obj, String str) {
        try {
            return i(str, obj.getClass()).getInt(obj);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static long n(Object obj, String str) {
        try {
            return i(str, obj.getClass()).getLong(obj);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return 0l;
    }

    public static Object o(Object obj, String str) {
        try {
            return i(str, obj.getClass()).get(obj);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object p(String str, Class cls) {
        try {
            return i(str, cls).get(null);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object q(Class cls, Object... objArr) {
        try {
            return g(cls, objArr).newInstance(objArr);
        } catch (Throwable e) {
           e.printStackTrace();
        }
        return null;
    }

    public static void r(Class cls, Object... objArr) {
        if (objArr.length == 0 || !(objArr[objArr.length - 1] instanceof AbstractC0098Dr)) {
            throw new IllegalArgumentException("no callback defined");
        }
        Bridge2.d(h(cls, a(cls.getClassLoader(), objArr)), (AbstractC0098Dr) objArr[objArr.length - 1]);
    }

    public static void s(Class cls, String str, Object... objArr) {
        if (objArr.length == 0 || !(objArr[objArr.length - 1] instanceof AbstractC0098Dr)) {
            throw new IllegalArgumentException("no callback defined");
        }
        Bridge2.d(k(cls, str, a(cls.getClassLoader(), objArr)), (AbstractC0098Dr) objArr[objArr.length - 1]);
    }

    public static void t(String str, ClassLoader classLoader, String str2, Object... objArr) {
        if (objArr.length == 0 || !(objArr[objArr.length - 1] instanceof AbstractC0098Dr)) {
            throw new IllegalArgumentException("no callback defined");
        }
        Class e = e(classLoader, str);
        Bridge2.d(k(e, str2, a(e.getClassLoader(), objArr)), (AbstractC0098Dr) objArr[objArr.length - 1]);
    }

    public static void u(Object obj, String str) {
        WeakHashMap weakHashMap = d;
        synchronized (weakHashMap) {
            HashMap hashMap = (HashMap) weakHashMap.get(obj);
            if (hashMap != null) {
                synchronized (hashMap) {
                    hashMap.remove(str);
                }
            }
        }
    }

    public static void v(Object obj, Object obj2, String str) {
        HashMap hashMap;
        WeakHashMap weakHashMap = d;
        synchronized (weakHashMap) {
            hashMap = (HashMap) weakHashMap.get(obj);
            if (hashMap == null) {
                hashMap = new HashMap();
                weakHashMap.put(obj, hashMap);
            }
        }
        synchronized (hashMap) {
            hashMap.put(str, obj2);
        }
    }

    public static void w(Object obj, String str) {
        try {
            i(str, obj.getClass()).setBoolean(obj, true);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static void x(Object obj, String str, float f) {
        try {
            i(str, obj.getClass()).setFloat(obj, f);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static void y(int i, Object obj, String str) {
        try {
            i(str, obj.getClass()).setInt(obj, i);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static void z(long j, Object obj, String str) {
        try {
            i(str, obj.getClass()).setLong(obj, j);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

}
