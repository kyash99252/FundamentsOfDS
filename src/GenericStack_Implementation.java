/**
 * The `GenericStack_Implementation` class is an implementation of the `GenericStack` class.
 * It uses a stack to parse HTML code and check if it is properly nested.
 *
 * This implementation uses a `GenericStack` to store tags. When an opening tag is encountered,
 * it is pushed onto the stack. When a closing tag is encountered, the corresponding opening tag
 * is popped from the stack. If the tags do not match, an error message is printed.
 *
 * @see GenericStack
 */
import java.util.*;

public class GenericStack_Implementation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("HTML Code Parser\n" + "Enter the HTML Code:");
        String code = "<html><head><title>My Title</title></head><body><h1>Heading</h1><p>Paragraph</p></body></html>";
        GenericStack<String> stack = new GenericStack<>(code.length());
        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == '<') {
                int j = code.indexOf('>', i);
                if (j != -1) {
                    String tag = code.substring(i + 1, j);
                    if (!tag.startsWith("/")) {
                        stack.push(tag);
                    } else {
                        String openTag = stack.pop();
                        if (!tag.substring(1).equals(openTag)) {
                            System.out.println("Error: " + openTag);
                            break;
                        }
                    }
                    i = j;
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("The HTML is properly nested.");
        } else {
            System.out.println("Error: " + stack.peek());
        }
    }
}
