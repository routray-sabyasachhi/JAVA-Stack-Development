package Java.Packages.Advance_Calculation.Exponential;

public class Factorial{
    private  int answer = 1;
    public void findFactorial(int n){
        for(int i=1; i <= n; i++){
            answer *= i;
        }
        System.out.println("Answer = " +answer);
    }
}


