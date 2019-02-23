package com.demo.crackingcodinginterview;

public class CheckPermutation {

    private boolean checkPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] lettercounts = new int[128];//ASCII
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            lettercounts[c]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            int c = s2.charAt(i);
            lettercounts[c]--;
            if (lettercounts[c] < 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        CheckPermutation permutation = new CheckPermutation();
        System.out.println(permutation.checkPermutation("dcaab", "aabcd"));
    }
}
