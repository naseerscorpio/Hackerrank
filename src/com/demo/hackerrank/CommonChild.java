package com.demo.hackerrank;

public class CommonChild {

    /*
     1. Recursive Solution
     2. Memorize Intermediate results
     3. Bottom-up
  */
    static int commonChild(String a, String b) {
        int C[][] = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    C[i + 1][j + 1] = 1 + C[i][j];
                } else {
                    C[i + 1][j + 1] = Math.max(C[i + 1][j], C[i][j + 1]);
                }
            }
        }
        return C[a.length()][b.length()];
    }
}
