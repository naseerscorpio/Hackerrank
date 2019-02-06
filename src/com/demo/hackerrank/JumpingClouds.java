package com.demo.hackerrank;

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
}
