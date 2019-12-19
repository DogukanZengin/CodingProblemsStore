package com.dz.io.datastructures;

public class BinaryTreeTraversal {

    class TreeNode{
        int value;
        TreeNode right;
        TreeNode left;
    }

    public void inOrderTraversal(TreeNode node){
        if(node != null){
            inOrderTraversal(node.left);
            visit(node);
            inOrderTraversal(node.right);
        }
    }

    public void preOrderTraversal(TreeNode node){
        if(node != null){
            visit(node);
            inOrderTraversal(node.left);
            inOrderTraversal(node.right);
        }
    }
    public void postOrderTraversal(TreeNode node){
        if(node!= null){
            inOrderTraversal(node.left);
            inOrderTraversal(node.right);
            visit(node);
        }
    }

    public void visit(TreeNode node){
        System.out.println(node.value);
    }
}
