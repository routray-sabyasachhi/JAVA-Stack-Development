
import java.util.Scanner;

public class AreaOfCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the radius: ");
        double radius = sc.nextDouble();
        double area = 3.141592 * radius * radius;
        System.out.println("Area of the Circle : " + area);
    }
}
