package com.dz.io;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ABooks {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCount = sc.nextInt();
        List<Integer> holder;
        while(testCount-- > 0){
            int N = sc.nextInt();
            holder = new ArrayList<>();
            for(int i = 0;i<N;i++){
                holder.add(sc.nextInt());
            }
            List<Integer> newList = new ArrayList<>();
            for(int i = 0;i<holder.size();i++){
                int count = 0;
                for(int j = i+1;j<holder.size();j++){
                    if(holder.get(i)<holder.get(j)){
                        count++;
                    }
                }
                newList.add(count);
            }
            newList.forEach(integer -> System.out.println(integer + " "));
        }
    }
}
