package com.dz.io.datastructures;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringOps {

    static String isValid(String s) {
        Map<Character,Long> freqMap = s.chars().mapToObj(value -> (char) value).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        Long previous = freqMap.values().iterator().next();
        boolean tolerance = true;
        for (long value : freqMap.values()){
            if(previous != value){
                if(tolerance && (Math.min(previous,value) == 1 || Math.abs(previous-value)==1)){
                    tolerance =false;
                    continue;
                }
                return "NO";
            }
            previous = value;
        }

        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String a = scanner.nextLine();

        String isValid = isValid(a);
        System.out.println(isValid);
    }
}
