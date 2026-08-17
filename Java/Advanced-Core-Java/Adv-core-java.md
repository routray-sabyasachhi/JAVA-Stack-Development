# Advanced Core Java

Advanced Core Java covers the deeper features of the Java language and standard library that are important for professional Java development, backend development, interviews, system design, and frameworks such as Spring.

> Advanced Core Java means understanding how Java works beyond basic syntax, OOP, collections, and simple programs.

In simple words:

> Advanced Core Java focuses on powerful language features, runtime behavior, memory management, concurrency, I/O, reflection, annotations, functional programming, and other features used in real Java applications.

---

# What Comes Under Advanced Core Java?

Important Advanced Core Java topics include:

* Nested classes
* Inner classes
* Anonymous classes
* Enum
* Annotation
* Reflection
* Exception handling
* Custom exceptions
* Assertions
* I/O
* NIO
* Serialization
* Deserialization
* Lambda expressions
* Functional interfaces
* Method references
* Stream API
* Optional
* Date and Time API
* Multithreading
* Concurrency
* Executor Framework
* Synchronization
* Locks
* Atomic classes
* Concurrent collections
* JVM memory concepts
* Garbage collection
* Class loading
* Modules
* Records
* Sealed classes
* Pattern matching
* Generics
* Comparable and Comparator
* Immutability
* Object cloning
* Annotations and metadata
* Dynamic proxies

---

# 1. Nested Classes

A nested class is a class declared inside another class.

Example:

```java
class Outer {

    class Inner {

        void show() {

            System.out.println("Inner class");
        }
    }
}
```

Usage:

```java
public class Main {

    public static void main(String[] args) {

        Outer outer = new Outer();

        Outer.Inner inner =
                outer.new Inner();

        inner.show();
    }
}
```

Output:

```text
Inner class
```

---

# Types of Nested Classes

Java has several types of nested classes:

1. Static nested class
2. Non-static inner class
3. Local inner class
4. Anonymous inner class

---

# Static Nested Class

A static nested class is declared using `static`.

Example:

```java
class Outer {

    static class Inner {

        void show() {

            System.out.println(
                    "Static nested class"
            );
        }
    }
}
```

Usage:

```java
Outer.Inner inner =
        new Outer.Inner();

inner.show();
```

Important:

A static nested class does not require an object of the outer class.

---

# Non-Static Inner Class

A non-static class inside another class is called an inner class.

Example:

```java
class Outer {

    private int value = 100;

    class Inner {

        void show() {

            System.out.println(value);
        }
    }
}
```

Usage:

```java
Outer outer = new Outer();

Outer.Inner inner =
        outer.new Inner();

inner.show();
```

Output:

```text
100
```

An inner class can directly access members of the outer class.

---

# Local Inner Class

A class declared inside a method, constructor, or block is called a local inner class.

Example:

```java
class Outer {

    void display() {

        class LocalClass {

            void show() {

                System.out.println(
                        "Local inner class"
                );
            }
        }

        LocalClass obj =
                new LocalClass();

        obj.show();
    }
}
```

---

# Anonymous Inner Class

An anonymous class is a class without a name.

Example:

```java
abstract class Animal {

    abstract void sound();
}
```

Using anonymous class:

```java
Animal animal = new Animal() {

    @Override
    void sound() {

        System.out.println("Animal sound");
    }
};

animal.sound();
```

Anonymous classes are useful when a class is required only once.

---

# 2. Enum

An enum is a special Java type used to represent a fixed set of constants.

Example:

```java
enum Day {

    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}
```

Usage:

```java
Day today = Day.MONDAY;

System.out.println(today);
```

Output:

```text
MONDAY
```

---

# Enum with Switch

```java
enum Status {

    SUCCESS,
    FAILED,
    PENDING
}
```

Usage:

```java
Status status = Status.SUCCESS;

switch (status) {

    case SUCCESS:
        System.out.println("Operation successful");
        break;

    case FAILED:
        System.out.println("Operation failed");
        break;

    case PENDING:
        System.out.println("Operation pending");
        break;
}
```

---

# Enum with Fields and Methods

Enums can have fields, constructors, and methods.

Example:

```java
enum Status {

    SUCCESS(200),
    NOT_FOUND(404),
    SERVER_ERROR(500);

    private int code;

    Status(int code) {

        this.code = code;
    }

    public int getCode() {

        return code;
    }
}
```

Usage:

```java
System.out.println(
        Status.SUCCESS.getCode()
);
```

Output:

```text
200
```

---

# Enum with Abstract Methods

Enums can even define abstract methods.

```java
enum Operation {

    ADD {

        @Override
        int calculate(int a, int b) {

            return a + b;
        }
    },

    SUBTRACT {

        @Override
        int calculate(int a, int b) {

            return a - b;
        }
    };

    abstract int calculate(int a, int b);
}
```

Usage:

```java
System.out.println(
        Operation.ADD.calculate(10, 5)
);
```

Output:

```text
15
```

---

# 3. Annotations

Annotations provide metadata about Java code.

Examples:

```java
@Override
@Deprecated
@SuppressWarnings
```

Annotations do not directly execute business logic.

They provide information to:

* Compiler
* JVM
* Frameworks
* Build tools
* Development tools

---

# @Override

`@Override` tells the compiler that a method overrides a superclass method.

Example:

```java
class Animal {

    void sound() {

        System.out.println("Animal sound");
    }
}
```

Child:

```java
class Dog extends Animal {

    @Override
    void sound() {

        System.out.println("Dog barks");
    }
}
```

---

# @Deprecated

Marks an API as deprecated.

```java
class OldAPI {

    @Deprecated
    void oldMethod() {

        System.out.println("Old method");
    }
}
```

The compiler can warn developers when the method is used.

---

# @SuppressWarnings

Suppresses selected compiler warnings.

Example:

```java
@SuppressWarnings("unchecked")
public void method() {

}
```

It should be used carefully.

---

# Custom Annotation

We can create our own annotation.

Syntax:

```java
@interface MyAnnotation {

}
```

Example:

```java
@interface Author {

    String name();
}
```

Usage:

```java
@Author(name = "Sabya")
class Student {

}
```

---

# Annotation Retention

Retention determines how long annotation information is available.

Common retention policies:

```text
SOURCE
CLASS
RUNTIME
```

Example:

```java
@Retention(RetentionPolicy.RUNTIME)
@interface Author {

    String name();
}
```

`RUNTIME` means the annotation can be accessed using reflection.

---

# 4. Reflection

Reflection allows Java programs to inspect and interact with classes, methods, fields, constructors, and annotations at runtime.

Reflection is available through:

```java
java.lang.reflect
```

Example:

```java
class Student {

    private String name;

    public void show() {

        System.out.println("Student");
    }
}
```

Getting class information:

```java
Class<?> clazz =
        Student.class;

System.out.println(
        clazz.getName()
);
```

Output:

```text
Student
```

---

# Getting Class Object

There are three common ways.

### Using `.class`

```java
Class<?> clazz =
        Student.class;
```

### Using `getClass()`

```java
Student student =
        new Student();

Class<?> clazz =
        student.getClass();
```

### Using Class.forName()

```java
Class<?> clazz =
        Class.forName("Student");
```

The last approach is useful when the class name is available dynamically.

---

# Reflection Methods

Reflection can inspect:

* Class name
* Modifiers
* Constructors
* Methods
* Fields
* Interfaces
* Superclass
* Annotations

Example:

```java
Class<?> clazz =
        Student.class;

System.out.println(
        clazz.getName()
);

System.out.println(
        clazz.getSuperclass()
);
```

---

# Reflection and Methods

Example:

```java
class Student {

    public void show() {

        System.out.println("Student");
    }
}
```

Reflection:

```java
Class<?> clazz =
        Student.class;

var methods =
        clazz.getDeclaredMethods();

for (var method : methods) {

    System.out.println(
            method.getName()
    );
}
```

---

# Reflection and Fields

```java
class Student {

    private String name;
}
```

Reflection:

```java
Class<?> clazz =
        Student.class;

var fields =
        clazz.getDeclaredFields();

for (var field : fields) {

    System.out.println(
            field.getName()
    );
}
```

Reflection is heavily used by frameworks.

Examples:

* Spring
* Hibernate
* JUnit
* Dependency injection frameworks

---

# 5. Exception Handling

An exception is an abnormal condition that interrupts the normal flow of program execution.

Example:

```java
int result =
        10 / 0;
```

This produces:

```text
ArithmeticException
```

---

# Exception Hierarchy

Basic hierarchy:

```text
Object
   |
Throwable
   |
   +-- Error
   |
   +-- Exception
         |
         +-- RuntimeException
```

---

# Error

Errors generally represent serious problems associated with the JVM or environment.

Examples:

```text
OutOfMemoryError
StackOverflowError
NoClassDefFoundError
```

Applications normally should not try to recover from every `Error`.

---

# Checked Exception

Checked exceptions are checked by the compiler.

Examples:

```text
IOException
SQLException
ClassNotFoundException
```

Example:

```java
void readFile()
        throws IOException {

}
```

The caller must handle or declare the exception.

---

# Unchecked Exception

Unchecked exceptions are subclasses of `RuntimeException`.

Examples:

```text
NullPointerException
ArithmeticException
ArrayIndexOutOfBoundsException
IllegalArgumentException
```

Example:

```java
String name = null;

System.out.println(
        name.length()
);
```

This causes:

```text
NullPointerException
```

---

# try-catch

```java
try {

    int result =
            10 / 0;

}
catch (ArithmeticException e) {

    System.out.println(
            "Cannot divide by zero"
    );
}
```

---

# Multiple Catch Blocks

```java
try {

    int[] numbers = {10, 20};

    System.out.println(
            numbers[5]
    );

}
catch (ArithmeticException e) {

    System.out.println(
            "Arithmetic error"
    );
}
catch (ArrayIndexOutOfBoundsException e) {

    System.out.println(
            "Array index error"
    );
}
```

---

# Multi-Catch

Java allows multiple exception types in one catch block.

```java
try {

    // code

}
catch (ArithmeticException |
       NullPointerException e) {

    System.out.println(
            "Runtime problem"
    );
}
```

---

# finally

`finally` is used for cleanup code.

```java
try {

    System.out.println("Try");

}
catch (Exception e) {

    System.out.println("Catch");

}
finally {

    System.out.println("Finally");
}
```

The `finally` block normally executes whether an exception occurs or not.

---

# try-with-resources

Try-with-resources automatically closes resources that implement `AutoCloseable`.

Example:

```java
try (
    FileInputStream input =
            new FileInputStream("data.txt")
) {

    int data =
            input.read();

}
catch (IOException e) {

    e.printStackTrace();
}
```

This is preferred over manually closing resources.

---

# Custom Exception

We can create our own exception.

```java
class InvalidAgeException
        extends Exception {

    public InvalidAgeException(
            String message) {

        super(message);
    }
}
```

Usage:

```java
static void checkAge(int age)
        throws InvalidAgeException {

    if (age < 18) {

        throw new InvalidAgeException(
                "Age must be 18 or above"
        );
    }
}
```

---

# throw vs throws

`throw` is used to actually throw an exception.

```java
throw new IllegalArgumentException(
        "Invalid value"
);
```

`throws` declares that a method may throw exceptions.

```java
void readFile()
        throws IOException {

}
```

Memory trick:

```text
throw  → throws an exception
throws → declares an exception
```

---

# Exception Propagation

If a method does not handle an exception, it can propagate to its caller.

Example:

```java
static void method1() {

    int x = 10 / 0;
}
```

```java
static void method2() {

    method1();
}
```

```java
public static void main(String[] args) {

    method2();
}
```

The exception propagates through the call stack until handled.

---

# Exception Chaining

One exception can be associated with another cause.

Example:

```java
try {

    // database operation

}
catch (Exception e) {

    throw new RuntimeException(
            "Database operation failed",
            e
    );
}
```

This preserves the original cause.

---

# 6. Assertions

Assertions are used to test assumptions during development.

Syntax:

```java
assert condition;
```

Example:

```java
int age = 20;

assert age >= 18;
```

With message:

```java
assert age >= 18 :
        "Age must be 18 or above";
```

Assertions are disabled by default.

Enable them using:

```bash
java -ea Main
```

`-ea` means:

```text
enable assertions
```

---

# 7. I/O

Java I/O allows programs to read and write data.

Important packages:

```text
java.io
java.nio
java.nio.file
```

Common I/O operations:

* Read files
* Write files
* Read bytes
* Read characters
* Buffered input/output
* Object serialization

---

# Byte Streams

Byte streams are used for binary data.

Important classes:

```text
InputStream
OutputStream
FileInputStream
FileOutputStream
BufferedInputStream
BufferedOutputStream
```

Example:

```java
try (
    FileInputStream input =
            new FileInputStream("input.txt");

    FileOutputStream output =
            new FileOutputStream("output.txt")
) {

    int data;

    while ((data = input.read()) != -1) {

        output.write(data);
    }

}
catch (IOException e) {

    e.printStackTrace();
}
```

---

# Character Streams

Character streams are designed for character data.

Important classes:

```text
Reader
Writer
FileReader
FileWriter
BufferedReader
BufferedWriter
```

Example:

```java
try (
    BufferedReader reader =
            new BufferedReader(
                    new FileReader("data.txt")
            )
) {

    String line;

    while ((line = reader.readLine()) != null) {

        System.out.println(line);
    }

}
catch (IOException e) {

    e.printStackTrace();
}
```

---

# BufferedReader

`BufferedReader` reads text efficiently using buffering.

Example:

```java
BufferedReader reader =
        new BufferedReader(
                new FileReader("data.txt")
        );

String line =
        reader.readLine();
```

---

# BufferedWriter

```java
BufferedWriter writer =
        new BufferedWriter(
                new FileWriter("data.txt")
        );

writer.write("Hello Java");

writer.newLine();

writer.close();
```

Prefer try-with-resources in production code.

---

# 8. NIO

NIO stands for New I/O.

Important packages:

```text
java.nio
java.nio.file
java.nio.channels
```

NIO provides modern APIs for file and channel operations.

---

# Path

`Path` represents a file or directory path.

```java
Path path =
        Paths.get("data.txt");

System.out.println(
        path.toAbsolutePath()
);
```

Modern Java code can also use:

```java
Path path =
        Path.of("data.txt");
```

---

# Files

`Files` provides utility methods for file operations.

Example:

```java
Path path =
        Path.of("data.txt");

Files.writeString(
        path,
        "Hello Java"
);
```

Reading:

```java
String content =
        Files.readString(path);

System.out.println(content);
```

---

# Creating Directories

```java
Path path =
        Path.of("data");

Files.createDirectories(path);
```

---

# Checking File Existence

```java
Path path =
        Path.of("data.txt");

if (Files.exists(path)) {

    System.out.println(
            "File exists"
    );
}
```

---

# 9. Serialization

Serialization converts an object into a byte stream.

This can be used to store or transfer object state.

A class can implement:

```java
Serializable
```

Example:

```java
class Student
        implements Serializable {

    private int id;
    private String name;

    public Student(
            int id,
            String name) {

        this.id = id;
        this.name = name;
    }
}
```

---

# ObjectOutputStream

Serialization example:

```java
Student student =
        new Student(101, "Sabya");

try (
    ObjectOutputStream output =
        new ObjectOutputStream(
            new FileOutputStream(
                "student.ser"
            )
        )
) {

    output.writeObject(student);

}
catch (IOException e) {

    e.printStackTrace();
}
```

---

# Deserialization

Deserialization converts the byte stream back into an object.

Example:

```java
try (
    ObjectInputStream input =
        new ObjectInputStream(
            new FileInputStream(
                "student.ser"
            )
        )
) {

    Student student =
            (Student) input.readObject();

}
catch (IOException |
       ClassNotFoundException e) {

    e.printStackTrace();
}
```

---

# transient Keyword

The `transient` keyword prevents a field from being serialized.

Example:

```java
class User
        implements Serializable {

    private String username;

    private transient String password;
}
```

`password` will not be serialized.

---

# serialVersionUID

Serializable classes commonly define:

```java
private static final long serialVersionUID = 1L;
```

Example:

```java
class Student
        implements Serializable {

    private static final long
            serialVersionUID = 1L;
}
```

It helps control serialization compatibility between class versions.

---

# 10. Lambda Expressions

Lambda expressions provide a concise way to represent behavior.

Syntax:

```java
(parameters) -> expression
```

Example:

```java
(a, b) -> a + b
```

---

# Lambda Example

```java
List<String> names =
        List.of(
                "Sabya",
                "Rahul",
                "Amit"
        );

names.forEach(
        name -> System.out.println(name)
);
```

Output:

```text
Sabya
Rahul
Amit
```

---

# Lambda with Multiple Statements

```java
name -> {

    System.out.println(
            "Name: " + name
    );

    System.out.println(
            "Length: " + name.length()
    );
}
```

---

# 11. Functional Interface

A functional interface contains exactly one abstract method.

Example:

```java
@FunctionalInterface
interface Calculator {

    int calculate(int a, int b);
}
```

Using lambda:

```java
Calculator add =
        (a, b) -> a + b;

System.out.println(
        add.calculate(10, 20)
);
```

Output:

```text
30
```

---

# Common Functional Interfaces

Java provides many functional interfaces in:

```text
java.util.function
```

Important interfaces:

```text
Predicate<T>
Function<T,R>
Consumer<T>
Supplier<T>
UnaryOperator<T>
BinaryOperator<T>
```

---

# Predicate

`Predicate<T>` accepts a value and returns `boolean`.

Example:

```java
Predicate<Integer> even =
        number -> number % 2 == 0;

System.out.println(
        even.test(10)
);
```

Output:

```text
true
```

---

# Function

`Function<T, R>` accepts one type and returns another type.

```java
Function<String, Integer> length =
        text -> text.length();

System.out.println(
        length.apply("Java")
);
```

Output:

```text
4
```

---

# Consumer

`Consumer<T>` accepts a value and returns nothing.

```java
Consumer<String> printer =
        name -> System.out.println(name);

printer.accept("Sabya");
```

---

# Supplier

`Supplier<T>` does not take an argument but returns a value.

```java
Supplier<String> supplier =
        () -> "Java";

System.out.println(
        supplier.get()
);
```

---

# UnaryOperator

Accepts and returns the same type.

```java
UnaryOperator<Integer> square =
        number -> number * number;

System.out.println(
        square.apply(5)
);
```

Output:

```text
25
```

---

# BinaryOperator

Accepts two values of the same type and returns the same type.

```java
BinaryOperator<Integer> add =
        (a, b) -> a + b;

System.out.println(
        add.apply(10, 20)
);
```

---

# 12. Method References

Method references provide a shorter syntax for lambdas.

Syntax:

```java
ClassName::methodName
```

Example:

```java
List<String> names =
        List.of(
                "Sabya",
                "Rahul",
                "Amit"
        );

names.forEach(
        System.out::println
);
```

Equivalent lambda:

```java
names.forEach(
        name -> System.out.println(name)
);
```

---

# Static Method Reference

```java
class Utility {

    static int square(int number) {

        return number * number;
    }
}
```

Method reference:

```java
Function<Integer, Integer> function =
        Utility::square;
```

---

# Constructor Reference

Syntax:

```java
ClassName::new
```

Example:

```java
Supplier<ArrayList<String>> supplier =
        ArrayList::new;

ArrayList<String> list =
        supplier.get();
```

---

# 13. Stream API

Stream API provides a functional approach to processing collections and other data sources.

Example:

```java
List<Integer> numbers =
        List.of(
                10,
                20,
                30,
                40
        );

numbers.stream()
        .filter(n -> n > 20)
        .forEach(System.out::println);
```

Output:

```text
30
40
```

---

# Stream Pipeline

A stream pipeline generally contains:

```text
Source
   ↓
Intermediate Operations
   ↓
Terminal Operation
```

Example:

```java
numbers.stream()
        .filter(n -> n > 20)
        .map(n -> n * 2)
        .forEach(System.out::println);
```

---

# filter()

`filter()` selects elements based on a condition.

```java
List<Integer> numbers =
        List.of(1, 2, 3, 4, 5);

numbers.stream()
        .filter(n -> n % 2 == 0)
        .forEach(System.out::println);
```

Output:

```text
2
4
```

---

# map()

`map()` transforms elements.

```java
numbers.stream()
        .map(n -> n * 2)
        .forEach(System.out::println);
```

---

# sorted()

```java
numbers.stream()
        .sorted()
        .forEach(System.out::println);
```

---

# distinct()

```java
List<Integer> numbers =
        List.of(
                10,
                20,
                20,
                30
        );

numbers.stream()
        .distinct()
        .forEach(System.out::println);
```

Output:

```text
10
20
30
```

---

# limit()

```java
numbers.stream()
        .limit(2)
        .forEach(System.out::println);
```

---

# reduce()

`reduce()` combines stream elements into a single result.

```java
int sum =
        numbers.stream()
                .reduce(
                        0,
                        Integer::sum
                );

System.out.println(sum);
```

---

# collect()

Streams can be collected into collections.

```java
List<Integer> evenNumbers =
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(
                        Collectors.toList()
                );
```

---

# Stream vs Collection

Collection stores data.

Stream processes data.

```text
Collection → Data
Stream     → Processing
```

A stream does not normally store the elements itself.

---

# 14. Optional

`Optional<T>` represents a value that may or may not be present.

Example:

```java
Optional<String> name =
        Optional.of("Sabya");
```

Checking:

```java
if (name.isPresent()) {

    System.out.println(
            name.get()
    );
}
```

---

# Optional.ofNullable()

Useful when a value may be null.

```java
String value = null;

Optional<String> optional =
        Optional.ofNullable(value);
```

---

# orElse()

```java
String name =
        optional.orElse("Unknown");

System.out.println(name);
```

---

# orElseGet()

```java
String name =
        optional.orElseGet(
                () -> "Unknown"
        );
```

---

# orElseThrow()

```java
String name =
        optional.orElseThrow(
                () -> new IllegalStateException(
                        "Name not found"
                )
        );
```

---

# Optional map()

```java
Optional<String> name =
        Optional.of("Sabya");

Optional<Integer> length =
        name.map(String::length);

System.out.println(
        length.orElse(0)
);
```

---

# 15. Date and Time API

Modern Java provides the Date and Time API in:

```text
java.time
```

Important classes:

```text
LocalDate
LocalTime
LocalDateTime
ZonedDateTime
Instant
Duration
Period
```

---

# LocalDate

```java
LocalDate date =
        LocalDate.now();

System.out.println(date);
```

---

# LocalTime

```java
LocalTime time =
        LocalTime.now();

System.out.println(time);
```

---

# LocalDateTime

```java
LocalDateTime dateTime =
        LocalDateTime.now();

System.out.println(dateTime);
```

---

# Creating a Specific Date

```java
LocalDate date =
        LocalDate.of(
                2026,
                8,
                17
        );
```

---

# Adding Days

```java
LocalDate tomorrow =
        date.plusDays(1);
```

---

# Period

`Period` represents a date-based amount of time.

```java
Period period =
        Period.ofYears(2);

System.out.println(period);
```

---

# Duration

`Duration` represents a time-based amount.

```java
Duration duration =
        Duration.ofHours(5);
```

---

# 16. Multithreading

Multithreading allows multiple threads to execute tasks concurrently.

A thread is a lightweight unit of execution.

---

# Creating a Thread

```java
class MyThread extends Thread {

    @Override
    public void run() {

        System.out.println(
                "Thread running"
        );
    }
}
```

Usage:

```java
MyThread thread =
        new MyThread();

thread.start();
```

Important:

Use:

```java
thread.start();
```

not:

```java
thread.run();
```

`start()` creates a new thread of execution.

---

# Runnable

A better approach is often to use `Runnable`.

```java
Runnable task = () -> {

    System.out.println(
            "Task running"
    );
};

Thread thread =
        new Thread(task);

thread.start();
```

---

# Thread Lifecycle

A thread can move through states such as:

```text
NEW
RUNNABLE
BLOCKED
WAITING
TIMED_WAITING
TERMINATED
```

---

# sleep()

`sleep()` pauses the current thread for a specified amount of time.

```java
try {

    Thread.sleep(1000);

}
catch (InterruptedException e) {

    Thread.currentThread()
            .interrupt();
}
```

---

# join()

`join()` waits for another thread to finish.

```java
Thread thread =
        new Thread(
                () -> System.out.println(
                        "Worker"
                )
        );

thread.start();

try {

    thread.join();

}
catch (InterruptedException e) {

    Thread.currentThread()
            .interrupt();
}
```

---

# 17. Synchronization

Synchronization prevents multiple threads from incorrectly accessing shared mutable data at the same time.

Example:

```java
class Counter {

    private int count;

    public synchronized void increment() {

        count++;
    }

    public int getCount() {

        return count;
    }
}
```

---

# Race Condition

A race condition occurs when the result depends on the timing or ordering of threads accessing shared data.

Example:

```java
count++;
```

This looks like one operation but involves multiple steps:

```text
Read
 ↓
Modify
 ↓
Write
```

Two threads can interfere with each other.

---

# synchronized Method

```java
public synchronized void increment() {

    count++;
}
```

Only one thread can execute the synchronized method on the same object monitor at a time.

---

# synchronized Block

```java
public void increment() {

    synchronized (this) {

        count++;
    }
}
```

A synchronized block allows more precise locking.

---

# 18. volatile

The `volatile` keyword helps provide visibility of changes to a variable across threads.

Example:

```java
private volatile boolean running =
        true;
```

If one thread changes `running`, other threads can observe the updated value more reliably.

Important:

`volatile` does not make compound operations like:

```java
count++;
```

atomic.

---

# 19. Atomic Classes

Java provides atomic classes in:

```text
java.util.concurrent.atomic
```

Example:

```java
AtomicInteger counter =
        new AtomicInteger(0);

counter.incrementAndGet();

System.out.println(
        counter.get()
);
```

Atomic classes support thread-safe operations without using traditional synchronization for many use cases.

---

# Common Atomic Classes

```text
AtomicInteger
AtomicLong
AtomicBoolean
AtomicReference
```

---

# 20. Executor Framework

Creating threads manually is not always ideal.

The Executor Framework manages task execution.

Important package:

```text
java.util.concurrent
```

Example:

```java
ExecutorService executor =
        Executors.newFixedThreadPool(2);

executor.submit(() -> {

    System.out.println(
            "Task running"
    );
});

executor.shutdown();
```

---

# Fixed Thread Pool

```java
ExecutorService executor =
        Executors.newFixedThreadPool(4);
```

It creates a pool with a fixed number of worker threads.

---

# Callable

`Callable<T>` is similar to `Runnable` but can return a result and throw checked exceptions.

Example:

```java
Callable<Integer> task =
        () -> 100;
```

---

# Future

A `Future` represents the result of an asynchronous computation.

```java
Future<Integer> future =
        executor.submit(
                () -> 100
        );
```

Getting result:

```java
Integer result =
        future.get();
```

`get()` can block until the result is available.

---

# 21. Lock

Java provides explicit locks.

Example:

```java
Lock lock =
        new ReentrantLock();

lock.lock();

try {

    // critical section

}
finally {

    lock.unlock();
}
```

Important:

Always release the lock in `finally`.

---

# ReentrantLock

`ReentrantLock` provides more control than a basic `synchronized` block.

Features include:

* Explicit lock/unlock
* Try lock
* Interruptible locking
* Fairness option

---

# 22. Concurrent Collections

Java provides thread-safe collections designed for concurrent applications.

Examples:

```text
ConcurrentHashMap
CopyOnWriteArrayList
BlockingQueue
ConcurrentLinkedQueue
```

Example:

```java
ConcurrentHashMap<Integer, String>
        students =
        new ConcurrentHashMap<>();

students.put(101, "Sabya");
students.put(102, "Rahul");
```

---

# ConcurrentHashMap

`ConcurrentHashMap` is designed for concurrent access.

Example:

```java
ConcurrentHashMap<String, Integer>
        map =
        new ConcurrentHashMap<>();

map.put("Java", 100);

map.computeIfAbsent(
        "Spring",
        key -> 200
);
```

---

# BlockingQueue

A `BlockingQueue` supports operations that can wait when the queue is full or empty.

Example:

```java
BlockingQueue<Integer> queue =
        new ArrayBlockingQueue<>(10);

queue.put(100);

Integer value =
        queue.take();
```

This is useful in producer-consumer systems.

---

# 23. Producer-Consumer Pattern

Producer generates data.

Consumer processes data.

A blocking queue can connect them.

```text
Producer
   |
   v
BlockingQueue
   |
   v
Consumer
```

Example:

```java
BlockingQueue<Integer> queue =
        new ArrayBlockingQueue<>(10);
```

Producer:

```java
queue.put(100);
```

Consumer:

```java
Integer value =
        queue.take();
```

---

# 24. Deadlock

Deadlock occurs when two or more threads wait forever for each other's locks.

Example concept:

```text
Thread 1
   ↓
Lock A
   ↓
Wait for Lock B

Thread 2
   ↓
Lock B
   ↓
Wait for Lock A
```

Neither thread can continue.

---

# Avoiding Deadlock

Common techniques:

* Acquire locks in a consistent order.
* Avoid unnecessary nested locks.
* Use timeout-based locking.
* Keep critical sections small.
* Prefer higher-level concurrency utilities.

---

# 25. Immutability

An immutable object cannot be changed after creation.

Example:

```java
final class Student {

    private final int id;

    private final String name;

    public Student(
            int id,
            String name) {

        this.id = id;
        this.name = name;
    }

    public int getId() {

        return id;
    }

    public String getName() {

        return name;
    }
}
```

The object's state cannot be changed after construction.

---

# Rules for Creating Immutable Classes

Common guidelines:

* Make the class `final`.
* Make fields `private`.
* Make fields `final`.
* Initialize fields through constructor.
* Do not provide setters.
* Return defensive copies for mutable objects.

---

# String Is Immutable

Example:

```java
String name = "Java";

name.concat(" Programming");

System.out.println(name);
```

Output:

```text
Java
```

The original String does not change.

Correct:

```java
name =
        name.concat(" Programming");
```

Now:

```text
Java Programming
```

---

# 26. String Pool

Java maintains a String pool for string literals.

Example:

```java
String a = "Java";
String b = "Java";

System.out.println(a == b);
```

Output:

```text
true
```

Both references can refer to the same pooled string.

But:

```java
String c =
        new String("Java");

System.out.println(a == c);
```

Output:

```text
false
```

`==` compares references.

`equals()` compares content.

```java
System.out.println(
        a.equals(c)
);
```

Output:

```text
true
```

---

# 27. StringBuilder

`StringBuilder` is mutable and useful for repeated string modifications.

Example:

```java
StringBuilder builder =
        new StringBuilder();

builder.append("Java");
builder.append(" ");
builder.append("Programming");

System.out.println(
        builder
);
```

---

# StringBuffer

`StringBuffer` is also mutable but provides synchronized methods.

```text
String
    → Immutable

StringBuilder
    → Mutable, generally preferred for single-threaded string construction

StringBuffer
    → Mutable, synchronized
```

---

# 28. Comparable

`Comparable<T>` defines the natural ordering of a class.

Example:

```java
class Student
        implements Comparable<Student> {

    private int marks;

    public Student(int marks) {

        this.marks = marks;
    }

    @Override
    public int compareTo(Student other) {

        return Integer.compare(
                this.marks,
                other.marks
        );
    }
}
```

Sorting:

```java
Collections.sort(students);
```

---

# 29. Comparator

`Comparator<T>` defines external/custom ordering.

Example:

```java
Comparator<Student> comparator =
        (a, b) ->
                Integer.compare(
                        a.getMarks(),
                        b.getMarks()
                );
```

Sorting:

```java
students.sort(comparator);
```

---

# Comparable vs Comparator

| Comparable           | Comparator                  |
| -------------------- | --------------------------- |
| Natural ordering     | Custom ordering             |
| `compareTo()`        | `compare()`                 |
| Defined inside class | Usually separate            |
| One main ordering    | Multiple possible orderings |

Memory trick:

```text
Comparable  → compareTo()
Comparator  → compare()
```

---

# 30. Object Cloning

Java provides object cloning through `Cloneable` and `clone()`.

Example:

```java
class Student
        implements Cloneable {

    private String name;

    public Student(String name) {

        this.name = name;
    }

    @Override
    public Student clone()
            throws CloneNotSupportedException {

        return (Student) super.clone();
    }
}
```

Usage:

```java
Student s1 =
        new Student("Sabya");

Student s2 =
        s1.clone();
```

Cloning should be used carefully.

Copy constructors or explicit copy methods are often easier to understand.

---

# Shallow Copy

A shallow copy copies field values as they are.

For object references, both objects can reference the same nested object.

Concept:

```text
Object A
   |
   +----> Object X

Object B
   |
   +----> Object X
```

---

# Deep Copy

A deep copy creates independent copies of nested mutable objects.

Concept:

```text
Object A
   |
   +----> Object X

Object B
   |
   +----> Object Y
```

where:

```text
X ≠ Y
```

---

# 31. Record

A record is a compact way to model immutable data carriers.

Example:

```java
record Student(
        int id,
        String name
) {
}
```

Usage:

```java
Student student =
        new Student(
                101,
                "Sabya"
        );

System.out.println(
        student.name()
);
```

Records automatically provide useful members such as:

* Constructor
* Accessor methods
* `equals()`
* `hashCode()`
* `toString()`

Record accessors use the component name:

```java
student.name()
```

not:

```java
student.getName()
```

---

# 32. Sealed Classes

Sealed classes restrict which classes can extend or implement them.

Example:

```java
sealed class Shape
        permits Circle, Rectangle {
}
```

Allowed subclasses:

```java
final class Circle
        extends Shape {
}
```

```java
final class Rectangle
        extends Shape {
}
```

A class not listed in `permits` cannot directly extend the sealed class.

---

# non-sealed

A permitted subclass can be declared `non-sealed`.

Example:

```java
sealed class Shape
        permits Circle {
}
```

```java
non-sealed class Circle
        extends Shape {
}
```

Now other classes can extend `Circle`.

---

# 33. Pattern Matching

Modern Java provides pattern matching features that make type checks and casts more concise.

Example:

```java
Object value = "Java";

if (value instanceof String text) {

    System.out.println(
            text.length()
    );
}
```

The variable `text` is available when the pattern matches.

---

# Pattern Matching with Conditions

```java
Object value = "Java";

if (value instanceof String text
        && text.length() > 3) {

    System.out.println(text);
}
```

---

# 34. Modules

Java Platform Module System was introduced to improve modularity.

A module groups related packages and controls what is exported.

A module can contain:

```text
module-info.java
```

Example:

```java
module com.app {

    exports com.app.model;
}
```

---

# requires

A module can depend on another module using:

```java
requires module.name;
```

Example:

```java
module com.app {

    requires java.sql;
}
```

---

# exports

Exports make a package available to other modules.

```java
module com.app {

    exports com.app.model;
}
```

---

# 35. Class Loading

The JVM loads classes dynamically when needed.

Important class loaders include:

```text
Bootstrap ClassLoader
Platform ClassLoader
Application ClassLoader
```

Class loading generally involves:

```text
Loading
   ↓
Linking
   ↓
Initialization
```

---

# Class.forName()

`Class.forName()` can load a class dynamically.

Example:

```java
Class<?> clazz =
        Class.forName(
                "com.example.Student"
        );
```

This technique has historically been common with JDBC drivers and reflection-based systems.

---

# 36. JVM Memory

Java programs use different runtime memory areas.

Important areas include:

```text
Heap
Stack
Method Area / Metaspace
PC Register
Native Method Stack
```

---

# Heap

The heap stores objects.

Example:

```java
Student student =
        new Student();
```

The `Student` object is allocated on the heap.

---

# Stack

Each thread has its own stack.

It stores things such as:

* Local variables
* Method call frames
* References
* Intermediate values

Example:

```java
void method() {

    int number = 10;
}
```

The local variable exists within the method's execution frame.

---

# Metaspace

Modern HotSpot JVMs use Metaspace for class metadata.

It replaced the older permanent generation approach.

---

# 37. Garbage Collection

Garbage Collection automatically reclaims memory occupied by objects that are no longer reachable.

Example:

```java
Student student =
        new Student();

student = null;
```

If no other reference points to the object, it may become eligible for garbage collection.

---

# System.gc()

Java allows requesting garbage collection:

```java
System.gc();
```

Important:

This is only a request.

It does not guarantee that garbage collection will happen immediately.

---

# Reachability

An object is generally eligible for garbage collection when it is no longer reachable from GC roots.

Examples of important GC roots include:

* Active thread references
* Static references
* JNI references
* Local references in active stack frames

---

# 38. equals() and hashCode()

If two objects are logically equal according to `equals()`, they should generally have the same `hashCode()`.

Example:

```java
class Student {

    private int id;

    @Override
    public boolean equals(
            Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Student other)) {
            return false;
        }

        return id == other.id;
    }

    @Override
    public int hashCode() {

        return Integer.hashCode(id);
    }
}
```

This is important when using:

```text
HashMap
HashSet
HashTable
```

---

# 39. final Keyword

`final` can be applied to:

* Variables
* Methods
* Classes

---

# Final Variable

```java
final int MAX = 100;
```

The variable cannot be reassigned.

---

# Final Method

```java
class Parent {

    final void show() {

        System.out.println("Parent");
    }
}
```

A child class cannot override the method.

---

# Final Class

```java
final class Utility {

}
```

A final class cannot be extended.

Example:

```java
public final class String {

}
```

`String` is final.

---

# 40. Static Initialization Block

A static block runs when the class is initialized.

Example:

```java
class Demo {

    static {

        System.out.println(
                "Static block"
        );
    }

    public static void main(String[] args) {

        System.out.println(
                "Main method"
        );
    }
}
```

Output:

```text
Static block
Main method
```

---

# 41. Instance Initialization Block

An instance initialization block runs when an object is created, before the constructor body.

Example:

```java
class Student {

    {
        System.out.println(
                "Initialization block"
        );
    }

    Student() {

        System.out.println(
                "Constructor"
        );
    }
}
```

Usage:

```java
new Student();
```

Output:

```text
Initialization block
Constructor
```

---

# 42. Varargs

Varargs allow a method to accept a variable number of arguments.

Syntax:

```java
void method(int... values) {

}
```

Example:

```java
static int sum(int... numbers) {

    int total = 0;

    for (int number : numbers) {

        total += number;
    }

    return total;
}
```

Usage:

```java
System.out.println(
        sum(10, 20, 30)
);
```

Output:

```text
60
```

---

# Varargs Rules

A method can have only one varargs parameter.

Varargs must be the last parameter.

Valid:

```java
void method(
        String name,
        int... numbers
) {
}
```

Invalid:

```java
void method(
        int... numbers,
        String name
) {
}
```

---

# 43. Default Methods in Interfaces

Interfaces can have default methods.

Example:

```java
interface Vehicle {

    default void start() {

        System.out.println(
                "Vehicle starting"
        );
    }
}
```

Implementation:

```java
class Car implements Vehicle {

}
```

Usage:

```java
Car car =
        new Car();

car.start();
```

---

# 44. Static Methods in Interfaces

Interfaces can contain static methods.

```java
interface Utility {

    static void show() {

        System.out.println(
                "Utility method"
        );
    }
}
```

Call using:

```java
Utility.show();
```

Static interface methods are not inherited like instance methods.

---

# 45. Private Methods in Interfaces

Modern Java interfaces can contain private methods.

Example:

```java
interface Service {

    default void execute() {

        validate();
        System.out.println(
                "Executing"
        );
    }

    private void validate() {

        System.out.println(
                "Validating"
        );
    }
}
```

Private methods help reuse implementation inside the interface.

---

# 46. Covariant Return Type

A child class can override a method and return a more specific type.

Example:

```java
class Animal {

    Animal create() {

        return new Animal();
    }
}
```

Child:

```java
class Dog extends Animal {

    @Override
    Dog create() {

        return new Dog();
    }
}
```

`Dog` is a subtype of `Animal`.

---

# 47. Pass-by-Value in Java

Java is always pass-by-value.

For primitive values, the value itself is copied.

```java
static void change(int x) {

    x = 100;
}

int number = 10;

change(number);

System.out.println(number);
```

Output:

```text
10
```

For objects, the reference value is copied.

```java
static void change(Student student) {

    student.setName("Rahul");
}
```

The copied reference can still refer to the same object.

Important:

> Java is pass-by-value, including when the value being passed is an object reference.

---

# 48. Object Class

Every Java class ultimately inherits from `Object`.

Important methods include:

```text
toString()
equals()
hashCode()
getClass()
clone()
wait()
notify()
notifyAll()
```

---

# toString()

`toString()` returns a string representation of an object.

Example:

```java
class Student {

    private int id;

    Student(int id) {

        this.id = id;
    }

    @Override
    public String toString() {

        return "Student{id=" +
                id +
                "}";
    }
}
```

Usage:

```java
System.out.println(
        new Student(101)
);
```

---

# 49. wait(), notify(), notifyAll()

These methods are used for thread coordination.

They belong to `Object`.

Example concept:

```text
Thread A
   ↓
wait()

Thread B
   ↓
notify()
```

Important:

`wait()` must generally be called while holding the object's monitor, such as inside a synchronized block or method.

---

# wait() vs sleep()

| `wait()`                       | `sleep()`                             |
| ------------------------------ | ------------------------------------- |
| Belongs to `Object`            | Belongs to `Thread`                   |
| Used for thread coordination   | Used for pausing                      |
| Releases monitor while waiting | Does not release monitor              |
| Used with synchronization      | Does not require synchronized context |

---

# 50. Thread-Safe Design

A class is thread-safe when it behaves correctly when accessed concurrently by multiple threads.

Ways to improve thread safety:

* Immutable objects
* Synchronization
* Locks
* Atomic classes
* Concurrent collections
* Thread confinement
* Proper executor usage

---

# 51. ThreadLocal

`ThreadLocal<T>` provides a separate value for each thread.

Example:

```java
ThreadLocal<Integer> value =
        ThreadLocal.withInitial(
                () -> 0
        );

value.set(100);

System.out.println(
        value.get()
);
```

Each thread has its own value.

---

# 52. CompletableFuture

`CompletableFuture` supports asynchronous and composable operations.

Example:

```java
CompletableFuture<Integer> future =
        CompletableFuture.supplyAsync(
                () -> 100
        );
```

Processing the result:

```java
future.thenApply(
        value -> value * 2
);
```

Example:

```java
CompletableFuture
        .supplyAsync(() -> 100)
        .thenApply(value -> value * 2)
        .thenAccept(
                System.out::println
        );
```

---

# 53. Parallel Streams

Streams can execute operations in parallel.

Example:

```java
numbers.parallelStream()
        .filter(n -> n % 2 == 0)
        .forEach(System.out::println);
```

Parallel streams should not automatically be assumed to be faster.

They are most useful when the workload and data size justify parallel processing.

---

# 54. Spliterator

`Spliterator` is an advanced mechanism for traversing and partitioning elements.

It is useful internally with streams and parallel processing.

Example:

```java
List<Integer> numbers =
        List.of(10, 20, 30);

Spliterator<Integer> spliterator =
        numbers.spliterator();

spliterator.forEachRemaining(
        System.out::println
);
```

---

# 55. Dynamic Proxy

Java provides dynamic proxies for creating proxy objects at runtime.

Important package:

```text
java.lang.reflect
```

Concept:

```text
Client
  ↓
Proxy
  ↓
Invocation Handler
  ↓
Real Object
```

Dynamic proxies are useful in:

* Logging
* Security
* Transactions
* AOP-like behavior
* Framework infrastructure

---

# 56. JVM Shutdown Hook

Java allows registering code to execute during JVM shutdown.

Example:

```java
Runtime.getRuntime()
        .addShutdownHook(
                new Thread(() ->
                        System.out.println(
                                "Application shutting down"
                        )
                )
        );
```

Useful for cleanup tasks.

---

# 57. System Properties

Java provides system properties.

Example:

```java
System.out.println(
        System.getProperty("java.version")
);
```

Other properties:

```text
os.name
user.name
user.dir
java.home
java.version
```

---

# 58. Environment Variables

Environment variables can be read using:

```java
String path =
        System.getenv("PATH");
```

For application configuration, environment variables are commonly used to avoid hardcoding secrets and environment-specific settings.

---

# 59. BigInteger

`BigInteger` supports arbitrary-precision integer arithmetic.

Example:

```java
BigInteger a =
        new BigInteger(
                "12345678901234567890"
        );

BigInteger b =
        new BigInteger(
                "98765432109876543210"
        );

BigInteger result =
        a.add(b);

System.out.println(result);
```

---

# 60. BigDecimal

`BigDecimal` is useful for precise decimal arithmetic.

Especially important for financial calculations.

Example:

```java
BigDecimal price =
        new BigDecimal("10.50");

BigDecimal quantity =
        new BigDecimal("2");

BigDecimal total =
        price.multiply(quantity);

System.out.println(total);
```

Avoid relying on binary floating-point arithmetic for exact monetary calculations.

---

# 61. Math and StrictMath

Java provides mathematical utilities through:

```java
Math
StrictMath
```

Example:

```java
System.out.println(
        Math.sqrt(25)
);

System.out.println(
        Math.pow(2, 3)
);
```

---

# 62. UUID

UUID represents a universally unique identifier.

Example:

```java
UUID id =
        UUID.randomUUID();

System.out.println(id);
```

Commonly used for:

* Database identifiers
* Request identifiers
* Distributed systems
* File names
* Tracking IDs

---

# 63. Regular Expressions

Java supports regular expressions through:

```text
java.util.regex
```

Important classes:

```text
Pattern
Matcher
```

Example:

```java
Pattern pattern =
        Pattern.compile(
                "\\d+"
        );

Matcher matcher =
        pattern.matcher("12345");

System.out.println(
        matcher.matches()
);
```

Output:

```text
true
```

---

# 64. Scanner

`Scanner` can read formatted input.

Example:

```java
Scanner scanner =
        new Scanner(System.in);

System.out.print(
        "Enter name: "
);

String name =
        scanner.nextLine();

System.out.println(
        "Hello " + name
);
```

For high-performance input, other approaches may be preferred in competitive programming.

---

# 65. Properties

`Properties` represents a persistent set of string key-value pairs.

Example:

```java
Properties properties =
        new Properties();

properties.setProperty(
        "username",
        "admin"
);

properties.setProperty(
        "environment",
        "development"
);
```

Reading:

```java
String username =
        properties.getProperty(
                "username"
        );
```

Properties are commonly used for configuration files.

---

# 66. Resource Management

Resources such as files, streams, sockets, and database connections should be closed properly.

Preferred pattern:

```java
try (Resource resource =
        createResource()) {

    // use resource
}
```

This is called try-with-resources.

---

# 67. AutoCloseable

A class can implement `AutoCloseable` to work with try-with-resources.

Example:

```java
class MyResource
        implements AutoCloseable {

    public void use() {

        System.out.println(
                "Using resource"
        );
    }

    @Override
    public void close() {

        System.out.println(
                "Resource closed"
        );
    }
}
```

Usage:

```java
try (MyResource resource =
        new MyResource()) {

    resource.use();
}
```

---

# 68. Clean Code with Advanced Core Java

Good Java code should:

* Prefer immutability where practical.
* Use meaningful names.
* Avoid unnecessary synchronization.
* Use generics instead of raw types.
* Prefer try-with-resources.
* Handle exceptions appropriately.
* Avoid swallowing exceptions.
* Use interfaces where abstraction is useful.
* Use streams when they improve readability.
* Avoid streams when ordinary loops are clearer.
* Use concurrent collections for concurrent workloads.
* Avoid unnecessary reflection.
* Keep classes focused.
* Prefer composition where appropriate.

---

# 69. Common Advanced Core Java Mistakes

## Mistake 1: Calling run() instead of start()

Incorrect:

```java
thread.run();
```

Correct:

```java
thread.start();
```

`run()` executes like a normal method call.

`start()` starts a new thread.

---

## Mistake 2: Using == for String comparison

Incorrect:

```java
if (a == b) {
}
```

Correct:

```java
if (a.equals(b)) {
}
```

For null-safe comparisons, use:

```java
Objects.equals(a, b);
```

---

## Mistake 3: Forgetting to unlock

Incorrect:

```java
lock.lock();

// code

lock.unlock();
```

If an exception occurs, the unlock may never execute.

Correct:

```java
lock.lock();

try {

    // code

}
finally {

    lock.unlock();
}
```

---

## Mistake 4: Assuming volatile makes everything atomic

This is incorrect:

```java
volatile int count;

count++;
```

`volatile` provides visibility semantics but does not make the read-modify-write operation atomic.

---

## Mistake 5: Using parallel streams everywhere

Parallel streams are not automatically faster.

Use them only when the workload is suitable.

---

## Mistake 6: Catching Exception without handling it

Avoid:

```java
try {

    // code

}
catch (Exception e) {

}
```

This hides problems.

At minimum, handle, log, or propagate the exception appropriately.

---

## Mistake 7: Using raw collections

Avoid:

```java
List list =
        new ArrayList();
```

Prefer:

```java
List<String> list =
        new ArrayList<>();
```

---

# 70. Advanced Core Java Interview Questions

### What is the difference between inner class and static nested class?

An inner class is non-static and has an association with an instance of the outer class.

A static nested class does not require an outer class instance.

---

### What is an anonymous class?

An anonymous class is a class without an explicit name, usually created for one-time use.

---

### What is an enum?

An enum is a special type representing a fixed set of constants.

---

### What is reflection?

Reflection allows Java code to inspect and interact with classes and members at runtime.

---

### What is the difference between checked and unchecked exceptions?

Checked exceptions are checked by the compiler.

Unchecked exceptions are subclasses of `RuntimeException` and are not required to be declared or caught.

---

### What is the difference between throw and throws?

```text
throw  → actually throws an exception
throws → declares possible exceptions
```

---

### What is try-with-resources?

It automatically closes resources implementing `AutoCloseable` or `Closeable`.

---

### What is serialization?

Serialization converts an object's state into a byte stream.

---

### What is deserialization?

Deserialization reconstructs an object from a byte stream.

---

### What does transient mean?

`transient` prevents a field from being serialized by Java's standard serialization mechanism.

---

### What is a lambda expression?

A lambda expression is a concise way to represent behavior compatible with a functional interface.

---

### What is a functional interface?

An interface with exactly one abstract method.

Example:

```java
@FunctionalInterface
interface Calculator {

    int calculate(int a, int b);
}
```

---

### What is Predicate?

`Predicate<T>` takes a value and returns a boolean.

---

### What is Function?

`Function<T,R>` accepts `T` and produces `R`.

---

### What is Consumer?

`Consumer<T>` accepts a value and returns no result.

---

### What is Supplier?

`Supplier<T>` produces a value without accepting an argument.

---

### What is Stream API?

Stream API provides a declarative way to process sequences of data.

---

### Is a stream a data structure?

No.

A stream is primarily a mechanism for processing data.

---

### What is Optional?

`Optional<T>` is a container that may contain a non-null value or be empty.

---

### What is the difference between Collection and Stream?

```text
Collection → stores/manages data
Stream     → processes data
```

---

### What is synchronization?

Synchronization controls concurrent access to shared resources.

---

### What is a race condition?

A race condition occurs when program behavior depends on unpredictable timing between concurrent operations.

---

### What is volatile?

`volatile` provides visibility guarantees for a variable across threads but does not make arbitrary compound operations atomic.

---

### What is an atomic class?

Atomic classes provide thread-safe atomic operations on values.

---

### What is ExecutorService?

`ExecutorService` manages asynchronous task execution and thread pools.

---

### What is Callable?

`Callable<T>` represents a task that can return a result and throw checked exceptions.

---

### What is Future?

`Future` represents the result of an asynchronous computation.

---

### What is deadlock?

Deadlock occurs when threads wait indefinitely for resources held by each other.

---

### What is ConcurrentHashMap?

A concurrent map designed for safe and efficient access by multiple threads.

---

### What is immutability?

An immutable object cannot have its state changed after construction.

---

### Why is String immutable?

String immutability provides benefits such as safe sharing, predictable behavior, string pooling, and security-related advantages.

---

### What is the difference between StringBuilder and StringBuffer?

```text
StringBuilder → mutable, generally unsynchronized
StringBuffer  → mutable, synchronized
```

---

### What is Comparable?

`Comparable` defines natural ordering through `compareTo()`.

---

### What is Comparator?

`Comparator` defines custom ordering through `compare()`.

---

### What is type erasure?

Type erasure removes most generic type information from runtime representation while maintaining compile-time type checking.

---

### What is a record?

A record is a concise syntax for declaring classes primarily intended to model immutable data.

---

### What is a sealed class?

A sealed class restricts which classes can directly extend it.

---

### What is a module?

A module is a named unit that groups packages and controls dependencies and exported packages.

---

### What is garbage collection?

Garbage collection automatically reclaims memory from objects that are no longer reachable.

---

### Does System.gc() guarantee garbage collection?

No.

It only requests that the JVM consider garbage collection.

---

### What is the difference between stack and heap?

```text
Stack → thread-specific execution frames/local data
Heap  → dynamically allocated objects
```

---

### Is Java pass-by-reference?

No.

Java is always pass-by-value.

For objects, the value being copied is the object reference.

---

### What is the difference between shallow copy and deep copy?

```text
Shallow copy → nested references may be shared
Deep copy    → nested mutable objects are independently copied
```

---

### What is a race condition?

A race condition happens when multiple threads access shared mutable state and the result depends on execution timing.

---

### What is deadlock?

Deadlock is a state where threads wait indefinitely for locks/resources held by one another.

---

# Advanced Core Java Quick Revision Table

| Concept              | Short Meaning                       |
| -------------------- | ----------------------------------- |
| Nested Class         | Class declared inside another class |
| Inner Class          | Non-static nested class             |
| Static Nested Class  | Static class inside another class   |
| Anonymous Class      | Nameless one-time class             |
| Enum                 | Fixed set of constants              |
| Annotation           | Metadata attached to code           |
| Reflection           | Runtime inspection/manipulation     |
| Checked Exception    | Compiler-checked exception          |
| Unchecked Exception  | Runtime exception                   |
| `throw`              | Throws an exception                 |
| `throws`             | Declares possible exceptions        |
| `finally`            | Cleanup block                       |
| Try-with-resources   | Automatic resource closing          |
| Serialization        | Object → byte stream                |
| Deserialization      | Byte stream → object                |
| `transient`          | Excludes field from serialization   |
| Lambda               | Concise functional behavior         |
| Functional Interface | One abstract method                 |
| Predicate            | `T → boolean`                       |
| Function             | `T → R`                             |
| Consumer             | `T → void`                          |
| Supplier             | `() → T`                            |
| Method Reference     | Short form of lambda                |
| Stream               | Data processing pipeline            |
| Optional             | Represents optional value           |
| `LocalDate`          | Date without time                   |
| `LocalDateTime`      | Date and time                       |
| Thread               | Unit of execution                   |
| `Runnable`           | Task without result                 |
| `Callable`           | Task with result                    |
| `ExecutorService`    | Task/thread management              |
| Synchronization      | Controls shared access              |
| `volatile`           | Visibility guarantee                |
| Atomic Class         | Atomic thread-safe operations       |
| Lock                 | Explicit synchronization mechanism  |
| ConcurrentHashMap    | Concurrent map                      |
| Deadlock             | Threads waiting indefinitely        |
| Immutable Object     | Cannot change after creation        |
| Comparable           | Natural ordering                    |
| Comparator           | Custom ordering                     |
| Record               | Compact data carrier                |
| Sealed Class         | Restricted inheritance              |
| Module               | Modular Java unit                   |
| Reflection           | Runtime class inspection            |
| Heap                 | Object memory                       |
| Stack                | Thread execution memory             |
| Garbage Collection   | Automatic memory reclamation        |
| `StringBuilder`      | Mutable string builder              |
| `StringBuffer`       | Synchronized mutable string builder |
| `BigInteger`         | Arbitrary-precision integer         |
| `BigDecimal`         | Precise decimal arithmetic          |
| UUID                 | Unique identifier                   |
| `ThreadLocal`        | Per-thread value                    |
| `CompletableFuture`  | Composable asynchronous computation |

---

# Advanced Core Java Concept Map

```text
Advanced Core Java
|
+-- Language Features
|   |
|   +-- Nested Classes
|   +-- Enum
|   +-- Annotation
|   +-- Generics
|   +-- Records
|   +-- Sealed Classes
|   +-- Pattern Matching
|
+-- Exception Handling
|   |
|   +-- Checked Exceptions
|   +-- Unchecked Exceptions
|   +-- Custom Exceptions
|   +-- Exception Chaining
|   +-- Try-With-Resources
|
+-- I/O
|   |
|   +-- java.io
|   +-- java.nio
|   +-- Files
|   +-- Path
|   +-- Serialization
|
+-- Functional Java
|   |
|   +-- Lambda
|   +-- Functional Interfaces
|   +-- Method References
|   +-- Stream API
|   +-- Optional
|
+-- Concurrency
|   |
|   +-- Thread
|   +-- Runnable
|   +-- Callable
|   +-- Synchronization
|   +-- volatile
|   +-- Atomic Classes
|   +-- Locks
|   +-- ExecutorService
|   +-- Future
|   +-- CompletableFuture
|   +-- Concurrent Collections
|
+-- JVM
    |
    +-- Class Loading
    +-- Heap
    +-- Stack
    +-- Metaspace
    +-- Garbage Collection
    +-- Type Erasure
```

---

# What You Should Master for Interviews

Focus especially on these topics:

```text
1. OOP
2. Exception Handling
3. Generics
4. Collections
5. Comparable vs Comparator
6. equals() and hashCode()
7. String and String Pool
8. Immutable Classes
9. Inner Classes
10. Enum
11. Annotations
12. Reflection
13. Lambda Expressions
14. Functional Interfaces
15. Stream API
16. Optional
17. Multithreading
18. Synchronization
19. volatile
20. Atomic Classes
21. ExecutorService
22. Callable and Future
23. CompletableFuture
24. Concurrent Collections
25. Deadlock
26. JVM Memory
27. Garbage Collection
28. Class Loading
29. Serialization
30. Records
31. Sealed Classes
32. Modules
```

---

# One-Line Memory Tricks

```text
Nested Class = Class inside another class
```

```text
Enum = Fixed set of constants
```

```text
Annotation = Metadata
```

```text
Reflection = Inspect Java code at runtime
```

```text
throw = Throw
throws = Declare
```

```text
try-with-resources = Automatic resource closing
```

```text
Lambda = Behavior as a value
```

```text
Predicate = Test
Function = Transform
Consumer = Consume
Supplier = Supply
```

```text
Stream = Process data
Optional = Represent possible absence
```

```text
start() = New thread
run()   = Normal method execution
```

```text
synchronized = Mutual exclusion + visibility guarantees
```

```text
volatile = Visibility, not general atomicity
```

```text
Atomic = Thread-safe atomic operation
```

```text
Comparable = Natural ordering
Comparator = Custom ordering
```

```text
Heap = Objects
Stack = Method execution
```

```text
GC = Reclaim unreachable objects
```

```text
Record = Compact data carrier
```

```text
Sealed = Controlled inheritance
```

```text
Java = Pass-by-value
```

> **Advanced Core Java = Deep understanding of Java language features + JVM behavior + I/O + functional programming + concurrency + runtime mechanisms.**
