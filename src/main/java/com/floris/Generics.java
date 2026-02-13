package com.floris;

public class Generics {
    public static <T extends Comparable<T>> int countGreaterThan(T[] t, T item) {
        int count = 0;
        for  (int i = 0; i < t.length-1; i++) {
            if (t[i].compareTo(item) > 0) {
                count++;
            }
        }
        return count;
    }
}
