# Multi-Threading and Concurrency in Java

> **Level:** Advanced Core Java
> **Prerequisites:** OOP, Exception Handling, Collections, Generics, Java I/O
> **Goal:** Understand how Java creates, manages, synchronizes, and coordinates multiple threads and how to write safe concurrent applications.

---

## 1. Introduction to Multi-Threading

### What is a Thread?

A **thread** is the smallest unit of execution within a process.

A Java application starts with at least one thread:

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Main Thread");
    }
}
```

The `main()` method executes inside the **main thread**.

### Process vs Thread

| Process                               | Thread                                |
| ------------------------------------- | ------------------------------------- |
| Independent program in execution      | Small execution unit inside a process |
| Has its own memory space              | Shares process memory                 |
| More expensive                        | Less expensive                        |
| Communication is relatively expensive | Communication is easier               |
| Example: Chrome, IntelliJ             | Example: GC thread, main thread       |

---

# 2. Why Multi-Threading?

Multi-threading allows multiple tasks to execute concurrently.

### Benefits

* Better CPU utilization
* Improved application responsiveness
* Parallel execution on multi-core CPUs
* Background task execution
* Better resource utilization
* Useful for servers and distributed applications

Example:

```java
public class Main {
    public static void main(String[] args) {

        Thread task1 = new Thread(() -> {
            System.out.println("Downloading file...");
        });

        Thread task2 = new Thread(() -> {
            System.out.println("Processing data...");
        });

        task1.start();
        task2.start();
    }
}
```

The order of execution is not guaranteed.

---

# 3. Concurrency vs Parallelism

### Concurrency

Multiple tasks are making progress during overlapping periods.

### Parallelism

Multiple tasks are actually executing simultaneously on different CPU cores.

```text
Concurrency:

Task A ------
      Task B ------
           Task C ------

Parallelism:

CPU 1: Task A --------
CPU 2: Task B --------
CPU 3: Task C --------
```

A multi-threaded program can provide concurrency even on a single-core CPU.

---

# 4. Creating Threads

Java provides several approaches.

## 4.1 Extending `Thread`

```java
class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("Thread is running");
    }
}

public class Main {
    public static void main(String[] args) {

        MyThread thread = new MyThread();

        thread.start();
    }
}
```

### Important

Never call:

```java
thread.run();
```

when you want to create a new thread.

Use:

```java
thread.start();
```

`start()` creates a new thread and eventually invokes `run()`.

---

# 5. Implementing `Runnable`

A better approach is often to implement `Runnable`.

```java
class Task implements Runnable {

    @Override
    public void run() {
        System.out.println("Task is running");
    }
}

public class Main {
    public static void main(String[] args) {

        Thread thread = new Thread(new Task());

        thread.start();
    }
}
```

### Why `Runnable`?

Java supports single inheritance.

Therefore:

```java
class Task extends Thread
```

prevents the class from extending another class.

Using:

```java
class Task implements Runnable
```

keeps inheritance available.

---

# 6. Lambda Expression with Thread

Since `Runnable` is a functional interface:

```java
Thread thread = new Thread(() -> {
    System.out.println("Running task");
});

thread.start();
```

Short form:

```java
new Thread(() -> System.out.println("Hello")).start();
```

---

# 7. `Callable`

`Runnable` cannot return a result.

`Callable` can return a value and throw checked exceptions.

```java
import java.util.concurrent.Callable;

Callable<Integer> task = () -> {
    return 100;
};
```

Difference:

| Runnable                                | Callable                        |
| --------------------------------------- | ------------------------------- |
| `run()`                                 | `call()`                        |
| No return value                         | Returns value                   |
| Cannot throw checked exception directly | Can throw checked exceptions    |
| Used for tasks without result           | Used for tasks producing result |

---

# 8. Thread Lifecycle

A Java thread can have several states.

```text
NEW
 |
 | start()
 v
RUNNABLE
 |
 +----> BLOCKED
 |
 +----> WAITING
 |
 +----> TIMED_WAITING
 |
 v
TERMINATED
```

Java defines these states through:

```java
Thread.State
```

Main states:

* `NEW`
* `RUNNABLE`
* `BLOCKED`
* `WAITING`
* `TIMED_WAITING`
* `TERMINATED`

---

# 9. Checking Thread State

```java
Thread thread = new Thread(() -> {
    System.out.println("Running");
});

System.out.println(thread.getState());

thread.start();

System.out.println(thread.getState());
```

Possible output:

```text
NEW
RUNNABLE
```

The exact state observed depends on scheduling.

---

# 10. Thread Methods

Important methods:

```java
start()
run()
sleep()
join()
interrupt()
isAlive()
getName()
setName()
getPriority()
setPriority()
currentThread()
yield()
```

---

# 11. Thread Name

```java
Thread thread = new Thread(() -> {
    System.out.println(Thread.currentThread().getName());
});

thread.setName("Worker-1");

thread.start();
```

Output:

```text
Worker-1
```

Get current thread:

```java
Thread current = Thread.currentThread();

System.out.println(current.getName());
```

---

# 12. Thread Priority

Java provides priorities from:

```text
1 -> MIN_PRIORITY
5 -> NORM_PRIORITY
10 -> MAX_PRIORITY
```

Example:

```java
Thread thread = new Thread(() -> {
    System.out.println("Task");
});

thread.setPriority(Thread.MAX_PRIORITY);

thread.start();
```

### Important

Thread priority is only a scheduling hint.

Do not rely on priority for program correctness.

---

# 13. `sleep()`

`sleep()` pauses the current thread for a specified time.

```java
try {
    Thread.sleep(1000);
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}
```

Example:

```java
for (int i = 1; i <= 5; i++) {

    System.out.println(i);

    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
}
```

---

# 14. `join()`

`join()` makes one thread wait for another thread to finish.

```java
Thread thread = new Thread(() -> {

    for (int i = 1; i <= 5; i++) {
        System.out.println(i);
    }
});

thread.start();

try {
    thread.join();
} catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}

System.out.println("Main thread continues");
```

Concept:

```text
Main Thread
    |
    +---- starts Worker
              |
              | executing
              |
              v
           finishes
    |
    v
continues
```

---

# 15. `isAlive()`

Checks whether a thread is still running.

```java
Thread thread = new Thread(() -> {
    System.out.println("Task");
});

System.out.println(thread.isAlive());

thread.start();

System.out.println(thread.isAlive());
```

---

# 16. `yield()`

`yield()` gives the scheduler a hint that the current thread is willing to allow another runnable thread to execute.

```java
Thread.yield();
```

It is only a scheduling hint.

Do not depend on it for synchronization.

---

# 17. Daemon Threads

A daemon thread performs background work.

Examples include:

* Garbage collection
* Background monitoring
* Cleanup tasks

Example:

```java
Thread daemon = new Thread(() -> {

    while (true) {
        System.out.println("Background task");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            break;
        }
    }
});

daemon.setDaemon(true);

daemon.start();
```

A JVM can terminate when all non-daemon threads have finished.

---

# 18. Race Condition

A **race condition** occurs when multiple threads access shared data and the final result depends on the timing of execution.

Example:

```java
class Counter {

    int count = 0;

    void increment() {
        count++;
    }
}
```

Suppose two threads execute:

```java
counter.increment();
```

1000 times each.

Expected:

```text
2000
```

But the actual result may be less than 2000.

Why?

Because:

```java
count++;
```

is not one indivisible operation.

Conceptually:

```text
READ
ADD
WRITE
```

Two threads can interfere with each other.

---

# 19. Critical Section

A **critical section** is code that accesses shared mutable data and must not be executed by multiple threads simultaneously.

Example:

```java
void increment() {
    count++;
}
```

The critical section must be protected.

---

# 20. `synchronized`

Java provides the `synchronized` keyword for mutual exclusion.

```java
class Counter {

    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
```

Now only one thread at a time can execute the synchronized method for the same object monitor.

---

# 21. Synchronized Block

Instead of synchronizing the entire method:

```java
synchronized (this) {
    count++;
}
```

Example:

```java
class Counter {

    private int count = 0;

    public void increment() {

        synchronized (this) {
            count++;
        }
    }
}
```

This can reduce the synchronized region.

---

# 22. Object Monitor

Every Java object has an associated monitor.

When a thread enters:

```java
synchronized (object) {
    // critical section
}
```

it attempts to acquire that object's monitor.

```text
Thread A
   |
   | acquire monitor
   v
[ Object Monitor ]
   |
   v
Critical Section
```

Another thread must wait until the monitor is released.

---

# 23. Synchronized Instance Method

```java
public synchronized void method() {
    // critical section
}
```

Equivalent conceptually to:

```java
public void method() {

    synchronized (this) {
        // critical section
    }
}
```

---

# 24. Static Synchronization

For a static synchronized method:

```java
public static synchronized void method() {
    // critical section
}
```

The lock is associated with the `Class` object.

Conceptually:

```java
synchronized (MyClass.class) {
    // critical section
}
```

---

# 25. Lock Object

Instead of locking on `this`, use a dedicated lock.

```java
class Counter {

    private int count = 0;

    private final Object lock = new Object();

    public void increment() {

        synchronized (lock) {
            count++;
        }
    }
}
```

This makes the locking policy explicit.

---

# 26. `volatile`

`volatile` ensures that reads and writes of a variable have the required visibility semantics across threads.

Example:

```java
class Worker {

    private volatile boolean running = true;

    void stop() {
        running = false;
    }

    void work() {

        while (running) {
            // work
        }
    }
}
```

Without appropriate synchronization/visibility, one thread may not observe another thread's update as intended.

### Important

`volatile` does **not** make compound operations atomic.

This is not safe merely because of `volatile`:

```java
volatile int count;

count++;
```

---

# 27. Atomicity, Visibility and Ordering

Three important concepts in concurrency:

### Atomicity

An operation happens as one indivisible unit.

### Visibility

One thread can observe changes made by another thread.

### Ordering

Operations appear in a valid ordering according to the Java Memory Model.

A correct concurrent program must reason about all three.

---

# 28. Atomic Classes

Java provides atomic classes in:

```java
java.util.concurrent.atomic
```

Examples:

```java
AtomicInteger
AtomicLong
AtomicBoolean
AtomicReference
```

Example:

```java
import java.util.concurrent.atomic.AtomicInteger;

class Counter {

    private final AtomicInteger count = new AtomicInteger();

    void increment() {
        count.incrementAndGet();
    }

    int getCount() {
        return count.get();
    }
}
```

---

# 29. Compare-And-Set

Atomic classes commonly use CAS:

**Compare-And-Set**

Concept:

```text
Read current value
      |
      v
Compare with expected value
      |
      +---- equal ----> update
      |
      +---- different -> retry/fail
```

Example:

```java
AtomicInteger number = new AtomicInteger(10);

boolean result = number.compareAndSet(10, 20);

System.out.println(result);
System.out.println(number.get());
```

---

# 30. Explicit Locks

Java provides:

```java
java.util.concurrent.locks
```

Important interfaces/classes:

```text
Lock
ReentrantLock
ReadWriteLock
ReentrantReadWriteLock
Condition
```

---

# 31. `ReentrantLock`

Example:

```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter {

    private int count = 0;

    private final Lock lock = new ReentrantLock();

    void increment() {

        lock.lock();

        try {
            count++;
        } finally {
            lock.unlock();
        }
    }
}
```

### Important Rule

Always unlock inside `finally`.

```java
lock.lock();

try {
    // critical section
} finally {
    lock.unlock();
}
```

---

# 32. `tryLock()`

`tryLock()` attempts to acquire a lock without waiting indefinitely.

```java
if (lock.tryLock()) {

    try {
        // critical section
    } finally {
        lock.unlock();
    }

} else {
    System.out.println("Could not acquire lock");
}
```

Useful for avoiding unnecessary waiting.

---

# 33. `ReadWriteLock`

Useful when:

* Reads are frequent
* Writes are relatively rare

```java
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class DataStore {

    private final ReadWriteLock lock =
            new ReentrantReadWriteLock();

    void read() {

        lock.readLock().lock();

        try {
            // read data
        } finally {
            lock.readLock().unlock();
        }
    }

    void write() {

        lock.writeLock().lock();

        try {
            // modify data
        } finally {
            lock.writeLock().unlock();
        }
    }
}
```

Multiple readers can execute concurrently.

Writes require exclusive access.

---

# 34. `wait()`, `notify()` and `notifyAll()`

These methods belong to `Object`.

```java
wait()
notify()
notifyAll()
```

They are used for thread coordination.

Example:

```java
synchronized (lock) {

    while (!condition) {
        lock.wait();
    }

    // continue
}
```

Another thread can signal:

```java
synchronized (lock) {
    condition = true;
    lock.notifyAll();
}
```

### Important

`wait()`, `notify()`, and `notifyAll()` must be called while owning the object's monitor.

---

# 35. Why Use `while` with `wait()`?

Correct:

```java
synchronized (lock) {

    while (!condition) {
        lock.wait();
    }

    // work
}
```

Avoid relying on:

```java
if (!condition) {
    lock.wait();
}
```

because threads can wake without the condition becoming true.

---

# 36. Producer-Consumer Problem

A classic concurrency problem.

```text
Producer
   |
   v
[ Shared Queue ]
   |
   v
Consumer
```

Producer adds data.

Consumer removes data.

Modern Java applications should generally prefer concurrent queues or blocking queues instead of manually implementing coordination with `wait()`/`notify()`.

---

# 37. `BlockingQueue`

Java provides:

```java
java.util.concurrent.BlockingQueue
```

Example:

```java
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

BlockingQueue<Integer> queue =
        new LinkedBlockingQueue<>(10);
```

Producer:

```java
queue.put(100);
```

Consumer:

```java
int value = queue.take();
```

`put()` waits when the queue is full.

`take()` waits when the queue is empty.

---

# 38. Executor Framework

Creating a new thread for every task is inefficient.

Instead, Java provides the Executor framework.

Package:

```java
java.util.concurrent
```

Important interfaces/classes:

```text
Executor
ExecutorService
ScheduledExecutorService
Future
Callable
CompletableFuture
ThreadPoolExecutor
Executors
```

---

# 39. Executor

Basic interface:

```java
Executor executor = command -> {
    new Thread(command).start();
};

executor.execute(() -> {
    System.out.println("Task");
});
```

---

# 40. ExecutorService

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

ExecutorService executor =
        Executors.newFixedThreadPool(4);

executor.execute(() -> {
    System.out.println("Task 1");
});

executor.execute(() -> {
    System.out.println("Task 2");
});

executor.shutdown();
```

The executor manages worker threads.

---

# 41. Thread Pool

A thread pool contains reusable worker threads.

```text
             Tasks
              |
     +--------+--------+
     |        |        |
     v        v        v
   Task 1   Task 2   Task 3
              |
              v
       [ Thread Pool ]
       |      |      |
       v      v      v
     T-1    T-2    T-3
```

Benefits:

* Reuse threads
* Reduce thread creation overhead
* Control concurrency
* Manage task execution

---

# 42. Types of Executor Pools

Common factory methods:

```java
Executors.newFixedThreadPool(n)
Executors.newSingleThreadExecutor()
Executors.newCachedThreadPool()
Executors.newScheduledThreadPool(n)
```

Modern production systems should choose executor configurations carefully rather than blindly using convenience factories.

---

# 43. `submit()`

`submit()` returns a `Future`.

```java
ExecutorService executor =
        Executors.newFixedThreadPool(2);

Future<?> future = executor.submit(() -> {
    System.out.println("Task");
});

executor.shutdown();
```

---

# 44. `Future`

A `Future` represents the result of an asynchronous computation.

```java
Future<Integer> future =
        executor.submit(() -> 100);
```

Get result:

```java
Integer result = future.get();

System.out.println(result);
```

`get()` may block until the result is available.

---

# 45. `Callable` with ExecutorService

```java
ExecutorService executor =
        Executors.newFixedThreadPool(2);

Callable<Integer> task = () -> {
    return 10 + 20;
};

Future<Integer> future = executor.submit(task);

try {
    System.out.println(future.get());
} catch (Exception e) {
    e.printStackTrace();
}

executor.shutdown();
```

---

# 46. Cancelling a Task

```java
future.cancel(true);
```

Check:

```java
future.isCancelled();
future.isDone();
```

Cancellation is cooperative.

A task should respond appropriately to interruption.

---

# 47. Interrupting Threads

Interrupting does not forcibly kill a thread.

```java
thread.interrupt();
```

A thread can check:

```java
Thread.currentThread().isInterrupted();
```

Example:

```java
while (!Thread.currentThread().isInterrupted()) {
    // work
}
```

If `sleep()`, `wait()`, or `join()` throws `InterruptedException`, restore the interrupt status when you cannot handle it fully:

```java
catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}
```

---

# 48. Deadlock

A deadlock occurs when threads wait forever for resources held by each other.

Example:

```text
Thread A
   |
   | holds Lock 1
   v
 waits for Lock 2
        ^
        |
Thread B
   |
   | holds Lock 2
   v
 waits for Lock 1
```

Neither thread can continue.

---

# 49. Deadlock Prevention

Common strategies:

* Always acquire locks in the same order
* Keep critical sections small
* Avoid unnecessary nested locks
* Use `tryLock()` with timeouts where appropriate
* Avoid holding locks while performing slow external operations

Consistent lock ordering is especially important.

---

# 50. Livelock

In livelock, threads are active but make no useful progress.

Example:

```text
Thread A reacts to Thread B
Thread B reacts to Thread A
Thread A reacts again
Thread B reacts again
...
```

Unlike deadlock:

```text
Deadlock -> threads are blocked
Livelock  -> threads are running but not progressing
```

---

# 51. Starvation

Starvation occurs when a thread continuously fails to obtain the resources or CPU time it needs.

Possible causes:

* Poor scheduling
* Unfair locking
* Long-running critical sections
* High-priority threads dominating resources

---

# 52. Semaphore

A `Semaphore` controls access to a limited number of permits.

Example:

```java
import java.util.concurrent.Semaphore;

Semaphore semaphore = new Semaphore(3);
```

Acquire:

```java
semaphore.acquire();
```

Release:

```java
semaphore.release();
```

Example use cases:

* Connection pools
* Limited resources
* Concurrent access limits

---

# 53. CountDownLatch

A `CountDownLatch` allows one or more threads to wait until a counter reaches zero.

```java
import java.util.concurrent.CountDownLatch;

CountDownLatch latch = new CountDownLatch(3);
```

Worker:

```java
latch.countDown();
```

Waiting thread:

```java
latch.await();
```

Concept:

```text
Initial count = 3

Task 1 -> countDown() -> 2
Task 2 -> countDown() -> 1
Task 3 -> countDown() -> 0

Waiting thread continues
```

A latch cannot normally be reset.

---

# 54. CyclicBarrier

A `CyclicBarrier` allows a group of threads to wait for each other at a common synchronization point.

```java
import java.util.concurrent.CyclicBarrier;

CyclicBarrier barrier =
        new CyclicBarrier(3);
```

Each participating thread:

```java
barrier.await();
```

Once all three arrive, they can continue.

Unlike `CountDownLatch`, a `CyclicBarrier` can be reused.

---

# 55. Phaser

`Phaser` provides more flexible synchronization for phased tasks.

It can be useful when:

* The number of participants changes
* Work happens in multiple phases
* Threads need to synchronize at different stages

Example:

```java
import java.util.concurrent.Phaser;

Phaser phaser = new Phaser(3);
```

---

# 56. Concurrent Collections

Java provides thread-safe collections under:

```java
java.util.concurrent
```

Important classes:

```text
ConcurrentHashMap
CopyOnWriteArrayList
CopyOnWriteArraySet
ConcurrentLinkedQueue
BlockingQueue
LinkedBlockingQueue
ArrayBlockingQueue
PriorityBlockingQueue
```

---

# 57. `ConcurrentHashMap`

Instead of manually synchronizing a normal `HashMap` in many concurrent scenarios:

```java
ConcurrentHashMap<String, Integer> map =
        new ConcurrentHashMap<>();
```

Example:

```java
map.put("Java", 1);

map.compute("Java", (key, value) -> value + 1);
```

It is designed for concurrent access.

---

# 58. `CopyOnWriteArrayList`

Useful when:

* Reads are frequent
* Writes are rare
* Iteration should not be disrupted by concurrent modifications

```java
CopyOnWriteArrayList<String> list =
        new CopyOnWriteArrayList<>();

list.add("Java");
list.add("Spring");
```

Writes are more expensive because the underlying array is copied.

---

# 59. Concurrent Queue

Example:

```java
ConcurrentLinkedQueue<Integer> queue =
        new ConcurrentLinkedQueue<>();

queue.offer(10);
queue.offer(20);

System.out.println(queue.poll());
```

---

# 60. Thread-Safe vs Synchronized Collections

Legacy synchronized collections include:

```java
Vector
Hashtable
Collections.synchronizedList(...)
```

Modern concurrent applications often prefer specialized concurrent collections such as:

```java
ConcurrentHashMap
CopyOnWriteArrayList
ConcurrentLinkedQueue
BlockingQueue
```

Choose according to the access pattern.

---

# 61. `ThreadLocal`

`ThreadLocal` provides a separate value for each thread.

```java
ThreadLocal<Integer> local =
        ThreadLocal.withInitial(() -> 0);
```

Example:

```java
local.set(100);

System.out.println(local.get());
```

Each thread gets its own value.

Useful for thread-confined state.

### Important

With pooled threads, remove values when appropriate:

```java
local.remove();
```

This helps prevent unintended retention of data between tasks.

---

# 62. Java Memory Model

The **Java Memory Model (JMM)** defines how threads interact through memory.

Important concepts:

* Shared memory
* Visibility
* Atomicity
* Ordering
* Happens-before relationship

The JMM is essential for understanding why apparently simple concurrent code can behave unexpectedly.

---

# 63. Happens-Before

The happens-before relationship establishes visibility and ordering guarantees between actions.

Examples include:

### Program Order

Within one thread:

```java
x = 10;
y = 20;
```

The first action happens-before the second.

### Monitor Unlock → Subsequent Lock

Unlocking a monitor happens-before a subsequent successful lock of the same monitor.

### Volatile Write → Subsequent Volatile Read

A write to a volatile variable happens-before a subsequent read of that same variable.

### Thread Start

Calling:

```java
thread.start();
```

establishes ordering between actions before the start and actions in the started thread.

### Thread Join

Actions in a thread happen-before another thread successfully returns from:

```java
thread.join();
```

---

# 64. Immutability and Concurrency

Immutable objects are naturally safer to share between threads.

Example:

```java
public final class User {

    private final String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
```

Characteristics:

* State cannot change after construction
* Fields are private and final
* No setters
* Class can be final
* Mutable internal state should not be exposed

Immutability reduces synchronization requirements.

---

# 65. Thread-Safe Design

A class is thread-safe when its behavior remains correct under concurrent access according to its contract.

Strategies:

1. Immutable objects
2. Synchronization
3. Explicit locks
4. Atomic variables
5. Thread confinement
6. Concurrent collections
7. Message passing
8. Proper task coordination

---

# 66. CompletableFuture

`CompletableFuture` supports asynchronous programming and composition.

Example:

```java
import java.util.concurrent.CompletableFuture;

CompletableFuture<Integer> future =
        CompletableFuture.supplyAsync(() -> 100);

future.thenAccept(result -> {
    System.out.println(result);
});
```

---

# 67. `thenApply()`

Transforms the result.

```java
CompletableFuture<Integer> future =
        CompletableFuture.supplyAsync(() -> 10);

CompletableFuture<Integer> result =
        future.thenApply(value -> value * 2);
```

Concept:

```text
10
 |
 v
*2
 |
 v
20
```

---

# 68. `thenAccept()`

Consumes the result without producing another result.

```java
future.thenAccept(value -> {
    System.out.println(value);
});
```

---

# 69. `thenCompose()`

Used when an asynchronous operation produces another `CompletableFuture`.

```java
future.thenCompose(value ->
        CompletableFuture.supplyAsync(() -> value * 2)
);
```

Useful for sequential asynchronous workflows.

---

# 70. `thenCombine()`

Combines independent asynchronous operations.

```java
CompletableFuture<Integer> first =
        CompletableFuture.supplyAsync(() -> 10);

CompletableFuture<Integer> second =
        CompletableFuture.supplyAsync(() -> 20);

CompletableFuture<Integer> result =
        first.thenCombine(second, Integer::sum);
```

Result:

```text
30
```

---

# 71. Exception Handling with CompletableFuture

```java
CompletableFuture.supplyAsync(() -> {
    throw new RuntimeException("Error");
})
.exceptionally(error -> {
    System.out.println(error.getMessage());
    return 0;
});
```

Another option:

```java
future.handle((result, error) -> {
    if (error != null) {
        return 0;
    }

    return result;
});
```

---

# 72. Fork/Join Framework

The Fork/Join framework is designed for divide-and-conquer parallelism.

Package:

```java
java.util.concurrent
```

Important classes:

```text
ForkJoinPool
RecursiveTask
RecursiveAction
```

Concept:

```text
             Problem
                |
        +-------+-------+
        |               |
     Subproblem       Subproblem
        |               |
     +--+--+         +--+--+
     |     |         |     |
   Task  Task      Task  Task
     \     /         \     /
      \   /           \   /
       Result         Result
          \           /
           \         /
             Combine
```

---

# 73. RecursiveTask

Returns a result.

```java
import java.util.concurrent.RecursiveTask;

class SumTask extends RecursiveTask<Integer> {

    @Override
    protected Integer compute() {
        return 100;
    }
}
```

---

# 74. RecursiveAction

Does not return a result.

```java
import java.util.concurrent.RecursiveAction;

class MyTask extends RecursiveAction {

    @Override
    protected void compute() {
        System.out.println("Executing task");
    }
}
```

---

# 75. Virtual Threads

Modern Java provides **virtual threads** for high-throughput concurrent applications, especially when there are many tasks that spend time waiting on I/O.

Example:

```java
Thread.startVirtualThread(() -> {
    System.out.println("Virtual thread");
});
```

Or with an executor:

```java
try (var executor =
         java.util.concurrent.Executors.newVirtualThreadPerTaskExecutor()) {

    executor.submit(() -> {
        System.out.println("Task");
    });
}
```

Virtual threads are lightweight threads managed by the JVM rather than mapping every application thread directly to a dedicated OS thread.

They are particularly useful for blocking I/O workloads.

They are not a replacement for CPU parallelism.

---

# 76. Platform Threads vs Virtual Threads

| Platform Thread                           | Virtual Thread                     |
| ----------------------------------------- | ---------------------------------- |
| More expensive                            | Very lightweight                   |
| Typically maps to OS scheduling resources | Managed by JVM                     |
| Suitable for many workloads               | Excellent for high-concurrency I/O |
| Limited practical quantity                | Can create very large numbers      |
| More resource intensive                   | Lower per-thread overhead          |

---

# 77. Structured Concurrency

Structured concurrency treats related concurrent tasks as a single logical unit.

The goal is to make:

* Task lifetime easier to understand
* Cancellation easier
* Error handling more predictable
* Parent-child task relationships explicit

Modern Java provides structured concurrency APIs as part of its evolving concurrency model. Check the Java version and API status before relying on preview/incubator features in production.

---

# 78. Common Concurrency Problems

### Race Condition

Multiple threads access shared mutable state incorrectly.

### Deadlock

Threads wait forever for each other's locks.

### Livelock

Threads continuously react but make no progress.

### Starvation

A thread cannot obtain required resources.

### Visibility Problem

One thread does not correctly observe another thread's update.

### Atomicity Problem

A compound operation is interrupted by concurrent access.

---

# 79. Best Practices

### 1. Prefer Immutability

```java
final class User {
    private final String name;
}
```

### 2. Minimize Shared Mutable State

Less shared state means fewer synchronization problems.

### 3. Prefer High-Level Concurrency Utilities

Prefer:

```text
ExecutorService
CompletableFuture
BlockingQueue
ConcurrentHashMap
AtomicInteger
Semaphore
CountDownLatch
```

when they fit the problem.

### 4. Keep Critical Sections Small

Avoid:

```java
synchronized (lock) {
    // database call
    // network call
    // file operation
}
```

Long operations while holding locks can reduce throughput and increase deadlock risk.

### 5. Always Release Explicit Locks

```java
lock.lock();

try {
    // work
} finally {
    lock.unlock();
}
```

### 6. Handle Interruption Correctly

```java
catch (InterruptedException e) {
    Thread.currentThread().interrupt();
}
```

### 7. Do Not Depend on Thread Scheduling

Avoid logic that assumes:

```text
Thread A will always execute before Thread B
```

unless synchronization explicitly establishes that relationship.

---

# 80. `synchronized` vs `Lock`

| Feature                        | `synchronized` | `Lock`               |
| ------------------------------ | -------------- | -------------------- |
| Easy to use                    | Yes            | More verbose         |
| Automatic unlock               | Yes            | No                   |
| `tryLock()`                    | No             | Yes                  |
| Interruptible lock acquisition | Limited        | Yes                  |
| Multiple conditions            | No             | Yes with `Condition` |
| Best for simple locking        | Yes            | Not always necessary |
| Advanced control               | Limited        | High                 |

Use `synchronized` when it is sufficient.

Use `Lock` when you need advanced features.

---

# 81. `volatile` vs `synchronized`

| `volatile`                         | `synchronized`                         |
| ---------------------------------- | -------------------------------------- |
| Provides visibility guarantees     | Provides visibility + mutual exclusion |
| Does not provide general atomicity | Protects critical sections             |
| No locking                         | Uses monitor locking                   |
| Good for simple state flags        | Good for compound operations           |

Example where `volatile` can be appropriate:

```java
private volatile boolean running;
```

Example requiring stronger synchronization:

```java
count++;
```

---

# 82. AtomicInteger vs synchronized

Using `AtomicInteger`:

```java
AtomicInteger counter = new AtomicInteger();

counter.incrementAndGet();
```

Using synchronization:

```java
synchronized (lock) {
    counter++;
}
```

For simple atomic numeric operations, atomic classes are often a good fit.

For multiple related state changes that must happen together, locking may be more appropriate.

---

# 83. Practical Example: Thread-Safe Counter

```java
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

    private final AtomicInteger count = new AtomicInteger();

    public void increment() {
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }
}
```

Usage:

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args)
            throws InterruptedException {

        Counter counter = new Counter();

        ExecutorService executor =
                Executors.newFixedThreadPool(4);

        for (int i = 0; i < 1000; i++) {
            executor.submit(counter::increment);
        }

        executor.shutdown();

        while (!executor.isTerminated()) {
            Thread.sleep(10);
        }

        System.out.println(counter.getCount());
    }
}
```

Expected:

```text
1000
```

---

# 84. Practical Example: Producer-Consumer

```java
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer {

    public static void main(String[] args) {

        BlockingQueue<Integer> queue =
                new LinkedBlockingQueue<>(10);

        Thread producer = new Thread(() -> {

            try {
                for (int i = 1; i <= 10; i++) {
                    queue.put(i);
                    System.out.println("Produced: " + i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {

            try {
                for (int i = 1; i <= 10; i++) {
                    int value = queue.take();
                    System.out.println("Consumed: " + value);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
```

---

# 85. Practical Example: CompletableFuture

```java
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {

        CompletableFuture<Integer> future =
                CompletableFuture
                        .supplyAsync(() -> 10)
                        .thenApply(value -> value * 2)
                        .thenApply(value -> value + 5);

        future.thenAccept(result ->
                System.out.println("Result: " + result)
        );
    }
}
```

Result:

```text
25
```

---

# 86. Multi-Threading Interview Questions

## Beginner

1. What is a thread?
2. What is the difference between process and thread?
3. How can you create a thread in Java?
4. What is the difference between `start()` and `run()`?
5. What is `Runnable`?
6. What is `Callable`?
7. What is `sleep()`?
8. What is `join()`?
9. What is a daemon thread?
10. What are thread states?

## Intermediate

11. What is a race condition?
12. What is synchronization?
13. What is `synchronized`?
14. What is a monitor?
15. What is `volatile`?
16. What is an atomic operation?
17. What is `AtomicInteger`?
18. What is `ExecutorService`?
19. What is a thread pool?
20. What is `Future`?

## Advanced

21. What is the Java Memory Model?
22. What is happens-before?
23. What is deadlock?
24. What is livelock?
25. What is starvation?
26. Difference between `synchronized` and `ReentrantLock`.
27. Difference between `volatile` and `AtomicInteger`.
28. How does `ConcurrentHashMap` support concurrent access?
29. What is `ForkJoinPool`?
30. What is `CompletableFuture`?
31. What is CAS?
32. What is false sharing?
33. What is lock contention?
34. What is thread confinement?
35. What are virtual threads?
36. When should virtual threads be used?
37. What is structured concurrency?
38. How does interruption work?
39. How can deadlocks be prevented?
40. How do you design a thread-safe class?

---

# 87. Important Java Concurrency Packages

```text
java.lang
    Thread
    Runnable

java.util.concurrent
    Executor
    ExecutorService
    Future
    Callable
    CompletableFuture
    Semaphore
    CountDownLatch
    CyclicBarrier
    Phaser
    BlockingQueue
    ConcurrentHashMap

java.util.concurrent.atomic
    AtomicInteger
    AtomicLong
    AtomicBoolean
    AtomicReference

java.util.concurrent.locks
    Lock
    ReentrantLock
    ReadWriteLock
    ReentrantReadWriteLock
    Condition
```

---

# 88. Quick Revision

```text
Thread
  |
  +-- start()
  +-- run()
  +-- sleep()
  +-- join()
  +-- interrupt()
  +-- isAlive()

Synchronization
  |
  +-- synchronized
  +-- volatile
  +-- Atomic classes
  +-- Lock
  +-- ReentrantLock

Coordination
  |
  +-- wait()
  +-- notify()
  +-- notifyAll()
  +-- CountDownLatch
  +-- CyclicBarrier
  +-- Phaser
  +-- Semaphore

Executors
  |
  +-- Executor
  +-- ExecutorService
  +-- ScheduledExecutorService
  +-- Future
  +-- Callable
  +-- CompletableFuture

Concurrent Collections
  |
  +-- ConcurrentHashMap
  +-- BlockingQueue
  +-- ConcurrentLinkedQueue
  +-- CopyOnWriteArrayList

Advanced
  |
  +-- Java Memory Model
  +-- Happens-Before
  +-- CAS
  +-- Fork/Join
  +-- Virtual Threads
  +-- Structured Concurrency
```

---

# 89. Recommended Learning Order

Study this chapter in the following order:

```text
1. Process vs Thread
2. Creating Threads
3. Runnable
4. Callable
5. Thread Lifecycle
6. Thread Methods
7. sleep()
8. join()
9. Interrupts
10. Daemon Threads
11. Race Conditions
12. Critical Sections
13. synchronized
14. Object Monitors
15. volatile
16. Atomic Classes
17. Lock / ReentrantLock
18. wait / notify / notifyAll
19. Executor Framework
20. Thread Pools
21. Future / Callable
22. Concurrent Collections
23. BlockingQueue
24. Semaphore
25. CountDownLatch
26. CyclicBarrier
27. ThreadLocal
28. Java Memory Model
29. Happens-Before
30. CompletableFuture
31. Fork/Join
32. Deadlock / Livelock / Starvation
33. Virtual Threads
34. Structured Concurrency
35. Thread-Safe Design
```

---

# 90. Final Takeaway

Java concurrency is not simply about creating multiple threads.

The important concepts are:

```text
Threads
   ↓
Shared State
   ↓
Race Conditions
   ↓
Synchronization
   ↓
Visibility + Atomicity + Ordering
   ↓
Locks / Atomic Variables
   ↓
Thread Coordination
   ↓
Executors
   ↓
Concurrent Collections
   ↓
CompletableFuture
   ↓
Fork/Join
   ↓
Virtual Threads
   ↓
Safe Concurrent System Design
```

The most important rule is:

> **Minimize shared mutable state, prefer high-level concurrency utilities, and design thread interaction explicitly rather than relying on timing or thread scheduling.**
