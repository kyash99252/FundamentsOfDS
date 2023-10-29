/**
 * The `GenericStack` class represents a last-in-first-out (LIFO) stack of
 * elements of generic type `E`.
 * It supports the usual push and pop operations, along with methods for peeking
 * at the top element,
 * testing if the stack is empty, and testing if the stack is full.
 *
 * This implementation uses an array to store elements. When a new element is
 * added to the stack,
 * it is added to the top of the array. When an element is removed from the
 * stack, it is removed from
 * the top of the array. The size of the array is fixed when the stack is
 * created and cannot be changed.
 *
 * @param <E> the type of elements in this stack
 */
public class GenericStack<E> {
    private final E[] elements;
    private int top;

    /**
     * Initializes an empty stack with a specified capacity.
     *
     * @param capacity the maximum number of elements that can be stored in this
     *                 stack
     */
    public GenericStack(int capacity) {
        elements = (E[]) new Object[capacity];
        top = -1;
    }

    /**
     * Adds an element to the top of this stack.
     *
     * @param item the element to add
     * @throws IndexOutOfBoundsException if this stack is full
     */
    public void push(E item) {
        try {
            if (top + 1== elements.length) {
                throw new IndexOutOfBoundsException("Stack is Full");
            }
            top++;
            elements[top] = item;
        } catch (IndexOutOfBoundsException e) {
            // Handle the exception.
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    /**
     * Removes and returns the element at the top of this stack.
     *
     * @return the element at the top of this stack
     * @throws IndexOutOfBoundsException if this stack is empty
     */
    public E pop() {
        try {
            if (isEmpty()) {
                throw new IndexOutOfBoundsException("Stack is Empty");
            }
            E item = elements[top];
            top--;
            return item;
        } catch (IndexOutOfBoundsException e) {
            // Handle the exception.
            System.out.println("An error occurred: " + e.getMessage());
            return null;
        }
    }

    /**
     * Returns the element at the top of this stack without removing it.
     *
     * @return the element at the top of this stack
     */
    public E peek() {
        return elements[top];
    }

    /**
     * Returns `true` if this stack contains no elements.
     *
     * @return `true` if this stack contains no elements; `false` otherwise
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * Returns `true` if this stack is full.
     *
     * @return `true` if this stack is full; `false` otherwise
     */
    public boolean isFull() {
        return top == elements.length - 1;
    }

    /**
     * Returns the number of elements in this stack.
     *
     * @return the number of elements in this stack
     */
    public int size() {
        return top + 1;
    }
}
