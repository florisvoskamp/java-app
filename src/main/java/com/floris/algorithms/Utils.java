package com.floris.algorithms;

import java.util.Arrays;
import java.util.Random;

public class Utils {
    public static boolean zoek(int[] lijst, int waarde) {
        // Schrijf een methode die een waarde zoekt in een lijst en true retourneert als de waarde voorkomt, anders false.
        // Tijdcomplexiteit = O(n)
        for (int i = 0; i < lijst.length; i++) {
            if (lijst[i] == waarde) {
                return true;
            }
        }
        return false;
    }

    public static int telParen(int[] lijst) {
        // Schrijf een methode die het aantal paren in een lijst telt waarbij het eerste getal kleiner is dan het tweede.
        // Voorbeeld:
        // Voor de lijst {1, 3, 2} → (1,3), (1,2) → output: 2.
        // Tijdcomplexiteit = O(n^2), oftewel kwadratisch in de lengte van de lijst.
        int paren = 0;
        for (int i = 0; i < lijst.length; i++) {
            for (int j = i + 1; j < lijst.length; j++) {
                if (lijst[i] < lijst[j]) {
                    paren++;
                }
            }
        }
        return paren;
    }

    public static int faculteit(int n) {
        // Schrijf een methode die de faculteit van een getal n berekent.
        // Tijdscomplexiteit = O(n)
        if (n < 0) {
            throw new IllegalArgumentException("n moet groter dan 0 zijn");
        }
        int resultaat = 1;
        for (int i = 2; i <= n; i++) {
            resultaat *= i;
        }
        return resultaat;
    }

    public static int faculteitRecursie(int n) {
        // Schrijf een recursieve methode die de faculteit van een getal n berekent.
        // Tijdscomplexiteit = O(n)
        if (n < 0) {
            throw new IllegalArgumentException("n moet groter dan 0 zijn");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * faculteitRecursie(n - 1);
    }

    public static int aantalRoutes(int niveau) {
        // Schrijf een recursieve methode die het aantal mogelijke routes telt in een binaire boom van hoogte n.
        if (niveau == 0) {
            return 1;
        }
        return 2*aantalRoutes(niveau-1);
    }

    public static boolean binaireZoek(int[] lijst, int waarde) {
        // Binair zoeken is een methode waarbij je het middelste element van een gesorteerde lijst pakt en dan bepaalt of je links of rechts ervan moet zijn.
        // Schrijf een methode die gebruik maakt van het binaire zoekalgoritme. Ga ervan uit dat de lijst is gesorteerd.
        int links = 0;
        int rechts = lijst.length - 1;
        while (links <= rechts) {
            int mid = links + (rechts - links) / 2;
            int midVal = lijst[mid];
            if (midVal == waarde) {
                return true;
            } else if (midVal < waarde) {
                links = mid + 1;
            } else {
                rechts = mid - 1;
            }
        }
        return false;
    }

    public static int berekenSomStream(int[] lijst) {
        // Schrijf een methode die de som van alle elementen in een lijst berekent.
        return Arrays.stream(lijst).sum();
    }

    public static int berekenSom(int[] lijst) {
        // Schrijf een methode die de som van alle elementen in een lijst berekent.
        int som = 0;
        for (int j : lijst) {
            som += j;
        }
        return som;
    }

    /*public static int[][] matrixVermenigvuldiging(int[][] A, int[][] B) {
        return
    }*/

    public static int[] bubbleSort(int[] lijst) {
        boolean swapped;

        for (int i = 1; i < lijst.length-1; i++) {
            swapped = false;
            for (int j = 0; j < lijst.length - i - 1; j++) {
                if  (lijst[j] > lijst[j+1]) {
                    lijst[j] = lijst[j+1];
                    swapped = true;
                }
            }

            if (!swapped)
                break;
        }
        return lijst;
    }

    public static int[] insertionSort(int[] lijst) {
        for (int i = 1; i < lijst.length; i++) {
            int key = lijst[i];
            int j =  i - 1;

            while (j >= 0 && lijst[j] > key) {
                lijst[j+1] = lijst[j];
                j--;
            }
            lijst[j+1] = key;
        }
        return  lijst;
    }

    public static void merge(int[] lijst, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] lA = new int[n1];
        int[] rA = new int[n2];

        for (int i = 0; i < n1; i++) {
            lA[i] = lijst[left + i];
        }
        for (int  i = 0; i < n2; i++) {
            rA[i] = lijst[mid + 1 + i];
        }

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (lA[i] <= rA[j]) {
                lijst[k] = lA[i];
                i++;
            } else {
                lijst[k] = rA[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            lijst[k] = lA[i];
            i++;
            k++;
        }

        while(j < n2) {
            lijst[k] = rA[j];
            j++;
            k++;
        }

    }

    public static void mergeSort(int[] lijst, int left, int right) {
        if  (left >= right)
            return;

        int mid =  left + (right - left)/2;
        mergeSort(lijst, left, mid);
        mergeSort(lijst, mid + 1, right);
        merge(lijst, left, mid, right);
    }

    public static int partition(int[] lijst, int left, int right) {
        int pivot = lijst[right];

        int i = left - 1;

        for (int j = left; j <= right-1; j++) {
            if (lijst[j] < pivot) {
                i++;
                swap(lijst, i, j);
            }
        }

        swap(lijst, i+1, right);
        return i + 1;
    }

    public static void quickSort(int[] lijst, int left, int right) {
        if (left < right) {
            int pivot = partition(lijst, left, right);

            // recursion
            quickSort(lijst, left, pivot - 1);
            quickSort(lijst, pivot + 1, right);
        }
    }

    public static void swap(int[] lijst, int i, int j) {
        int temp = lijst[i];
        lijst[i] = lijst[j];
        lijst[j] = temp;
    }
}

