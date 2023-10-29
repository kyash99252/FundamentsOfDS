/**
 * The `GenericQueue` class represents a first-in-first-out (FIFO) queue of
 * elements of generic type `E`.
 * It supports the usual enqueue and dequeue operations, along with methods for
 * peeking at the front element,
 * testing if the queue is empty, and testing if the queue is full.
 *
 * This implementation uses an array to store elements. When a new element is
 * added to the queue,
 * it is added to the rear of the array. When an element is removed from the
 * queue, it is removed from
 * the front of the array. The size of the array is fixed when the queue is
 * created and cannot be changed.
 *
 * @param <E> the type of elements in this queue
 */
public class GenericQueue<E> {
    private final E[] elements;
    private int front;
    private int rear;
    private int size;

    /**
     * Initializes an empty queue with a specified capacity.
     *
     * @param capacity the maximum number of elements that can be stored in this
     *                 queue
     */
    public GenericQueue(int capacity) {
        elements = (E[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    /**
     * Adds an element to the rear of this queue.
     *
     * @param item the element to add
     * @throws IndexOutOfBoundsException if this queue is full
     */
    public void enqueue(E item) {
        try {
            rear++;
            if (!isFull()) {
                elements[rear % elements.length] = item;
                size++;
            } else {
                throw new IndexOutOfBoundsException("Error: Queue is full");
            }
        } catch (IndexOutOfBoundsException e) {
            // Handle the exception.
            System.out.println(e.getMessage());
        }
    }

    /**
     * Removes and returns the element at the front of this queue.
     *
     * @return the element at the front of this queue
     * @throws IndexOutOfBoundsException if this queue is empty
     */
    public E dequeue() {
        try {
            if (isEmpty()) {
                throw new IndexOutOfBoundsException("Queue is Empty");
            }
            front++;
            size--;
            return elements[front - 1];
        } catch (IndexOutOfBoundsException e) {
            // Handle the exception.
            System.out.println("An error occurred: " + e.getMessage());
            return null;
        }
    }

    /**
     * Returns the element at the front of this queue without removing it.
     *
     * @return the element at the front of this queue
     */
    public E peek() {
        return elements[front];
    }

    /**
     * Returns `true` if queue contains no elements.
     *
     * @return `true` if queue contains no elements; `false` otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns `true` if queue is full.
     *
     * @return `true` if queue is full; `false` otherwise
     */
    public boolean isFull() {
        return size >= elements.length;
    }

    /**
     * Returns the number of elements in this queue.
     *
     * @return the number of elements in this queue
     */
    public int size() {
        return size;
    }
}