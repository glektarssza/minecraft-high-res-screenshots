package com.glektarssza.high_res_screenshots.exceptions.collections;

import com.glektarssza.high_res_screenshots.exceptions.BaseException;

/**
 * An exception that is triggered when a key cannot be found in a collection.
 */
public class KeyNotFoundException extends BaseException {
    /**
     * The key which could not be found.
     */
    public final String key;

    /**
     * Create a new instance.
     *
     * @param key The key could not be found.
     */
    public KeyNotFoundException(String key) {
        this(key, null, null, false, false);
    }

    /**
     * Create a new instance.
     *
     * @param cause The throwable that triggered the new instance to be created.
     */
    public KeyNotFoundException(Throwable cause) {
        this(null, null, cause, false, false);
    }

    /**
     * Create a new instance.
     *
     * @param key The key could not be found.
     * @param message The message to use to describe the cause of the new
     *        instance.
     */
    public KeyNotFoundException(String key, String message) {
        this(key, message, null, false, false);
    }

    /**
     * Create a new instance.
     *
     * @param key The key could not be found.
     * @param cause The throwable that triggered the new instance to be created.
     */
    public KeyNotFoundException(String key, Throwable cause) {
        this(key, null, cause, false, false);
    }

    /**
     * Create a new instance.
     *
     * @param key The key could not be found.
     * @param message The message to use to describe the cause of the new
     *        instance.
     * @param cause The throwable that triggered the new instance to be created.
     */
    public KeyNotFoundException(String key, String message, Throwable cause) {
        this(key, message, cause, false, false);
    }

    /**
     * Create a new instance.
     *
     * @param key The key could not be found.
     * @param message The message to use to describe the cause of the new
     *        instance.
     * @param cause The throwable that triggered the new instance to be created.
     * @param enableSuppression Whether or not to suppress the newly created
     *        instance.
     * @param writableStackTrace Whether or not the stack trace of the newly
     *        created instance should be writable.
     */
    protected KeyNotFoundException(String key, String message, Throwable cause,
        boolean enableSuppression,
        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.key = key;
    }
}
