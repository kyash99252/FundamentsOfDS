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
