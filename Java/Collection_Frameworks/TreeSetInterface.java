package Java.Collection_Frameworks;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetInterface {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        //Bydefault keep in sorted order
        // Not allow duplicate values bcz set always contain unique values

        set.add(35);
        set.add(-5);
        set.add(3);
        set.add(15);
        set.add(0);
        set.add(35);  // not affect to set

        System.out.println(set);  // [-5, 0, 3, 15, 35]

        Set<Integer> nums = new TreeSet<>(Comparator.reverseOrder());

        nums.add(35);
        nums.add(-5);
        nums.add(3);
        nums.add(15);
        nums.add(0);

        System.out.println(nums);
        System.out.println(nums.remove(-4)); // it searches the argument in set if found return true and remove that element
        System.out.println(nums);
         System.out.println(nums.remove(0)); // it searches the argument in set if found return true and remove that element
        System.out.println(nums);

    }
}
