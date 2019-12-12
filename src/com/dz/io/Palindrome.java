package com.dz.io;

import java.util.Set;
import java.util.stream.Collectors;

public class Palindrome {

    public static boolean isPalindromePermutation(String s) {
        int letterCount = s.length() / 2;
        if (s.length() % 2 == 0) {
            letterCount++;
        }
        Set<Character> characterSet = s.toLowerCase().chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
        return characterSet.size() == letterCount;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("Tact zoa"));
    }
}
