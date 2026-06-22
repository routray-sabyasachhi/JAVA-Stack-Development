package Pattern_Printing;

import java.util.Scanner;

public class HollowRectangle {
    public static void main(String[] args) {
        System.out.print("Enter the size of rectangle : ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.close();

        printHollowRectangle(size);
    }

    public static void printHollowRectangle(int n) {
        for (int i = 1; i <= n; i++) {
            //first row
            if(i == 1) {
                for(int j = 1; j <= n; j++){
                    System.out.print("*");
                }
            }

            // last row
            else if (i == n){
                for(int j = 1; j <= n; j++){
                    System.out.print("*");
                }
            }

            // middle row

            else {
                System.out.print("*");  // first boundary

                for(int j = 1; j <= n-2; j++){    // middle space printing
                    System.out.print(" ");
                }

                System.out.print("*");  // End boundary
            }

            System.out.println();
        }
    }
}
