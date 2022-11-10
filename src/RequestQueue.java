
public class RequestQueue {
    private static int front;
    private static int rear;
    static int capacity;
    private static Object queue[];

    //Create an object in java

    RequestQueue(int size) {
        front = rear = 0;
        capacity = size;
        queue = new Object[capacity];
    }

    // insert an element into the queue
    static void queueEnqueue(Object item) {
        // check if the queue is full
        if (capacity == rear) {
            System.out.printf("\nQueue is full\n");
            return;
        }

        // insert element at the rear
        else {
            queue[rear] = item;
            rear++;
        }
        return;
    }

    //remove an element from the queue
    static void queueDequeue() {
        // check if queue is empty
        if (front == rear) {
            System.out.printf("\nQueue is empty\n");
            return;
        }

        // shift elements to the right by one place uptil rear
        else {
            for (int i = 0; i < rear - 1; i++) {
                queue[i] = queue[i + 1];
            }


            // set queue[rear] to 0
            if (rear < capacity)
                queue[rear] = 0;

            // decrement rear
            rear--;
        }
        return;
    }

    // print queue elements
    static void queueDisplay() {
        int i;
        if (front == rear) {
            System.out.println("Queue is Empty\n");
            return;
        }

        // traverse front to rear and print elements
        for (i = front; i < rear; i++) {
            System.out.print(queue[i] + ",");
        }
        System.out.println();
        return;
    }


    // print front of queue
    static void queueFront() {
        if (front == rear) {
            System.out.println("Queue is Empty\n");
            return;
        }
        System.out.printf("\nFront Element of the queue: %d", queue[front]);
        return;
    }

    static Request peek() {
        System.out.println("The first element in the queue is :" + queue[0]);
        return (Request) queue[0];
    }

    static int remove() {
        int key = 0;

        // check if queue is empty
        if (front == rear) {
            System.out.printf("\nQueue is empty\n");
            return key;
        }

        // shift elements to the right by one place uptil rear
        else {
            key = (int) queue[0];
            for (int i = 0; i < rear - 1; i++) {

                queue[i] = queue[i + 1];
            }

            // set queue[rear] to 0
            if (rear < capacity)
                queue[rear] = 0;

            // decrement rear
            rear--;
        }
        return key;
    }

    static Request[] giveQueue() {
        int i;
        Request[] queueRequest = new Request[capacity];
        if (front == rear) {
            System.out.println("Queue is Empty\n");
            return queueRequest;
        }


        // traverse front to rear and print elements
        for (i = front; i < rear; i++) {
            queueRequest[i] = (Request) queue[i];
        }

        return queueRequest;

    }


}