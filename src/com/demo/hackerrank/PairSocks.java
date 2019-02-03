package com.demo.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class PairSocks 
{
    private static final Scanner scanner = new Scanner(System.in);
    
    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {

        Map<Integer,Integer> map = new HashMap();
        int result = 0;
        int count = 0;
        for (int i : ar) {
            if(!map.containsKey(i)){
                map.put(i, 1);
            }else {
                map.put(i,map.get(i)+1);
            }
        }

        for (int key:map.keySet()) {
            result += map.get(key) / 2 ;
        }
        return result;
    }


    public static void main( String[] args ) throws Exception
    {

        int n = 10;

        String[] arItems = {"1", "1", "3", "1", "2", "1", "3", "3", "3", "3"};

        int[] ar = new int[n];

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);
        System.out.println(result);

    }
}
