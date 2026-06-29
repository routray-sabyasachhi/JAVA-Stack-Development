public class String_Class {
    public static void main(String[] args) {
        /**
         * -> String belongs to java.lang package.
         * -> java.lang package is imported automatically, so we don't need write.
         * -> Java provides a special syntax called a String Literals for convenience.
         */

        // How do we know String is a class

        String language = "Java";
        System.out.println(language.length());
        System.out.println(language.toUpperCase());
        System.out.println(language.charAt(1));

        /**
         * from above example method call proves that String is a class
         * 
         * int x = 10;
         * x.length();  // which is invalid
         * int can't fuction call because it is a primitive type
         */

        // below proof

        System.out.println(language.getClass());   // o/p: class java.lang.String
        System.out.println(language.getBytes());


        //      Primitive              v/s         String
        /**
         *   int, char, boolen                     String
         *   Stores value directly                 Stores a reference to an object
         *  No methods                             Many methods
         * Fixed size                              Variable length
         * Not an object                           Object
         */

        // Note: Java supports string literals, special language feature that creates that creates or reuses String objects in the String constant pool

    }
}
