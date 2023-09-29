import java.util.*;
// Main class for user interaction and testing.
public class Main
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of Array: ");
        int size = input.nextInt();
        MyLongArray array = new MyLongArray(size);
        array.insert(); // Initialize the array with random values.
        System.out.println("""
                Enter the Sr. No. of operation you want to perform:\s
                1. Find Element
                2. Get Index of Element
                3. Delete an Element
                4. Display the Array
                5. Insert an Element
                6. Delete Element at particular index
                7. Sort Array using Bubble Sort
                8. Sort Array using Insertion Sort
                9. Sort Array using Selection Sort\s""");
        byte test = input.nextByte();
        switch (test) {
            case 1:
                System.out.print("Enter the Element you want to find: ");
                long searchKey = input.nextLong();
                System.out.println(array.find(searchKey));
                break;

            case 2:
                System.out.print("Enter the Index you want to find: ");
                int index = input.nextInt();
                System.out.println(array.getElem(index));
                break;

            case 3:
                System.out.print("Enter the Element you want to Delete: ");
                long value = input.nextLong();
                System.out.println(array.delete(value));
                array.display();
                break;

            case 4:
                array.display();
                break;

            case 5:
                System.out.println("Enter the Index and Value of Element you wish to add: ");
                int index1 = input.nextInt();
                long value1 = input.nextLong();
                array.insert(index1, value1);
                array.display();
                break;

            case 6:
                System.out.println("Enter the Index of Element you wish to delete: ");
                int index2 = input.nextInt();
                System.out.println(array.deleteAt(index2));
                array.display();
                break;

            case 7:
                System.out.println("The sorted array is: ");
                array.bubbleSort();
                array.display();
                break;

            case 8:
                System.out.println("The sorted array is: ");
                array.insertionSort();
                array.display();
                break;

            case 9:
                System.out.println("The sorted array is: ");
                array.selectionSort();
                array.display();
                break;

            default:
                throw new IllegalArgumentException("Invalid Option");
        }

    }
}