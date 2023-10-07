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
//        if (isFull()) throw new IndexOutOfBoundsException("Error: Queue is full");
        if (front != rear % elements.length || rear == 0) {
            elements[rear % elements.length] = item;
        }
        else {
            throw new IndexOutOfBoundsException("Error: Queue is full");
        }
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
        return size() >= elements.length;
    }

    public int size() {
        if (front == (rear % elements.length) + 1) {
            return 0;
        }
        else if (rear < elements.length && front == 0) {
            return rear + 1;
        }
        else {
            int temp = front - (rear % elements.length);
            if (temp <= 0) {
                return Math.abs(temp - 1);
            }
            return elements.length + 1 - temp;
        }
    }
}
