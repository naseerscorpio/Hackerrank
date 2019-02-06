package com.demo.hackerrank;

public class CountInversions {


    static long countInversions(int[] arr) {
        return countInversions(arr, 0, arr.length);
    }

    static long countInversions(int[] arr, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) return 0;

        long count = 0;

        int middle = (leftStart + rightEnd) / 2;
        count += countInversions(arr, leftStart, middle);
        count += countInversions(arr, middle + 1, rightEnd);
        count += merge(arr, leftStart, rightEnd);

        return count;
    }

    static long merge(int[] arr, int start, int end) {

        int mid = (start + end) / 2;
        int[] newArr = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = start;
        long count = 0;
        while (i <= mid && j <= end) {
            if (arr[i] > arr[j]) {
                newArr[k++] = arr[j++];
                count += mid - i + 1;
            } else {
                newArr[k++] = arr[i++];
            }
        }

        while (i <= mid) {
            newArr[k++] = arr[i++];
        }
        while (j <= end) {
            newArr[k++] = arr[j++];
        }

        System.arraycopy(newArr, 0, arr, start, end - start + 1);
        return count;
    }
}
