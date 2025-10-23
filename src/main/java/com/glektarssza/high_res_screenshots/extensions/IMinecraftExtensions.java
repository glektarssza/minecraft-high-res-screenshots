package com.glektarssza.high_res_screenshots.extensions;

import net.minecraft.client.shader.Framebuffer;

/**
 * A set of extensions for the {@code Minecraft} class.
 */
public interface IMinecraftExtensions {
    /**
     * Set the framebuffer to be used for rendering.
     *
     * If the current framebuffer is the base Minecraft framebuffer it will be
     * stored so it can be reset later via a call to {@link #resetFramebuffer}.
     *
     * The framebuffer will not be bound for usage immediately.
     *
     * @param framebuffer The framebuffer to use for rendering.
     */
    public default void setFramebuffer(Framebuffer framebuffer) {
        setFramebuffer(framebuffer, false);
    }

    /**
     * Set the framebuffer to be used for rendering.
     *
     * If the current framebuffer is the base Minecraft framebuffer it will be
     * stored so it can be reset later via a call to {@link #resetFramebuffer}.
     *
     * @param framebuffer The framebuffer to use for rendering.
     * @param bindImmediately Whether to immediately bind the framebuffer for
     *        usage.
     */
    public default void setFramebuffer(Framebuffer framebuffer,
        boolean bindImmediately) {
        setFramebuffer(framebuffer, bindImmediately, true);
    }

    /**
     * Set the framebuffer to be used for rendering.
     *
     * If the current framebuffer is the base Minecraft framebuffer it will be
     * stored so it can be reset later via a call to {@link #resetFramebuffer}.
     *
     * @param framebuffer The framebuffer to use for rendering.
     * @param bindImmediately Whether to immediately bind the framebuffer for
     *        usage.
     * @param resizeViewport Whether to resize the OpenGL viewport when the
     *        framebuffer is bound.
     */
    public void setFramebuffer(Framebuffer framebuffer, boolean bindImmediately,
        boolean resizeViewport);

    /**
     * Reset the framebuffer back to the original Minecraft framebuffer.
     */
    public default void restoreFramebuffer() {
        restoreFramebuffer(true);
    }

    /**
     * Reset the framebuffer back to the original Minecraft framebuffer.
     *
     * @param bindImmediately Whether to immediately bind the framebuffer for
     *        usage.
     */
    public default void restoreFramebuffer(boolean bindImmediately) {
        restoreFramebuffer(bindImmediately, true);
    }

    /**
     * Reset the framebuffer back to the original Minecraft framebuffer.
     *
     * @param bindImmediately Whether to immediately bind the framebuffer for
     *        usage.
     * @param resizeViewport Whether to resize the OpenGL viewport when the
     *        framebuffer is bound.
     */
    public void restoreFramebuffer(boolean bindImmediately,
        boolean resizeViewport);
}
