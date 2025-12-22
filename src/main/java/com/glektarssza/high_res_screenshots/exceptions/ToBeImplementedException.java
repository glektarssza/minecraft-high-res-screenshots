package com.glektarssza.high_res_screenshots.exceptions;

/**
 * An exception that is thrown when functionality is still to be implemented.
 */
public class ToBeImplementedException extends BaseRuntimeException {
    /**
     * Create a new instance.
     */
    public ToBeImplementedException() {
        this("Functionality to be implemented", null, false, false);
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
    protected ToBeImplementedException(String message, Throwable cause,
        boolean enableSuppression,
        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
