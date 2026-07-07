# Polymorphism in Java

Polymorphism is one of the four main pillars of Object-Oriented Programming.

> Polymorphism means one name having many forms.

In Java, polymorphism allows the same method name, same reference type, or same operation to behave differently depending on the input or actual object.

Real-life examples:

- A person can be a student, employee, son, friend, or customer.
- A phone can be used for calling, payment, camera, and internet.
- A method named `draw()` can draw a circle, rectangle, or triangle.
- A method named `pay()` can pay by cash, UPI, card, or wallet.

In simple words:

> Polymorphism means the same action can behave differently in different situations.

## Why Polymorphism Is Needed

Without polymorphism, we often write repeated conditional code.

Example without polymorphism:

```java
class PaymentService {
    void pay(String paymentType) {
        if (paymentType.equals("UPI")) {
            System.out.println("Payment done using UPI");
        } else if (paymentType.equals("CARD")) {
            System.out.println("Payment done using card");
        } else if (paymentType.equals("CASH")) {
            System.out.println("Payment done using cash");
        }
    }
}
```

Problem:

- Too many `if else` conditions
- Difficult to maintain
- Adding a new payment type requires changing existing code

With polymorphism:

```java
class Payment {
    void pay() {
        System.out.println("Generic payment");
    }
}

class UpiPayment extends Payment {
    @Override
    void pay() {
        System.out.println("Payment done using UPI");
    }
}

class CardPayment extends Payment {
    @Override
    void pay() {
        System.out.println("Payment done using card");
    }
}

class CashPayment extends Payment {
    @Override
    void pay() {
        System.out.println("Payment done using cash");
    }
}
```

Now each payment class has its own behavior. The same method `pay()` behaves differently depending on the object.

## Main Definition

Polymorphism is an OOP concept where the same method, object reference, or operation can take many forms.

In Java, polymorphism is mainly achieved in two ways:

1. Compile-time polymorphism
2. Runtime polymorphism

## Important Terms

| Term | Meaning |
| --- | --- |
| Polymorphism | One name, many forms |
| Compile-time polymorphism | Method call decided during compilation |
| Runtime polymorphism | Method call decided during program execution |
| Method overloading | Same method name with different parameters |
| Method overriding | Child class redefines parent class method |
| Dynamic method dispatch | Runtime selection of overridden method |
| Upcasting | Parent reference storing child object |
| Downcasting | Converting parent reference back to child reference |
| `instanceof` | Checks actual object type |

## Types of Polymorphism in Java

Java supports two main types of polymorphism:

1. Static polymorphism
2. Dynamic polymorphism

Static polymorphism is also called compile-time polymorphism.

Dynamic polymorphism is also called runtime polymorphism.

## 1. Compile-Time Polymorphism

Compile-time polymorphism means the compiler decides which method to call during compilation.

In Java, compile-time polymorphism is achieved using method overloading.

```java
class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println(calculator.add(10, 20));
        System.out.println(calculator.add(10.5, 20.5));
        System.out.println(calculator.add(10, 20, 30));
    }
}
```

Output:

```text
30
31.0
60
```

Program explanation:

The method name is the same: `add`.

But the parameter list is different.

The compiler checks the arguments and decides which `add()` method should run.

That is why method overloading is compile-time polymorphism.

## Method Overloading

Method overloading means creating multiple methods with the same name but different parameter lists in the same class.

The difference can be:

- Different number of parameters
- Different type of parameters
- Different order of parameters

## Overloading by Number of Parameters

```java
class Display {
    void show(int a) {
        System.out.println("One number: " + a);
    }

    void show(int a, int b) {
        System.out.println("Two numbers: " + a + " and " + b);
    }
}
```

Explanation:

Both methods are named `show`, but one method has one parameter and the other has two parameters.

## Overloading by Type of Parameters

```java
class Display {
    void show(int number) {
        System.out.println("Integer: " + number);
    }

    void show(String text) {
        System.out.println("String: " + text);
    }
}
```

Explanation:

One `show()` method accepts `int`.

Another `show()` method accepts `String`.

## Overloading by Order of Parameters

```java
class StudentInfo {
    void show(String name, int age) {
        System.out.println(name + " is " + age + " years old");
    }

    void show(int age, String name) {
        System.out.println(name + " is " + age + " years old");
    }
}
```

Explanation:

Both methods have one `String` and one `int`, but the order is different.

So this is valid overloading.

## Complete Overloading Example

```java
class Printer {
    void print(int value) {
        System.out.println("Integer value: " + value);
    }

    void print(double value) {
        System.out.println("Double value: " + value);
    }

    void print(String value) {
        System.out.println("String value: " + value);
    }

    void print(String label, int value) {
        System.out.println(label + ": " + value);
    }
}

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();

        printer.print(10);
        printer.print(10.5);
        printer.print("Java");
        printer.print("Marks", 95);
    }
}
```

Output:

```text
Integer value: 10
Double value: 10.5
String value: Java
Marks: 95
```

## Can Return Type Alone Overload a Method?

No. Return type alone cannot overload a method.

Invalid code:

```java
class Test {
    int show() {
        return 10;
    }

    // Error
    double show() {
        return 10.5;
    }
}
```

Reason:

The compiler identifies overloaded methods by method name and parameter list, not by return type alone.

## Method Signature

Method signature means:

- Method name
- Parameter list

Return type is not part of the method signature for overloading.

```java
void show(int a)
void show(String a)
void show(int a, int b)
```

These are different method signatures.

## Automatic Type Promotion in Overloading

If an exact method match is not found, Java can promote smaller data types to larger data types.

```java
class Test {
    void show(int number) {
        System.out.println("int method");
    }

    void show(double number) {
        System.out.println("double method");
    }
}

public class Main {
    public static void main(String[] args) {
        Test test = new Test();
        test.show(10);
        test.show(10.5f);
    }
}
```

Output:

```text
int method
double method
```

Explanation:

`10` is an `int`, so `show(int)` runs.

`10.5f` is a `float`. There is no `show(float)`, so Java promotes `float` to `double` and calls `show(double)`.

Promotion order:

```text
byte -> short -> int -> long -> float -> double
char -> int -> long -> float -> double
```

## Overloading with `null`

`null` can match any reference type.

```java
class Test {
    void show(String value) {
        System.out.println("String method");
    }

    void show(Object value) {
        System.out.println("Object method");
    }
}

public class Main {
    public static void main(String[] args) {
        Test test = new Test();
        test.show(null);
    }
}
```

Output:

```text
String method
```

Explanation:

Both `String` and `Object` can accept `null`.

But `String` is more specific than `Object`, so `show(String)` runs.

Ambiguous example:

```java
class Test {
    void show(String value) {
        System.out.println("String method");
    }

    void show(Integer value) {
        System.out.println("Integer method");
    }

    public static void main(String[] args) {
        Test test = new Test();
        // test.show(null); // Error: ambiguous
    }
}
```

Explanation:

`String` and `Integer` are unrelated classes.

Java cannot decide which method is more specific.

## Overloading Static Methods

Static methods can be overloaded.

```java
class MathUtil {
    static int square(int number) {
        return number * number;
    }

    static double square(double number) {
        return number * number;
    }
}
```

Explanation:

Both methods are static, but the parameter types are different.

This is valid method overloading.

## Overloading Constructors

Constructors can also be overloaded.

```java
class Student {
    String name;
    int age;

    Student() {
        name = "Unknown";
        age = 0;
    }

    Student(String name) {
        this.name = name;
        age = 0;
    }

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void showDetails() {
        System.out.println(name + " - " + age);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student("Sabya");
        Student s3 = new Student("Rahul", 22);

        s1.showDetails();
        s2.showDetails();
        s3.showDetails();
    }
}
```

Output:

```text
Unknown - 0
Sabya - 0
Rahul - 22
```

Explanation:

The constructor name is same as class name, but the parameter lists are different.

This is constructor overloading.

## 2. Runtime Polymorphism

Runtime polymorphism means Java decides which method to call at runtime based on the actual object.

Runtime polymorphism is achieved using:

- Inheritance
- Method overriding
- Parent reference holding child object

```java
class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal;

        animal = new Dog();
        animal.sound();

        animal = new Cat();
        animal.sound();
    }
}
```

Output:

```text
Dog barks
Cat meows
```

Program explanation:

`Animal animal` is a parent class reference.

First, it stores a `Dog` object.

So `animal.sound()` calls the `Dog` version.

Then, it stores a `Cat` object.

So `animal.sound()` calls the `Cat` version.

The method call is decided at runtime. This is runtime polymorphism.

## Method Overriding

Method overriding means a child class provides its own implementation of a parent class method.

```java
class Parent {
    void show() {
        System.out.println("Parent show");
    }
}

class Child extends Parent {
    @Override
    void show() {
        System.out.println("Child show");
    }
}
```

Explanation:

`Child` has the same `show()` method as `Parent`.

The child version replaces the parent behavior for child objects.

## Rules of Method Overriding

- Method name must be the same.
- Parameter list must be the same.
- Return type must be same or covariant.
- Child method cannot reduce access level.
- Parent and child classes must have inheritance.
- Private methods cannot be overridden.
- Static methods cannot be overridden; they are hidden.
- Final methods cannot be overridden.
- Constructors cannot be overridden.

## `@Override` Annotation

`@Override` tells the compiler that a method is intended to override a parent class method.

```java
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
```

Benefit:

If the method name or parameter list is wrong, the compiler catches the mistake.

## Dynamic Method Dispatch

Dynamic method dispatch is the process where Java decides at runtime which overridden method should execute.

```java
class Shape {
    void draw() {
        System.out.println("Drawing shape");
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing circle");
    }
}

class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing rectangle");
    }
}

public class Main {
    public static void main(String[] args) {
        Shape shape1 = new Circle();
        Shape shape2 = new Rectangle();

        shape1.draw();
        shape2.draw();
    }
}
```

Output:

```text
Drawing circle
Drawing rectangle
```

Explanation:

The reference type is `Shape`.

The actual objects are `Circle` and `Rectangle`.

Java calls the method based on the actual object, not only the reference type.

## Upcasting

Upcasting means assigning a child class object to a parent class reference.

```java
Animal animal = new Dog();
```

This is valid because a `Dog` is an `Animal`.

Complete example:

```java
class Animal {
    void eat() {
        System.out.println("Animal eats");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.eat();
        // animal.bark(); // Error
    }
}
```

Explanation:

The object is `Dog`, but the reference type is `Animal`.

So we can call only methods available in `Animal`.

If `Dog` overrides an `Animal` method, then the `Dog` version will run.

## Downcasting

Downcasting means converting a parent reference back into a child reference.

```java
Animal animal = new Dog();
Dog dog = (Dog) animal;
dog.bark();
```

Complete example:

```java
class Animal {
    void eat() {
        System.out.println("Animal eats");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog();

        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            dog.bark();
        }
    }
}
```

Output:

```text
Dog barks
```

Explanation:

`instanceof` checks whether the actual object is a `Dog`.

After checking, we safely convert `Animal` reference into `Dog` reference.

## `instanceof` Operator

`instanceof` checks whether an object is an instance of a class, subclass, or interface implementation.

```java
class Animal {
}

class Dog extends Animal {
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog();

        System.out.println(animal instanceof Animal);
        System.out.println(animal instanceof Dog);
    }
}
```

Output:

```text
true
true
```

Explanation:

The object is a `Dog`.

A `Dog` is also an `Animal`.

## `instanceof` Pattern Matching

Modern Java supports pattern matching with `instanceof`.

```java
class Animal {
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal = new Dog();

        if (animal instanceof Dog dog) {
            dog.bark();
        }
    }
}
```

Explanation:

`animal instanceof Dog dog` checks the type and creates a `dog` variable automatically.

This avoids manual casting.

## Polymorphism with Arrays

A parent class array can store child class objects.

```java
class Shape {
    void draw() {
        System.out.println("Drawing shape");
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing circle");
    }
}

class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing rectangle");
    }
}

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(),
            new Rectangle(),
            new Shape()
        };

        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}
```

Output:

```text
Drawing circle
Drawing rectangle
Drawing shape
```

Explanation:

The array type is `Shape[]`.

But it stores `Circle`, `Rectangle`, and `Shape` objects.

During loop execution, Java calls the correct `draw()` method for each actual object.

## Polymorphism with Method Parameters

A method can accept a parent type and receive any child object.

```java
class Payment {
    void pay() {
        System.out.println("Generic payment");
    }
}

class UpiPayment extends Payment {
    @Override
    void pay() {
        System.out.println("Paid using UPI");
    }
}

class CardPayment extends Payment {
    @Override
    void pay() {
        System.out.println("Paid using card");
    }
}

class PaymentProcessor {
    void processPayment(Payment payment) {
        payment.pay();
    }
}

public class Main {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        processor.processPayment(new UpiPayment());
        processor.processPayment(new CardPayment());
    }
}
```

Output:

```text
Paid using UPI
Paid using card
```

Explanation:

`processPayment()` accepts `Payment`.

But we pass `UpiPayment` and `CardPayment`.

The correct `pay()` method runs at runtime.

This makes code flexible and extensible.

## Polymorphism with Return Type

A method can return a parent type while actually returning a child object.

```java
class Notification {
    void send() {
        System.out.println("Sending notification");
    }
}

class EmailNotification extends Notification {
    @Override
    void send() {
        System.out.println("Sending email");
    }
}

class SmsNotification extends Notification {
    @Override
    void send() {
        System.out.println("Sending SMS");
    }
}

class NotificationFactory {
    Notification createNotification(String type) {
        if (type.equals("email")) {
            return new EmailNotification();
        }
        return new SmsNotification();
    }
}

public class Main {
    public static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();

        Notification notification = factory.createNotification("email");
        notification.send();
    }
}
```

Output:

```text
Sending email
```

Explanation:

The return type is `Notification`.

But the actual returned object is `EmailNotification`.

The overridden `send()` method of `EmailNotification` runs.

## Polymorphism with Interfaces

Interfaces are widely used for polymorphism.

```java
interface Payment {
    void pay(double amount);
}

class UpiPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI");
    }
}

class CardPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using card");
    }
}

public class Main {
    public static void main(String[] args) {
        Payment payment;

        payment = new UpiPayment();
        payment.pay(1000);

        payment = new CardPayment();
        payment.pay(2000);
    }
}
```

Output:

```text
Paid 1000.0 using UPI
Paid 2000.0 using card
```

Explanation:

`Payment` is an interface reference.

It can point to any object of a class that implements `Payment`.

This is one of the most important real-world uses of polymorphism.

## Polymorphism with Abstract Classes

Abstract classes are also used for polymorphism.

```java
abstract class Employee {
    private String name;

    Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract double calculateSalary();
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    FullTimeEmployee(String name, double monthlySalary) {
        super(name);
        this.monthlySalary = monthlySalary;
    }

    @Override
    double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    private int hours;
    private double ratePerHour;

    PartTimeEmployee(String name, int hours, double ratePerHour) {
        super(name);
        this.hours = hours;
        this.ratePerHour = ratePerHour;
    }

    @Override
    double calculateSalary() {
        return hours * ratePerHour;
    }
}

public class Main {
    public static void main(String[] args) {
        Employee[] employees = {
            new FullTimeEmployee("Sabya", 50000),
            new PartTimeEmployee("Rahul", 80, 500)
        };

        for (Employee employee : employees) {
            System.out.println(employee.getName() + ": " + employee.calculateSalary());
        }
    }
}
```

Output:

```text
Sabya: 50000.0
Rahul: 40000.0
```

Explanation:

`Employee` is an abstract parent class.

`FullTimeEmployee` and `PartTimeEmployee` provide their own salary calculation.

The same method call `calculateSalary()` behaves differently for different employee objects.

## Overriding with Covariant Return Type

Covariant return type means an overridden method can return a child type of the parent method return type.

```java
class Animal {
}

class Dog extends Animal {
}

class AnimalFactory {
    Animal createAnimal() {
        return new Animal();
    }
}

class DogFactory extends AnimalFactory {
    @Override
    Dog createAnimal() {
        return new Dog();
    }
}
```

Explanation:

`AnimalFactory.createAnimal()` returns `Animal`.

`DogFactory.createAnimal()` returns `Dog`.

This is valid because `Dog` is a child class of `Animal`.

## Access Modifier Rule in Overriding

In overriding, child class cannot reduce method visibility.

Valid:

```java
class Parent {
    protected void show() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    @Override
    public void show() {
        System.out.println("Child");
    }
}
```

Invalid:

```java
class Parent {
    public void show() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    // Error: cannot reduce visibility
    protected void show() {
        System.out.println("Child");
    }
}
```

Explanation:

Public is more visible than protected.

A child class cannot make an inherited public method less accessible.

## Exception Rule in Overriding

For checked exceptions, child class method cannot throw a broader checked exception than the parent method.

```java
import java.io.IOException;

class Parent {
    void read() throws IOException {
        System.out.println("Parent read");
    }
}

class Child extends Parent {
    @Override
    void read() throws IOException {
        System.out.println("Child read");
    }
}
```

This is valid.

Invalid idea:

```java
class Parent {
    void read() {
        System.out.println("Parent read");
    }
}

class Child extends Parent {
    // Error if this declares a broad checked exception
    // void read() throws Exception { }
}
```

## Static Methods and Polymorphism

Static methods are not overridden. They are hidden.

```java
class Parent {
    static void show() {
        System.out.println("Parent static show");
    }
}

class Child extends Parent {
    static void show() {
        System.out.println("Child static show");
    }
}

public class Main {
    public static void main(String[] args) {
        Parent obj = new Child();
        obj.show();
    }
}
```

Output:

```text
Parent static show
```

Explanation:

For static methods, Java uses reference type.

The reference type is `Parent`, so `Parent.show()` runs.

This is method hiding, not runtime polymorphism.

## Variables and Polymorphism

Variables are not overridden. They are hidden.

```java
class Parent {
    String name = "Parent";
}

class Child extends Parent {
    String name = "Child";
}

public class Main {
    public static void main(String[] args) {
        Parent obj = new Child();
        System.out.println(obj.name);
    }
}
```

Output:

```text
Parent
```

Explanation:

Variables are selected based on reference type.

Methods are selected based on actual object when overridden.

## Private Methods and Polymorphism

Private methods cannot be overridden because they are not visible in the child class.

```java
class Parent {
    private void show() {
        System.out.println("Parent private show");
    }
}

class Child extends Parent {
    private void show() {
        System.out.println("Child private show");
    }
}
```

Explanation:

This is not overriding.

The `show()` method in `Child` is a separate private method.

## Final Methods and Polymorphism

A final method cannot be overridden.

```java
class Parent {
    final void show() {
        System.out.println("Final show");
    }
}

class Child extends Parent {
    // void show() { } // Error
}
```

Explanation:

`final` prevents child classes from changing the method behavior.

## Final Class and Polymorphism

A final class cannot be inherited.

```java
final class Bank {
}

// class SavingsBank extends Bank { } // Error
```

If a class cannot be inherited, method overriding cannot happen for that class.

## Constructors and Polymorphism

Constructors are not inherited and cannot be overridden.

But constructors can be overloaded.

```java
class Student {
    Student() {
        System.out.println("Default constructor");
    }

    Student(String name) {
        System.out.println("Student name: " + name);
    }
}
```

Explanation:

Constructor overloading is compile-time polymorphism.

Constructor overriding does not exist in Java.

## Polymorphism and `super`

`super` can call the parent class method from an overridden method.

```java
class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        super.sound();
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.sound();
    }
}
```

Output:

```text
Animal makes sound
Dog barks
```

Explanation:

`super.sound()` calls the parent method.

Then the child method adds its own behavior.

## Polymorphism and `Object` Class

Every class in Java inherits from `Object`.

Common methods like `toString()`, `equals()`, and `hashCode()` can be overridden.

```java
class Student {
    private int id;
    private String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}

public class Main {
    public static void main(String[] args) {
        Student student = new Student(101, "Sabya");
        System.out.println(student);
    }
}
```

Output:

```text
101 - Sabya
```

Explanation:

`System.out.println(student)` internally calls `student.toString()`.

Because we override `toString()`, meaningful data is printed.

## Overriding `equals()`

```java
class Student {
    private int id;
    private String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Student)) {
            return false;
        }

        Student other = (Student) obj;
        return this.id == other.id;
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(101, "Sabya");
        Student s2 = new Student(101, "Rahul");

        System.out.println(s1.equals(s2));
    }
}
```

Output:

```text
true
```

Explanation:

We override `equals()` to compare students by `id`.

Although names are different, ids are same, so result is `true`.

Note:

When you override `equals()`, you should also override `hashCode()` in real applications.

## Compile-Time vs Runtime Polymorphism

| Feature | Compile-Time Polymorphism | Runtime Polymorphism |
| --- | --- | --- |
| Also called | Static polymorphism | Dynamic polymorphism |
| Achieved by | Method overloading | Method overriding |
| Decision time | Compile time | Runtime |
| Inheritance needed | No | Yes |
| Performance | Slightly faster | Slightly slower |
| Flexibility | Less flexible | More flexible |
| Example | `add(int, int)` and `add(double, double)` | `Animal animal = new Dog()` |

## Overloading vs Overriding

| Feature | Overloading | Overriding |
| --- | --- | --- |
| Meaning | Same method name, different parameters | Child redefines parent method |
| Class | Can happen in same class | Needs parent-child classes |
| Parameters | Must be different | Must be same |
| Return type | Can differ only if parameters differ | Same or covariant |
| Access modifier | No strict overriding rule | Cannot reduce visibility |
| Polymorphism | Compile-time | Runtime |
| Static methods | Can be overloaded | Cannot be overridden |
| Final methods | Can be overloaded | Cannot be overridden |
| Private methods | Can be overloaded | Cannot be overridden |

## Real-Life Example: Payment System

```java
abstract class Payment {
    private double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    abstract void pay();
}

class UpiPayment extends Payment {
    private String upiId;

    UpiPayment(double amount, String upiId) {
        super(amount);
        this.upiId = upiId;
    }

    @Override
    void pay() {
        System.out.println("Paid " + getAmount() + " using UPI ID: " + upiId);
    }
}

class CardPayment extends Payment {
    private String cardNumber;

    CardPayment(double amount, String cardNumber) {
        super(amount);
        this.cardNumber = cardNumber;
    }

    @Override
    void pay() {
        System.out.println("Paid " + getAmount() + " using card: " + cardNumber);
    }
}

class CashPayment extends Payment {
    CashPayment(double amount) {
        super(amount);
    }

    @Override
    void pay() {
        System.out.println("Paid " + getAmount() + " using cash");
    }
}

class Checkout {
    void completePayment(Payment payment) {
        payment.pay();
    }
}

public class Main {
    public static void main(String[] args) {
        Checkout checkout = new Checkout();

        checkout.completePayment(new UpiPayment(1500, "sabya@upi"));
        checkout.completePayment(new CardPayment(2500, "XXXX-1234"));
        checkout.completePayment(new CashPayment(500));
    }
}
```

Output:

```text
Paid 1500.0 using UPI ID: sabya@upi
Paid 2500.0 using card: XXXX-1234
Paid 500.0 using cash
```

Program explanation:

`Payment` is an abstract parent class.

`UpiPayment`, `CardPayment`, and `CashPayment` override `pay()`.

`Checkout.completePayment()` accepts a `Payment` reference.

At runtime, the correct `pay()` method runs based on the actual object passed.

This is a strong real-world use of runtime polymorphism.

## Real-Life Example: Notification System

```java
interface NotificationSender {
    void send(String message);
}

class EmailSender implements NotificationSender {
    public void send(String message) {
        System.out.println("Email sent: " + message);
    }
}

class SmsSender implements NotificationSender {
    public void send(String message) {
        System.out.println("SMS sent: " + message);
    }
}

class WhatsAppSender implements NotificationSender {
    public void send(String message) {
        System.out.println("WhatsApp sent: " + message);
    }
}

class NotificationService {
    void notifyUser(NotificationSender sender, String message) {
        sender.send(message);
    }
}

public class Main {
    public static void main(String[] args) {
        NotificationService service = new NotificationService();

        service.notifyUser(new EmailSender(), "Welcome");
        service.notifyUser(new SmsSender(), "OTP: 123456");
        service.notifyUser(new WhatsAppSender(), "Order shipped");
    }
}
```

Output:

```text
Email sent: Welcome
SMS sent: OTP: 123456
WhatsApp sent: Order shipped
```

Program explanation:

`NotificationSender` is an interface.

Different classes implement the same `send()` method differently.

`NotificationService` works with the interface, not with concrete classes.

This makes the system flexible.

## Polymorphism in Collections

Collections can store parent or interface references.

```java
import java.util.ArrayList;

interface Task {
    void execute();
}

class EmailTask implements Task {
    public void execute() {
        System.out.println("Sending email");
    }
}

class ReportTask implements Task {
    public void execute() {
        System.out.println("Generating report");
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<>();

        tasks.add(new EmailTask());
        tasks.add(new ReportTask());

        for (Task task : tasks) {
            task.execute();
        }
    }
}
```

Output:

```text
Sending email
Generating report
```

Explanation:

`ArrayList<Task>` stores objects of different classes that implement `Task`.

Each object runs its own `execute()` method.

## Polymorphism and Loose Coupling

Polymorphism helps write loosely coupled code.

Loose coupling means one class depends on an abstraction instead of depending directly on a specific implementation.

Tightly coupled code:

```java
class OrderService {
    private EmailSender sender = new EmailSender();

    void placeOrder() {
        sender.send("Order placed");
    }
}
```

Problem:

`OrderService` depends directly on `EmailSender`.

Loosely coupled code:

```java
interface Sender {
    void send(String message);
}

class EmailSender implements Sender {
    public void send(String message) {
        System.out.println("Email: " + message);
    }
}

class OrderService {
    private Sender sender;

    OrderService(Sender sender) {
        this.sender = sender;
    }

    void placeOrder() {
        sender.send("Order placed");
    }
}
```

Explanation:

`OrderService` depends on the `Sender` interface.

Any class implementing `Sender` can be used.

This is a common idea in Spring Boot and real backend development.

## Polymorphism and Open-Closed Principle

The Open-Closed Principle says:

> Software entities should be open for extension but closed for modification.

Polymorphism supports this principle.

Example:

```java
interface Discount {
    double apply(double amount);
}

class NoDiscount implements Discount {
    public double apply(double amount) {
        return amount;
    }
}

class FestivalDiscount implements Discount {
    public double apply(double amount) {
        return amount * 0.80;
    }
}

class StudentDiscount implements Discount {
    public double apply(double amount) {
        return amount * 0.90;
    }
}

class BillingService {
    double calculateFinalAmount(double amount, Discount discount) {
        return discount.apply(amount);
    }
}
```

Explanation:

To add a new discount type, create a new class implementing `Discount`.

No need to modify `BillingService`.

## Polymorphism with Abstract Class vs Interface

| Feature | Abstract Class | Interface |
| --- | --- | --- |
| Keyword | `abstract class` | `interface` |
| Used by class with | `extends` | `implements` |
| Multiple inheritance | One abstract class only | Multiple interfaces allowed |
| Fields | Can have instance fields | Mostly constants |
| Constructors | Can have constructors | Cannot have constructors |
| Best use | Shared base state plus behavior | Common capability or contract |

Use abstract class when child classes share common data and behavior.

Use interface when different classes share a common capability.

## Where Polymorphism Is Used in Java

Polymorphism is used in:

- Method overloading
- Method overriding
- Interface-based programming
- Abstract classes
- Collections
- Spring Boot dependency injection
- JDBC drivers
- Servlet API
- Event handling
- Strategy pattern
- Factory pattern
- Payment systems
- Notification systems
- Logging systems

## Advantages of Polymorphism

- Improves code flexibility
- Reduces repeated code
- Supports method overriding
- Supports runtime behavior change
- Makes code easier to extend
- Helps build loosely coupled systems
- Improves maintainability
- Supports clean object-oriented design
- Helps implement design patterns

## Disadvantages of Polymorphism

- Runtime behavior can be harder to trace for beginners
- Too many abstractions can make code complex
- Incorrect downcasting can cause `ClassCastException`
- Overloading ambiguity can confuse the compiler
- Poor inheritance design can create maintenance problems

## Best Practices

- Use overloading only when methods do similar work.
- Use overriding when child classes need different behavior.
- Always use `@Override` when overriding.
- Prefer parent or interface references for flexible code.
- Use `instanceof` before downcasting.
- Avoid unnecessary downcasting.
- Prefer interfaces for service-like behavior.
- Keep method names meaningful.
- Do not overload methods in a confusing way.
- Do not use inheritance only for code reuse.

## Common Mistakes

Mistake 1:

Thinking return type alone can overload a method.

```java
int show() {
    return 10;
}

// double show() { return 10.5; } // Error
```

Mistake 2:

Thinking static methods are overridden.

```java
class Parent {
    static void show() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    static void show() {
        System.out.println("Child");
    }
}
```

This is method hiding, not overriding.

Mistake 3:

Trying to override private methods.

Private methods are not visible in child classes, so they cannot be overridden.

Mistake 4:

Calling child-specific methods from a parent reference.

```java
Animal animal = new Dog();
// animal.bark(); // Error
```

Mistake 5:

Downcasting without checking type.

```java
Animal animal = new Cat();
// Dog dog = (Dog) animal; // Runtime error
```

Better:

```java
if (animal instanceof Dog) {
    Dog dog = (Dog) animal;
}
```

## Complete Practice Program

```java
abstract class Vehicle {
    private String brand;

    Vehicle(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    abstract void start();

    void stop() {
        System.out.println(brand + " stopped");
    }
}

class Car extends Vehicle {
    Car(String brand) {
        super(brand);
    }

    @Override
    void start() {
        System.out.println(getBrand() + " car starts with key");
    }
}

class Bike extends Vehicle {
    Bike(String brand) {
        super(brand);
    }

    @Override
    void start() {
        System.out.println(getBrand() + " bike starts with self-start");
    }
}

class ElectricScooter extends Vehicle {
    ElectricScooter(String brand) {
        super(brand);
    }

    @Override
    void start() {
        System.out.println(getBrand() + " scooter starts silently");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("Hyundai"),
            new Bike("Honda"),
            new ElectricScooter("Ather")
        };

        for (Vehicle vehicle : vehicles) {
            vehicle.start();
            vehicle.stop();
        }
    }
}
```

Output:

```text
Hyundai car starts with key
Hyundai stopped
Honda bike starts with self-start
Honda stopped
Ather scooter starts silently
Ather stopped
```

Program explanation:

`Vehicle` is an abstract parent class.

`Car`, `Bike`, and `ElectricScooter` are child classes.

Each child class overrides `start()`.

The array type is `Vehicle[]`, but it stores different child objects.

During the loop, Java calls the correct `start()` method based on the actual object.

This program shows abstraction, inheritance, overriding, and runtime polymorphism together.

## Interview Questions

### What is polymorphism?

Polymorphism is an OOP concept where one name can have many forms. In Java, it allows the same method or reference to behave differently based on parameters or actual object.

### What are the types of polymorphism in Java?

Java has compile-time polymorphism and runtime polymorphism.

Compile-time polymorphism is achieved by method overloading.

Runtime polymorphism is achieved by method overriding.

### What is method overloading?

Method overloading means creating multiple methods with the same name but different parameter lists.

### What is method overriding?

Method overriding means a child class provides its own implementation of a parent class method with the same method signature.

### Can static methods be overridden?

No. Static methods cannot be overridden. They are hidden.

### Can private methods be overridden?

No. Private methods cannot be overridden because they are not visible in child classes.

### Can final methods be overridden?

No. Final methods cannot be overridden.

### Can constructors be overridden?

No. Constructors cannot be overridden because they are not inherited.

### Can constructors be overloaded?

Yes. Constructors can be overloaded by changing their parameter list.

### What is dynamic method dispatch?

Dynamic method dispatch is the runtime process where Java decides which overridden method to call based on the actual object.

### What is upcasting?

Upcasting means storing a child class object in a parent class reference.

```java
Animal animal = new Dog();
```

### What is downcasting?

Downcasting means converting a parent reference back into a child reference.

```java
Dog dog = (Dog) animal;
```

### Why use polymorphism?

Polymorphism improves flexibility, code reuse, maintainability, and extensibility. It allows code to depend on parent classes or interfaces instead of specific child classes.

## Quick Revision Table

| Concept | Short Meaning |
| --- | --- |
| Polymorphism | One name, many forms |
| Compile-time polymorphism | Method call decided at compile time |
| Runtime polymorphism | Method call decided at runtime |
| Overloading | Same method name, different parameters |
| Overriding | Child redefines parent method |
| Dynamic dispatch | Runtime method selection |
| Upcasting | Parent reference stores child object |
| Downcasting | Parent reference converted to child type |
| `instanceof` | Checks actual object type |
| Static method | Hidden, not overridden |
| Private method | Not overridden |
| Final method | Cannot be overridden |
| Constructor | Can be overloaded, not overridden |
| Interface polymorphism | Interface reference stores implementation object |

## One-Line Memory Trick

Polymorphism = same method or reference, different behavior depending on input or object.
