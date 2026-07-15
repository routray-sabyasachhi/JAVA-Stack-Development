# Java Exception Handling

A complete guide to understanding, handling, and managing exceptions in Java. This covers the exception hierarchy, types of exceptions, exception handling mechanisms, custom exceptions, and best practices.

## 1. What Is an Exception?

An exception is an event that disrupts the normal flow of program execution.

**Example of abnormal events:**
- Dividing a number by zero
- Accessing an array index that doesn't exist
- Trying to open a file that doesn't exist
- Attempting to cast an incompatible type
- Calling a method on a null object

Without exception handling, the program crashes. With exception handling, the program can catch errors and handle them gracefully.

## 2. Exception vs Error

| Aspect | Exception | Error |
| --- | --- | --- |
| **Definition** | An event that disrupts normal program flow | A serious problem that typically shouldn't be caught |
| **Type** | Checked and Unchecked | Unchecked (inherited from `Throwable`) |
| **Handling** | Should be caught and handled | Generally not caught |
| **Recovery** | Program can recover | Program typically crashes |
| **Examples** | `IOException`, `SQLException`, `NullPointerException` | `StackOverflowError`, `OutOfMemoryError` |

**Key Point:** Always handle exceptions, never handle errors.

## 3. Java Exception Hierarchy

```
Throwable (root class for all errors and exceptions)
    ├── Error (unchecked, don't catch)
    │   ├── StackOverflowError
    │   ├── OutOfMemoryError
    │   └── VirtualMachineError
    │
    └── Exception (handled by us)
        ├── Checked Exception (must be caught or declared)
        │   ├── IOException
        │   ├── SQLException
        │   ├── FileNotFoundException
        │   ├── ClassNotFoundException
        │   ├── InterruptedException
        │   └── Custom Checked Exceptions
        │
        └── Unchecked Exception (inherits from RuntimeException)
            ├── RuntimeException
            │   ├── NullPointerException
            │   ├── ArrayIndexOutOfBoundsException
            │   ├── ArithmeticException
            │   ├── ClassCastException
            │   ├── IllegalArgumentException
            │   ├── NumberFormatException
            │   └── Custom Unchecked Exceptions
```

## 4. Checked vs Unchecked Exceptions

### Checked Exceptions

Checked exceptions are **compile-time exceptions**. The compiler forces you to handle them.

**Characteristics:**
- Must be caught or declared using `throws` keyword
- Compiler checks if they are handled
- Inherits from `Exception` class (not from `RuntimeException`)

**Common Checked Exceptions:**
- `IOException` - Input/Output operations
- `SQLException` - Database operations
- `FileNotFoundException` - File operations
- `ClassNotFoundException` - Class loading
- `InterruptedException` - Thread interruption

**Example:**

```java
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CheckedExceptionExample {
    public static void main(String[] args) {
        // FileNotFoundException is a checked exception
        // Compiler forces us to handle it
        try {
            FileReader file = new FileReader("nonexistent.txt");
            // Read file
        } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
```

### Unchecked Exceptions

Unchecked exceptions are **runtime exceptions**. The compiler doesn't force you to handle them.

**Characteristics:**
- Don't need to be caught or declared
- Occur at runtime
- Inherits from `RuntimeException` class
- Programmer's responsibility to avoid

**Common Unchecked Exceptions:**
- `NullPointerException` - Accessing null object
- `ArrayIndexOutOfBoundsException` - Invalid array index
- `ArithmeticException` - Arithmetic errors
- `ClassCastException` - Invalid casting
- `IllegalArgumentException` - Invalid argument
- `NumberFormatException` - String to number conversion failure

**Example:**

```java
public class UncheckedExceptionExample {
    public static void main(String[] args) {
        // NullPointerException - unchecked
        String str = null;
        System.out.println(str.length()); // Crashes with NullPointerException
        
        // ArithmeticException - unchecked
        int result = 10 / 0; // Crashes with ArithmeticException
        
        // ArrayIndexOutOfBoundsException - unchecked
        int[] arr = {1, 2, 3};
        System.out.println(arr[5]); // Crashes with ArrayIndexOutOfBoundsException
    }
}
```

## 5. Try-Catch Block

The `try-catch` block is used to handle exceptions.

**Syntax:**

```java
try {
    // Code that might throw an exception
    // If an exception occurs, control jumps to catch block
} catch (ExceptionType1 e) {
    // Handle ExceptionType1
    System.out.println("Caught: " + e.getMessage());
} catch (ExceptionType2 e) {
    // Handle ExceptionType2
} finally {
    // Optional: Executes regardless of exception (cleanup code)
}
```

### Basic Try-Catch Example

```java
public class BasicTryCatch {
    public static void main(String[] args) {
        try {
            int a = 10;
            int b = 0;
            int result = a / b; // ArithmeticException
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Program continues...");
    }
}
```

**Output:**
```text
Cannot divide by zero
Error: / by zero
Program continues...
```

### Multiple Catch Blocks

Handle different exceptions differently.

```java
public class MultipleCatch {
    public static void main(String[] args) {
        try {
            int[] numbers = {1, 2, 3};
            String value = "abc";
            
            int num = Integer.parseInt(value); // NumberFormatException
            int result = numbers[10]; // ArrayIndexOutOfBoundsException
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds");
        } catch (Exception e) {
            System.out.println("General exception: " + e.getMessage());
        }
    }
}
```

**Key Points:**
- Catch more specific exceptions first
- Catch general exceptions last
- Only one catch block executes (the first match)

### Multi-Catch Block (Java 7+)

Handle multiple exceptions with the same code using `|` (pipe).

```java
public class MultiCatch {
    public static void main(String[] args) {
        try {
            int[] arr = {1, 2, 3};
            int result = arr[5] / 0; // Could throw multiple exceptions
        } catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
```

## 6. Finally Block

The `finally` block **always executes**, whether an exception occurs or not. Use it for cleanup code.

**When does finally execute?**
- After try block completes normally
- After a catch block executes
- Before a method returns (unless System.exit() is called)

**Example:**

```java
public class FinallyBlockExample {
    public static void main(String[] args) {
        try {
            System.out.println("Trying to execute");
            int result = 10 / 0; // Exception here
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        } finally {
            System.out.println("Finally block always executes");
        }
    }
}
```

**Output:**
```text
Trying to execute
Caught ArithmeticException: / by zero
Finally block always executes
```

### Common Uses of Finally

```java
// Closing resources
FileReader reader = null;
try {
    reader = new FileReader("file.txt");
    // Read file
} catch (IOException e) {
    System.out.println("Error reading file");
} finally {
    if (reader != null) {
        try {
            reader.close(); // Always close the resource
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## 7. Try-With-Resources (Java 7+)

Automatically closes resources that implement `AutoCloseable`.

**Syntax:**

```java
try (ResourceType resource = new ResourceType()) {
    // Use resource
} catch (Exception e) {
    // Handle exception
}
// Resource automatically closed here
```

**Advantages:**
- Cleaner code
- Automatic resource closure
- No need for finally block

**Example:**

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {
    public static void main(String[] args) {
        // FileReader automatically closes after try block
        try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
```

**Multiple Resources:**

```java
try (
    BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
    BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))
) {
    String line;
    while ((line = reader.readLine()) != null) {
        writer.write(line);
        writer.newLine();
    }
} catch (IOException e) {
    System.out.println("Error: " + e.getMessage());
}
```

## 8. Throwing Exceptions

Use the `throw` keyword to explicitly throw an exception.

**Syntax:**

```java
throw new ExceptionType("Error message");
```

**Example:**

```java
public class ThrowingException {
    public static void checkAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        System.out.println("Age is valid: " + age);
    }
    
    public static void main(String[] args) {
        try {
            checkAge(-5); // Throws exception
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
```

**Output:**
```text
Caught: Age cannot be negative
```

### Throws Keyword (Declaration)

Use `throws` keyword to declare that a method throws an exception. The caller must handle it.

**Syntax:**

```java
public returnType methodName() throws ExceptionType {
    // Method implementation
}
```

**Example:**

```java
import java.io.FileReader;
import java.io.IOException;

public class ThrowsKeyword {
    // Method declares it throws IOException
    public static void readFile(String filename) throws IOException {
        FileReader reader = new FileReader(filename);
        // Read file operations
        reader.close();
    }
    
    public static void main(String[] args) {
        try {
            readFile("test.txt");
        } catch (IOException e) {
            System.out.println("Caller caught: " + e.getMessage());
        }
    }
}
```

**Key Difference:**
- `throw` - Explicitly throws an exception
- `throws` - Declares that a method may throw an exception

## 9. Custom Exceptions

Create your own exceptions by extending `Exception` or `RuntimeException`.

### Custom Checked Exception

```java
// Define custom exception
public class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

// Use custom exception
public class Person {
    private int age;
    
    public Person(int age) throws InvalidAgeException {
        if (age < 0 || age > 150) {
            throw new InvalidAgeException("Age must be between 0 and 150");
        }
        this.age = age;
    }
    
    public int getAge() {
        return age;
    }
}

// Client code
public class CustomExceptionExample {
    public static void main(String[] args) {
        try {
            Person person = new Person(200); // Throws custom exception
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

### Custom Unchecked Exception

```java
// Define custom unchecked exception
public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Use custom exception
public class BankAccount {
    private double balance;
    
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    
    public void withdraw(double amount) {
        if (amount > balance) {
            throw new InsufficientBalanceException(
                "Insufficient balance. Available: " + balance + ", Requested: " + amount
            );
        }
        balance -= amount;
        System.out.println("Withdrawal successful. Balance: " + balance);
    }
}
```

## 10. Common Java Exceptions

| Exception | Cause | Solution |
| --- | --- | --- |
| `NullPointerException` | Accessing member of null object | Check for null before access |
| `ArrayIndexOutOfBoundsException` | Invalid array index | Check array bounds |
| `ArithmeticException` | Division by zero | Check divisor before operation |
| `ClassCastException` | Invalid type casting | Check type before casting |
| `NumberFormatException` | String to number conversion fails | Validate string format |
| `StringIndexOutOfBoundsException` | Invalid string index | Check string bounds |
| `IllegalArgumentException` | Invalid argument passed | Validate arguments |
| `IllegalStateException` | Invalid object state | Check state before operation |
| `UnsupportedOperationException` | Unsupported operation | Check supported operations |
| `IOException` | Input/output error | Handle I/O operations carefully |
| `SQLException` | Database error | Handle database operations |
| `FileNotFoundException` | File doesn't exist | Check file existence |
| `ClassNotFoundException` | Class doesn't exist | Check class name and path |

### Common Exception Examples

```java
public class CommonExceptionsDemo {
    public static void main(String[] args) {
        // 1. NullPointerException
        try {
            String str = null;
            int length = str.length();
        } catch (NullPointerException e) {
            System.out.println("NPE: Don't use null objects");
        }
        
        // 2. ArrayIndexOutOfBoundsException
        try {
            int[] arr = {1, 2, 3};
            int value = arr[10];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index error");
        }
        
        // 3. ArithmeticException
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        }
        
        // 4. ClassCastException
        try {
            Object obj = "String";
            Integer num = (Integer) obj;
        } catch (ClassCastException e) {
            System.out.println("Invalid type casting");
        }
        
        // 5. NumberFormatException
        try {
            int num = Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format");
        }
    }
}
```

## 11. Exception Handling Best Practices

### 1. Catch Specific Exceptions First

```java
// Good ✓
try {
    // code
} catch (FileNotFoundException e) {
    // Handle specific exception
} catch (IOException e) {
    // Handle general exception
}

// Bad ✗
try {
    // code
} catch (IOException e) {
    // Catches FileNotFoundException too, but less specific
} catch (FileNotFoundException e) {
    // Never reached
}
```

### 2. Don't Catch Generic Exception

```java
// Bad ✗
try {
    // code
} catch (Exception e) {
    // Catches everything - bad practice
}

// Good ✓
try {
    // code
} catch (SpecificException e) {
    // Handle specific exception
}
```

### 3. Don't Ignore Exceptions

```java
// Bad ✗
try {
    // code
} catch (Exception e) {
    // Empty catch block - ignores exception
}

// Good ✓
try {
    // code
} catch (Exception e) {
    // Log the exception
    System.out.println("Error occurred: " + e.getMessage());
    e.printStackTrace();
}
```

### 4. Provide Meaningful Error Messages

```java
// Bad ✗
throw new Exception("Error");

// Good ✓
throw new Exception("Cannot process payment. Amount cannot be negative: " + amount);
```

### 5. Clean Up Resources in Finally or Try-With-Resources

```java
// Good - Using try-with-resources ✓
try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
    // Use resource
} catch (IOException e) {
    e.printStackTrace();
}
```

### 6. Chain Exceptions for Context

```java
try {
    // Database operation
} catch (SQLException e) {
    throw new DataAccessException("Failed to fetch user data", e);
}
```

### 7. Don't Throw Exceptions from Finally Block

```java
// Bad ✗
finally {
    try {
        resource.close();
    } catch (Exception e) {
        throw e; // Don't throw from finally
    }
}

// Good ✓
finally {
    try {
        resource.close();
    } catch (Exception e) {
        // Log the error
        logger.error("Failed to close resource", e);
    }
}
```

## 12. Exception Handling Flow

**Control Flow:**

```
try {
    ↓
    Statement 1  →  Exception at Statement 2  →  Jump to catch
    ↓
    Statement 2 (throws exception)
    ↓
    Statement 3 (skipped)
} catch {
    ↓
    Handle exception
} finally {
    ↓
    Always executed
}
```

**Example:**

```java
public class ExceptionFlow {
    public static void main(String[] args) {
        try {
            System.out.println("1. Before division");
            int result = 10 / 0; // Exception thrown
            System.out.println("2. After division"); // Skipped
        } catch (ArithmeticException e) {
            System.out.println("3. Caught exception");
        } finally {
            System.out.println("4. Finally block");
        }
        System.out.println("5. After try-catch");
    }
}
```

**Output:**
```text
1. Before division
3. Caught exception
4. Finally block
5. After try-catch
```

## 13. Checked Exceptions Best Practices

### Wrap Checked Exceptions in Unchecked

```java
public class UserService {
    public User getUser(int id) {
        try {
            // Database operation that throws SQLException (checked)
            return fetchFromDatabase(id);
        } catch (SQLException e) {
            // Wrap in runtime exception
            throw new DataAccessException("Failed to fetch user", e);
        }
    }
}

public class DataAccessException extends RuntimeException {
    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
```

### Convert to Unchecked When Handling

```java
public List<User> getAllUsers() {
    return userList.stream()
        .map(id -> {
            try {
                return getUser(id);
            } catch (SQLException e) {
                throw new RuntimeException("Error fetching user", e);
            }
        })
        .collect(Collectors.toList());
}
```

## 14. Practice Programs

### Program 1: Bank Account with Validation

```java
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class BankAccount {
    private double balance;
    
    public BankAccount(double initialBalance) throws Exception {
        if (initialBalance < 0) {
            throw new Exception("Initial balance cannot be negative");
        }
        this.balance = initialBalance;
    }
    
    public void deposit(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Deposit amount must be positive");
        }
        balance += amount;
        System.out.println("Deposited: " + amount + ", Balance: " + balance);
    }
    
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(
                "Insufficient funds. Balance: " + balance + ", Requested: " + amount
            );
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount + ", Balance: " + balance);
    }
    
    public double getBalance() {
        return balance;
    }
}

public class BankApp {
    public static void main(String[] args) {
        try {
            BankAccount account = new BankAccount(1000);
            account.deposit(500);
            account.withdraw(300);
            account.withdraw(2000); // Throws InsufficientFundsException
        } catch (InsufficientFundsException e) {
            System.out.println("Transaction failed: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

### Program 2: Array Access with Exception Handling

```java
public class ArrayOperations {
    public static int getElement(int[] arr, int index) {
        try {
            return arr[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index: " + index + ", Array size: " + arr.length);
            return -1;
        } catch (NullPointerException e) {
            System.out.println("Array is null");
            return -1;
        }
    }
    
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        
        System.out.println("Element at index 2: " + getElement(numbers, 2));
        System.out.println("Element at index 10: " + getElement(numbers, 10));
        System.out.println("Element from null: " + getElement(null, 0));
    }
}
```

### Program 3: User Registration with Validation

```java
class InvalidEmailException extends Exception {
    public InvalidEmailException(String message) {
        super(message);
    }
}

class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}

public class User {
    private String email;
    private String password;
    
    public User(String email, String password) 
            throws InvalidEmailException, InvalidPasswordException {
        setEmail(email);
        setPassword(password);
    }
    
    private void setEmail(String email) throws InvalidEmailException {
        if (email == null || !email.contains("@")) {
            throw new InvalidEmailException("Invalid email format");
        }
        this.email = email;
    }
    
    private void setPassword(String password) throws InvalidPasswordException {
        if (password == null || password.length() < 8) {
            throw new InvalidPasswordException("Password must be at least 8 characters");
        }
        this.password = password;
    }
    
    public String getEmail() {
        return email;
    }
}

public class RegistrationApp {
    public static void main(String[] args) {
        try {
            User user = new User("john@example.com", "password123");
            System.out.println("Registration successful: " + user.getEmail());
        } catch (InvalidEmailException e) {
            System.out.println("Email error: " + e.getMessage());
        } catch (InvalidPasswordException e) {
            System.out.println("Password error: " + e.getMessage());
        }
    }
}
```

### Program 4: File Operations with Try-With-Resources

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperations {
    public static void copyFile(String source, String destination) {
        try (
            BufferedReader reader = new BufferedReader(new FileReader(source));
            BufferedWriter writer = new BufferedWriter(new FileWriter(destination))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("File copied successfully");
        } catch (IOException e) {
            System.out.println("Error copying file: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        copyFile("input.txt", "output.txt");
    }
}
```

## 15. Summary Checklist

- ✓ Understand exception hierarchy and throwable classes
- ✓ Know difference between checked and unchecked exceptions
- ✓ Use try-catch-finally blocks correctly
- ✓ Prefer try-with-resources for resource management
- ✓ Create custom exceptions for domain-specific errors
- ✓ Throw meaningful exception messages
- ✓ Catch specific exceptions in correct order
- ✓ Avoid empty catch blocks
- ✓ Provide error logging and handling
- ✓ Use finally block for cleanup operations
- ✓ Never catch generic Exception class unnecessarily
- ✓ Handle both checked and unchecked exceptions appropriately
