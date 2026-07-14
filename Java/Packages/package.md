# Packages in Java

A package in Java is a group of related classes, interfaces, enums, records, and sub-packages.

> A package is like a folder that organizes Java files and avoids naming conflicts.

In simple words:

> Package means keeping related Java classes together under one name.

Real-life examples:

- All banking-related classes can be kept inside `com.bank`.
- All student-related classes can be kept inside `com.school.student`.
- All utility classes can be kept inside `com.app.util`.
- Java's `Scanner` class is inside the `java.util` package.

## Why Packages Are Needed

Without packages, all Java classes stay in one place.

That creates problems:

- Class names can conflict.
- Large projects become hard to manage.
- Code organization becomes poor.
- Access control becomes harder.
- Reusing code becomes difficult.

Example problem:

```java
class Student {
    String name;
}
```

In a large project, there may be many `Student` classes:

- School student
- College student
- Training student
- Exam student

Packages solve this:

```java
package com.school;

public class Student {
}
```

```java
package com.training;

public class Student {
}
```

Now both classes can exist because their full names are different:

```text
com.school.Student
com.training.Student
```

## Main Definition

A package is a namespace that organizes related Java types and prevents naming conflicts.

Java packages help with:

- Organization
- Access control
- Reusability
- Maintainability
- Naming conflict prevention

## Important Terms

| Term | Meaning |
| --- | --- |
| Package | Group of related Java classes and interfaces |
| `package` keyword | Used to declare a package |
| `import` keyword | Used to use classes from another package |
| Built-in package | Package provided by Java |
| User-defined package | Package created by programmer |
| Sub-package | Package inside another package name |
| Fully qualified name | Complete class name with package |
| Classpath | Location where Java searches for classes |
| JAR | Java archive file used to package compiled classes |

## Types of Packages in Java

Java packages are mainly divided into two types:

1. Built-in packages
2. User-defined packages

## 1. Built-In Packages

Built-in packages are already provided by Java.

Common built-in packages:

| Package | Use |
| --- | --- |
| `java.lang` | Basic Java classes like `String`, `Math`, `System` |
| `java.util` | Utility classes like `Scanner`, `ArrayList`, `HashMap` |
| `java.io` | File input and output classes |
| `java.time` | Date and time API |
| `java.sql` | JDBC database classes |
| `java.net` | Networking classes |
| `java.math` | Big number classes like `BigInteger`, `BigDecimal` |
| `javax.swing` | GUI classes |

Example using `java.util.Scanner`:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.println("Hello " + name);
    }
}
```

Explanation:

`Scanner` is inside the `java.util` package.

So we import it using:

```java
import java.util.Scanner;
```

## `java.lang` Package

The `java.lang` package is automatically imported in every Java program.

That is why we can use these classes without import:

- `String`
- `System`
- `Math`
- `Integer`
- `Double`
- `Object`
- `Thread`

Example:

```java
public class Main {
    public static void main(String[] args) {
        String name = "Sabya";
        System.out.println(name.toUpperCase());
        System.out.println(Math.sqrt(25));
    }
}
```

No import is needed because `String`, `System`, and `Math` are in `java.lang`.

## 2. User-Defined Packages

User-defined packages are created by programmers.

Syntax:

```java
package packageName;
```

Example:

```java
package school;

public class Student {
    public void showName() {
        System.out.println("Student name is Sabya");
    }
}
```

The package statement must be the first statement in the Java file, except comments.

## Basic Package Example

Folder structure:

```text
project
|
|-- school
|   |-- Student.java
|
|-- Main.java
```

`Student.java`

```java
package school;

public class Student {
    public void showDetails() {
        System.out.println("Student from school package");
    }
}
```

`Main.java`

```java
import school.Student;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.showDetails();
    }
}
```

Output:

```text
Student from school package
```

Program explanation:

`Student` belongs to the `school` package.

`Main` imports `school.Student`.

After importing, `Main` can create an object of `Student`.

## Package Declaration Rules

- The package declaration should be the first non-comment statement.
- Only one package declaration is allowed in one Java file.
- Package name should match folder structure.
- Package names are usually written in lowercase.
- A public class name must match the file name.

Valid:

```java
package com.company.app;

public class Employee {
}
```

Invalid:

```java
import java.util.Scanner;

package school; // Error

public class Student {
}
```

Reason:

`package` must come before `import`.

## Correct Order in Java File

The correct order is:

```text
1. package statement
2. import statements
3. class, interface, enum, or record declaration
```

Example:

```java
package com.app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLine());
    }
}
```

## Folder Structure and Package Name

Package name and folder structure should match.

Example package:

```java
package com.skillup.student;
```

Folder structure:

```text
com
|
|-- skillup
|   |-- student
|       |-- Student.java
```

If folder structure does not match package name, compile or run errors can happen.

## Compiling a Package Program

Example file:

`school/Student.java`

```java
package school;

public class Student {
    public void show() {
        System.out.println("Student class");
    }
}
```

Compile from project root:

```bash
javac school/Student.java
```

This creates:

```text
school/Student.class
```

## Compiling with `-d`

The `-d` option tells `javac` where to place compiled `.class` files.

```bash
javac -d . Student.java
```

If `Student.java` contains:

```java
package school;
```

Then Java creates:

```text
school/Student.class
```

Example:

```bash
javac -d . Student.java
```

Meaning:

- `javac` compiles the file.
- `-d .` means place output in the current directory.
- Java creates package folders automatically.

## Running a Package Program

If class has a package:

```java
package school;

public class StudentApp {
    public static void main(String[] args) {
        System.out.println("Running package program");
    }
}
```

Compile:

```bash
javac -d . StudentApp.java
```

Run:

```bash
java school.StudentApp
```

Important:

Do not run:

```bash
java StudentApp
```

Because the full class name is:

```text
school.StudentApp
```

## Fully Qualified Name

Fully qualified name means the complete name of a class including its package.

Example:

```java
java.util.Scanner
```

Here:

- `java.util` is package name
- `Scanner` is class name

Using fully qualified name:

```java
public class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Scanner created");
    }
}
```

Explanation:

Here we did not use `import`.

We used the full class name directly.

## `import` Keyword

The `import` keyword allows us to use classes from another package without writing the full package name every time.

```java
import java.util.Scanner;
```

Example:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    }
}
```

Without import:

```java
public class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
    }
}
```

Both are correct.

Import just makes code shorter and cleaner.

## Single-Type Import

Single-type import imports one specific class.

```java
import java.util.ArrayList;
```

Example:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Sabya");
        System.out.println(names);
    }
}
```

This is clear and recommended.

## Wildcard Import

Wildcard import imports all classes from a package.

```java
import java.util.*;
```

Example:

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
    }
}
```

Important:

`import java.util.*;` imports classes directly inside `java.util`.

It does not import sub-packages.

## Wildcard Import Does Not Import Sub-Packages

```java
import java.util.*;
```

This does not import:

```java
java.util.concurrent.ExecutorService
```

You must import it separately:

```java
import java.util.concurrent.ExecutorService;
```

or:

```java
import java.util.concurrent.*;
```

## Import Name Conflict

Sometimes two packages have classes with the same name.

Example:

```java
java.util.Date
java.sql.Date
```

If both are needed, use fully qualified name for at least one.

```java
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date utilDate = new Date();
        java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());

        System.out.println(utilDate);
        System.out.println(sqlDate);
    }
}
```

Explanation:

`Date` means `java.util.Date` because it is imported.

`java.sql.Date` is written with its full name to avoid confusion.

## Static Import

Static import allows direct access to static members of a class.

Syntax:

```java
import static packageName.ClassName.staticMember;
```

Example:

```java
import static java.lang.Math.PI;
import static java.lang.Math.sqrt;

public class Main {
    public static void main(String[] args) {
        System.out.println(PI);
        System.out.println(sqrt(25));
    }
}
```

Output:

```text
3.141592653589793
5.0
```

Without static import:

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(Math.PI);
        System.out.println(Math.sqrt(25));
    }
}
```

## Static Wildcard Import

```java
import static java.lang.Math.*;
```

Example:

```java
import static java.lang.Math.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(pow(2, 3));
        System.out.println(max(10, 20));
        System.out.println(PI);
    }
}
```

Static import should be used carefully.

Too many static imports can make code confusing.

## Default Package

If a Java file has no package declaration, it belongs to the default package.

Example:

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Default package");
    }
}
```

This class is in the default package.

Important:

Using the default package is fine for small practice programs.

For real projects, avoid the default package.

## Why Avoid Default Package

Default package is not recommended because:

- Classes cannot be imported easily into named packages.
- Large projects become hard to organize.
- Naming conflicts are more likely.
- Frameworks and build tools expect proper package structure.

For real Java projects, always use named packages.

## Sub-Package

A sub-package is a package that appears under another package name.

Example:

```text
com.app
com.app.service
com.app.repository
com.app.controller
```

Important:

Java treats these as separate packages:

```text
com.app
com.app.service
```

`com.app.service` is not automatically part of `com.app` for imports or access.

## Sub-Package Example

Folder structure:

```text
src
|
|-- com
|   |-- app
|       |-- model
|       |   |-- Student.java
|       |
|       |-- service
|           |-- StudentService.java
```

`Student.java`

```java
package com.app.model;

public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
```

`StudentService.java`

```java
package com.app.service;

import com.app.model.Student;

public class StudentService {
    public void printStudent(Student student) {
        System.out.println(student.getName());
    }
}
```

Explanation:

`StudentService` must import `com.app.model.Student`.

Sub-packages are not imported automatically.

## Access Modifiers and Packages

Packages are closely connected with access modifiers.

| Modifier | Same class | Same package | Subclass different package | Everywhere |
| --- | --- | --- | --- | --- |
| `private` | Yes | No | No | No |
| default | Yes | Yes | No | No |
| `protected` | Yes | Yes | Yes, through inheritance | No |
| `public` | Yes | Yes | Yes | Yes |

## Default Access in Same Package

If no access modifier is written, it is called default access or package-private access.

```java
package school;

class Student {
    void show() {
        System.out.println("Default access");
    }
}
```

This class can be used only inside the `school` package.

## Public Class Across Packages

To use a class from another package, the class must be public.

`school/Student.java`

```java
package school;

public class Student {
    public void show() {
        System.out.println("Public student class");
    }
}
```

`Main.java`

```java
import school.Student;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.show();
    }
}
```

Explanation:

`Student` is public, so another package can access it.

`show()` is also public, so another package can call it.

## Protected Access Across Packages

`protected` members can be accessed in a different package only through inheritance.

`company/Employee.java`

```java
package company;

public class Employee {
    protected String name = "Sabya";
}
```

`app/Developer.java`

```java
package app;

import company.Employee;

public class Developer extends Employee {
    public void showName() {
        System.out.println(name);
    }
}
```

Explanation:

`Developer` can access `name` because it extends `Employee`.

## Private Access in Packages

Private members are accessible only inside the same class.

```java
package school;

public class Student {
    private int marks = 90;

    public int getMarks() {
        return marks;
    }
}
```

Outside classes cannot access `marks` directly.

They must use `getMarks()`.

## Package Naming Conventions

Package names should be:

- Lowercase
- Meaningful
- Based on domain name for real projects
- Written in reverse domain format

Example:

```text
com.google.search
com.amazon.payment
com.skillup.java.basics
org.springframework.boot
```

Why reverse domain?

Domain names are unique.

So reverse domain package names reduce naming conflicts.

## Common Package Structure in Java Projects

Typical backend project structure:

```text
com.app
|
|-- controller
|-- service
|-- repository
|-- model
|-- dto
|-- exception
|-- config
|-- util
```

Meaning:

| Package | Purpose |
| --- | --- |
| `controller` | Handles API or user requests |
| `service` | Business logic |
| `repository` | Database access |
| `model` | Entity or domain classes |
| `dto` | Data transfer objects |
| `exception` | Custom exceptions |
| `config` | Configuration classes |
| `util` | Utility/helper classes |

## Package and Classpath

Classpath tells Java where to find compiled classes and libraries.

When running Java:

```bash
java -cp out com.app.Main
```

Meaning:

- `-cp out` tells Java to search inside the `out` folder.
- `com.app.Main` is the fully qualified class name.

`-classpath` and `-cp` mean the same thing.

## Compiling Source into Output Folder

Folder structure:

```text
src
|-- com
|   |-- app
|       |-- Main.java
```

Compile:

```bash
javac -d out src/com/app/Main.java
```

Run:

```bash
java -cp out com.app.Main
```

Explanation:

`javac -d out` places compiled classes into the `out` folder while preserving package structure.

`java -cp out` tells Java where compiled classes are located.

## Compiling Multiple Files

Suppose project has:

```text
src
|-- com
|   |-- app
|       |-- Main.java
|       |-- service
|           |-- StudentService.java
|       |-- model
|           |-- Student.java
```

Compile all Java files:

```bash
javac -d out src/com/app/model/Student.java src/com/app/service/StudentService.java src/com/app/Main.java
```

On larger projects, build tools like Maven or Gradle compile files automatically.

## Package with Maven Project

Maven standard structure:

```text
project
|
|-- src
|   |-- main
|   |   |-- java
|   |       |-- com
|   |           |-- app
|   |               |-- Main.java
|   |
|   |-- test
|       |-- java
|           |-- com
|               |-- app
|                   |-- MainTest.java
```

In Maven, package folders are usually inside:

```text
src/main/java
```

Test classes are inside:

```text
src/test/java
```

## Package with Spring Boot

Spring Boot commonly uses package structure like:

```text
com.example.demo
|
|-- DemoApplication.java
|-- controller
|-- service
|-- repository
|-- entity
|-- dto
|-- config
```

Important Spring Boot point:

The main application class should usually be in the root package.

Example:

```java
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```

If `DemoApplication` is in `com.example.demo`, Spring scans sub-packages like:

```text
com.example.demo.controller
com.example.demo.service
com.example.demo.repository
```

## Package and JAR File

A JAR file is a Java Archive file.

It packages compiled classes, resources, and metadata into one file.

Example:

```text
app.jar
```

JAR files are used to:

- Share libraries
- Package applications
- Add dependencies
- Deploy Java programs

## Creating a Simple JAR

Compile:

```bash
javac -d out src/com/app/Main.java
```

Create JAR:

```bash
jar --create --file app.jar -C out .
```

Run if it has a main class in manifest:

```bash
java -jar app.jar
```

For beginners, remember:

JAR is a packaged form of compiled Java classes.

## `package-info.java`

`package-info.java` is a special file used to add package-level documentation or annotations.

Example:

```java
/**
 * Contains service classes for student operations.
 */
package com.app.service;
```

It is not required for every package.

It is mostly used in libraries or well-documented projects.

## Importing Classes from Same Package

Classes in the same package do not need import.

`school/Student.java`

```java
package school;

public class Student {
    public void show() {
        System.out.println("Student");
    }
}
```

`school/Teacher.java`

```java
package school;

public class Teacher {
    public void teach() {
        Student student = new Student();
        student.show();
    }
}
```

Explanation:

Both classes are in `school`.

So `Teacher` can use `Student` without import.

## Importing Classes from Different Package

Classes in different packages need import or fully qualified name.

```java
package app;

import school.Student;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.show();
    }
}
```

## Public Class and File Name Rule

If a class is public, file name must match public class name.

Valid:

`Student.java`

```java
public class Student {
}
```

Invalid:

`StudentInfo.java`

```java
public class Student {
}
```

Reason:

Public class name and file name must be the same.

## Multiple Classes in One File

Java allows multiple classes in one file, but only one public top-level class is allowed.

`Main.java`

```java
public class Main {
    public static void main(String[] args) {
        Helper helper = new Helper();
        helper.show();
    }
}

class Helper {
    void show() {
        System.out.println("Helper class");
    }
}
```

Explanation:

`Main` is public, so file name is `Main.java`.

`Helper` is not public, so it can stay in the same file.

## Package and Encapsulation

Packages support encapsulation at a higher level.

Example:

```java
package banking;

class InternalValidator {
    boolean isValidAmount(double amount) {
        return amount > 0;
    }
}
```

`InternalValidator` has default access.

So it can be used only inside the `banking` package.

This hides internal helper classes from outside packages.

## Real-Life Example: Student Management Packages

Folder structure:

```text
src
|-- com
|   |-- school
|       |-- model
|       |   |-- Student.java
|       |
|       |-- service
|       |   |-- StudentService.java
|       |
|       |-- Main.java
```

`Student.java`

```java
package com.school.model;

public class Student {
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

`StudentService.java`

```java
package com.school.service;

import com.school.model.Student;

public class StudentService {
    public void printStudent(Student student) {
        System.out.println(student.getId() + " - " + student.getName());
    }
}
```

`Main.java`

```java
package com.school;

import com.school.model.Student;
import com.school.service.StudentService;

public class Main {
    public static void main(String[] args) {
        Student student = new Student(101, "Sabya");

        StudentService service = new StudentService();
        service.printStudent(student);
    }
}
```

Output:

```text
101 - Sabya
```

Program explanation:

`Student` is kept in the `model` package.

`StudentService` is kept in the `service` package.

`Main` imports both classes.

This makes the project organized.

## Real-Life Example: Banking Packages

Folder structure:

```text
src
|-- com
|   |-- bank
|       |-- account
|       |   |-- BankAccount.java
|       |
|       |-- service
|       |   |-- BankingService.java
|       |
|       |-- Main.java
```

`BankAccount.java`

```java
package com.bank.account;

public class BankAccount {
    private String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double balance) {
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
            System.out.println("Invalid amount");
            return;
        }
        balance = balance + amount;
    }
}
```

`BankingService.java`

```java
package com.bank.service;

import com.bank.account.BankAccount;

public class BankingService {
    public void depositMoney(BankAccount account, double amount) {
        account.deposit(amount);
        System.out.println("Updated balance: " + account.getBalance());
    }
}
```

`Main.java`

```java
package com.bank;

import com.bank.account.BankAccount;
import com.bank.service.BankingService;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Sabya", 10000);
        BankingService service = new BankingService();

        service.depositMoney(account, 2000);
    }
}
```

Output:

```text
Updated balance: 12000.0
```

Program explanation:

Bank account data is inside the `account` package.

Business logic is inside the `service` package.

The main class imports and uses both.

This is how real applications separate responsibilities.

## Common Compile and Run Errors

### Error: Class Not Found

Example:

```text
Error: Could not find or load main class Main
```

Possible reasons:

- You ran the class without full package name.
- You are not in the correct directory.
- Classpath is wrong.
- Compilation output folder is wrong.

If class is:

```java
package com.app;
```

Run it like:

```bash
java com.app.Main
```

or with output folder:

```bash
java -cp out com.app.Main
```

### Error: Package Does Not Exist

Example:

```text
package com.school.model does not exist
```

Possible reasons:

- Package folder is missing.
- Class was not compiled.
- Import statement is wrong.
- Classpath is wrong.
- Package name and folder structure do not match.

### Error: Duplicate Class

Possible reasons:

- Same fully qualified class name exists in two places.
- File path and package declaration conflict.
- Old `.class` files are still present in output folder.

## Best Practices

- Use packages in all real projects.
- Keep package names lowercase.
- Use meaningful package names.
- Use reverse domain naming for professional projects.
- Keep related classes in the same package.
- Separate layers using packages like `controller`, `service`, `repository`, and `model`.
- Avoid default package in real projects.
- Avoid wildcard imports in production code when clarity matters.
- Use public only for classes that need outside access.
- Keep internal helper classes package-private when possible.
- Use `-d` while compiling package-based programs manually.

## Common Mistakes

Mistake 1:

Writing `package` after `import`.

```java
import java.util.Scanner;
package school; // Error
```

Correct:

```java
package school;
import java.util.Scanner;
```

Mistake 2:

Running a package class without full name.

```bash
java Main
```

Correct:

```bash
java com.app.Main
```

Mistake 3:

Thinking wildcard imports include sub-packages.

```java
import java.util.*;
```

This does not import `java.util.concurrent`.

Mistake 4:

Using uppercase package names.

```java
package Com.App; // Not recommended
```

Correct:

```java
package com.app;
```

Mistake 5:

Making every class public.

Only expose classes that must be used outside the package.

## Interview Questions

### What is a package in Java?

A package is a namespace that groups related classes, interfaces, enums, records, and sub-packages. It helps organize code and prevents naming conflicts.

### What are the types of packages in Java?

There are two types:

- Built-in packages
- User-defined packages

### Which keyword is used to create a package?

The `package` keyword is used to create a package.

```java
package com.app;
```

### Which keyword is used to use another package class?

The `import` keyword is used.

```java
import java.util.Scanner;
```

### Is `java.lang` imported automatically?

Yes. `java.lang` is imported automatically in every Java program.

### What is a fully qualified class name?

A fully qualified class name is the complete class name with package.

Example:

```java
java.util.Scanner
```

### Does wildcard import import sub-packages?

No. Wildcard import imports only classes directly inside that package.

`import java.util.*;` does not import `java.util.concurrent.*`.

### Can classes in the same package access each other without import?

Yes. Classes in the same package do not need import.

### Can a class in a named package import a class from the default package?

No. Classes in named packages cannot import classes from the default package.

This is one reason to avoid the default package.

### What is static import?

Static import allows direct access to static members without writing the class name.

```java
import static java.lang.Math.sqrt;
```

### What is classpath?

Classpath is the location where Java searches for compiled classes and libraries.

### What is a JAR file?

A JAR file is a Java Archive file used to package compiled Java classes and resources.

## Quick Revision Table

| Concept | Short Meaning |
| --- | --- |
| Package | Group of related Java classes |
| `package` | Declares package |
| `import` | Uses class from another package |
| Built-in package | Package provided by Java |
| User-defined package | Package created by programmer |
| `java.lang` | Imported automatically |
| Fully qualified name | Package name plus class name |
| Static import | Imports static members |
| Default package | Package-less class location |
| Sub-package | Package with nested name |
| Classpath | Search path for classes |
| JAR | Packaged Java archive |
| `-d` | Output directory for compiled classes |
| `-cp` | Classpath option |

## One-Line Memory Trick

Package = folder-like namespace that organizes Java classes and avoids name conflicts.
