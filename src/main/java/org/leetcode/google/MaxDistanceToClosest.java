package org.leetcode.google;

public class MaxDistanceToClosest {

    int maxDistToClosest(int [] seats) {
        // Write your code here.
        int i, j, res = 0, n = seats.length;
        for (i = j = 0; j < n; ++j)
            if (seats[j] == 1) {
                res = i > 0 ? Math.max(res, (j - i + 1) / 2) : j;
                i = j + 1;
            }
        res = Math.max(res, n - i);
        return res;
    }

//    public int maxDistToClosest(int[] seats) {
//        // Write your code here.
//        int[] arr = new int[seats.length];
//        int lastIndexOf1=-1;
//        int res = 0;
//
//        int n = seats.length;
//        for(int i=0;i<seats.length;i++){
//            if(seats[i]==1){
//                lastIndexOf1=i;
//                arr[i]=1;
//            }else {
//                arr[i] = lastIndexOf1 == -1 ? n : i - lastIndexOf1;
//            }
//        }
//        lastIndexOf1=-1;
//        for(int i=seats.length-1;i >= 0;i--){
//            if(seats[i]==1){
//                lastIndexOf1=i;
//            }else {
//                arr[i] = Math.min(arr[i], lastIndexOf1 == -1 ? n : lastIndexOf1 -i);
//                res = Math.max(res, arr[i]);
//            }
//
//        }
//        return res;
//    }

    public static void main(String[] args) {
        MaxDistanceToClosest maxDistanceToClosest = new MaxDistanceToClosest();
//        int[] arr = new int[]{1,1,0,0,1};
//        int[] arr = new int[]{1,0,0,0};
//        int[] arr = new int[]{0,0,1,0,1};


        int[] arr = new int[]{1,0,0,0,1,0,1};
        System.out.println(maxDistanceToClosest.maxDistToClosest(arr));
    }
}
