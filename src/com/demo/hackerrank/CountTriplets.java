package com.demo.hackerrank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {

    static long countTriplets(List<Long> arr, long r) {
        /*
        # stores number of tuples with two elements that can be formed if we find the key
         */
        Map<Long, Long> t2 = new HashMap<>();
        /*
         # stores number of tuples with three elements that can be formed if we find the key
         */
        Map<Long, Long> t3 = new HashMap<>();
        long result = 0L;

        for (Long a : arr) {
            /*
             # k completes the three tuples given we have already found k/(r^2) and k/r
             */
            result += t3.getOrDefault(a, 0L);
            if (t2.containsKey(a)) {
            /*
              # For any element of array we can form three element tuples if we find k*r given k / r is already found. Also k forms the second element.
             */
                t3.put(a * r, t3.getOrDefault(a * r, 0L) + t2.get(a));
            }
            /*
             # For any element of array we can form two element tuples if we find k*r. Also k forms the first element.
             */
            t2.put(a * r, t2.getOrDefault(a * r, 0L) + 1);
        }
        return result;
    }
}
