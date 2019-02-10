package com.demo.hackerrank.WarmUp;

import java.io.IOException;
import java.util.Scanner;

public class CountingValleys {


    static int countingValleys(int n, String s) {

        int valleys = 0;
        int mountains = 0;

        int counter = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'U') {
                counter++;
            } else {
                counter--;
            }
            if (counter == 0) {
                if (ch == 'D') {
                    mountains++;
                } else {
                    valleys++;
                }
            }
        }
        return valleys;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        System.out.println(result);

        scanner.close();
    }
}
