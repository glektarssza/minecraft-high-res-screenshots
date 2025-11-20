package com.glektarssza.high_res_screenshots;

import javax.annotation.Nonnull;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import com.glektarssza.high_res_screenshots.utils.Types;

/**
 * The root mod class.
 */
@Mod(modid = Tags.MOD_ID, name = Tags.MOD_NAME, version = Tags.MOD_VERSION, dependencies = Tags.MOD_DEPENDENCIES, acceptableRemoteVersions = Tags.MOD_VERSION, acceptedMinecraftVersions = "[1.7.10]", modLanguage = "java", guiFactory = "com.glektarssza.high_res_screenshots.config.GuiFactory", canBeDeactivated = false, useMetadata = true)
public class HighResScreenshots {
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
    public static HighResScreenshots getInstance() {
        return instance;
    }

    /**
     * Get the mod proxy object.
     *
     * @return The mod proxy object.
     */
    @Nonnull
    public static CommonProxy getProxy() {
        return Types.castToNonNull(proxy);
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
}
