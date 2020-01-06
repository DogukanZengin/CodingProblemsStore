package com.dz.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Starting with a 1-indexed array of zeros and a list of operations,
 * for each operation add a value to each of the array element between two given indices, inclusive.
 * Once all operations have been performed, return the maximum value in your array.
 */
public class ArrayManipulation {

    /*This can be calculated by calculating every index value in the array normally
        But this wont be time efficient. Instead just calculate boundary values with a positive and
        negative value of k, so the array will become a slope of increase rate.
        After this just loop through the array and create a sum of values, when that sum is at maximum value
        this is the maximum
     */
    static long arrayManipulation(int n, int[][] queries) {
        long[] container = new long[n+1];
        for (int[] query : queries) {
            container[query[0]-1] += query[2];
            container[query[1]] -= query[2];
        }
        long sum = 0;
        long max = 0;
        for (int i = 0; i < n; i++) {
            sum += container[i];
            max = Math.max(max, sum);
        }
        return max;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
