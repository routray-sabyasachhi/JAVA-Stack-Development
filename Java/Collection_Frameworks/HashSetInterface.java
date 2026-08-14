package Java.Collection_Frameworks;

import java.util.HashSet;

public class HashSetInterface {
    public static void main(String[] args) {
        // Creating a HashSet
        HashSet<String> set = new HashSet<>();

        // Adding elements to the HashSet
        set.add("Apple");
        set.add("Banana");
        set.add("Orange");
        set.add("Mango");
        set.add("Grapes");

        // Displaying the HashSet
        System.out.println("HashSet: " + set);

        // Checking if an element exists
        if (set.contains("Banana")) {
            System.out.println("Banana is present in the HashSet.");
        } else {
            System.out.println("Banana is not present in the HashSet.");
        }

        // Removing an element
        set.remove("Mango");
        System.out.println("After removing Mango: " + set);

        // Iterating through the HashSet
        System.out.println("Iterating through the HashSet:");
        for (String fruit : set) {
            System.out.println(fruit);
        }

        // Getting the size of the HashSet
        System.out.println("Size of the HashSet: " + set.size());

        // Clearing the HashSet
        set.clear();
        System.out.println("After clearing, HashSet: " + set);
    }
}