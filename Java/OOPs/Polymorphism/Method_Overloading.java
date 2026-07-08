package Java.OOPs.Polymorphism;

public class Method_Overloading {

    void add(int a, int b){
        System.out.println("Sum = " + (a+b) );
    }

    void add(int a, int b, int c) {
        System.out.println("Sum = " + (a+b+c));
    }
    public static void main(String[] args) {
        System.out.println("Method Overloading");
        Method_Overloading obj = new Method_Overloading();
        obj.add(10, 20);
        obj.add(10, 20, 30);
    }
}
