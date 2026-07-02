package Java.OOPs.Encapsulation;

// Encapsulation means binding data and methods together inside one class.
// It also means hiding the internal data from direct outside access.
class Human {
    // private fields cannot be accessed directly from outside this class.
    // This protects the data from invalid or unwanted changes.
    private String name; // Instance variable
    private int age; // Instance variable

    // A constructor is used to initialize an object at the time of creation.
    // Here we reuse setters so validation rules stay in one place.
    public Human(String name, int age) {
        setName(name);
        setAge(age);
    }

    // Setter method for name.
    // A setter gives controlled write access to a private field.
    public void setName(String name) {
        // Validation: name should not be null or blank.
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Invalid name. Name cannot be empty.");
            return;
        }

        // this.name means the instance variable of the current object.
        // name means the local parameter received by this method.
        this.name = name;
    }

    // Setter method for age.
    // We can add rules before changing the private variable.
    public void setAge(int age) {
        // Validation: age should be a positive number.
        if (age <= 0) {
            System.out.println("Invalid age. Age must be greater than 0.");
            return;
        }

        this.age = age;
    }

    // Getter method for name.
    // A getter gives read access to a private field.
    public String getName() {
        return name;
    }

    // Getter method for age.
    public int getAge() {
        return age;
    }

    // Business method: this method changes data in a controlled way.
    // The outside code does not need to know how age is stored internally.
    public void celebrateBirthday() {
        age++;
    }

    // This method prints object details in a clean format.
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class Encapsulation_Concepts {
    public static void main(String[] args) {
        // Create a Human object and initialize values using the constructor.
        Human obj = new Human("Sabya", 21);

        // Direct access is not allowed because fields are private.
        // obj.name = "Satya"; // Error: name has private access in Human
        // obj.age = -10;      // Error: age has private access in Human

        // We must use public methods to read or modify private data.
        System.out.println("Initial Details:");
        obj.displayDetails();

        // Update the name using the setter method.
        obj.setName("Satya");

        // This invalid value will be rejected by the setter validation.
        obj.setAge(-5);

        // This method updates age safely from inside the class.
        obj.celebrateBirthday();

        System.out.println("\nUpdated Details:");
        System.out.println("Name from getter: " + obj.getName());
        System.out.println("Age from getter: " + obj.getAge());
    }
}

/*
Notes: Encapsulation Concepts
-----------------------------

1. Encapsulation
   Encapsulation is the process of wrapping data and methods together inside a
   class. In this program, Human keeps data fields and related methods together.

2. Data Hiding
   Data hiding means making variables private so outside classes cannot access
   them directly. Here, name and age are private.

3. private Access Modifier
   private members are accessible only inside the same class. This is why main()
   cannot directly use obj.name or obj.age.

4. public Methods
   public methods are used as controlled doors to private data. Getters read
   data, setters update data, and business methods perform meaningful actions.

5. Getter
   A getter returns the value of a private field.
   Example: getName() returns the value of name.

6. Setter
   A setter updates the value of a private field.
   Example: setAge(int age) updates age only after checking validation rules.

7. Validation
   Encapsulation allows validation before data changes. In this program, empty
   names and negative ages are rejected.

8. Constructor With Encapsulation
   The constructor initializes object data. Calling setters inside the
   constructor helps reuse the same validation logic.

9. this Keyword
   this refers to the current object. this.name means the name variable that
   belongs to the current Human object.

10. Controlled Modification
   celebrateBirthday() changes age from inside the class. This is better than
   allowing outside code to change age randomly.

11. Real-Life Example
   Think of a bank account. Balance should be private. Outside code should not
   directly change balance. It should use deposit() and withdraw() methods, so
   rules like minimum balance and valid amount can be checked.

12. Main Benefit
   Encapsulation makes code safer, cleaner, easier to maintain, and easier to
   debug because the class controls its own data.
*/
