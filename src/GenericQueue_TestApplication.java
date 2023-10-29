
/**
 * The `GenericQueue_TestApplication` class is an implementation of the `GenericQueue` class.
 * It provides a menu-driven interface to test the functionality of the `GenericQueue` class.
 *
 * This implementation uses a `Scanner` object to read user input. The user can choose from a list of
 * operations to perform on the queue, including enqueuing and dequeuing elements, peeking at the front element,
 * checking if the queue is empty or full, and checking the current size of the queue.
 *
 * @see GenericQueue
 */
import java.util.Scanner;

public class GenericQueue_TestApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Define the limit for the queue: ");
        int capacity = sc.nextInt();
        GenericQueue<Integer> queue = new GenericQueue<>(capacity);
        int select;
        do {
            System.out.print("Menu:\n" + "1. Enqueue Element\n" + "2. Dequeue Element\n" + "3. Peek Element\n"
                    + "4. Check if Empty\n" + "5. Check if Full\n" + "6. Size of Queue\n" + "Enter Sr. No. of Operation: ");
            select = sc.nextInt();
            switch (select) {
                case 1:
                    System.out.print("Please input the element you wish to enqueue: ");
                    int temp = sc.nextInt();
                    queue.enqueue(temp);
                    break;

                case 2:
                    System.out.println("The dequeued element is: " + queue.dequeue());
                    break;

                case 3:
                    System.out.println("The element at the front is: " + queue.peek());
                    break;

                case 4:
                    if (queue.isEmpty()) {
                        System.out.println("The Queue is Empty");
                    } else {
                        System.out.println("The Queue is not Empty");
                    }
                    break;

                case 5:
                    if (queue.isFull()) {
                        System.out.println("The Queue is Full");
                    } else {
                        System.out.println("The Queue is not Full");
                    }
                    break;

                case 6:
                    System.out.println("The Current Size of Queue is " + queue.size());
                    break;
                default:
                    System.out.println("Invalid Operator");
            }
        } while (select != 0);
        sc.close();
    }
}
