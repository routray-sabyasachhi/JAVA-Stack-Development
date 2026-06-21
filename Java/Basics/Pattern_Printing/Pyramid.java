package Pattern_Printing;

import java.util.Scanner;

public class Pyramid {
    public static void main(String[] args) {
        System.out.print("Enter height of Pyramid : ");
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        sc.close();
        pyramidPrinting(height);
    }

    public static void pyramidPrinting(int h) {
        for(int i = 1; i <= h; i++) {
            for(int j = h-i ; j >= 1; j--) {
                System.out.print(" ");
            }
            for(int j = 2 * i - 1; j >= 1; j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
