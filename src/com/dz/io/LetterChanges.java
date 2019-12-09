package com.dz.io;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Have the function LetterChanges(str) take the str parameter being passed and modify it using the following algorithm.
 * Replace every letter in the string with the letter following it in the alphabet (ie. c becomes d, z becomes a).
 * Then capitalize every vowel in this new string (a, e, i, o, u) and finally return this modified string.
 */
public class LetterChanges {

    public static String change(String str, int shiftAmount) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e','i','o','u'));
        char[] chars = str.toCharArray();
        for(int i = 0;i<chars.length;i++){
          if(chars[i] >= 97 && chars[i] <= 122){ // [a,z] is [97,122]
              chars[i] = (char) ((chars[i]+shiftAmount -97) % 26 + 97); // loop in a range = ((value + increaseAmount - min) % range) + min
              if(vowels.contains(chars[i])){
                  chars[i] = (char) (chars[i] -32);
              }
          }
        }
        return String.valueOf(chars);
    }

    public static void main (String[] args) {
        System.out.println(change("abcdefz",1));
    }
}
