package com.demo.hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SherlockAndAnagrams {


    static int sherlockAndAnagrams(String s) {
        int count = 0;
        //for each length of sliding window
        for (int i = 1; i < s.length(); i++) {
            //starting  index
            Map<String, Integer> found = new HashMap<>();
            for (int j = 0; j + i < s.length(); j++) {
                String substr = s.substring(j, j + i);
                substr = Arrays.stream(substr.split("")).sorted()
                        .collect(Collectors.joining(""));
                if (found.containsKey(substr)) {
                    count += found.get(substr);
                    found.put(substr, found.get(substr) + 1);
                } else {
                    found.put(substr, 1);
                }
            }
        }
        return count;
    }
}
