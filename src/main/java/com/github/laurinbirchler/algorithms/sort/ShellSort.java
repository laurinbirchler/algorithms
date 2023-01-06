package com.github.laurinbirchler.algorithms.sort;

/**
 * Like insertion sort, shell sort works by iterating through the elements of an array and comparing adjacent elements.
 * However, instead of comparing adjacent elements, shell sort compares elements that are a certain number of positions
 * apart from each other, called the "gap". The gap is initially set to a value such as the length of the array divided
 * by 2, and is gradually reduced as the sort progresses.
 */
public class ShellSort extends InsertionSort {

    @Override
    public void sort(int[] arr) {
        // Get the length of the array
        int length = arr.length;

        // Start with a gap size of half the length of the array
        int gap = length / 2;

        // While the gap size is greater than 0
        while (gap > 0) {
            // Iterate through the array with the given gap size
            for (int i = gap; i < length; ++i) {
                // Save the current element as the "key"
                int key = arr[i];

                // Start the "j" index at the element before the current one
                int j = i - gap;

                // While "j" is still a valid index and the element at "j" is greater than the key
                while (j >= 0 && arr[j] > key) {
                    // Shift the element at "j" up by the gap size
                    arr[j + gap] = arr[j];

                    // Decrement "j" by the gap size to move on to the next element
                    j -= gap;
                }

                // Insert the key into its proper position in the array
                arr[j + gap] = key;
            }

            // Reduce the gap size by half
            gap /= 2;
        }
    }

}
