package com.dz.io.datastructures;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    class TrieNode{
        private Map<Character, TrieNode> children;
        private char value;

        public TrieNode() {
            this.children = new HashMap<>();
        }
    }

    private TrieNode root;

    void insert(String key){
        int length = key.length();
        TrieNode pointer = root;
        for(int i = 0;i< length;i++){
            if(pointer.children.get(key.charAt(i)) == null){
                pointer.children.put(key.charAt(i), new TrieNode());
            }
            pointer = pointer.children.get(key.charAt(i));
        }
    }

    boolean find(String key){
        int length = key.length();
        TrieNode pointer = root;
        for(int i = 0;i< length;i++){
            if(pointer.children.get(key.charAt(i)) == null){
                return false;
            }
            pointer = pointer.children.get(key.charAt(i));
        }
        return true;
    }
}
