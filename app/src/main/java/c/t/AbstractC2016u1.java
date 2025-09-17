package c.t;

import android.content.Context;

import c.t.tp.Bridge2;

public class AbstractC2016u1 {
    public static void d() throws Throwable {
        if (Bridge2.f1442c) {
            Class class_ActivityThread = CP.e(ClassLoader.getSystemClassLoader(), "android.app.ActivityThread");
            CP.s(class_ActivityThread, "systemMain", new C0512Tq(13));
        }
        CP.s(Class.forName("android.app.ConfigurationController"), "updateLocaleListFromAppContext", Context.class, new P30());
    }
}
