package com.floris.generics;

import java.util.List;

public class Generics {
    public static <T extends Comparable<T>> int countGreaterThan(T[] t, T item) {
        int count = 0;
        for (T e : t) {
            if (e.compareTo(item) > 0) {
                count++;
            }
        }
        return count;
    }

    public static double sum(List<? extends Number> numbers) {
        double total = 0.0;

        for (Number n : numbers) {
            total += n.doubleValue();
        }

        return total;
    }

    public static <T extends Comparable<T>> T[] insertionSort(T[] t) {
        for (int i = 1; i < t.length; i++) {
            T key = t[i];
            int j =  i - 1;

            while (j >= 0 && t[j].compareTo(key) > 0) {
                t[j+1] = t[j];
                j--;
            }
            t[j+1] = key;
        }
        return t;
    }
}

