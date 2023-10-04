public class GenericQueue<E> {
    private final E[] elements;
    private int front;
    private int rear;

    public GenericQueue(int capacity) {
        elements = (E[]) new Object[capacity];
        front = 0;
        rear = -1;
    }

    public void enqueue(E item) {
        rear++;
        if (isFull()) throw new IndexOutOfBoundsException("Error: Queue is full");
        elements[rear] = item;
    }

    public E dequeue() {
        if (isEmpty()) System.out.println("Queue is Empty");
        front++;
        return elements[front - 1];
    }

    public E peek() {
        return elements[front];
    }

    public boolean isEmpty() {
        return front == 0 && rear == -1;
    }

    public boolean isFull() {
        return front == 0 && rear == elements.length - 1;
    }
}
