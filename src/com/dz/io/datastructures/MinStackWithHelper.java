package com.dz.io.datastructures;

import java.util.Stack;

public class MinStackWithHelper{
    private Stack<Integer> main;
    private Stack<Integer> helper;

    public MinStackWithHelper() {
        main = new Stack<>();
        helper = new Stack<>();
    }

    public void push(Integer item){

        main.push(item);

        if(helper.isEmpty() || helper.peek() >= item){
            helper.push(item);
        }
    }

    public Integer pop(){
        Integer popped = main.pop();
        if(helper.peek().equals(popped)){
            helper.pop();
        }

        return popped;
    }

    public Integer min(){
        return helper.peek();
    }

    //size
    //peek
    //isEmpty
}
