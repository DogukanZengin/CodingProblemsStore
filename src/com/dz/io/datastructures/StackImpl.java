package com.dz.io.datastructures;

import java.util.Stack;

public class StackImpl<T> extends Stack<T> {

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T element, Node<T> next) {
            this.data = element;
            this.next = next;
        }
    }

    private Node<T> top;
    private Node<T> min;

    public T peek() {
        return top.data;
    }

    public T push(T data) {
        top = new Node<>(data,top);
        return top.data;
    }

    public T pop() {
        T data = top.data;
        top = top.next;
        return data;
    }

    public Node<T> min(){
        return min;
    }

    public boolean isEmpty(){
        return top == null;
    }
}
