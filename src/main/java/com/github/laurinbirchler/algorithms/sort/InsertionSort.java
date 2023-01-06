package com.github.laurinbirchler.algorithms.sort;

/**
 * Implementation of the Insertion Sort algorithm for sorting arrays of integers.
 * <p>
 * It is a variant of bubble sort and works by repeatedly iterating over the elements of the list and
 * swapping adjacent elements that are out of order. The key difference between comb sort and bubble
 * sort is that comb sort uses a gap between the elements that are compared, whereas bubble sort
 * always compares adjacent elements.
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
