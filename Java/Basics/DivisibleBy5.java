
import java.util.Scanner;

class MyDivisibility {
    String answer;  // by default compiler initiate to null this is best feature of java

    public  MyDivisibility(int number){   // constructor

        // we can findout by modulus operator and we go through the unit place mathematical formula
        if((number % 10) == 0 || (number % 10) == 5)
            answer = "Divisible By 5";
        else
            answer = "Not Divisible By 5";
    }
    
    public String findAnswer(){
        return answer;
    }
}

public class DivisibleBy5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter positive integer to check, Is it divisible by 5(Yes/No) ? ");
        int number = sc.nextInt();

        sc.close();   // resourse management

        // user defined class making (here we can write but for practice we make user defined function inde user defined class)
        MyDivisibility self = new MyDivisibility(number);

        String answer = self.findAnswer(); 
        System.out.println(answer);
    }
}
