import java.util.Scanner;
import java.util.Random;

public class GenericQueue_TestApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Define the limit for the queue: ");
        int capacity = sc.nextInt();
        GenericQueue<Integer> queue = new GenericQueue<>(capacity);
//        Random rand = new Random();
//        for (int i = 0; i < capacity - 1; i++) {
//            queue.enqueue(rand.nextInt(100));
//        }
        System.out.print("""
                Menu:
                1. Enqueue Element
                2. Dequeue Element
                3. Peek Element
                4. Check if Empty
                5. Check if Full
                0. Exit Program
                Enter Sr. No. of Operation :""");
        int select = sc.nextInt();
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
                }
                else {
                    System.out.println("The Queue is not Empty");
                }
                break;

            case 5:
                if (queue.isFull()) {
                    System.out.println("The Queue is Full");
                }
                else {
                    System.out.println("The Queue is not Full");
                }

            case 0:
                System.out.println("Exited program successfully");
                break;

            default:
                throw new IllegalArgumentException("Invalid Option");
        }
    }
}
