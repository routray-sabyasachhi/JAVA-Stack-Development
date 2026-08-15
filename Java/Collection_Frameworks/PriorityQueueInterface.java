package Java.Collection_Frameworks;

import java.util.PriorityQueue;

public class PriorityQueueInterface {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(10);
        pq.offer(8);
        pq.offer(60);
        pq.offer(9);
        pq.offer(100);

        System.out.println(pq);  // 8, 9, 60, 10, 100  

        System.out.println(pq.poll());
        
        System.out.println(pq);   // 9, 10, 60, 100
        
    }
}
