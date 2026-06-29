//package Java.String;

public class String_Basics {
    public static void main(String[] args) {

        // Introduction
        /**
         * String is a class provided by java
         * actually String create an object of the String class
         */

        String name = "Sabyasachhi"; // value can't be changed (im-mutable)
        String nums = "5034"; 
        //Although it contains digits, it is still a string because it is  enclosed in double quotes.

        System.out.println(name);
        System.out.println(nums+25); // " + " treated as concatenation

        // way of creating Java String

        //type 1
        String course = "DSA"; // string literals is stored int he string constant pool(SCP).
        System.out.println(course);

        //type 2
        String lastname = new String("Routray"); // memory allocated in heap area using " new " keyword
        System.out.println(lastname);

        //memory layout
        /**
         * 
         * +----------------+
           |     "Java"     |
           +----------------+
                    ▲
                    |
                language

                explanation: The variable language refers to the string object containing "java".

         */


        // Immutable checking

        // case 1

        String str = "Hello";
        str.concat("World");
        System.out.println(str);  // o/p: Hello
        System.out.println(str.concat(" sabya"));   // in concat new object will be created but the original one remain same
        
        // case 2
        String language = "Java"; // the original string "java exists"
        language = "Python";
        // in above new string object "Python created and language now points to Python
        System.out.println(language);

        // single Quote ' ' is use only for char

        String brand =  "Routray";
        String surname = new String("Routray");

        //Interview questions
        System.out.println(brand == surname); // false
        System.out.println(brand.equals(surname)); // true

        //----------------------------//
        //    Practice questions     //
        //--------------------------//


        // Q1.
        String s1 = "Java";
        String s2 = "Java";
        System.out.println(s1 == s2); // true
        // aboove is true bcz s1 and s2 points to same string literal "Java" in orginally Java is one copy

        //Q2.
        String s3 = new String("Python");
        String s4 = new String("Python");

System.out.println(s3 == s4); // false in pool they crate separate copy of python

String s5 = "JS";
String s6 = new String("JS");
System.out.println(s5 == s6); // == compares object references (memory addresses) between heap object-1 and heap object-2
System.out.println(s5.equals(s6)); // equals() compares the contents (sequence of characters)


//Q3
String s7 = "Java";
String s8 = "Ja" + "va";

System.out.println(s7 == s8); //true

    }
}
