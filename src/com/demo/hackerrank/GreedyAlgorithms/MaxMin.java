package com.demo.hackerrank.GreedyAlgorithms;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MaxMin {

    // Complete the maxMin function below.
    static int maxMin(int k, int[] arr) {
        Arrays.sort(arr);
        int minu = arr[arr.length-1];
        int num=0;
        //iterate over all subarrs
        for(int i =0;i<=arr.length-k;i++)
        {
            num = arr[i+k-1] - arr[i];
            if(num <= minu)
            {
                minu = num;
            }
        }
        return minu;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int[] a = new int[]{1,2,3,4,10,20,30,40,100,200};
        maxMin(4,a);
    }
}

