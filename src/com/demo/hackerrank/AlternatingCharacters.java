package com.demo.hackerrank;

public class AlternatingCharacters {


    static int alternatingCharacters(String s) {
        if (s.length() <= 1) return 0;

        char s0 = s.toCharArray()[0];
        int deletions = 0;
        for (int i = 1; i < s.length(); i++) {
            char s1 = s.charAt(i);
            if (s0 == s1) {
                deletions++;
            }
            s0 = s1;
        }
        return deletions;
    }
}
