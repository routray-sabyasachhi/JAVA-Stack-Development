package Java.Collection_Frameworks;

import java.util.LinkedList;

public class LinkedListInterface {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Sabya");
        list.add("");
        list.add("satya");
        System.out.println(list);

        /*

        o/p: [Sabya, , satya]
        
        */
    }
}
