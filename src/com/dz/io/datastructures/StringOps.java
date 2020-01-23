package com.dz.io.datastructures;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringOps {


    /**
     * Two requirements here
     * - all characters must be appearing the same number of times
     *      ~ that means frequency map value is equal for all characters in the string
     * - all characters appear the same number of times when one character at any index is removed
     *      ~ one of the characters can be 1 occurrence or freqMapValue + 1 occurrence.
     */

    /**
     * First create a frequency map of characters.
     * Then create another frequency map of frequencies
     * Find the most frequent and less frequent of entries.
     * If size is 1 then this is valid
     * if size is more then two not valid, most frequent must be equal to frequency map's size minus 1, if not It is not valid
     * Less frequent entry must be 1 or just plus 1 to the most frequent, if not It is not valid
     */
    static String isValid(String s) {
        Map<Character,Long> freqMap = s.chars().mapToObj(value -> (char) value).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        Map<Long,Long> numFreqMap = new ArrayList<>(freqMap.values()).stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        Long mostFrequent = Collections.max(numFreqMap.entrySet(), (entry1, entry2) -> (int) (entry1.getValue() - entry2.getValue())).getKey();
        Long lessFrequent = Collections.min(numFreqMap.entrySet(), (entry1, entry2) -> (int) (entry1.getValue() - entry2.getValue())).getKey();

        if(numFreqMap.size() == 1){
            return "YES";
        }

        if(numFreqMap.size() > 2 ||
           numFreqMap.get(mostFrequent) != freqMap.size() - 1 ||
           (lessFrequent != 1 && lessFrequent - mostFrequent != 1)){
            return "NO";
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
