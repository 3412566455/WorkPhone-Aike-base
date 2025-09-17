package c.t.tp;

import android.util.Log;

public class NewString implements Comparable{
    private static final String TAG = "MyBridgeHook";
    public int length(String str){
        Log.d(TAG, "新String length被替换成功！");
        return 0;
    }
    @Override
    public final int compareTo(Object obj) {
        Log.d(TAG, "NewString compareTo开始");
        NewString r10 = (NewString) obj;
        if (this == r10) {
            return 0;
        }
        r10.getClass();
        if (System.identityHashCode(this) < System.identityHashCode(r10)) {
            return -1;
        }
        return 1;
    }
}
