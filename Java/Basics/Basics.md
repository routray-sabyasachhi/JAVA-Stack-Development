# Java Basics

This file is a step-by-step beginner guide for Java. It starts from installing the JDK and ends with writing, compiling, running, and understanding basic Java programs.

## 1. What Is Java?

Java is a high-level, object-oriented programming language.

High-level means Java is easier for humans to read than machine code.

Object-oriented means Java organizes code around classes and objects.

Java is platform independent because Java code is first compiled into bytecode, and bytecode runs on the JVM.

## 2. JDK, JRE, JVM, And Compiler

Before writing Java code, understand these names:

| Term | Full form | Meaning |
| --- | --- | --- |
| JDK | Java Development Kit | Tools needed to develop Java programs |
| JRE | Java Runtime Environment | Environment needed to run Java programs |
| JVM | Java Virtual Machine | Runs Java bytecode |
| javac | Java Compiler | Converts `.java` source code into `.class` bytecode |
| java | Java Launcher | Runs the compiled `.class` program |

Simple flow:

```text
Program.java
    |
    | javac Program.java
    v
Program.class
    |
    | java Program
    v
Output on screen
```

Important point:

You write source code in a `.java` file.

The compiler creates a `.class` file.

The JVM runs the `.class` file.

## 3. Download And Install JDK

1. Open a browser.
2. Search for "Oracle JDK download" or "OpenJDK download".
3. Download the JDK for your operating system.
4. Install it.
5. Check installation using terminal or command prompt:

```bash
java -version
javac -version
```

If both commands show a version number, Java is installed correctly.

Example:

```text
java version "21..."
javac 21...
```

## 4. PATH Environment Variable

PATH tells the operating system where to find commands like `java` and `javac`.

If `java -version` or `javac -version` is not recognized, the JDK `bin` folder may not be added to PATH.

Example JDK bin path on Windows:

```text
C:\Program Files\Java\jdk-21\bin
```

Why `bin`?

`bin` means binary/executable files. It contains commands like `java.exe` and `javac.exe`.

## 5. Create First Java File

Create a file named:

```text
Test.java
```

File name should match the public class name.

Example:

```java
public class Test {
    public static void main(String[] args) {
        System.out.println("Hello Java");
    }
}
```

## 6. Compile And Run First Program

Open terminal in the folder where `Test.java` is saved.

Compile:

```bash
javac Test.java
```

This creates:

```text
Test.class
```

Run:

```bash
java Test
```

Do not write `.class` while running.

Correct:

```bash
java Test
```

Wrong:

```bash
java Test.class
```

## 7. First Program: Every Word Meaning

Program:

```java
public class Test {
    public static void main(String[] args) {
        System.out.println("Hello Java");
    }
}
```

Line by line:

```java
public class Test {
```

`public` means this class can be accessed from outside.

`class` is a keyword used to create a class.

`Test` is the class name. Because the class is public, the file name should be `Test.java`.

`{` starts the class body.

```java
public static void main(String[] args) {
```

`public` means the JVM can access this method from outside the class.

`static` means the JVM can call this method without creating an object of the class.

`void` means this method does not return any value.

`main` is the method name. Java program execution starts from `main`.

`String[] args` stores command-line arguments.

`String` means text type.

`[]` means array.

`args` is the variable name. You can rename it, but `args` is the common convention.

`(` and `)` contain method parameters.

`{` starts the main method body.

```java
System.out.println("Hello Java");
```

`System` is a built-in Java class.

`out` is an object inside `System` used for output.

`println` means print line. It prints text and then moves to the next line.

`"Hello Java"` is a string literal.

`;` ends the statement.

```java
}
```

This closes the main method.

```java
}
```

This closes the class.

## 8. Basic Program Structure Diagram

```text
class
|
+-- main method
    |
    +-- statements
```

Example:

```text
public class Test
|
+-- public static void main(String[] args)
    |
    +-- System.out.println("Hello Java");
```

## 9. Comments In Java

Comments are notes for humans. The compiler ignores them.

Single-line comment:

```java
// This is a single-line comment
```

Multi-line comment:

```java
/*
This is
a multi-line
comment
*/
```

Documentation comment:

```java
/**
 * This is used for documentation.
 */
```

Why comments are written:

They explain code.

They make programs easier to revise later.

They help other developers understand the logic.

## 10. Printing Output

Use `System.out.print()` when you do not want a new line.

Use `System.out.println()` when you want a new line after printing.

Use `System.out.printf()` when you want formatted output.

Example:

```java
public class PrintExample {
    public static void main(String[] args) {
        System.out.print("Hello ");
        System.out.println("Java");
        System.out.printf("Age = %d", 20);
    }
}
```

Output:

```text
Hello Java
Age = 20
```

## 11. Escape Sequences

Escape sequences are special character combinations.

| Escape | Meaning |
| --- | --- |
| `\n` | New line |
| `\t` | Tab space |
| `\"` | Double quote |
| `\\` | Backslash |

Example:

```java
System.out.println("Hello\nJava");
System.out.println("Name\tAge");
System.out.println("He said \"Hi\"");
```

## 12. Variables

A variable is a named memory location that stores a value.

Example:

```java
int age = 20;
```

Meaning:

`int` is the data type.

`age` is the variable name.

`=` assigns the value.

`20` is the value.

`;` ends the statement.

Memory idea:

```text
+------+
| age  |
| 20   |
+------+
```

## 13. Declaration, Initialization, And Assignment

Declaration means creating a variable.

```java
int x;
```

Initialization means giving the first value.

```java
x = 10;
```

Declaration and initialization together:

```java
int y = 20;
```

Assignment means giving or updating a value.

```java
y = 30;
```

Full example:

```java
public class VariableExample {
    public static void main(String[] args) {
        int x;
        x = 10;

        int y = 20;
        y = 30;

        System.out.println(x);
        System.out.println(y);
    }
}
```

## 14. Data Types

Java data types are mainly divided into two groups:

```text
Data Types
|
+-- Primitive
|   +-- byte
|   +-- short
|   +-- int
|   +-- long
|   +-- float
|   +-- double
|   +-- char
|   +-- boolean
|
+-- Non-Primitive
    +-- String
    +-- Array
    +-- Class
    +-- Object
    +-- Interface
```

Primitive data types:

| Type | Stores | Example |
| --- | --- | --- |
| `byte` | Small integer | `byte b = 10;` |
| `short` | Small integer | `short s = 100;` |
| `int` | Integer | `int age = 20;` |
| `long` | Large integer | `long population = 9000000000L;` |
| `float` | Decimal number | `float price = 10.5f;` |
| `double` | Decimal number | `double marks = 95.75;` |
| `char` | Single character | `char grade = 'A';` |
| `boolean` | true or false | `boolean pass = true;` |

Important:

Use single quotes for `char`.

Use double quotes for `String`.

Example:

```java
char grade = 'A';
String name = "Sabyasachi";
```

## 15. Constants

A constant value should not change.

Use `final` to make a variable constant.

Example:

```java
final double PI = 3.14159;
```

By convention, constant names are written in uppercase letters.

## 16. Naming Conventions In Java

Naming convention means standard style for naming.

| Item | Convention | Example |
| --- | --- | --- |
| Class | PascalCase | `StudentDetails` |
| Method | camelCase | `calculateArea()` |
| Variable | camelCase | `studentAge` |
| Constant | UPPER_SNAKE_CASE | `MAX_MARKS` |
| Package | lowercase | `com.example.basics` |

Rules for identifiers:

Names can contain letters, digits, `_`, and `$`.

Names cannot start with a digit.

Names cannot be Java keywords.

Names are case-sensitive.

Good names:

```java
int studentAge;
double totalMarks;
String firstName;
```

Bad names:

```java
int 1age;       // starts with digit
int class;      // keyword
int total marks; // space not allowed
```

## 17. Keywords

Keywords are reserved words in Java.

You cannot use keywords as variable names.

Examples:

```text
class, public, static, void, int, if, else, for, while, switch, return, new
```

## 18. Type Casting

Type casting means converting one data type to another.

Widening casting happens automatically when converting a smaller type to a larger type.

```java
int x = 10;
double y = x;
```

Narrowing casting must be done manually because data may be lost.

```java
double price = 99.99;
int value = (int) price;
```

Output value becomes `99`.

## 19. Operators

Operators are symbols that perform operations on values and variables.

Example:

```java
int sum = 10 + 20;
```

Here `+` is an operator.

## 20. Arithmetic Operators

Arithmetic operators perform mathematical operations.

| Operator | Meaning | Example | Result |
| --- | --- | --- | --- |
| `+` | Addition | `10 + 5` | `15` |
| `-` | Subtraction | `10 - 5` | `5` |
| `*` | Multiplication | `10 * 5` | `50` |
| `/` | Division | `10 / 5` | `2` |
| `%` | Modulus/remainder | `10 % 3` | `1` |

Example:

```java
public class ArithmeticExample {
    public static void main(String[] args) {
        int a = 10;
        int b = 3;

        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);
        System.out.println(a % b);
    }
}
```

Important:

With integers, division removes the decimal part.

```java
System.out.println(10 / 3);   // 3
System.out.println(10.0 / 3); // 3.3333333333333335
```

## 21. Assignment Operators

Assignment operators assign values.

| Operator | Meaning | Same as |
| --- | --- | --- |
| `=` | Assign | `x = 10` |
| `+=` | Add and assign | `x = x + 5` |
| `-=` | Subtract and assign | `x = x - 5` |
| `*=` | Multiply and assign | `x = x * 5` |
| `/=` | Divide and assign | `x = x / 5` |
| `%=` | Remainder and assign | `x = x % 5` |

Example:

```java
int x = 10;
x += 5; // x becomes 15
x -= 3; // x becomes 12
```

## 22. Comparison Operators

Comparison operators compare values and return `true` or `false`.

| Operator | Meaning |
| --- | --- |
| `>` | Greater than |
| `<` | Less than |
| `>=` | Greater than or equal to |
| `<=` | Less than or equal to |
| `==` | Equal to |
| `!=` | Not equal to |

Example:

```java
int x = 10;
int y = 5;

System.out.println(x > y);  // true
System.out.println(x == y); // false
```

Important:

`=` assigns a value.

`==` compares two values.

## 23. Logical Operators

Logical operators combine boolean conditions.

| Operator | Meaning | Example |
| --- | --- | --- |
| `&&` | AND | Both conditions must be true |
| `||` | OR | At least one condition must be true |
| `!` | NOT | Reverses true/false |

Truth table for AND:

| A | B | A && B |
| --- | --- | --- |
| true | true | true |
| true | false | false |
| false | true | false |
| false | false | false |

Truth table for OR:

| A | B | A || B |
| --- | --- | --- |
| true | true | true |
| true | false | true |
| false | true | true |
| false | false | false |

Example:

```java
int age = 20;
boolean hasId = true;

System.out.println(age >= 18 && hasId); // true
```

## 24. Increment And Decrement Operators

Increment increases value by 1.

Decrement decreases value by 1.

| Operator | Meaning |
| --- | --- |
| `++` | Increase by 1 |
| `--` | Decrease by 1 |

Pre-increment:

```java
int x = 5;
System.out.println(++x); // 6
```

First increase, then use.

Post-increment:

```java
int x = 5;
System.out.println(x++); // 5
System.out.println(x);   // 6
```

First use, then increase.

## 25. Bitwise Operators

Bitwise operators work on bits.

| Operator | Meaning |
| --- | --- |
| `&` | Bitwise AND |
| `|` | Bitwise OR |
| `^` | Bitwise XOR |
| `~` | Bitwise NOT |
| `<<` | Left shift |
| `>>` | Right shift |

Example:

```java
int a = 5; // binary 0101
int b = 3; // binary 0011

System.out.println(a & b); // 1
System.out.println(a | b); // 7
```

## 26. Ternary Operator

The ternary operator is a short form of simple `if else`.

Syntax:

```java
condition ? valueIfTrue : valueIfFalse
```

Example:

```java
int age = 20;
String result = age >= 18 ? "Adult" : "Minor";
System.out.println(result);
```

## 27. Operator Precedence

Operator precedence decides which operation happens first.

Example:

```java
int result = 10 + 5 * 2;
```

Output is `20`, not `30`, because multiplication happens before addition.

Use parentheses when you want clarity:

```java
int result = (10 + 5) * 2;
```

## 28. Taking Input From User

Use `Scanner` to take input from the user.

Step 1: Import Scanner.

```java
import java.util.Scanner;
```

Step 2: Create Scanner object.

```java
Scanner sc = new Scanner(System.in);
```

Step 3: Read input.

```java
int age = sc.nextInt();
```

Full example:

```java
import java.util.Scanner;

public class TakeInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        System.out.println("Your age is: " + age);
        sc.close();
    }
}
```

Every important word:

`import` brings a class from Java library.

`java.util.Scanner` is the full location of the Scanner class.

`Scanner` is a class used for reading input.

`sc` is a variable name that stores the Scanner object.

`new` creates a new object.

`System.in` means keyboard input.

`nextInt()` reads an integer.

`close()` closes the scanner resource.

## 29. Scanner Methods

| Method | Reads |
| --- | --- |
| `nextInt()` | Integer |
| `nextLong()` | Long integer |
| `nextFloat()` | Float |
| `nextDouble()` | Double |
| `next()` | One word string |
| `nextLine()` | Full line string |
| `nextBoolean()` | Boolean |

Example:

```java
import java.util.Scanner;

public class UserDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        System.out.print("Enter marks: ");
        double marks = sc.nextDouble();

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Marks: " + marks);

        sc.close();
    }
}
```

Important `nextLine()` problem:

After `nextInt()`, `nextDouble()`, or similar methods, a newline remains in input. If you call `nextLine()` immediately after that, it may read the leftover newline.

Solution:

```java
int age = sc.nextInt();
sc.nextLine(); // consume leftover newline
String name = sc.nextLine();
```

## 30. Control Statements

Control statements decide the flow of a program.

```text
Control Statements
|
+-- Decision Making
|   +-- if
|   +-- if else
|   +-- else if ladder
|   +-- nested if
|   +-- switch
|
+-- Looping
|   +-- for
|   +-- while
|   +-- do while
|   +-- enhanced for
|
+-- Jumping
    +-- break
    +-- continue
    +-- return
```

## 31. if Statement

Use `if` when you want to run code only if a condition is true.

Syntax:

```java
if (condition) {
    // code
}
```

Diagram:

```text
Start
  |
Check condition
  |
+-+---------+
| true      | false
v           v
Run code    Skip code
  |           |
  +-----+-----+
        v
       End
```

Example:

```java
int age = 20;

if (age >= 18) {
    System.out.println("You can vote");
}
```

## 32. if else Statement

Use `if else` when there are two paths.

Syntax:

```java
if (condition) {
    // code when true
} else {
    // code when false
}
```

Diagram:

```text
          condition
          /       \
       true       false
        |           |
    if block    else block
        \         /
          End
```

Example:

```java
int age = 16;

if (age >= 18) {
    System.out.println("Adult");
} else {
    System.out.println("Minor");
}
```

## 33. else if Ladder

Use `else if` when there are multiple conditions.

Example:

```java
int marks = 75;

if (marks >= 90) {
    System.out.println("Grade A");
} else if (marks >= 75) {
    System.out.println("Grade B");
} else if (marks >= 60) {
    System.out.println("Grade C");
} else {
    System.out.println("Needs improvement");
}
```

Diagram:

```text
marks >= 90 ?
  | yes -> Grade A
  no
marks >= 75 ?
  | yes -> Grade B
  no
marks >= 60 ?
  | yes -> Grade C
  no
Needs improvement
```

## 34. Nested if

Nested `if` means an `if` inside another `if`.

Example:

```java
int age = 20;
boolean hasVoterId = true;

if (age >= 18) {
    if (hasVoterId) {
        System.out.println("Allowed to vote");
    } else {
        System.out.println("Get voter ID first");
    }
} else {
    System.out.println("Not eligible by age");
}
```

Use nested `if` when one condition depends on another condition.

## 35. switch Statement

Use `switch` when one value has many possible cases.

Syntax:

```java
switch (value) {
    case option1:
        // code
        break;
    case option2:
        // code
        break;
    default:
        // code
}
```

Example:

```java
int day = 3;

switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    case 3:
        System.out.println("Wednesday");
        break;
    default:
        System.out.println("Invalid day");
}
```

Meaning:

`switch` checks a value.

`case` defines a possible match.

`break` exits the switch.

`default` runs when no case matches.

Without `break`, Java continues into the next case. This is called fall-through.

## 36. for Loop

Use `for` when you know how many times to repeat.

Syntax:

```java
for (initialization; condition; update) {
    // code
}
```

Diagram:

```text
Initialization
      |
Condition true?
   /       \
 yes       no
  |         |
Body       End
  |
Update
  |
Back to condition
```

Example:

```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```

Meaning:

`int i = 1` starts the counter.

`i <= 5` checks whether loop should continue.

`i++` increases `i` after every loop round.

## 37. while Loop

Use `while` when you want to repeat while a condition is true, but the number of repetitions may not be fixed.

Syntax:

```java
while (condition) {
    // code
}
```

Example:

```java
int i = 1;

while (i <= 5) {
    System.out.println(i);
    i++;
}
```

Diagram:

```text
Check condition
  |
true -> body -> update -> check again
  |
false
  |
End
```

## 38. do while Loop

Use `do while` when the loop body must run at least once.

Syntax:

```java
do {
    // code
} while (condition);
```

Example:

```java
int i = 1;

do {
    System.out.println(i);
    i++;
} while (i <= 5);
```

Difference:

`while` checks condition first.

`do while` runs code first, then checks condition.

## 39. Enhanced for Loop

Enhanced `for` loop is used to read values from arrays or collections.

Example:

```java
int[] numbers = {10, 20, 30};

for (int number : numbers) {
    System.out.println(number);
}
```

Meaning:

`number` takes one value from `numbers` in each loop round.

## 40. break Statement

`break` stops the loop or switch immediately.

Example:

```java
for (int i = 1; i <= 5; i++) {
    if (i == 3) {
        break;
    }
    System.out.println(i);
}
```

Output:

```text
1
2
```

## 41. continue Statement

`continue` skips the current loop round and moves to the next round.

Example:

```java
for (int i = 1; i <= 5; i++) {
    if (i == 3) {
        continue;
    }
    System.out.println(i);
}
```

Output:

```text
1
2
4
5
```

## 42. return Statement

`return` exits from a method.

Example:

```java
public class ReturnExample {
    public static void main(String[] args) {
        int age = 15;

        if (age < 18) {
            System.out.println("Not allowed");
            return;
        }

        System.out.println("Allowed");
    }
}
```

Here, if age is less than 18, the program prints `Not allowed` and exits the `main` method.

## 43. Arrays Basic Idea

An array stores multiple values of the same type.

Example:

```java
int[] marks = {80, 90, 75};
```

Diagram:

```text
Index:  0   1   2
Value: 80  90  75
```

Access value:

```java
System.out.println(marks[0]); // 80
```

Loop through array:

```java
for (int i = 0; i < marks.length; i++) {
    System.out.println(marks[i]);
}
```

## 44. String Basics

`String` stores text.

Example:

```java
String name = "Java";
```

Useful methods:

```java
System.out.println(name.length());
System.out.println(name.toUpperCase());
System.out.println(name.toLowerCase());
System.out.println(name.charAt(0));
```

String comparison:

```java
String a = "Java";
String b = "Java";

System.out.println(a.equals(b)); // true
```

Important:

Use `.equals()` to compare String content.

Avoid `==` for String content comparison because `==` compares references.

## 45. Methods Basic Idea

A method is a block of code that performs a task.

Example:

```java
public class MethodExample {
    static void greet() {
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        greet();
    }
}
```

Why methods are useful:

They avoid repeated code.

They make programs organized.

They make code easier to test.

## 46. Simple Area Of Circle Program

Example:

```java
import java.util.Scanner;

public class AreaOfCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter radius: ");
        double radius = sc.nextDouble();

        double area = 3.14159 * radius * radius;

        System.out.println("Area of circle = " + area);

        sc.close();
    }
}
```

Formula:

```text
area = pi * radius * radius
```

## 47. Common Beginner Errors

Missing semicolon:

```java
System.out.println("Hello")
```

Correct:

```java
System.out.println("Hello");
```

Class name and file name mismatch:

```text
File: Test.java
public class Demo
```

Correct:

```text
File: Test.java
public class Test
```

Using `=` instead of `==`:

```java
if (x = 5) { }
```

Correct:

```java
if (x == 5) { }
```

Forgetting import:

```java
Scanner sc = new Scanner(System.in);
```

Correct:

```java
import java.util.Scanner;
```

## 48. Complete Beginner Practice Program

This program uses input, variables, operators, if else, and output.

```java
import java.util.Scanner;

public class StudentResult {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter marks: ");
        int marks = sc.nextInt();

        System.out.println("Student: " + name);
        System.out.println("Marks: " + marks);

        if (marks >= 90) {
            System.out.println("Grade A");
        } else if (marks >= 75) {
            System.out.println("Grade B");
        } else if (marks >= 60) {
            System.out.println("Grade C");
        } else if (marks >= 40) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

        sc.close();
    }
}
```

## 49. Recommended Learning Sequence

Follow this order:

1. Install JDK.
2. Check `java -version` and `javac -version`.
3. Write first `Hello Java` program.
4. Understand class, main method, and print statements.
5. Learn comments.
6. Learn variables.
7. Learn primitive data types.
8. Learn naming conventions.
9. Learn operators.
10. Learn input using Scanner.
11. Learn `if`, `else`, and `else if`.
12. Learn `switch`.
13. Learn loops: `for`, `while`, `do while`.
14. Learn `break`, `continue`, and `return`.
15. Learn arrays and strings.
16. Practice small programs daily.

## 50. Small Practice Questions

1. Print your name, age, and city.
2. Take two numbers from the user and print their sum.
3. Take radius from the user and print area of circle.
4. Check whether a number is positive, negative, or zero.
5. Check whether a number is even or odd.
6. Print numbers from 1 to 10 using `for`.
7. Print numbers from 10 to 1 using `while`.
8. Print multiplication table of a number.
9. Find largest of three numbers.
10. Take marks and print grade.

## 51. Final Mini Revision

Java source file extension is `.java`.

Compiled bytecode file extension is `.class`.

`javac` compiles Java code.

`java` runs compiled Java code.

Program execution starts from `main`.

Every statement usually ends with `;`.

Blocks are created with `{}`.

Variables store values.

Operators perform operations.

Scanner takes input.

Control statements control program flow.

