package Java.Packages.Basic_Calculation;

public class Division {
    // Divides the first number by the second number.
    public double divideTwoNumbers(double firstNumber, double secondNumber) {
        if (secondNumber == 0) {
            System.out.println("Cannot divide by zero");
            return 0;
        }

        return firstNumber / secondNumber;
    }
}
