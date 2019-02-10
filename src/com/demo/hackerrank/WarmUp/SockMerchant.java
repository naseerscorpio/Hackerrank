package com.demo.hackerrank.WarmUp;

import java.util.HashMap;
import java.util.Map;

public class SockMerchant {

    // Can also be done using Set or simply using array
    static int sockMerchant(int n, int[] ar) {

        Map<Integer, Integer> map = new HashMap();
        int result = 0;
        int count = 0;
        for (int i : ar) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }

        for (int key : map.keySet()) {
            result += map.get(key) / 2;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {1,2,2,3,3,4,5,4};
        sockMerchant(8,input);
    }
}
