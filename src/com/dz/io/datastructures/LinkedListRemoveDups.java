package com.dz.io.datastructures;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class LinkedListRemoveDups {

    /**
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
}
