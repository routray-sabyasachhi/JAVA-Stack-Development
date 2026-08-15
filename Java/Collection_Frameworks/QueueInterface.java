package Java.Collection_Frameworks;

import java.util.LinkedList;
import java.util.Queue;

public class QueueInterface {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(5);
        queue.add(15);
        queue.add(25);
        queue.add(35);
        queue.add(45);
        queue.add(55);
        queue.offer(65);
        queue.add(null);

        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.element());
        System.out.println(queue.remove());
        System.out.println(queue.poll());

        System.out.println(queue);



    }
}
