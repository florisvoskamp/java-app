package com.floris;

import org.junit.jupiter.api.Test;

import java.util.List;

import com.floris.datastructures.tree.FCNSNode;
import com.floris.datastructures.tree.FCNSTree;

import static org.junit.jupiter.api.Assertions.*;

class FCNSTreeTest {

    @Test
    void constructor_withRootValue_createsTreeWithRoot() {
        FCNSTree<String> tree = new FCNSTree<>("A");
        assertEquals("A", tree.getRoot().getValue());
    }

    @Test
    void constructor_withRootNode_createsTreeWithRoot() {
        FCNSNode<String> root = new FCNSNode<>("A", null, null);
        FCNSTree<String> tree = new FCNSTree<>(root);
        assertSame(root, tree.getRoot());
    }

    @Test
    void addChild_addsChildToRoot() {
        FCNSTree<String> tree = new FCNSTree<>("A");
        tree.addChild("B", "A");
        assertEquals("B", tree.getRoot().getFirstChild().getValue());
        assertNull(tree.getRoot().getFirstChild().getNextSibling());
    }

    @Test
    void addChild_addsMultipleChildrenToRoot() {
        FCNSTree<String> tree = new FCNSTree<>("A");
        tree.addChild("B", "A");
        tree.addChild("C", "A");
        tree.addChild("D", "A");

        FCNSNode<String> firstChild = tree.getRoot().getFirstChild();
        assertEquals("D", firstChild.getValue()); // Last added is first (inserted at front)
        assertEquals("C", firstChild.getNextSibling().getValue());
        assertEquals("B", firstChild.getNextSibling().getNextSibling().getValue());
        assertNull(firstChild.getNextSibling().getNextSibling().getNextSibling());
    }

    @Test
    void addChild_addsChildToNonRoot() {
        FCNSTree<String> tree = new FCNSTree<>("A");
        tree.addChild("B", "A");
        tree.addChild("E", "B");
        tree.addChild("F", "B");

        FCNSNode<String> b = tree.getRoot().getFirstChild();
        assertEquals("F", b.getFirstChild().getValue()); // Last added (F) is first child
        assertEquals("E", b.getFirstChild().getNextSibling().getValue());
    }

    @Test
    void addChild_throwsWhenParentNotFound() {
        FCNSTree<String> tree = new FCNSTree<>("A");
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> tree.addChild("B", "X"));
        assertTrue(ex.getMessage().contains("Parent not found"));
        assertTrue(ex.getMessage().contains("X"));
    }

    @Test
    void traverse_singleNode_returnsRootOnly() {
        FCNSTree<String> tree = new FCNSTree<>("A");
        assertArrayEquals(List.of("A").toArray(), tree.traverse().toArray());
    }

    @Test
    void traverse_simpleTree_returnsPreOrder() {
        FCNSTree<String> tree = new FCNSTree<>("A");
        tree.addChild("B", "A");
        tree.addChild("C", "A");
        assertArrayEquals(List.of("A", "C", "B").toArray(), tree.traverse().toArray()); // C added after B, so C is firstChild
    }

    @Test
    void traverse_deepTree_returnsPreOrder() {
        FCNSTree<String> tree = new FCNSTree<>("A");
        tree.addChild("B", "A");
        tree.addChild("C", "A");
        tree.addChild("D", "B");
        tree.addChild("E", "B");
        tree.addChild("F", "D");

        List<String> result = tree.traverse();
        assertEquals("A", result.get(0));
        assertTrue(result.contains("B"));
        assertTrue(result.contains("C"));
        assertTrue(result.contains("D"));
        assertTrue(result.contains("E"));
        assertTrue(result.contains("F"));
        assertEquals(6, result.size());
    }

    @Test
    void traverse_complexTree_correctOrder() {
        FCNSTree<String> tree = new FCNSTree<>("A");
        tree.addChild("B", "A");
        tree.addChild("C", "A");
        tree.addChild("D", "A");
        tree.addChild("E", "B");
        tree.addChild("F", "B");
        tree.addChild("G", "D");

        List<String> result = tree.traverse();
        assertEquals("A", result.get(0));
        assertEquals(7, result.size());
    }

    @Test
    void print_doesNotThrow() {
        FCNSTree<String> tree = new FCNSTree<>("A");
        tree.addChild("B", "A");
        tree.addChild("C", "A");
        assertDoesNotThrow(() -> tree.print());
    }

    @Test
    void print_emptyTree_doesNotThrow() {
        FCNSTree<String> tree = new FCNSTree<>("A");
        assertDoesNotThrow(() -> tree.print());
    }

    // FCNSNode tests
    @Test
    void fcnsNode_constructor_setsValueAndLinks() {
        FCNSNode<String> child = new FCNSNode<>("B", null, null);
        FCNSNode<String> sibling = new FCNSNode<>("C", null, null);
        FCNSNode<String> node = new FCNSNode<>("A", child, sibling);

        assertEquals("A", node.getValue());
        assertSame(child, node.getFirstChild());
        assertSame(sibling, node.getNextSibling());
    }

    @Test
    void fcnsNode_setters_updateFields() {
        FCNSNode<String> node = new FCNSNode<>("A", null, null);
        FCNSNode<String> child = new FCNSNode<>("B", null, null);
        FCNSNode<String> sibling = new FCNSNode<>("C", null, null);

        node.setValue("X");
        node.setFirstChild(child);
        node.setNextSibling(sibling);

        assertEquals("X", node.getValue());
        assertSame(child, node.getFirstChild());
        assertSame(sibling, node.getNextSibling());
    }

    @Test
    void fcnsNode_withIntegers() {
        FCNSTree<Integer> tree = new FCNSTree<>(1);
        tree.addChild(2, 1);
        tree.addChild(3, 1);
        tree.addChild(4, 2);

        List<Integer> result = tree.traverse();
        assertEquals(4, result.size());
        assertTrue(result.contains(1));
        assertTrue(result.contains(2));
        assertTrue(result.contains(3));
        assertTrue(result.contains(4));
    }
}
