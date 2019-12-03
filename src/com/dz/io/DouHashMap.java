package com.dz.io;

import java.util.Objects;

public class DouHashMap<K,V>{

    Node<K,V>[] table;
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    static final int MAXIMUM_CAPACITY = 1 << 30;


    public DouHashMap() {
    }

    class Node<K,V>{
        int hash;
        K key;
        V value;
        Node<K,V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private int hash(Object key){
        return Objects.hash(key);
    }

}
