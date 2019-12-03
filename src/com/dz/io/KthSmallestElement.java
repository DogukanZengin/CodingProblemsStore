package com.dz.io;

import java.util.Arrays;

public class KthSmallestElement {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParityII(new int[]{1,4,4,3,0,3})));
    }

    static int[] sortArrayByParityII(int[] A) {

        for(int i=0;i<A.length;i++){
            int nextCandidate=0,temp;
            boolean odd = i%2 != 0;
            if(odd != (A[i] % 2 != 0)){
                for(int j=i+1;j<A.length;j++){
                    if((A[j]%2!=0) == odd){
                        nextCandidate = j;
                        break;
                    }
                }
                temp = A[i];
                A[i] = A[nextCandidate];
                A[nextCandidate] = temp;
            }
        }
        return A;
    }
    public static int kthSmallest(int[][] matrix, int k) {
        int m=matrix.length;// N x N matrix

        int lower = matrix[0][0];//first element
        int upper = matrix[m-1][m-1];//last element

        while(lower<upper){
            int mid = lower + ((upper-lower)>>1);
            int count = count(matrix, mid);
            if(count<k){
                lower=mid+1;
            }else{
                upper=mid;
            }
        }
        return upper;
    }

    private static int count(int[][] matrix, int target){
        int m=matrix.length; // matrix vertical element count
        int i=m-1;// arr[i][] - matrix vertical last element
        int j=0; // horizontal
        int count = 0;

        while(i>=0&&j<m){
            if(matrix[i][j]<=target){
                count += i+1;
                j++;
            }else{
                i--;
            }
        }

        return count;
    }
}
