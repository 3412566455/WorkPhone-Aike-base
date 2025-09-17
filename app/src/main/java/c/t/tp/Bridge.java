package c.t.tp;

import android.util.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Bridge {
    // 日志标签
    private static final String TAG = "MyBridgeHook";

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

        // 打印第三个参数：Object obj2
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

        Log.d(TAG, "  XX当前a长度:"+a.length);
        if(a.length > 0){
            try {
                Object a_obj = a[0];
                Method method = (Method) member;
                String methodName = method.getName();
                Method replaceMethod = a_obj.getClass().getDeclaredMethod(methodName);
                replaceMethod.invoke(a_obj);
            } catch (Throwable e) {
                Log.d(TAG, "    Invoke ERROR: ", e);
            }
        }

        return null;
    }

    public static native Object invokeNative(Member member, int i, Object obj, Object[] objArr);

    public static void main(String[] strArr, int i) {
        // 程序入口日志
        Log.d(TAG, "===== 程序开始执行 =====");
        Log.d(TAG, "当前执行方法：main，参数：strArr长度=" + (strArr != null ? strArr.length : 0) + ", i=" + i);

        // 输出Hook开始日志
        Log.d(TAG, "Hook NewString开始！准备通过反射获取String类的方法");

        // 获取String类的Class对象
        Log.d(TAG, "步骤1：获取String类的Class对象");
        Class<MyTestClass> stringClass = MyTestClass.class;
        Log.d(TAG, "成功获取String类的Class对象，类名：" + stringClass.getName());

        // 声明Method变量并初始化
        Method lengthMethod = null;
        Log.d(TAG, "步骤2：声明lengthMethod变量，初始值为null");

        // 反射获取String类的length()方法
        Log.d(TAG, "步骤3：开始通过反射获取String类的sayHello()方法");
        try {
            lengthMethod = stringClass.getMethod("sayHello");
            if (lengthMethod != null) {
                Log.d(TAG, "成功获取sayHello()方法，方法签名：" + lengthMethod);
                Log.d(TAG, "方法所在类：" + lengthMethod.getDeclaringClass().getName());
                Log.d(TAG, "方法返回值类型：" + lengthMethod.getReturnType().getName());
            } else {
                Log.d(TAG, "获取length()方法失败，返回null");
            }
        } catch (NoSuchMethodException e) {
            Log.d(TAG, "Hook NewString错误！获取length()方法时抛出异常：" + e.getMessage());
            Log.d(TAG, "异常堆栈信息：", e); // 打印完整堆栈
            throw new RuntimeException(e);
        }

        // 创建A4实例
        Log.d(TAG, "步骤4：创建A4类实例");
        A4 a4 = new A4();
        Log.d(TAG, "A4实例创建成功，对象地址：" + a4);

        // 创建NewString实例
        Log.d(TAG, "步骤5：创建NewString类实例");
        MyTestClass2 newString = new MyTestClass2();
        Log.d(TAG, "NewString实例创建成功，对象地址：" + newString);

        // 调用A4的a方法，传入NewString实例
        Log.d(TAG, "步骤6：调用a4.a(newString)方法");
        a4.a(newString);
        Log.d(TAG, "a4.a()方法调用完成");

        // 调用native代理方法
        Log.d(TAG, "步骤7：调用proxyMethodNative原生方法，参数：");
        Log.d(TAG, "  - 目标方法：" + lengthMethod);
        Log.d(TAG, "  - 声明类：" + lengthMethod.getDeclaringClass().getName());
        Log.d(TAG, "  - 整数参数：0");
        Log.d(TAG, "  - A4实例：" + a4);

        try {
            proxyMethodNative(lengthMethod, lengthMethod.getDeclaringClass(), 0, a4);
            Log.d(TAG,"方法替换成功！");
        } catch (NullPointerException e) {
            Log.d(TAG,"失败：传入的Method对象为null。");
        } catch (IllegalArgumentException e) {
            Log.d(TAG,"失败：目标方法不合法，不能被替换。");
        } catch (Exception e) {
            Log.d(TAG,"发生了未知的错误。");
        }
        MyTestClass myTestClass = new MyTestClass();
        Log.d(TAG,"准备调用sayHello");
        myTestClass.sayHello();
        Log.d(TAG,"调用完毕sayHello");
        // 输出Hook成功日志
        Log.d(TAG, "Hook NewString成功！所有步骤执行完毕");
        Log.d(TAG, "===== 程序执行结束 =====");
    }


    private static native synchronized void proxyMethodNative(Member member, Class<?> cls, int i, Object obj);
}
