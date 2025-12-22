package com.glektarssza.high_res_screenshots.config;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Since;

/**
 * The mod configuration data for serialization to/from JSON.
 */
public class ConfigData {
    /**
     * The width of the screenshot to take.
     */
    @Expose
    @SerializedName("screenshotWidth")
    @Since(1.0)
    public int screenshotWidth = 1920;

    /**
     * The height of the screenshot to take.
     */
    @Expose
    @SerializedName("screenshotHeight")
    @Since(1.0)
    public int screenshotHeight = 1280;

    /**
     * Whether to preserve the current aspect ratio of the game.
     */
    @Expose
    @SerializedName("preserveAspectRatio")
    @Since(1.0)
    public boolean preserveAspectRatio = true;

    /**
     * Whether to hide the player HUD.
     */
    @Expose
    @SerializedName("hideHud")
    @Since(1.0)
    public boolean hideHud = false;

    /**
     * The format to save screenshots in.
     */
    @Expose
    @SerializedName("screenshotFormat")
    @Since(1.0)
    public ScreenshotFormat screenshotFormat;

    /**
     * Create a new instance with the default values.
     */
    public ConfigData() {
        this.hideHud = false;
        this.preserveAspectRatio = false;
        this.screenshotFormat = ScreenshotFormat.PNG;
        this.screenshotWidth = 1920;
        this.screenshotHeight = 1280;
    }
}
