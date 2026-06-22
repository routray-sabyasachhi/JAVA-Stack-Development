package Pattern_Printing;

import java.util.Scanner;

public class Zigzag {
    public static void main(String[] args) {
        System.out.print("Enter size of zigzag : ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.close();

        ZigZagPattern(size);
    }

    public static void ZigZagPattern(int n){

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= n; j++) {

                if ((i + j) % 4 == 0 ||
                    (i == 2 && j % 4 == 0)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
    }
}
