package com.dz.io.datastructures;

public class StackImpl<T>{

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T element, Node<T> next) {
            this.data = element;
            this.next = next;
        }
    }

    private Node<T> top;

    public T peek() {
        return top.data;
    }

    public void push(T data) {
        top = new Node<>(data,top);
    }

    public T pop() {
        T data = top.data;
        top = top.next;
        return data;
    }

    public boolean isEmpty(){
        return top == null;
    }
}
