/**
 * Represents a generic tree node with data of type E.
 *
 * @param <E> The type of data stored in the node.
 */
public class Node<E> {
    private E data;
    private Node<E> parent;
    private Node<E>[] children;

    /**
     * Constructs a new Node with the given data.
     *
     * @param data The data to be stored in the node.
     */
    public Node(E data) {
        this.data = data;
        this.parent = null;
        this.children = new Node[0];
    }

    /**
     * Gets the data stored in the node.
     *
     * @return The data stored in the node.
     */
    public E getData() {
        return data;
    }

    /**
     * Gets the parent node of the current node.
     *
     * @return The parent node, or null if the node has no parent.
     */
    public Node<E> getParent() {
        return parent;
    }

    /**
     * Gets an array of child nodes of the current node.
     *
     * @return An array of child nodes.
     */
    public Node<E>[] getChildren() {
        return children;
    }

    /**
     * Adds a child node to the current node.
     *
     * @param child The child node to be added.
     */
    public void addChild(Node<E> child) {
        child.parent = this;
        Node<E>[] newChildren = new Node[children.length + 1];
        System.arraycopy(children, 0, newChildren, 0, children.length);
        newChildren[children.length] = child;
        children = newChildren;
    }
}
