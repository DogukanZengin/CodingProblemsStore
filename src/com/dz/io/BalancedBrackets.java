package com.dz.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BalancedBrackets {


    static String isBalanced(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        Map<Character,Character> consequentMap = new HashMap<>();
        consequentMap.put('{','}');
        consequentMap.put('(',')');
        consequentMap.put('[',']');

        for(int i = 0;i<s.length();i++){
            char next = s.charAt(i);
            if(consequentMap.containsKey(next)){
                stack.push(next);
                continue;
            }

            if(consequentMap.containsValue(next)){
                if(!stack.isEmpty()){
                    char openingBracket = stack.pop();
                    if(!consequentMap.get(openingBracket).equals(next)){
                        return "NO";
                    }
                }else{
                    return "NO";
                }
            }
        }
        if(stack.isEmpty()){
            return "YES";
        }else{
            return "NO";
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            System.out.println(result);
        }


        scanner.close();
    }
}
