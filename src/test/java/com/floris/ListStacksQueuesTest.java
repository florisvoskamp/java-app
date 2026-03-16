package com.floris;

import org.junit.jupiter.api.Test;

import com.floris.datastructures.ListStacksQueues;

import static org.junit.jupiter.api.Assertions.*;

class ListStacksQueuesTest {

    private final ListStacksQueues listStacksQueues = new ListStacksQueues();

    @Test
    void isBalanced_emptyString() {
        assertTrue(listStacksQueues.isBalanced(""));
    }

    @Test
    void isBalanced_simplePair() {
        assertTrue(listStacksQueues.isBalanced("()"));
    }

    @Test
    void isBalanced_nestedBrackets() {
        assertTrue(listStacksQueues.isBalanced("([])"));
    }

    @Test
    void isBalanced_multipleTypes() {
        assertTrue(listStacksQueues.isBalanced("()[]{}"));
    }

    @Test
    void isBalanced_withContent() {
        assertTrue(listStacksQueues.isBalanced("(a + (b * c))"));
    }

    @Test
    void isBalanced_complexExpression() {
        assertTrue(listStacksQueues.isBalanced("{ [ ( ) ] }"));
    }

    @Test
    void isBalanced_unbalanced_singleOpen() {
        assertFalse(listStacksQueues.isBalanced("("));
    }

    @Test
    void isBalanced_unbalanced_singleClose() {
        assertFalse(listStacksQueues.isBalanced(")"));
    }

    @Test
    void isBalanced_unbalanced_wrongOrder() {
        assertFalse(listStacksQueues.isBalanced("([)]"));
    }

    @Test
    void isBalanced_unbalanced_mismatched() {
        assertFalse(listStacksQueues.isBalanced("(]"));
    }

    @Test
    void isBalanced_unbalanced_extraOpen() {
        assertFalse(listStacksQueues.isBalanced("([]"));
    }
}
