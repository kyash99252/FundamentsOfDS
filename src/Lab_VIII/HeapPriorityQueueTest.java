package Lab_VIII;

import java.util.Comparator;
import java.util.Scanner;

/**
 * A test application for the HeapPriorityQueue implementation.
 */
public class HeapPriorityQueueTest {

    /**
     * The main method to run the test application.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Create a new HeapPriorityQueue with a custom comparator
        Scanner sc = new Scanner(System.in);
        Comparator<Integer> integerComparator = Comparator.naturalOrder();
        HeapPriorityQueue<Integer, String> priorityQueue = new HeapPriorityQueue<>(integerComparator);

        int choice;
        do {
            System.out.println("===== Priority Queue Menu =====\n" +
                    "1. Insert Entry\n" +
                    "2. View Minimum Entry\n" +
                    "3. Remove Minimum Entry\n" +
                    "4. View Size\n" +
                    "5. Display All Entries\n" +
                    "6. Check if Priority Queue is Empty\n" +
                    "7. Exit\n" +
                    "==============================\n");

            // Read user choice
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // Insert some entries into the priority queue
                    System.out.println("Enter key:");
                    int key = sc.nextInt();
                    System.out.println("Enter value:");
                    String value = sc.next();
                    priorityQueue.insert(key, value);
                    break;

                case 2:
                    // Print the minimum entry
                    Entry<Integer, String> minEntry = priorityQueue.min();
                    System.out.println("Minimum Entry: " + minEntry.getKey() + " - " + minEntry.getValue());
                    break;

                case 3:
                    // Remove and print the minimum entry
                    Entry<Integer, String> removedEntry = priorityQueue.removeMin();
                    System.out.println("Removed Entry: " + removedEntry.getKey() + " - " + removedEntry.getValue());
                    break;

                case 4:
                    // Print the size of the priority queue
                    System.out.println("Priority Queue Size: " + priorityQueue.size());
                    break;

                case 5:
                    // Remove and print the minimum entry until the priority queue is empty
                    System.out.println("Removing Entries:");
                    while (!priorityQueue.isEmpty()) {
                        Entry<Integer, String> entry = priorityQueue.removeMin();
                        System.out.println("Removed Entry: " + entry.getKey() + " - " + entry.getValue());
                    }
                    break;

                case 6:
                    // Check if Priority Queue is empty
                    if (priorityQueue.isEmpty()) {
                        System.out.println("The Priority Queue is Empty");
                    } else {
                        System.out.println("The Priority Queue isn't Empty");
                    }
                    break;

                case 7:
                    System.out.println("Exiting Program");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                    break;
            }
        } while (choice != 7); // Continue the loop until the user selects option 6 to exit
    }
}
