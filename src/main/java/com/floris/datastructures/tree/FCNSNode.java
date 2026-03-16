package com.floris.datastructures.tree;

public class FCNSNode<T> {
    private T value;
    private FCNSNode<T> firstChild;
    private FCNSNode<T> nextSibling;

    public FCNSNode(T value, FCNSNode<T> firstChild, FCNSNode<T> nextSibling) {
        this.value = value;
        this.firstChild = firstChild;
        this.nextSibling = nextSibling;
    }

    public T getValue() {
        return value;
    }

    public FCNSNode<T> getFirstChild() {
        return firstChild;
    }
    
    public FCNSNode<T> getNextSibling() {
        return nextSibling;
    }

    public void setValue(T value) {
        this.value = value;
    }
    
    public void setFirstChild(FCNSNode<T> firstChild) {
        this.firstChild = firstChild;
    }

    public void setNextSibling(FCNSNode<T> nextSibling) {
        this.nextSibling = nextSibling;
    }
    
    
}

