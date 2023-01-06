package com.github.laurinbirchler.algorithms.sort;

import org.jetbrains.annotations.NotNull;

/**
 * A class that provides a method for performing a bidirectional bubble sort (also known as Cocktail-Sort)
 * on an array of integers.
 * <p>
 * The inner loop at the beginning of the outer loop sorts the elements in ascending order, and the inner loop
 * at the end of the outer loop sorts the elements in descending order. This allows the algorithm to sort the
 * elements in both directions, resulting in a more efficient sort compared to a regular bubble sort that only
 * sorts the elements in one direction
 *
 * @author Laurin Birchler
 * @version 1.0
 * @see <a href="https://en.wikipedia.org/wiki/Bidirectional_bubble_sort">Bidirectional Bubble sort</a>
 * @since 1.0
 */
public class BidirectionalBubbleSort implements SortingAlgorithm {

    @Override
    public <T extends Comparable<T>> T[] sort(T @NotNull [] arr) {

        boolean isSorted = false;

        int start = 0;
        int end = arr.length - 1;

        // Iterate through the array, swapping adjacent elements if they are in the wrong order
        while (!isSorted) {

            isSorted = true;

            // bubble sort the array in ascending order
            // Iterate through the array, swapping adjacent elements if they are in the wrong order
            for (int i = start; i < end; i++) {
                if (arr[i].compareTo(arr[i + 1]) > 0) {
                    swap(arr, i, i + 1);
                    isSorted = false;
                }
            }

            // If the array is already sorted, break out of the loop
            if (isSorted) {
                break;
            }

            isSorted = true;
            end--;

            // bubble sort the array in descending order
            // Iterate through the array, swapping adjacent elements if they are in the wrong order
            for (int i = end - 1; i >= start; i--) {
                if (arr[i].compareTo(arr[i + 1]) > 0) {
                    swap(arr, i, i + 1);
                    isSorted = false;
                }
            }
            start++;
        }
        return arr;
    }

    @Override
    public int[] sort(int @NotNull [] arr) {
        boolean isSorted = false;

        int start = 0;
        int end = arr.length - 1;

        // Continue looping until the array is sorted
        while (!isSorted) {

            // Assume that the array is sorted
            isSorted = true;

            // bubble sort the array in ascending order
            // Iterate through the array, swapping adjacent elements if they are in the wrong order
            for (int i = start; i < end; i++) {
                // If the elements are in the wrong order, swap them
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    isSorted = false;
                }
            }

            // If the array is already sorted, break out of the loop
            if (isSorted) {
                break;
            }

            // the last element is already in its correct position
            isSorted = true;

            // Decrement the end index because the last element is already sorted
            end--;

            // bubble sort the array in descending order
            // Iterate through the array in reverse order, swapping adjacent elements if they are in the wrong order
            for (int i = end - 1; i >= start; i--) {
                // If the elements are in the wrong order, swap them
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    isSorted = false;
                }
            }

            // Increment the start index because the first element is already sorted
            start++;
        }
        return arr;
    }

    /**
     * Swaps the elements at the specified indices in the specified array.
     *
     * @param array the array in which the elements will be swapped
     * @param i     the index of the first element to be swapped
     * @param j     the index of the second element to be swapped
     */
    private static void swap(int @NotNull [] array, int i, int j) {
        // Use bit manipulation (XOR) to swap the elements without using a temporary variable
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }

    /**
     * Swaps the elements at the specified indices in the specified array.
     *
     * @param array the array in which the elements will be swapped
     * @param i     the index of the first element to be swapped
     * @param j     the index of the second element to be swapped
     * @param <T>   the type of the elements in the array
     */
    private static <T> void swap(T @NotNull [] array, int i, int j) {
        // The XOR is not possible on generic types, so use a temporary variable
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
