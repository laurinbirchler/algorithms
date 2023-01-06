package com.github.laurinbirchler.algorithms.sort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BidirectionalBubbleSortTest {
    SortingAlgorithm bidirectionalBubbleSort = new BidirectionalBubbleSort();

    @ParameterizedTest(name = "{index} --> Testing with {0} which is a {2}")
    @MethodSource("argumentProvider")
    public void testSort(Integer[] array, Integer[] expected, String message) {

        var sortedArray = bidirectionalBubbleSort.sort(array);
        assertArrayEquals(expected, sortedArray);
    }

    private static Stream<Arguments> argumentProvider() {

        return Stream.of(
                arguments(new int[]{5, 1, 4, 2, 8}, new int[]{1, 2, 4, 5, 8}, "normal array"),
                arguments(new int[]{-5, -1, 4, 2, 8}, new int[]{-5, -1, 2, 4, 8}, "array with negative integers"),
                arguments(new int[]{-5, -1, 4, 2, 8, 0}, new int[]{-5, -1, 0, 2, 4, 8}, "array with zeros"),
                arguments(new int[]{-5, -1, 8, -1, -1, 4, 2, 8, 0}, new int[]{-5, -1, -1, -1, 0, 2, 4, 8, 8}, "array with duplicates")
        );
    }
}