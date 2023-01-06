package com.github.laurinbirchler.algorithms.sort;

import org.jetbrains.annotations.NotNull;

/**
 * Implementation of the Insertion Sort algorithm for sorting arrays of integers.
 * <p>
 * Insertion sort is an efficient algorithm for sorting a small number of elements. It works by iterating through
 * the elements of an array, and inserting each element into its proper position in the array, relative to
 * the other elements. The algorithm has a time complexity of O(n^2) and is <b>not suitable for sorting large lists</b>,
 * but it is fast and simple to implement, and is often used as a simple sorting algorithm in introductory
 * computer science courses.
 *
 * @author Laurin Birchler
 * @version 1.0
 * @see <a href="https://en.wikipedia.org/wiki/Insertion_Sort">Insertion Sort</a>
 * @since 1.0
 */
public class InsertionSort implements SortingAlgorithm {
    @Override
    public int[] sort(int @NotNull [] array) {
        int length = array.length;

        for (int i = 0; i < length; ++i) {
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            if (array[j + 1] > key) {
                array[j + 1] = key;
            }
        }
        return array;
    }


    @Override
    public <T extends Comparable<T>> T[] sort(T @NotNull [] array) {

        int length = array.length;

        for (int i = 0; i < length; ++i) {
            // Save the current element as the "key"
            T key = array[i];
            // Initialize the second loop variable with the index of the previous element
            int j = i - 1;

            // Iterate through the sorted subarray to the left of the current element
            // Shift all elements that are larger than the key to the right, until it finds the correct
            // position for the key
            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j = j - 1;
            }

            // Insert the key into its correct position
            array[j + 1] = key;
        }

        // Return the sorted array
        return array;
    }
}
