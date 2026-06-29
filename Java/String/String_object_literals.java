public class String_object_literals {
    public static void main(String[] args) {
        /**
         * String object is an object of string class.
         * In below example:
         * 
         * String -> Class
         * new -> Creates a new object
         * "Sabya" -> String literal
         * name -> Reference variable
         */

        String name = new String("Sabya");
        System.out.println(name);

        String a = "Java";
        String b = "Java";
        System.out.println(a == b); //true

        String c = new String("Java");
        String d = new String("Java");
        System.out.println(c == d); // false

        String e = new String("Java");
        String f = "Java";
        System.out.println(e == f);   //false


    }
}
