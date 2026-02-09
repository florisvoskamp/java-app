package com.floris;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        // Test data
        int[] lijst = {1, 3, 2, 5, 4, 7, 6};
        int[] gesorteerd = {1, 2, 3, 4, 5, 6, 7};
        int[] groteLijst = new int[100_000];
        for (int i = 0; i < groteLijst.length; i++) groteLijst[i] = i;

        System.out.println("=== Utils timing tests ===\n");

        // zoek
        long t0 = System.nanoTime();
        boolean z = Utils.zoek(lijst, 5);
        long t1 = System.nanoTime();
        System.out.printf("zoek(lijst, 5) = %s  →  %d ns%n", z, t1 - t0);

        // zoek op grote lijst
        t0 = System.nanoTime();
        z = Utils.zoek(groteLijst, 99_999);
        t1 = System.nanoTime();
        System.out.printf("zoek(groteLijst[100k], 99999) = %s  →  %d ns%n", z, t1 - t0);

        // telParen
        t0 = System.nanoTime();
        int paren = Utils.telParen(lijst);
        t1 = System.nanoTime();
        System.out.printf("telParen(lijst) = %d  →  %d ns%n", paren, t1 - t0);

        // faculteit
        t0 = System.nanoTime();
        int fac = Utils.faculteit(10);
        t1 = System.nanoTime();
        System.out.printf("faculteit(10) = %d  →  %d ns%n", fac, t1 - t0);

        t0 = System.nanoTime();
        fac = Utils.faculteit(20);
        t1 = System.nanoTime();
        System.out.printf("faculteit(20) = %d  →  %d ns%n", fac, t1 - t0);

        // aantalRoutes
        t0 = System.nanoTime();
        int routes = Utils.aantalRoutes(10);
        t1 = System.nanoTime();
        System.out.printf("aantalRoutes(10) = %d  →  %d ns%n", routes, t1 - t0);

        t0 = System.nanoTime();
        routes = Utils.aantalRoutes(20);
        t1 = System.nanoTime();
        System.out.printf("aantalRoutes(20) = %d  →  %d ns%n", routes, t1 - t0);

        // binaireZoek
        t0 = System.nanoTime();
        boolean b = Utils.binaireZoek(gesorteerd, 5);
        t1 = System.nanoTime();
        System.out.printf("binaireZoek(gesorteerd, 5) = %s  →  %d ns%n", b, t1 - t0);

        t0 = System.nanoTime();
        b = Utils.binaireZoek(groteLijst, 99_999);
        t1 = System.nanoTime();
        System.out.printf("binaireZoek(groteLijst[100k], 99999) = %s  →  %d ns%n", b, t1 - t0);

        // berekenSomStream
        t0 = System.nanoTime();
        int som = Utils.berekenSomStream(lijst);
        t1 = System.nanoTime();
        System.out.printf("berekenSomStream(lijst) = %d  →  %d ns%n", som, t1 - t0);

        t0 = System.nanoTime();
        som = Utils.berekenSomStream(groteLijst);
        t1 = System.nanoTime();
        System.out.printf("berekenSomStream(groteLijst[100k]) = %d  →  %d ns%n", som, t1 - t0);

        // berekenSom
        t0 = System.nanoTime();
        som = Utils.berekenSom(lijst);
        t1 = System.nanoTime();
        System.out.printf("berekenSom(lijst) = %d  →  %d ns%n", som, t1 - t0);

        t0 = System.nanoTime();
        som = Utils.berekenSom(groteLijst);
        t1 = System.nanoTime();
        System.out.printf("berekenSom(groteLijst[100k]) = %d  →  %d ns%n", som, t1 - t0);

        System.out.println("\n(matrixVermenigvuldiging niet getest: nog niet geïmplementeerd)");
    }
}
