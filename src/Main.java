import java.util.Arrays;
import java.util.Random;

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
            if (swapped == false)
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
    
    // Sorting the array by using seletion sort
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
		MyLongArray array = new MyLongArray(5);
        array.insert();
        array.display();
	}
}
