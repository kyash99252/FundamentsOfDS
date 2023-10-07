/**
 * The `GenericStack_TestApplication` class is an implementation of the `GenericStack` class.
 * It provides a menu-driven interface to test the functionality of the `GenericStack` class.
 *
 * This implementation uses a `Scanner` object to read user input. The user can choose from a list of
 * operations to perform on the stack, including pushing and popping elements, peeking at the top element,
 * checking if the stack is empty or full, and checking the current size of the stack.
 *
 * @see GenericStack
 */
import java.util.*;
public class GenericStack_TestApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Define the limit for the stack: ");
        int capacity = sc.nextInt();
        GenericStack<Integer> stack = new GenericStack<>(capacity);
        int select;
        do {
            System.out.print("""
                Menu:
                1. Push Element
                2. Pop Element
                3. Peek Element
                4. Check if Empty
                5. Check if Full
                6. Check Current Size of Stack
                0. Exit Program
                Enter Sr. No. of Operation :""");
            select = sc.nextInt();
            switch (select) {
                case 1:
                    System.out.print("Please input the element you wish to push: ");
                    int temp = sc.nextInt();
                    stack.push(temp);
                    break;

                case 2:
                    System.out.println("The element popped is: " + stack.pop());
                    break;

                case 3:
                    System.out.println("The element at the top is: " + stack.peek());
                    break;

                case 4:
                    if (stack.isEmpty()) {
                        System.out.println("The Stack is Empty");
                    }
                    else {
                        System.out.println("The Stack is not Empty");
                    }
                    break;

                case 5:
                    if (stack.isFull()) {
                        System.out.println("The Stack is Full");
                    }
                    else {
                        System.out.println("The Stack is not Full");
                    }
                    break;

                case 6:
                    System.out.println("The current size of stack is " + stack.size());
            }
        } while (select != 0);
    }
}
