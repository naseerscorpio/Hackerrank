package com.demo.hackerrank;

public class CountSwaps {

    static void countSwaps(int[] a) {
        //[6,4,1]
        int swaps = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swaps++;
                }
            }
        }
        System.out.println(swaps);
    }
}
