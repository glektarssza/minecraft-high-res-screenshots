package com.glektarssza.high_res_screenshots.utils.function;

/**
 * A function that accepts no arguments and produces a result.
 *
 * @param <R> The type of the result.
 */
public interface VoidFunction<R> {
    /**
     * Invoke the function.
     *
     * @return The function result.
     */
    public R invoke();
}
