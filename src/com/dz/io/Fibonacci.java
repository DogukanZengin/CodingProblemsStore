package com.dz.io;

import java.math.BigDecimal;

public class Fibonacci {

    static int fibonacciRecursive(int n){
        if(n == 0)return 0;
        if(n == 1)return 1;
        return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
    }

    static int fibonacciDynamic(int n){
        return fibonacciDynamic(n, new int[n+1]);
    }

    static int fibonacciDynamic(int n, int[] memo){
        if(n==0 || n==1) return n;
        if(memo[n] == 0){
            memo[n] = fibonacciDynamic(n-1,memo) + fibonacciDynamic(n-2,memo);
        }
        return memo[n];
    }

    static int fibonacciBottomUp(int n){
        if(n==0 || n==1) return n;
        int[] memo = new int[n+1];
        memo[0] = 0;
        memo[1] = 1;
        for(int i = 2;i<=n;i++){
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[n];
    }
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(fibonacciRecursive(30));
        System.out.println((System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        System.out.println(BigDecimal.valueOf(fibonacciDynamic(50)));
        System.out.println((System.currentTimeMillis() - start));
        System.out.println(fibonacciBottomUp(10));
    }
}
