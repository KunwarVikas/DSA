package queue;

class MyQueue {
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    MyQueue(int size) {
        arr = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
        this.size = 0;
    }

    /**
     * dequeue from queue
     */
    public void dequeue() {
        // check for queue underflow
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Removing " + arr[front]);
        front = (front + 1) % capacity;
        size--;
    }

    /**
     * enqueue an item to the queue
     * @param item
     */
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        System.out.println("Enqueuing " + item);
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        size++;
    }

    /**
     * @return the size of the queue
     */
    public int size() {
        return size;
    }

    /**
     * checks if queue is empty
     * @return
     */
    public Boolean isEmpty() {
        return (size() == 0);
    }

    /**
     * check if queue is full
     * @return
     */
    public Boolean isFull() {
        return (size() == capacity);
    }

    /**
     * main method
     * @param args
     */
    public static void main(String[] args) {
        // create a queue of capacity 5
        MyQueue queue = new MyQueue(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        queue.dequeue();
        System.out.println("The queue size is " + queue.size());

        queue.dequeue();
        queue.dequeue();

        if (queue.isEmpty()) {
            System.out.println("The queue is empty");
        } else {
            System.out.println("The queue is not empty");
        }
    }
}