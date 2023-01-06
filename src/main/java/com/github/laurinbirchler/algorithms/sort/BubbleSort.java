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

    @Override
    public <T extends Comparable<T>> T[] sort(T[] arr) {

        int length = arr.length;

        // Iterate through the array, swapping adjacent elements if they are in the wrong order
        for (int i = 0; i < length - 1; i++) {
            // The last i elements are already in their correct positions
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    // Swap the elements
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        // Return the sorted array
        return arr;
    }

    @Override
    public int[] sort(int[] arr) {

        int length = arr.length;

        // Iterate through the array, swapping adjacent elements if they are in the wrong order
        for (int i = 0; i < length - 1; i++) {
            // The last i elements are already in their correct positions
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap the elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        // Return the sorted array
        return arr;
    }
}
