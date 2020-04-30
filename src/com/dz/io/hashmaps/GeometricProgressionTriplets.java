package com.dz.io.hashmaps;// you can use System.out.println for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * - I will start with second element in the list
 * - So on the left side of the current element a there must be at least one i which satisfies a/r = i with r being the common
 * - And on the right side there must be at least one j which satisfies a*r = j with r being the common
 * - Create two hashmaps with the values and their occurrences.
 * - For each element in the array check these statements and before proceeding to the next feed left and right maps accordingly
 */
public class GeometricProgressionTriplets {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());
        System.out.println(countGeometricProgression(arr,r));
    }

    public static Long countGeometricProgression(List<Long> arr, long r){

        Map<Long,Long> frequencyRight = createFrequencyMap(arr);
        Map<Long,Long> frequencyLeft = new HashMap<>();
        long count = 0L;

        for (Long current : arr) {
            frequencyRight.put(current, frequencyRight.get(current) -1);
            Long occurrenceRight = frequencyRight.getOrDefault(current * r,0L);
            Long occurrenceLeft = frequencyLeft.getOrDefault(current / r, 0L);
            occurrenceLeft = current%r != 0 ? 0 : occurrenceLeft;

            addOccurrence(frequencyLeft, current);

            count += occurrenceLeft * occurrenceRight;
        }

        return count;
    }

    public static Map<Long,Long> createFrequencyMap(List<Long> arr){
        return arr.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
    }

    public static void addOccurrence(Map<Long,Long> frequencyMap, Long value){

        if(frequencyMap.containsKey(value)){
            frequencyMap.put(value, frequencyMap.get(value) + 1);
        }else{
            frequencyMap.put(value, 1L);
        }
    }
}
