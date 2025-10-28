package com.glektarssza.high_res_screenshots;

import java.io.File;
import java.lang.invoke.MethodHandles;

import javax.annotation.Nonnull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

/**
 * The root mod class.
 */
@Mod(modid = Tags.MOD_ID, name = Tags.MOD_NAME, version = Tags.MOD_VERSION, dependencies = Tags.MOD_DEPENDENCIES, acceptableRemoteVersions = Tags.MOD_VERSION, acceptedMinecraftVersions = "[1.7.10]", modLanguage = "java", guiFactory = "com.glektarssza.high_res_screenshots.config.GuiFactory", canBeDeactivated = false, useMetadata = true)
public class HighResScreenshots {
    /**
     * The logger for this class.
     */
    @SuppressWarnings("unused")
    private static final Logger LOGGER = LoggerFactory
        .getLogger(MethodHandles.lookup().lookupClass());

    /**
     * The proxy instance.
     */
    @SidedProxy(modId = Tags.MOD_ID, serverSide = "com.glektarssza.high_res_screenshots.CommonProxy", clientSide = "com.glektarssza.high_res_screenshots.ClientProxy")
    private static CommonProxy proxy;

    /**
     * The mod singleton instance.
     */
    @Mod.Instance
    private static HighResScreenshots instance;

    /**
     * Get the mod singleton instance.
     *
     * @return The mod singleton instance.
     */
    @Nonnull
    public static HighResScreenshots getInstance() {
        if (instance != null) {
            return instance;
        }
        throw new RuntimeException(
            "Instance is null, this should never happen!");
    }

    /**
     * Get the path to the mod configuration directory.
     *
     * @return The path to the mod configuration directory.
     */
    public File getConfigDir() {
        return getProxy().getConfigDir();
    }

    /**
     * Get the mod proxy object.
     *
     * @return The mod proxy object.
     */
    @Nonnull
    public static CommonProxy getProxy() {
        if (proxy != null) {
            return proxy;
        }
        throw new RuntimeException("Proxy is null, this should never happen!");
    }

    /**
     * Handle the Forge Mod Loader pre-initialization event.
     *
     * @param event The event to handle.
     */
    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        getProxy().preInit(event);
    }

    /**
     * Handle the Forge Mod Loader initialization event.
     *
     * @param event The event to handle.
     */
    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        getProxy().init(event);
    }

    /**
     * Handle the Forge Mod Loader pre-initialization event.
     *
     * @param event The event to handle.
     */
    @Mod.EventHandler
    public void onPostInit(FMLPostInitializationEvent event) {
        getProxy().postInit(event);
    }

    /**
     * Handle the Forge Mod Loader server starting event.
     *
     * @param event The event to handle.
     */
    @Mod.EventHandler
    public void onServerStarting(FMLServerStartingEvent event) {
        getProxy().serverStarting(event);
    }
}
