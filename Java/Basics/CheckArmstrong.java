/**
 * Armstrong number
 * 
 * i/p: 123
 * output: false
 * ex: (1*1*1) + (2*2*2) + (3*3*3) = 36 
 * 
 * i/p: 9474
 * o/p: true
 * ex: (9*9*9*9) + (4*4*4*4) + (7*7*7*7) + (4*4*4*4) = 9474
 * 
 */
import java.util.Scanner;


public class CheckArmstrong {
    public static void main(String[] args) {
        System.out.print("Enter a number to check Armstrong or not : ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        sc.close();

        // printing result

        if(isArmstrong(number))
            System.out.println("true");
        else
            System.out.println("false");
    }


    //This method finds the length/order of the number
    public static int order(int number) {
        int length = 0;
        while((number / 10) > 0){
            length++;
        }
        return length;
    }

    public static int power(int x, int y) {
        if(y == 0) 
            return 1;
        if(y % 2 == 0) 
            return power(x, y/2) * power(x, y/2);
        return x* power(x, y/2) * power(x, y/2);
    }


    public static boolean isArmstrong(int number) {

        // first find length of number
        int x = order(number);
        
        int temp = number, sum = 0;
        while(temp !=0) {
            int r = temp % 10;
            sum += power(r,x);
            temp = temp / 10;
        } 
        return sum == number;
    }
}
