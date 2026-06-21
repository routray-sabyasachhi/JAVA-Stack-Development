package Pattern_Printing;
import java.util.Scanner;

public class RightTriangle {
    public static void main(String[] args) {
        System.out.print("Enter the height of Right angle triangle : ");
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        sc.close();
        trianlePrinting(height);
    }

    public static void trianlePrinting(int h) {
        for(int i = 1; i <= h ; i++) {
            for(int j = 1 ; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
