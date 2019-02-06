package com.demo.hackerrank;

import java.util.Arrays;

public class MinAbsoluteDifference {


    static int minimumAbsoluteDifference(int[] arr) {
        if (arr.length == 0) return 0;

        Arrays.sort(arr);
        /*
            As the array has been sorted, so we need to consider the difference between
            only the consecutive elements. In a sorted array, the difference will increase
            if you skip elements to calculate the difference.
         */
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            minDiff = Math.min(minDiff,Math.abs(arr[i]-arr[i-1]));
        }
        return minDiff;
    }
}
