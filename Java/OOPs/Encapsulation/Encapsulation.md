# Encapsulation in Java

Encapsulation is one of the most important concepts of Object-Oriented Programming. As your trainer, I want you to remember it like this:

> Encapsulation means keeping data safe inside a class and allowing access only through controlled methods.

In simple words, we put variables and methods together in one class, then we protect the variables using `private` and access them using `public` methods.

## Why Encapsulation Is Needed

Imagine a `Human` class with an `age` variable. If the variable is public, anyone can write:

```java
obj.age = -10;
```

This is logically wrong because age cannot be negative. Encapsulation protects the data from this kind of invalid change.

## Main Definition

Encapsulation is the process of wrapping data and methods into a single unit called a class, and hiding the internal data from direct outside access.

Example:

```java
class Human {
    private String name;
    private int age;
}
```

Here, `name` and `age` are data members, and they are hidden using the `private` access modifier.

## Important Concepts

### 1. Class

A class is a blueprint. It contains variables and methods.

```java
class Human {
    private String name;
    private int age;
}
```

### 2. Private Variables

Private variables cannot be accessed directly from outside the class.

```java
private String name;
private int age;
```

This is called data hiding.

### 3. Getter Method

A getter method is used to read the value of a private variable.

```java
public String getName() {
    return name;
}
```

Trainer note: A getter means "give me the value."

### 4. Setter Method

A setter method is used to update the value of a private variable.

```java
public void setName(String name) {
    this.name = name;
}
```

Trainer note: A setter means "set or update the value."

### 5. Validation in Setter

The biggest advantage of a setter is that we can check data before saving it.

```java
public void setAge(int age) {
    if (age <= 0) {
        System.out.println("Invalid age");
        return;
    }
    this.age = age;
}
```

Now nobody can store a negative age.

### 6. this Keyword

`this` refers to the current object.

```java
this.name = name;
```

The left side `this.name` is the instance variable. The right side `name` is the method parameter.

### 7. Constructor

A constructor is used to initialize an object.

```java
public Human(String name, int age) {
    setName(name);
    setAge(age);
}
```

Calling setters inside a constructor is useful because validation logic is reused.

### 8. Read-Only Class

If a class has only getters and no setters, values can be read but cannot be changed from outside.

```java
class Student {
    private String college = "ABC College";

    public String getCollege() {
        return college;
    }
}
```

### 9. Write-Only Class

If a class has only setters and no getters, values can be updated but cannot be read directly from outside.

```java
class Password {
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }
}
```

This can be useful for sensitive data.

### 10. Fully Encapsulated Class

A fully encapsulated class has:

- All variables marked as `private`
- Public getters and setters for controlled access
- Validation inside setters when needed

## Complete Example

```java
class BankAccount {
    private String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        setBalance(balance);
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 0) {
            System.out.println("Balance cannot be negative");
            return;
        }
        this.balance = balance;
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

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Sabya", 1000);

        account.deposit(500);
        account.withdraw(300);

        System.out.println(account.getAccountHolder());
        System.out.println(account.getBalance());
    }
}
```

## Program Explanation

`accountHolder` and `balance` are private, so outside code cannot change them directly.

`getAccountHolder()` and `getBalance()` allow safe read access.

`setBalance()` prevents negative balance.

`deposit()` adds money only when the amount is valid.

`withdraw()` removes money only when the amount is valid and balance is enough.

This is the real power of encapsulation: the class protects its own data.

## Advantages of Encapsulation

- Protects data from direct access
- Improves security
- Allows validation before updating data
- Makes code easier to maintain
- Reduces bugs
- Improves code readability
- Helps achieve data hiding
- Gives control over read and write operations

## Encapsulation vs Data Hiding

Encapsulation is the bigger concept. It means wrapping data and methods together.

Data hiding is part of encapsulation. It means hiding variables using access modifiers like `private`.

## Access Modifiers and Encapsulation

| Modifier | Meaning | Encapsulation Use |
| --- | --- | --- |
| `private` | Accessible only inside same class | Best for variables |
| `default` | Accessible inside same package | Limited use |
| `protected` | Accessible in same package and child classes | Used in inheritance |
| `public` | Accessible from anywhere | Best for getters, setters, and useful methods |

## Best Practices

- Keep instance variables `private`
- Use getters only when outside code needs to read data
- Use setters only when outside code needs to update data
- Add validation inside setters
- Prefer meaningful methods like `deposit()` and `withdraw()` instead of blindly exposing setters
- Do not make variables public unless there is a very strong reason

## Interview Answer

Encapsulation is an OOP concept where data and methods are wrapped together inside a class. The data is hidden using private variables, and access is provided through public getter and setter methods. It improves security, validation, maintainability, and control over data.

## One-Line Memory Trick

Encapsulation = private data + public controlled methods.
