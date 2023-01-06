package com.github.laurinbirchler.algorithms.sort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("Testing CombSort")
class CombSortTest {
    SortingAlgorithm combSort = new CombSort();

    @ParameterizedTest(name = "{index} --> Testing with {0} which is a {2}")
    @MethodSource("comparableArgumentProvider")
    public <T extends Comparable<T>> void testSortGeneric(T[] array, T[] expected, String message) {

        var sortedArray = combSort.sort(array);
        assertArrayEquals(expected, sortedArray);
    }

    @ParameterizedTest(name = "{index} --> Testing with {0} which is a {2}")
    @MethodSource("primitiveArgumentProvider")
    public void testSortPrimitive(int[] array, int[] expected, String message) {

        var sortedArray = combSort.sort(array);
        assertArrayEquals(expected, sortedArray);
    }

    private static Stream<Arguments> primitiveArgumentProvider() {

        return Stream.of(
                arguments(new int[]{5, 1, 4, 2, 8}, new int[]{1, 2, 4, 5, 8}, "normal array"),
                arguments(new int[]{1, 2, 4, 5, 8}, new int[]{1, 2, 4, 5, 8}, "normal array already sorted"),
                arguments(new int[]{-5, -1, 4, 2, 8}, new int[]{-5, -1, 2, 4, 8}, "array with negative integers"),
                arguments(new int[]{-5, -1, 4, 2, 8, 0}, new int[]{-5, -1, 0, 2, 4, 8}, "array with zeros"),
                arguments(new int[]{-5, -1, 8, -1, -1, 4, 2, 8, 0}, new int[]{-5, -1, -1, -1, 0, 2, 4, 8, 8}, "array with duplicates")
        );
    }

    private static Stream<Arguments> comparableArgumentProvider() {

        return Stream.of(
                arguments(new Double[]{5.2, 2.4, 4.3, 3.8, 1.34}, new Double[]{1.34, 2.4, 3.8, 4.3, 5.2}, "array of Double Objects"),
                arguments(new Integer[]{5, 2, 4, 3, 1}, new Integer[]{1, 2, 3, 4, 5}, "array of Integer Objects"),
                arguments(new Integer[]{1, 2, 3, 4, 5}, new Integer[]{1, 2, 3, 4, 5}, "array of Integer Objects already sorted"),
                arguments(new String[]{"Hello", "World", "Apple", "~", "Apple", "Pineapple", "Amber", "1"}, new String[]{"1", "Amber", "Apple", "Apple", "Hello", "Pineapple", "World", "~"}, "array of String Objects")
        );
    }
}