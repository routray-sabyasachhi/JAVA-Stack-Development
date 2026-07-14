package Java.Packages.Advance_Calculation.Exponential;

public class Factorial {
    // Finds factorial of a non-negative number.
    public int findFactorial(int number) {
        if (number < 0) {
            System.out.println("Factorial is not defined for negative numbers");
            return 0;
        }

        int answer = 1;

        for (int i = 1; i <= number; i++) {
            answer = answer * i;
        }

        return answer;
    }
}
