package com.glektarssza.high_res_screenshots.config;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import javax.annotation.Nonnull;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.ibm.icu.text.DateFormat;

import com.glektarssza.high_res_screenshots.exceptions.ToBeImplementedException;
import com.glektarssza.high_res_screenshots.exceptions.io.IOException;
import com.glektarssza.high_res_screenshots.exceptions.io.PathNotFoundException;
import com.glektarssza.high_res_screenshots.utils.TypeHelpers;

/**
 * The main mod configuration.
 */
public class Config {
    /**
     * The version of the configuration.
     */
    public static final double CONFIG_VERSION = 1.0;

    /**
     * The path to the directory to store the configuration in.
     */
    @Nonnull
    public final Path configDirPath;

    /**
     * The name to store the configuration under, minus any file extensions.
     */
    @Nonnull
    public final String configName;

    /**
     * The Gson handler instance.
     */
    @Nonnull
    private final Gson gsonInstance;

    /**
     * The configuration data.
     */
    @Nonnull
    private ConfigData configData;

    /**
     * Whether the configuration data has been modified but not saved to the
     * disk yet.
     */
    private boolean dirty;

    /**
     * Create a new instance.
     */
    public Config(@Nonnull Path configDirPath, @Nonnull String configName) {
        this.configDirPath = configDirPath;
        this.configName = configName;
        this.configData = new ConfigData();
        this.gsonInstance = TypeHelpers.castToNonNull(
            new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .generateNonExecutableJson()
                .setDateFormat(DateFormat.FULL, DateFormat.FULL)
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .setPrettyPrinting()
                .setVersion(CONFIG_VERSION)
                .create());
    }

    /**
     * Get whether this instance has had its data modified but that data has not
     * yet been saved to the disk.
     *
     * @returns {@code true} if this instance has had its configuration data
     *          modified but not yet saved to the disk, {@code false} otherwise.
     */
    public boolean getIsDirty() {
        return this.dirty;
    }

    /**
     * Get the width of screenshots to take.
     *
     * @return The width of screenshots to take.
     */
    public int getScreenshotWidth() {
        return this.configData.screenshotWidth;
    }

    /**
     * Set the width of screenshots to take.
     *
     * @param width The new width of screenshots to take.
     */
    public void setScreenshotWidth(int width) {
        this.configData.screenshotWidth = width;
        this.dirty = true;
    }

    /**
     * Get the height of screenshots to take.
     *
     * @return The height of screenshots to take.
     */
    public int getScreenshotHeight() {
        return this.configData.screenshotHeight;
    }

    /**
     * Set the height of screenshots to take.
     *
     * @param height The new height of screenshots to take.
     */
    public void setScreenshotHeight(int height) {
        this.configData.screenshotHeight = height;
        this.dirty = true;
    }

    /**
     * Get whether the HUD should be hidden in screenshots.
     *
     * @return Whether the HUD should be hidden in screenshots.
     */
    public boolean getHideHud() {
        return this.configData.hideHud;
    }

    /**
     * Set whether the HUD should be hidden in screenshots.
     *
     * @param hideHud Whether the HUD should be hidden in screenshots.
     */
    public void setHideHud(boolean hideHud) {
        this.configData.hideHud = hideHud;
        this.dirty = true;
    }

    /**
     * Get whether the aspect ratio should be preserved in screenshots.
     *
     * @return Whether the aspect ratio should be preserved in screenshots.
     */
    public boolean getPreserveAspectRatio() {
        return this.configData.preserveAspectRatio;
    }

    /**
     * Set whether the aspect ratio should be preserved in screenshots.
     *
     * @param preserveAspectRatio Whether the aspect ratio should be preserved
     *        in screenshots.
     */
    public void setPreserveAspectRatio(boolean preserveAspectRatio) {
        this.configData.preserveAspectRatio = preserveAspectRatio;
        this.dirty = true;
    }

    /**
     * Get the format screenshots should be saved in.
     *
     * @return The format screenshots should be saved in.
     */
    public ScreenshotFormat getScreenshotFormat() {
        return this.configData.screenshotFormat;
    }

    /**
     * Set the format screenshots should be saved in.
     *
     * @param screenshotFormat The format screenshots should be saved in.
     */
    public void setScreenshotFormat(ScreenshotFormat screenshotFormat) {
        this.configData.screenshotFormat = screenshotFormat;
        this.dirty = true;
    }

    /**
     * Synchronize the data contained in instance with the data on the disk.
     */
    public void sync() {
        throw new ToBeImplementedException();
    }

    /**
     * Load the configuration from the disk.
     *
     * @throws IOException Thrown if an I/O exception occurs while loading the
     *         configuration from the disk.
     */
    public void load() throws IOException {
        final Path configFilePath = configDirPath
            .resolve(this.configName + ".json");
        if (!Files.exists(configFilePath)) {
            throw new PathNotFoundException(configFilePath,
                "Could not find configuration file to load on disk");
        }
        try {
            BufferedReader reader = Files.newBufferedReader(configFilePath,
                Charset.forName("UTF-8"));
            this.configData = TypeHelpers
                .castToNonNull(gsonInstance.fromJson(reader, ConfigData.class));
        } catch (JsonSyntaxException t) {
            throw new IOException(configFilePath,
                "Failed to read configuration file from disk (configuration file contains malformed JSON data)",
                t);
        } catch (NullPointerException t) {
            throw new IOException(configFilePath,
                "Failed to read configuration file from disk (configuration file contains no data or a `null` root element)",
                t);
        } catch (Throwable t) {
            throw new IOException(configFilePath,
                "Failed to read configuration file from disk (unhandled exception while reading file)",
                t);
        }
    }

    /**
     * Save the configuration to the disk.
     */
    public void save() throws IOException {
        if (!this.getIsDirty()) {
            return;
        }
        final Path configFilePath = configDirPath
            .resolve(this.configName + ".json");
        try {
            BufferedWriter writer = Files.newBufferedWriter(configFilePath,
                Charset.forName("UTF-8"), StandardOpenOption.WRITE,
                StandardOpenOption.TRUNCATE_EXISTING,
                StandardOpenOption.CREATE);
            gsonInstance.toJson(this.configData, ConfigData.class, writer);
        } catch (JsonSyntaxException t) {
            throw new IOException(configFilePath,
                "Failed to write configuration file from disk (configuration data contains malformed JSON data)",
                t);
        } catch (Throwable t) {
            throw new IOException(configFilePath,
                "Failed to write configuration file to disk (unhandled exception while writing file)",
                t);
        }
        this.dirty = false;
    }
}
