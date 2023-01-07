package com.github.laurinbirchler.algorithms.sort;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;

@DisplayName("Testing Stooge Sort")
public class StoogeSort implements SortingAlgorithm {
    @Override
    public <T extends Comparable<T>> T[] sort(T @NotNull [] arr) {
        sort(arr, 0, arr.length );
        return arr;
    }

    @Override
    public int[] sort(int @NotNull [] arr) {
        sort(arr, 0, arr.length);
        return arr;
    }

    /**
     * Sorts the elements in the given array using the Stooge sort algorithm and the given comparator.
     *
     * @param arr the array to be sorted
     * @param l the left index of the subarray to be sorted
     * @param r the right index of the subarray to be sorted
     */
    private void sort(int[] arr, int l, int r) {

        // If first element is smaller than last, swap them
        if (arr[r - 1] < arr[l]) {
            int temp = arr[l];
            arr[l] = arr[r - 1];
            arr[r - 1] = temp;
        }

        int n = r - l;

        // If there are 2 or more elements in the array then sort the first 2/3 elements and last 2/3 elements recursively
        if (n > 2) {
            int t = n / 3;
            // Recursively sort first 2/3 elements
            sort(arr, l, r - t);
            // Recursively sort last 2/3 elements
            sort(arr, l + t, r);
            // Recursively sort first 2/3 elements again to confirm
            sort(arr, l, r - t);
        }
    }

    /**
     * Sorts the elements in the given array using the Stooge sort algorithm and the given comparator.
     *
     * @param arr the array to be sorted
     * @param l the left index of the subarray to be sorted
     * @param r the right index of the subarray to be sorted
     * @param <T> the type of elements in the array
     */
    private <T extends Comparable<T>> void sort(T[] arr, int l, int r) {

        // If first element is smaller than last, swap them
        if (arr[r - 1].compareTo(arr[l]) < 0) {
            T temp = arr[l];
            arr[l] = arr[r - 1];
            arr[r - 1] = temp;
        }

        int n = r - l;

        // If more than 2 elements are present in the array then recursively sort first 2/3 elements and last 2/3 elements
        if (n > 2) {
            int t = n / 3;
            // Recursively sort first 2/3 elements
            sort(arr, l, r - t);
            // Recursively sort last 2/3 elements
            sort(arr, l + t, r);
            // Recursively sort first 2/3 elements again to confirm
            sort(arr, l, r - t);
        }
    }

}
