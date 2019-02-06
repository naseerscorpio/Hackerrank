package com.demo.hackerrank;

public class ArrayManipulation {


    static long arrayManipulation(int n, int[][] queries) {
        long[] arr = new long[n];
        long max = 0;
        int a = 0;
        int b = 0;
        int k = 0;
        int m = queries.length;

        for (int i = 0; i < m; i++) {
            a = queries[i][0] - 1;
            b = queries[i][1] - 1;
            k = queries[i][2];
            arr[a] += k;
            if (b + 1 < n)
                arr[b + 1] -= k;
        }
        for (int i = 1; i < n; i++) {
            arr[i] += arr[i - 1];
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }
}
