package c.t;

public class K30 implements Comparable{
    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        K30 k30 = (K30) obj;
        if (this == k30) {
            return 0;
        }
        k30.getClass();
        if (System.identityHashCode(this) < System.identityHashCode(k30)) {
            return -1;
        }
        return 1;
    }

}
