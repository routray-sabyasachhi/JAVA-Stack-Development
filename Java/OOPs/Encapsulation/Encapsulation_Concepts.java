package Java.OOPs.Encapsulation;

class Human {
    private String name; //Instace variable
    private int age; // Instance variable

    //setter
    public void setName(String name) { 
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }

    //getter
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

}

public class Encapsulation_Concepts {
    public static void main(String[] args) {
        Human obj = new Human();
        obj.setName("Sabya");
        obj.setAge(21);

        System.out.println(obj.getName());
        System.out.println(obj.getAge());
    }
}
