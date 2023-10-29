import java.util.Scanner;

/**
 * A simple menu-driven application to test the PositionalList implementation.
 */
public class PositionalList_TestApplication {
    /**
     * The main method to run the PositionalListTest program.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        LinkedPositionalList<Integer> positionalList = new LinkedPositionalList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add element at the front");
            System.out.println("2. Add element at the back");
            System.out.println("3. Add element before a position");
            System.out.println("4. Add element after a position");
            System.out.println("5. Set element at a position");
            System.out.println("6. Remove element at a position");
            System.out.println("7. Print elements");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter element to add at the front: ");
                    int frontElement = scanner.nextInt();
                    positionalList.addFirst(frontElement);
                    positionalList.display();
                    break;
                case 2:
                    System.out.print("Enter element to add at the back: ");
                    int backElement = scanner.nextInt();
                    positionalList.addLast(backElement);
                    positionalList.display();
                    break;
                case 3:
                    System.out.print("Enter element to add: ");
                    int elementBefore = scanner.nextInt();
                    System.out.print("Enter the position before which to add: ");
                    int positionBefore = scanner.nextInt();
                    Position<Integer> beforePosition = getPosition(positionalList, positionBefore);
                    positionalList.addBefore(beforePosition, elementBefore);
                    positionalList.display();
                    break;
                case 4:
                    System.out.print("Enter element to add: ");
                    int elementAfter = scanner.nextInt();
                    System.out.print("Enter the position after which to add: ");
                    int positionAfter = scanner.nextInt();
                    Position<Integer> afterPosition = getPosition(positionalList, positionAfter);
                    positionalList.addAfter(afterPosition, elementAfter);
                    positionalList.display();
                    break;
                case 5:
                    System.out.print("Enter element to set: ");
                    int elementToSet = scanner.nextInt();
                    System.out.print("Enter the position to set: ");
                    int positionToSet = scanner.nextInt();
                    Position<Integer> setPosition = getPosition(positionalList, positionToSet);
                    positionalList.set(setPosition, elementToSet);
                    positionalList.display();
                    break;
                case 6:
                    System.out.print("Enter the position to remove: ");
                    int positionToRemove = scanner.nextInt();
                    Position<Integer> removePosition = getPosition(positionalList, positionToRemove);
                    int removedElement = positionalList.remove(removePosition);
                    System.out.println("Removed element: " + removedElement);
                    positionalList.display();
                    break;
                case 7:
                    System.out.println("Elements in the list:");
                    positionalList.display();
                    break;
                case 8:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Retrieves a Position at a specified index in the PositionalList.
     *
     * @param list The PositionalList to search in.
     * @param position The index of the Position to retrieve.
     * @return The Position at the specified index.
     */
    private static Position<Integer> getPosition(PositionalList<Integer> list, int position) {
        int count = 0;
        Position<Integer> currentPosition = list.first();
        while (count < position && currentPosition != null) {
            currentPosition = list.after(currentPosition);
            count++;
        }
        return currentPosition;
    }
}
