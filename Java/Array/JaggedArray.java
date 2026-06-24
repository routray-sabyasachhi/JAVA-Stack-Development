package Java.Array;

import java.util.Scanner;

public class JaggedArray {
    public static void main(String[] args) {
        int m = 3;
        System.out.print("Enter the columns for 3 row respectively");
        Scanner sc = new Scanner(System.in);
        int[][] jagged = new int[m][];
        for(int i=0; i<m;i++) {
            int n = sc.nextInt();
            jagged[i] = new int[n];   // for diffrent row creating diffrent size of column
        }
        sc.close();

        for(int i=0; i<m; i++) {
            for(int j=0; j<jagged[i].length;j++) {
                jagged[i][j] = 2*i + j;
            }
        }
        for(int i=0; i<m; i++) {
            for(int j=0; j<jagged[i].length;j++) {
                System.out.print(jagged[i][j] + " ");
            }
            System.out.println();
        }
    }
}
