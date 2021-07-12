package stack;

class MyStack
{
    private int arr[];
    private int top;
    private int capacity;

    MyStack(int size)
    {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    /**
     *
     * @param item
     */
    public void push(int item)
    {
        if (isFull())
        {
            System.out.println("Stack is full\n");
            return;
        }
        System.out.println("Inserting " + item);
        arr[++top] = item;
    }

    /**
     *
     * @return
     */
    public int pop()
    {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        System.out.println("Popping top element");
        return arr[top--];
    }

    /**
     * returns the size of stack
     * @return
     */
    public int size() {
        return top + 1;
    }

    /**
     * checks is stack is empty
     * @return
     */
    public Boolean isEmpty() {
        return size() == 0;
    }

    /**
     * checks if stack is full
     * @return
     */
    public Boolean isFull() {
        return size() == capacity;
    }

    public static void main (String[] args) {
        MyStack stack = new MyStack(3);

        stack.push(1);
        stack.push(2);
        stack.pop();
        stack.pop();
        stack.push(3);

        System.out.println("The stack size is " + stack.size());
        stack.pop();
        // check if the stack is empty
        if (stack.isEmpty()) {
            System.out.println("The stack is empty");
        } else {
            System.out.println("The stack is not empty");
        }
    }
}
