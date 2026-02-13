package com.floris;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Hello world!
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        // Test data (aligned with UtilsTest where applicable)
        int[] lijst = {1, 3, 2};
        int[] gesorteerdeLijst = {1, 2, 3, 4, 5, 6, 6, 9, 10, 15, 18};
        int[] groteLijst = new int[100_000];
        for (int i = 0; i < groteLijst.length; i++) groteLijst[i] = i;

        // Large unsorted list for sorting benchmarks (same data for all algorithms)
        final int SORT_SIZE = 2500;
        int[] groteOngesorteerdeLijst = new int[SORT_SIZE];
        Random rng = new Random(42);
        for (int i = 0; i < groteOngesorteerdeLijst.length; i++) {
            groteOngesorteerdeLijst[i] = rng.nextInt();
        }

        System.out.println("=== Utils timing tests ===\n");

        // zoek (UtilsTest: zoek(lijst, 5))
        long t0 = System.nanoTime();
        boolean z = Utils.zoek(lijst, 5);
        long t1 = System.nanoTime();
        System.out.printf("zoek(lijst, 5) = %s  →  %d ns%n", z, t1 - t0);

        t0 = System.nanoTime();
        z = Utils.zoek(groteLijst, 99_999);
        t1 = System.nanoTime();
        System.out.printf("zoek(groteLijst[100k], 99999) = %s  →  %d ns%n", z, t1 - t0);

        // telParen (UtilsTest: telParen(lijst) = 2)
        t0 = System.nanoTime();
        int paren = Utils.telParen(lijst);
        t1 = System.nanoTime();
        System.out.printf("telParen(lijst) = %d  →  %d ns%n", paren, t1 - t0);

        // faculteit (UtilsTest: faculteit(5) = 120)
        t0 = System.nanoTime();
        int fac = Utils.faculteit(5);
        t1 = System.nanoTime();
        System.out.printf("faculteit(5) = %d  →  %d ns%n", fac, t1 - t0);

        t0 = System.nanoTime();
        fac = Utils.faculteit(10);
        t1 = System.nanoTime();
        System.out.printf("faculteit(10) = %d  →  %d ns%n", fac, t1 - t0);

        // faculteitRecursie (UtilsTest: faculteitRecursie(5) = 120)
        t0 = System.nanoTime();
        fac = Utils.faculteitRecursie(5);
        t1 = System.nanoTime();
        System.out.printf("faculteitRecursie(5) = %d  →  %d ns%n", fac, t1 - t0);

        // aantalRoutes (UtilsTest: aantalRoutes(3) = 8)
        t0 = System.nanoTime();
        int routes = Utils.aantalRoutes(3);
        t1 = System.nanoTime();
        System.out.printf("aantalRoutes(3) = %d  →  %d ns%n", routes, t1 - t0);

        t0 = System.nanoTime();
        routes = Utils.aantalRoutes(10);
        t1 = System.nanoTime();
        System.out.printf("aantalRoutes(10) = %d  →  %d ns%n", routes, t1 - t0);

        // binaireZoek (UtilsTest: binaireZoek(gesorteerdeLijst, 18))
        t0 = System.nanoTime();
        boolean b = Utils.binaireZoek(gesorteerdeLijst, 18);
        t1 = System.nanoTime();
        System.out.printf("binaireZoek(gesorteerdeLijst, 18) = %s  →  %d ns%n", b, t1 - t0);

        t0 = System.nanoTime();
        b = Utils.binaireZoek(groteLijst, 99_999);
        t1 = System.nanoTime();
        System.out.printf("binaireZoek(groteLijst[100k], 99999) = %s  →  %d ns%n", b, t1 - t0);

        // berekenSom (UtilsTest: berekenSom(lijst) = 6)
        t0 = System.nanoTime();
        int som = Utils.berekenSom(lijst);
        t1 = System.nanoTime();
        System.out.printf("berekenSom(lijst) = %d  →  %d ns%n", som, t1 - t0);

        t0 = System.nanoTime();
        som = Utils.berekenSomStream(lijst);
        t1 = System.nanoTime();
        System.out.printf("berekenSomStream(lijst) = %d  →  %d ns%n", som, t1 - t0);

        t0 = System.nanoTime();
        som = Utils.berekenSom(groteLijst);
        t1 = System.nanoTime();
        System.out.printf("berekenSom(groteLijst[100k]) = %d  →  %d ns%n", som, t1 - t0);

        // Sorting algorithms on large list (n = SORT_SIZE) — times in ms
        System.out.println("\n--- Sorting (n = " + SORT_SIZE + ", random data) ---");

        int[] bubbleInput = Arrays.copyOf(groteOngesorteerdeLijst, groteOngesorteerdeLijst.length);
        t0 = System.nanoTime();
        Utils.bubbleSort(bubbleInput);
        t1 = System.nanoTime();
        System.out.printf("bubbleSort    →  %d ms%n", (t1 - t0) / 1_000_000);

        int[] insertionInput = Arrays.copyOf(groteOngesorteerdeLijst, groteOngesorteerdeLijst.length);
        t0 = System.nanoTime();
        Utils.insertionSort(insertionInput);
        t1 = System.nanoTime();
        System.out.printf("insertionSort →  %d ms%n", (t1 - t0) / 1_000_000);

        int[] mergeInput = Arrays.copyOf(groteOngesorteerdeLijst, groteOngesorteerdeLijst.length);
        t0 = System.nanoTime();
        Utils.mergeSort(mergeInput, 0, mergeInput.length - 1);
        t1 = System.nanoTime();
        System.out.printf("mergeSort     →  %d ms%n", (t1 - t0) / 1_000_000);

        int[] quickInput = Arrays.copyOf(groteOngesorteerdeLijst, groteOngesorteerdeLijst.length);
        t0 = System.nanoTime();
        Utils.quickSort(quickInput, 0, quickInput.length - 1);
        t1 = System.nanoTime();
        System.out.printf("quickSort     →  %d ms%n", (t1 - t0) / 1_000_000);

        System.out.println("\n=== Done (all UtilsTest operations with timing) ===");

        Pair<String, Integer> pair = new Pair<>("", 10);

        Integer[] a = {5,2,30,-10,5,6,9};
        System.out.println(Generics.countGreaterThan(a, 2));
        System.out.println(Generics.sum(List.of(a)));
        MinMax<Integer> min = new MinMaxImpl<>();
        System.out.println(min.min(a));
        System.out.println(min.max(a));
    }
}
