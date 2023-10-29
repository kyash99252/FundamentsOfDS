
/**
 * The GenericStack_Implementation class is a simple program that converts an integer
 * into its binary representation using a generic stack. It takes user input for an
 * integer, calculates its binary representation, and prints it.
 *
 * @author Yash Kadam
 * @version 1.0
 */
import java.util.*;

public class GenericStack_Implementation {
    /**
     * The main method of the GenericStack_Implementation class.
     * It takes user input, calculates the binary representation of the input
     * number,
     * and prints it in reverse order.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        // Create a GenericStack instance for storing binary digits
        GenericStack<Integer> stack = new GenericStack<>(32);

        // Create a Scanner for user input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int a = input.nextInt();

        // Calculate and push binary digits onto the stack
        while (a != 0) {
            int temp = a % 2;
            stack.push(temp);
            a /= 2;
        }

        // Pop and print the binary digits in reverse order
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println();

        // Close the Scanner
        input.close();
    }
}