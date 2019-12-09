package com.dz.io;

/**
 * Have the function LongestWord(sen) take the sen parameter being passed and return the largest word in the string.
 * If there are two or more words that are the same length, return the first word from the string with that length.
 * Ignore punctuation and assume sen will not be empty.
 */
public class LongestWord {

    public static String LongestWord(String sen) {
        String[] words = sen.split(" ");
        String longest = "";
        for(String word : words){
            if(word.replaceAll("\\p{Punct}","").length() > longest.length()){
                longest = word;
            }
        }
        return longest;
    }

    public static String LongestWordEnhanced(String sen) {
        String[] words = sen.toLowerCase().split("[^A-Za-z0-9]"); // Split with whitespace and punctuation from the beginning;
        String longest= "";
        for(String word : words){
            if(word.length() > longest.length()){
                longest = word;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(".,;;&dogu".replaceAll("\\p{Punct}",""));
    }
}
