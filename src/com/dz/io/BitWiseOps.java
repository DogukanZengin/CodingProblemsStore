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
        String bs = printBinary(.125);
        System.out.println(bs);

        for (int i = 0; i < 1000; i++) {
            double num = i / 1000.0;
            String binary = printBinary(num);
            String binary2 = printBinary2(num);
            if (!binary.equals("ERROR") || !binary2.equals("ERROR")) {
                System.out.println(num + " : " + binary + " " + binary2);
            }
        }
    }

    public static String printBinary(double num) {
        if (num >= 1 || num <= 0) {
            return "ERROR";
        }

        StringBuilder binary = new StringBuilder();
        binary.append(".");
        while (num > 0) {
            /* Setting a limit on length: 32 characters */
            double r = num * 2;
            if (r >= 1) {
                binary.append(1);
                num = r - 1;
            } else {
                binary.append(0);
                num = r;
            }
        }
        return binary.toString();
    }

    public static String printBinary2(double num) {
        if (num >= 1 || num <= 0) {
            return "ERROR";
        }

        StringBuilder binary = new StringBuilder();
        double frac = 0.5;
        binary.append(".");
        while (num > 0) {
            /* Setting a limit on length: 32 characters */
            if (binary.length() >= 32) {
                return "ERROR";
            }
            if (num >= frac) {
                binary.append(1);
                num -= frac;
            } else {
                binary.append(0);
            }
            frac /= 2;
        }
        return binary.toString();
    }
}
