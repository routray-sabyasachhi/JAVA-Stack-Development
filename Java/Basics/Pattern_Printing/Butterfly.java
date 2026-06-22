package Pattern_Printing;

import java.util.Scanner;

public class Butterfly {
    public static void main(String[] args) {
        System.out.println("Enter size ofthe butterfly : ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.close();

        printButterfly(size);
        
    }


    private static void printButterfly(int n) {

    // Upper half
    for (int i = 1; i <= n; i++) {

        // Left stars
        for (int j = 1; j <= i; j++) {
            System.out.print("*");
        }

        // Middle spaces
        for (int j = 1; j <= 2 * (n - i); j++) {
            System.out.print(" ");
        }

        // Right stars
        for (int j = 1; j <= i; j++) {
            System.out.print("*");
        }

        System.out.println();
    }

    // Lower half
    for (int i = n - 1; i >= 1; i--) {

        // Left stars
        for (int j = 1; j <= i; j++) {
            System.out.print("*");
        }

        // Middle spaces
        for (int j = 1; j <= 2 * (n - i); j++) {
            System.out.print(" ");
        }

        // Right stars
        for (int j = 1; j <= i; j++) {
            System.out.print("*");
        }

        System.out.println();
    }
}
    
    }

