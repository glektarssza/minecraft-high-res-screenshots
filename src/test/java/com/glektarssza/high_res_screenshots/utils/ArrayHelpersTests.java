package com.glektarssza.high_res_screenshots.utils;

import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.annotation.Nonnull;
import javax.annotation.RegEx;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import net.datafaker.Faker;

/**
 * Unit tests for the {@link ArrayHelpers} class.
 */
public class ArrayHelpersTests {
    /**
     * A pattern which matches against unsigned long integers.
     */
    @RegEx
    @Nonnull
    public static final String UNSIGNED_LONG_INTEGER_PATTERN = "^[[:digit:]]{1,21}[lL]?$";

    /**
     * A pattern which matches against signed long integers.
     */
    @RegEx
    @Nonnull
    public static final String SIGNED_LONG_INTEGER_PATTERN = "^-?[[:digit:]]{1,20}[lL]?$";

    /**
     * The fake data source.
     */
    @Nonnull
    private static Faker fakeData = new Faker(Locale.CANADA);

    /**
     * Method to run before all tests.
     */
    @BeforeAll
    public static void beforeAll() {
        String rawFakerSeed = System.getenv().getOrDefault("FAKER_SEED",
            System.getProperty("FAKER_SEED"));
        if (rawFakerSeed != null
            && (rawFakerSeed.matches(UNSIGNED_LONG_INTEGER_PATTERN)
                || rawFakerSeed.matches(SIGNED_LONG_INTEGER_PATTERN))) {
            try {
                long fakerSeed = Long.parseLong(rawFakerSeed, 10);
                fakeData = new Faker(Locale.CANADA, new Random(fakerSeed));
            } catch (Throwable t) {
                // -- Do nothing
            }
        }
    }

    @Test
    public void testCloneBytes() {
        // -- Given
        byte[] arr = fakeData.random()
            .nextRandomBytes(fakeData.random().nextInt(1, 10));

        // -- When
        byte[] result = ArrayHelpers.clone(arr);

        // -- Then
        Assertions.assertThat(result).hasSize(arr.length)
            .containsExactly(arr).isNotSameAs(arr);
    }

    @Test
    public void testCloneShorts() {
        // -- Given
        List<Short> data = fakeData.collection().minLen(1).maxLen(10)
            .nullRate(0)
            .suppliers(() -> {
                byte[] bytes = fakeData.random().nextRandomBytes(Short.BYTES);
                long result = 0;
                for (int i = 0; i < Short.BYTES; i += 1) {
                    result += (long) (bytes[i] << 8 * i);
                }
                return (short) result;
            }).generate();
        short[] arr = new short[data.size()];
        for (int i = 0; i < data.size(); i += 1) {
            arr[i] = data.get(i);
        }

        // -- When
        short[] result = ArrayHelpers.clone(arr);

        // -- Then
        Assertions.assertThat(result).hasSize(arr.length)
            .containsExactly(arr).isNotSameAs(arr);
    }

    @Test
    public void testCloneInts() {
        // -- Given
        List<Integer> data = fakeData.collection().minLen(1).maxLen(10)
            .nullRate(0)
            .suppliers(() -> {
                byte[] bytes = fakeData.random().nextRandomBytes(Integer.BYTES);
                long result = 0;
                for (int i = 0; i < Integer.BYTES; i += 1) {
                    result += (long) (bytes[i] << 8 * i);
                }
                return (int) result;
            }).generate();
        int[] arr = new int[data.size()];
        for (int i = 0; i < data.size(); i += 1) {
            arr[i] = data.get(i);
        }

        // -- When
        int[] result = ArrayHelpers.clone(arr);

        // -- Then
        Assertions.assertThat(result).hasSize(arr.length)
            .containsExactly(arr).isNotSameAs(arr);
    }

    @Test
    public void testCloneLongs() {
        // -- Given
        List<Long> data = fakeData.collection().minLen(1).maxLen(10)
            .nullRate(0)
            .suppliers(() -> {
                byte[] bytes = fakeData.random().nextRandomBytes(Long.BYTES);
                long result = 0;
                for (int i = 0; i < Long.BYTES; i += 1) {
                    result += (long) (bytes[i] << 8 * i);
                }
                return (long) result;
            }).generate();
        long[] arr = new long[data.size()];
        for (int i = 0; i < data.size(); i += 1) {
            arr[i] = data.get(i);
        }

        // -- When
        long[] result = ArrayHelpers.clone(arr);

        // -- Then
        Assertions.assertThat(result).hasSize(arr.length)
            .containsExactly(arr).isNotSameAs(arr);
    }

    @Test
    public void testCloneFloats() {
        // -- Given
        List<Float> data = fakeData.collection().minLen(1).maxLen(10)
            .nullRate(0)
            .suppliers(() -> {
                byte[] bytes = fakeData.random().nextRandomBytes(Float.BYTES);
                float result = 0;
                for (int i = 0; i < Float.BYTES; i += 1) {
                    result += (float) (bytes[i] << 8 * i);
                }
                return (float) result;
            }).generate();
        float[] arr = new float[data.size()];
        for (int i = 0; i < data.size(); i += 1) {
            arr[i] = data.get(i);
        }

        // -- When
        float[] result = ArrayHelpers.clone(arr);

        // -- Then
        Assertions.assertThat(result).hasSize(arr.length)
            .containsExactly(arr).isNotSameAs(arr);
    }

    @Test
    public void testCloneDoubles() {
        // -- Given
        List<Double> data = fakeData.collection().minLen(1).maxLen(10)
            .nullRate(0)
            .suppliers(() -> {
                byte[] bytes = fakeData.random().nextRandomBytes(Double.BYTES);
                double result = 0;
                for (int i = 0; i < Double.BYTES; i += 1) {
                    result += (double) (bytes[i] << 8 * i);
                }
                return (double) result;
            }).generate();
        double[] arr = new double[data.size()];
        for (int i = 0; i < data.size(); i += 1) {
            arr[i] = data.get(i);
        }

        // -- When
        double[] result = ArrayHelpers.clone(arr);

        // -- Then
        Assertions.assertThat(result).hasSize(arr.length)
            .containsExactly(arr).isNotSameAs(arr);
    }

    @Test
    public void testCloneCharacters() {
        // -- Given
        List<Character> data = fakeData.collection().minLen(1).maxLen(10)
            .nullRate(0)
            .suppliers(() -> {
                byte[] bytes = fakeData.random()
                    .nextRandomBytes(Character.BYTES);
                char result = 0;
                for (int i = 0; i < Character.BYTES; i += 1) {
                    result += (char) (bytes[i] << 8 * i);
                }
                return (char) result;
            }).generate();
        char[] arr = new char[data.size()];
        for (int i = 0; i < data.size(); i += 1) {
            arr[i] = data.get(i);
        }

        // -- When
        char[] result = ArrayHelpers.clone(arr);

        // -- Then
        Assertions.assertThat(result).hasSize(arr.length)
            .containsExactly(arr).isNotSameAs(arr);
    }

    /**
     * A test class.
     */
    public static class FooBar {
        /**
         * A test string.
         */
        public String qux;

        /**
         * Create a new instance.
         */
        public FooBar() {
            this.qux = "zig";
        }
    }

    @Test
    public void testCloneObjects() {
        // -- Given
        List<FooBar> data = fakeData.collection().minLen(1).maxLen(10)
            .nullRate(0)
            .suppliers(() -> new FooBar()).generate();
        FooBar[] arr = new FooBar[data.size()];
        for (int i = 0; i < data.size(); i += 1) {
            arr[i] = data.get(i);
        }

        // -- When
        FooBar[] result = ArrayHelpers.clone(arr);

        // -- Then
        Assertions.assertThat(result).hasSize(arr.length)
            .containsExactly(arr).isNotSameAs(arr);
    }
}
