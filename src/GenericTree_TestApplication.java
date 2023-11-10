import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * A simple test application for interacting with a generic tree data structure.
 */
public class TestApplication {
    /**
     * The main method to run the test application.
     *
     * @param args Command line arguments (not used in this application).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rootValue = 0;
        while (true) {
            try {
                System.out.print("Enter the root value of the tree: ");
                rootValue = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println(e + ": Enter a valid Integer");
                scanner.nextLine();
            }
        }
        Tree<Integer> tree = new Tree<>(rootValue);
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Display Tree");
            System.out.println("2. List Leaves");
            System.out.println("3. List Internal Nodes");
            System.out.println("4. List Edges");
            System.out.println("5. Find Path for a Node");
            System.out.println("6. Find Depth of a Node");
            System.out.println("7. Find Height of the Tree");
            System.out.println("8. Extract Subtree");
            System.out.println("9. Add Node");
            System.out.println("10. Add Children to Node");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Displaying Tree:");
                    tree.displayTree();
                    break;
                case 2:
                    System.out.println("List of Leaves:");
                    tree.listLeaves();
                    break;
                case 3:
                    System.out.println("List of Internal Nodes:");
                    tree.listInternalNodes();
                    break;
                case 4:
                    System.out.println("List of Edges:");
                    tree.listEdges();
                    break;
                case 5:
                int nodeValue = 0;    
                while (true) {
                    try {
                        System.out.print("Enter the value of the node: ");
                        nodeValue = scanner.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                            System.out.println(e + ": Enter a valid Integer");
                            scanner.nextLine();
                        }
                    }
                    Node<Integer> node = findNode(tree.root, nodeValue);
                    if (node != null) {
                        System.out.println("Path for Node " + nodeValue + ": " + tree.findPath(node));
                    } else {
                        System.out.println("Node not found.");
                    }
                    break;
                case 6:
                    int depthNodeValue = 0;
                    while (true) {
                        try {
                            System.out.print("Enter the value of the node: ");
                            depthNodeValue = scanner.nextInt();
                            break;
                        }
                        catch (InputMismatchException e) {
                            System.out.println(e + ": Enter a valid Integer.");
                        }
                    }
                    Node<Integer> depthNode = findNode(tree.root, depthNodeValue);
                    if (depthNode != null) {
                        System.out.println("Depth of Node " + depthNodeValue + ": " + tree.findDepth(depthNode));
                    } else {
                        System.out.println("Node not found.");
                    }
                    break;
                case 7:
                    System.out.println("Height of Tree: " + tree.findHeight());
                    break;
                case 8:
                    int subtreeRootValue = 0;
                    while (true) {
                        try {
                            System.out.print("Enter the value of the node to extract subtree: ");
                            subtreeRootValue = scanner.nextInt();
                            break;
                        }
                        catch (InputMismatchException e) {
                            System.out.println(e + ": Enter a valid Integer.");
                        }
                    }
                    Node<Integer> subtreeRoot = findNode(tree.root, subtreeRootValue);
                    try {
                        if (subtreeRoot == null) {
                            throw new NoSuchElementException();
                        }
                        Tree<Integer> subtree = tree.findSubtree(subtreeRoot);
                        System.out.println("\nSubtree rooted at Node " + subtreeRootValue + ":");
                        subtree.displayTree();
                    } catch (NoSuchElementException e) {
                        System.out.println(e + ": Node not found.");
                    }
                    break;
                case 9:
                    System.out.print("Enter the value of the parent node: ");
                    int parentValue = scanner.nextInt();
                    Node<Integer> parentNode = findNode(tree.root, parentValue);
                    if (parentNode != null) {
                        System.out.print("Enter the value of the new node: ");
                        int newNodeValue = scanner.nextInt();
                        Node<Integer> newNode = new Node<>(newNodeValue);
                        parentNode.addChild(newNode);
                        System.out.println("Node " + newNodeValue + " added as a child to Node " + parentValue);
                    } else {
                        System.out.println("Parent node not found.");
                    }
                    break;
                case 10:
                    System.out.print("Enter the value of the parent node: ");
                    int parentForChildrenValue = scanner.nextInt();
                    Node<Integer> parentForChildren = findNode(tree.root, parentForChildrenValue);
                    if (parentForChildren != null) {
                        System.out.print("Enter the number of children to add: ");
                        int numChildren = scanner.nextInt();
                        for (int i = 0; i < numChildren; i++) {
                            System.out.print("Enter the value of child " + (i + 1) + ": ");
                            int childValue = scanner.nextInt();
                            Node<Integer> childNode = new Node<>(childValue);
                            parentForChildren.addChild(childNode);
                        }
                        System.out.println("Children added to Node " + parentForChildrenValue);
                    } else {
                        System.out.println("Parent node not found.");
                    }
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    /**
     * Finds a node in the tree with the specified value.
     *
     * @param node  The root of the tree or subtree to search.
     * @param value The value to search for.
     * @return The node with the specified value, or null if not found.
     */
    private static Node<Integer> findNode(Node<Integer> node, int value) {
        if (node.getData() == value) {
            return node;
        }

        for (Node<Integer> child : node.getChildren()) {
            Node<Integer> foundNode = findNode(child, value);
            if (foundNode != null) {
                return foundNode;
            }
        }

        return null;
    }
}
