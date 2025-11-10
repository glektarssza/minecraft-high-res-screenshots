package com.glektarssza.high_res_screenshots;

import java.lang.invoke.MethodHandles;

import javax.annotation.Nonnull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

import com.glektarssza.high_res_screenshots.utils.TypeHelper;

import serverutils.events.ServerUtilitiesPreInitRegistryEvent;

public class ClientProxy extends CommonProxy {
    /**
     * The logger for this class.
     */
    @Nonnull
    private static final Logger LOGGER = TypeHelper.castToNonNull(LoggerFactory
        .getLogger(MethodHandles.lookup().lookupClass()));

    /**
     * Handle the mod pre-initialization event.
     *
     * @param event The incoming event.
     */
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        LOGGER.info("Pre-initializing client-side for {}...",
            Tags.MOD_NAME);
        LOGGER.info("Registering mod {} key bindings...",
            Tags.MOD_NAME);
        // TODO: Register key bindings
        LOGGER.info("Done pre-initializing client-side for {}!",
            Tags.MOD_NAME);
    }

    /**
     * Handle the mod initialization event.
     *
     * @param event The incoming event.
     */
    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        LOGGER.info("Initializing client-side for {}...", Tags.MOD_NAME);
        // -- Does nothing yet!
        LOGGER.info("Done initializing client-side for {}!",
            Tags.MOD_NAME);
    }

    /**
     * Handle the mod post-initialization event.
     *
     * @param event The incoming event.
     */
    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
        LOGGER.info("Post-initializing client-side for {}...",
            Tags.MOD_NAME);
        // -- Does nothing yet!
        LOGGER.info("Done post-initializing client-side for {}!",
            Tags.MOD_NAME);
    }

    /**
     * Handle the Server Utilities mod pre-initialization registry event.
     *
     * @param event The incoming event.
     */
    @Override
    @SubscribeEvent
    public void serverUtilitiesPreInitRegistry(
        ServerUtilitiesPreInitRegistryEvent event) {
        super.serverUtilitiesPreInitRegistry(event);
        LOGGER.info(
            "Pre-initializing client-side of Server Utilities stuff for {}...",
            Tags.MOD_NAME);
        // -- Does nothing yet!
        LOGGER.info(
            "Done pre-initializing client-side of Server Utilities stuff for {}!",
            Tags.MOD_NAME);
    }

    /**
     * Handle the Minecraft Forge mod configuration changed event.
     *
     * @param event The incoming event.
     */
    @Override
    @SubscribeEvent
    public void configChanged(ConfigChangedEvent event) {
        super.configChanged(event);
        if (event.modID.equals(Tags.MOD_ID)) {
            LOGGER.info(
                "Handling client side of configuration change for {}...",
                Tags.MOD_NAME);
            // TODO: Handle any configuration changed logic
            LOGGER.info(
                "Done handling client side of configuration change for {}!",
                Tags.MOD_NAME);
        }
    }
}
