import java.util.Scanner;

class TakeAndIdentifyInteger {
    String reply;
    public TakeAndIdentifyInteger(){      //Constructor
        System.out.print("Enter a number to identify Integer or not ? ");
        Scanner sc = new Scanner(System.in);
        double number = sc.nextDouble();
        if( number == ((int) number))
            reply = "Input Number is Integer";
        else
            reply = "Anything Else Except Intger";

        sc.close();  // Scanner resourse management
    }
    public String getReply() {
        return reply;
    }
}

public class CheckInteger {
    public static void main(String[] args) {
        TakeAndIdentifyInteger checkInt = new TakeAndIdentifyInteger();

        System.out.println(checkInt.getReply());
    }
}
