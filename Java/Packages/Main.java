package Java.Packages;

import Java.Packages.Advance_Calculation.Exponential.Pow2;
import Java.Packages.Advance_Calculation.Exponential.Factorial;
import Java.Packages.Advance_Calculation.Exponential.Power;
import Java.Packages.Advance_Calculation.Trigonometric_Function.Cos;
import Java.Packages.Advance_Calculation.Trigonometric_Function.Sin;
import Java.Packages.Basic_Calculation.Add;
import Java.Packages.Basic_Calculation.Division;
import Java.Packages.Basic_Calculation.Multiplication;
import Java.Packages.Basic_Calculation.Substraction;

public class Main {
    public static void main(String[] args) {
        // Basic_Calculation package classes are used for normal arithmetic operations.
        Add add = new Add();
        Substraction substraction = new Substraction();
        Multiplication multiplication = new Multiplication();
        Division division = new Division();

        System.out.println("Addition: " + add.addTwoNumbers(10, 5));
        System.out.println("Substraction: " + substraction.subtractTwoNumbers(10, 5));
        System.out.println("Multiplication: " + multiplication.multiplyTwoNumbers(10, 5));
        System.out.println("Division: " + division.divideTwoNumbers(10, 5));

        // Exponential package classes are used for factorial, square, and power operations.
        Factorial factorial = new Factorial();
        Pow2 square = new Pow2();

        System.out.println("Factorial: " + factorial.findFactorial(5));
        System.out.println("Square: " + square.findSquare(5));

        // Power has a static method, so we can call it directly with the class name.
        System.out.println("Power: " + Power.myPower(5, 2));

        // Trigonometric_Function package classes are used for sin and cos operations.
        Sin sin = new Sin();
        Cos cos = new Cos();

        double angleInRadians = Math.toRadians(30);

        System.out.println("Sin 30 degree: " + sin.findSin(angleInRadians));
        System.out.println("Cos 30 degree: " + cos.findCos(angleInRadians));
    }
}
