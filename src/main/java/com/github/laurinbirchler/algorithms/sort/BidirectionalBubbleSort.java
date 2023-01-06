package com.github.laurinbirchler.algorithms.sort;

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
    public void sort(int[] arr) {

        // If no swaps are made, the array is already sorted, and we can exit the loop.
        boolean swapped = true;
        int startIndex = 0;
        int endIndex = arr.length - 1;

        while (swapped) {
            swapped = false;

            // Bubble-Sort up the largest element to the end of the array
            for (int i = startIndex; i < endIndex; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }

            swapped = false;

            // Bubble-Sort down the smallest element to the start of the array
            endIndex--;
            for (int i = endIndex - 1; i >= startIndex; i--) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }

            startIndex++;
        }
    }

}
