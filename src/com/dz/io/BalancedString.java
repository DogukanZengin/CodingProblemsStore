package com.dz.io;

/**
 * Balanced strings are those who have equal quantity of 'L' and 'R' characters.
 *
 * Given a balanced string s split it in the maximum amount of balanced strings.
 *
 * Return the maximum amount of splitted balanced strings.
 */
public class BalancedString {

    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRRLLRLL"));

    }

    static int balancedStringSplit(String s) {
            int total = 0, count = 0;
            for(int i = 0;i<s.length();i++){
                count += s.charAt(i) == 'R' ? 1 : -1;
                if(count == 0) total++;
            }

            return total;
    }
}
