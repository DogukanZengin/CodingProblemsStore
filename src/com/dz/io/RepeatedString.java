package com.dz.io;

import java.util.regex.Matcher;

/**
 * Lilah has a string, , of lowercase English letters that she repeated infinitely many times.
 * Given an integer, , find and print the number of letter a's in the first  letters of Lilah's infinite string.
 * For example, if the string  and , the substring we consider is , the first  characters of her infinite string.
 * There are  occurrences of a in the substring.
 */
public class RepeatedString {

    static long repeatedString(String s, long n) {

        String filtered = s.replaceAll("[^a]","");
        long factor = (n/s.length());
        long count = filtered.length() * factor;
        long rem = n % s.length();
        count += s.substring(0, (int) rem).replaceAll("[^a]","").length();
        return count;

    }

    static long repeatedString2(String s, long n){
        long count =0;
        for(char c : s.toCharArray())
            if(c == 'a')
                count++;
        long factor = (n/s.length());
        long rem = (n%s.length());
        count =  factor*count  ;
        for(int i=0;i<rem;i++)
            if(s.charAt(i)=='a')
                count++;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(repeatedString("ojowrdcpavatfacuunxycyrmpbkvaxyrsgquwehhurnicgicmrpmgegftjszgvsgqavcrvdtsxlkxjpqtlnkjuyraknwxmnthfpt",685118368975L));
    }
}
