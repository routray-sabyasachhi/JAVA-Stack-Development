package Pattern_Printing;

import java.util.Scanner;

public class SquarePrinting {
    public static void main(String[] args) {
        System.out.print("Enter the width of the square : ");
        Scanner sc = new Scanner(System.in);
        int width = sc.nextInt();
        sc.close();
        squarePrinting(width);
    }

    public static void squarePrinting(int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
