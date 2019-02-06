package com.demo.hackerrank;

import java.util.HashMap;
import java.util.Map;

public class SherlockAndValidString {


    static String isValid(String s) {
        Map<Character, Integer> lettercounts = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (char c : s.toCharArray()) {
            if (lettercounts.containsKey(c)) {
                lettercounts.put(c, lettercounts.get(c) + 1);
            } else {
                lettercounts.put(c, 1);
            }
            max = Math.max(max, lettercounts.get(c));
        }

        for (Map.Entry m : lettercounts.entrySet())
            min = Math.min(min, (int) m.getValue());

        int maxCount = 0;
        int minCount = 0;
        for (int count : lettercounts.values()) {
            if (count == max) {
                maxCount++;
            } else if (count == min) {
                minCount++;
            }
        }

        if (max - min == 0 || (maxCount == lettercounts.size() - 1 && min == 1)
                || (minCount == lettercounts.size() - 1 && max - min == 1)) {
            return "YES";
        }
        return "NO";
    }

}
