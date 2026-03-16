package com.floris;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.floris.algorithms.Utils;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UtilsTest {
    public int[] lijst = {1,3,2};
    public int[] gesorteerdeLijst = {1,2,3,4,5,6,6,9,10,15,18};
    public int[] ongesorteerdeLijst = {9, 4, 12, 99, 101, 30, 10, 12};
    public int[] gesorteerdeVersieOngesorteerdeLijst = {4, 9, 10, 12, 12, 30, 99, 101};

    @Test
    public void testZoeken() {
        assertTrue(Utils.zoek(lijst,5));
    }

    @Test
    public void testTelParen() {
        assertEquals(2, Utils.telParen(lijst));
    }

    @Test
    public void testFaculiteit() {
        assertEquals(120, Utils.faculteit(5));
    }

    @Test
    public void testFaculiteitRecursie() {
        assertEquals(120, Utils.faculteitRecursie(5));
    }

    @Test
    public void testAantalRoutes() {
        assertEquals(8,Utils.aantalRoutes(3));
    }

    @Test
    public void testBinaireZoek() {
        assertTrue(Utils.binaireZoek(gesorteerdeLijst, 18));
    }

    @Test
    public void testBerekenSom() {
        assertEquals(6, Utils.berekenSom(lijst));
    }

    @Test
    public void testBubbleSort() {
        int[] lijst = Utils.bubbleSort(gesorteerdeLijst);
        assertEquals(gesorteerdeLijst, lijst);
    }

    @Test
    public void testInsertionSort() {
        int[]  lijst = Utils.insertionSort(gesorteerdeLijst);
        assertArrayEquals(gesorteerdeLijst, lijst);
    }

    @Test
    public void testMergeSort() {
        Utils.mergeSort(ongesorteerdeLijst, 0, ongesorteerdeLijst.length-1);
        assertArrayEquals(ongesorteerdeLijst, gesorteerdeVersieOngesorteerdeLijst);
    }

    @Test
    public void testQuickSort() {
        Utils.quickSort(ongesorteerdeLijst, 0, ongesorteerdeLijst.length-1);
        assertArrayEquals(ongesorteerdeLijst, gesorteerdeVersieOngesorteerdeLijst);
    }
}
