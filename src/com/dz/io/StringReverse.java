package com.dz.io;

public class StringReverse {

    public static String FirstReverse(String str) {
        char[] chars = str.toCharArray();
        for(int i = 0;i<chars.length/2;i++){
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
       return String.valueOf(chars);
    }

    public static String ReverseJApi(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static void main (String[] args) {
        System.out.print(FirstReverse("dogukanzengin"));
        System.out.println(ReverseJApi("dogukanzengin"));
    }
}
