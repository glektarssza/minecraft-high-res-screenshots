package com.glektarssza.high_res_screenshots.exceptions.io;

import java.io.File;
import java.nio.file.Path;

import com.glektarssza.high_res_screenshots.exceptions.BaseRuntimeException;

/**
 * The base for all custom I/O-related exceptions.
 */
public class IOException extends BaseRuntimeException {
    /**
     * The path which was being operated on when the I/O exception occurred.
     */
    public final Path path;

    /**
     * Create a new instance.
     */
    public IOException() {
        this(null, null, null, false, false);
    }

    /**
     * Create a new instance.
     *
     * @param message The message to use to describe the cause of the new
     *        instance.
     */
    public IOException(String message) {
        this(null, message, null, false, false);
    }

    /**
     * Create a new ins
     *
     * @param message The message to use to describe the cause of the new
     *        instance.
     * @param cause The throwable that triggered the new instance to be created.
     */
    public IOException(Throwable cause) {
        this(null, null, cause, false, false);
    }

    /**
     * Create a new instance.
     *
     * @param path The path which was being operated on when the new instance
     *        was triggered.
     */
    public IOException(Path path) {
        this(path, null, null, false, false);
    }

    /**
     * Create a new instance.
     *
     * @param path The path which was being operated on when the new instance
     *        was triggered.
     */
    public IOException(File path) {
        this(path.toPath(), null, null, false, false);
    }

    /**
     * Create a new ins
     *
     * @param message The message to use to describe the cause of the new
     *        instance.
     * @param cause The throwable that triggered the new instance to be created.
     */
    public IOException(String message, Throwable cause) {
        this(null, message, cause, false, false);
    }

    /**
     * Create a new instance.
     *
     * @param path The path which was being operated on when the new instance
     *        was triggered.
     * @param message The message to use to describe the cause of the new
     *        instance.
     */
    public IOException(Path path, String message) {
        this(path, message, null, false, false);
    }

    /**
     * Create a new instance.
     *
     * @param path The path which was being operated on when the new instance
     *        was triggered.
     * @param message The message to use to describe the cause of the new
     *        instance.
     */
    public IOException(File path, String message) {
        this(path.toPath(), message, null, false, false);
    }

    /**
     * Create a new instance.
     *
     * @param path The path which was being operated on when the new instance
     *        was triggered.
     * @param cause The throwable that triggered the new instance to be created.
     *
     */
    public IOException(Path path, Throwable cause) {
        this(path, null, cause, false, false);
    }

    /**
     * Create a new instance.
     *
     * @param path The path which was being operated on when the new instance
     *        was triggered.
     * @param cause The throwable that triggered the new instance to be created.
     */
    public IOException(File path, Throwable cause) {
        this(path.toPath(), null, cause, false, false);
    }

    /**
     * Create a new instance.
     *
     * @param path The path which was being operated on when the new instance
     *        was triggered.
     * @param message The message to use to describe the cause of the new
     *        instance.
     * @param cause The throwable that triggered the new instance to be created.
     */
    public IOException(Path path, String message, Throwable cause) {
        this(path, message, cause, false, false);
    }

    /**
     * Create a new instance.
     *
     * @param path The path which was being operated on when the new instance
     *        was triggered.
     * @param message The message to use to describe the cause of the new
     *        instance.
     * @param cause The throwable that triggered the new instance to be created.
     */
    public IOException(File path, String message, Throwable cause) {
        this(path.toPath(), message, cause, false, false);
    }

    /**
     * Create a new instance.
     *
     * @param path The path which was being operated on when the new instance
     *        was triggered.
     * @param message The message to use to describe the cause of the new
     *        instance.
     * @param cause The throwable that triggered the new instance to be created.
     * @param enableSuppression Whether or not to suppress the newly created
     *        instance.
     * @param writableStackTrace Whether or not the stack trace of the newly
     *        created instance should be writable.
     */
    protected IOException(Path path, String message, Throwable cause,
        boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.path = path;
    }
}
