package com.dz.io;

public class MathPuzzles {
    
    static boolean isPrime(int num){
        if(num<2) return false;
        
        for(int i = 2;i<num;i++){
            if(num%i == 0) return false;
        }

        return true;
    }

    static boolean isPrimeEfficient(int num){
        if(num<2) return false;

        double srt  = Math.sqrt(num);

        for(int i = 2;i<srt;i++){
            if(num%i == 0) return false;
        }

        return true;
    }


}
