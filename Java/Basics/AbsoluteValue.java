/**
 * Problem is that Finding Absolute value
 * if i/p: 5   o/p: 5
 * if i/p: -6  o/p: 6
 * 
 * means hamesa o/p positive main ayega
 */

import java.util.Scanner;
 /*  import java.math.*;
 It is un-necessary because  Math is part of lang package and it will be automatically imported */

class AbsoluteValueCalculator {
    int number;
    public void takeNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a integer number to find it's Absolute value : ");
        number = sc.nextInt();
        sc.close();   // resourse management
    }

    public void findAbsolute() {
        System.out.println("Absolute value is " + Math.abs(number));
    }
}


public class AbsoluteValue {
    public static void main(String[] args) {

        AbsoluteValueCalculator myClass = new AbsoluteValueCalculator();

        myClass.takeNumber();
        myClass.findAbsolute();
        
    }
}
