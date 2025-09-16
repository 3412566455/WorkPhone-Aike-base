package c.t;

import java.io.PrintStream;
import java.util.HashMap;

public class m40 {
    public static final Class[] a = {Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE};

    public static float a(Class[] clsArr, Class[] clsArr2) {
        float f;
        boolean z;
        float f2 = 0.0f;
        for (int i = 0; i < clsArr.length; i++) {
            Class cls = clsArr[i];
            Class cls2 = clsArr2[i];
            if (cls2.isPrimitive()) {
                if (!cls.isPrimitive()) {
                    cls = (Class) a40.b.get(cls);
                    f = 0.1f;
                } else {
                    f = 0.0f;
                }
                int i2 = 0;
                while (cls != cls2) {
                    Class[] clsArr3 = a;
                    if (i2 < 7) {
                        if (cls == clsArr3[i2]) {
                            f += 0.1f;
                            if (i2 < 6) {
                                cls = clsArr3[i2 + 1];
                            }
                        }
                        i2++;
                    }
                }
            } else {
                f = 0.0f;
                while (true) {
                    if (cls == null || cls2.equals(cls)) {
                        break;
                    }
                    if (cls2.isInterface()) {
                        HashMap hashMap = a40.a;
                        if (c(b) >= c(6)) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (a40.c(cls, cls2, z)) {
                            f += 0.25f;
                            break;
                        }
                    }
                    f += 1.0f;
                    cls = cls.getSuperclass();
                }
                if (cls == null) {
                    f += 1.5f;
                }
            }
            f2 += f;
        }
        return f2;
    }

    private static int b = 0;
    static {
        String d2 = d("java.specification.version");
        b = "0.9".equals(d2) ? 1 : "1.1".equals(d2) ? 2 : "1.2".equals(d2) ? 3 : "1.3".equals(d2) ? 4 : "1.4".equals(d2) ? 5 : "1.5".equals(d2) ? 6 : "1.6".equals(d2) ? 7 : "1.7".equals(d2) ? 8 : "1.8".equals(d2) ? 9 : 0;
    }

    public static String d(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            PrintStream printStream = System.err;
            printStream.println("Caught a SecurityException reading the system property '" + str + "'; the SystemUtils property value will default to null.");
            return null;
        }
    }


    public static float c(int i) {
        if (i != 1) {
            if (i == 2) {
                return 1.1f;
            }
            if (i == 3) {
                return 1.2f;
            }
            if (i == 4) {
                return 1.3f;
            }
            if (i == 5) {
                return 1.4f;
            }
            if (i != 6) {
                if (i == 7) {
                    return 1.6f;
                }
                if (i == 8) {
                    return 1.7f;
                }
                if (i == 9) {
                    return 1.8f;
                }
                throw null;
            }
        }
        return 1.5f;
    }


}
