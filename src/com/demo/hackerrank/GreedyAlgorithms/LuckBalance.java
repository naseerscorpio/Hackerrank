package com.demo.hackerrank.GreedyAlgorithms;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LuckBalance {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
        int result = 0;
        int total = 0;
        List<Integer> importantContests = new ArrayList<>();
        for (int i = 0; i < contests.length; i++) {
            int luck = contests[i][0];
            int importance = contests[i][1];
            total += luck;
            if (importance == 1) {
                importantContests.add(luck);
            }
        }
        Collections.sort(importantContests);
        int mustWinImprContest = importantContests.size() - k;
        int luckToSubtract = 0;
        for (int i = 0; i < mustWinImprContest; i++) {
            luckToSubtract += importantContests.get(i);
        }
        //this is bcoz total is calculated assuming she lost all contests in the beginning
        // when she must win these, initial loss is compensated and then L is decreased
        result = total - 2 * luckToSubtract;
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
