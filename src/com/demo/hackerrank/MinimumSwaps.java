package com.demo.hackerrank;

public class MinimumSwaps {


    static int minimumSwaps(int[] arr) {
        int first = 0;
        int last = arr.length - 1;
        int swaps = 0;
        while (first < last) {
            while (arr[first] == first + 1 && first < last) {
                first++;
            }
            while (arr[last] == last + 1 && first < last) {
                last--;
            }

            if (first < last) {
                int temp = arr[arr[first] - 1];
                arr[arr[first] - 1] = arr[first];
                arr[first] = temp;
                swaps++;
            }
        }
        return swaps;
    }
}
