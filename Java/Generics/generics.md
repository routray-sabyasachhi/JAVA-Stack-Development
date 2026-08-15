# Generics in Java

Generics in Java allow us to write classes, interfaces, and methods that can work with different data types while providing compile-time type safety.

> Generics means writing code that works with different types while checking the type at compile time.

In simple words:

> Generics allow us to specify the type of data a class, method, or collection can work with.

Real-life examples:

* `ArrayList<String>` stores only `String` objects.
* `ArrayList<Integer>` stores only `Integer` objects.
* `HashMap<Integer, String>` stores an `Integer` key and a `String` value.
* `List<Double>` stores only `Double` objects.

---

## Why Generics Are Needed

Before generics, Java collections commonly stored objects using the `Object` type.

Example:

```java
ArrayList list = new ArrayList();

list.add("Sabya");
list.add(100);
list.add(25.5);
```

The collection can contain different types.

This creates problems:

* Type safety is not guaranteed.
* Explicit type casting is required.
* Runtime `ClassCastException` can occur.
* Code becomes less readable.
* Programming errors are detected later.

Generics solve these problems.

Example:

```java
ArrayList<String> names = new ArrayList<>();

names.add("Sabya");
names.add("Rahul");
```

Now:

```java
names.add(100); // Compile-time error
```

The compiler prevents inserting the wrong type.

---

## Main Definition

Generics are a Java feature that allows classes, interfaces, and methods to operate on parameterized types.

Generics provide:

* Type safety
* Compile-time checking
* Code reusability
* Less type casting
* Cleaner code
* Better readability

---

## Important Terms

| Term              | Meaning                                                          |
| ----------------- | ---------------------------------------------------------------- |
| Generic           | Code that works with different data types                        |
| Type Parameter    | Placeholder for a type                                           |
| Type Argument     | Actual type supplied to a generic                                |
| Generic Class     | Class that uses type parameters                                  |
| Generic Method    | Method that uses type parameters                                 |
| Generic Interface | Interface that uses type parameters                              |
| Bounded Type      | Generic type restricted to certain types                         |
| Wildcard          | `?` used to represent an unknown type                            |
| Raw Type          | Generic type used without specifying type                        |
| Type Erasure      | Process used by Java compiler to remove generic type information |

---

# Generic Type Parameter

A generic type parameter is a placeholder for a data type.

Common naming conventions:

| Parameter | Common Meaning |
| --------- | -------------- |
| `T`       | Type           |
| `E`       | Element        |
| `K`       | Key            |
| `V`       | Value          |
| `N`       | Number         |
| `S`       | State          |

Example:

```java
class Box<T> {

    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
```

Here:

```text
T = Type parameter
```

---

# Generic Class

A generic class is a class that uses one or more type parameters.

Syntax:

```java
class ClassName<T> {
}
```

Example:

```java
class Box<T> {

    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
```

Using the generic class:

```java
public class Main {

    public static void main(String[] args) {

        Box<String> stringBox = new Box<>();

        stringBox.setValue("Sabya");

        System.out.println(stringBox.getValue());
    }
}
```

Output:

```text
Sabya
```

---

# Generic Class with Integer

```java
Box<Integer> integerBox = new Box<>();

integerBox.setValue(100);

System.out.println(integerBox.getValue());
```

Output:

```text
100
```

The same class works with different types.

---

# Generic Class with Multiple Type Parameters

A class can have multiple type parameters.

Syntax:

```java
class ClassName<T, U> {
}
```

Example:

```java
class Pair<K, V> {

    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
```

Using it:

```java
Pair<Integer, String> student =
        new Pair<>(101, "Sabya");

System.out.println(student.getKey());
System.out.println(student.getValue());
```

Output:

```text
101
Sabya
```

Here:

```text
K = Integer
V = String
```

---

# Generic Method

A generic method is a method that introduces its own type parameter.

Syntax:

```java
<T> returnType methodName(T value) {
}
```

Example:

```java
public class Main {

    public static <T> void printValue(T value) {

        System.out.println(value);
    }

    public static void main(String[] args) {

        printValue("Sabya");
        printValue(100);
        printValue(25.5);
    }
}
```

Output:

```text
Sabya
100
25.5
```

The method works with different types.

---

# Generic Method with Return Value

```java
public static <T> T getValue(T value) {

    return value;
}
```

Example:

```java
String name = getValue("Sabya");

Integer number = getValue(100);

System.out.println(name);
System.out.println(number);
```

Output:

```text
Sabya
100
```

---

# Generic Method with Multiple Parameters

```java
public static <T> void printTwoValues(T first, T second) {

    System.out.println(first);
    System.out.println(second);
}
```

Example:

```java
printTwoValues("Java", "Generics");

printTwoValues(10, 20);
```

---

# Generic Interface

Interfaces can also use generics.

Example:

```java
interface Container<T> {

    void add(T value);

    T get();
}
```

Implementing the interface:

```java
class StringContainer implements Container<String> {

    private String value;

    @Override
    public void add(String value) {

        this.value = value;
    }

    @Override
    public String get() {

        return value;
    }
}
```

Usage:

```java
StringContainer container = new StringContainer();

container.add("Sabya");

System.out.println(container.get());
```

Output:

```text
Sabya
```

---

# Generic Interface with Generic Implementation

Instead of fixing the type, the implementing class can also remain generic.

```java
interface Container<T> {

    void add(T value);

    T get();
}
```

Implementation:

```java
class MyContainer<T> implements Container<T> {

    private T value;

    @Override
    public void add(T value) {

        this.value = value;
    }

    @Override
    public T get() {

        return value;
    }
}
```

Usage:

```java
MyContainer<String> container = new MyContainer<>();

container.add("Java");

System.out.println(container.get());
```

---

# Generics with Collections

Generics are heavily used in the Java Collection Framework.

Example:

```java
ArrayList<String> names = new ArrayList<>();

names.add("Sabya");
names.add("Rahul");
names.add("Amit");
```

The list accepts only `String`.

This is not allowed:

```java
names.add(100); // Compile-time error
```

---

# Generic ArrayList

```java
ArrayList<Integer> numbers = new ArrayList<>();

numbers.add(10);
numbers.add(20);
numbers.add(30);

System.out.println(numbers);
```

Output:

```text
[10, 20, 30]
```

---

# Generic HashMap

`HashMap` uses two type parameters:

```text
K = Key
V = Value
```

Example:

```java
HashMap<Integer, String> students = new HashMap<>();

students.put(101, "Sabya");
students.put(102, "Rahul");
students.put(103, "Amit");
```

Here:

```text
Key   = Integer
Value = String
```

This is invalid:

```java
students.put("101", "Sabya"); // Compile-time error
```

---

# Generic Set

```java
HashSet<String> names = new HashSet<>();

names.add("Sabya");
names.add("Rahul");
names.add("Amit");
```

Only `String` values can be added.

---

# Generic Queue

```java
Queue<Integer> queue = new LinkedList<>();

queue.add(10);
queue.add(20);
queue.add(30);
```

Here the queue stores only `Integer` values.

---

# Generic Type Safety

One of the biggest advantages of generics is type safety.

Without generics:

```java
ArrayList list = new ArrayList();

list.add("Sabya");
list.add(100);

String name = (String) list.get(1);
```

This causes:

```text
ClassCastException
```

With generics:

```java
ArrayList<String> list = new ArrayList<>();

list.add("Sabya");

String name = list.get(0);
```

No explicit casting is required.

---

# Generics Remove Explicit Casting

Without generics:

```java
ArrayList list = new ArrayList();

list.add("Sabya");

String name = (String) list.get(0);
```

With generics:

```java
ArrayList<String> list = new ArrayList<>();

list.add("Sabya");

String name = list.get(0);
```

Generics make the code cleaner.

---

# Generic Type Parameter vs Type Argument

These two terms are important.

Example:

```java
class Box<T> {
}
```

Here:

```text
T = Type parameter
```

When we write:

```java
Box<String> box = new Box<>();
```

Here:

```text
String = Type argument
```

Remember:

```text
T       → Type parameter
String  → Type argument
```

---

# Multiple Generic Parameters

A generic class can have multiple type parameters.

Example:

```java
class Student<K, V> {

    private K id;
    private V name;

    public Student(K id, V name) {

        this.id = id;
        this.name = name;
    }

    public K getId() {

        return id;
    }

    public V getName() {

        return name;
    }
}
```

Usage:

```java
Student<Integer, String> student =
        new Student<>(101, "Sabya");

System.out.println(student.getId());
System.out.println(student.getName());
```

Output:

```text
101
Sabya
```

---

# Bounded Generics

Sometimes we do not want to allow every type.

We can restrict a generic type using bounds.

Syntax:

```java
<T extends Type>
```

Example:

```java
class Calculator<T extends Number> {

    private T value;

    public Calculator(T value) {

        this.value = value;
    }

    public T getValue() {

        return value;
    }
}
```

Usage:

```java
Calculator<Integer> c1 =
        new Calculator<>(100);

Calculator<Double> c2 =
        new Calculator<>(25.5);
```

Both are valid because:

```text
Integer extends Number
Double extends Number
```

But:

```java
Calculator<String> c3 =
        new Calculator<>("Java");
```

is invalid because `String` is not a subclass of `Number`.

---

# Upper Bounded Type Parameter

Upper bound uses:

```java
<T extends Type>
```

Example:

```java
public static <T extends Number>
double square(T number) {

    return number.doubleValue()
            * number.doubleValue();
}
```

Usage:

```java
System.out.println(square(10));
System.out.println(square(5.5));
```

Output:

```text
100.0
30.25
```

---

# Multiple Bounds

A type parameter can have multiple bounds.

Syntax:

```java
<T extends ClassName & InterfaceName>
```

Example:

```java
class Example<T extends Number & Comparable<T>> {

}
```

Important rule:

If a class is present, it must come first.

Correct:

```java
<T extends Number & Comparable<T>>
```

Invalid:

```java
<T extends Comparable<T> & Number>
```

---

# Wildcards

A wildcard is represented by:

```java
?
```

It represents an unknown type.

Example:

```java
List<?> list;
```

This means:

> A list of some unknown type.

Example:

```java
public static void printList(List<?> list) {

    for (Object value : list) {

        System.out.println(value);
    }
}
```

This method can accept:

```java
List<String>
List<Integer>
List<Double>
```

---

# Unbounded Wildcard

Syntax:

```java
?
```

Example:

```java
List<?> list;
```

It can represent a list of any type.

Example:

```java
List<String> names = new ArrayList<>();

names.add("Sabya");

List<Integer> numbers = new ArrayList<>();

numbers.add(100);
```

Both can be passed to:

```java
printList(names);
printList(numbers);
```

---

# Upper Bounded Wildcard

Syntax:

```java
? extends Type
```

Example:

```java
List<? extends Number> numbers;
```

This means:

> A list of some type that is `Number` or a subclass of `Number`.

Valid:

```java
List<Integer> integers;
List<Double> doubles;
List<Float> floats;
```

Example:

```java
public static double sum(List<? extends Number> numbers) {

    double total = 0;

    for (Number number : numbers) {

        total += number.doubleValue();
    }

    return total;
}
```

---

# Lower Bounded Wildcard

Syntax:

```java
? super Type
```

Example:

```java
List<? super Integer> numbers;
```

This means:

> A list of `Integer` or a superclass of `Integer`.

Possible types include:

```text
List<Integer>
List<Number>
List<Object>
```

Example:

```java
public static void addNumbers(
        List<? super Integer> numbers) {

    numbers.add(10);
    numbers.add(20);
}
```

---

# PECS Rule

PECS means:

> Producer Extends, Consumer Super

This is an important rule for wildcard usage.

### Producer

If a collection produces values for you:

```java
? extends Type
```

Example:

```java
List<? extends Number>
```

You mainly read values from it.

### Consumer

If a collection consumes values from you:

```java
? super Type
```

Example:

```java
List<? super Integer>
```

You can add `Integer` values to it.

Memory trick:

```text
Producer → extends
Consumer → super
```

---

# Generic Method vs Wildcard

These are different concepts.

Generic method:

```java
public static <T> void print(T value) {

    System.out.println(value);
}
```

Wildcard:

```java
public static void print(List<?> list) {

    System.out.println(list);
}
```

Generic method introduces a type parameter.

Wildcard represents an unknown type.

---

# Generic Constructor

Constructors can also be generic.

Example:

```java
class Box {

    public <T> Box(T value) {

        System.out.println(value);
    }
}
```

Usage:

```java
Box box1 = new Box("Java");

Box box2 = new Box(100);
```

The constructor accepts different types.

---

# Generic Class with Generic Method

A class and method can both use generics.

Example:

```java
class Printer<T> {

    public void print(T value) {

        System.out.println(value);
    }

    public <U> void printAnother(U value) {

        System.out.println(value);
    }
}
```

Usage:

```java
Printer<String> printer = new Printer<>();

printer.print("Java");

printer.printAnother(100);
```

Here:

```text
T = String
U = Integer
```

---

# Static Members and Generics

A static member cannot directly use the class's type parameter.

Invalid:

```java
class Box<T> {

    static T value; // Error
}
```

Why?

Because `T` belongs to the object/class type parameter, while static members belong to the class itself.

Correct approach:

```java
class Box<T> {

    public static <U> void print(U value) {

        System.out.println(value);
    }
}
```

---

# Generic Inheritance

A generic class can extend another generic class.

Example:

```java
class Parent<T> {

    protected T value;
}
```

Child class:

```java
class Child<T> extends Parent<T> {

    public void show() {

        System.out.println(value);
    }
}
```

Usage:

```java
Child<String> child = new Child<>();

child.value = "Sabya";

child.show();
```

---

# Fixing the Type During Inheritance

A child class can specify a concrete type.

```java
class Parent<T> {

    protected T value;
}
```

Child:

```java
class StringChild extends Parent<String> {

    public void show() {

        System.out.println(value);
    }
}
```

Now:

```text
T = String
```

inside `StringChild`.

---

# Raw Types

A raw type is a generic class used without specifying its type parameter.

Example:

```java
ArrayList list = new ArrayList();
```

This is a raw type.

It is allowed for backward compatibility but should generally be avoided.

Better:

```java
ArrayList<String> list = new ArrayList<>();
```

---

# Problems with Raw Types

Example:

```java
ArrayList list = new ArrayList();

list.add("Sabya");
list.add(100);

String name = (String) list.get(1);
```

This can cause:

```text
ClassCastException
```

Generic version:

```java
ArrayList<String> list = new ArrayList<>();

list.add("Sabya");
```

Now wrong types are rejected at compile time.

---

# Diamond Operator

Java provides the diamond operator:

```java
<>
```

It allows the compiler to infer the generic type.

Without diamond operator:

```java
ArrayList<String> names =
        new ArrayList<String>();
```

With diamond operator:

```java
ArrayList<String> names =
        new ArrayList<>();
```

The second version is shorter and preferred.

---

# Type Inference

Java can automatically determine the generic type from context.

Example:

```java
Box<String> box = new Box<>();
```

Java understands:

```text
T = String
```

Example:

```java
List<Integer> numbers = new ArrayList<>();
```

Java infers:

```text
T = Integer
```

---

# Generic Arrays

Creating arrays of a type parameter directly is not allowed.

Invalid:

```java
class Box<T> {

    T[] values = new T[10]; // Error
}
```

This is because Java generics use type erasure.

A common approach is to use an `Object` array and cast carefully, or use collections.

Example:

```java
class Box<T> {

    private Object[] values;

    public Box(int size) {

        values = new Object[size];
    }
}
```

For most applications, prefer:

```java
List<T>
```

instead of generic arrays.

---

# Cannot Use Primitive Types Directly

Generics work with reference types, not primitive types.

Invalid:

```java
List<int> numbers;
```

Correct:

```java
List<Integer> numbers;
```

Similarly:

```text
int     → Integer
double  → Double
char    → Character
boolean → Boolean
long    → Long
float   → Float
short   → Short
byte    → Byte
```

Example:

```java
List<Integer> numbers = new ArrayList<>();

numbers.add(10);
```

Java automatically performs boxing:

```text
int → Integer
```

---

# Generics and Autoboxing

Example:

```java
List<Integer> numbers = new ArrayList<>();

numbers.add(10);
```

The integer literal:

```java
10
```

is an `int`.

Java automatically converts it to:

```java
Integer
```

This is called autoboxing.

When retrieving:

```java
int number = numbers.get(0);
```

Java automatically converts:

```text
Integer → int
```

This is called unboxing.

---

# Type Erasure

Java implements generics using type erasure.

The compiler uses generic type information for compile-time checking and then removes most generic type information from the generated bytecode.

Example:

```java
List<String> names =
        new ArrayList<>();
```

and:

```java
List<Integer> numbers =
        new ArrayList<>();
```

At runtime, generic type information is largely erased.

Conceptually:

```text
List<String>
List<Integer>
       ↓
     List
```

Type erasure helps maintain compatibility with older Java code.

---

# Important Consequences of Type Erasure

Because of type erasure:

You cannot normally do:

```java
if (value instanceof T) {
}
```

You cannot create:

```java
new T();
```

You cannot create:

```java
new T[10];
```

You cannot use a type parameter as a static field type.

---

# Generic Exception Restriction

Java does not allow a generic class to extend `Throwable`.

Invalid:

```java
class MyException<T> extends Exception {
}
```

Generic classes cannot directly be used as throwable exception types.

---

# Generics and Inheritance

An important point:

```java
List<String>
```

is **not** a subtype of:

```java
List<Object>
```

Even though:

```text
String extends Object
```

Example:

```java
List<String> strings =
        new ArrayList<>();

List<Object> objects = strings; // Error
```

This prevents type-safety problems.

---

# Why List Is Not List

# Suppose Java allowed:

```java
List<String> strings =
        new ArrayList<>();

List<Object> objects = strings;
```

Then we could write:

```java
objects.add(100);
```

Now the original `List<String>` contains an `Integer`.

That would break type safety.

Therefore:

```text
List<String> ≠ List<Object>
```

---

# Generic Class Example: Box

```java
class Box<T> {

    private T value;

    public Box(T value) {

        this.value = value;
    }

    public T getValue() {

        return value;
    }
}
```

Main:

```java
public class Main {

    public static void main(String[] args) {

        Box<String> stringBox =
                new Box<>("Java");

        Box<Integer> integerBox =
                new Box<>(100);

        System.out.println(stringBox.getValue());
        System.out.println(integerBox.getValue());
    }
}
```

Output:

```text
Java
100
```

---

# Real-Life Example: Student Repository

Generics are heavily used in real applications.

Example:

```java
class Student {

    private int id;
    private String name;

    public Student(int id, String name) {

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

Generic repository:

```java
class Repository<T> {

    private T data;

    public void save(T data) {

        this.data = data;
    }

    public T find() {

        return data;
    }
}
```

Usage:

```java
Repository<Student> repository =
        new Repository<>();

Student student =
        new Student(101, "Sabya");

repository.save(student);

Student result = repository.find();

System.out.println(
        result.getName()
);
```

Output:

```text
Sabya
```

The same repository can work with another type:

```java
Repository<String> stringRepository =
        new Repository<>();

stringRepository.save("Java");

System.out.println(
        stringRepository.find()
);
```

---

# Real-Life Example: Generic Service

```java
class Service<T> {

    public void process(T data) {

        System.out.println(
                "Processing: " + data
        );
    }
}
```

Usage:

```java
Service<String> stringService =
        new Service<>();

stringService.process("Student Data");
```

Another type:

```java
Service<Integer> integerService =
        new Service<>();

integerService.process(100);
```

This is useful for reusable application components.

---

# Generics in Java Collections

Common generic collections:

```java
List<String>
Set<Integer>
Map<Integer, String>
Queue<Double>
Deque<String>
```

Examples:

```java
List<String> names =
        new ArrayList<>();

Set<Integer> numbers =
        new HashSet<>();

Map<Integer, String> students =
        new HashMap<>();

Queue<String> queue =
        new LinkedList<>();
```

---

# Advantages of Generics

Generics provide several advantages.

### 1. Type Safety

Wrong types are detected during compilation.

```java
List<String> names =
        new ArrayList<>();

names.add(100); // Error
```

### 2. No Explicit Casting

Without generics:

```java
String name =
        (String) list.get(0);
```

With generics:

```java
String name =
        names.get(0);
```

### 3. Code Reusability

One generic class can work with multiple types.

```java
Box<String>
Box<Integer>
Box<Double>
```

### 4. Better Readability

This:

```java
List<String>
```

clearly tells us what the list contains.

### 5. Compile-Time Error Detection

Many type errors are found before the program runs.

---

# Limitations of Generics

Important limitations:

* Cannot use primitive types directly.
* Cannot create `new T()`.
* Cannot create generic arrays directly.
* Cannot use type parameters in static fields.
* Generic type information is mostly erased at runtime.
* Cannot create generic exceptions extending `Throwable`.

---

# Common Generic Syntax

### Generic Class

```java
class Box<T> {
}
```

### Generic Method

```java
<T> void print(T value) {
}
```

### Generic Interface

```java
interface Container<T> {
}
```

### Upper Bound

```java
<T extends Number>
```

### Unbounded Wildcard

```java
List<?>
```

### Upper Bounded Wildcard

```java
List<? extends Number>
```

### Lower Bounded Wildcard

```java
List<? super Integer>
```

---

# Common Mistakes

### Mistake 1: Using primitive types

Incorrect:

```java
List<int> numbers;
```

Correct:

```java
List<Integer> numbers;
```

---

### Mistake 2: Using raw types

Avoid:

```java
List list = new ArrayList();
```

Prefer:

```java
List<String> list =
        new ArrayList<>();
```

---

### Mistake 3: Assuming List is List

Incorrect:

```java
List<Object> objects =
        new ArrayList<String>();
```

This is not allowed.

---

### Mistake 4: Creating generic arrays

Incorrect:

```java
T[] array = new T[10];
```

Generic arrays cannot be created directly.

---

### Mistake 5: Confusing T and ?

`T` is a type parameter.

```java
<T>
```

`?` is a wildcard.

```java
List<?>
```

They are related but not the same.

---

# Generic Type Parameter vs Wildcard

| Feature              | Type Parameter          | Wildcard                   |
| -------------------- | ----------------------- | -------------------------- |
| Symbol               | `T`                     | `?`                        |
| Meaning              | Named type parameter    | Unknown type               |
| Can introduce a type | Yes                     | No                         |
| Common use           | Generic classes/methods | Flexible method parameters |
| Example              | `<T>`                   | `<?>`                      |

---

# Generics vs Object

Without generics:

```java
class Box {

    private Object value;

    public void set(Object value) {

        this.value = value;
    }

    public Object get() {

        return value;
    }
}
```

Usage:

```java
Box box = new Box();

box.set("Sabya");

String name =
        (String) box.get();
```

With generics:

```java
class Box<T> {

    private T value;

    public void set(T value) {

        this.value = value;
    }

    public T get() {

        return value;
    }
}
```

Usage:

```java
Box<String> box =
        new Box<>();

box.set("Sabya");

String name =
        box.get();
```

Generics provide compile-time type safety and eliminate unnecessary casting.

---

# Interview Questions

### What are generics in Java?

Generics allow classes, interfaces, and methods to work with parameterized types while providing compile-time type safety.

---

### Why are generics used?

Generics are used for:

* Type safety
* Code reusability
* Removing explicit casting
* Compile-time error detection
* Better readability

---

### What is a generic class?

A generic class is a class that uses one or more type parameters.

Example:

```java
class Box<T> {
}
```

---

### What is a generic method?

A generic method is a method that declares its own type parameter.

Example:

```java
public static <T> void print(T value) {

    System.out.println(value);
}
```

---

### What is a type parameter?

A type parameter is a placeholder for a type.

Example:

```java
class Box<T>
```

Here `T` is the type parameter.

---

### What is a type argument?

The actual type supplied to a generic is called a type argument.

Example:

```java
Box<String>
```

Here `String` is the type argument.

---

### What is a wildcard?

`?` represents an unknown type.

Example:

```java
List<?>
```

---

### What is an upper bounded wildcard?

An upper bounded wildcard uses:

```java
? extends Type
```

Example:

```java
List<? extends Number>
```

---

### What is a lower bounded wildcard?

A lower bounded wildcard uses:

```java
? super Type
```

Example:

```java
List<? super Integer>
```

---

### What is PECS?

PECS means:

```text
Producer Extends
Consumer Super
```

Use `extends` when reading/producing values and `super` when consuming/adding values.

---

### Can generics use primitive types?

No.

Incorrect:

```java
List<int>
```

Correct:

```java
List<Integer>
```

---

### What is type erasure?

Type erasure is the process by which generic type information is removed from most runtime bytecode while preserving compile-time type checking.

---

### Why can't we create `new T()`?

Because the actual generic type is not available in the required form at runtime due to type erasure.

---

### Can a static field use a class type parameter?

No.

Invalid:

```java
class Box<T> {

    static T value;
}
```

---

### Can generic classes have multiple type parameters?

Yes.

Example:

```java
class Pair<K, V> {
}
```

---

### Is `List<String>` a subtype of `List<Object>`?

No.

Generics in Java are invariant.

```text
List<String> ≠ List<Object>
```

---

### What is a raw type?

A raw type is a generic class or interface used without specifying its type parameter.

Example:

```java
List list;
```

Raw types should generally be avoided in new code.

---

### What is the diamond operator?

The diamond operator:

```java
<>
```

allows Java to infer generic type arguments.

Example:

```java
List<String> names =
        new ArrayList<>();
```

---

# Quick Revision Table

| Concept            | Short Meaning                                      |
| ------------------ | -------------------------------------------------- |
| Generics           | Type-safe reusable code                            |
| `T`                | Type parameter                                     |
| `E`                | Element                                            |
| `K`                | Key                                                |
| `V`                | Value                                              |
| Type Parameter     | Placeholder type                                   |
| Type Argument      | Actual supplied type                               |
| Generic Class      | Class with type parameter                          |
| Generic Method     | Method with type parameter                         |
| Generic Interface  | Interface with type parameter                      |
| `?`                | Unknown type                                       |
| `? extends T`      | Upper bounded wildcard                             |
| `? super T`        | Lower bounded wildcard                             |
| PECS               | Producer Extends, Consumer Super                   |
| Raw Type           | Generic type without type argument                 |
| Diamond `<>`       | Type inference                                     |
| Type Erasure       | Generic type information mostly removed at runtime |
| `List<String>`     | List containing Strings                            |
| `Map<K,V>`         | Key-value generic structure                        |
| `T extends Number` | Type restricted to Number/subtypes                 |
| Primitive Types    | Cannot be used directly with generics              |

---

# One-Line Memory Tricks

```text
Generics = Type safety + Code reusability
```

```text
T = Type
E = Element
K = Key
V = Value
```

```text
extends = Producer
super = Consumer
```

```text
? = Unknown type
```

```text
List<String> ≠ List<Object>
```

```text
Generics work with reference types, not primitive types.
```

```text
Type erasure = Generic type information is mostly removed at runtime.
```

> **Generics = Write once, use with many types, while keeping type safety.**
