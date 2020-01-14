package com.dz.io.datastructures;

import java.util.Stack;

public class QueueWith2Stacks<T> {

    Stack<T> in;
    Stack<T> out;

    public QueueWith2Stacks(){
        this.in = new Stack<>();
        this.out = new Stack<>();
    }

    boolean add(T t){
        in.push(t);
        return  true;
    }

    T poll(){
        while(!in.isEmpty()){
            out.push(in.pop());
        }
        return out.pop();
    }
}
