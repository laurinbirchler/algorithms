package com.github.laurinbirchler.algorithms.search;

/**
 * A class for performing a binary search on an array of comparable elements.
 * <p>
 * <b>If the array is not sorted, the binary search algorithm will not work as expected.</b> The binary search algorithm
 * relies on the fact that the array is sorted in order to divide the search space in half and narrow down the
 * search to the appropriate portion of the array.
 *
 * @author Laurin Birchler
 * @version 1.0
 * @see <a href="https://en.wikipedia.org/wiki/Binary_Search">BinarySearch</a>
 * @see SearchAlgorithm
 * @since 1.0
 */
public class BinarySearch implements SearchAlgorithm {
    @Override
    public <T extends Comparable<T>> int search(T[] array, T key) {

        /*
         * The array must be sorted for the binary search to work.
         * Throwing an exception in this case would not be consistent with the usual behavior
         * of the binary search algorithm, which is to simply return -1 if the key is not
         * found in the array.
         */
        if (!isSorted(array)) {
            return -1;
        }

        return search(array, key, 0, array.length - 1);
    }

    /**
     * Recursive helper method for performing a binary search on the given array.
     *
     * @param <T>   the type of the elements in the array, which must be comparable
     * @param array the array to search
     * @param key   the key to search for
     * @param left  the left index of the current search space
     * @param right the right index of the current search space
     * @return the index of the key in the array, or -1 if the key is not found
     */
    private <T extends Comparable<T>> int search(T[] array, T key, int left, int right) {

        if (left > right) {
            // key not found
            return -1;
        }

        int mid = (left + right) / 2;
        int comparison = array[mid].compareTo(key);

        if (comparison == 0) {
            return mid;
        } else if (comparison < 0) {
            return search(array, key, mid + 1, right);
        } else {
            return search(array, key, left, mid - 1);
        }
    }

    /**
     * Returns true if the given array is sorted, false otherwise.
     *
     * @param <T>   the type of the elements in the array, which must be comparable
     * @param array the array to check
     * @return true if the array is sorted, false otherwise
     */
    private static <T extends Comparable<T>> boolean isSorted(T[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(array[i - 1]) < 0) {
                return false;
            }
        }

        return true;
    }
}
