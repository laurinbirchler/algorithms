package com.github.laurinbirchler.algorithms.sort;

/**
 * A class that provides a method for performing bubble sort on an array of integers.
 *
 * @author Laurin Birchler
 * @version 1.0
 * @see <a href="https://en.wikipedia.org/wiki/Bubble_sort">Bubble sort</a>
 * @since 1.0
 */
public class BubbleSort implements SortingAlgorithm {

    /**
     * Sorts the elements in the specified array in ascending order.
     *
     * @param arr the array to sort
     */
    @Override
    public void sort(int[] arr) {

        int n = arr.length;
        int temp;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {

                    // swap elements
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * Sorts the elements in the specified array in ascending order. However, some optimizations have been made.
     * One optimization is to track whether any swaps have been made in the inner loop. If no swaps are made, then
     * the array must already be sorted, and we can exit the outer loop early.
     *
     * @param arr the array to sort
     */
    public void sort_optimized(int[] arr) {

        int n = arr.length;
        int temp;

        for (int i = 0; i < n; i++) {
            boolean swapped = false;

            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {

                    // swap elements
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {

                // array is already sorted, so exit early
                break;
            }
        }
    }
}
