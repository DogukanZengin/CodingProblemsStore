package com.dz.io;


import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * One Away: There are three types of edits that can be performed on strings:
 * insert a character, remove a character, or replace a character.
 * Given two strings, write a function to check if they are one edit (or zero edits) away.
 */
public class StringCompression {

    static String compression(String s){
        char cursor = s.charAt(0);
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for(int i = 0;i<s.length();i++){
            if(cursor == s.charAt(i)){
                count++;
            }else if(count > 1){
                sb.append(cursor);
                sb.append(count);
                count = 1;
            }else{
                sb.append(cursor);
            }

            cursor = s.charAt(i);

        }
        sb.append(cursor);
        sb.append(count);
        return sb.toString().length() == s.length() ? s : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(compression("aaaaabbbccccccceaaaafffggfg"));
    }
}
