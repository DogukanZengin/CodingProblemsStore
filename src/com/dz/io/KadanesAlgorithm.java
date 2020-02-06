package com.dz.io;

import java.util.Arrays;

public class KadanesAlgorithm{

    public static int maxSubsetSum(int[] arr) {
        if (arr.length == 0) return 0; // If no elements just return 0;
        System.out.println(Arrays.toString(arr));
        arr[0] = Math.max(0, arr[0]);// If one element check if that element is below zero, if yes set it to zero

        if (arr.length == 1) return arr[0];//return previous ops.

        arr[1] = Math.max(arr[0], arr[1]);//Initially check first two elements, and set the second element as highest of both
        System.out.println(Arrays.toString(arr));
        for (int i = 2; i < arr.length; i++){
            System.out.println(Math.max(arr[i-1], arr[i]+arr[i-2]));
            arr[i] = Math.max(arr[i-1], arr[i]+arr[i-2]);//Now keep setting the highest
            System.out.println(Arrays.toString(arr));
        }
        return arr[arr.length-1];
    }

    public static void main(String[] args) {
        maxSubsetSum(new int[]{2,1,5,8,4});
    }
}
