package c.t.tp;

import android.util.Log;

public class MyTestClass {
    private static final String TAG = "MyBridgeHook";
    public void sayHello() {
        Log.d(TAG,"Hello from original version!");
    }
}