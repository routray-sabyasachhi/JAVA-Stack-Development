package Pattern_Printing;
import java.util.Scanner;

public class NumberTriangle {
    public static void main(String[] args) {
        System.out.print("Enter height of Triangle : ");
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        sc.close();
        printNumberTriangle(height);
    }
    
    public static void printNumberTriangle(int h) {
        for(int i = 1; i<= h; i++) {
            for(int j = 1; j <= i; j++){
                System.out.print(j +" ");
            }
            System.out.println();
        }
    }
}
