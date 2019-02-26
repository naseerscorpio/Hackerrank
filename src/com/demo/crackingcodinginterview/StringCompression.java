package com.demo.crackingcodinginterview;

public class StringCompression {

    private String compress(String s1) {

        StringBuilder builder = new StringBuilder();
        int count = 1;
        for (int i = 1; i < s1.length(); i++) {
            if (s1.charAt(i) == s1.charAt(i - 1)) {
                ++count;
            } else {
                builder.append(s1.charAt(i - 1));
                builder.append(count);
                count = 1;
            }
        }
        builder.append(s1.charAt(s1.length() - 1));
        builder.append(count);

        return builder.toString().length() < s1.length() ? builder.toString() : s1;
    }

    public static void main(String[] args) {
        StringCompression stringCompression = new StringCompression();
        System.out.println(stringCompression.compress("aabcccccaab"));
    }
}
