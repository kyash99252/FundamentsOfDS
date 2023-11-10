/**
 * Represents a generic tree data structure with nodes of type E.
 *
 * @param <E> The type of data stored in the tree nodes.
 */
public class Tree<E> {
    /**
     * The root node of the tree.
     */
    public Node<E> root;

    /**
     * Constructs a new tree with the specified root data.
     *
     * @param rootData The data for the root node.
     */
    public Tree(E rootData) {
        root = new Node<>(rootData);
    }

    /**
     * Displays the tree using a recursive traversal, starting from the root.
     */
    public void displayTree() {
        displayNode(root, 0);
    }

    private void displayNode(Node<E> node, int depth) {
        StringBuilder indentation = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            indentation.append("  ");
        }
        System.out.println(indentation.append(node.getData()));

        for (Node<E> child : node.getChildren()) {
            displayNode(child, depth + 1);
        }
    }

    /**
     * Finds siblings of a given node.
     *
     * @param node The node whose siblings are to be found.
     * @return An array of sibling nodes.
     */
    public Node[] findSiblings(Node node) {
        if (node.getParent() == null) {
            return new Node[0]; // Root node has no siblings
        }

        Node parent = node.getParent();
        Node[] siblings = new Node[parent.getChildren().length - 1];
        int index = 0;
        for (Node child : parent.getChildren()) {
            if (child != node) {
                siblings[index] = child;
                index++;
            }
        }

        return siblings;
    }

    /**
     * Lists the leaves of the tree.
     */
    public void listLeaves() {
        listLeaves(root);
    }

    private void listLeaves(Node node) {
        if (node.getChildren().length == 0) {
            System.out.print(node.getData() + " ");
        }

        for (Node child : node.getChildren()) {
            listLeaves(child);
        }
    }

    /**
     * Lists the internal nodes of the tree.
     */
    public void listInternalNodes() {
        listInternalNodes(root);
    }

    private void listInternalNodes(Node node) {
        if (node != root && node.getChildren().length > 0) {
            System.out.print(node.getData() + " ");
        }

        for (Node child : node.getChildren()) {
            listInternalNodes(child);
        }
    }

    /**
     * Lists the edges of the tree.
     */
    public void listEdges() {
        listEdges(root);
    }

    private void listEdges(Node node) {
        for (Node child : node.getChildren()) {
            System.out.println(node.getData() + " - " + child.getData());
            listEdges(child);
        }
    }

    /**
     * Finds the path from the root to a given node.
     *
     * @param node The node for which to find the path.
     * @return A string representing the path from the root to the node.
     */
    public String findPath(Node node) {
        if (node == root) {
            return String.valueOf(node.getData());
        }

        return findPath(node.getParent()) + " -> " + node.getData();
    }

    /**
     * Finds the depth of a given node in the tree.
     *
     * @param node The node for which to find the depth.
     * @return The depth of the node.
     */
    public int findDepth(Node node) {
        if (node == root) {
            return 0;
        }

        return findDepth(node.getParent()) + 1;
    }

    /**
     * Finds the height of the tree.
     *
     * @return The height of the tree.
     */
    public int findHeight() {
        return findHeight(root);
    }

    private int findHeight(Node node) {
        int maxHeight = -1;

        for (Node child : node.getChildren()) {
            int childHeight = findHeight(child);
            maxHeight = Math.max(maxHeight, childHeight);
        }

        return maxHeight + 1;
    }

    /**
     * Finds the subtree rooted at a given node.
     *
     * @param node The root of the subtree.
     * @return A new tree representing the subtree.
     */
    public Tree findSubtree(Node node) {
        Tree subtree = new Tree(node.getData());

        for (Node child : node.getChildren()) {
            subtree.root.addChild(child);
        }

        return subtree;
    }
}
