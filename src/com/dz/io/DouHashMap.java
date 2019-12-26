package com.dz.io;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    static void checkMagazine(String[] magazine, String[] note) {
        Map<String,Long> magazineMapped =  Arrays.stream(magazine).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        Map<String,Long> noteMapped =  Arrays.stream(note).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        for(String s : noteMapped.keySet()){
            if(!magazineMapped.containsKey(s) || magazineMapped.get(s) < noteMapped.get(s)){
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }

}
