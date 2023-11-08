import java.util.Iterator;
import java.util.NoSuchElementException;

/** Implementation of a positional list stored as a doubly linked list. */
public class LinkedPositionalList<E> implements PositionalList{
    /*----------Nested Node Class-------------------*/
    private static class Node<E> implements Position<E> {
        private E element;          // reference to the element stored at this node
        private Node<E> prev;       // reference to the previous node in the list
        private Node<E> next;       // reference to the subsequent node in the list

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public E getElement() throws IllegalStateException {
            try {
                if (next == null) {
                    throw new IllegalStateException("Position no longer valid");
                }
            }
            catch (IllegalStateException e) {
                System.out.println("Error: " + e);
            }
            return element;
        }
    }

    // instance variables of the LinkedPositionalList
    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    /** Constructs a new empty list. */
    public LinkedPositionalList() {
        header = new Node<E>(null, null, null);     // create header
        trailer = new Node<E>(null, header, null);       // trailer is preceded by header
        header.next = trailer;
        size = 0;
    }

    // public accessor methods
    /** Returns the number of elements in the linked list. */
    public int size() {
        return size;
    }

    /** Tests whether the linked list is empty. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Returns the first Position in the linked list (or null, if empty). */
    public Position<E> first() {
        if (isEmpty()) return null;
        return header.next;
    }

    /** Returns the last Position in the list (or null, if empty). */
    public Position<E> last() {
        if (isEmpty()) return null;
        return trailer.prev;
    }

    /** Returns the Position immediately before Position p (or null, if p is first). */
    public Position<E> before(Position p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.prev;
    }

    /** Returns the Position immediately after Position p (or null, if p is last). */
    public Position<E> after(Position p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.next;
    }

    /** Inserts element e at the front of the list and returns its new Position. */
    public Position<E> addFirst(Object e) {
        return addBetween((E) e, header, header.next);
    }

    /** Inserts element e at the back of the list and returns its new Position. */
    public Position<E> addLast(Object e) {
        return addBetween((E) e, trailer.prev, trailer);
    }

    /** Inserts element e immediately before Position p and returns its new Position. */
    public Position<E> addBefore(Position p, Object e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween((E) e, node.prev, node);
    }

    /** Inserts element e immediately after Position p and returns its new Position. */
    public Position<E> addAfter(Position p, Object e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween((E) e, node, node.next);
    }

    /** Replaces the element stored at Position p and returns the replaced element. */
    public E set(Position p, Object e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E oldValue = node.element;
        node.element = (E) e;
        return oldValue;
    }

    /** Removes the element stored at Position p and returns it (invalidating p). */
    public E remove(Position p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> prev = validate(p);
        Node<E> next = validate(p);
        prev.next = next;
        next.prev = prev;
        size--;
        E element = node.element;
        node.prev = null;
        node.next = null;
        trailer = trailer.prev;
        return element;
    }

    // private utilities
    /** Adds elements e to the linked list between the given nodes. */
    private Position<E> addBetween(E e, Node<E> prev, Node<E> next) {
        Node<E> newNode = new Node<>(e, prev, next);
        prev.next = newNode;
        next.prev = newNode;
        size++;
        return newNode;
    }

    /** Validates the position and returns it as a node. */
    private Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("Invalid position");
        }
        Node<E> node = (Node<E>) p;
        if (node.next == null) {
            throw new IllegalArgumentException("Position is no longer in the list");
        }
        return node;
    }

    public Iterator<E> iterator() {
        return new PositionalListIterator();
    }

    private class PositionalListIterator implements Iterator<E> {
        private Position<E> current = first();

        public boolean hasNext() {
            return current != null;
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the list.");
            }
            E element = current.getElement();
            current = after(current);
            return element;
        }
    }

    public Position<E> getPosition(E e)
    {
        Position<E> x = first();
        while(x.getElement()!=e)
        {
            x = after(x);
        }
        return x;
    }
    public void display()
    {
        Node<E> currNode = header.next;
        System.out.print("Head <- -> ");
        while(currNode!=trailer)
        {
            System.out.print(currNode.getElement()+"<- ->");
            currNode=currNode.next;
        }
        System.out.println("Tail");
    }
}
