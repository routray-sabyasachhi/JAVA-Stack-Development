package Java.Array.Basics;

public class MatrixAddition {
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

        int[][] result = performMatrixAddition(arr1, arr2);

        System.out.println("Matrix Addition :");

        for (int[] row : result) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static int[][] performMatrixAddition(int[][] arr1, int[][] arr2) {
        int row = arr1.length;
        int column = arr1[0].length;
        int[][] resMatrix = new int[row][column];

        for(int i = 0; i< row; i++) {
            for (int j=0; j< column; j++){
                resMatrix[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        return resMatrix;
    }
}
