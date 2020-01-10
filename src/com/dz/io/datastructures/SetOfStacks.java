package com.dz.io.datastructures;

import java.util.Stack;

/**
 *  3.3
 * Stack of Plates: Imagine a (literal) stack of plates.
 * If the stack gets too high, it might topple.
 * Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold.
 * Implement a data structure SetOfStacks that mimics this.
 * SetOfStacks should be composed of several stacks and should create a new stack once the previous one exceeds capacity.
 * SetOfStacks. push () and SetOfStacks. pop () should behave identically to a single stack
 * (that is, pop ( ) should return the same values as it would if there were just a single stack).
 */
@SuppressWarnings("unchecked")
public class SetOfStacks<T> {

    int maxStackSize;
    Stack[] stacks;
    int activeStackIndex;

    public SetOfStacks(int maxStackSize, int stackCount) {
        this.maxStackSize = maxStackSize;
        this.stacks = new Stack[stackCount];
        stacks[activeStackIndex = 0] = new Stack<T>();
    }

    boolean push(T t){
        if (stacks[activeStackIndex].size() >= maxStackSize) {
            if(activeStackIndex == stacks.length-1){
                System.out.println("Stack is full");
                return false;
            }
            stacks[++activeStackIndex] = new Stack<T>();
        }
        stacks[activeStackIndex].push(t);
        return true;
    }

    T pop(){
        if(stacks[activeStackIndex].isEmpty()){
            if(activeStackIndex == 0 ){
                System.out.println("Stack is empty");
                return null;
            }
            activeStackIndex--;
        }
        return (T) stacks[activeStackIndex].pop();
    }
    String showStatistics(){
        return "Active Stack Index : " + activeStackIndex + ", Current Stack Size :  " + stacks[activeStackIndex].size();
    }

    T popAtIndex(int index){
        if(!stacks[index].isEmpty()){
            return (T) stacks[index].pop();
        }
        System.out.println("Stack at index is empty");
        return null;
    }


    public static void main(String[] args) {
        SetOfStacks<Integer> setOfStacks =  new SetOfStacks<>(2,3);
        setOfStacks.push(1);
        System.out.println(setOfStacks.showStatistics());
        setOfStacks.pop();
        setOfStacks.pop();

    }

}
