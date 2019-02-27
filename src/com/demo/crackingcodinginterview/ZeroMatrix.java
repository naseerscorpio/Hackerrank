package com.demo.crackingcodinginterview;

import java.util.ArrayList;
import java.util.List;

public class ZeroMatrix {

    /*
            [1,0,3                      [0,0,0
             0,5,6  -->                  0,0,0
             7,8,9]                      0,0,9]
     */

    private void zeroMatrix(int[][] matrix) {
        List<Tuple2> zeroCoordinates = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroCoordinates.add(new Tuple2(i, j));
                }
            }
        }

        for (Tuple2 pair : zeroCoordinates) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][pair.y] = 0;
            }
            for (int i = 0; i < matrix[pair.x].length; i++) {
                matrix[pair.x][i] = 0;
            }
        }

        displayMatrix(matrix);
    }

    private void displayMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private class Tuple2 {
        private int x;
        private int y;

        public Tuple2(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        ZeroMatrix zeroMatrix = new ZeroMatrix();
        int[][] matrix = {{1, 0, 3}, {5, 5, 6}, {7, 8, 9}};
        zeroMatrix.zeroMatrix(matrix);
    }
}
