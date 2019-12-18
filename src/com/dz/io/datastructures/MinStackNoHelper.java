package com.dz.io.datastructures;

import java.util.Stack;

/**
 * A minimum stack implementation
 *  If newly inserted element is bigger or equals to minimum element, just insert
 *  Else set newly inserted element as minimum and push 2x - min to the stack
 *  If popped item is bigger or equals to min just pop
 *  Else return min then set min as 2*min - popped
 */
public class MinStackNoHelper {

    private Stack<Integer> holder;
    private Integer min;

    public MinStackNoHelper() {
        holder = new Stack<>();
    }

    public void push(Integer item){

        if(holder.isEmpty()){
            holder.push(item);
            min = item;
        }else{
            if(min < item){
                holder.push(item);
            }else{
                min = item;
                holder.push(2*item-min);
            }
        }
    }

    public Integer pop(){
        Integer popped = holder.pop();
        if(min > popped){
            Integer actual = min;
            min = 2*min - popped;
            return actual;
        }else{
            return popped;
        }
    }
}
