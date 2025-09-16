package c.t;

import android.util.Log;

public class C0512Tq extends AbstractC0098Dr{
    public static int b;
    public final /* synthetic */ int a;


    public /* synthetic */ C0512Tq(int i) {
        this.a = i;
    }

    public static void c(ClassLoader classLoader) throws Throwable{
        Class<?> class1 = classLoader.loadClass("com.tencent.wcdb.database.SQLiteCipherSpec");
        Class<?> class2 = classLoader.loadClass("com.tencent.wcdb.database.SQLiteDatabase$CursorFactory");
        Class class3 = Integer.TYPE;
        Class<?> class4 = classLoader.loadClass("com.tencent.wcdb.DatabaseErrorHandler");
        CP.t("com.tencent.wcdb.database.SQLiteDatabase", classLoader, "openDatabase",
                String.class, byte[].class, class1, class2, class3, class4, class3, new C0512Tq(10));
    }

    @Override
    public void a(C0072Cr cr) {
        Log.i("hookStudy", "艾克注入成功");
    }

    @Override
    public void b(C0072Cr cr) {

    }
}
