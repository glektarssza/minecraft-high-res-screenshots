package com.glektarssza.high_res_screenshots.utils;

import java.lang.reflect.Array;

/**
 * A collection of helpers for dealing with arrays.
 */
public class ArrayHelpers {
    /**
     * Create a clone of a given array.
     *
     * @param src The source array to clone.
     */
    public static byte[] clone(byte[] src) {
        byte[] cloned = new byte[src.length];
        copy(src, cloned);
        return cloned;
    }

    /**
     * Create a clone of a given array.
     *
     * @param src The source array to clone.
     */
    public static short[] clone(short[] src) {
        short[] cloned = new short[src.length];
        copy(src, cloned);
        return cloned;
    }

    /**
     * Create a clone of a given array.
     *
     * @param src The source array to clone.
     */
    public static int[] clone(int[] src) {
        int[] cloned = new int[src.length];
        copy(src, cloned);
        return cloned;
    }

    /**
     * Create a clone of a given array.
     *
     * @param src The source array to clone.
     */
    public static long[] clone(long[] src) {
        long[] cloned = new long[src.length];
        copy(src, cloned);
        return cloned;
    }

    /**
     * Create a clone of a given array.
     *
     * @param src The source array to clone.
     */
    public static float[] clone(float[] src) {
        float[] cloned = new float[src.length];
        copy(src, cloned);
        return cloned;
    }

    /**
     * Create a clone of a given array.
     *
     * @param src The source array to clone.
     */
    public static double[] clone(double[] src) {
        double[] cloned = new double[src.length];
        copy(src, cloned);
        return cloned;
    }

    /**
     * Create a clone of a given array.
     *
     * @param src The source array to clone.
     */
    public static char[] clone(char[] src) {
        char[] cloned = new char[src.length];
        copy(src, cloned);
        return cloned;
    }

    /**
     * Create a clone of a given array.
     *
     * @param src The source array to clone.
     */
    public static <T> T[] clone(T[] src) {
        @SuppressWarnings("unchecked")
        T[] cloned = (T[]) Array.newInstance(src.getClass().getComponentType(),
            src.length);
        copy(src, cloned);
        return cloned;
    }

    /**
     * Copy one array to another array.
     *
     * @param src The source array to copy from.
     * @param dst The destination array to copy to.
     *
     * @throws IllegalArgumentException Thrown if the source array cannot fit
     *         into the destination array.
     */
    public static void copy(byte[] src, byte[] dst) {
        if (src.length > dst.length) {
            throw new IllegalArgumentException(
                "Source array cannot fit into destination array");
        }
        for (int i = 0; i < src.length; i += 1) {
            dst[i] = src[i];
        }
    }

    /**
     * Copy one array to another array.
     *
     * @param src The source array to copy from.
     * @param dst The destination array to copy to.
     *
     * @throws IllegalArgumentException Thrown if the source array cannot fit
     *         into the destination array.
     */
    public static void copy(short[] src, short[] dst) {
        if (src.length > dst.length) {
            throw new IllegalArgumentException(
                "Source array is not the same size as destination array");
        }
        for (int i = 0; i < src.length; i += 1) {
            dst[i] = src[i];
        }
    }

    /**
     * Copy one array to another array.
     *
     * @param src The source array to copy from.
     * @param dst The destination array to copy to.
     *
     * @throws IllegalArgumentException Thrown if the source array cannot fit
     *         into the destination array.
     */
    public static void copy(int[] src, int[] dst) {
        if (src.length > dst.length) {
            throw new IllegalArgumentException(
                "Source array is not the same size as destination array");
        }
        for (int i = 0; i < src.length; i += 1) {
            dst[i] = src[i];
        }
    }

    /**
     * Copy one array to another array.
     *
     * @param src The source array to copy from.
     * @param dst The destination array to copy to.
     *
     * @throws IllegalArgumentException Thrown if the source array cannot fit
     *         into the destination array.
     */
    public static void copy(long[] src, long[] dst) {
        if (src.length > dst.length) {
            throw new IllegalArgumentException(
                "Source array is not the same size as destination array");
        }
        for (int i = 0; i < src.length; i += 1) {
            dst[i] = src[i];
        }
    }

    /**
     * Copy one array to another array.
     *
     * @param src The source array to copy from.
     * @param dst The destination array to copy to.
     *
     * @throws IllegalArgumentException Thrown if the source array cannot fit
     *         into the destination array.
     */
    public static void copy(float[] src, float[] dst) {
        if (src.length > dst.length) {
            throw new IllegalArgumentException(
                "Source array is not the same size as destination array");
        }
        for (int i = 0; i < src.length; i += 1) {
            dst[i] = src[i];
        }
    }

    /**
     * Copy one array to another array.
     *
     * @param src The source array to copy from.
     * @param dst The destination array to copy to.
     *
     * @throws IllegalArgumentException Thrown if the source array cannot fit
     *         into the destination array.
     */
    public static void copy(double[] src, double[] dst) {
        if (src.length > dst.length) {
            throw new IllegalArgumentException(
                "Source array is not the same size as destination array");
        }
        for (int i = 0; i < src.length; i += 1) {
            dst[i] = src[i];
        }
    }

    /**
     * Copy one array to another array.
     *
     * @param src The source array to copy from.
     * @param dst The destination array to copy to.
     *
     * @throws IllegalArgumentException Thrown if the source array cannot fit
     *         into the destination array.
     */
    public static void copy(char[] src, char[] dst) {
        if (src.length > dst.length) {
            throw new IllegalArgumentException(
                "Source array is not the same size as destination array");
        }
        for (int i = 0; i < src.length; i += 1) {
            dst[i] = src[i];
        }
    }

    /**
     * Copy one array to another array.
     *
     * @param src The source array to copy from.
     * @param dst The destination array to copy to.
     *
     * @throws IllegalArgumentException Thrown if the source array cannot fit
     *         into the destination array.
     */
    public static <T> void copy(T[] src, T[] dst) {
        if (src.length > dst.length) {
            throw new IllegalArgumentException(
                "Source array is not the same size as destination array");
        }
        for (int i = 0; i < src.length; i += 1) {
            dst[i] = src[i];
        }
    }

    /**
     * Copy the given range of elements from the one array to another.
     *
     * @param src The source array to copy from.
     * @param dst The destination array to copy to.
     * @param srcOffset The offset into the source array to copy items from.
     * @param dstOffset The offset into the destination array to copy items to.
     * @param count The number of items to copy.
     *
     * @throws IllegalArgumentException Thrown if the copy range would exceed
     *         the source or destination array bounds.
     */
    public static void copyRange(byte[] src, byte[] dst, int srcOffset,
        int dstOffset, int count) {
        if (srcOffset < 0 || srcOffset + count >= src.length) {
            throw new IllegalArgumentException(
                "Copy range would exceed source array bounds");
        }
        if (dstOffset < 0 || dstOffset + count >= dst.length) {
            throw new IllegalArgumentException(
                "Copy range would exceed destination array bounds");
        }
        for (int i = srcOffset; i < srcOffset + count; i += 1) {
            dst[dstOffset + i] = src[srcOffset + i];
        }
    }

    /**
     * Copy the given range of elements from the one array to another.
     *
     * @param src The source array to copy from.
     * @param dst The destination array to copy to.
     * @param srcOffset The offset into the source array to copy items from.
     * @param dstOffset The offset into the destination array to copy items to.
     * @param count The number of items to copy.
     *
     * @throws IllegalArgumentException Thrown if the copy range would exceed
     *         the source or destination array bounds.
     */
    public static void copyRange(short[] src, short[] dst, int srcOffset,
        int dstOffset, int count) {
        if (srcOffset < 0 || srcOffset + count >= src.length) {
            throw new IllegalArgumentException(
                "Copy range would exceed source array bounds");
        }
        if (dstOffset < 0 || dstOffset + count >= dst.length) {
            throw new IllegalArgumentException(
                "Copy range would exceed destination array bounds");
        }
        for (int i = srcOffset; i < srcOffset + count; i += 1) {
            dst[dstOffset + i] = src[srcOffset + i];
        }
    }

    /**
     * Copy the given range of elements from the one array to another.
     *
     * @param src The source array to copy from.
     * @param dst The destination array to copy to.
     * @param srcOffset The offset into the source array to copy items from.
     * @param dstOffset The offset into the destination array to copy items to.
     * @param count The number of items to copy.
     *
     * @throws IllegalArgumentException Thrown if the copy range would exceed
     *         the source or destination array bounds.
     */
    public static void copyRange(int[] src, int[] dst, int srcOffset,
        int dstOffset, int count) {
        if (srcOffset < 0 || srcOffset + count >= src.length) {
            throw new IllegalArgumentException(
                "Copy range would exceed source array bounds");
        }
        if (dstOffset < 0 || dstOffset + count >= dst.length) {
            throw new IllegalArgumentException(
                "Copy range would exceed destination array bounds");
        }
        for (int i = srcOffset; i < srcOffset + count; i += 1) {
            dst[dstOffset + i] = src[srcOffset + i];
        }
    }

    /**
     * Copy the given range of elements from the one array to another.
     *
     * @param src The source array to copy from.
     * @param dst The destination array to copy to.
     * @param srcOffset The offset into the source array to copy items from.
     * @param dstOffset The offset into the destination array to copy items to.
     * @param count The number of items to copy.
     *
     * @throws IllegalArgumentException Thrown if the copy range would exceed
     *         the source or destination array bounds.
     */
    public static void copyRange(long[] src, long[] dst, int srcOffset,
        int dstOffset, int count) {
        if (srcOffset < 0 || srcOffset + count >= src.length) {
            throw new IllegalArgumentException(
                "Copy range would exceed source array bounds");
        }
        if (dstOffset < 0 || dstOffset + count >= dst.length) {
            throw new IllegalArgumentException(
                "Copy range would exceed destination array bounds");
        }
        for (int i = srcOffset; i < srcOffset + count; i += 1) {
            dst[dstOffset + i] = src[srcOffset + i];
        }
    }

    /**
     * Copy the given range of elements from the one array to another.
     *
     * @param src The source array to copy from.
     * @param dst The destination array to copy to.
     * @param srcOffset The offset into the source array to copy items from.
     * @param dstOffset The offset into the destination array to copy items to.
     * @param count The number of items to copy.
     *
     * @throws IllegalArgumentException Thrown if the copy range would exceed
     *         the source or destination array bounds.
     */
    public static void copyRange(float[] src, float[] dst, int srcOffset,
        int dstOffset, int count) {
        if (srcOffset < 0 || srcOffset + count >= src.length) {
            throw new IllegalArgumentException(
                "Copy range would exceed source array bounds");
        }
        if (dstOffset < 0 || dstOffset + count >= dst.length) {
            throw new IllegalArgumentException(
                "Copy range would exceed destination array bounds");
        }
        for (int i = srcOffset; i < srcOffset + count; i += 1) {
            dst[dstOffset + i] = src[srcOffset + i];
        }
    }

    /**
     * Copy the given range of elements from the one array to another.
     *
     * @param src The source array to copy from.
     * @param dst The destination array to copy to.
     * @param srcOffset The offset into the source array to copy items from.
     * @param dstOffset The offset into the destination array to copy items to.
     * @param count The number of items to copy.
     *
     * @throws IllegalArgumentException Thrown if the copy range would exceed
     *         the source or destination array bounds.
     */
    public static void copyRange(double[] src, double[] dst, int srcOffset,
        int dstOffset, int count) {
        if (srcOffset < 0 || srcOffset + count >= src.length) {
            throw new IllegalArgumentException(
                "Copy range would exceed source array bounds");
        }
        if (dstOffset < 0 || dstOffset + count >= dst.length) {
            throw new IllegalArgumentException(
                "Copy range would exceed destination array bounds");
        }
        for (int i = srcOffset; i < srcOffset + count; i += 1) {
            dst[dstOffset + i] = src[srcOffset + i];
        }
    }

    /**
     * Copy the given range of elements from the one array to another.
     *
     * @param src The source array to copy from.
     * @param dst The destination array to copy to.
     * @param srcOffset The offset into the source array to copy items from.
     * @param dstOffset The offset into the destination array to copy items to.
     * @param count The number of items to copy.
     *
     * @throws IllegalArgumentException Thrown if the copy range would exceed
     *         the source or destination array bounds.
     */
    public static void copyRange(char[] src, char[] dst, int srcOffset,
        int dstOffset, int count) {
        if (srcOffset < 0 || srcOffset + count >= src.length) {
            throw new IllegalArgumentException(
                "Copy range would exceed source array bounds");
        }
        if (dstOffset < 0 || dstOffset + count >= dst.length) {
            throw new IllegalArgumentException(
                "Copy range would exceed destination array bounds");
        }
        for (int i = srcOffset; i < srcOffset + count; i += 1) {
            dst[dstOffset + i] = src[srcOffset + i];
        }
    }

    /**
     * Copy the given range of elements from the one array to another.
     *
     * @param src The source array to copy from.
     * @param dst The destination array to copy to.
     * @param srcOffset The offset into the source array to copy items from.
     * @param dstOffset The offset into the destination array to copy items to.
     * @param count The number of items to copy.
     *
     * @throws IllegalArgumentException Thrown if the copy range would exceed
     *         the source or destination array bounds.
     */
    public static <T> void copyRange(T[] src, T[] dst, int srcOffset,
        int dstOffset, int count) {
        if (srcOffset < 0 || srcOffset + count >= src.length) {
            throw new IllegalArgumentException(
                "Copy range would exceed source array bounds");
        }
        if (dstOffset < 0 || dstOffset + count >= dst.length) {
            throw new IllegalArgumentException(
                "Copy range would exceed destination array bounds");
        }
        for (int i = srcOffset; i < srcOffset + count; i += 1) {
            dst[dstOffset + i] = src[srcOffset + i];
        }
    }
}
