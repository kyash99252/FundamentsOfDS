import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// Define a class named MyLongArray for managing a long array.
class MyLongArray {
    private long[] a; // Array to store long values
    private int currentIndex; // Index to keep track of the current number of elements in the array

    // Constructor to initialize the array with a given size.
    public MyLongArray(int size) {
        a = new long[size];
        currentIndex = 0; // Initialize the current index to 0.
    }

    // Method to find an element in the array and return its index.
    public int find(long searchKey) {
        for(int i = 0; i < currentIndex; i++) {
            if (a[i] == searchKey) {
                return i; // Return the index of the element if found.
            }
        }
        return -1; // Return -1 if the element is not found in the array.
    }

    // Method to insert random values into the array.
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

    // Method to retrieve an element at a given index.
    public long getElem(int index) {
        return a[index];
    }

    // Method to delete a specified value from the array.
    public boolean delete(long value) {
        int index = find(value);
        if (index == -1) {
            return false; // Element not found, return false.
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

    // Method to display the contents of the array.
    public void display() {
        System.out.println(Arrays.toString(a));
    }

    // Method to insert a value at a specified index.
    public void insert(int index, long value) {
        long temp = a[index];
        a[index] = value;
        a[a.length - 1] = a[a.length - 2];
        for (int i = index + 1; i < currentIndex - 1; i++) {
            a[i] = temp;
            temp = a[i + 1];
        }
    }

    // Method to delete an element at a specified index.
    public boolean deleteAt(int index) {
        if (index < a.length) {
            for (int i = index; i < currentIndex; i++) {
                a[i] = a[i + 1];
                currentIndex--;
            }
            a[a.length - 1] = 0;
            return true; // Element successfully deleted, return true.
        }
        return false; // Index out of bounds, return false.
    }

    // Method to perform bubble sort on the array to sort it in ascending order.
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

    // Method to perform insertion sort on the array to sort it in ascending order.
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

    // Method to perform selection sort on the array to sort it in ascending order.
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
