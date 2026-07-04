# Inheritance in Java

Inheritance is one of the four main pillars of Object-Oriented Programming.

> Inheritance means creating a new class from an existing class so that the new class can reuse, extend, or modify the behavior of the existing class.

In simple words, inheritance allows one class to acquire the properties and methods of another class.

Example from real life:

- A `Car` is a `Vehicle`
- A `Dog` is an `Animal`
- A `SavingsAccount` is a `BankAccount`
- A `JavaDeveloper` is an `Employee`

In Java, inheritance is created using the `extends` keyword.

```java
class Parent {
    // parent class members
}

class Child extends Parent {
    // child class members
}
```

Here, `Child` inherits from `Parent`.

## Why Inheritance Is Needed

Without inheritance, common code gets repeated in many classes.

Example without inheritance:

```java
class Dog {
    String name;

    void eat() {
        System.out.println("Eating food");
    }
}

class Cat {
    String name;

    void eat() {
        System.out.println("Eating food");
    }
}
```

Both `Dog` and `Cat` have the same `name` variable and `eat()` method. This creates duplicate code.

With inheritance:

```java
class Animal {
    String name;

    void eat() {
        System.out.println("Eating food");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking");
    }
}

class Cat extends Animal {
    void meow() {
        System.out.println("Cat is meowing");
    }
}
```

Now `name` and `eat()` are written only once inside `Animal`, and both `Dog` and `Cat` can reuse them.

## Main Definition

Inheritance is an OOP mechanism where one class acquires the fields and methods of another class using the `extends` keyword.

The class whose properties are inherited is called the parent class, superclass, or base class.

The class that inherits those properties is called the child class, subclass, or derived class.

```java
class Vehicle {
    void start() {
        System.out.println("Vehicle starts");
    }
}

class Bike extends Vehicle {
    void ride() {
        System.out.println("Bike is riding");
    }
}
```

`Vehicle` is the parent class. `Bike` is the child class.

## Important Terms

| Term | Meaning |
| --- | --- |
| Parent class | The class whose members are inherited |
| Child class | The class that inherits another class |
| Superclass | Another name for parent class |
| Subclass | Another name for child class |
| Base class | Another name for parent class |
| Derived class | Another name for child class |
| `extends` | Java keyword used for class inheritance |
| `super` | Keyword used to refer to parent class members |
| Method overriding | Redefining a parent class method in child class |
| IS-A relationship | Relationship represented by inheritance |

## Basic Syntax

```java
class ParentClass {
    // fields and methods
}

class ChildClass extends ParentClass {
    // extra fields and methods
}
```

Only one class can come after `extends`.

```java
class B extends A {
}
```

This is valid.

```java
class C extends A, B {
}
```

This is invalid in Java because Java does not support multiple inheritance with classes.

## Simple Complete Example

```java
class Employee {
    String name;
    double salary;

    void work() {
        System.out.println(name + " is working");
    }

    void showSalary() {
        System.out.println("Salary: " + salary);
    }
}

class Developer extends Employee {
    String programmingLanguage;

    void writeCode() {
        System.out.println(name + " writes code in " + programmingLanguage);
    }
}

public class Main {
    public static void main(String[] args) {
        Developer dev = new Developer();

        dev.name = "Sabya";
        dev.salary = 50000;
        dev.programmingLanguage = "Java";

        dev.work();
        dev.showSalary();
        dev.writeCode();
    }
}
```

Output:

```text
Sabya is working
Salary: 50000.0
Sabya writes code in Java
```

## Program Explanation

`Employee` is the parent class.

`Developer` is the child class because it extends `Employee`.

`name`, `salary`, `work()`, and `showSalary()` belong to `Employee`.

`programmingLanguage` and `writeCode()` belong to `Developer`.

The `Developer` object can access both:

- Members inherited from `Employee`
- Members declared inside `Developer`

That is the power of inheritance.

## IS-A Relationship

Inheritance represents an IS-A relationship.

```java
class Animal {
}

class Dog extends Animal {
}
```

Here:

```text
Dog IS-A Animal
```

This is correct, so inheritance makes sense.

Another example:

```java
class Vehicle {
}

class Car extends Vehicle {
}
```

Here:

```text
Car IS-A Vehicle
```

This is also correct.

Wrong example:

```java
class Engine {
}

class Car extends Engine {
}
```

This is usually wrong because a car is not an engine. A car has an engine.

That is a HAS-A relationship, so composition should be used instead of inheritance.

## HAS-A Relationship vs IS-A Relationship

Inheritance is used for IS-A relationship.

Composition is used for HAS-A relationship.

```java
class Engine {
    void startEngine() {
        System.out.println("Engine started");
    }
}

class Car {
    Engine engine = new Engine();

    void startCar() {
        engine.startEngine();
        System.out.println("Car started");
    }
}
```

Here `Car` has an `Engine`, so composition is better than inheritance.

## Types of Inheritance in Java

Java supports these types of inheritance with classes:

1. Single inheritance
2. Multilevel inheritance
3. Hierarchical inheritance

Java does not support multiple inheritance with classes.

Java supports multiple inheritance through interfaces.

## 1. Single Inheritance

Single inheritance means one child class inherits from one parent class.

```java
class Animal {
    void eat() {
        System.out.println("Animal eats food");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
        dog.bark();
    }
}
```

Output:

```text
Animal eats food
Dog barks
```

Explanation:

`Dog` inherits `eat()` from `Animal` and also has its own method `bark()`.

## 2. Multilevel Inheritance

Multilevel inheritance means a class inherits from a child class, creating a chain.

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

class Puppy extends Dog {
    void weep() {
        System.out.println("Puppy weeps");
    }
}

public class Main {
    public static void main(String[] args) {
        Puppy puppy = new Puppy();

        puppy.eat();
        puppy.bark();
        puppy.weep();
    }
}
```

Output:

```text
Animal eats
Dog barks
Puppy weeps
```

Explanation:

`Puppy` inherits from `Dog`, and `Dog` inherits from `Animal`.

So `Puppy` gets:

- `eat()` from `Animal`
- `bark()` from `Dog`
- `weep()` from itself

## 3. Hierarchical Inheritance

Hierarchical inheritance means multiple child classes inherit from the same parent class.

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

class Cat extends Animal {
    void meow() {
        System.out.println("Cat meows");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
        dog.bark();

        Cat cat = new Cat();
        cat.eat();
        cat.meow();
    }
}
```

Output:

```text
Animal eats
Dog barks
Animal eats
Cat meows
```

Explanation:

Both `Dog` and `Cat` inherit the common `eat()` method from `Animal`.

## 4. Multiple Inheritance with Classes

Multiple inheritance means one class inherits from more than one parent class.

Java does not support multiple inheritance with classes.

Invalid code:

```java
class A {
    void show() {
        System.out.println("A");
    }
}

class B {
    void show() {
        System.out.println("B");
    }
}

class C extends A, B {
}
```

This is not allowed.

Reason:

If both `A` and `B` have a `show()` method, Java will not know which method `C` should inherit. This problem is called ambiguity.

## 5. Multiple Inheritance Through Interface

Java solves multiple inheritance using interfaces.

```java
interface Printable {
    void print();
}

interface Scannable {
    void scan();
}

class PrinterMachine implements Printable, Scannable {
    public void print() {
        System.out.println("Printing document");
    }

    public void scan() {
        System.out.println("Scanning document");
    }
}

public class Main {
    public static void main(String[] args) {
        PrinterMachine machine = new PrinterMachine();
        machine.print();
        machine.scan();
    }
}
```

Explanation:

`PrinterMachine` implements two interfaces: `Printable` and `Scannable`.

This is allowed because interfaces mainly define behavior contracts.

## Hybrid Inheritance

Hybrid inheritance is a combination of two or more inheritance types.

Java does not support hybrid inheritance using classes if it creates multiple inheritance.

Java can achieve hybrid inheritance using interfaces.

```java
interface A {
    void methodA();
}

interface B {
    void methodB();
}

class Parent {
    void parentMethod() {
        System.out.println("Parent method");
    }
}

class Child extends Parent implements A, B {
    public void methodA() {
        System.out.println("Method A");
    }

    public void methodB() {
        System.out.println("Method B");
    }
}
```

Here `Child` extends one class and implements multiple interfaces.

## What Is Inherited

A child class can inherit:

- Non-private fields
- Non-private methods
- `protected` members
- `public` members
- Default members if parent and child are in the same package

Constructors are not inherited.

Private members are not directly accessible in the child class.

## What Is Not Inherited

These are not inherited in the normal direct-access sense:

- Constructors
- Private fields
- Private methods
- Static members as object behavior

Important note:

Private members exist inside the parent part of the child object, but the child class cannot access them directly.

## Access Modifiers in Inheritance

| Modifier | Same class | Same package child | Different package child | Everywhere |
| --- | --- | --- | --- | --- |
| `private` | Yes | No | No | No |
| default | Yes | Yes | No | No |
| `protected` | Yes | Yes | Yes, through inheritance | No |
| `public` | Yes | Yes | Yes | Yes |

Example:

```java
class Parent {
    private int privateNumber = 10;
    int defaultNumber = 20;
    protected int protectedNumber = 30;
    public int publicNumber = 40;
}

class Child extends Parent {
    void show() {
        // System.out.println(privateNumber); // Error
        System.out.println(defaultNumber);
        System.out.println(protectedNumber);
        System.out.println(publicNumber);
    }
}
```

`privateNumber` cannot be accessed directly in `Child`.

## Private Members and Getter Methods

Private fields are not directly accessible in child classes, but they can be accessed through public or protected methods.

```java
class Account {
    private double balance = 5000;

    public double getBalance() {
        return balance;
    }
}

class SavingsAccount extends Account {
    void showBalance() {
        System.out.println("Balance: " + getBalance());
    }
}
```

Explanation:

`balance` is private, so `SavingsAccount` cannot access it directly.

But `getBalance()` is public, so `SavingsAccount` can call it.

## Constructor in Inheritance

Constructors are not inherited.

But when a child object is created, the parent constructor is called first.

```java
class Parent {
    Parent() {
        System.out.println("Parent constructor");
    }
}

class Child extends Parent {
    Child() {
        System.out.println("Child constructor");
    }
}

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
    }
}
```

Output:

```text
Parent constructor
Child constructor
```

Explanation:

When `new Child()` is executed:

1. Parent class constructor runs first.
2. Child class constructor runs second.

This happens because the parent part of the object must be initialized before the child part.

## `super` Keyword

The `super` keyword refers to the immediate parent class object.

It is used for three main purposes:

1. To call parent class constructor
2. To call parent class method
3. To access parent class field

## 1. Using `super()` to Call Parent Constructor

```java
class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }
}

class Developer extends Employee {
    String language;

    Developer(String name, String language) {
        super(name);
        this.language = language;
    }

    void showDetails() {
        System.out.println(name + " knows " + language);
    }
}

public class Main {
    public static void main(String[] args) {
        Developer developer = new Developer("Sabya", "Java");
        developer.showDetails();
    }
}
```

Output:

```text
Sabya knows Java
```

Explanation:

`super(name)` calls the constructor of `Employee`.

`this.language = language` initializes the child class field.

Important rule:

`super()` must be the first statement inside a constructor.

## Default `super()` Call

If you do not write `super()`, Java automatically adds it.

```java
class Parent {
    Parent() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    Child() {
        // Java automatically adds super() here
        System.out.println("Child");
    }
}
```

But this automatic call works only if the parent class has a no-argument constructor.

## Parent Without No-Argument Constructor

```java
class Parent {
    Parent(String message) {
        System.out.println(message);
    }
}

class Child extends Parent {
    Child() {
        super("Parent constructor called");
        System.out.println("Child constructor called");
    }
}
```

If `super("Parent constructor called")` is removed, the code will fail because `Parent` does not have a no-argument constructor.

## 2. Using `super` to Call Parent Method

```java
class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {
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

`super.sound()` calls the parent class version of `sound()`.

After that, the child class prints its own message.

## 3. Using `super` to Access Parent Field

```java
class Parent {
    String name = "Parent name";
}

class Child extends Parent {
    String name = "Child name";

    void showNames() {
        System.out.println(name);
        System.out.println(super.name);
    }
}
```

Output:

```text
Child name
Parent name
```

Explanation:

`name` means child class field.

`super.name` means parent class field.

## `this` vs `super`

| Keyword | Meaning | Used for |
| --- | --- | --- |
| `this` | Current class object | Current class field, method, constructor |
| `super` | Parent class object | Parent class field, method, constructor |

Example:

```java
class Parent {
    int number = 10;
}

class Child extends Parent {
    int number = 20;

    void show() {
        System.out.println(this.number);
        System.out.println(super.number);
    }
}
```

`this.number` gives `20`.

`super.number` gives `10`.

## Method Overriding

Method overriding means defining a parent class method again in the child class with the same method signature.

Method signature means method name and parameters.

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

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.sound();
    }
}
```

Output:

```text
Dog barks
```

Explanation:

`Dog` overrides the `sound()` method of `Animal`.

When `dog.sound()` is called, the child class version runs.

## Rules of Method Overriding

- The method name must be the same.
- The parameter list must be the same.
- The return type must be the same or covariant.
- The child method cannot reduce the visibility of the parent method.
- Only inherited methods can be overridden.
- Private methods cannot be overridden.
- Static methods cannot be overridden in the true runtime-polymorphism sense.
- Final methods cannot be overridden.
- Constructors cannot be overridden.

## `@Override` Annotation

`@Override` tells the compiler that you are intentionally overriding a method.

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

Use `@Override` whenever you override a method.

Benefit:

If you make a spelling mistake or wrong parameter list, the compiler will show an error.

## Overriding vs Overloading

| Feature | Overriding | Overloading |
| --- | --- | --- |
| Meaning | Same method redefined in child class | Same method name with different parameters |
| Class relation | Requires inheritance | Can happen in same class |
| Parameters | Must be same | Must be different |
| Return type | Same or covariant | Can be different, but parameters must differ |
| Polymorphism type | Runtime polymorphism | Compile-time polymorphism |

Overriding example:

```java
class Parent {
    void show() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    void show() {
        System.out.println("Child");
    }
}
```

Overloading example:

```java
class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }
}
```

## Runtime Polymorphism

Runtime polymorphism means method call is resolved at runtime based on the actual object.

Inheritance and method overriding are required for runtime polymorphism.

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

Explanation:

The reference type is `Animal`.

But the actual objects are `Dog` and `Cat`.

At runtime, Java decides which `sound()` method to call.

This is called dynamic method dispatch.

## Parent Reference and Child Object

Java allows a parent class reference to store a child class object.

```java
Animal animal = new Dog();
```

This is valid because a `Dog` is an `Animal`.

But with a parent reference, you can call only the members known to the parent type.

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

`animal` is an `Animal` reference, so it can call `eat()`.

It cannot call `bark()` directly because `bark()` is not declared in `Animal`.

## Downcasting

Downcasting means converting a parent reference back to a child reference.

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

Explanation:

`instanceof` checks whether the object is actually a `Dog`.

This prevents `ClassCastException`.

## `instanceof` Operator

`instanceof` checks whether an object belongs to a class or its child class.

```java
class Animal {
}

class Dog extends Animal {
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();

        System.out.println(dog instanceof Dog);
        System.out.println(dog instanceof Animal);
    }
}
```

Output:

```text
true
true
```

Explanation:

`dog` is a `Dog`.

Because `Dog` extends `Animal`, `dog` is also an `Animal`.

## Covariant Return Type

In method overriding, the child class method can return a subclass of the parent method return type.

```java
class Animal {
}

class Dog extends Animal {
}

class Parent {
    Animal getAnimal() {
        return new Animal();
    }
}

class Child extends Parent {
    @Override
    Dog getAnimal() {
        return new Dog();
    }
}
```

Explanation:

Parent method returns `Animal`.

Child method returns `Dog`.

This is allowed because `Dog` is a child class of `Animal`.

## Static Methods and Inheritance

Static methods belong to the class, not to the object.

Static methods are inherited, but they are not overridden. They are hidden.

```java
class Parent {
    static void show() {
        System.out.println("Parent static method");
    }
}

class Child extends Parent {
    static void show() {
        System.out.println("Child static method");
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
Parent static method
```

Explanation:

For static methods, Java checks the reference type, not the actual object.

The reference type is `Parent`, so `Parent.show()` runs.

## Field Hiding

Fields are not overridden. Fields are hidden.

```java
class Parent {
    int number = 10;
}

class Child extends Parent {
    int number = 20;
}

public class Main {
    public static void main(String[] args) {
        Parent obj = new Child();
        System.out.println(obj.number);
    }
}
```

Output:

```text
10
```

Explanation:

Fields are selected based on reference type.

Methods are selected based on actual object when they are overridden.

## `final` Keyword in Inheritance

The `final` keyword can stop inheritance or overriding.

## Final Variable

A final variable cannot be changed.

```java
class Student {
    final String college = "ABC College";
}
```

## Final Method

A final method cannot be overridden.

```java
class Parent {
    final void show() {
        System.out.println("Final method");
    }
}

class Child extends Parent {
    // void show() { } // Error
}
```

## Final Class

A final class cannot be inherited.

```java
final class Parent {
}

// class Child extends Parent { } // Error
```

Examples of final classes in Java:

- `String`
- `Integer`
- `Double`

## Abstract Class and Inheritance

An abstract class is a class that cannot be directly instantiated.

It is designed to be inherited.

```java
abstract class Shape {
    abstract double area();

    void display() {
        System.out.println("Calculating area");
    }
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return 3.14 * radius * radius;
    }
}

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        circle.display();
        System.out.println(circle.area());
    }
}
```

Explanation:

`Shape` contains an abstract method `area()`.

`Circle` must provide the implementation of `area()`.

This is inheritance plus abstraction.

## Interface and Inheritance

Interfaces define what a class must do.

A class uses `implements` for interfaces.

An interface can extend another interface.

```java
interface Vehicle {
    void start();
}

interface ElectricVehicle extends Vehicle {
    void charge();
}

class ElectricCar implements ElectricVehicle {
    public void start() {
        System.out.println("Electric car starts");
    }

    public void charge() {
        System.out.println("Electric car charging");
    }
}
```

Explanation:

`ElectricVehicle` inherits `start()` from `Vehicle`.

`ElectricCar` must implement both `start()` and `charge()`.

## Object Class: Root of All Classes

In Java, every class directly or indirectly inherits from the `Object` class.

```java
class Student {
}
```

Internally, it behaves like:

```java
class Student extends Object {
}
```

Important methods inherited from `Object`:

- `toString()`
- `equals()`
- `hashCode()`
- `getClass()`

Example:

```java
class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student name: " + name;
    }
}

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Sabya");
        System.out.println(student);
    }
}
```

Output:

```text
Student name: Sabya
```

Explanation:

`toString()` comes from the `Object` class.

We override it to print meaningful object information.

## Inheritance with Encapsulation

Inheritance should be used with encapsulation.

Parent class variables should usually be private, and child classes should access them through methods.

```java
class Person {
    private String name;

    Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Student extends Person {
    private int rollNumber;

    Student(String name, int rollNumber) {
        super(name);
        this.rollNumber = rollNumber;
    }

    void showDetails() {
        System.out.println("Name: " + getName());
        System.out.println("Roll Number: " + rollNumber);
    }
}
```

Explanation:

`name` is private in `Person`.

`Student` uses `getName()` to read it.

This keeps data safe and still allows reuse.

## Inheritance with Packages

Inheritance behavior depends on access modifiers and packages.

If child class is in a different package:

- It can access public members.
- It can access protected members through inheritance.
- It cannot access default members.
- It cannot access private members.

Example:

```java
package company;

public class Employee {
    protected String name = "Sabya";
    String department = "IT";
}
```

```java
package app;

import company.Employee;

public class Developer extends Employee {
    public void show() {
        System.out.println(name);
        // System.out.println(department); // Error
    }
}
```

Explanation:

`name` is protected, so the child class can access it.

`department` has default access, so it is not accessible outside the package.

## Method Overriding Access Rule

A child class cannot reduce the access level of an overridden method.

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
    // Error: cannot reduce visibility from public to protected
    protected void show() {
        System.out.println("Child");
    }
}
```

## Exception Rule in Overriding

If a parent method declares a checked exception, the child method can:

- Declare the same exception
- Declare a subclass exception
- Declare no exception

The child method cannot declare a broader checked exception.

```java
import java.io.IOException;

class Parent {
    void readFile() throws IOException {
        System.out.println("Parent reads file");
    }
}

class Child extends Parent {
    @Override
    void readFile() throws IOException {
        System.out.println("Child reads file");
    }
}
```

This is valid.

## Real-Life Example: Bank Account

```java
class BankAccount {
    private String accountHolder;
    private double balance;

    BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive");
            return;
        }
        balance = balance + amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdraw amount must be positive");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance");
            return;
        }
        balance = balance - amount;
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    SavingsAccount(String accountHolder, double balance, double interestRate) {
        super(accountHolder, balance);
        this.interestRate = interestRate;
    }

    public void showInterestRate() {
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

public class Main {
    public static void main(String[] args) {
        SavingsAccount account = new SavingsAccount("Sabya", 10000, 5.5);

        account.deposit(2000);
        account.withdraw(1500);

        System.out.println("Holder: " + account.getAccountHolder());
        System.out.println("Balance: " + account.getBalance());
        account.showInterestRate();
    }
}
```

Output:

```text
Holder: Sabya
Balance: 10500.0
Interest Rate: 5.5%
```

Program explanation:

`BankAccount` contains common account details and operations.

`SavingsAccount` extends `BankAccount` and adds `interestRate`.

`super(accountHolder, balance)` calls the parent constructor.

The `SavingsAccount` object can call inherited methods like `deposit()`, `withdraw()`, `getBalance()`, and `getAccountHolder()`.

## Complete Example with Overriding and Polymorphism

```java
class Employee {
    private String name;
    private double baseSalary;

    Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public double calculateSalary() {
        return baseSalary;
    }
}

class FullTimeEmployee extends Employee {
    private double bonus;

    FullTimeEmployee(String name, double baseSalary, double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return super.calculateSalary() + bonus;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    PartTimeEmployee(String name, int hoursWorked, double hourlyRate) {
        super(name, 0);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new FullTimeEmployee("Sabya", 50000, 10000);
        Employee employee2 = new PartTimeEmployee("Rahul", 80, 500);

        printSalary(employee1);
        printSalary(employee2);
    }

    static void printSalary(Employee employee) {
        System.out.println(employee.getName() + " salary: " + employee.calculateSalary());
    }
}
```

Output:

```text
Sabya salary: 60000.0
Rahul salary: 40000.0
```

Program explanation:

`Employee` is the parent class.

`FullTimeEmployee` and `PartTimeEmployee` are child classes.

Both child classes override `calculateSalary()`.

`printSalary()` accepts an `Employee` reference.

At runtime, Java calls the correct `calculateSalary()` method depending on the actual object.

This example shows inheritance, encapsulation, method overriding, and runtime polymorphism together.

## Advantages of Inheritance

- Code reusability
- Less duplicate code
- Easier maintenance
- Better organization of related classes
- Supports method overriding
- Supports runtime polymorphism
- Helps build extensible applications
- Makes common behavior reusable in parent classes

## Disadvantages of Inheritance

- Parent and child classes become tightly connected
- Changes in parent class can affect child classes
- Deep inheritance chains can become confusing
- Wrong inheritance can create poor design
- Child class may inherit behavior it does not need

## Best Practices

- Use inheritance only when there is a clear IS-A relationship.
- Keep parent class fields private.
- Use protected methods carefully.
- Prefer composition for HAS-A relationships.
- Avoid very deep inheritance chains.
- Use `@Override` for overridden methods.
- Do not use inheritance only to reuse one or two methods.
- Make classes `final` when they should not be extended.
- Design parent classes carefully because child classes depend on them.

## Common Mistakes

Mistake 1:

Using inheritance for HAS-A relationship.

```java
class Car extends Engine {
}
```

Better:

```java
class Car {
    private Engine engine;
}
```

Mistake 2:

Trying to access private parent fields directly.

```java
class Parent {
    private int number = 10;
}

class Child extends Parent {
    void show() {
        // System.out.println(number); // Error
    }
}
```

Mistake 3:

Forgetting that constructors are not inherited.

Mistake 4:

Confusing method overloading with method overriding.

Mistake 5:

Thinking static methods are overridden. Static methods are hidden, not overridden.

## Interview Questions

### What is inheritance?

Inheritance is an OOP concept where one class acquires the properties and methods of another class using the `extends` keyword. It helps with code reuse, method overriding, and runtime polymorphism.

### Which keyword is used for inheritance in Java?

The `extends` keyword is used for class inheritance.

```java
class Dog extends Animal {
}
```

### Does Java support multiple inheritance?

Java does not support multiple inheritance with classes.

Java supports multiple inheritance through interfaces.

### Are constructors inherited?

No, constructors are not inherited.

But when a child object is created, the parent constructor is called first.

### Can private members be inherited?

Private members are part of the parent object state, but they are not directly accessible in the child class.

They can be accessed through public or protected methods.

### What is method overriding?

Method overriding means a child class provides its own implementation of a parent class method with the same method signature.

### What is the use of `super`?

`super` is used to call the parent class constructor, parent class method, or parent class field.

### What is runtime polymorphism?

Runtime polymorphism means Java decides at runtime which overridden method to execute based on the actual object.

### What is the root class of all Java classes?

`Object` is the root class of all Java classes.

## Quick Revision Table

| Concept | Short Meaning |
| --- | --- |
| Inheritance | One class acquires another class members |
| `extends` | Creates class inheritance |
| Parent class | Class being inherited |
| Child class | Class that inherits |
| `super()` | Calls parent constructor |
| `super.method()` | Calls parent method |
| Overriding | Child redefines parent method |
| Runtime polymorphism | Method call decided at runtime |
| `final` class | Cannot be inherited |
| `final` method | Cannot be overridden |
| Abstract class | Incomplete class designed for inheritance |
| Interface | Contract implemented by classes |
| IS-A | Use inheritance |
| HAS-A | Use composition |

## One-Line Memory Trick

Inheritance = child class reuses parent class features using `extends`.
