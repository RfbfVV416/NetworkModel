package NetworkModel;

@FunctionalInterface
public interface WeightFunction<T, U, V, R> {
    public R apply(T t, U u, V v);
}

