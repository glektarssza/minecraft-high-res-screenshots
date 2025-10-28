package com.glektarssza.high_res_screenshots.mixins.early.vanilla;

import javax.annotation.Nullable;

import net.minecraft.client.Minecraft;
import net.minecraft.client.shader.Framebuffer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

import com.glektarssza.high_res_screenshots.extensions.IMinecraftExtensions;

/**
 * A mixin for the {@code Minecraft} class.
 */
@Mixin(Minecraft.class)
public class MinecraftMixin implements IMinecraftExtensions {
    /**
     * The framebuffer currently in use.
     */
    @Shadow
    private Framebuffer framebufferMc;

    /**
     * The original framebuffer used by Minecraft.
     */
    @Unique
    @Nullable
    private Framebuffer originalFramebufferMc = null;

    /**
     * {@inheritDoc}
     */
    @Override
    public void setFramebuffer(Framebuffer framebuffer,
        boolean bindImmediately, boolean resizeViewport) {
        if (originalFramebufferMc == null) {
            originalFramebufferMc = framebufferMc;
        }
        framebufferMc = framebuffer;
        if (bindImmediately) {
            framebuffer.bindFramebuffer(resizeViewport);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void restoreFramebuffer(boolean bindImmediately,
        boolean resizeViewport) {
        if (originalFramebufferMc != null) {
            setFramebuffer(originalFramebufferMc, bindImmediately,
                resizeViewport);
            originalFramebufferMc = null;
        }
    }
}
