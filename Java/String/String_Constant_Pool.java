public class String_Constant_Pool {
    public static void main(String[] args) {
        
        String s1 = "Java";
        String s2 = "Java";
        String s3 = "Java";
        /**
         * without optimization, java would create 3 separate String objects.
         * This is waste of memory
         * Instead, Java stores one copy and lets all variables refer to it.
         */
        System.out.println(s1 + s2 + s3);

        // SCP (String constant pool)
        /**
         * The String Constant Pool (SCP) is a special memory area inside the JVM where String literals are stored.
         * Its purpose is to reuse identical String literals to save memory.
         */

        // Memory diagram
        /**
         *String Constant Pool

        +----------------+
        |     "Java"     |
        +----------------+
          ▲      ▲      ▲
          │      │      │
         s1     s2     s3
         */

         // why is this efficient

         /**
          * without SCP :
          * 3*20 bytes = 60 bytes
          * with SCP:
          * 1*20 bytes = 20 bytes
          * 
          * Java saves 40 bytes from this above example.
          */

         String s4 = "Java";
         String s5 = new String("Java"); // it always create a new string object in thr heap.
         // Each new creates a different Heap object.

         System.out.println(s4 == s5); // false
         /**
          * 
String Pool

+---------+
| "Java"  |
+---------+
     ▲
     │
    s1

Heap

+---------+
| "Java"  |
+---------+
     ▲
     │
    s2


 Note : Pool object ≠ Heap object.   
          */

 /**
  * 
  * Note : 
  * 
  * prefer : String name = "Sabya";
  * bcz :
  * ->Reuse Existing objects.
  * ->Saves memory.
  * ->Faster than creating unnecessary objects.
  * Recomended for most situations.
  * 
  */
 /*
Step 1:
Java checks whether "Java" already exists
inside the String Constant Pool.

Step 2:
If it does not exist,
Java first creates it in the SCP.

Step 3:
Java then creates another object in the Heap
because of the new keyword.


String Pool

+---------+
| "Java"  |
+---------+

Heap

+---------+
| "Java"  | ← s1
+---------+

+---------+
| "Java"  | ← s2
+---------+
*/


String lang = "Java";

lang = lang.concat("Programming");  // now lang refers to new object "Java Programming".


/*
Why Did Java Make String Immutable ?


1. Security

Strings are used for:

Passwords
Database URLs
File paths
Network addresses

If Strings were mutable, one part of a program could unexpectedly change values used by another part.

2. String Pool

If one shared String literal could be modified, every reference would see the change.

Example:

String s1 = "Java";
String s2 = "Java";

If Strings were mutable:

s1 = s1.replace("Java", "Python");

The original "Java" object isn't modified. Instead, a new "Python" object is created.

This keeps s2 safely referring to "Java".

3. Thread Safety

Multiple threads can safely share immutable Strings because no thread can change the object.

4. Hashing

Strings are commonly used as keys in collections like HashMap.

If a String key could change after insertion, lookups would become unreliable.
*/

    }
}
