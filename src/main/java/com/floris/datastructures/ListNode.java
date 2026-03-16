package com.floris.datastructures;

public class ListNode<T> {
    private ListNode<T> next;
    private T value;

    public ListNode(T value, ListNode<T> next) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    public void clear() {
        this.value = null;
        this.next = null;
    }
}

