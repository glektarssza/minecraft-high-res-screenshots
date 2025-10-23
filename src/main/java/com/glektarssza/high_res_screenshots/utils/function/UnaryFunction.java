package com.glektarssza.high_res_screenshots.utils.function;

/**
 * A function that accepts one argument and produces a result.
 *
 * @param <T> The type of the argument.
 * @param <R> The type of the result.
 */
public interface UnaryFunction<T, R> {
    /**
     * Invoke the function.
     *
     * @param arg The function argument.
     *
     * @return The function result.
     */
    public R invoke(T arg);
}
