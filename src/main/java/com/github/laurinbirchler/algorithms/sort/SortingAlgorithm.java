package com.github.laurinbirchler.algorithms.sort;

public interface SortingAlgorithm {
     <T extends Comparable<T>> T[] sort(T[] unsorted);
}
