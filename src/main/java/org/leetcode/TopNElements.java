package org.leetcode;

import java.util.*;

public class TopNElements {

    public static class ComparatorClass implements Comparator<Pair>{
        @Override
        public int compare(Pair pair1, Pair pair2) {
            return Integer.compare(pair2.count, pair1.count);
        }
    }
    public static class Pair {
        String word;
        int count;

        public Pair(String word, int count){
            this.word = word;
            this.count= count;
        }
    }
    public static void main(String[] args) {
        List<String> words = List.of("abc","abc","xyz","xyz","xyz","fas","fas");
        Map<String, Integer> wordCounter = new HashMap<>();


        for(String word: words){
            int count =1;
            if(wordCounter.containsKey(word)){
                count = wordCounter.get(word) + 1;
            }
            wordCounter.put(word,count);
        }


        ComparatorClass comparatorClass = new ComparatorClass();
        PriorityQueue<Pair> pairs = new PriorityQueue<>(comparatorClass);
        for(String key : wordCounter.keySet()){
            pairs. add(new Pair(key, wordCounter.get(key)));
        }
        System.out.println(pairs.poll().word);
        System.out.println(pairs.poll().word);
    }
}
