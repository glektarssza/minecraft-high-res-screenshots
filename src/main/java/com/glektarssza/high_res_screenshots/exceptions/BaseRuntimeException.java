package com.glektarssza.high_res_screenshots.exceptions;

/**
 * The base for all custom exceptions.
 */
public class BaseRuntimeException extends RuntimeException {
    /**
     * Create a new instance.
     */
    public BaseRuntimeException() {
        super();
    }

    /**
     * Create a new instance.
     *
     * @param message The message to use to describe the cause of the new
     *        instance.
     */
    public BaseRuntimeException(String message) {
        super(message);
    }

    /**
     * Create a new instance.
     *
     * @param cause The throwable that triggered the new instance to be created.
     */
    public BaseRuntimeException(Throwable cause) {
        super(cause);
    }

    /**
     * Create a new instance.
     *
     * @param message The message to use to describe the cause of the new
     *        instance.
     * @param cause The throwable that triggered the new instance to be created.
     */
    public BaseRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Create a new instance.
     *
     * @param message The message to use to describe the cause of the new
     *        instance.
     * @param cause The throwable that triggered the new instance to be created.
     * @param enableSuppression Whether or not to suppress the newly created
     *        instance.
     * @param writableStackTrace Whether or not the stack trace of the newly
     *        created instance should be writable.
     */
    protected BaseRuntimeException(String message, Throwable cause,
        boolean enableSuppression,
        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
