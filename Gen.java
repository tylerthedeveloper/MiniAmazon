/**
 * Generic class Gen
 * @param <T> the type of the value being generalized
 */
public class Gen<T>
{
    // T stands for "Type"
    private T t;

    public void set(T t) { this.t = t; }
    public T get() { return t; }
}