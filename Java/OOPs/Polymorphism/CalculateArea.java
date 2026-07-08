package Java.OOPs.Polymorphism;
class Calculator{
    void calculation(int a, int b){
        System.out.println("parent calculation");
        System.out.println(a + " + " + b + " = " + (a+b));
    }
}
class ChildCalculator extends Calculator {
    @Override
    void calculation(int a, int b) {
        super.calculation(a, b);
        System.out.println("child calculation");
        System.out.println(a + " + " + b + " = " + (a+b));
    }
}

public class CalculateArea {
    public static void main(String[] args) {
        Calculator obj = new ChildCalculator();
        obj.calculation(10, 20);
    }
}
