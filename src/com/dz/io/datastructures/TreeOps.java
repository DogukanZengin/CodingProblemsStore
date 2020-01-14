package com.dz.io.datastructures;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TreeOps {

    /**
     * Create a binary tree with minimal height using a sorted array
     * @param
     * @return
     */
    private static Node createMinimalBST(int[] arr, int start, int end){
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        Node n = new Node(arr[mid]);
        n.left = (createMinimalBST(arr, start, mid - 1));
        n.right = (createMinimalBST(arr, mid + 1, end));
        return n;
    }

    public static Node createMinimalBST(int[] array) {
        return createMinimalBST(array, 0, array.length - 1);
    }

    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static int height(Node root){
        if (root == null) return -1;

        int left = 1 + height(root.left);
        int right = 1 + height(root.right);

        return Math.max(left, right);
    }

    public static void main(String[] args) {
        System.out.println((int)1/2);
    }

    static Node createSampleTree(int height){
        if(height == 0){
            return null;
        }
        Random r = new Random();
        Node root = new Node(r.nextInt(20));
        root.left = createSampleTree(height-1);
        root.right= createSampleTree(height-1);
        return root;
    }

    static void displayTree(Node root){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        Node current;
        int height = height(root);
        while(!queue.isEmpty()){
            current = queue.poll();
            if(height != height(current)){
                System.out.println();
            }
            String space = IntStream.range(0, height(current)+1).mapToObj(i -> " ").collect(Collectors.joining(""));
            System.out.print(space + current.data);
            if(current.left !=  null){
                queue.add(current.left);
            }
            if(current.right != null){
                queue.add(current.right);
            }
            height = height(current);
        }
    }
}
