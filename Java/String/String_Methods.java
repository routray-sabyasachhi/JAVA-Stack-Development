public class String_Methods {
    public static void main(String[] args) {
        String fullName = "Sabyasachhi Routray";

        // 1
        System.out.println(fullName.length()); //19 return number of characters including space
        
        String nullString = "";
        System.out.println(nullString.length());
/*
        String s = null;
        System.out.println(s.length());  // can't invoke null length

        // time complexity : O(1) , because java stores the length internally


        */

        // method -> 2     { boolean isEmpty();} 
        //Time complexity : O(1)

        String s2 = "";
        String s3 = "   ";

        System.out.println(s2.isEmpty());
        System.out.println(s3.isEmpty());


        // method -> 3 { isBlank() }


    }
}
