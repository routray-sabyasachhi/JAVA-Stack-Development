package Java.OOPs.Polymorphism;

interface Animal {
    public void sound();
}
class Dog implements Animal {
    @Override
    public void sound(){
        // super.sound();  X because parent is not a class 
        System.out.println("Dog barks !");
    }
}

public class Method_Overriding {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.sound();
    }
}
