package c.t;

import android.content.Context;
import android.os.Bundle;

import aike.AikeCallback;
import c.t.tp.Bridge2;

public class AbstractC2016u1 {
    public static void test(ClassLoader classLoader){
        Object[] objArray1 = new Object[]{Bundle.class, new AikeCallback(classLoader, 1)};
        CP.t("com.tencent.mm.ui.LauncherUI", classLoader, "onCreate", objArray1);
    }
}
