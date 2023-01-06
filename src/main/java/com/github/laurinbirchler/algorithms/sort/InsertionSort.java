package com.github.laurinbirchler.algorithms.sort;

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
    public void sort(int[] array) {

        int length = array.length;

        // Iterate through each element in the array
        for (int i = 0; i < length; ++i) {

            // Save the current element as the "key"
            int key = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }

            array[j + 1] = key;

        }

    }
}
