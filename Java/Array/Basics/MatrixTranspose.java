package Java.Array.Basics;

public class MatrixTranspose {
    public static void main(String[] args) {
         int[][] arr1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] result = performMatrixTranspose(arr1);

        System.out.println("Transpose Matrix :");

        for (int[] row : result) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static int[][] performMatrixTranspose(int[][] arr1){
        int row = arr1.length;
        int column = arr1[0].length;
        int[][] result = new int[column][row];
        for(int i=0; i<row; i++) {
            for(int j=0; j< column; j++) {
                result[i][j] = arr1[j][i];
            }
        }
        return result;
    }
}
