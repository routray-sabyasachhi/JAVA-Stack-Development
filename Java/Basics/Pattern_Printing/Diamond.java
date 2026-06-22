package Pattern_Printing;

import java.util.Scanner;

public class Diamond {
    public static void main(String[] args) {
        System.out.print("Enter the size of Diamond : ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.close();
        printDiamondUpper(size);
        printLowerDiamond(size - 1);
    }

    public static void printDiamondUpper(int size) {
        for(int i = 1; i <= size; i++) {
            for(int j = 1; j <= size-i; j++){
                System.out.print(" ");
            }
            for(int j = 1; j <= 2 * i - 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void printLowerDiamond(int size) {
        for(int i = size; i >= 1; i--) {
            for(int j = 0; j <= size - i; j++){
                System.out.print(" ");
            }
            for(int j = 2 * i - 1; j >= 1; j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
