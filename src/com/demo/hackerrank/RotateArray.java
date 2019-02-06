package com.demo.hackerrank;

public class RotateArray {


    static int[] rotLeft(int[] a, int d) {
        int[] rot = new int[a.length];
        int n = a.length;
        for (int i = 0; i < a.length; i++) {
            rot[(n + i - d) % n] = a[i];
        }
        return rot;
    }
}
