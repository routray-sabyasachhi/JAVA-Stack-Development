public class Operator {
    public static void main(String[] args) {
        //  Differnt types of Operator

        int x = 10 , y = 5;

        //Arithmetic operator

        System.out.println(x+y);  // Addition
        System.out.println(x-y);  // Subtraction
        System.out.println(x*y);  // Multiplication
        System.out.println(x/y);  // Division
        System.out.println(x%y);  // Modulus

        // Comaparison operator (o/p: true/false)

        System.out.println(x>y);
        System.out.println(x<y);
        System.out.println(x<=y);
        System.out.println(x>=y);
        System.out.println((x==y));  // isEqual
        System.out.println(x != y);  // isNotEqual

        // Logical Operator (o/p: true/false)
        /*

        || -> logical "or" operator
        && -> Logical "And" operator
        !  -> Logical "Not" operator

        */

        // Increment / Decrement operator

        System.out.println(x--);
        System.out.println(x);
        System.out.println(++x);
        System.out.println(x);

        // Assignment Operator

        /*

        =  -> assignment operator
        += -> Addition assignment
        -= -> subtraction assignment
        *= -> Multiplication assignment
        /= -> Division Assignment
        %= -> Modulo Assignment

        */

        // Bitwise Operator
        /*
        
        &   ->  Bitwise AND
        |   ->  Bitwise OR
        ^   ->  Bitwise XOR
        ~   ->  Bitwise NOT
        <<  ->  Leftshift 
        >>  ->  Rightshift

        */

    }
}
