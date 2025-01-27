package org.leetcode;

import java.util.*;

/*
* LeetCode:- https://leetcode.com/problems/word-ladder/
*
* */
public class WordLadder {
    public class Pair {
        String word;
        int ladderLength;

        public Pair(String word, int ladderLength) {
            this.word = word;
            this.ladderLength = ladderLength;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<Pair> pairs = new LinkedList<>();

        pairs.add(new Pair(beginWord,1));
        wordSet.remove(beginWord);
        while(!pairs.isEmpty()){
            String word = pairs.peek().word;
            int len = pairs.peek().ladderLength;
            pairs.remove();
            if(word.equals(endWord)) return len;
            for(int i =0; i < word.length(); i++){
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] wordArray = word.toCharArray();
                    wordArray[i] = ch;
                    String newWord=  new String(wordArray);
                    if(wordSet.contains(newWord)){
                        pairs.add(new Pair(newWord,len+1));
                        wordSet.remove(newWord);
                    }
                }
            }

        }

        return 0;
    }

    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();
        System.out.println(wordLadder.ladderLength("hit","cog", List.of("hot","dot","dog","lot","log","cog")));
    }
}
