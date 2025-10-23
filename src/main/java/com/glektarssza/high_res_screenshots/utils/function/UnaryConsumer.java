package com.glektarssza.high_res_screenshots.utils.function;

/**
 * A function that accepts one argument and produces a result.
 *
 * @param <T1> The type of the first argument.
 */
public interface UnaryConsumer<T> {
    /**
     * Invoke the function.
     *
     * @param arg The function argument.
     */
    public void invoke(T arg);
}
