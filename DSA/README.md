# DSA in Java — Complete Roadmap

> **Language:** Java
> **Level:** Beginner → Advanced → Competitive Programming
> **Goal:** Master Data Structures, Algorithms, Problem Solving, Interview DSA, Competitive Programming and GATE-level DSA.

---

# Table of Contents

1. DSA Foundations
2. Java for DSA
3. Complexity Analysis
4. Mathematics for DSA
5. Arrays
6. Strings
7. Searching
8. Sorting
9. Recursion
10. Backtracking
11. Linked List
12. Stack
13. Queue
14. Deque
15. Hashing
16. Set and Map
17. Two Pointers
18. Sliding Window
19. Prefix Sum
20. Difference Array
21. Bit Manipulation
22. Greedy Algorithms
23. Trees
24. Binary Search Tree
25. Heap and Priority Queue
26. Trie
27. Graph Foundations
28. Graph Traversal
29. Shortest Path
30. Minimum Spanning Tree
31. Topological Sorting
32. Disjoint Set Union
33. Dynamic Programming
34. Divide and Conquer
35. Advanced Graph Algorithms
36. Advanced Trees
37. Range Query Data Structures
38. String Algorithms
39. Number Theory
40. Computational Geometry
41. Advanced Algorithms
42. Amortized Analysis
43. Randomized Algorithms
44. Java Collections for DSA
45. Problem-Solving Patterns
46. Competitive Programming Techniques
47. Interview Preparation
48. GATE-Oriented DSA
49. DSA Project Practice
50. Final Mastery Roadmap

---

# Chapter 1 — DSA Foundations

## 1.1 What is Data Structure?

A data structure is a way of organizing and storing data so that operations can be performed efficiently.

Examples:

```text
Array
Linked List
Stack
Queue
Tree
Graph
Hash Table
Heap
Trie
```

---

## 1.2 What is an Algorithm?

An algorithm is a finite sequence of well-defined steps used to solve a problem.

Example:

```text
Input
  ↓
Process
  ↓
Output
```

---

## 1.3 Characteristics of an Algorithm

Study:

* Input
* Output
* Definiteness
* Finiteness
* Effectiveness
* Correctness

---

## 1.4 Algorithm Analysis

Study:

* Time complexity
* Space complexity
* Auxiliary space
* Input size
* Best case
* Average case
* Worst case
* Amortized complexity

---

# Chapter 2 — Java for DSA

Before starting serious DSA, master the Java features used repeatedly.

## 2.1 Java Basics

* Variables
* Data types
* Operators
* Conditions
* Loops
* Methods
* Arrays
* Classes
* Objects

---

## 2.2 Important Java Features for DSA

Study:

* `String`
* `StringBuilder`
* `StringBuffer`
* `char`
* `Character`
* Wrapper classes
* Autoboxing
* Unboxing
* `static`
* `final`

---

## 2.3 Java Collections

Master:

```text
ArrayList
LinkedList
Vector
Stack
ArrayDeque
PriorityQueue
HashSet
LinkedHashSet
TreeSet
HashMap
LinkedHashMap
TreeMap
Queue
Deque
```

---

## 2.4 Java Interfaces

Understand:

```text
Collection
List
Set
Queue
Deque
Map
SortedSet
NavigableSet
SortedMap
NavigableMap
```

---

## 2.5 Utility Classes

Learn:

```text
Arrays
Collections
Objects
Comparator
Comparable
Math
Random
Optional
```

---

## 2.6 Custom Comparators

Essential for DSA.

```java
Arrays.sort(arr, (a, b) -> Integer.compare(a, b));
```

Study:

* `Comparable`
* `Comparator`
* Lambda comparator
* Multi-level sorting
* Custom objects

---

# Chapter 3 — Complexity Analysis

This is one of the most important DSA chapters.

## 3.1 Asymptotic Notation

Study:

```text
Big O
Big Ω
Big Θ
```

---

## 3.2 Common Complexities

Know:

```text
O(1)
O(log n)
O(n)
O(n log n)
O(n²)
O(n³)
O(2ⁿ)
O(n!)
```

---

## 3.3 Analyze Loops

Study:

* Single loop
* Nested loops
* Dependent loops
* Logarithmic loops
* Halving loops
* Doubling loops

---

## 3.4 Analyze Recursion

Study:

* Recurrence relation
* Recursion tree
* Substitution method
* Master theorem

---

## 3.5 Space Complexity

Understand:

* Input space
* Auxiliary space
* Recursion stack
* Heap memory
* Stack memory

---

# Chapter 4 — Mathematics for DSA

Mathematics significantly improves algorithmic problem solving.

## 4.1 Number Basics

Study:

* Positive/negative numbers
* Even/odd
* Divisibility
* Factors
* Multiples

---

## 4.2 GCD and LCM

Algorithms:

* Euclidean algorithm
* Extended Euclidean algorithm

---

## 4.3 Prime Numbers

Study:

* Prime checking
* Trial division
* Sieve of Eratosthenes
* Segmented sieve
* Prime factorization

---

## 4.4 Modular Arithmetic

Study:

```text
(a + b) % m
(a - b) % m
(a × b) % m
```

Also:

* Modular inverse
* Modular exponentiation
* Fermat's Little Theorem
* Euler's theorem

---

## 4.5 Fast Exponentiation

Study:

* Binary exponentiation
* Modular exponentiation

Complexity:

```text
O(log n)
```

---

## 4.6 Combinatorics

Study:

* Factorial
* Permutations
* Combinations
* Pascal's triangle
* Binomial coefficients

---

## 4.7 Mathematical Sequences

Study:

* Arithmetic progression
* Geometric progression
* Fibonacci
* Catalan numbers

---

# Chapter 5 — Arrays

Arrays are the foundation of DSA.

## 5.1 Array Basics

Study:

* Declaration
* Initialization
* Traversal
* Insertion
* Deletion
* Searching
* Updating

---

## 5.2 1D Arrays

Practice:

* Maximum
* Minimum
* Sum
* Average
* Reverse
* Rotation
* Frequency
* Duplicate detection

---

## 5.3 2D Arrays

Study:

* Matrix traversal
* Row traversal
* Column traversal
* Diagonal traversal
* Matrix addition
* Matrix multiplication
* Transpose
* Rotation

---

## 5.4 Array Patterns

Master:

* Prefix sum
* Difference array
* Two pointers
* Sliding window
* Kadane's algorithm
* Dutch National Flag
* Partitioning

---

# Chapter 6 — Strings

## 6.1 String Fundamentals

Study:

* String immutability
* Character access
* Concatenation
* Substring
* Comparison
* Conversion

---

## 6.2 StringBuilder

Master:

```java
StringBuilder sb = new StringBuilder();
```

Operations:

* append
* insert
* delete
* reverse
* replace

---

## 6.3 String Problems

Practice:

* Palindrome
* Anagram
* Frequency counting
* Duplicate characters
* Character compression
* String reversal
* Rotation
* Subsequence
* Substring

---

## 6.4 Advanced String Topics

Study later:

* Pattern matching
* KMP
* Z algorithm
* Rabin-Karp
* Rolling hash
* Trie
* Suffix array
* Suffix tree

---

# Chapter 7 — Searching Algorithms

## 7.1 Linear Search

Complexity:

```text
O(n)
```

---

## 7.2 Binary Search

Master:

```text
O(log n)
```

Study:

* Iterative binary search
* Recursive binary search
* First occurrence
* Last occurrence
* Lower bound
* Upper bound
* Search insertion position

---

## 7.3 Binary Search on Answer

Very important.

Pattern:

```text
low
high

while (low <= high)
```

Problems involving:

* Minimum possible answer
* Maximum possible answer
* Feasibility checking

---

## 7.4 Advanced Binary Search

Study:

* Rotated sorted array
* Peak element
* Mountain array
* Search in matrix
* Minimum in rotated array
* Search on monotonic function

---

# Chapter 8 — Sorting Algorithms

## 8.1 Elementary Sorting

Master:

```text
Bubble Sort
Selection Sort
Insertion Sort
```

Understand their:

* Time complexity
* Space complexity
* Stability
* In-place property

---

## 8.2 Efficient Sorting

Master:

```text
Merge Sort
Quick Sort
Heap Sort
```

---

## 8.3 Non-Comparison Sorting

Study:

```text
Counting Sort
Radix Sort
Bucket Sort
```

---

## 8.4 Sorting Concepts

Understand:

* Stable sorting
* Unstable sorting
* In-place sorting
* Adaptive sorting
* Internal sorting
* External sorting

---

# Chapter 9 — Recursion

Recursion is a foundation for trees, graphs, backtracking and DP.

## 9.1 Basics

Study:

* Base case
* Recursive case
* Call stack
* Stack overflow

---

## 9.2 Types

* Direct recursion
* Indirect recursion
* Tail recursion
* Tree recursion
* Nested recursion

---

## 9.3 Recursive Problems

Practice:

* Factorial
* Fibonacci
* Power
* Sum
* Reverse number
* Reverse string
* Array traversal

---

## 9.4 Recursion Analysis

Study:

* Recurrence relations
* Recursion tree
* Stack space

---

# Chapter 10 — Backtracking

Backtracking is essential for constraint-solving problems.

## 10.1 Core Pattern

```text
Choose
Explore
Unchoose
```

---

## 10.2 Problems

Master:

* Subsets
* Subsequences
* Permutations
* Combination Sum
* Letter combinations
* N-Queens
* Sudoku
* Rat in a Maze
* Word Search
* Graph coloring

---

# Chapter 11 — Linked List

## 11.1 Singly Linked List

Study:

* Node
* Head
* Tail
* Traversal
* Insertion
* Deletion
* Search

---

## 11.2 Doubly Linked List

Study:

* Previous pointer
* Next pointer
* Insertion
* Deletion
* Reverse

---

## 11.3 Circular Linked List

Study:

* Circular singly list
* Circular doubly list

---

## 11.4 Important Problems

Master:

* Reverse linked list
* Middle node
* Detect cycle
* Remove cycle
* Merge sorted lists
* Intersection
* Remove duplicates
* Palindrome
* Reverse in groups
* Rotate list
* Sort linked list

---

## 11.5 Fast and Slow Pointer

Master Floyd's cycle detection algorithm.

---

# Chapter 12 — Stack

## 12.1 Stack Fundamentals

Operations:

```text
push
pop
peek
isEmpty
```

---

## 12.2 Implement Stack

Using:

* Array
* Linked List
* `ArrayDeque`

---

## 12.3 Stack Problems

Master:

* Balanced parentheses
* Next greater element
* Next smaller element
* Previous greater element
* Previous smaller element
* Stock span
* Largest rectangle in histogram
* Min stack
* Expression evaluation

---

## 12.4 Expression Algorithms

Study:

* Infix
* Prefix
* Postfix
* Infix → Postfix
* Infix → Prefix
* Postfix evaluation
* Prefix evaluation

---

# Chapter 13 — Queue

## 13.1 Queue

Operations:

```text
enqueue
dequeue
front
rear
```

---

## 13.2 Implement Queue

Using:

* Array
* Linked List
* Circular array

---

## 13.3 Circular Queue

Study:

* Front
* Rear
* Modulo arithmetic
* Full condition
* Empty condition

---

## 13.4 Priority Queue

Learn Java:

```java
PriorityQueue<Integer>
```

Understand:

* Min heap behavior
* Max heap comparator
* Custom objects

---

# Chapter 14 — Deque

Deque = Double Ended Queue.

Operations:

```text
addFirst
addLast
removeFirst
removeLast
peekFirst
peekLast
```

Java:

```java
ArrayDeque<Integer> deque;
```

Problems:

* Sliding window maximum
* Monotonic queue
* Palindrome checking

---

# Chapter 15 — Hashing

## 15.1 Hash Table

Understand:

* Hash function
* Hash code
* Collision
* Bucket
* Load factor
* Rehashing

---

## 15.2 Collision Resolution

Study:

* Separate chaining
* Open addressing
* Linear probing
* Quadratic probing
* Double hashing

---

## 15.3 Java Hashing

Understand:

```text
HashMap
HashSet
LinkedHashMap
LinkedHashSet
```

---

## 15.4 Hashing Problems

Practice:

* Two Sum
* Frequency counting
* Duplicate detection
* Longest consecutive sequence
* Subarray sum
* Zero-sum subarray
* Anagram grouping

---

# Chapter 16 — Set and Map

Study:

```text
HashSet
LinkedHashSet
TreeSet

HashMap
LinkedHashMap
TreeMap
```

Understand:

* Ordering
* Complexity
* Hashing
* Tree-based maps
* Custom comparators

---

# Chapter 17 — Two Pointers

Master patterns:

```text
left
right
```

Problems:

* Pair sum
* 3Sum
* 4Sum
* Remove duplicates
* Container with most water
* Trapping rain water
* Sorted array problems

---

# Chapter 18 — Sliding Window

## 18.1 Fixed Window

Examples:

* Maximum sum subarray of size K
* Average of subarray

---

## 18.2 Variable Window

Examples:

* Longest substring without repeating characters
* Minimum window substring
* Longest subarray satisfying condition

---

## 18.3 Advanced Sliding Window

Combine with:

* HashMap
* HashSet
* Deque
* Frequency array

---

# Chapter 19 — Prefix Sum

Study:

* 1D prefix sum
* 2D prefix sum
* Range sum
* Prefix frequency
* Prefix XOR

Pattern:

```text
prefix[i] = prefix[i - 1] + arr[i]
```

---

# Chapter 20 — Difference Array

Useful for range updates.

Study:

* 1D difference array
* Range increment
* Range decrement
* 2D difference array

---

# Chapter 21 — Bit Manipulation

Very important for advanced DSA and competitive programming.

## 21.1 Binary Representation

Understand:

```text
Decimal
Binary
Octal
Hexadecimal
```

---

## 21.2 Bit Operators

```text
&
|
^
~
<<
>>
>>>
```

---

## 21.3 Important Techniques

Study:

* Check odd/even
* Check/set/clear bit
* Toggle bit
* Count set bits
* Power of two
* XOR properties
* Bit masks
* Brian Kernighan algorithm

---

## 21.4 Advanced Bitmasking

Study:

* Subset masks
* Bitmask DP
* State compression
* Bitset techniques

---

# Chapter 22 — Greedy Algorithms

## 22.1 Greedy Concept

At each step choose the locally optimal decision.

---

## 22.2 Problems

Master:

* Activity selection
* Fractional knapsack
* Job sequencing
* Coin change variants
* Interval scheduling
* Merge intervals
* Minimum platforms
* Huffman coding
* Gas station
* Jump game

---

## 22.3 Greedy Proof

Learn:

* Greedy choice property
* Optimal substructure
* Exchange argument

---

# Chapter 23 — Trees

## 23.1 Tree Fundamentals

Study:

* Root
* Parent
* Child
* Leaf
* Sibling
* Depth
* Height
* Level
* Subtree
* Degree

---

## 23.2 Binary Tree

Each node has at most two children.

---

## 23.3 Traversals

Master:

```text
Preorder
Inorder
Postorder
Level Order
```

---

## 23.4 Recursive Traversal

Study recursive implementations.

---

## 23.5 Iterative Traversal

Master iterative:

* Preorder
* Inorder
* Postorder
* Level order

using stacks/queues.

---

## 23.6 Tree Problems

Master:

* Height
* Diameter
* Maximum path sum
* Lowest Common Ancestor
* Symmetric tree
* Identical trees
* Mirror tree
* Balanced tree
* Boundary traversal
* Vertical traversal
* Top view
* Bottom view
* Left view
* Right view
* Zigzag traversal

---

# Chapter 24 — Binary Search Tree

Study:

* BST property
* Search
* Insert
* Delete
* Minimum
* Maximum
* Successor
* Predecessor

---

## 24.1 BST Problems

Master:

* Validate BST
* Kth smallest
* Kth largest
* LCA
* Sorted array → BST
* Recover BST
* Two Sum in BST

---

# Chapter 25 — Heap

## 25.1 Heap Fundamentals

Study:

* Min heap
* Max heap
* Complete binary tree
* Heap property

---

## 25.2 Operations

```text
insert
extract
peek
heapify
```

---

## 25.3 Heap Sort

Understand:

```text
Build heap
Extract repeatedly
```

---

## 25.4 Java PriorityQueue

Master:

```java
PriorityQueue<Integer> minHeap =
        new PriorityQueue<>();

PriorityQueue<Integer> maxHeap =
        new PriorityQueue<>(Comparator.reverseOrder());
```

---

## 25.5 Heap Problems

Practice:

* Kth largest
* Kth smallest
* Top K elements
* K closest points
* Merge K sorted lists
* Median from data stream
* Task scheduling

---

# Chapter 26 — Trie

Trie is a prefix tree.

Study:

* Trie node
* Insert
* Search
* Prefix search
* Delete
* Word dictionary

Problems:

* Autocomplete
* Word search
* Prefix matching
* Maximum XOR

---

# Chapter 27 — Graph Foundations

## 27.1 Graph Terminology

Study:

* Vertex
* Edge
* Degree
* Path
* Cycle
* Connected component
* Directed graph
* Undirected graph
* Weighted graph
* Unweighted graph
* Multigraph
* DAG

---

## 27.2 Graph Representation

Master:

### Adjacency Matrix

```text
V × V
```

### Adjacency List

```text
List<List<Integer>>
```

### Edge List

```text
List<Edge>
```

---

# Chapter 28 — Graph Traversal

## 28.1 BFS

Breadth First Search.

Uses:

```text
Queue
```

Applications:

* Shortest path in unweighted graph
* Level traversal
* Connected components

---

## 28.2 DFS

Depth First Search.

Uses:

```text
Recursion
Stack
```

Applications:

* Cycle detection
* Components
* Path finding
* Topological sorting

---

## 28.3 Graph Problems

Master:

* Number of islands
* Flood fill
* Connected components
* Bipartite graph
* Cycle detection
* Path existence
* Grid traversal

---

# Chapter 29 — Shortest Path Algorithms

## 29.1 BFS Shortest Path

For unweighted graphs.

---

## 29.2 Dijkstra

For graphs with non-negative edge weights.

Understand:

* Priority queue
* Relaxation
* Distance array

Complexity commonly achieved with a binary heap:

```text
O((V + E) log V)
```

---

## 29.3 Bellman-Ford

Handles negative edge weights.

Study:

* Relaxation
* Negative cycle detection

---

## 29.4 Floyd-Warshall

All-pairs shortest path.

Complexity:

```text
O(V³)
```

---

# Chapter 30 — Minimum Spanning Tree

Study:

```text
Prim's Algorithm
Kruskal's Algorithm
```

Understand:

* Spanning tree
* Minimum spanning tree
* Edge selection
* Cycle prevention

---

# Chapter 31 — Topological Sorting

Applicable to DAGs.

Algorithms:

```text
DFS
Kahn's Algorithm
```

Applications:

* Course scheduling
* Dependency resolution
* Build systems
* Task ordering

---

# Chapter 32 — Disjoint Set Union

Also called:

```text
Union-Find
DSU
```

Study:

* Parent array
* Find
* Union
* Path compression
* Union by rank
* Union by size

Applications:

* Kruskal
* Connected components
* Cycle detection
* Dynamic connectivity

---

# Chapter 33 — Dynamic Programming

One of the most important advanced DSA topics.

## 33.1 DP Fundamentals

Understand:

* Overlapping subproblems
* Optimal substructure
* State
* Transition
* Base case

---

## 33.2 Memoization

Top-down DP.

```text
Recursion
+
Cache
```

---

## 33.3 Tabulation

Bottom-up DP.

```text
Base cases
↓
Build table
↓
Final answer
```

---

# Chapter 34 — 1D Dynamic Programming

Master:

* Fibonacci
* Climbing stairs
* House robber
* Coin change
* Minimum cost climbing stairs
* Decode ways
* Maximum subarray variants

---

# Chapter 35 — 2D Dynamic Programming

Master:

* Grid paths
* Minimum path sum
* Unique paths
* Dungeon game
* Matrix chain multiplication

---

# Chapter 36 — Knapsack DP

Master:

```text
0/1 Knapsack
Unbounded Knapsack
Bounded Knapsack
Subset Sum
Partition Equal Subset Sum
Target Sum
Coin Change
```

---

# Chapter 37 — Subsequence DP

Master:

```text
LCS
LIS
Longest Palindromic Subsequence
Longest Common Substring
Edit Distance
```

---

# Chapter 38 — Interval DP

Study:

* Matrix Chain Multiplication
* Burst Balloons
* Optimal BST
* Palindrome partitioning

---

# Chapter 39 — Tree DP

Study:

* DP on binary trees
* Maximum independent set
* Tree diameter DP
* Rerooting concepts

---

# Chapter 40 — Bitmask DP

Study:

* Subset states
* State compression
* Traveling Salesman Problem
* Assignment problems

---

# Chapter 41 — Divide and Conquer

Study:

* Concept
* Divide
* Conquer
* Combine

Algorithms:

```text
Merge Sort
Quick Sort
Binary Search
Closest Pair
Strassen Matrix Multiplication
```

---

# Chapter 42 — Advanced Graph Algorithms

Study:

* Strongly Connected Components
* Kosaraju
* Tarjan
* Bridges
* Articulation points
* Euler path
* Euler circuit
* Hamiltonian path
* Hamiltonian cycle
* Maximum flow
* Minimum cut

---

# Chapter 43 — Strongly Connected Components

Master:

## Kosaraju Algorithm

Steps:

```text
DFS
↓
Stack by finishing time
↓
Reverse graph
↓
DFS in reverse finishing order
```

## Tarjan Algorithm

Understand:

* Discovery time
* Low-link value
* DFS stack

---

# Chapter 44 — Bridges and Articulation Points

Study:

* Discovery time
* Low-link
* DFS tree

Applications:

* Network reliability
* Critical connections

---

# Chapter 45 — Advanced Trees

Study:

* AVL Tree
* Red-Black Tree
* B-Tree
* B+ Tree
* Segment Tree
* Fenwick Tree
* Binary Lifting
* Heavy-Light Decomposition

---

# Chapter 46 — AVL Tree

Study:

* Balance factor
* Left rotation
* Right rotation
* Left-right rotation
* Right-left rotation
* Insert
* Delete

---

# Chapter 47 — Red-Black Tree

Understand:

* Coloring rules
* Rotations
* Rebalancing
* Insertion
* Deletion

Important because Java's:

```text
TreeMap
TreeSet
```

are based on red-black tree concepts.

---

# Chapter 48 — Segment Tree

Used for range queries and updates.

Study:

* Build
* Query
* Point update
* Range update
* Lazy propagation

Problems:

* Range sum
* Range minimum
* Range maximum

---

# Chapter 49 — Fenwick Tree

Also called:

```text
Binary Indexed Tree
BIT
```

Study:

* Prefix sum
* Point update
* Range sum
* Coordinate compression

Typical complexity:

```text
Update: O(log n)
Query:  O(log n)
```

---

# Chapter 50 — Binary Lifting

Used for:

* Lowest Common Ancestor
* Kth ancestor
* Tree queries

Study:

```text
up[node][j]
```

---

# Chapter 51 — Heavy-Light Decomposition

Advanced tree technique.

Used for:

* Path queries
* Path updates
* Tree range queries

Usually combined with:

```text
Segment Tree
```

---

# Chapter 52 — String Algorithms

## 52.1 Naive Pattern Matching

Complexity:

```text
O(nm)
```

---

## 52.2 KMP

Study:

* Prefix function
* LPS array
* Pattern matching

---

## 52.3 Z Algorithm

Study:

* Z array
* Pattern matching
* String preprocessing

---

## 52.4 Rabin-Karp

Study:

* Rolling hash
* Hash collision
* Multiple pattern matching

---

## 52.5 Advanced Strings

Study:

* Trie
* Suffix array
* Suffix tree
* Suffix automaton

---

# Chapter 53 — Number Theory Algorithms

Study:

* GCD
* Extended GCD
* LCM
* Prime factorization
* Sieve
* Segmented sieve
* Euler phi
* Modular inverse
* Modular exponentiation
* Chinese Remainder Theorem
* Fermat's Little Theorem
* Euler's theorem

---

# Chapter 54 — Computational Geometry

Advanced topic.

Study:

* Points
* Lines
* Vectors
* Distance
* Orientation
* Cross product
* Dot product
* Line intersection
* Segment intersection
* Convex hull
* Closest pair of points

---

# Chapter 55 — Advanced Algorithm Techniques

Study:

* Meet in the middle
* Coordinate compression
* Sweep line
* Offline queries
* Mo's algorithm
* Randomized algorithms
* Reservoir sampling
* Binary lifting
* Divide and conquer optimization
* Convex hull trick

---

# Chapter 56 — Amortized Analysis

Study:

* Aggregate method
* Accounting method
* Potential method

Examples:

* Dynamic array resizing
* Stack operations
* Union-Find

---

# Chapter 57 — Randomized Algorithms

Study:

* Randomized quicksort
* Randomized selection
* Randomized hashing
* Reservoir sampling

---

# Chapter 58 — Important Problem-Solving Patterns

These patterns should become automatic.

## Pattern 1 — Frequency Map

```text
HashMap
```

Use for:

* Counting
* Duplicates
* Anagrams

---

## Pattern 2 — Two Pointers

```text
left → ← right
```

---

## Pattern 3 — Sliding Window

```text
left → right
```

---

## Pattern 4 — Fast and Slow Pointer

Used in:

* Linked list
* Cycle detection

---

## Pattern 5 — Prefix Sum

Used for:

* Range queries
* Subarray sums

---

## Pattern 6 — Binary Search

Used for:

* Sorted data
* Monotonic answer space

---

## Pattern 7 — Monotonic Stack

Used for:

* Next greater element
* Histogram
* Stock span

---

## Pattern 8 — Heap

Used for:

* Top K
* Scheduling
* Median
* Kth largest/smallest

---

## Pattern 9 — BFS

Used for:

* Shortest unweighted path
* Levels
* Grid problems

---

## Pattern 10 — DFS

Used for:

* Components
* Cycles
* Backtracking
* Tree problems

---

## Pattern 11 — Greedy

Used when local choices can be proven optimal.

---

## Pattern 12 — Backtracking

Used for:

```text
Choose
Explore
Undo
```

---

## Pattern 13 — Dynamic Programming

Use:

```text
State
Transition
Base case
```

---

## Pattern 14 — Union-Find

Used for:

* Connectivity
* MST
* Dynamic components

---

# Chapter 59 — Java Collections for DSA

Master the following completely.

## List

```text
ArrayList
LinkedList
Vector
```

Know:

* Complexity
* Internal implementation
* When to use each

---

## Stack

Prefer:

```java
ArrayDeque
```

for many stack use cases.

---

## Queue

Study:

```text
Queue
ArrayDeque
LinkedList
PriorityQueue
```

---

## Set

```text
HashSet
LinkedHashSet
TreeSet
```

---

## Map

```text
HashMap
LinkedHashMap
TreeMap
```

---

## Concurrent Collections

For advanced Java concurrency:

```text
ConcurrentHashMap
ConcurrentLinkedQueue
BlockingQueue
CopyOnWriteArrayList
```

---

# Chapter 60 — DSA Debugging Skills

Learn to debug:

* Infinite loops
* Stack overflow
* Array index errors
* Null pointer errors
* Integer overflow
* Incorrect base cases
* Incorrect pointer movement
* Off-by-one errors
* Wrong binary search boundaries
* Incorrect recursion state
* DP state mistakes

---

# Chapter 61 — Integer Overflow

Very important in Java.

For example:

```java
int result = a * b;
```

may overflow.

Use:

```java
long result = (long) a * b;
```

Understand:

```text
Integer.MAX_VALUE
Integer.MIN_VALUE
Long.MAX_VALUE
Long.MIN_VALUE
```

---

# Chapter 62 — Input/Output for Competitive Programming

Learn:

```text
BufferedReader
StringTokenizer
BufferedInputStream
StringBuilder
BufferedWriter
```

Build a custom fast scanner when required.

Example:

```java
static class FastScanner {

    private final BufferedReader br =
            new BufferedReader(
                    new InputStreamReader(System.in));

    private StringTokenizer st;

    String next() throws IOException {

        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }

        return st.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
}
```

---

# Chapter 63 — Competitive Programming Techniques

Study:

* Fast I/O
* Coordinate compression
* Prefix sums
* Difference arrays
* Binary search
* Greedy
* DP
* Bit manipulation
* Graph algorithms
* DSU
* Segment trees
* Fenwick trees
* Modular arithmetic
* Combinatorics

---

# Chapter 64 — Problem Difficulty Progression

Do not immediately start hard problems.

## Level 1

```text
Basic
Arrays
Strings
Loops
Searching
Sorting
```

Target:

```text
Easy
```

---

## Level 2

```text
Hashing
Two pointers
Sliding window
Linked list
Stack
Queue
```

Target:

```text
Easy → Medium
```

---

## Level 3

```text
Trees
Heap
Greedy
Binary search
Recursion
Backtracking
```

Target:

```text
Medium
```

---

## Level 4

```text
Graphs
Dynamic Programming
Tries
Advanced recursion
```

Target:

```text
Medium → Hard
```

---

## Level 5

```text
Advanced graphs
Segment tree
Fenwick tree
String algorithms
Advanced DP
Advanced trees
```

Target:

```text
Hard
```

---

# Chapter 65 — Recommended Problem-Solving Process

For every problem follow:

```text
1. Understand the problem
        ↓
2. Identify input/output
        ↓
3. Create examples
        ↓
4. Think brute force
        ↓
5. Analyze complexity
        ↓
6. Identify pattern
        ↓
7. Optimize
        ↓
8. Write algorithm
        ↓
9. Implement in Java
        ↓
10. Test edge cases
        ↓
11. Analyze complexity
        ↓
12. Review solution
```

---

# Chapter 66 — Edge Cases

Always test:

```text
Empty input
Single element
Two elements
All equal
Already sorted
Reverse sorted
Negative values
Large values
Duplicate values
Maximum input size
Minimum input size
```

---

# Chapter 67 — DSA Practice Structure

For each topic use:

### Step 1

Understand theory.

### Step 2

Implement the data structure/algorithm manually.

### Step 3

Solve basic problems.

### Step 4

Solve pattern-based problems.

### Step 5

Solve medium problems.

### Step 6

Solve hard problems.

### Step 7

Reimplement without notes.

### Step 8

Review mistakes.

---

# Chapter 68 — Implementation Checklist

You should eventually implement these from scratch.

## Data Structures

```text
Array
Dynamic Array
Singly Linked List
Doubly Linked List
Circular Linked List
Stack
Queue
Circular Queue
Deque
Hash Table
Binary Tree
BST
Heap
Trie
Graph
AVL Tree
Segment Tree
Fenwick Tree
DSU
```

---

# Chapter 69 — Algorithm Implementation Checklist

Implement from scratch:

```text
Linear Search
Binary Search

Bubble Sort
Selection Sort
Insertion Sort
Merge Sort
Quick Sort
Heap Sort
Counting Sort
Radix Sort

BFS
DFS

Dijkstra
Bellman-Ford
Floyd-Warshall

Prim
Kruskal

Topological Sort
Kosaraju
Tarjan

KMP
Rabin-Karp
Z Algorithm

Kadane

Euclidean GCD
Sieve
Fast Exponentiation

LCS
LIS
Knapsack
Edit Distance

N-Queens
Sudoku
Backtracking

Segment Tree
Fenwick Tree
DSU
```

---

# Chapter 70 — Interview DSA

Focus heavily on:

```text
Arrays
Strings
Hashing
Linked List
Stack
Queue
Binary Search
Trees
BST
Heap
Graphs
Greedy
Backtracking
Dynamic Programming
```

Also understand:

* Time complexity
* Space complexity
* Trade-offs
* Alternative solutions
* Edge cases

---

# Chapter 71 — GATE-Oriented DSA

For GATE-level preparation, emphasize:

## Data Structures

```text
Arrays
Linked Lists
Stacks
Queues
Trees
BST
Heaps
Hashing
Graphs
```

## Algorithms

```text
Searching
Sorting
Graph Traversal
Shortest Path
MST
Topological Sort
Recursion
Greedy
Dynamic Programming
```

## Theory

```text
Complexity
Recurrences
Asymptotic notation
Graph properties
Tree properties
Sorting analysis
Hashing
```

---

# Chapter 72 — Advanced Problem Categories

After completing normal DSA, study:

```text
Range Queries
Advanced DP
Tree DP
Graph DP
Bitmask DP
String Algorithms
Advanced Graphs
Advanced Trees
Flow Algorithms
Computational Geometry
Number Theory
Game Theory
```

---

# Chapter 73 — Game Theory

Optional advanced competitive programming topic.

Study:

* Nim
* Sprague-Grundy theorem
* Grundy numbers
* Winning and losing positions

---

# Chapter 74 — Network Flow

Advanced graph topic.

Study:

* Flow network
* Residual graph
* Augmenting path
* Ford-Fulkerson
* Edmonds-Karp
* Dinic's algorithm
* Maximum flow
* Minimum cut
* Bipartite matching

---

# Chapter 75 — Advanced Dynamic Programming

Study:

* Digit DP
* Tree DP
* Bitmask DP
* Interval DP
* DP on DAG
* DP optimization
* Divide and conquer optimization
* Convex hull trick
* State compression

---

# Chapter 76 — Advanced Graph Topics

Study:

```text
SCC
Bridges
Articulation Points
Eulerian Path
Eulerian Circuit
Hamiltonian Path
Hamiltonian Cycle
Maximum Flow
Minimum Cut
Bipartite Matching
Graph Coloring
```

---

# Chapter 77 — DSA Projects

After learning core DSA, build small projects.

## Project 1 — Custom ArrayList

Implement:

```text
add
remove
get
set
contains
resize
```

---

## Project 2 — Custom HashMap

Implement:

```text
put
get
remove
containsKey
resize
rehash
```

---

## Project 3 — Custom LinkedList

Implement:

```text
insert
delete
search
reverse
```

---

## Project 4 — Mini Search Engine

Use:

```text
Trie
HashMap
String algorithms
```

---

## Project 5 — Route Finder

Use:

```text
Graph
BFS
Dijkstra
PriorityQueue
```

---

## Project 6 — Task Scheduler

Use:

```text
PriorityQueue
Heap
Greedy
```

---

## Project 7 — Autocomplete System

Use:

```text
Trie
Heap
HashMap
```

---

# Chapter 78 — Master DSA Pattern Map

```text
Array
 |
 +-- Prefix Sum
 +-- Difference Array
 +-- Two Pointer
 +-- Sliding Window
 +-- Binary Search
 +-- Kadane
 +-- Sorting

String
 |
 +-- Frequency
 +-- Two Pointer
 +-- Sliding Window
 +-- KMP
 +-- Z Algorithm
 +-- Trie
 +-- Rolling Hash

Linked List
 |
 +-- Fast/Slow Pointer
 +-- Reversal
 +-- Merge
 +-- Cycle Detection

Stack
 |
 +-- Monotonic Stack
 +-- Expression
 +-- Next Greater
 +-- Histogram

Queue
 |
 +-- BFS
 +-- Sliding Window
 +-- Deque

Heap
 |
 +-- Top K
 +-- Scheduling
 +-- Median
 +-- Kth Element

Tree
 |
 +-- DFS
 +-- BFS
 +-- BST
 +-- LCA
 +-- Tree DP
 +-- Binary Lifting

Graph
 |
 +-- BFS
 +-- DFS
 +-- Dijkstra
 +-- Bellman-Ford
 +-- Floyd-Warshall
 +-- MST
 +-- DSU
 +-- Topological Sort
 +-- SCC
 +-- Bridges
 +-- Flow

DP
 |
 +-- 1D
 +-- 2D
 +-- Knapsack
 +-- Subsequence
 +-- Interval
 +-- Tree DP
 +-- Bitmask DP
 +-- Digit DP
```

---

# Chapter 79 — Complete Learning Sequence

Follow this exact sequence.

```text
PHASE 1 — FOUNDATION
│
├── Java for DSA
├── Complexity
├── Mathematics
└── Recursion
        ↓
PHASE 2 — LINEAR DATA STRUCTURES
│
├── Arrays
├── Strings
├── Linked List
├── Stack
├── Queue
└── Deque
        ↓
PHASE 3 — CORE ALGORITHMS
│
├── Searching
├── Sorting
├── Hashing
├── Two Pointers
├── Sliding Window
├── Prefix Sum
├── Difference Array
└── Bit Manipulation
        ↓
PHASE 4 — NON-LINEAR STRUCTURES
│
├── Binary Tree
├── BST
├── Heap
├── Trie
└── Graph
        ↓
PHASE 5 — CORE ALGORITHMS
│
├── BFS
├── DFS
├── Greedy
├── Backtracking
├── Shortest Path
├── MST
├── Topological Sort
└── DSU
        ↓
PHASE 6 — DYNAMIC PROGRAMMING
│
├── 1D DP
├── 2D DP
├── Knapsack
├── LCS
├── LIS
├── Interval DP
├── Tree DP
├── Bitmask DP
└── Digit DP
        ↓
PHASE 7 — ADVANCED DSA
│
├── Segment Tree
├── Fenwick Tree
├── AVL
├── Red-Black Tree
├── Binary Lifting
├── HLD
├── SCC
├── Bridges
├── Articulation Points
├── Flow
└── Advanced Strings
        ↓
PHASE 8 — COMPETITIVE PROGRAMMING
│
├── Number Theory
├── Combinatorics
├── Geometry
├── Game Theory
├── Advanced DP
├── Advanced Graphs
└── Advanced Data Structures
        ↓
PHASE 9 — MASTERY
│
├── Problem Patterns
├── Timed Practice
├── Contest Practice
├── Interview Problems
├── GATE Problems
└── Original Problem Solving
```

---

# Chapter 80 — Final DSA Master Checklist

## Foundations

* [ ] Algorithm
* [ ] Data structure
* [ ] Time complexity
* [ ] Space complexity
* [ ] Big O
* [ ] Big Ω
* [ ] Big Θ
* [ ] Recurrence relations
* [ ] Master theorem

## Arrays

* [ ] 1D arrays
* [ ] 2D arrays
* [ ] Prefix sum
* [ ] Difference array
* [ ] Kadane
* [ ] Rotation
* [ ] Partitioning

## Strings

* [ ] String
* [ ] StringBuilder
* [ ] Frequency
* [ ] Palindrome
* [ ] Anagram
* [ ] Pattern matching
* [ ] KMP
* [ ] Z algorithm
* [ ] Rolling hash
* [ ] Trie
* [ ] Suffix array

## Searching

* [ ] Linear search
* [ ] Binary search
* [ ] Lower bound
* [ ] Upper bound
* [ ] Binary search on answer

## Sorting

* [ ] Bubble
* [ ] Selection
* [ ] Insertion
* [ ] Merge
* [ ] Quick
* [ ] Heap
* [ ] Counting
* [ ] Radix
* [ ] Bucket

## Linked List

* [ ] Singly
* [ ] Doubly
* [ ] Circular
* [ ] Reverse
* [ ] Cycle
* [ ] Merge
* [ ] Intersection
* [ ] Fast/slow pointer

## Stack

* [ ] Stack implementation
* [ ] Monotonic stack
* [ ] Next greater
* [ ] Next smaller
* [ ] Histogram
* [ ] Expression conversion
* [ ] Expression evaluation

## Queue

* [ ] Queue
* [ ] Circular queue
* [ ] Deque
* [ ] Priority queue
* [ ] Monotonic queue

## Hashing

* [ ] Hash function
* [ ] Collision
* [ ] Chaining
* [ ] Open addressing
* [ ] HashMap
* [ ] HashSet

## Trees

* [ ] Binary tree
* [ ] Traversals
* [ ] BST
* [ ] Heap
* [ ] AVL
* [ ] Red-Black
* [ ] Trie

## Graphs

* [ ] Representation
* [ ] BFS
* [ ] DFS
* [ ] Cycle detection
* [ ] Bipartite
* [ ] Topological sort
* [ ] Dijkstra
* [ ] Bellman-Ford
* [ ] Floyd-Warshall
* [ ] Prim
* [ ] Kruskal
* [ ] DSU
* [ ] SCC
* [ ] Bridges
* [ ] Articulation points
* [ ] Euler
* [ ] Flow

## Greedy

* [ ] Activity selection
* [ ] Fractional knapsack
* [ ] Job sequencing
* [ ] Interval scheduling
* [ ] Huffman coding
* [ ] Jump game

## Backtracking

* [ ] Subsets
* [ ] Permutations
* [ ] Combinations
* [ ] N-Queens
* [ ] Sudoku
* [ ] Rat in maze
* [ ] Word search

## Dynamic Programming

* [ ] Memoization
* [ ] Tabulation
* [ ] 1D DP
* [ ] 2D DP
* [ ] Knapsack
* [ ] LCS
* [ ] LIS
* [ ] Edit distance
* [ ] Interval DP
* [ ] Tree DP
* [ ] Bitmask DP
* [ ] Digit DP
* [ ] DP optimization

## Advanced

* [ ] Segment Tree
* [ ] Fenwick Tree
* [ ] Binary Lifting
* [ ] HLD
* [ ] Mo's Algorithm
* [ ] Coordinate Compression
* [ ] Number Theory
* [ ] Combinatorics
* [ ] Geometry
* [ ] Game Theory
* [ ] Network Flow

---

# Final Goal

Do not measure DSA mastery only by the number of problems solved.

A strong DSA developer should be able to:

```text
Understand Problem
       ↓
Identify Data
       ↓
Choose Data Structure
       ↓
Choose Algorithm
       ↓
Prove Correctness
       ↓
Analyze Complexity
       ↓
Implement in Java
       ↓
Test Edge Cases
       ↓
Optimize
       ↓
Explain the Solution
```

## Target Skill Level

### Level 1 — Foundation

You can implement basic data structures and algorithms.

### Level 2 — Problem Solver

You can identify common patterns.

### Level 3 — Advanced

You can solve unfamiliar medium/hard problems.

### Level 4 — Competitive

You can combine multiple techniques.

### Level 5 — DSA Mastery

You can design efficient algorithms for problems you have never seen before.

---

# Recommended Rule

For every new DSA topic:

```text
THEORY
   ↓
VISUALIZE
   ↓
IMPLEMENT FROM SCRATCH
   ↓
ANALYZE COMPLEXITY
   ↓
BASIC PROBLEMS
   ↓
PATTERN PROBLEMS
   ↓
MEDIUM PROBLEMS
   ↓
HARD PROBLEMS
   ↓
REVISE
   ↓
REIMPLEMENT WITHOUT NOTES
```

**Do not skip implementation.**

For Java DSA, learn both:

```text
1. How the data structure/algorithm works internally
2. How to use Java's built-in implementation
```

For example, learn both:

```text
Custom Heap
       +
PriorityQueue
```

and:

```text
Custom HashMap
       +
HashMap
```

That combination gives you both **DSA fundamentals and practical Java development skills**.
