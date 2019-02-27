package com.demo.crackingcodinginterview;

public class RotateMatrix {

    private void rotate(int[][] matrix) {
        int N = matrix.length;
        // Consider all squares one by one
        for (int layer = 0; layer < N / 2; layer++) {
            int first = layer;
            int last = N - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                //save top
                int top = matrix[first][i];
                //left -> top
                matrix[first][i] = matrix[last - offset][first];
                //bottom -> left
                matrix[last - offset][first] = matrix[last][last-offset];
                //right -> bottom
                matrix[last][last-offset] = matrix[i][last];
                //top -> right
                matrix[i][last] = top;
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

    public static void main(String[] args) {
        RotateMatrix rotateMatrix = new RotateMatrix();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateMatrix.rotate(matrix);
    }
}
