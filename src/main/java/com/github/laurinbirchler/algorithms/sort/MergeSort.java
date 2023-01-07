package com.github.laurinbirchler.algorithms.sort;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort implements SortingAlgorithm {

    @Override
    public int[] sort(int @NotNull [] unsorted) {

        // If the array is empty or contains only one element, it is already sorted
        if (unsorted.length <= 1) {
            return unsorted;
        }

        // Split the array into two arrays
        int middle = unsorted.length / 2;

        // Copy the first half of the array into the left subarray
        int[] left = Arrays.copyOfRange(unsorted, 0, middle);
        // Copy the second half of the array into the right subarray
        int[] right = Arrays.copyOfRange(unsorted, middle, unsorted.length);

        // Sort the left subarray
        left = sort(left);
        // Sort the right subarray
        right = sort(right);

        // Merge the two sorted subarrays
        return merge(left, right);

    }

    @Override
    public <T extends Comparable<T>> T[] sort(T @NotNull [] unsorted) {

        // If the array is empty or contains only one element, it is already sorted
        if (unsorted.length <= 1) {
            return unsorted;
        }

        // Split the array into two arrays
        int middle = unsorted.length / 2;
        // Copy the first half of the array into the left subarray
        T[] left = Arrays.copyOfRange(unsorted, 0, middle);
        // Copy the second half of the array into the right subarray
        T[] right = Arrays.copyOfRange(unsorted, middle, unsorted.length);

        // Sort the left subarray
        left = sort(left);
        //  Sort the right subarray
        right = sort(right);

        // Merge the two sorted subarrays
        return merge(left, right);
    }

    @Contract(pure = true)
    private int[] merge(int @NotNull [] left, int[] right) {

        // Create a new array that will contain the merged elements
        int[] merged = new int[left.length + right.length];

        int mergedIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        // Iterate through the left and right subarrays and add the smaller element to the merged array
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                merged[mergedIndex] = left[leftIndex];
                leftIndex++;
            } else {
                merged[mergedIndex] = right[rightIndex];
                rightIndex++;
            }
            mergedIndex++;
        }

        // Add the remaining elements of the left subarray to the merged array
        while (leftIndex < left.length) {
            merged[mergedIndex] = left[leftIndex];
            leftIndex++;
            mergedIndex++;
        }

        // Add the remaining elements of the right subarray to the merged array
        while (rightIndex < right.length) {
            merged[mergedIndex] = right[rightIndex];
            rightIndex++;
            mergedIndex++;
        }

        // Return the merged array
        return merged;
    }

    private <T extends Comparable<T>> T[] merge(T[] left, T[] right) {

        // Create a new array that will contain the merged elements
        T[] merged = (T[]) Array.newInstance(
                left.getClass().getComponentType(),
                left.length + right.length);

        int mergedIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        // Iterate through the left and right subarrays and add the smaller element to the merged array
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex].compareTo(right[rightIndex]) < 0) {
                merged[mergedIndex] = left[leftIndex];
                leftIndex++;
            } else {
                merged[mergedIndex] = right[rightIndex];
                rightIndex++;
            }
            mergedIndex++;
        }

        while (leftIndex < left.length) {
            merged[mergedIndex] = left[leftIndex];
            leftIndex++;
            mergedIndex++;
        }

        // Add the remaining elements of the right subarray to the merged array
        while (rightIndex < right.length) {
            merged[mergedIndex] = right[rightIndex];
            rightIndex++;
            mergedIndex++;
        }
        // Return the merged array
        return merged;
    }
}
