package com.demo.hackerrank.Search;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IceCreamParlour {

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < cost.length; i++) {
            int target = money - cost[i];
            if (map.containsKey(target)) {
                System.out.println();
                System.out.println(++i + " " + map.get(target));
            }
            map.put(cost[i], i + 1);
        }

    }

    private static int binarySearch(int[] arr, int element) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = right - (right - left) / 2;
            if (arr[mid] == element) {
                return mid;
            } else if (arr[mid] < element) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }
            whatFlavors(cost, money);
        }

        scanner.close();
    }
}
