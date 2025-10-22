package com.glektarssza.high_res_screenshots;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.MessageFactory;

import net.minecraft.util.ResourceLocation;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

import net.minecraftforge.common.MinecraftForge;

import serverutils.events.ServerUtilitiesPreInitRegistryEvent;

/**
 * The common and server-side proxy.
 */
public class CommonProxy {
    /**
     * The root logger for the mod.
     */
    private Logger rootLogger;

    /**
     * The path to the mod configuration directory.
     */
    private File configDir;

    /**
     * Get the root logger for the mod.
     *
     * @return The root logger for the mod.
     */
    public Logger getRootLogger() {
        return this.rootLogger;
    }

    /**
     * Get a new logger.
     *
     * @return A new logger.
     */
    public Logger getLogger() {
        return LogManager.getLogger();
    }

    /**
     * Get a new logger with the given message factory.
     *
     * @param messageFactory The message factory to create the new logger with.
     *
     * @return A new logger with the given message factory.
     */
    public Logger getLogger(MessageFactory messageFactory) {
        return LogManager.getLogger(messageFactory);
    }

    /**
     * Get a new logger with the given name.
     *
     * @param name The name to create the new logger with.
     *
     * @return A new logger with the given name.
     */
    public Logger getLogger(String name) {
        return LogManager.getLogger(name);
    }

    /**
     * Get a new logger for the given class.
     *
     * @param clazz The class to create the new logger for.
     *
     * @return A new logger for the given class.
     */
    public <T> Logger getLogger(Class<T> clazz) {
        return LogManager.getLogger(clazz);
    }

    /**
     * Get a new logger for the given name with the given message factory.
     *
     * @param name The name to create the new logger for.
     * @param messageFactory The message factory to create the new logger with.
     *
     * @return A new logger for the given name with the given message factory.
     */
    public Logger getLogger(String name, MessageFactory messageFactory) {
        return LogManager.getLogger(name, messageFactory);
    }

    /**
     * Get a new logger for the given class with the given message factory.
     *
     * @param clazz The class to create the new logger for.
     * @param messageFactory The message factory to create the new logger with.
     *
     * @return A new logger for the given class with the given message factory.
     */
    public <T> Logger getLogger(Class<T> clazz, MessageFactory messageFactory) {
        return LogManager.getLogger(clazz, messageFactory);
    }

    /**
     * Get the path to the mod configuration directory.
     *
     * @return The path to the mod configuration directory.
     */
    public File getConfigDir() {
        return this.configDir;
    }

    /**
     * Handle the mod pre-initialization event.
     *
     * @param event The incoming event.
     */
    public void preInit(FMLPreInitializationEvent event) {
        this.rootLogger = event.getModLog();
        this.getRootLogger().info(
            "Pre-initializing server/common-side for {}...",
            Tags.MOD_NAME);
        this.configDir = event.getModConfigurationDirectory();
        // TODO: Initialize configuration
        this.getRootLogger().info(
            "Registering mod {} with the Forge event bus...",
            Tags.MOD_NAME);
        MinecraftForge.EVENT_BUS.register(this);
        // -- OnConfigChangedEvent comes in through here
        FMLCommonHandler.instance().bus().register(this);
        this.getRootLogger().info(
            "Done pre-initializing server/common-side for {}!",
            Tags.MOD_NAME);
    }

    /**
     * Handle the mod initialization event.
     *
     * @param event The incoming event.
     */
    public void init(FMLInitializationEvent event) {
        this.getRootLogger().info("Initializing server/common-side for {}...",
            Tags.MOD_NAME);
        // -- Does nothing yet!
        this.getRootLogger().info(
            "Done initializing server/common-side for {}!",
            Tags.MOD_NAME);
    }

    /**
     * Handle the mod post-initialization event.
     *
     * @param event The incoming event.
     */
    public void postInit(FMLPostInitializationEvent event) {
        this.getRootLogger().info(
            "Post-initializing server/common-side for {}...",
            Tags.MOD_NAME);
        // TODO
        this.getRootLogger().info(
            "Done post-initializing server/common-side for {}!",
            Tags.MOD_NAME);
    }

    /**
     * Handle the server starting event.
     *
     * @param event The incoming event.
     */
    public void serverStarting(FMLServerStartingEvent event) {
        this.getRootLogger().info("Handling server about to start for {}...",
            Tags.MOD_NAME);
        this.getRootLogger().info("Registering custom commands for {}...",
            Tags.MOD_NAME);
        // TODO: Register custom commands
        this.getRootLogger().info("Done registering custom commands for {}!",
            Tags.MOD_NAME);
        this.getRootLogger().info("Done handling server about to start for {}!",
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
        this.getRootLogger().info(
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
        this.getRootLogger().info(
            "Done pre-initializing server/common-side of Server Utilities stuff for {}!",
            Tags.MOD_NAME);
    }

    @SubscribeEvent
    public void configChanged(ConfigChangedEvent event) {
        if (event.modID.equals(Tags.MOD_ID)) {
            // TODO: Refresh config
            // TODO: Save config
        }
    }
}
