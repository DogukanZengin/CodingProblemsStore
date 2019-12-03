package com.dz.io;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *
 * Given two integers x and y, calculate the Hamming distance.
 */
public class HammingDistance {

    public static void main(String[] args) {
        hammingDistanceBitShifting(2323,2);
    }

    /**
     * Unefficient String formatting solution
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance(int x, int y) {
        String xB = String.format("%32s",Integer.toBinaryString(x)).replace(" ","0");
        String yB = String.format("%32s",Integer.toBinaryString(y)).replace(" ","0");
        System.out.println(xB);
        int distance = 0;
        int length = Math.max(xB.length(),yB.length());
        for(int i = 0;i<length;i++){
            if(xB.charAt(i) != yB.charAt(i)){
                distance++;
            }
        }
        return distance;
    }

    /**
     * Efficient solution with bit manipulation
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistanceBitShifting(int x, int y) {
        int xor = x ^ y, count = 0;
        for (int i=0;i<32;i++) {
            count += (xor >> i) & 1;
        }
        return count;
    }
}
