
import java.util.Scanner;

public class TakeInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number : ");
        int userInput = sc.nextInt();
        sc.close();   // resourse management
        System.out.println("Entered Input is : " + userInput);
    }
}