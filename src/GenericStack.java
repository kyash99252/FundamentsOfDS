public class GenericStack<E> {
    private final E[] elements;
    private int top;

    public GenericStack(int capacity){
        elements = (E[]) new Object[capacity];
        top = -1;
    }

    public void push(E item) {
        top++;
        if (top == elements.length) {
            throw new IndexOutOfBoundsException("Stack is Full");
        }
        elements[top] = item;
    }

    public E pop() {
        top--;
        return elements[top + 1];
    }

    public E peek() {
        return elements[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == elements.length - 1;
    }

    public int size() {return top + 1; }
}
