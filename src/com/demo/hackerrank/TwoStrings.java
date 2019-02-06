package com.demo.hackerrank;

public class TwoStrings {


    static String twoStrings(String s1, String s2) {
        boolean distinct = true;
        for (char c : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
            if (s1.indexOf(c) > 0 && s2.indexOf(c) > 0) {
                distinct = false;
                break;
            }
        }
        return distinct ? "Yes" : "No";
    }
}
