package org.leetcode.google;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {

    private final int size;
    private final Queue<Double> queue;
    private double sum;

    public MovingAverage(int size) {
        this.size = size;
        this.queue = new LinkedList<>();
        this.sum = 0;
    }

    public double next(int val) {
        queue.add((double) val);
        sum += val;

        if (queue.size() > size && !queue.isEmpty()) {
            sum -= queue.poll(); // Remove the oldest value
        }

        return sum / queue.size();
    }

    public static void main(String[] args) {
        MovingAverage ma = new MovingAverage(3);
        System.out.println(ma.next(1)); // Output: 1.0
        System.out.println(ma.next(10)); // Output: 5.5
        System.out.println(ma.next(3)); // Output: 4.67
        System.out.println(ma.next(5)); // Output: 6.0
    }

//    int size;
//    List<Double> list;
//    double sum = 0;
//    /*
//     * @param size: An integer
//     */
//    public MovingAverage(int size) {
//
//        // do intialization if necessary
//
//        this.size = size;
//        list = new ArrayList<>();
//    }
//
//    /*
//     * @param val: An integer
//     * @return:
//     */
//    public double next(int val) {
//        // write your code here
//        list.add((double) val);
//        sum += val;
//        if(list.size() >= size) {
//            sum -= list.get(list.size() - size - 1);
//
//            return sum / size;
//        }
//
//        return sum/list.size();
//
//
//    }
}
