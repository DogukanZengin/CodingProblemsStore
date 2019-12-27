package com.dz.io;

public class BitWiseOps {

    public static void repeatedArithmeticShift(int x, int count){
        System.out.println(x);
        for(int i = 0;i<count;i++){
            x >>= 1;
        }
        System.out.println(x);
    }

    public static void repeatedLogicalShift(int x, int count){
        System.out.println(x);
        for(int i = 0;i<count;i++){
            x >>>= 1;
        }
        System.out.println(x);
    }

    static boolean getBit(int num, int i){
        return ((num & (1 << i)) != 0);
    }

    int setBit(int num, int i){
        return num | (1 << i);
    }

    int clearBit(int num, int i){
        int mask = ~(1<<i);
        return num & mask;
    }

    public static void main(String[] args) {
        //repeatedArithmeticShift(-93242,32);
        //repeatedLogicalShift(-93242,32);
        //System.out.println(Integer.toBinaryString(6));

        System.out.println(Integer.toBinaryString(32));
        System.out.println(getBit(32,6));
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(1<<6));
    }
}
