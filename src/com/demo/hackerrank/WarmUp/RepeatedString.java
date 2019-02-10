package com.demo.hackerrank.WarmUp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RepeatedString {

    static long repeatedString(String s, long n) {
        long numOfS = n / s.length();
        long rest = n % s.length();

        if (!s.contains("a")) return 0;
        return s.length() > n ? aCounter(s, rest)
                : numOfS * aCounter(s, s.length()) + aCounter(s, rest);
    }

    private static long aCounter(String s, long end) {
        int a = 0;
        for (int i = 0; i < end; i++) {
            if (s.charAt(i) == 'a') a++;
        }
        return a;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s = scanner.nextLine();

        long n = scanner.nextLong();

        long result = repeatedString(s, n);

        System.out.println(result);
        scanner.close();
    }
}
