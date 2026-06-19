import java.util.Scanner;

class MyFunction {
   public boolean checkOddEven(int number) {
        boolean res = true;
        if((number & 1 ) != 0 )
             res = false;
        return res;
    }
}

public class EvenOdd {
    public static void main(String[] args) {
        // to check odd or even
        Scanner sc = new Scanner(System.in);

        // Creating object for our MyFunction class to call its fuctions
        MyFunction check = new MyFunction();

        System.out.print("enter a number to check (Even/ Odd) : ");
        int number = sc.nextInt();
        boolean res = check.checkOddEven(number);

        // This is for user friendlyness
        if(res == true)
            System.out.println("Number "+ number+" is Even");
        else
            System.out.println("Number "+ number+" is Odd");
    }
}
