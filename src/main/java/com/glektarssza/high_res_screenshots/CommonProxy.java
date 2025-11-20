package com.glektarssza.high_res_screenshots;

import java.lang.invoke.MethodHandles;

import javax.annotation.Nonnull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.minecraft.util.ResourceLocation;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

import net.minecraftforge.common.MinecraftForge;

import com.glektarssza.high_res_screenshots.utils.TypeHelpers;

import serverutils.events.ServerUtilitiesPreInitRegistryEvent;

/**
 * The common and server-side proxy.
 */
public class CommonProxy {
    /**
     * The logger for this class.
     */
    @Nonnull
    private static final Logger LOGGER = TypeHelpers.castToNonNull(LoggerFactory
        .getLogger(MethodHandles.lookup().lookupClass()));

    /**
     * Handle the mod pre-initialization event.
     *
     * @param event The incoming event.
     */
    public void preInit(FMLPreInitializationEvent event) {
        LOGGER.info("Pre-initializing server/common-side for {}...",
            Tags.MOD_NAME);
        LOGGER.info("Initializing mod {} configuration...",
            Tags.MOD_NAME);
        // TODO: Initialize configuration
        LOGGER.info("Registering mod {} with the Forge event bus...",
            Tags.MOD_NAME);
        MinecraftForge.EVENT_BUS.register(this);
        // -- OnConfigChangedEvent comes in through here
        FMLCommonHandler.instance().bus().register(this);
        LOGGER.info("Done pre-initializing server/common-side for {}!",
            Tags.MOD_NAME);
    }

    /**
     * Handle the mod initialization event.
     *
     * @param event The incoming event.
     */
    public void init(FMLInitializationEvent event) {
        LOGGER.info("Initializing server/common-side for {}...", Tags.MOD_NAME);
        // -- Does nothing yet!
        LOGGER.info("Done initializing server/common-side for {}!",
            Tags.MOD_NAME);
    }

    /**
     * Handle the mod post-initialization event.
     *
     * @param event The incoming event.
     */
    public void postInit(FMLPostInitializationEvent event) {
        LOGGER.info("Post-initializing server/common-side for {}...",
            Tags.MOD_NAME);
        // -- Does nothing yet!
        LOGGER.info("Done post-initializing server/common-side for {}!",
            Tags.MOD_NAME);
    }

    /**
     * Handle the Server Utilities mod pre-initialization registry event.
     *
     * @param event The incoming event.
     */
    @SubscribeEvent
    public void serverUtilitiesPreInitRegistry(
        ServerUtilitiesPreInitRegistryEvent event) {
        LOGGER.info(
            "Pre-initializing server/common-side of Server Utilities stuff for {}...",
            Tags.MOD_NAME);
        event.getRegistry().registerServerReloadHandler(
            new ResourceLocation(Tags.MOD_ID, "config"),
            reloadEvent -> {
                try {
                    // TODO: Sync config
                } catch (Throwable t) {
                    return false;
                }
                return true;
            });
        LOGGER.info(
            "Done pre-initializing server/common-side of Server Utilities stuff for {}!",
            Tags.MOD_NAME);
    }

    /**
     * Handle the Minecraft Forge mod configuration changed event.
     *
     * @param event The incoming event.
     */
    @SubscribeEvent
    public void configChanged(ConfigChangedEvent event) {
        if (event.modID.equals(Tags.MOD_ID)) {
            LOGGER.info(
                "Handling common/sever side of configuration change for {}...",
                Tags.MOD_NAME);
            // TODO: Handle any configuration changed logic
            LOGGER.info(
                "Done handling common/sever side of configuration change for {}!",
                Tags.MOD_NAME);
        }
    }
}
