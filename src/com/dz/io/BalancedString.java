package com.dz.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Balanced strings are those who have equal quantity of 'L' and 'R' characters.
 *
 * Given a balanced string s split it in the maximum amount of balanced strings.
 *
 * Return the maximum amount of splitted balanced strings.
 */
public class BalancedString {

    static int balancedStringSplit(String s) {
            int total = 0, count = 0;
            for(int i = 0;i<s.length();i++){
                count += s.charAt(i) == 'R' ? 1 : -1;
                if(count == 0) total++;
            }

            return total;
    }

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        List<Character> characters = b.chars().mapToObj(operand -> (char) operand).collect(Collectors.toList());
        List<Character> extras = new ArrayList<>();
        for(int i = 0;i<a.length();i++){
            if(characters.contains(a.charAt(i))){
                characters.remove(Character.valueOf(a.charAt(i)));
            }else{
                extras.add(a.charAt(i));
            }
        }
        characters.addAll(extras);
        return characters.size();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        System.out.println(res);

        scanner.close();
    }
}
