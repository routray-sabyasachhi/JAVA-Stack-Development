package Pattern_Printing;

import java.util.Scanner;

public class HollowPyramid {
    public static void main(String[] args) {
        System.out.print("Enter the size of Hollow Pyramid : ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.close();

        printHollowPyramid(size);
    }

    public static void printHollowPyramid(int size) {

    for (int i = 1; i <= size; i++) {

        // Leading spaces
        for (int j = 1; j <= size - i; j++) {
            System.out.print(" ");
        }

        // First row
        if (i == 1) {
            System.out.println("*");
        }

        // Last row
        else if (i == size) {
            for (int j = 1; j <= 2 * size - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Middle rows
        else {
            System.out.print("*");

            for (int j = 1; j <= 2 * i - 3; j++) {
                System.out.print(" ");
            }

            System.out.print("*");
            System.out.println();
        }
    }
}
}
