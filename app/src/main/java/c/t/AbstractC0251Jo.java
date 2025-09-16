package c.t;

public abstract class AbstractC0251Jo extends K30 implements AbstractC0248Jl{
    public static void a(C0225Io io) {
        Object[] objArr = (Object[]) io.a;
        if (objArr != null) {
            for (Object obj : objArr) {
                try {
                    ((C1946t) ((AbstractC0248Jl) obj)).getClass();
                    C1946t.a(io);
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
            return;
        }
        throw new IllegalStateException("This object was not created for use with callAll");
    }

}
