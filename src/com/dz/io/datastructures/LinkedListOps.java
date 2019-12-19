package com.dz.io.datastructures;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class LinkedListOps {
    /**
     * Remove duplicates
     * If no temporary buffer is given, it could be solved with O(n^2) complexity with iterating through with inner loops
     */
    public static LinkedList<Object> removeDups(LinkedList<Object> list){
        Set<Object> listAsSet = new HashSet<>();
        while(list.iterator().hasNext()){
            Object o = list.iterator().next();
            if(!listAsSet.add(o)){
                list.remove(o);
            }
        }
        return list;
    }

    /**
     * Find the kth element to last with JDK
     * @param list
     * @param k
     * @return
     */
    public static Object findKthElementToLast(LinkedList<Object> list, int k){
        int pointer =0;
        Object o = new Object();
        while(pointer != k){
            o = list.pop();
            pointer++;
        }
        return o;
    }

    /**
     * Find the kth element to last with custom implementation
     * @param head
     * @param k
     * @return
     */
    public static Object findKthElementToLast(Node head, int k){
        Node pointer1 = head;
        Node pointer2 = head;

        for(int i = 0;i<k;i++){
            pointer1 = pointer1.next;
        }
        while(pointer1 != null){
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }

        return pointer2.item;
    }

    /**
     * Delete an element from list with only element provided.
     * @param current
     * @return
     */
    public static boolean deleteMiddleNode(Node current){
        if(current ==  null && current.next == null){
            System.out.println("Not enough elements");
            return false;
        }
        Node next = current.next;
        current.item = next.item;
        current.next = next.next;
        return true;
    }

    static Node insertNodeAtPosition(Node head, int data, int position) {
        int pointer = 0;
        Node previous = head;
        while(pointer != position-1){
            previous = previous.next;
            pointer++;
        }
        previous.next = new Node(data,previous.next);

        return head;
    }

    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        while(head.next != null){
            DoublyLinkedListNode next = head.next;
            head.next = head.prev;
            head.prev = next;
            head = next;
        }
        head.next = head.prev;
        head.prev = null;
        return head;

    }

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            DoublyLinkedList llist = new DoublyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            DoublyLinkedListNode llist1 = reverse(llist.head);

            printDoublyLinkedList(llist1, " ");
        }

        scanner.close();
    }

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep) {
        while (node != null) {
            System.out.print(node.data);

            node = node.next;

            if (node != null) {
                System.out.print(sep);
            }
        }
    }

    private static class Node {
        int item;
        Node next;
        Node prev;

        Node(int element,Node next) {
            this.item = element;
            this.next = next;
        }

        Node(int element,Node next, Node prev) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
