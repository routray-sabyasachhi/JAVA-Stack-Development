package Pattern_Printing;

import java.util.Scanner;

public class NumberPyramid {
    public static void main(String[] args) {
        System.out.print("enter the height of pyramid : ");
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        sc.close();

        printNumberPyramid(height);
    }

    // A private method can only be accessed within the same class.
    private static void printNumberPyramid(int h) {  
        for(int i = 1; i <= h; i++) {
            // beggening space printing
            for(int j = 1; j <= h - i; j++){
                System.out.print(" ");
            }
            // Increase number printing
            for(int j = 1; j <= i; j++){
                System.out.print(j);
            }
            //Decresing number printing
            for(int j = i - 1; j >= 1; j--) {
                System.out.print(j);
            }

            System.out.println();
        }
    }
}
