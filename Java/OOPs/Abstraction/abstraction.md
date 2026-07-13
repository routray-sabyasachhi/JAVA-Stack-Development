# Abstraction in Java

Abstraction is one of the four main pillars of Object-Oriented Programming.

> Abstraction means showing only the essential details to the user and hiding the internal implementation details.

In simple words:

> Abstraction tells what an object does, but hides how it does it.

Real-life examples:

- When you drive a car, you use the steering, accelerator, brake, and gear. You do not need to know the complete engine mechanism.
- When you use an ATM, you enter a PIN and withdraw money. You do not see the internal banking process.
- When you make a phone call, you press a contact and call. You do not handle network tower communication manually.
- When you use `System.out.println()`, you know it prints output. You do not need to know the internal working of output streams at the beginning.

Abstraction helps us focus on functionality instead of internal complexity.

## Why Abstraction Is Needed

Without abstraction, users of a class may need to understand too many internal details.

Example without abstraction:

```java
class Car {
    void startFuelPump() {
        System.out.println("Fuel pump started");
    }

    void startEngineMotor() {
        System.out.println("Engine motor started");
    }

    void injectFuel() {
        System.out.println("Fuel injected");
    }

    void igniteSparkPlug() {
        System.out.println("Spark plug ignited");
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car();

        car.startFuelPump();
        car.startEngineMotor();
        car.injectFuel();
        car.igniteSparkPlug();
    }
}
```

Problem:

- The user must know every internal step.
- The code becomes harder to use.
- Internal implementation is exposed.
- If internal steps change, outside code must also change.

With abstraction:

```java
class Car {
    void start() {
        startFuelPump();
        startEngineMotor();
        injectFuel();
        igniteSparkPlug();
        System.out.println("Car started");
    }

    private void startFuelPump() {
        System.out.println("Fuel pump started");
    }

    private void startEngineMotor() {
        System.out.println("Engine motor started");
    }

    private void injectFuel() {
        System.out.println("Fuel injected");
    }

    private void igniteSparkPlug() {
        System.out.println("Spark plug ignited");
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();
    }
}
```

Now the user only calls `start()`.

The internal steps are hidden inside private methods.

This is abstraction.

## Main Definition

Abstraction is the process of hiding internal implementation details and showing only necessary functionality to the user.

In Java, abstraction is mainly achieved using:

1. Abstract classes
2. Interfaces

## Important Terms

| Term | Meaning |
| --- | --- |
| Abstraction | Hiding implementation and showing required functionality |
| Abstract class | A class declared with `abstract` keyword |
| Abstract method | A method without body |
| Concrete method | A normal method with body |
| Interface | A contract that classes implement |
| Implementation | Actual code written inside a method |
| `abstract` keyword | Used to create abstract classes and abstract methods |
| `extends` | Used by a class to inherit an abstract class |
| `implements` | Used by a class to implement an interface |

## How Java Achieves Abstraction

Java provides two main tools for abstraction:

```text
Abstraction
|
|-- Abstract class
|-- Interface
```

Abstract class gives partial abstraction.

Interface gives full abstraction in the traditional sense, because it focuses on behavior contracts.

Modern Java interfaces can also have default and static methods, but they are still mainly used for abstraction.

## 1. Abstract Class

An abstract class is a class declared using the `abstract` keyword.

Syntax:

```java
abstract class ClassName {
    // abstract methods
    // concrete methods
}
```

Example:

```java
abstract class Animal {
    abstract void sound();

    void eat() {
        System.out.println("Animal eats food");
    }
}
```

Explanation:

`Animal` is an abstract class.

`sound()` is an abstract method because it has no body.

`eat()` is a concrete method because it has a body.

## Abstract Method

An abstract method is a method that has only declaration and no body.

```java
abstract void sound();
```

Important points:

- It is declared with the `abstract` keyword.
- It does not have a method body.
- It ends with a semicolon.
- It must be inside an abstract class or interface.
- A child class must override it, unless the child class is also abstract.

## Concrete Method

A concrete method is a normal method with a body.

```java
void eat() {
    System.out.println("Animal eats food");
}
```

An abstract class can contain concrete methods.

This is useful when child classes share common behavior.

## Simple Abstract Class Example

```java
abstract class Animal {
    abstract void sound();

    void sleep() {
        System.out.println("Animal is sleeping");
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
        Dog dog = new Dog();
        dog.sound();
        dog.sleep();

        Cat cat = new Cat();
        cat.sound();
        cat.sleep();
    }
}
```

Output:

```text
Dog barks
Animal is sleeping
Cat meows
Animal is sleeping
```

Program explanation:

`Animal` is abstract because the exact sound is different for each animal.

`Dog` provides its own implementation of `sound()`.

`Cat` provides its own implementation of `sound()`.

`sleep()` is common for all animals, so it is written once in the abstract class.

This shows abstraction and code reuse together.

## Can We Create Object of Abstract Class?

No, we cannot create an object of an abstract class directly.

Invalid code:

```java
abstract class Animal {
    abstract void sound();
}

public class Main {
    public static void main(String[] args) {
        // Animal animal = new Animal(); // Error
    }
}
```

Reason:

An abstract class may have incomplete methods.

So Java does not allow direct object creation.

But we can create a reference of an abstract class.

```java
Animal animal = new Dog();
```

This is allowed because the actual object is `Dog`, and `Dog` provides implementation.

## Abstract Class Reference

An abstract class reference can point to a child class object.

```java
abstract class Shape {
    abstract void draw();
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
        Shape shape;

        shape = new Circle();
        shape.draw();

        shape = new Rectangle();
        shape.draw();
    }
}
```

Output:

```text
Drawing circle
Drawing rectangle
```

Explanation:

`Shape` is an abstract reference.

It points to `Circle` first and `Rectangle` later.

The same `draw()` call behaves differently depending on the object.

This is abstraction with runtime polymorphism.

## Rules of Abstract Class

- An abstract class is declared with `abstract`.
- An abstract class can have abstract methods.
- An abstract class can have concrete methods.
- An abstract class can have constructors.
- An abstract class can have instance variables.
- An abstract class can have static variables.
- An abstract class can have final variables.
- An abstract class can have private, protected, default, and public members.
- An abstract class cannot be instantiated directly.
- If a class has at least one abstract method, the class must be abstract.
- A child class must implement all abstract methods, unless the child class is also abstract.

## Abstract Class with Constructor

An abstract class can have a constructor.

The constructor is called when a child class object is created.

```java
abstract class Employee {
    String name;

    Employee(String name) {
        this.name = name;
        System.out.println("Employee constructor called");
    }

    abstract double calculateSalary();
}

class FullTimeEmployee extends Employee {
    double monthlySalary;

    FullTimeEmployee(String name, double monthlySalary) {
        super(name);
        this.monthlySalary = monthlySalary;
    }

    @Override
    double calculateSalary() {
        return monthlySalary;
    }
}

public class Main {
    public static void main(String[] args) {
        FullTimeEmployee employee = new FullTimeEmployee("Sabya", 50000);
        System.out.println(employee.name);
        System.out.println(employee.calculateSalary());
    }
}
```

Output:

```text
Employee constructor called
Sabya
50000.0
```

Explanation:

We cannot create `Employee` object directly.

But when `FullTimeEmployee` object is created, the `Employee` constructor runs first.

The constructor initializes common data.

## Abstract Class with Variables

An abstract class can contain variables.

```java
abstract class BankAccount {
    protected String accountHolder;
    protected double balance;

    BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    abstract void calculateInterest();

    void showBalance() {
        System.out.println(accountHolder + " balance: " + balance);
    }
}
```

Explanation:

`accountHolder` and `balance` are common data.

Every child account type can reuse them.

## Abstract Class with Final Method

An abstract class can have final methods.

Final methods cannot be overridden by child classes.

```java
abstract class BankAccount {
    final void bankPolicy() {
        System.out.println("Minimum balance rule applies");
    }

    abstract void calculateInterest();
}
```

Explanation:

`bankPolicy()` is fixed behavior.

Child classes cannot change it.

## Abstract Class with Static Method

An abstract class can have static methods.

```java
abstract class Utility {
    static void printAppName() {
        System.out.println("Banking Application");
    }
}

public class Main {
    public static void main(String[] args) {
        Utility.printAppName();
    }
}
```

Output:

```text
Banking Application
```

Explanation:

Static methods belong to the class.

They can be called using the abstract class name.

## Can Abstract Method Be Private?

No, an abstract method cannot be private.

Invalid code:

```java
abstract class Animal {
    // private abstract void sound(); // Error
}
```

Reason:

An abstract method must be implemented by a child class.

Private methods are not visible to child classes.

So private abstract methods are not allowed.

## Can Abstract Method Be Final?

No, an abstract method cannot be final.

Invalid code:

```java
abstract class Animal {
    // final abstract void sound(); // Error
}
```

Reason:

An abstract method must be overridden.

A final method cannot be overridden.

So `abstract` and `final` conflict.

## Can Abstract Method Be Static?

No, an abstract method cannot be static.

Invalid code:

```java
abstract class Animal {
    // static abstract void sound(); // Error
}
```

Reason:

Static methods belong to the class and are not overridden in the runtime-polymorphism sense.

Abstract methods are meant to be overridden by child classes.

So static abstract methods are not allowed.

## Abstract Child Class

If a child class does not implement all abstract methods, it must also be abstract.

```java
abstract class Animal {
    abstract void sound();
    abstract void move();
}

abstract class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

class Puppy extends Dog {
    @Override
    void move() {
        System.out.println("Puppy runs");
    }
}
```

Explanation:

`Dog` implements only `sound()`.

It does not implement `move()`, so `Dog` must be abstract.

`Puppy` implements the remaining `move()` method, so it can be concrete.

## 2. Interface

An interface is a contract that tells what a class must do.

Syntax:

```java
interface InterfaceName {
    void methodName();
}
```

Example:

```java
interface Payment {
    void pay(double amount);
}
```

Explanation:

Any class that implements `Payment` must provide the `pay()` method.

## Interface Example

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

Program explanation:

`Payment` is an interface.

`UpiPayment` and `CardPayment` implement the interface.

Both classes provide their own `pay()` implementation.

The user knows only the `pay()` method, not the internal payment logic.

This is abstraction.

## Interface Rules

- An interface is declared using the `interface` keyword.
- Interface methods are public and abstract by default.
- Interface variables are public, static, and final by default.
- A class uses `implements` to implement an interface.
- A class can implement multiple interfaces.
- An interface cannot have a constructor.
- An interface cannot be instantiated directly.
- An interface can extend another interface.
- Interface methods must be implemented as `public` in implementing classes.

## Interface Methods Are Public by Default

```java
interface Animal {
    void sound();
}

class Dog implements Animal {
    public void sound() {
        System.out.println("Dog barks");
    }
}
```

Explanation:

`sound()` in the interface is automatically `public abstract`.

So the implementation in `Dog` must be `public`.

If `public` is missing, Java gives an error because access visibility becomes weaker.

## Interface Variables Are Constants

```java
interface Bank {
    String BANK_NAME = "ABC Bank";
}

class Account implements Bank {
    void showBankName() {
        System.out.println(BANK_NAME);
    }
}
```

Explanation:

`BANK_NAME` is automatically:

```java
public static final String BANK_NAME = "ABC Bank";
```

So interface variables are constants.

## Multiple Inheritance Through Interface

Java does not support multiple inheritance with classes.

But Java supports multiple inheritance through interfaces.

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

Output:

```text
Printing document
Scanning document
```

Explanation:

`PrinterMachine` implements two interfaces.

So Java achieves multiple behavior inheritance through interfaces.

## Interface Extending Interface

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
        System.out.println("Electric car started");
    }

    public void charge() {
        System.out.println("Electric car charging");
    }
}
```

Explanation:

`ElectricVehicle` extends `Vehicle`.

So any class implementing `ElectricVehicle` must implement both `start()` and `charge()`.

## Class Extends Class and Implements Interface

A class can extend one class and implement multiple interfaces.

```java
class Person {
    String name;

    Person(String name) {
        this.name = name;
    }
}

interface Coder {
    void code();
}

interface Tester {
    void test();
}

class Developer extends Person implements Coder, Tester {
    Developer(String name) {
        super(name);
    }

    public void code() {
        System.out.println(name + " writes code");
    }

    public void test() {
        System.out.println(name + " tests code");
    }
}
```

Explanation:

`Developer` extends one class: `Person`.

`Developer` implements two interfaces: `Coder` and `Tester`.

This is common in Java.

## Default Method in Interface

An interface can have a default method.

A default method has a body.

```java
interface Vehicle {
    void start();

    default void stop() {
        System.out.println("Vehicle stopped");
    }
}

class Car implements Vehicle {
    public void start() {
        System.out.println("Car started");
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();
        car.stop();
    }
}
```

Output:

```text
Car started
Vehicle stopped
```

Explanation:

`start()` must be implemented by `Car`.

`stop()` already has a default implementation in the interface.

## Overriding Default Method

A class can override a default method.

```java
interface Vehicle {
    default void stop() {
        System.out.println("Vehicle stopped");
    }
}

class Car implements Vehicle {
    public void stop() {
        System.out.println("Car stopped safely");
    }
}
```

Explanation:

The interface gives default behavior.

The class can change it when needed.

## Static Method in Interface

An interface can have static methods.

```java
interface Calculator {
    static int add(int a, int b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Calculator.add(10, 20));
    }
}
```

Output:

```text
30
```

Explanation:

Static interface methods are called using the interface name.

They are not called using implementation objects.

## Private Method in Interface

Interfaces can have private helper methods.

```java
interface Logger {
    default void logInfo(String message) {
        log("INFO", message);
    }

    default void logError(String message) {
        log("ERROR", message);
    }

    private void log(String level, String message) {
        System.out.println(level + ": " + message);
    }
}

class ConsoleLogger implements Logger {
}
```

Explanation:

`log()` is a private helper method inside the interface.

It reduces duplicate code between default methods.

## Functional Interface

A functional interface has exactly one abstract method.

```java
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);
}

public class Main {
    public static void main(String[] args) {
        Calculator addition = (a, b) -> a + b;
        System.out.println(addition.calculate(10, 20));
    }
}
```

Output:

```text
30
```

Explanation:

`Calculator` has one abstract method: `calculate()`.

So it can be used with a lambda expression.

This is abstraction used in modern Java.

## Abstract Class vs Interface

| Feature | Abstract Class | Interface |
| --- | --- | --- |
| Keyword | `abstract class` | `interface` |
| Used by class | `extends` | `implements` |
| Object creation | Cannot create direct object | Cannot create direct object |
| Constructors | Allowed | Not allowed |
| Instance variables | Allowed | Not normal instance variables |
| Method body | Abstract and concrete methods allowed | Abstract, default, static, private methods allowed |
| Multiple inheritance | A class can extend only one class | A class can implement multiple interfaces |
| Access modifiers | Supports all normal access modifiers | Abstract methods are public by default |
| Best use | Shared state plus common behavior | Common contract or capability |

## When to Use Abstract Class

Use an abstract class when:

- Classes have an IS-A relationship.
- Child classes share common fields.
- Child classes share common methods.
- You want to provide partial implementation.
- You need constructors.

Example:

```java
abstract class Employee {
    private String name;
    private int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    abstract double calculateSalary();
}
```

`Employee` is a good abstract class because all employees have common data like name and id.

## When to Use Interface

Use an interface when:

- Different classes need a common capability.
- You want multiple inheritance of behavior contracts.
- You want loose coupling.
- You want to define what must be done, not how.

Example:

```java
interface Payable {
    void pay();
}

class Employee implements Payable {
    public void pay() {
        System.out.println("Salary paid");
    }
}

class Vendor implements Payable {
    public void pay() {
        System.out.println("Vendor bill paid");
    }
}
```

`Employee` and `Vendor` are different types, but both are payable.

So interface is a good choice.

## Abstraction vs Encapsulation

| Feature | Abstraction | Encapsulation |
| --- | --- | --- |
| Meaning | Hides implementation details | Hides data |
| Focus | What an object does | How data is protected |
| Achieved by | Abstract class and interface | Private variables, getters, setters |
| Example | `payment.pay()` hides payment process | `private balance` protects balance |

Simple memory:

Abstraction hides implementation.

Encapsulation hides data.

## Abstraction vs Inheritance

| Feature | Abstraction | Inheritance |
| --- | --- | --- |
| Meaning | Hides implementation and exposes behavior | Child class acquires parent members |
| Purpose | Reduce complexity | Reuse and extend code |
| Keywords | `abstract`, `interface` | `extends` |
| Example | `Shape` defines `draw()` | `Circle extends Shape` |

Abstraction often uses inheritance, but both are not the same.

## Abstraction vs Polymorphism

| Feature | Abstraction | Polymorphism |
| --- | --- | --- |
| Meaning | Hides implementation | One name, many forms |
| Focus | What should be done | Which implementation runs |
| Achieved by | Abstract class, interface | Overloading, overriding |
| Example | `Payment` interface | `payment.pay()` calls UPI or card version |

Abstraction defines the common contract.

Polymorphism chooses the correct implementation at runtime.

## Real-Life Example: Payment System

```java
interface Payment {
    void pay(double amount);
}

class UpiPayment implements Payment {
    private String upiId;

    UpiPayment(String upiId) {
        this.upiId = upiId;
    }

    public void pay(double amount) {
        validateUpi();
        System.out.println("Paid " + amount + " using UPI ID: " + upiId);
    }

    private void validateUpi() {
        System.out.println("UPI validated");
    }
}

class CardPayment implements Payment {
    private String cardNumber;

    CardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void pay(double amount) {
        validateCard();
        System.out.println("Paid " + amount + " using card: " + cardNumber);
    }

    private void validateCard() {
        System.out.println("Card validated");
    }
}

class Checkout {
    void completePayment(Payment payment, double amount) {
        payment.pay(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        Checkout checkout = new Checkout();

        checkout.completePayment(new UpiPayment("sabya@upi"), 1500);
        checkout.completePayment(new CardPayment("XXXX-1234"), 2500);
    }
}
```

Output:

```text
UPI validated
Paid 1500.0 using UPI ID: sabya@upi
Card validated
Paid 2500.0 using card: XXXX-1234
```

Program explanation:

`Payment` hides the internal payment process.

`Checkout` only knows that every payment has a `pay()` method.

`UpiPayment` handles UPI validation internally.

`CardPayment` handles card validation internally.

The user of `Checkout` does not need to know how UPI or card payment works.

This is abstraction.

## Real-Life Example: Shape Area

```java
abstract class Shape {
    abstract double area();

    void printArea() {
        System.out.println("Area: " + area());
    }
}

class Circle extends Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return 3.14 * radius * radius;
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }
}

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(10, 6);

        circle.printArea();
        rectangle.printArea();
    }
}
```

Output:

```text
Area: 78.5
Area: 60.0
```

Program explanation:

`Shape` defines what every shape must do: calculate area.

`Circle` and `Rectangle` decide how area is calculated.

The user calls `printArea()` without knowing the internal formula details.

## Real-Life Example: Bank Account

```java
abstract class BankAccount {
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
            System.out.println("Invalid deposit amount");
            return;
        }
        balance = balance + amount;
    }

    abstract void showAccountType();
}

class SavingsAccount extends BankAccount {
    SavingsAccount(String accountHolder, double balance) {
        super(accountHolder, balance);
    }

    @Override
    void showAccountType() {
        System.out.println("Savings account");
    }
}

class CurrentAccount extends BankAccount {
    CurrentAccount(String accountHolder, double balance) {
        super(accountHolder, balance);
    }

    @Override
    void showAccountType() {
        System.out.println("Current account");
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount account = new SavingsAccount("Sabya", 10000);

        account.deposit(2000);
        account.showAccountType();
        System.out.println(account.getAccountHolder());
        System.out.println(account.getBalance());
    }
}
```

Output:

```text
Savings account
Sabya
12000.0
```

Program explanation:

`BankAccount` hides common account logic like balance handling.

Child classes only define their specific account type.

The user works with `BankAccount` reference and does not need internal details.

## Real-Life Example: Notification System

```java
interface NotificationSender {
    void send(String message);
}

class EmailSender implements NotificationSender {
    public void send(String message) {
        connectToEmailServer();
        System.out.println("Email sent: " + message);
    }

    private void connectToEmailServer() {
        System.out.println("Connected to email server");
    }
}

class SmsSender implements NotificationSender {
    public void send(String message) {
        connectToSmsGateway();
        System.out.println("SMS sent: " + message);
    }

    private void connectToSmsGateway() {
        System.out.println("Connected to SMS gateway");
    }
}

class NotificationService {
    void notifyUser(NotificationSender sender, String message) {
        sender.send(message);
    }
}
```

Explanation:

`NotificationService` does not know how email or SMS works internally.

It only depends on the `NotificationSender` abstraction.

This makes the code flexible and loosely coupled.

## Abstraction and Loose Coupling

Loose coupling means classes depend less on concrete implementation and more on abstraction.

Tightly coupled code:

```java
class OrderService {
    private EmailSender emailSender = new EmailSender();

    void placeOrder() {
        emailSender.send("Order placed");
    }
}
```

Problem:

`OrderService` directly depends on `EmailSender`.

Better code using abstraction:

```java
interface MessageSender {
    void send(String message);
}

class EmailSender implements MessageSender {
    public void send(String message) {
        System.out.println("Email: " + message);
    }
}

class SmsSender implements MessageSender {
    public void send(String message) {
        System.out.println("SMS: " + message);
    }
}

class OrderService {
    private MessageSender sender;

    OrderService(MessageSender sender) {
        this.sender = sender;
    }

    void placeOrder() {
        sender.send("Order placed");
    }
}
```

Explanation:

`OrderService` depends on `MessageSender`, not on a specific email or SMS class.

This is abstraction and loose coupling.

This idea is very important in Spring Boot dependency injection.

## Abstraction in Java Built-In Classes

Java uses abstraction everywhere.

Example with `List`:

```java
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names;

        names = new ArrayList<>();
        names.add("Sabya");

        names = new LinkedList<>();
        names.add("Rahul");
    }
}
```

Explanation:

`List` is an interface.

`ArrayList` and `LinkedList` are implementations.

The user works with the `List` abstraction.

The internal storage mechanism is hidden.

## Abstraction in JDBC

JDBC also uses abstraction.

```java
Connection connection = DriverManager.getConnection(url, username, password);
Statement statement = connection.createStatement();
ResultSet resultSet = statement.executeQuery("select * from users");
```

Explanation:

`Connection`, `Statement`, and `ResultSet` are interfaces.

Different database vendors provide their own implementations.

The developer writes common JDBC code without knowing the internal driver implementation.

## Abstraction in Spring Boot

Spring Boot uses abstraction heavily.

Example:

```java
interface UserRepository {
    void saveUser(String name);
}

class MySqlUserRepository implements UserRepository {
    public void saveUser(String name) {
        System.out.println("Saved user in MySQL: " + name);
    }
}

class UserService {
    private UserRepository repository;

    UserService(UserRepository repository) {
        this.repository = repository;
    }

    void registerUser(String name) {
        repository.saveUser(name);
    }
}
```

Explanation:

`UserService` depends on the `UserRepository` abstraction.

It does not care whether data is saved in MySQL, MongoDB, file, or API.

This makes code easier to test and maintain.

## Complete Practice Program

```java
abstract class Course {
    private String title;
    private int durationInHours;

    Course(String title, int durationInHours) {
        this.title = title;
        this.durationInHours = durationInHours;
    }

    public String getTitle() {
        return title;
    }

    public int getDurationInHours() {
        return durationInHours;
    }

    abstract void startCourse();

    void showCourseInfo() {
        System.out.println("Course: " + title);
        System.out.println("Duration: " + durationInHours + " hours");
    }
}

interface CertificateProvider {
    void generateCertificate(String studentName);
}

class JavaCourse extends Course implements CertificateProvider {
    JavaCourse() {
        super("Java Full Stack Development", 120);
    }

    @Override
    void startCourse() {
        setupJdk();
        System.out.println("Java course started");
    }

    private void setupJdk() {
        System.out.println("JDK setup completed");
    }

    public void generateCertificate(String studentName) {
        System.out.println("Certificate generated for " + studentName);
    }
}

class PythonCourse extends Course implements CertificateProvider {
    PythonCourse() {
        super("Python Backend Development", 90);
    }

    @Override
    void startCourse() {
        setupPython();
        System.out.println("Python course started");
    }

    private void setupPython() {
        System.out.println("Python setup completed");
    }

    public void generateCertificate(String studentName) {
        System.out.println("Certificate generated for " + studentName);
    }
}

public class Main {
    public static void main(String[] args) {
        Course javaCourse = new JavaCourse();
        javaCourse.showCourseInfo();
        javaCourse.startCourse();

        CertificateProvider certificate = new JavaCourse();
        certificate.generateCertificate("Sabya");
    }
}
```

Output:

```text
Course: Java Full Stack Development
Duration: 120 hours
JDK setup completed
Java course started
Certificate generated for Sabya
```

Program explanation:

`Course` is an abstract class.

It hides common course data and common method `showCourseInfo()`.

`startCourse()` is abstract because each course starts differently.

`CertificateProvider` is an interface because generating certificates is a capability.

`JavaCourse` and `PythonCourse` provide their own setup logic.

The user only calls `startCourse()` and does not need to know setup details.

This program shows abstraction through both abstract class and interface.

## Advantages of Abstraction

- Hides implementation details
- Reduces complexity
- Improves code readability
- Improves security by exposing only required behavior
- Helps achieve loose coupling
- Makes code easier to maintain
- Supports polymorphism
- Supports clean architecture
- Makes large applications easier to manage
- Helps define common contracts through interfaces

## Disadvantages of Abstraction

- Too many abstract layers can make code difficult to understand.
- Beginners may find it harder to trace actual implementation.
- Poor abstraction design can create unnecessary complexity.
- Changing an abstraction can affect many implementing classes.

## Best Practices

- Use abstraction to hide complexity, not to make simple things complicated.
- Use abstract class when classes share common state and behavior.
- Use interface when classes share a capability or contract.
- Keep abstraction names clear and meaningful.
- Do not expose unnecessary internal methods as public.
- Prefer private helper methods for internal steps.
- Program to an interface when flexibility is needed.
- Keep abstract methods focused and simple.
- Do not create an abstract class if no common behavior or state exists.
- Do not create an interface for only one implementation unless future flexibility is expected.

## Common Mistakes

Mistake 1:

Trying to create an object of an abstract class.

```java
abstract class Animal {
}

// Animal animal = new Animal(); // Error
```

Mistake 2:

Forgetting to implement abstract methods.

```java
abstract class Animal {
    abstract void sound();
}

// class Dog extends Animal { } // Error unless sound() is implemented
```

Mistake 3:

Using weaker access while implementing interface methods.

```java
interface Animal {
    void sound();
}

class Dog implements Animal {
    // void sound() { } // Error

    public void sound() {
        System.out.println("Dog barks");
    }
}
```

Mistake 4:

Confusing abstraction with encapsulation.

Abstraction hides implementation details.

Encapsulation hides data using private variables and controlled methods.

Mistake 5:

Making every class abstract or every behavior an interface without a real need.

Good abstraction should simplify code, not complicate it.

## Interview Questions

### What is abstraction?

Abstraction is an OOP concept that hides internal implementation details and shows only necessary functionality to the user.

### How is abstraction achieved in Java?

Abstraction is achieved using abstract classes and interfaces.

### What is an abstract class?

An abstract class is a class declared with the `abstract` keyword. It can have abstract methods, concrete methods, variables, constructors, and static methods.

### What is an abstract method?

An abstract method is a method without a body. It must be implemented by a child class unless the child class is also abstract.

### Can we create an object of an abstract class?

No. We cannot create an object of an abstract class directly.

### Can an abstract class have a constructor?

Yes. An abstract class can have a constructor. It is called when a child class object is created.

### Can an abstract class have concrete methods?

Yes. An abstract class can have concrete methods with method bodies.

### Can an abstract method be private?

No. An abstract method cannot be private because child classes must be able to access and implement it.

### Can an abstract method be final?

No. An abstract method cannot be final because abstract methods must be overridden and final methods cannot be overridden.

### Can an abstract method be static?

No. Abstract methods cannot be static because static methods are not overridden in the runtime-polymorphism sense.

### What is an interface?

An interface is a contract that defines methods a class must implement.

### Can a class implement multiple interfaces?

Yes. A class can implement multiple interfaces.

### Can an interface have a constructor?

No. Interfaces cannot have constructors.

### What is the difference between abstract class and interface?

An abstract class is used when related classes share common state and behavior. An interface is used to define a common contract or capability that multiple classes can implement.

### What is partial abstraction?

Partial abstraction means some methods are implemented and some methods are abstract. Abstract classes can provide partial abstraction.

### What is full abstraction?

Full abstraction means only method declarations are exposed and implementation is provided by implementing classes. Interfaces traditionally provide full abstraction.

## Quick Revision Table

| Concept | Short Meaning |
| --- | --- |
| Abstraction | Hide implementation, show functionality |
| Abstract class | Incomplete class declared with `abstract` |
| Abstract method | Method without body |
| Concrete method | Method with body |
| Interface | Contract implemented by classes |
| `extends` | Used to inherit abstract class |
| `implements` | Used to implement interface |
| Constructor in abstract class | Allowed |
| Constructor in interface | Not allowed |
| Abstract class object | Not allowed directly |
| Interface object | Not allowed directly |
| Abstract class reference | Can point to child object |
| Interface reference | Can point to implementation object |
| Abstraction vs encapsulation | Implementation hiding vs data hiding |

## One-Line Memory Trick

Abstraction = show what is needed, hide how it works.
