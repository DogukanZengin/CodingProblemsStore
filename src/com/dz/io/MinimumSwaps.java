package com.dz.io;

/**
 * You are given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] without any duplicates.
 * You are allowed to swap any two elements. You need to find the minimum number of swaps required to sort the array in ascending order.
 * For example, given the array  we perform the following steps:
 */
public class MinimumSwaps {

    static int minimumSwaps(int[] arr) {
        int swapCounts = 0;
        boolean sorted = false;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != i + 1) {
                    int temp = arr[arr[i] - 1];
                    arr[arr[i] - 1] = arr[i];
                    arr[i] = temp;
                    sorted =false;
                    swapCounts++;
                }

            }
        }
        return swapCounts;
    }

    public static void main(String[] args) {

    }
}
