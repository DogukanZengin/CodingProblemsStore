package com.dz.io.sort;

import java.util.Arrays;

/**
 * Bubble Sort is O(n^2)
 */
public class BubbleSort {

    static int[] sort(int[] arr){
        boolean sorted = false;
        while(!sorted){
            sorted = true;
            for(int i = 0;i<arr.length-1;i++){
                int temp = arr[i];
                if(temp > arr[i+1]){
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    sorted = false;
                }
            }
        }
        return arr;
    }

    static int[] sortAlt(int[] arr){
        for(int i = 0;i<arr.length;i++){
            for(int j = 1;j<arr.length-i;j++){
                if(arr[j-1] > arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }


    public static void main(String[] args) {
        int[] arr = {3,7,8,5,2,1,10,15,12,11,4};
        System.out.println(Arrays.toString(sortAlt(arr)));
    }
}
