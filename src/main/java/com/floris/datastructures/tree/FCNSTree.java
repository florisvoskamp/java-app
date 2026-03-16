package com.floris.datastructures.tree;

import java.util.ArrayList;
import java.util.List;

public class FCNSTree<T> {
    private final FCNSNode<T> root;

    public FCNSTree(FCNSNode<T> root) {
        this.root = root;
    }

    public FCNSTree(T rootValue) {
        this.root = new FCNSNode<>(rootValue, null, null);
    }

    public FCNSNode<T> getRoot() {
        return root;
    }

    public void addChild(T value, T parent) {
        FCNSNode<T> parentNode = find(root, parent);
        if (parentNode == null) {
            throw new IllegalArgumentException("Parent not found: " + parent);
        }
        FCNSNode<T> node = new FCNSNode<>(value, null, null);
        node.setNextSibling(parentNode.getFirstChild());
        parentNode.setFirstChild(node);
    }

    private FCNSNode<T> find(FCNSNode<T> node, T target) {
        if (node == null) return null;
        if (node.getValue() != null && node.getValue().equals(target)) return node;

        FCNSNode<T> result = find(node.getFirstChild(), target);
        if (result != null) return result;

        return find(node.getNextSibling(), target);
    }

    public List<T> traverse() {
        List<T> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    private void traverse(FCNSNode<T> node, List<T> result) {
        if (node == null) return;
        result.add(node.getValue());
        traverse(node.getFirstChild(), result);
        traverse(node.getNextSibling(), result);
    }

    public void print() {
        if (root == null) return;
        System.out.println(root.getValue());
        printChildren(root.getFirstChild(), "");
    }

    private void printChildren(FCNSNode<T> node, String prefix) {
        if (node == null) return;
        boolean isLast = node.getNextSibling() == null;
        System.out.println(prefix + (isLast ? "└── " : "├── ") + node.getValue());
        String childPrefix = prefix + (isLast ? "    " : "│   ");
        FCNSNode<T> child = node.getFirstChild();
        while (child != null) {
            printChildren(child, childPrefix);
            child = child.getNextSibling();
        }
    }
}

