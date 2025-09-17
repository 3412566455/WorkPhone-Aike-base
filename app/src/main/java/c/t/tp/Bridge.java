package c.t.tp;

import android.content.Context;
import android.util.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

import c.t.AbstractC0098Dr;
import c.t.AbstractC0248Jl;
import c.t.AbstractC2016u1;
import c.t.N4;

public class Bridge {
    // 日志标签
    public static final String TAG = "MyBridgeHook";

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

    public static Object d(Member member, AbstractC0098Dr dr) {
        Log.d(TAG, "有人调用 (Bridge.d has been called)");
        return null;
    }

    public static native void doCommandNative(int i, Object obj);

    public static boolean start=true;
    public static Object handleRuntimeEvent(Member member, Object obj, Object obj2, Object[] objArr) throws Throwable {
        Log.d(TAG, "有人调用 (Bridge.handleRuntimeEvent has been called)");

        // 打印第一个参数：Member对象（可能是Method、Field或Constructor）
        if (member == null) {
            Log.d(TAG, "参数1 (member): null");
        } else {
            String memberType = "未知类型";
            if (member instanceof Method) {
                memberType = "Method";
            } else if (member instanceof Field) {
                memberType = "Field";
            } else if (member instanceof Constructor) {
                memberType = "Constructor";
            }
            Log.d(TAG, "参数1 (member):");
            Log.d(TAG, "  类型: " + memberType);
            Log.d(TAG, "  声明类: " + member.getDeclaringClass().getName());
            Log.d(TAG, "  名称: " + member.getName());
            Log.d(TAG, "  修饰符: " + member.getModifiers());
        }

        // 打印第二个参数：Object obj
        if (obj == null) {
            Log.d(TAG, "参数2 (obj): null");
        } else {
            Log.d(TAG, "参数2 (obj):");
            Log.d(TAG, "  类型: " + obj.getClass().getName());
            Log.d(TAG, "  内容: " + obj.toString());
            Log.d(TAG, "  哈希码: " + obj.hashCode());
        }


        if (obj2 == null) {
            Log.d(TAG, "参数3 (obj2): null");
        } else {
            Log.d(TAG, "参数3 (obj2):");
            Log.d(TAG, "  类型: " + obj2.getClass().getName());
            Log.d(TAG, "  内容: " + obj2.toString());
            Log.d(TAG, "  哈希码: " + obj2.hashCode());
        }

        // 打印第四个参数：Object[] objArr（数组）
        if (objArr == null) {
            Log.d(TAG, "参数4 (objArr): null");
        } else {
            Log.d(TAG, "参数4 (objArr):");
            Log.d(TAG, "  数组长度: " + objArr.length);
            for (int i = 0; i < objArr.length; i++) {
                Object item = objArr[i];
                if (item == null) {
                    Log.d(TAG, "  索引[" + i + "]: null");
                } else {
                    Log.d(TAG, "  索引[" + i + "]:");
                    Log.d(TAG, "    类型: " + item.getClass().getName());
                    Log.d(TAG, "    内容: " + item.toString());
                    Log.d(TAG, "    哈希码: " + item.hashCode());
                }
            }
        }
//        int i = android.os.Process.myPid();

        String processName = android.os.Process.myProcessName();
        Log.e(TAG, "当前进程名："+processName);
        if (start) {
            Log.d(TAG, "检测到system_server进程，准备执行hook操作");
            Class<?> configurationController = null;
            try {
                configurationController = Class.forName("android.app.ConfigurationController");
                Log.d(TAG, "成功加载ConfigurationController类");

                Log.d(TAG, "成功加载ConfigurationController类: " + configurationController.getName());
            } catch (ClassNotFoundException e) {
                Log.e(TAG, "加载ConfigurationController类失败：类不存在", e);
                Log.e(TAG, "可能原因：系统版本不兼容或类名已变更");

            } catch (SecurityException e) {
                Log.e(TAG, "加载ConfigurationController类失败：权限不足", e);
                Log.e(TAG, "可能原因：应用缺少系统权限或处于沙箱环境中");

            } catch (Exception e) {
                Log.e(TAG, "加载ConfigurationController类时发生未知错误", e);

            }
            A4 a4 = null;
            try {
                // 初始化相关对象
                a4 = new A4();
                MyTestClass myTestClass = new MyTestClass();
                a4.a(myTestClass);
                Log.d(TAG, "初始化A4和MyTestClass对象成功");
            } catch (Exception e) {
                Log.e(TAG, "初始化A4或MyTestClass对象失败", e);
                Log.e(TAG, "可能原因：构造函数抛出异常或a()方法执行失败");

            }

            Log.d(TAG, "准备hook Context updateLocaleListFromAppContext方法");
            try {

                Method targetMethod = configurationController.getDeclaredMethod("updateLocaleListFromAppContext", Context.class);
                if (targetMethod == null) {
                    Log.e(TAG, "获取目标方法失败：返回的Method对象为null");
                }

                // 获取声明类
                Class<?> declaringClass = configurationController.getDeclaringClass();
                if (declaringClass == null) {
                    Log.e(TAG, "获取声明类失败：返回的Class对象为"+declaringClass);
                }

                // 执行方法替换
                proxyMethodNative(targetMethod, declaringClass, 0, a4);
                Log.d(TAG, "方法替换成功！目标方法：" + targetMethod.getName());
            } catch (NoSuchMethodException e) {
                Log.e(TAG, "找不到updateLocaleListFromAppContext方法", e);
                Log.e(TAG, "可能原因：方法名拼写错误、参数列表不匹配或方法已被移除");
            } catch (NullPointerException e) {
                Log.e(TAG, "失败：传入的Method对象为null", e);
            } catch (IllegalArgumentException e) {
                Log.e(TAG, "失败：目标方法不合法，不能被替换", e);
                Log.e(TAG, "可能原因：方法是final/static/私有方法或参数类型不匹配");
            } catch (Exception e) {
                Log.e(TAG, "发生了未知的错误", e);
                Log.e(TAG, "错误类型：" + e.getClass().getName());
                Log.e(TAG, "错误信息：" + e.getMessage());
            }
            Log.d(TAG, "hook操作结束 Context updateLocaleListFromAppContext");
            start=false;
        }



        Object[] objArr2 =  ((A4) obj).a;
        int length = objArr2.length;
        boolean z = true;
        if (length == 0) {
            return invokeNative(member, 1, obj2, objArr);
        }
        Log.d(TAG, "before returnObject: ");
        Object returnObject = invokeNative(member, 1, obj2, objArr);
        Log.d(TAG, "Context returnObject: " + returnObject);
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader != null) {
            Log.d(TAG, "Context ClassLoader: " + contextClassLoader);
            Log.d(TAG, "Parent ClassLoader: " + contextClassLoader.getParent());
        } else {
            Log.d(TAG, "Context ClassLoader is null");
        }
        return returnObject;



    }

    public static native Object invokeNative(Member member, int i, Object obj, Object[] objArr);

    public static void main(String[] strArr, int i) {
        // 程序入口日志
        Log.d(TAG, "===== 程序开始执行 =====");
        Log.d(TAG, "当前执行方法：main，参数：strArr长度=" + (strArr != null ? strArr.length : 0) + ", i=" + i);

        // 输出Hook开始日志
        Log.d(TAG, "Hook开始！准备通过反射获取ActivityThread类的方法");

        // 获取ActivityThread类的Class对象
        Log.d(TAG, "步骤1：获取ActivityThread类的Class对象");
        Class<?> activityThreadClass = null;
        Class<?> configurationController = null;
        try {
            activityThreadClass = Class.forName("android.app.ActivityThread");
            configurationController = Class.forName("android.app.ConfigurationController");
        } catch (ClassNotFoundException e) {
            Log.d(TAG,"ActivityThread获取失败");
            throw new RuntimeException(e);
        }
        Log.d(TAG, "成功获取ActivityThread类的Class对象，类名：" + activityThreadClass.getName());

        // 声明Method变量并初始化
        Method systemMainMethod = null;
        Method updateLocaleListFromAppContext = null;
        Log.d(TAG, "步骤2：声明systemMainMethod变量，初始值为null");

        // 反射获取ActivityThread类的systemMain()方法
        Log.d(TAG, "步骤3：开始通过反射获取ActivityThread类的systemMain()方法");
        try {
            // systemMain()是无参静态方法
            systemMainMethod = activityThreadClass.getMethod("systemMain");
            if (systemMainMethod != null) {
                Log.d(TAG, "成功获取systemMain()方法，方法签名：" + systemMainMethod);
                Log.d(TAG, "方法所在类：" + systemMainMethod.getDeclaringClass().getName());
                Log.d(TAG, "方法返回值类型：" + systemMainMethod.getReturnType().getName());
            } else {
                Log.d(TAG, "获取systemMain()方法失败，返回null");
            }
        } catch (NoSuchMethodException e) {
            Log.d(TAG, "Hook错误！获取systemMain()方法时抛出异常：" + e.getMessage());
            Log.d(TAG, "异常堆栈信息：", e); // 打印完整堆栈
            throw new RuntimeException(e);
        }

        // 创建A4实例
        Log.d(TAG, "步骤4：创建A4类实例");
        A4 a4 = new A4();
        Log.d(TAG, "A4实例创建成功，对象地址：" + a4);

        // 调用A4的a方法，传入系统上下文实例
        Log.d(TAG, "步骤6：调用a4.a(systemContext)方法");
        MyTestClass myTestClass = new MyTestClass();
        a4.a(myTestClass);
        Log.d(TAG, "a4.a()方法调用完成");
        Log.d(TAG, "步骤7：调用proxyMethodNative原生方法，参数：");
        Log.d(TAG, "  - 目标方法：" + systemMainMethod);
        Log.d(TAG, "  - 声明类：" + systemMainMethod.getDeclaringClass().getName());
        Log.d(TAG, "  - 整数参数：0");
        Log.d(TAG, "  - A4实例：" + a4);

        try {
            proxyMethodNative(systemMainMethod, systemMainMethod.getDeclaringClass(), 0, a4);

            Log.d(TAG,"方法替换成功！");
        } catch (NullPointerException e) {
            Log.d(TAG,"失败：传入的Method对象为null。");
        } catch (IllegalArgumentException e) {
            Log.d(TAG,"失败：目标方法不合法，不能被替换。");
        } catch (Exception e) {
            Log.d(TAG,"发生了未知的错误。");
        }

//        try {
//            Object newInstance = AbstractC2016u1.class.getClassLoader().loadClass("c.t.t").newInstance();
//            if (newInstance instanceof AbstractC0248Jl) {
//                Log.e(TAG, "33333333333333333333");
//                AbstractC0248Jl jl = (AbstractC0248Jl) newInstance;
//                synchronized (a4) {
//                    Log.e(TAG, "4444444444444444444444");
//                    a4.a(jl);
//                    Log.e(TAG, "5555555555555555555555");
//                }
//            }
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        } catch (InstantiationException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
        // 输出Hook成功日志
        Log.d(TAG, "Hook成功！所有步骤执行完毕");
        Log.d(TAG, "===== 程序执行结束 =====");
    }


    private static native synchronized void proxyMethodNative(Member member, Class<?> cls, int i, Object obj);
}
