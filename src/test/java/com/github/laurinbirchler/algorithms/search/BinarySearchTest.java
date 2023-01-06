package com.github.laurinbirchler.algorithms.search;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    SearchAlgorithm binarySearch = new BinarySearch();
    Integer[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    Integer[] unsortedArray = {5, 1, 4, 2, 8};
    Integer[] emptyArray = {};

    @Test
    @DisplayName("Test searching for an element that is present in the array")
    public void test_elementIsPresent() {
        assertEquals(3, binarySearch.search(sortedArray, 4));
    }

    @Test
    @DisplayName("Test searching for an element that is not present in the array")
    public void test_elementIsNotPresent() {
        assertEquals(-1, binarySearch.search(sortedArray, 11));
    }

    @Test
    @DisplayName("Test searching for an element with an empty target array")
    public void test_targetArrayIsEmpty() {
        assertEquals(-1, binarySearch.search(emptyArray, 11));
    }

    @Test
    @DisplayName("Test searching for an element with an unsorted target array")
    public void test_targetArrayIsUnsorted() {
        assertEquals(-1, binarySearch.search(unsortedArray, 1));
    }

}