package c.t.tp;

import java.util.Arrays;

public final class A4 {
    public volatile transient Object[] a = Bridge.a;

    public final void a(Object obj) {
        synchronized (this) {
            int i = 0;
            while (true) {
                if (i < this.a.length) {
                    if (obj.equals(this.a[i])) {
                        break;
                    } else {
                        i++;
                    }
                } else {
                    i = -1;
                    break;
                }
            }
            if (i < 0) {
                Object[] objArr = new Object[this.a.length + 1];
                    System.arraycopy(this.a, 0, objArr, 0, this.a.length);
                objArr[this.a.length] = obj;
                Arrays.sort(objArr);
                this.a = objArr;
            }
        }
    }
}

