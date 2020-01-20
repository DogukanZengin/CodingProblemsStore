package com.dz.io.sort;

import java.util.Arrays;

/**
 * Selection sort is O(n^2)
 */
public class SelectionSort {

    static int[] sort(int[] arr){
        int smallest=0;
        for(int i = 0;i<arr.length-1;i++){
            for(int j = i+1;j<arr.length;j++){
                if(arr[smallest] > arr[j]){
                    smallest = j;
                }
            }
            int temp = arr[i];
            arr[i] =  arr[smallest];
            arr[smallest] = temp;
        }

        return arr;
    }


    public static void main(String[] args) {
        int[] arr = {3,7,8,5,2,1,10,15,12,11,4};
        System.out.println(Arrays.toString(sort(arr)));
    }
}
