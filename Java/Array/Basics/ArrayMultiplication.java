package Java.Array.Basics;

public class ArrayMultiplication {
    public static void main(String[] args) {

        int[][] arr1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] arr2 = {
                {1, 4, 7},
                {2, 5, 8},
                {3, 6, 9}
        };

        int[][] result = matrixMultiplication(arr1, arr2);

        System.out.println("Matrix Multiplication:");

        for (int[] row : result) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static int[][] matrixMultiplication(int[][] arr1, int[][] arr2) {

        int rows1 = arr1.length;
        int cols1 = arr1[0].length;

        int rows2 = arr2.length;
        int cols2 = arr2[0].length;

        if (cols1 != rows2) {
            throw new IllegalArgumentException(
                    "Matrix multiplication not possible");
        }

        int[][] result = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return result;
    }
}