package com.floris.datastructures;

public class HashTable <K,V> {
    public HashItem<K,V>[] table;
    public HashTable(int capacity) {
        table = new HashItem[capacity];
    }

    public void put(K key, V value) {
        int k = Math.floorMod(key.hashCode(), table.length);
        while  (table[k] != null) {
            HashItem<K,V> item = new HashItem<>(key, value);
            table[k] = item;
        }
    }

    public V get(K key) {
        int k = Math.floorMod(key.hashCode(), table.length);
        HashItem<K,V> item = table[k];
        return item.value;
    }

    public void remove(K key) {
        int k = Math.floorMod(key.hashCode(), table.length);
        HashItem<K,V> item = table[k];
        item.value = null;
        table[k] = null;
    }
}

