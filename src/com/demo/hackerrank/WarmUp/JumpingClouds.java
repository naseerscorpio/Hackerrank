package com.demo.hackerrank.WarmUp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class JumpingClouds {

    static int jumpingOnClouds(int[] c) {
        int steps = 0;
        int idx = 0;
        while (idx < c.length - 1) {
            if (idx + 2 < c.length && c[idx + 2] != 1) {
                steps++;
                idx += 2;
            } else {
                idx += 1;
                steps++;
            }
        }
        return steps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);
        System.out.println(result);

        scanner.close();
    }
}
