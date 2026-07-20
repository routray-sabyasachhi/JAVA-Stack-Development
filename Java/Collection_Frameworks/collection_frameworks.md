# Java Collection Framework

The Java Collection Framework is a group of interfaces, classes, and algorithms used to store, access, search, sort, and manipulate groups of objects. It is mainly available in the `java.util` package.

## Why Collections Are Needed

Arrays are fixed in size and provide limited built-in operations. Collections solve these problems by giving:

- Dynamic resizing
- Ready-made data structures
- Searching, sorting, insertion, deletion, and traversal APIs
- Type safety with generics
- Reusable algorithms through the `Collections` utility class
- Specialized implementations for ordering, uniqueness, concurrency, and performance

## Collection Framework Hierarchy

```text
Iterable
+-- Collection
    +-- List
    |   +-- ArrayList
    |   +-- LinkedList
    |   +-- Vector
    |   +-- Stack
    +-- Set
    |   +-- HashSet
    |   +-- LinkedHashSet
    |   +-- SortedSet
    |       +-- NavigableSet
    |           +-- TreeSet
    +-- Queue
        +-- PriorityQueue
        +-- Deque
            +-- ArrayDeque
            +-- LinkedList

Map
+-- HashMap
+-- LinkedHashMap
+-- SortedMap
|   +-- NavigableMap
|       +-- TreeMap
+-- Hashtable
+-- WeakHashMap
+-- IdentityHashMap
+-- EnumMap
+-- ConcurrentHashMap
```

Important point: `Map` is part of the Collection Framework, but it does not extend the `Collection` interface.

## Main Interfaces

| Interface | Description |
|---|---|
| `Iterable<E>` | Root interface that allows enhanced for-loop traversal. |
| `Collection<E>` | Root interface for most collection types. |
| `List<E>` | Ordered collection that allows duplicates and index-based access. |
| `Set<E>` | Collection that does not allow duplicate elements. |
| `SortedSet<E>` | Set that keeps elements sorted. |
| `NavigableSet<E>` | SortedSet with navigation methods like `lower`, `floor`, `ceiling`, and `higher`. |
| `Queue<E>` | Collection designed for holding elements before processing. |
| `Deque<E>` | Double-ended queue; supports insertion/removal at both ends. |
| `Map<K,V>` | Key-value pair structure; keys are unique. |
| `SortedMap<K,V>` | Map that keeps keys sorted. |
| `NavigableMap<K,V>` | SortedMap with navigation methods. |

## List Interface

`List` stores elements in insertion order and allows duplicates.

Common methods:

```java
List<String> names = new ArrayList<>();
names.add("Amit");
names.add("Neha");
names.add("Amit");

System.out.println(names.get(0));      // Amit
names.set(1, "Riya");
names.remove("Amit");                  // removes first Amit
System.out.println(names.size());
```

### ArrayList

`ArrayList` is backed by a dynamic array.

Features:

- Maintains insertion order
- Allows duplicates
- Allows `null`
- Fast random access using index
- Slower insertion/deletion in the middle because shifting is required
- Not synchronized

Best use:

- Frequent read/access operations
- When insertion/deletion mostly happens at the end

```java
ArrayList<Integer> numbers = new ArrayList<>();
numbers.add(10);
numbers.add(20);
numbers.add(1, 15);
System.out.println(numbers); // [10, 15, 20]
```

### LinkedList

`LinkedList` is implemented as a doubly linked list. It implements both `List` and `Deque`.

Features:

- Maintains insertion order
- Allows duplicates and `null`
- Faster insertion/deletion at beginning or middle when node position is known
- Slower random access than `ArrayList`
- Can be used as list, queue, or deque

```java
LinkedList<String> list = new LinkedList<>();
list.add("Java");
list.addFirst("Core");
list.addLast("Spring");
System.out.println(list); // [Core, Java, Spring]
```

### Vector

`Vector` is similar to `ArrayList`, but synchronized.

Features:

- Thread-safe for individual operations
- Slower than `ArrayList` in single-threaded code
- Legacy class

Modern preference: use `ArrayList` for normal code, or proper concurrent collections when thread safety is required.

### Stack

`Stack` is a legacy LIFO structure that extends `Vector`.

```java
Stack<Integer> stack = new Stack<>();
stack.push(10);
stack.push(20);
System.out.println(stack.pop());  // 20
System.out.println(stack.peek()); // 10
```

Modern preference: use `ArrayDeque` for stack behavior.

```java
Deque<Integer> stack = new ArrayDeque<>();
stack.push(10);
stack.push(20);
System.out.println(stack.pop());
```

## Set Interface

`Set` does not allow duplicate elements.

```java
Set<String> cities = new HashSet<>();
cities.add("Delhi");
cities.add("Mumbai");
cities.add("Delhi");
System.out.println(cities.size()); // 2
```

### HashSet

`HashSet` is backed by a hash table.

Features:

- Does not allow duplicates
- Allows one `null`
- Does not guarantee order
- Fast add, remove, and search on average
- Uses `hashCode()` and `equals()` to detect duplicates

```java
Set<Integer> set = new HashSet<>();
set.add(30);
set.add(10);
set.add(20);
System.out.println(set); // order not guaranteed
```

### LinkedHashSet

`LinkedHashSet` maintains insertion order.

Features:

- No duplicates
- Allows one `null`
- Predictable iteration order
- Slightly slower than `HashSet` because it maintains linked order

```java
Set<String> set = new LinkedHashSet<>();
set.add("B");
set.add("A");
set.add("C");
System.out.println(set); // [B, A, C]
```

### TreeSet

`TreeSet` stores elements in sorted order using a red-black tree.

Features:

- No duplicates
- Sorted natural order by default
- Can use custom `Comparator`
- Does not allow `null` in modern Java when natural ordering is used
- Slower than `HashSet`, but keeps data sorted

```java
Set<Integer> set = new TreeSet<>();
set.add(30);
set.add(10);
set.add(20);
System.out.println(set); // [10, 20, 30]
```

Custom sorting:

```java
Set<String> names = new TreeSet<>(Comparator.reverseOrder());
names.add("Amit");
names.add("Neha");
names.add("Riya");
System.out.println(names); // [Riya, Neha, Amit]
```

## Queue Interface

`Queue` is used for processing elements, usually in FIFO order.

Common methods:

| Operation | Throws exception | Returns special value |
|---|---|---|
| Insert | `add(e)` | `offer(e)` |
| Remove | `remove()` | `poll()` |
| Examine | `element()` | `peek()` |

```java
Queue<String> queue = new LinkedList<>();
queue.offer("Task1");
queue.offer("Task2");

System.out.println(queue.poll()); // Task1
System.out.println(queue.peek()); // Task2
```

### PriorityQueue

`PriorityQueue` processes elements according to priority, not insertion order.

Features:

- Default priority is natural ordering
- Custom priority can be defined using `Comparator`
- Does not allow `null`
- Not thread-safe

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.offer(40);
pq.offer(10);
pq.offer(30);

System.out.println(pq.poll()); // 10
```

Max heap style:

```java
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
maxHeap.offer(40);
maxHeap.offer(10);
maxHeap.offer(30);

System.out.println(maxHeap.poll()); // 40
```

## Deque Interface

`Deque` means double-ended queue. It supports insertion and removal from both ends.

```java
Deque<String> deque = new ArrayDeque<>();
deque.addFirst("A");
deque.addLast("B");
deque.addFirst("C");

System.out.println(deque.removeFirst()); // C
System.out.println(deque.removeLast());  // B
```

### ArrayDeque

`ArrayDeque` is usually preferred over `Stack` and `LinkedList` for stack or queue behavior.

Features:

- Resizable array implementation
- Faster than `Stack`
- Faster than `LinkedList` for most queue/deque operations
- Does not allow `null`
- Not synchronized

## Map Interface

`Map` stores data in key-value pairs. Keys must be unique, but values can be duplicate.

```java
Map<Integer, String> students = new HashMap<>();
students.put(1, "Amit");
students.put(2, "Neha");
students.put(1, "Riya");

System.out.println(students.get(1)); // Riya
```

Common methods:

| Method | Use |
|---|---|
| `put(key, value)` | Adds or updates an entry. |
| `get(key)` | Gets value by key. |
| `remove(key)` | Removes entry by key. |
| `containsKey(key)` | Checks if key exists. |
| `containsValue(value)` | Checks if value exists. |
| `keySet()` | Returns all keys. |
| `values()` | Returns all values. |
| `entrySet()` | Returns key-value pairs. |
| `getOrDefault(key, defaultValue)` | Returns value or default. |
| `putIfAbsent(key, value)` | Adds only if key is absent. |
| `computeIfAbsent(key, function)` | Computes and stores value if key is absent. |
| `merge(key, value, function)` | Combines old and new values. |

### HashMap

`HashMap` is the most commonly used map.

Features:

- Allows one `null` key
- Allows multiple `null` values
- Does not guarantee order
- Fast average lookup, insertion, and deletion
- Uses `hashCode()` and `equals()` for keys
- Not synchronized

```java
Map<String, Integer> marks = new HashMap<>();
marks.put("Math", 90);
marks.put("Science", 85);

for (Map.Entry<String, Integer> entry : marks.entrySet()) {
    System.out.println(entry.getKey() + " = " + entry.getValue());
}
```

### LinkedHashMap

`LinkedHashMap` maintains insertion order.

```java
Map<Integer, String> map = new LinkedHashMap<>();
map.put(3, "C");
map.put(1, "A");
map.put(2, "B");
System.out.println(map); // {3=C, 1=A, 2=B}
```

It can also maintain access order, useful for LRU cache logic.

```java
Map<Integer, String> cache = new LinkedHashMap<>(16, 0.75f, true);
cache.put(1, "A");
cache.put(2, "B");
cache.get(1);
System.out.println(cache); // {2=B, 1=A}
```

### TreeMap

`TreeMap` stores keys in sorted order.

Features:

- Sorted by natural ordering or custom `Comparator`
- Does not allow `null` key with natural ordering
- Allows multiple `null` values
- Slower than `HashMap`, but keeps keys sorted

```java
Map<Integer, String> map = new TreeMap<>();
map.put(3, "C");
map.put(1, "A");
map.put(2, "B");
System.out.println(map); // {1=A, 2=B, 3=C}
```

### Hashtable

`Hashtable` is a legacy synchronized map.

Features:

- Thread-safe for individual operations
- Does not allow `null` key or `null` value
- Slower than `HashMap`
- Legacy class

Modern preference: use `ConcurrentHashMap` for concurrent code.

### ConcurrentHashMap

`ConcurrentHashMap` is designed for high-performance concurrent access.

Features:

- Thread-safe
- Does not lock the entire map for most operations
- Does not allow `null` keys or `null` values
- Preferred over `Hashtable` in concurrent applications

```java
Map<String, Integer> map = new ConcurrentHashMap<>();
map.put("A", 10);
map.put("B", 20);
```

### WeakHashMap

`WeakHashMap` stores keys as weak references. If a key is no longer strongly referenced elsewhere, it can be removed by garbage collection.

Common use:

- Cache-like structures where entries should disappear when keys are no longer used

### IdentityHashMap

`IdentityHashMap` compares keys using `==` instead of `equals()`.

Common use:

- Special identity-based algorithms
- Object graph processing

It is not a general replacement for `HashMap`.

### EnumMap

`EnumMap` is a specialized map for enum keys.

Features:

- Very fast and memory efficient
- Maintains enum declaration order
- Does not allow `null` keys

```java
enum Day { MON, TUE, WED }

Map<Day, String> tasks = new EnumMap<>(Day.class);
tasks.put(Day.MON, "Study Java");
tasks.put(Day.TUE, "Practice SQL");
```

## Comparable and Comparator

### Comparable

Use `Comparable` when the class has a natural/default ordering.

```java
class Student implements Comparable<Student> {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.id, other.id);
    }
}
```

### Comparator

Use `Comparator` when you want external or multiple sorting rules.

```java
List<Student> students = new ArrayList<>();

students.sort(Comparator.comparing(s -> s.name));
students.sort(Comparator.comparingInt(s -> s.id));
students.sort(Comparator.comparing((Student s) -> s.name).reversed());
```

Multiple fields:

```java
students.sort(
    Comparator.comparing((Student s) -> s.name)
              .thenComparingInt(s -> s.id)
);
```

## Sorting Collections

```java
List<Integer> numbers = new ArrayList<>(List.of(30, 10, 20));

Collections.sort(numbers);
System.out.println(numbers); // [10, 20, 30]

numbers.sort(Comparator.reverseOrder());
System.out.println(numbers); // [30, 20, 10]
```

Sorting objects:

```java
class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}

List<Employee> employees = new ArrayList<>();
employees.add(new Employee(1, "Amit", 50000));
employees.add(new Employee(2, "Neha", 70000));

employees.sort(Comparator.comparingDouble(e -> e.salary));
```

## Iterating Collections

### Enhanced for-loop

```java
for (String name : names) {
    System.out.println(name);
}
```

### Iterator

Use `Iterator` when removing elements during traversal.

```java
Iterator<String> iterator = names.iterator();

while (iterator.hasNext()) {
    String name = iterator.next();
    if (name.startsWith("A")) {
        iterator.remove();
    }
}
```

### ListIterator

`ListIterator` works only with lists and supports forward/backward traversal.

```java
ListIterator<String> it = names.listIterator();

while (it.hasNext()) {
    System.out.println(it.next());
}

while (it.hasPrevious()) {
    System.out.println(it.previous());
}
```

### forEach

```java
names.forEach(System.out::println);
```

## Collections Utility Class

`Collections` contains static helper methods.

```java
List<Integer> list = new ArrayList<>(List.of(5, 2, 9, 1));

Collections.sort(list);
Collections.reverse(list);
Collections.shuffle(list);
Collections.swap(list, 0, 1);

int max = Collections.max(list);
int min = Collections.min(list);
int frequency = Collections.frequency(list, 5);
```

Important methods:

| Method | Use |
|---|---|
| `sort(list)` | Sorts list in natural order. |
| `sort(list, comparator)` | Sorts using custom comparator. |
| `reverse(list)` | Reverses list. |
| `shuffle(list)` | Randomly shuffles list. |
| `binarySearch(list, key)` | Searches sorted list. |
| `max(collection)` | Finds maximum element. |
| `min(collection)` | Finds minimum element. |
| `frequency(collection, element)` | Counts occurrences. |
| `disjoint(c1, c2)` | Checks whether two collections have no common elements. |
| `synchronizedList(list)` | Returns synchronized wrapper. |
| `unmodifiableList(list)` | Returns read-only wrapper. |

## Collection Factory Methods

Java 9 introduced convenient factory methods.

```java
List<String> list = List.of("A", "B", "C");
Set<Integer> set = Set.of(1, 2, 3);
Map<Integer, String> map = Map.of(1, "A", 2, "B");
```

Notes:

- These collections are unmodifiable.
- They do not allow `null`.
- `Set.of` and `Map.of` do not allow duplicates.

For many map entries:

```java
Map<Integer, String> map = Map.ofEntries(
    Map.entry(1, "A"),
    Map.entry(2, "B"),
    Map.entry(3, "C")
);
```

## Generics in Collections

Generics provide compile-time type safety.

```java
List<String> names = new ArrayList<>();
names.add("Amit");
// names.add(10); // compile-time error
```

Without generics, casting is required and runtime errors are more likely.

```java
List rawList = new ArrayList();
rawList.add("Java");
rawList.add(100);
```

### Wildcards

`? extends T` means you can read items as type `T`, but adding is restricted.

```java
public static double sum(List<? extends Number> numbers) {
    double total = 0;
    for (Number number : numbers) {
        total += number.doubleValue();
    }
    return total;
}
```

`? super T` means you can add `T` values, but reading gives `Object`.

```java
public static void addIntegers(List<? super Integer> list) {
    list.add(10);
    list.add(20);
}
```

Memory rule: PECS means Producer Extends, Consumer Super.

## equals() and hashCode()

Hash-based collections depend on `equals()` and `hashCode()`.

Rules:

- If two objects are equal using `equals()`, they must have the same `hashCode()`.
- If two objects have the same `hashCode()`, they may or may not be equal.
- Objects used as keys in `HashMap` or elements in `HashSet` should usually be immutable.

Example:

```java
class Product {
    private final int id;
    private final String name;

    Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Product other)) return false;
        return id == other.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
```

## Fail-Fast and Fail-Safe Iterators

Fail-fast iterators throw `ConcurrentModificationException` if a collection is structurally modified outside the iterator during traversal.

```java
List<Integer> list = new ArrayList<>(List.of(1, 2, 3));

for (Integer number : list) {
    if (number == 2) {
        list.remove(number); // may throw ConcurrentModificationException
    }
}
```

Correct way:

```java
Iterator<Integer> it = list.iterator();

while (it.hasNext()) {
    if (it.next() == 2) {
        it.remove();
    }
}
```

Fail-safe style iterators work on a copy or weakly consistent view. Examples include `CopyOnWriteArrayList` and `ConcurrentHashMap`.

## Thread-Safe Collections

Common options:

| Collection | Thread-safe option |
|---|---|
| `ArrayList` | `CopyOnWriteArrayList`, `Collections.synchronizedList(...)` |
| `HashSet` | `ConcurrentHashMap.newKeySet()`, `Collections.synchronizedSet(...)` |
| `HashMap` | `ConcurrentHashMap`, `Collections.synchronizedMap(...)` |
| `Queue` | `ConcurrentLinkedQueue`, `BlockingQueue` implementations |
| `Deque` | `ConcurrentLinkedDeque`, `BlockingDeque` implementations |

### CopyOnWriteArrayList

Good when reads are very frequent and writes are rare.

```java
List<String> list = new CopyOnWriteArrayList<>();
list.add("A");
list.add("B");
```

### BlockingQueue

Used in producer-consumer problems.

```java
BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

queue.put(10);       // waits if full
Integer value = queue.take(); // waits if empty
```

Common implementations:

- `ArrayBlockingQueue`
- `LinkedBlockingQueue`
- `PriorityBlockingQueue`
- `DelayQueue`
- `SynchronousQueue`

## Time Complexity

Average/common complexity:

| Collection | Add | Remove | Search/Get | Notes |
|---|---:|---:|---:|---|
| `ArrayList` | O(1) amortized | O(n) | O(1) by index, O(n) by value | Best for random access. |
| `LinkedList` | O(1) at ends | O(1) at ends, O(n) search | O(n) | Good as deque, not ideal for random access. |
| `HashSet` | O(1) | O(1) | O(1) | No ordering guarantee. |
| `LinkedHashSet` | O(1) | O(1) | O(1) | Maintains insertion order. |
| `TreeSet` | O(log n) | O(log n) | O(log n) | Sorted. |
| `HashMap` | O(1) | O(1) | O(1) | Key lookup is fast on average. |
| `LinkedHashMap` | O(1) | O(1) | O(1) | Maintains insertion/access order. |
| `TreeMap` | O(log n) | O(log n) | O(log n) | Sorted by key. |
| `PriorityQueue` | O(log n) | O(log n) poll | O(n) contains | Priority-based removal. |

Worst case for hash-based structures can degrade, but modern Java improves heavily-collided buckets by treeifying them when possible.

## Null Handling

| Collection | Null support |
|---|---|
| `ArrayList` | Allows multiple `null` values |
| `LinkedList` | Allows multiple `null` values |
| `HashSet` | Allows one `null` |
| `LinkedHashSet` | Allows one `null` |
| `TreeSet` | Usually does not allow `null` |
| `PriorityQueue` | Does not allow `null` |
| `ArrayDeque` | Does not allow `null` |
| `HashMap` | Allows one `null` key and multiple `null` values |
| `LinkedHashMap` | Allows one `null` key and multiple `null` values |
| `TreeMap` | Usually does not allow `null` key |
| `Hashtable` | Does not allow `null` key or value |
| `ConcurrentHashMap` | Does not allow `null` key or value |

## Choosing the Right Collection

| Need | Use |
|---|---|
| Fast random access | `ArrayList` |
| Frequent add/remove at both ends | `ArrayDeque` |
| Stack behavior | `ArrayDeque` |
| Queue behavior | `ArrayDeque` or `LinkedList` |
| Unique elements, no order needed | `HashSet` |
| Unique elements, insertion order needed | `LinkedHashSet` |
| Unique elements, sorted order needed | `TreeSet` |
| Key-value lookup, no order needed | `HashMap` |
| Key-value lookup with insertion order | `LinkedHashMap` |
| Key-value lookup with sorted keys | `TreeMap` |
| Thread-safe high-performance map | `ConcurrentHashMap` |
| Producer-consumer queue | `BlockingQueue` |
| Priority-based processing | `PriorityQueue` |
| Enum keys | `EnumMap` |

## Common Programs

### Remove Duplicates From a List

```java
List<Integer> list = List.of(1, 2, 2, 3, 3, 4);
Set<Integer> unique = new LinkedHashSet<>(list);
System.out.println(unique); // [1, 2, 3, 4]
```

### Count Word Frequency

```java
String text = "java spring java sql";
Map<String, Integer> frequency = new HashMap<>();

for (String word : text.split(" ")) {
    frequency.put(word, frequency.getOrDefault(word, 0) + 1);
}

System.out.println(frequency);
```

Using `merge`:

```java
for (String word : text.split(" ")) {
    frequency.merge(word, 1, Integer::sum);
}
```

### Sort Map by Values

```java
Map<String, Integer> marks = new HashMap<>();
marks.put("Amit", 80);
marks.put("Neha", 95);
marks.put("Riya", 90);

List<Map.Entry<String, Integer>> entries = new ArrayList<>(marks.entrySet());
entries.sort(Map.Entry.comparingByValue());

for (Map.Entry<String, Integer> entry : entries) {
    System.out.println(entry.getKey() + " = " + entry.getValue());
}
```

### Find First Non-Repeating Character

```java
String input = "swiss";
Map<Character, Integer> count = new LinkedHashMap<>();

for (char ch : input.toCharArray()) {
    count.put(ch, count.getOrDefault(ch, 0) + 1);
}

for (Map.Entry<Character, Integer> entry : count.entrySet()) {
    if (entry.getValue() == 1) {
        System.out.println(entry.getKey());
        break;
    }
}
```

### Group Items

```java
Map<String, List<String>> groups = new HashMap<>();

groups.computeIfAbsent("backend", key -> new ArrayList<>()).add("Java");
groups.computeIfAbsent("backend", key -> new ArrayList<>()).add("Spring");
groups.computeIfAbsent("database", key -> new ArrayList<>()).add("MySQL");

System.out.println(groups);
```

## Streams With Collections

Streams are not collections, but they work very closely with collections.

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5);

List<Integer> evenNumbers = numbers.stream()
    .filter(n -> n % 2 == 0)
    .toList();

int sum = numbers.stream()
    .mapToInt(Integer::intValue)
    .sum();
```

Collecting into collections:

```java
List<String> names = List.of("Amit", "Neha", "Riya", "Amit");

Set<String> uniqueNames = names.stream()
    .collect(Collectors.toSet());

Map<String, Long> counts = names.stream()
    .collect(Collectors.groupingBy(
        name -> name,
        Collectors.counting()
    ));
```

## Important Differences

### ArrayList vs LinkedList

| Point | ArrayList | LinkedList |
|---|---|---|
| Internal structure | Dynamic array | Doubly linked list |
| Random access | Fast | Slow |
| Insert/delete in middle | Slower due to shifting | Can be faster if node is known |
| Memory | Less overhead | More overhead due to node links |
| Best use | Reading by index | Queue/deque operations |

### HashSet vs TreeSet vs LinkedHashSet

| Point | HashSet | LinkedHashSet | TreeSet |
|---|---|---|---|
| Ordering | No guarantee | Insertion order | Sorted order |
| Speed | Fastest average | Slightly slower | O(log n) |
| Null | One null | One null | Usually no null |
| Implementation | Hash table | Hash table + linked list | Red-black tree |

### HashMap vs TreeMap vs LinkedHashMap

| Point | HashMap | LinkedHashMap | TreeMap |
|---|---|---|---|
| Ordering | No guarantee | Insertion/access order | Sorted key order |
| Speed | Fastest average | Slightly slower | O(log n) |
| Null key | One allowed | One allowed | Usually not allowed |
| Implementation | Hash table | Hash table + linked list | Red-black tree |

### Iterator vs ListIterator

| Point | Iterator | ListIterator |
|---|---|---|
| Works with | All collections | Only lists |
| Direction | Forward only | Forward and backward |
| Add element | No | Yes |
| Replace element | No | Yes |
| Remove element | Yes | Yes |

### Comparable vs Comparator

| Point | Comparable | Comparator |
|---|---|---|
| Package | `java.lang` | `java.util` |
| Method | `compareTo()` | `compare()` |
| Sorting logic | Inside class | Outside class |
| Number of sorting rules | Usually one | Many possible |

## HashMap Internal Working

`HashMap` stores data as key-value entries inside an internal array of buckets.

Basic flow of `put(key, value)`:

1. Calculate hash using `key.hashCode()`.
2. Convert hash into bucket index.
3. If bucket is empty, store the entry.
4. If bucket has entries, compare keys using `equals()`.
5. If key already exists, replace value.
6. If key does not exist, add a new entry.

Important terms:

| Term | Meaning |
|---|---|
| Bucket | A position in the internal table. |
| Capacity | Number of buckets. Default initial capacity is 16. |
| Load factor | Ratio that decides when resizing happens. Default is 0.75. |
| Threshold | `capacity * loadFactor`. Resize happens after crossing it. |
| Collision | When different keys go to the same bucket. |
| Rehashing | Rebuilding internal table after resizing. |
| Treeification | Converting a long bucket chain into a tree for better performance. |

Example:

```java
Map<String, Integer> map = new HashMap<>(16, 0.75f);
map.put("Java", 1);
map.put("Spring", 2);
```

Notes:

- A good `hashCode()` spreads keys evenly.
- Too many collisions reduce performance.
- Since Java 8, heavily-collided buckets may become balanced trees.
- Do not mutate fields used in `equals()` or `hashCode()` after inserting an object as a key.

## NavigableSet and NavigableMap

`NavigableSet` and `NavigableMap` provide methods to find nearby elements.

### NavigableSet Methods

```java
NavigableSet<Integer> set = new TreeSet<>(List.of(10, 20, 30, 40));

System.out.println(set.lower(30));   // 20, strictly less
System.out.println(set.floor(30));   // 30, less than or equal
System.out.println(set.ceiling(25)); // 30, greater than or equal
System.out.println(set.higher(30));  // 40, strictly greater
System.out.println(set.first());     // 10
System.out.println(set.last());      // 40
```

More methods:

```java
System.out.println(set.descendingSet());
System.out.println(set.subSet(10, true, 30, true));
System.out.println(set.headSet(30, false));
System.out.println(set.tailSet(20, true));
```

### NavigableMap Methods

```java
NavigableMap<Integer, String> map = new TreeMap<>();
map.put(10, "A");
map.put(20, "B");
map.put(30, "C");

System.out.println(map.lowerKey(20));     // 10
System.out.println(map.floorKey(20));     // 20
System.out.println(map.ceilingKey(25));   // 30
System.out.println(map.higherKey(20));    // 30
System.out.println(map.firstEntry());     // 10=A
System.out.println(map.lastEntry());      // 30=C
```

## Spliterator

`Spliterator` means splitable iterator. It is used mainly by streams for traversal and parallel processing.

Features:

- Can split elements into parts using `trySplit()`.
- Supports sequential and parallel traversal.
- Provides characteristics such as `ORDERED`, `SORTED`, `SIZED`, `DISTINCT`, and `IMMUTABLE`.

```java
List<String> names = List.of("Amit", "Neha", "Riya");
Spliterator<String> spliterator = names.spliterator();

spliterator.forEachRemaining(System.out::println);
```

Manual split:

```java
Spliterator<String> firstHalf = names.spliterator();
Spliterator<String> secondHalf = firstHalf.trySplit();

if (secondHalf != null) {
    secondHalf.forEachRemaining(System.out::println);
}
firstHalf.forEachRemaining(System.out::println);
```

## RandomAccess Marker Interface

`RandomAccess` is a marker interface. It has no methods.

It tells algorithms that a list supports fast index-based access.

Examples:

- `ArrayList` implements `RandomAccess`.
- `Vector` implements `RandomAccess`.
- `LinkedList` does not implement `RandomAccess`.

```java
List<Integer> list = new ArrayList<>();

if (list instanceof RandomAccess) {
    System.out.println("Fast index access");
}
```

## Arrays.asList vs List.of vs new ArrayList

| Point | `Arrays.asList()` | `List.of()` | `new ArrayList<>()` |
|---|---|---|---|
| Java version | Java 1.2 | Java 9 | Java 1.2 |
| Size change | Not allowed | Not allowed | Allowed |
| Element update | Allowed | Not allowed | Allowed |
| Null values | Allowed | Not allowed | Allowed |
| Backed by array | Yes | No | No |
| Modifiable | Partially | No | Yes |

```java
List<String> fixed = Arrays.asList("A", "B");
fixed.set(0, "X");
// fixed.add("C"); // UnsupportedOperationException

List<String> immutable = List.of("A", "B");
// immutable.set(0, "X"); // UnsupportedOperationException

List<String> modifiable = new ArrayList<>(List.of("A", "B"));
modifiable.add("C");
```

## Immutable and Unmodifiable Collections

Unmodifiable means the reference cannot be used to modify the collection, but the original collection may still change.

```java
List<String> original = new ArrayList<>();
original.add("A");

List<String> view = Collections.unmodifiableList(original);
original.add("B");

System.out.println(view); // [A, B]
```

Immutable collections cannot be changed after creation.

```java
List<String> list = List.of("A", "B");
// list.add("C"); // UnsupportedOperationException
```

Important distinction:

- `Collections.unmodifiableList(original)` creates an unmodifiable view.
- `List.copyOf(original)` creates an unmodifiable copy.

```java
List<String> copy = List.copyOf(original);
```

## More Collections Utility Methods

```java
List<String> empty = Collections.emptyList();
List<String> one = Collections.singletonList("Java");
List<String> repeated = Collections.nCopies(3, "Hi");

System.out.println(empty);    // []
System.out.println(one);      // [Java]
System.out.println(repeated); // [Hi, Hi, Hi]
```

Other useful methods:

| Method | Use |
|---|---|
| `addAll(collection, values...)` | Adds multiple values. |
| `fill(list, value)` | Replaces all elements with one value. |
| `copy(destination, source)` | Copies source into destination. |
| `rotate(list, distance)` | Rotates elements. |
| `replaceAll(list, old, new)` | Replaces matching values. |
| `indexOfSubList(source, target)` | Finds first sublist position. |
| `lastIndexOfSubList(source, target)` | Finds last sublist position. |
| `checkedList(list, type)` | Runtime type-safe wrapper. |

## Default Methods in Collection Interfaces

Java 8 added useful default methods.

### removeIf

```java
List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5));
numbers.removeIf(n -> n % 2 == 0);
System.out.println(numbers); // [1, 3, 5]
```

### replaceAll

```java
List<String> names = new ArrayList<>(List.of("amit", "neha"));
names.replaceAll(String::toUpperCase);
System.out.println(names); // [AMIT, NEHA]
```

### sort

```java
List<Integer> numbers = new ArrayList<>(List.of(3, 1, 2));
numbers.sort(Integer::compareTo);
System.out.println(numbers); // [1, 2, 3]
```

### forEach

```java
names.forEach(System.out::println);
```

## toArray Method

Collections can be converted to arrays.

```java
List<String> names = List.of("Amit", "Neha");

Object[] objectArray = names.toArray();
String[] stringArray = names.toArray(new String[0]);
```

Modern Java also supports:

```java
String[] array = names.toArray(String[]::new);
```

## Collection Conversions

### Array to List

```java
String[] array = {"A", "B", "C"};
List<String> list = new ArrayList<>(Arrays.asList(array));
```

### List to Set

```java
List<Integer> list = List.of(1, 2, 2, 3);
Set<Integer> set = new LinkedHashSet<>(list);
```

### Set to List

```java
Set<String> set = new HashSet<>(Set.of("A", "B"));
List<String> list = new ArrayList<>(set);
```

### Map Keys and Values to List

```java
Map<Integer, String> map = Map.of(1, "A", 2, "B");

List<Integer> keys = new ArrayList<>(map.keySet());
List<String> values = new ArrayList<>(map.values());
```

### List to Map

```java
class User {
    int id;
    String name;

    User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

List<User> users = List.of(new User(1, "Amit"), new User(2, "Neha"));

Map<Integer, String> userMap = users.stream()
    .collect(Collectors.toMap(user -> user.id, user -> user.name));
```

## More Concurrent Collections

| Collection | Description |
|---|---|
| `ConcurrentHashMap` | Thread-safe hash map. |
| `ConcurrentSkipListMap` | Thread-safe sorted map. |
| `ConcurrentSkipListSet` | Thread-safe sorted set. |
| `ConcurrentLinkedQueue` | Non-blocking thread-safe queue. |
| `ConcurrentLinkedDeque` | Non-blocking thread-safe deque. |
| `CopyOnWriteArrayList` | Thread-safe list optimized for reads. |
| `CopyOnWriteArraySet` | Thread-safe set optimized for reads. |
| `LinkedBlockingDeque` | Blocking double-ended queue. |

```java
NavigableMap<Integer, String> sortedMap = new ConcurrentSkipListMap<>();
sortedMap.put(2, "B");
sortedMap.put(1, "A");

Set<String> readMostlySet = new CopyOnWriteArraySet<>();
readMostlySet.add("Java");
```

## BlockingDeque

`BlockingDeque` is a thread-safe deque that can wait when full or empty.

```java
BlockingDeque<String> deque = new LinkedBlockingDeque<>(2);

deque.putFirst("A");
deque.putLast("B");

System.out.println(deque.takeFirst()); // A
System.out.println(deque.takeLast());  // B
```

## Comparable and Comparator Contracts

Sorting logic must be consistent and predictable.

Rules:

- If `a.compareTo(b) == 0`, they are considered equal for sorted collections.
- Comparator should be transitive: if `a > b` and `b > c`, then `a > c`.
- Do not return random or changing comparison results.
- Prefer `Integer.compare(a, b)` instead of `a - b` to avoid overflow.
- For `TreeSet` and `TreeMap`, comparison result decides uniqueness.

Problem example:

```java
Set<Student> set = new TreeSet<>(Comparator.comparing(s -> s.name));
```

If two students have the same name but different IDs, only one will remain because the comparator says they are equal.

Better:

```java
Set<Student> set = new TreeSet<>(
    Comparator.comparing((Student s) -> s.name)
              .thenComparingInt(s -> s.id)
);
```

## LRU Cache Using LinkedHashMap

`LinkedHashMap` can remove the eldest entry automatically.

```java
class LruCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    LruCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}

Map<Integer, String> cache = new LruCache<>(3);
cache.put(1, "A");
cache.put(2, "B");
cache.put(3, "C");
cache.get(1);
cache.put(4, "D");

System.out.println(cache); // {3=C, 1=A, 4=D}
```

## Sequenced Collections

Java 21 introduced sequenced collection interfaces for collections with a defined encounter order.

Main interfaces:

| Interface | Purpose |
|---|---|
| `SequencedCollection<E>` | Ordered collection with first/last operations. |
| `SequencedSet<E>` | Ordered set with first/last operations. |
| `SequencedMap<K,V>` | Ordered map with first/last entry operations. |

Common methods:

```java
SequencedCollection<String> names = new ArrayList<>();
names.addFirst("Amit");
names.addLast("Neha");

System.out.println(names.getFirst());
System.out.println(names.getLast());
System.out.println(names.reversed());
```

For maps:

```java
SequencedMap<Integer, String> map = new LinkedHashMap<>();
map.putFirst(1, "A");
map.putLast(2, "B");

System.out.println(map.firstEntry());
System.out.println(map.lastEntry());
System.out.println(map.reversed());
```

Examples of sequenced implementations:

- `ArrayList`
- `LinkedList`
- `LinkedHashSet`
- `TreeSet`
- `LinkedHashMap`
- `TreeMap`

## Common Mistakes

- Modifying a collection directly while iterating over it.
- Using mutable objects as `HashMap` keys.
- Forgetting to override both `equals()` and `hashCode()`.
- Expecting `HashMap` or `HashSet` to preserve order.
- Using `Stack` instead of `ArrayDeque`.
- Using `Vector` or `Hashtable` in new code without a specific reason.
- Calling `binarySearch` on an unsorted list.
- Sorting objects without defining `Comparable` or `Comparator`.
- Using `==` to compare strings or wrapper objects instead of `equals()`.
- Assuming synchronized wrappers make compound actions automatically atomic.
- Confusing unmodifiable views with immutable copies.
- Expecting `Arrays.asList()` to support `add()` or `remove()`.
- Forgetting that `TreeSet` uniqueness depends on comparison, not only `equals()`.
- Using subtraction in comparators, which can overflow.
- Assuming every Java version supports Java 21 sequenced collection methods.

## Interview Notes

- `ArrayList` grows dynamically when capacity is exceeded.
- `HashMap` stores entries based on hash buckets.
- `HashMap` uses `hashCode()` to choose a bucket and `equals()` to compare keys inside the bucket.
- `HashMap` allows one `null` key, but `ConcurrentHashMap` does not.
- `TreeMap` and `TreeSet` are sorted and usually backed by red-black trees.
- `LinkedHashMap` can be used to build an LRU cache.
- `ArrayDeque` is preferred for stack and queue operations in most single-threaded cases.
- `Iterator.remove()` is the safe way to remove while iterating.
- `Collections.synchronizedList()` requires external synchronization during iteration.
- `Comparable` defines natural ordering; `Comparator` defines custom ordering.
- `Arrays.asList()` has fixed size but allows `set()`.
- `List.of()` creates an unmodifiable list and does not allow `null`.
- `Spliterator` supports splitting traversal, mainly for streams.
- `RandomAccess` marks lists with fast index access.
- Java 21 added `SequencedCollection`, `SequencedSet`, and `SequencedMap`.

## Quick Revision

- `List`: ordered, duplicates allowed.
- `Set`: unique elements.
- `Queue`: elements waiting for processing.
- `Deque`: insertion/removal from both ends.
- `Map`: key-value pairs.
- `ArrayList`: best for fast index-based access.
- `LinkedList`: useful as deque, but not best for random access.
- `HashSet`: unique, unordered, fast.
- `LinkedHashSet`: unique, insertion order.
- `TreeSet`: unique, sorted.
- `HashMap`: key-value, unordered, fast.
- `LinkedHashMap`: key-value, insertion/access order.
- `TreeMap`: key-value, sorted by key.
- `ConcurrentHashMap`: thread-safe high-performance map.
- `PriorityQueue`: priority-based processing.
- `Collections`: utility methods.
- `Comparable` and `Comparator`: sorting logic.
- `NavigableSet` and `NavigableMap`: nearest lower/higher element lookup.
- `Spliterator`: splitable traversal used by streams.
- `RandomAccess`: marker for fast index-based lists.
- `Arrays.asList()`: fixed-size list backed by array.
- `List.of()`: unmodifiable list.
- `List.copyOf()`: unmodifiable copy.
- `ConcurrentSkipListMap`: thread-safe sorted map.
- `BlockingDeque`: blocking double-ended queue.
- `SequencedCollection`: Java 21 ordered collection interface.
