package com.dz.io;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
 * write a method to rotate the image by 90 degrees. can you do this in place?
 */
public class RotateMatrix {

    public void rotate(int[][] matrix, int N){
        for(int x = 0; x<N/2; x++){
            for(int y = x; y< N-x-1 ; y++){
                int temp = matrix[x][y];
                matrix[x][y] = matrix[y][N-x-1];
                matrix[y][N-x-1] = matrix[N-x-1][N-y-1];
                matrix[N-x-1][N-y-1] = matrix[N-1-y][x];
                matrix[N-1-y][x] = temp;
            }
        }
    }

    // Function for do transpose of matrix
    static void transpose(int arr[][])
    {
        for (int i = 0; i < arr.length; i++)
            for (int j = i; j < arr[0].length; j++) {
                int temp = arr[j][i];
                arr[j][i] = arr[i][j];
                arr[i][j] = temp;
            }
    }

    // After transpose we swap elements of
    // column one by one for finding left
    // rotation of matrix by 90 degree
    static void reverseColumns(int arr[][])
    {
        for (int i = 0; i < arr[0].length; i++)
            for (int j = 0, k = arr[0].length - 1; j < k; j++, k--) {
                int temp = arr[j][i];
                arr[j][i] = arr[k][i];
                arr[k][i] = temp;
            }
    }
}
