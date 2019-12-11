package com.dz.io;

public class HourGlass {


    public int findMaxHourGlass(int[][] matrix){
        int max = -9999;

        for(int i = 1;i<matrix.length-1;i++){
            for(int j = 1;j<matrix[i].length-1;j++){
                int sum = max = matrix[i][j];
                sum += matrix[i-1][j] + matrix[i-1][j-1] + matrix[i-1][j+1];
                sum += matrix[i+1][j] + matrix[i+1][j-1] + matrix[i+1][j+1];
                if(sum > max){
                    max = sum;
                }
            }
        }
        return max;
    }
}
