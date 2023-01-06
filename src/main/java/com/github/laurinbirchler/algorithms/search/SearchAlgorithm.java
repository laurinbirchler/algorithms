package com.github.laurinbirchler.algorithms.search;

public interface SearchAlgorithm {

     /**
      * @param key element which should be found
      * @param arr array where the element should be found
      * @param <T> Comparable type
      * @return first found index of the element or -1 if the element is not in the array
      */
     <T extends Comparable<T>> int search(T[] arr, T key);

}

