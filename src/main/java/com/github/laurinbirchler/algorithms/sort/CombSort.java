package com.github.laurinbirchler.algorithms.sort;

/**
 * Comb sort is a sorting algorithm that is used to sort a list of items in ascending or descending order.
 * <p>
 * It is a variant of bubble sort and works by repeatedly iterating over the elements of the list and
 * swapping adjacent elements that are out of order. The key difference between comb sort and bubble
 * sort is that comb sort uses a gap between the elements that are compared, whereas bubble sort
 * always compares adjacent elements.
 *
 * @author Laurin Birchler
 * @version 1.0
 * @see <a href="https://en.wikipedia.org/wiki/Comb_sort">Comb Sort</a>
 * @since 1.0
 */
public class CombSort implements SortingAlgorithm {

    // The shrink factor of 1.3 is commonly used because it has been found to be effective in practice (see Wikipedia)
    private static final double SHRINK_FACTOR = 1.3;

    @Override
    public void sort(int[] array) {

        int gap = array.length;
        boolean swapped = true;

        // Continue looping until the gap is 1 and no swaps have been made
        while (gap > 1 || swapped) {

            if (gap > 1) {
                // cast to int is necessary to avoid floating point arithmetic
                gap = (int) (gap / SHRINK_FACTOR);
            }

            swapped = false;

            for (int i = 0; i + gap < array.length; i++) {
                // swap elements if they are out of order
                if (array[i] > array[i + gap]) {
                    int temp = array[i];
                    array[i] = array[i + gap];
                    array[i + gap] = temp;
                    swapped = true;
                }
            }
        }
    }
}

