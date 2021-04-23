package NetworkModel;

@FunctionalInterface
public interface WeightFunction<T, U, R> {
    public R apply(T t, U u);
}

