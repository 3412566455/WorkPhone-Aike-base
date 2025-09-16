package c.t;

import java.util.HashMap;

public class a40 {
    public static final HashMap a;
    public static final HashMap b = new HashMap();

    public static final HashMap f716c;
    public static final HashMap d;

    static {
        HashMap<Class, Class> hashMap = new HashMap();
        a = hashMap;
        hashMap.put(Boolean.TYPE, Boolean.class);
        hashMap.put(Byte.TYPE, Byte.class);
        hashMap.put(Character.TYPE, Character.class);
        hashMap.put(Short.TYPE, Short.class);
        hashMap.put(Integer.TYPE, Integer.class);
        hashMap.put(Long.TYPE, Long.class);
        hashMap.put(Double.TYPE, Double.class);
        hashMap.put(Float.TYPE, Float.class);
        Class cls = Void.TYPE;
        hashMap.put(cls, cls);
        for (Class cls2 : hashMap.keySet()) {
            Class cls3 = (Class) a.get(cls2);
            if (!cls2.equals(cls3)) {
                b.put(cls3, cls2);
            }
        }
        f716c = new HashMap();
        d = new HashMap();
        a("int", "I");
        a("boolean", "Z");
        a("float", "F");
        a("long", "J");
        a("short", "S");
        a("byte", "B");
        a("double", "D");
        a("char", "C");
    }

    public static void a(String str, String str2) {
        f716c.put(str, str2);
        d.put(str2, str);
    }

    public static Class b(ClassLoader p0,String p1) {
        int i;
        Class uClass = null;
        String str = "[";
        boolean b = false;
        try{
            HashMap c = f716c;
            uClass = (c.containsKey(p1))? Class.forName(str+c.get(p1), b, p0).getComponentType(): Class.forName(a40.e(p1), b, p0);
        }catch(ClassNotFoundException e0){
            if ((i = p1.lastIndexOf(46)) != -1) {
                uClass = a40.b(p0, p1.substring(0, i)+'$'+p1.substring((i + 1)));
            }
        }catch(Throwable e0){
            return null;
        }
        return uClass;
    }

    public static boolean c(Class cls, Class cls2, boolean z) {
        if (cls2 == null) {
            return false;
        }
        if (cls == null) {
            return !cls2.isPrimitive();
        }
        if (z) {
            if (cls.isPrimitive() && !cls2.isPrimitive()) {
                if (cls.isPrimitive()) {
                    cls = (Class) a.get(cls);
                }
                if (cls == null) {
                    return false;
                }
            }
            if (cls2.isPrimitive() && !cls.isPrimitive() && (cls = (Class) b.get(cls)) == null) {
                return false;
            }
        }
        if (!cls.equals(cls2)) {
            if (!cls.isPrimitive()) {
                return cls2.isAssignableFrom(cls);
            }
            if (!cls2.isPrimitive()) {
                return false;
            }
            Class cls3 = Integer.TYPE;
            if (!cls3.equals(cls)) {
                Class cls4 = Long.TYPE;
                if (cls4.equals(cls)) {
                    if (!Float.TYPE.equals(cls2) && !Double.TYPE.equals(cls2)) {
                        return false;
                    }
                } else if (Boolean.TYPE.equals(cls) || Double.TYPE.equals(cls)) {
                    return false;
                } else {
                    Class cls5 = Float.TYPE;
                    if (cls5.equals(cls)) {
                        return Double.TYPE.equals(cls2);
                    }
                    if (Character.TYPE.equals(cls)) {
                        if (!cls3.equals(cls2) && !cls4.equals(cls2) && !cls5.equals(cls2) && !Double.TYPE.equals(cls2)) {
                            return false;
                        }
                    } else if (Short.TYPE.equals(cls)) {
                        if (!cls3.equals(cls2) && !cls4.equals(cls2) && !cls5.equals(cls2) && !Double.TYPE.equals(cls2)) {
                            return false;
                        }
                    } else if (!Byte.TYPE.equals(cls)) {
                        return false;
                    } else {
                        if (!Short.TYPE.equals(cls2) && !cls3.equals(cls2) && !cls4.equals(cls2) && !cls5.equals(cls2) && !Double.TYPE.equals(cls2)) {
                            return false;
                        }
                    }
                }
            } else if (!Long.TYPE.equals(cls2) && !Float.TYPE.equals(cls2) && !Double.TYPE.equals(cls2)) {
                return false;
            }
        }
        return true;
    }

    public static final Class[] f493c = new Class[0];
    public static boolean d(Class[] clsArr, Class[] clsArr2) {
        if ((clsArr2 != null || clsArr.length <= 0) && (clsArr2 == null || clsArr.length == clsArr2.length)) {
            if (clsArr2 == null) {
                clsArr2 = f493c;
            }
            for (int i = 0; i < clsArr.length; i++) {
                if (c(clsArr[i], clsArr2[i], true)) {
                }
            }
            return true;
        }
        return false;
    }
    public static String e(String str) {
        int i = 0;
        if (!(str == null || str.length() == 0)) {
            int length = str.length();
            char[] cArr = new char[length];
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (!Character.isWhitespace(str.charAt(i3))) {
                    cArr[i2] = str.charAt(i3);
                    i2++;
                }
            }
            if (i2 != length) {
                str = new String(cArr, 0, i2);
            }
        }
        if (!str.endsWith("[]")) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        while (str.endsWith("[]")) {
            str = str.substring(0, str.length() - 2);
            sb.append("[");
        }
        String str2 = (String) f716c.get(str);
        if (str2 != null) {
            sb.append(str2);
        } else {
            sb.append("L");
            sb.append(str);
            sb.append(";");
        }
        return sb.toString();
    }
}
