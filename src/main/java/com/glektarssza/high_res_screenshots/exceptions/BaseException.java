package com.glektarssza.high_res_screenshots.exceptions;

/**
 * The base for all custom exceptions.
 */
public class BaseException extends Exception {
    /**
     * Create a new instance.
     */
    public BaseException() {
        this(null, null, false, false);
    }

    /**
     * Create a new instance.
     *
     * @param message The message to use to describe the cause of the new
     *        instance.
     */
    public BaseException(String message) {
        this(message, null, false, false);
    }

    /**
     * Create a new instance.
     *
     * @param cause The throwable that triggered the new instance to be created.
     */
    public BaseException(Throwable cause) {
        this(null, cause, false, false);
    }

    /**
     * Create a new instance.
     *
     * @param message The message to use to describe the cause of the new
     *        instance.
     * @param cause The throwable that triggered the new instance to be created.
     */
    public BaseException(String message, Throwable cause) {
        this(message, cause, false, false);
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
    protected BaseException(String message, Throwable cause,
        boolean enableSuppression,
        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
