package com.dz.io;

public class Factorial {


    public static int factorial(int num) {
        if(num == 1){
            return num;
        }
        return num * factorial(num -1);
    }


    public static void main (String[] args) {
        System.out.print(factorial(4));
    }
}
