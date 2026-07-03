package Java.Array.Basics;


class A {

    public A() {
        System.out.println("Object created");
    }
    public void show() {
        System.out.println("In the object");
    }
}

public class Anonymous_Object {
    public static void main(String[] args) {

        new A().show();   // object creation 
        new A().show();   // new object created
        new A();
        // these are called anonymous objects
        
    }
}
