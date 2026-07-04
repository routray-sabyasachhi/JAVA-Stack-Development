import java.util.Scanner;

public class Input_Scanner_Methods {
    public static void main(String[] args) {

        // Scanner object created
        Scanner sc = new Scanner(System.in);

        //Taking input like int, double, float, char, long
        int Int = sc.nextInt();
        System.out.println(Int);
        float Float = sc.nextFloat();
        System.out.println(Float);
        double Double = sc.nextDouble();
        System.out.println(Double);
        char Char = sc.next().charAt(0);   //next() read string untill any delimeter found (like white-space)
        System.out.println(Char);
        long Long = sc.nextLong();
        System.out.println(Long);
        String firstName = sc.next();
        System.out.println(firstName);
        String fullName = sc.nextLine();
        System.out.println(fullName);


        sc.close();   //Resourse  management
    }
}
