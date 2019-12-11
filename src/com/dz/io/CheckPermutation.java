package com.dz.io;

import java.util.Arrays;

public class CheckPermutation {

    // If both are sorted they will be the same string
    public static boolean isPermutation(String original, String permutation){
        if(original.length() != permutation.length()){
            return false;
        }
        char[] originalChars = original.toCharArray();
        char[] permutChars = permutation.toCharArray();
        Arrays.sort(originalChars);
        Arrays.sort(permutChars);
        return Arrays.toString(originalChars).equals(Arrays.toString(permutChars)) ;
    }



    public static void main(String[] args) {
        System.out.println(isPermutation("abcde","edcbg"));
    }
}
