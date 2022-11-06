import java.util.*;

public class PriorityQueueDemo {

    // Main Method
    public static void main(String[] args)
    {
        // Creating empty priority queue
        // with custom Comparator
        PriorityQueue<Integer> pQueue
                = new PriorityQueue<Integer>(
                new Comparator<Integer>() {

                    // Compare method for place element in
                    // reverse order
                    public int compare(Integer a, Integer b)
                    {
                        if (a < b)
                            return 1;
                        if (a > b)
                            return -1;
                        return 0;
                    }
                });

        // Adding items to the pQueue using add()
        pQueue.add(10);
        pQueue.add(15);
        pQueue.add(20);
        pQueue.add(5);

        // Printing the top element of PriorityQueue
        System.out.println(pQueue.peek());

        // Printing the top element and removing it
        // from the PriorityQueue container
        System.out.println(pQueue.poll());

        // Printing the top element again
        System.out.println(pQueue.peek());
    }
}