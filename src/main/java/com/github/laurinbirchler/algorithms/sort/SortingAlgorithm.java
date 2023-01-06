package com.github.laurinbirchler.algorithms.sort;

/**
 * An interface that defines a sorting algorithm.
 */
public interface SortingAlgorithm {

     /**
      * Sorts an array of objects that implement the {@link Comparable} interface.
      *
      * @param unsorted the array to be sorted
      * @param <T> the type of elements in the array
      * @return the sorted array
      */
     <T extends Comparable<T>> T[] sort(T[] unsorted);

     /**
      * Sorts an array of integers.
      *
      * @param unsorted the array to be sorted
      * @return the sorted array
      */
     int[] sort(int[] unsorted);
}

