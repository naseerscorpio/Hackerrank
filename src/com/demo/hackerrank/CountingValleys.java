package com.demo.hackerrank;

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
}
