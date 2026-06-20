// take 3 input numbers and verify these 3 values are sides of the triangle
/**
 * i/p values:  a, b, c
 * then conditions should be satisfied
 * 1> a+b > c
 * 2> b+c > a
 * 3> c+a > b
 * 
 * above three three conditions should be satisfied
*/

import java.util.Scanner;

public class SideOfTriangles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double side1 = sc.nextDouble();
        double side2 = sc.nextDouble();
        double side3 = sc.nextDouble();
        sc.close();   // scanner resourse management
        VerifySideOfTriange verify = new VerifySideOfTriange(side1, side2, side3);
        verify.checkedMessage();
    }
}

class VerifySideOfTriange {
    public VerifySideOfTriange(double a, double b, double c) {
        System.out.println("Constructor called for checking :");

        if(((a+b) > c) && ((b+c) > a) && ((c+a) > b))
            System.out.println("Verified that these are side of a triangle.");
        else
            System.out.println("verified that these are not sides of a triangle.");
    }
    public void checkedMessage() {
        System.out.println("Checking completed");
    }

    
}
