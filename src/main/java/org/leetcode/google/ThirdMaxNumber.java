package org.leetcode.google;

import java.util.TreeSet;

public class ThirdMaxNumber {

    public int thirdMax(int[] nums) {
        // Write your code here.

        TreeSet<Integer> set = new TreeSet<>();

        for (int num : nums) {
            set.add(num);
            if(set.size() > 3) {
                set.remove(set.first());
            }
        }

       return set.size() == 3 ? set.first() : set.last();
    }

    public static void main(String[] args) {
        ThirdMaxNumber thirdMaxNumber = new ThirdMaxNumber();
        System.out.println(thirdMaxNumber.thirdMax(new int[]{2, 2,3, 1}));
    }
}
