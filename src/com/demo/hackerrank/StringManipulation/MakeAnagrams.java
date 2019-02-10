package com.demo.hackerrank.StringManipulation;

import java.io.IOException;
import java.util.Scanner;

public class MakeAnagrams {

    static int makeAnagram(String a, String b) {
        int[] lettercounts = new int[26];
        for (char c : a.toCharArray()) {
            lettercounts[c - 'a']++;
        }
        for (char c : b.toCharArray()) {
            lettercounts[c - 'a']--;
        }
        int result = 0;
        for (int i : lettercounts) {
            result += Math.abs(i);
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        System.out.println(res);

        scanner.close();
    }




}
