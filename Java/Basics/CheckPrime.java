
import java.util.Scanner;

public class CheckPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        sc.close();
        PrimeChecker obj = new PrimeChecker(number);
        String answer = obj.getAnswer();
        System.out.println(answer);
    }
}


class PrimeChecker {
    String answer = "Yes it is prime";
    public PrimeChecker(int number){
        if(number == 1) 
            System.out.println("It is a special number not-considered as prime");
        for(int i = 2; i * i <= number; i++) {
            if(number % i == 0){
                answer = "no it is not prime";
                break;
            }
        }
    }
    public String getAnswer(){
        return answer;
    }
}

