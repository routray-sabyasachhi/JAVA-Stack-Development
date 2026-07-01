package Java.OOPs;

class Person {
    int id;
    String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class Stack_Heap {
    private static Person buildPerson(int id, String name) {
        return new Person(id, name);
    }

    public static void main(String[] args) {
        int id = 34;
        String name = "Sabya";
        Person person = null;
        person = buildPerson(id, name);
        System.out.println(person.id);
        System.out.println(person.name);
    }
}