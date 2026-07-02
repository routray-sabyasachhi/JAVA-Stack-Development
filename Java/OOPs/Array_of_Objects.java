package Java.OOPs;

// Student is a user-defined class.
// It works like a blueprint for creating student objects.
class Student {
    // Instance variables: every Student object gets its own copy of these fields.
    int rollno;
    String name;
    double marks;
}

public class Array_of_Objects {
    public static void main(String[] args) {
        // This creates an array that can store references of 2 Student objects.
        // Important: it creates only the array, not the actual Student objects.
        Student[] students = new Student[2];

        // Create the first Student object using the new keyword.
        Student s1 = new Student();
        // Store data inside the first object's instance variables.
        s1.rollno = 34;
        s1.name = "sabya";
        s1.marks = 8.63;
        // Store the reference of the first Student object at index 0.
        students[0] = s1;

        // Create the second Student object.
        Student s2 = new Student();
        // Store data inside the second object's instance variables.
        s2.rollno = 36;
        s2.name = "satya";
        s2.marks = 8.93;
        // Store the reference of the second Student object at index 1.
        students[1] = s2;

        // Access object data through the array index and dot operator.
        System.out.println(students[0].name + " : " + students[0].marks);
        System.out.println(students[1].name + " : " + students[1].marks);
    }
}

/*
Theory and Concepts
-------------------

1. Class
   A class is a blueprint or template. Here, Student is a class that defines
   what data a student object can store: rollno, name, and marks.

2. Object
   An object is a real instance of a class. In this program, s1 and s2 are
   Student objects created using the new keyword.

3. Instance Variables
   The variables rollno, name, and marks are instance variables. Each Student
   object has separate values for these variables.

4. Array of Objects
   Student[] students = new Student[2]; creates an array that can hold 2
   Student object references. The array does not create Student objects by
   itself. Each object must be created separately using new Student().

5. Reference Variable
   Variables like s1, s2, and students[0] do not directly store the full object.
   They store a reference, which points to the object in memory.

6. new Keyword
   The new keyword creates an object in heap memory and returns its reference.
   Example: Student s1 = new Student();

7. Dot Operator
   The dot operator is used to access fields and methods of an object.
   Example: s1.name accesses the name field of the s1 object.

8. Array Indexing
   Array positions start from 0. In this program:
   students[0] stores the first Student object.
   students[1] stores the second Student object.

9. Memory Concept
   The students array stores references. The actual Student objects are stored
   separately in heap memory.

10. Program Flow
   First, the Student array is created. Then two Student objects are created.
   Their data is assigned, their references are stored in the array, and finally
   their name and marks values are printed.
*/
