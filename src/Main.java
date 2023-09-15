import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class MyLongArray {
    private long[] a;
    private int currentIndex;
    
    public MyLongArray(int size) {
        a = new long[size];
        currentIndex = 0;
    }
    
    public int find(long searchKey) {
        for(int i = 0; i < currentIndex; i++) {
            if (a[i] == searchKey) {
                return i;
            }
        }
        return -1;
    }
    
    public void insert() {
        Random rand = new Random();
        if (currentIndex < a.length) {
            for (int i = 0; i < a.length; i++) {
                a[i] = rand.nextInt(1000);
                currentIndex++;
            }
        }
        else {
            System.out.println("Error: Array is Full");
        }
    }
    
    public long getElem(int index) {
        return a[index];
    }
    
    public boolean delete(long value) {
        int index = find(value);
        if (index == -1) {
            return false;
        }
        else {
            for (int i = index; i < currentIndex; i++) {
                a[i] = a[i + 1];
                currentIndex--;
                a[currentIndex] = 0;
            }
        }
        a[a.length - 1] = 0; 
        return false;
    }
    
    public void display() {
        System.out.println(Arrays.toString(a));
    }
    
    public void insert(int index, long value) {
        long temp = a[index];
        a[index] = value;
        a[a.length - 1] = a[a.length - 2];
        for (int i = index + 1; i < currentIndex - 1; i++) {
            a[i] = temp;
            temp = a[i + 1];
        }
    }
    
    public boolean deleteAt(int index) {
        if (index < a.length) {
            for (int i = index; i < currentIndex; i++) {
                a[i] = a[i + 1];
                currentIndex--;
            }
            a[a.length - 1] = 0; 
            return true;
        }
        return false;
    }
    
    // Sorting the array by using bubble sort
    public void bubbleSort() {
        long n = a.length;
        long temp;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }
    
    // Sorting the array by using insertion sort
    public void insertionSort() {
        long n = a.length;
        for (int i = 1; i < n; ++i) {
            long key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = key;
        }
    }
    
    // Sorting the array by using selection sort
    public void selectionSort() {
        long n = a.length;
        int index;
        long temp;
        for (int i = 0; i < n - 1; i++) {
            index = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[index])
                    index = j;
            }
            if (index != i) {
                    temp = a[index];
                    a[index] = a[i];
                    a[i] = temp;
            }
        }
    }
}

public class Main
{
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of Array: ");
        int size = input.nextInt();
        MyLongArray array = new MyLongArray(size);
        array.insert();
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
