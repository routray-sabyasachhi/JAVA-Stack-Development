package Java.Collection_Frameworks;

import java.util.LinkedHashSet;

public class LinkedHashSetInterface {
    public static void main(String[] args) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        set.add(5);
        set.add(10);
        set.add(15);
        set.add(20);
        System.out.println("LinkedHashSet: " + set);

        set.remove(set.toArray()[1]);
        System.out.println("After removing element at index 1: " + set);

        set.add(85);
        System.out.println("After adding 85: " + set);
        set.hashCode();
        System.out.println("Hash code of the LinkedHashSet: " + set.hashCode());
        /* how hashcode is calculated
         * The hash code of a LinkedHashSet is calculated based on the hash codes of its elements and their order.
         *example: 31 * 1 + 31 * 2 + 31 * 3 = 124
         */
    }
}
