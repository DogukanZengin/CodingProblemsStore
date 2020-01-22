package com.dz.io;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SherlockAnagrams {


    static List<String> createSubStrings(String expression){
        List<String> subs = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            for (int j = i+1; j <= expression.length(); j++) {
                subs.add(sort(expression.substring(i,j)));
            }
        }
        return subs;
    }

    static String sort(String s){
        return s.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    static Map<String,Long> createFrequencyMap(String expression){
        List<String> subs = createSubStrings(expression);
        return subs.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
    }

    static Long calculatePerms(Long n){
        return (n * (n-1))/2;
    }

    static int sherlockAndAnagrams(String expression){
        Map<String,Long> frequencyMap = createFrequencyMap(expression);
        int count = 0;
        for(Long c : frequencyMap.values()){
            count += calculatePerms(c);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(sherlockAndAnagrams("kkkk"));
    }
}
