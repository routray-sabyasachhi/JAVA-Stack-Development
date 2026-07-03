package Java.Method;

class Mobile {
    String model;
    String price;
    static String type;

    static {   
        // this is call only once before object creation.
        type = "phone";
    }

    public void show(){
        System.out.println(model + " : " + price + " : " + type);
    }

}

public class Static_Concepts {
    public static void main(String[] args) {
        Mobile obj1 = new Mobile();
        obj1.model = "Apple";
        obj1.price = "1500";

        Mobile.type = "Smartphone";  // static Instace variable can be accessed by class name and made only copy for every objects

        Mobile obj2 = new Mobile();
        obj2.model = "Vivo";
        obj2.price = "170";

        obj1.show();
        obj2.show();
    }
}

/**
 * In static method only static variable can be accessed but other instace variable cant accessed .
 * it is because for static variable for every object creates only onr copy and shared between all objects so no confusion,
 * but for other variable make separate copy for every object so compiler got confused 
 * 
 * we can access other member variables if we pass the objects to the static method.
 */
