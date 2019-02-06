package com.demo.hackerrank;

import java.util.HashMap;
import java.util.Map;

public class SockMerchant {

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

    }
}
