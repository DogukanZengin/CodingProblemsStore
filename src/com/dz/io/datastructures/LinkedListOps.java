package com.dz.io.datastructures;

import com.sun.source.doctree.SummaryTree;

import java.util.*;

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
     *Partition: Write code to partition a linked list around a value x,
     * such that all nodes less than x come before all nodes greater than
     * or equal to x. lf x is contained within the list,
     * the values of x only need to be after the elements less than x (see below).
     * The partition element x can appear anywhere in the "right partition"; it does not need to appear between the left and right partitions.
     */
    public static void partition(Node<Integer> root){
        TreeSet<Integer> bst = new TreeSet<>();
        while(root != null){
            bst.add(root.item);
            root = root.next;
        }
        int firstValue = bst.pollFirst();
        Node<Integer> newRoot = new Node(firstValue);
        while(!bst.isEmpty()){
            int value = bst.pollFirst();
            Node<Integer> newNode = new Node<>(value);
            newRoot.next = newNode;
        }

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
    public static boolean deleteMiddleNode(Node<Integer> current){
        if(current ==  null && current.next == null){
            System.out.println("Not enough elements");
            return false;
        }
        Node<Integer> next = current.next;
        current.item = next.item;
        current.next = next.next;
        return true;
    }

    static Node<Integer> insertNodeAtPosition(Node<Integer> head, int data, int position) {
        int pointer = 0;
        Node<Integer> previous = head;
        while(pointer != position-1){
            previous = previous.next;
            pointer++;
        }
        previous.next = new Node<>(data,previous.next);

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

    /**
     * Brute force
     * @param head1
     * @param head2
     * @return
     */
    static Node<Integer> findMergePoint(Node<Integer> head1, Node<Integer> head2){
        Node<Integer> head1cp = head1;
        outer : while(head1cp != null){
            Node<Integer> head2cp = head2;
            while(head2cp != null){
                if(head1cp == head2cp){
                    break outer;
                }
                head2cp = head2cp.next;
            }
            head1cp = head1cp.next;
        }
        return head1cp;
    }

    /**
     * A better approach
     * @param head1
     * @param head2
     * @return
     */
    static int findMergePointEffective(Node<Integer> head1, Node<Integer> head2){
        Node<Integer> currentA = head1;
        Node<Integer> currentB = head2;

        //Do till the two nodes are the same
        while(currentA != currentB){
            //If you reached the end of one list start at the beginning of the other one
            //currentA
            if(currentA.next == null){
                currentA = head2;
            }else{
                currentA = currentA.next;
            }
            //currentB
            if(currentB.next == null){
                currentB = head1;
            }else{
                currentB = currentB.next;
            }
        }
        return currentB.item;
    }

    static Node<Integer> sumLists(Node<Integer> num1, Node<Integer> num2){
        Node<Integer> current1 = num1;
        Node<Integer> current2 = num2;

        ArrayDeque<Integer> num1Stack = new ArrayDeque<>();
        ArrayDeque<Integer> num2Stack = new ArrayDeque<>();

        Node<Integer> sum = new Node<Integer>(0);
        while(current1 != null){
            num1Stack.push(current1.item);
            current1 = current1.next;
        }
        while(current2 != null){
            num2Stack.push(current2.item);
            current2 = current2.next;
        }
        int carry=0;
        Node<Integer> sumPointer = sum;
        while(!num1Stack.isEmpty() || !num2Stack.isEmpty()){
            int nodeSum = num1Stack.pop() + num2Stack.pop();
            carry = nodeSum / 10;
            nodeSum = nodeSum%10;
            sumPointer.item = carry + nodeSum;
            sumPointer.next = new Node<>(0);
            sumPointer = sumPointer.next;
        }

        return sum;
    }

    static boolean isPalindrome(Node<Character> head){
        int size = getSize(head);

        Node<Character> pointer = head;
        int count = 0;
        ArrayDeque<Character> deque = new ArrayDeque<>();

        while(pointer != null){
            if(count > size/2){
                deque.push(pointer.item);
            }
            pointer = pointer.next;
            count++;
        }

        while(!deque.isEmpty()){
            if(head.item != deque.pop()){
                return false;
            }
            head = head.next;
        }

        return true;
    }

    static int getSize(Node<?> head){
        if(head == null){
            return 1;
        }
        return 1 + getSize(head.next);
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        Node<Character> head = new Node<>('d');
        Node<Character> node1 = new Node<>('a');
        Node<Character> node2 = new Node<>('b');
        Node<Character> node4 = new Node<>('b');
        Node<Character> node5 = new Node<>('a');
        Node<Character> node6 = new Node<>('d');
        head.next = node1;
        node1.next = node2;
        node2.next = node4;
        node4.next = node5;
        node5.next = node6;

        System.out.println(isPalindrome(head));
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

    private static class Node<T> {
        T item;
        Node<T> next;

        Node(T element,Node<T> next) {
            this.item = element;
            this.next = next;
        }
        Node(T element) {
            this.item = element;
        }
    }
}
