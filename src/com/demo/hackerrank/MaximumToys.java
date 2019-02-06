package com.demo.hackerrank;

import java.util.Arrays;

public class MaximumToys {


    static int maximumToys(int[] prices, int k) {
        int count = 0;
        Arrays.sort(prices);
        Long sum = 0L;
        for (int price : prices) {
            sum += price;
            if (sum <= k) {
                count++;
            }
        }
        return count;
    }
}
