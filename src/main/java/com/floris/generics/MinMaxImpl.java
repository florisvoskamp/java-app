package com.floris.generics;

public class MinMaxImpl<T extends Comparable<T>> implements MinMax<T> {
    @Override
    public T min(T[] array) {
        T min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (min.compareTo(array[i]) > 0) {
                min = array[i];
            }
        }
        return min;
    }

    @Override
    public T max(T[] array) {
        T  max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max.compareTo(array[i]) < 0) {
                max = array[i];
            }
        }
        return max;
    }
}

