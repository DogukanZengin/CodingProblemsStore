package com.dz.io.datastructures;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LinkedListOps {
    private static class Node {
        int item;
        Node next;

        Node(int element,Node next) {
            this.item = element;
            this.next = next;
        }
    }
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
        Node newCurrent = new Node(data,previous.next);
        previous.next = newCurrent;

        return head;
    }
}
