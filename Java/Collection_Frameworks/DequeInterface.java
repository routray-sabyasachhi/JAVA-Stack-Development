package Java.Collection_Frameworks;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeInterface {
    public static void main(String[] args) {
        
        Deque<Character> deque = new ArrayDeque<>();

        // DEque :-> Double Ended Queue

        deque.addFirst('A');
        deque.addFirst('B');
        deque.addLast('C');

        System.out.println(deque);
    }
}
