package Lab_VII;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a class for a node which holds an element of type E.
 *
 * @param <E> the type of element held by this node
 */
class Node<E> implements Position<E> {
    public E element;
    public Node<E> parent;
    public List<Position<E>> children = new ArrayList<>();

    /**
     * Constructor for creating a new node.
     */
    public Node() {
    }

    /**
     * Constructor for creating a new node with an element and parent.
     *
     * @param e the element to be held by this node
     * @param p the parent of this node
     */
    public Node(E e, Node<E> p) {
        element = e;
        parent = p;
    }

    /**
     * Returns the element held by this node.
     *
     * @return the element held by this node
     */
    public E getElement() {
        return element;
    }

    /**
     * Returns the parent of this node.
     *
     * @return the parent of this node
     */
    public Node<E> getParent() {
        return parent;
    }

    /**
     * Returns the children of this node.
     *
     * @return the children of this node
     */
    public List<Position<E>> getchildren() {
        return children;
    }

    /**
     * Sets the element of this node.
     *
     * @param e the element to be set
     */
    public void setElement(E e) {
        element = e;
    }

    /**
     * Sets the parent of this node.
     *
     * @param parentNode the parent to be set
     */
    public void setParent(Node<E> parentNode) {
        parent = parentNode;
    }
}

/**
 * This is a class for a linked tree which holds elements of type E.
 *
 * @param <E> the type of elements held by this tree
 */
public class LinkedTree<E> extends AbstractTree<E> {
    protected Node<E> root = null; // root of the tree
    private int size = 0; // number of nodes in the tree
    int firstcall = 0;

    /**
     * Constructor for creating a new linked tree.
     */
    public LinkedTree() {
    }

    /**
     * Validates the position and returns it as a node.
     *
     * @param p the position to be validated
     * @return the node of the position
     * @throws IllegalArgumentException if the position is not valid
     */
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) throw new IllegalArgumentException("Not valid position type");
        Node<E> node = (Node<E>) p; // safe cast
        if (node.getParent() == node) // our convention for defunct node
            throw new IllegalArgumentException("p is no longer in the tree");
        return node;
    }

    /**
     * Returns the size of the tree.
     *
     * @return the size of the tree
     */
    public int size() {
        return size;
    }

    /**
     * Returns the root of the tree.
     *
     * @return the root of the tree
     */
    public Position<E> root() {
        return root;
    }

    /**
     * Returns the parent of the position in the tree.
     *
     * @param p the position
     * @return the parent of the position
     * @throws IllegalArgumentException if the position is not valid
     */
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }

    /**
     * Creates a new node with an element and parent.
     *
     * @param e the element to be held by the node
     * @param p the parent of the node
     * @return the new node
     */
    public Node<E> createNode(E e, Node<E> p) {
        Node<E> node = new Node<>(e, p);
        firstcall++;
        return node;
    }

    /**
     * Adds a root to the tree.
     *
     * @param n the node to be added as root
     */
    public void addRoot(Node<E> n) {
        root = n;
    }

    /**
     * Adds a child to a node in the tree.
     *
     * @param n the node to which a child is to be added
     * @param c the child to be added
     */
    public void addChild(Node<E> n, Node<E> c) { // c will be child of n
        Position<E> pos = (Position<E>) c;
        n.children.add(pos);
    }

    /**
     * Returns the children of the position in the tree.
     *
     * @param p the position
     * @return the children of the position
     * @throws IllegalArgumentException if the position is not valid
     */
    public Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getchildren();
    }

    /**
     * Returns the number of children of the position in the tree.
     *
     * @param p the position
     * @return the number of children of the position
     * @throws IllegalArgumentException if the position is not valid
     */
    public int numChildren(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getchildren().size();
    }

    /**
     * Prints the elements of the tree in preorder with indentation.
     *
     * @param T the tree
     * @param p the position
     * @param d the depth
     */
    public void printPreorderIndent(Tree<E> T, Position<E> p, int d) {
        for (int i = 1; i <= d; i++) {
            System.out.print("  ");
        }
        System.out.print(p.getElement()); // indent based on d
        System.out.println();
        for (Position<E> c : T.children(p)) {
            printPreorderIndent(T, c, d + 1); // child depth is d+1
        }
    }

    /**
     * Prints the elements of the tree in preorder with labels.
     *
     * @param T the tree
     * @param p the position
     * @param path the path
     */
    public void printPreorderLabeled(Tree<E> T, Position<E> p, ArrayList<Integer> path) {
        int d = path.size();
        for (int i = 1; i <= d; i++) {
            System.out.print("  ");
        }
        for (int j = 0; j < d; j++) System.out.print(path.get(j) + (j == d - 1 ? " " : "."));
        System.out.println(p.getElement());
        path.add(1);
        for (Position<E> c : T.children(p)) {
            printPreorderLabeled(T, c, path);
            path.set(d, 1 + path.get(d));
        }
        path.remove(d);
    }

    /**
     * Returns the disk space used by the tree.
     *
     * @param T the tree
     * @param p the position
     * @return the disk space used by the tree
     */
    public static int diskSpace(Tree<Integer> T, Position<Integer> p) {
        int subtotal = p.getElement(); // we assume element represents space usage
        for (Position<Integer> c : T.children(p))
            subtotal += diskSpace(T, c);
        return subtotal;
    }
}

