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

    static int clearBit(int num, int i){
        int mask = ~(1<<i);
        return num & mask;
    }

    /**
     * You are given two 32-bit numbers, N and M, and two bit positions, i and j.
     * Write a method to insert Minto N such that M starts at bit j and ends at bit i.
     * You can assume that the bits j through i have enough space to fit all of M.
     * That is, if M= 10011, you can assume that there are at least 5 bits between j and i.
     * You would not, for example, have j = 3 and i = 2, because Mcould not fully fit between bit 3 and bit 2.
     * @param M
     * @param N
     * @return
     */
    static int insert(int M, int N, int i,int j){

        if (i > j || i < 0 || j >= 32) {
            return 0;
        }

        for(int k = i;k<j;k++){
            M = clearBit(M,k);
        }
        return M | (N << i);
    }

    public static void main(String[] args) {
        //repeatedArithmeticShift(-93242,32);
        //repeatedLogicalShift(-93242,32);
        //System.out.println(Integer.toBinaryString(6));
        //System.out.println(Integer.toBinaryString(32));
        //System.out.println(getBit(32,6));
        //System.out.println(Integer.toBinaryString(512));
        System.out.println(Integer.toBinaryString(~(1<<6)));
        //System.out.println(Integer.toBinaryString(insert(1024,19,2,6)));
        System.out.println(toBinaryString(35));
    }

    public static String toBinaryString(int num){
        StringBuilder sb = new StringBuilder();

        while(num > 0){
            sb.append(num%2);
            num = num/2;
        }
        return sb.reverse().toString();
    }
}
