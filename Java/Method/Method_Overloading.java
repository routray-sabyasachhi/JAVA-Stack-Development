
package Java.Method;

class Calculator {

    public int add(int a, int b){
        return a+b;
    }

    public void add(int a, int b, int c) {
        System.out.println(a+b+c);
    }
    
    public double add(double a, int b){
        return a+b;
    }
}

public class Method_Overloading {
    public static void main(String[] args) {
        // method overloading means same method name and fucionality differ with number and types of parameter

        Calculator obj = new Calculator();
        int result = obj.add(1, 2);
        System.out.println(result);

        double addition = obj.add(15.25, 18);
        System.out.println(addition);
    }
}
