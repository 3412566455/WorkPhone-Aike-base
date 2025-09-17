package c.t.tp;

import android.util.Log;

import java.util.Arrays;

public final class A4 {
    private static final String TAG = "MyBridgeHook";
    public volatile transient Object[] a = Bridge3.a;
    public Object[] getObjectArr(){
        return a;
    }

    public final void a(Object obj) {
        synchronized (this) {
            int i = 0;
            Log.d(TAG, "  XX A4准备while true");
            while (true) {
                if (i < this.a.length) {
                    if (obj.equals(this.a[i])) {
                        Log.d(TAG, "  XX A4准备while true break1");
                        break;
                    } else {
                        i++;
                    }
                } else {
                    i = -1;
                    Log.d(TAG, "  XX A4准备while true break2");
                    break;
                }
            }
            Log.d(TAG, "  XX A4中i=:"+i);
            if (i < 0) {
                Object[] objArr = new Object[this.a.length + 1];
                    System.arraycopy(this.a, 0, objArr, 0, this.a.length);
                objArr[this.a.length] = obj;
                Arrays.sort(objArr);
                this.a = objArr;
            }
            Log.d(TAG, "  XX Bridge.a 的size=:"+this.a.length);
        }
    }
}

