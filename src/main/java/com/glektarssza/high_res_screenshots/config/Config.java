package com.glektarssza.high_res_screenshots.config;

import java.nio.file.Path;

import net.minecraftforge.common.config.Configuration;

import com.glektarssza.high_res_screenshots.Tags;

/**
 * The mod configuration.
 */
public class Config {
    /**
     * The version of the configuration being used.
     */
    public static final String CONFIG_VERSION = "1";

    /**
     * Generate the configuration.
     *
     * @param diskPath The disk path to the configuration file.
     *
     * @return The generate configuration.
     */
    public static Configuration generateConfiguration(Path diskPath) {
        Configuration config = new Configuration(diskPath.toFile(),
            CONFIG_VERSION, false);
        config.getCategory("general").setShowInGui(true).setLanguageKey(
            "com.glektarssza.high_res_screenshots.config.category.general")
            .setComment("The general settings.");

        config
            .get("general", "screenshot_capture_method", "SINGLE_BUFFER",
                "The method to use to capture screenshots. Allowed values are: SINGLE_BUFFER/TILED_BUFFERS")
            .setShowInGui(true)
            .setLanguageKey(
                "com.glektarssza.high_res_screenshots.config.category.general.property.screenshot_capture_method")
            .setRequiresMcRestart(false)
            .setRequiresWorldRestart(false);
        config
            .get("general", "screenshot_width", 1920,
                "The width of screenshots to take.")
            .setShowInGui(true)
            .setLanguageKey(
                "com.glektarssza.high_res_screenshots.config.category.general.property.screenshot_width")
            .setRequiresMcRestart(false)
            .setRequiresWorldRestart(false);
        config
            .get("general", "screenshot_height", 1080,
                "The width of screenshots to take.")
            .setShowInGui(true)
            .setLanguageKey(
                "com.glektarssza.high_res_screenshots.config.category.general.property.screenshot_height")
            .setRequiresMcRestart(false)
            .setRequiresWorldRestart(false);

        config.getCategory("debug").setShowInGui(true).setLanguageKey(
            "com.glektarssza.high_res_screenshots.config.category.debug")
            .setComment("The debugging settings.");

        config
            .get("debug", "verbose_logging", false,
                "Whether verbose logging is enabled.")
            .setShowInGui(true)
            .setLanguageKey(
                "com.glektarssza.high_res_screenshots.config.category.debug.property.verbose_logging")
            .setRequiresMcRestart(false)
            .setRequiresWorldRestart(false);
        return config;
    }

    /**
     * The path to the configuration file on disk.
     */
    public final Path configPath;

    /**
     * The configuration being used in-game.
     */
    private final Configuration config;

    /**
     * Create a new instance.
     *
     * @param configDir The path to the configuration directory.
     */
    public Config(Path configDir) {
        this.configPath = configDir.resolve(String.join(".", new String[] {
            Tags.MOD_ID, "cfg"
        }));
        this.config = generateConfiguration(configPath);
    }

    /**
     * Load the configuration from disk.
     */
    public void load() {
        this.config.load();
    }

    /**
     * Save the configuration to disk.
     */
    public void save() {
        if (this.config.hasChanged()) {
            this.config.save();
        }
    }

    /**
     * Synchronize the configuration with the contents from disk.
     *
     * This process involves loading the configuration from disk, replacing any
     * values that have been changed on disk with their updated values, and then
     * saving the updated configuration back to disk.
     */
    public void sync() {
        Configuration diskConfig = generateConfiguration(this.configPath);
        // -- Load the refreshed disk configuration
        diskConfig.load();
        // -- Copy the in-game settings over top of the disk configuration
        diskConfig.copyCategoryProps(this.config, null);
        // -- Save it allllll to disk
        diskConfig.save();
        // -- Reload our in-game config from disk
        this.config.load();
    }
}
