package Java.Exception;

// Defining InvalidAgeException
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

// Use custom exception
class Person {
    private int age;

    // constructor
    Person (int age) throws InvalidAgeException {
        if(age < 0 || age > 150)
            throw new InvalidAgeException("Age must be in-between 0 to 150");

        this.age = age;
    }


    public int getAge() {
        return age;
    }
}

// Client code

public class CustomException {
    public static void main(String[] args) {
        try {
            Person person = new Person(200);
            int age = person.getAge();
            System.out.println(age);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }
}
