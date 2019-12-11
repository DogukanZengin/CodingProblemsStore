package com.dz.io;

import java.util.HashSet;
import java.util.Set;

public class UniqueCharacterString {

    public static boolean isUnique(String s){
        for(int i = 0;i<s.toCharArray().length-1;i++){
            if(s.indexOf(s.charAt(i),i+1) > -1){
                return false;
            }
        }
        return true;
    }

    public static boolean isUniqueAlt(String s){
        Set<Character> characterSet = new HashSet<>();
        for(int i = 0;i<s.length()-1;i++){
            if(!characterSet.add(s.charAt(i))){
                return false;
            }
        }
        return true;
    }

    //Bit Vector usage
    public static boolean isUniqueChars(String str) {
        if (str.length() > 26) { // Only 26 characters
            return false;
        }
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false;
            checker = checker | (1 << val);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUnique("abcde"));
        System.out.println(isUniqueAlt("abcde"));
        System.out.println(isUniqueChars("erterfdge"));

    }
}
