package com.glektarssza.high_res_screenshots.config;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.glektarssza.high_res_screenshots.exceptions.collections.KeyNotFoundException;

/**
 * An enumeration of valid formats to save screenshots in.
 */
public enum ScreenshotFormat {
    /**
     * The JPEG (Joint Photographic Experts Group) format.
     */
    JPEG("jpeg"),

    /**
     * The PNG (Portable Network Graphics) format.
     */
    PNG("png"),

    /**
     * The BMP (Bitmap) format.
     */
    BMP("bmp");

    /**
     * Try to convert a format identifier into an enumeration value.
     *
     * @param id The format identifier to try to convert.
     *
     * @return The matching enumeration value for the format ID or {@code null}
     *         if no matching enumeration value could be found.
     */
    @Nullable
    public static ScreenshotFormat tryFromString(String id) {
        ScreenshotFormat[] formats = ScreenshotFormat.values();
        for (ScreenshotFormat format : formats) {
            if (format.formatId.equalsIgnoreCase(id)) {
                return format;
            }
        }
        return null;
    }

    /**
     * Try to convert a format identifier into an enumeration value.
     *
     * @param id The format identifier to try to convert.
     *
     * @return The matching enumeration value for the format ID or {@code null}
     *         if no matching enumeration value could be found.
     *
     * @throws KeyNotFoundException Thrown if an enumeration value cannot be
     *         found matching the given format identifier.
     */
    @Nonnull
    public static ScreenshotFormat fromString(String id)
        throws KeyNotFoundException {
        ScreenshotFormat format = tryFromString(id);
        if (format == null) {
            throw new KeyNotFoundException(id,
                String.format(
                    "Could not find screenshot format enumeration value for format ID \"%s\"",
                    id));
        }
        return format;
    }

    /**
     * The unique identifier for the format.
     */
    public final String formatId;

    /**
     * Create a new instance.
     *
     * @param formatId The unique identifier of the format.
     */
    private ScreenshotFormat(String formatId) {
        this.formatId = formatId;
    }

    /**
     * Get the string representation of this instance.
     *
     * @return The string representation of this instance.
     */
    @Override
    public String toString() {
        return this.formatId;
    }
}
