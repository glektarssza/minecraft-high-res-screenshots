package com.glektarssza.high_res_screenshots.utils.function;

/**
 * A function that accepts four arguments and produces a result.
 *
 * @param <T1> The type of the first argument.
 * @param <T2> The type of the second argument.
 * @param <T3> The type of the third argument.
 * @param <T4> The type of the fourth argument.
 * @param <R> The type of the result.
 */
public interface QuaternaryFunction<T1, T2, T3, T4, R> {
    /**
     * Invoke the function.
     *
     * @param arg1 The first function argument.
     * @param arg2 The second function argument.
     * @param arg3 The third function argument.
     * @param arg4 The fourth function argument.
     *
     * @return The function result.
     */
    public R invoke(T1 arg1, T2 arg2, T3 arg3, T4 arg4);
}
