import java.util.*;

/**
 * This class demonstrates the usage of a GenericQueue to manage tasks.
 *
 * @author Yash Kadam
 */
public class GenericQueue_Implementation {
    /**
     * The main method of this class creates a GenericQueue to manage tasks,
     * enqueues tasks,
     * and processes them one by one.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        // Creating GenericQueue to manage tasks
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of tasks to be performed: ");
        int task = input.nextInt();
        System.out.print("Enter the time required for each task (in sec): ");
        int time = input.nextInt();
        time *= 1000;
        GenericQueue<String> taskQueue = new GenericQueue<>(task);

        // Enqueue tasks
        for (int i = 0; i < task; i++) {
            taskQueue.enqueue("Task " + (i + 1));
        }

        // Process tasks
        while (!taskQueue.isEmpty()) {
            String currentTask = taskQueue.dequeue();
            System.out.println("Processing: " + currentTask);

            // Simulate task execution
            try {
                Thread.sleep(time); // Simulate task execution time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All tasks are processed.");
        input.close();
    }
}
