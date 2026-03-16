package com.floris.datastructures;

import java.util.Iterator;

public class LinkedList<T extends Iterable<T>> implements ILinkedList<T> {
    private ListNode<T> first;
    private ListNode<T> last;
    private int size;
    private ListNode<T>[] list;

    public LinkedList(int size, ListNode<T>[] list) {
        this.size = size;
        this.list = list;
    }

    @Override
    public void addFirst(T value) {
        System.arraycopy(this.list, 0, this.list, 1, this.list.length - 1);
        ListNode<T> first =  new ListNode<>(value, list[1]);
        this.list[0] = first;
        this.first = first;
    }

    @Override
    public void clear() {
        for (ListNode<T> node : list) {
            node.clear();
            node =  null;
        }
    }

    @Override
    public void insert(int index, T value) {

    }

    @Override
    public void delete(int pos) {
        list[pos] = null;
    }

    @Override
    public T get(int pos) {
        return list[pos].getValue();
    }

    @Override
    public void removeFirst() {
        list[0] = null;
    }

    @Override
    public T getFirst() {
        return list[0].getValue();
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}

