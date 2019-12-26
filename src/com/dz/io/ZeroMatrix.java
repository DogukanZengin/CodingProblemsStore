package com.dz.io;

import java.util.ArrayList;
import java.util.List;

/**
 * Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to O.
 */
public class ZeroMatrix {

    public static int[][] zeroMatrix(int[][] original){
        int M = original.length;
        int N = original[0].length;
        List<Tuple> zeroPoints = new ArrayList<>();
        for(int i = 0;i< M;i++){
            for(int j = 0;j<N;j++){
                if(original[i][j] == 0){
                    zeroPoints.add(new Tuple(i,j));
                }
            }
        }

        for(Tuple tuple : zeroPoints){
            for(int i = 0;i<M;i++){
                original[i][tuple.y] = 0;
            }
            for(int i = 0;i<N;i++){
                original[tuple.x][i] = 0;
            }
        }

        return original;
    }

    public static class Tuple {
        public final int x;
        public final int y;
        public Tuple(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int[][] original = {{1,2,3,4,5},{5,4,0,2,1},{8,7,6,1,5},{4,5,7,2,7}};
        printAsMatrix(original);
        System.out.println("\n");
        printAsMatrix(zeroMatrix(original));

    }

    public static void printAsMatrix(int[][] matrix){
        int M = matrix.length;
        int N = matrix[0].length;

        for(int i = 0;i< M;i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
