package Pattern_Printing;

import java.util.Scanner;

public class FloydTriangle {
    public static void main(String[] args) {
        System.out.print("Enter height of Floyd's Triangle : ");
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        sc.close();
        printFloydTriangle(height);
    }

    public static void printFloydTriangle( int h ) {
        int inc = 1;
        for(int i = 1; i <= h; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(inc + " ");
                inc++;
            }
            System.out.println();
        }
    }
}
