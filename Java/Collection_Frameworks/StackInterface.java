package Java.Collection_Frameworks;

import java.util.Stack;   // LIFO  structure
import java.util.ArrayDeque;
import java.util.Deque;

public class StackInterface {
    public static void main(String[] args) {
        Stack<Integer> nums = new Stack<>();
        nums.push(10);
        nums.push(20);

        System.out.println(nums);
        System.out.println(nums.get(1));
        System.out.println(nums.pop());
        System.out.println(nums);

        Deque<Float> decimal = new ArrayDeque<>();

        decimal.push(15f);

        System.out.println(decimal);
    }
}
