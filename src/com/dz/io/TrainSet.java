package com.dz.io;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given a dataset consisting of N items. Each item is a pair of a word and a boolean denoting whether the given word is a spam word or not.
 *
 * We want to use this dataset for training our latest machine learning model. Thus we want to choose some subset of this dataset as training dataset. We want to make sure that there are no contradictions in our training set, i.e. there shouldn't be a word included in the training set that's marked both as spam and not-spam. For example item {"fck", 1}, and item {"fck, 0"} can't be present in the training set, because first item says the word "fck" is a spam, whereas the second item says it is not, which is a contradiction.
 *
 * Your task is to select the maximum number of items in the training set.
 *
 * Note that same pair of {word, bool} can appear multiple times in input. The training set can also contain the same pair multiple times.
 *
 * Input
 * First line will contain T, number of test cases. Then the test cases follow.
 * The first line of each test case contains a single integer N.
 * N lines follow. For each valid i, the i-th of these lines contains a string wi, followed by a space and an integer(boolean) si, denoting the i-th item.
 */
public class TrainSet {

    public static void main(String[] args) throws Exception{
        BufferedReader k=new BufferedReader(new InputStreamReader(System.in));
        int testCount=Integer.parseInt(k.readLine());
        Map<String,ScamContainer> container;
        while(testCount-- > 0){
            int N = Integer.parseInt(k.readLine());
            container =  new HashMap<>();
            for(int i = 0;i<N;i++){
                ScamContainer scam = new ScamContainer();
                String[] str =k.readLine().split(" ");
                String word = str[0];
                boolean isScam = str[1].equals("1");
                if(container.containsKey(word)){
                    container.get(word).increaseCount(isScam);
                }else{
                    scam.increaseCount(isScam);
                    container.put(word,scam);
                }
            }
            System.out.println(container.values().stream().mapToInt(scam -> Math.max(scam.falseCount,scam.trueCount)).sum());
        }
    }
}

class ScamContainer{
    int trueCount;
    int falseCount;

    void increaseCount(boolean isScam){
        if(isScam){
            trueCount++;
        }else{
            falseCount++;
        }
    }
}