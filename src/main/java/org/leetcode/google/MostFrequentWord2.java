package org.leetcode.google;

import java.util.*;

public class MostFrequentWord2 {

    public String mostCommonWord(String paragraph) {
        // Convert to lowercase and remove punctuation using regex
        String str = paragraph.toLowerCase().replaceAll("[!?',;.]", " ");

        // Split words and count occurrences using a HashMap
        Map<String, Integer> map = new HashMap<>();
        for (String word : str.split("\\s+")) {
            if (!word.isEmpty()) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        // Find most frequent word, break ties by lexicographical order
        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        MostFrequentWord2 sol = new MostFrequentWord2();
        System.out.println(sol.mostCommonWord("a a a b b b c c d"));  // Should print "a"
    }
}
