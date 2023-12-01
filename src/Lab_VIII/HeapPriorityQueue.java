package Lab_VIII;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * A priority queue implementation using a binary heap.
 *
 * @param <K> The type of the key.
 * @param <V> The type of the value.
 */
public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {

    /**
     * Internal storage for the entries forming a binary heap.
     */
    protected ArrayList<Entry<K, V>> heap = new ArrayList<>();

    /**
     * Constructs an empty heap priority queue using the natural order of keys.
     */
    public HeapPriorityQueue() {
        super();
    }

    /**
     * Constructs an empty heap priority queue using the provided comparator for key comparison.
     *
     * @param comp The comparator to be used for comparing keys.
     */
    public HeapPriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    /**
     * Calculates the index of the parent of a given index.
     *
     * @param j The index for which the parent index needs to be calculated.
     * @return The index of the parent.
     */
    protected int parent(int j) {
        return (j - 1) / 2;
    }

    /**
     * Calculates the index of the left child of a given index.
     *
     * @param j The index for which the left child index needs to be calculated.
     * @return The index of the left child.
     */
    protected int left(int j) {
        return 2 * j + 1;
    }

    /**
     * Calculates the index of the right child of a given index.
     *
     * @param j The index for which the right child index needs to be calculated.
     * @return The index of the right child.
     */
    protected int right(int j) {
        return 2 * j + 2;
    }

    /**
     * Checks if a given index has a left child.
     *
     * @param j The index to check.
     * @return True if the index has a left child, false otherwise.
     */
    protected boolean hasLeft(int j) {
        return left(j) < heap.size();
    }

    /**
     * Checks if a given index has a right child.
     *
     * @param j The index to check.
     * @return True if the index has a right child, false otherwise.
     */
    protected boolean hasRight(int j) {
        return right(j) < heap.size();
    }

    /**
     * Swaps the entries at two specified indices.
     *
     * @param i The index of the first entry.
     * @param j The index of the second entry.
     */
    protected void swap(int i, int j) {
        Entry<K, V> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    /**
     * Performs up-heap bubbling to restore the heap order after an insertion.
     *
     * @param j The index from which the up-heap bubbling starts.
     */
    protected void upheap(int j) {
        while (j > 0) {
            int p = parent(j);
            if (compare(heap.get(j), heap.get(p)) >= 0) break;
            swap(j, p);
            j = p;
        }
    }

    /**
     * Performs down-heap bubbling to restore the heap order after a removal.
     *
     * @param j The index from which the down-heap bubbling starts.
     */
    protected void downheap(int j) {
        while (hasLeft(j)) {
            int leftIndex = left(j);
            int smallChildIndex = leftIndex;
            if (hasRight(j)) {
                int rightIndex = right(j);
                if (compare(heap.get(leftIndex), heap.get(rightIndex)) > 0) {
                    smallChildIndex = rightIndex;
                }
            }
            if (compare(heap.get(smallChildIndex), heap.get(j)) >= 0) break;
            swap(j, smallChildIndex);
            j = smallChildIndex;
        }
    }

    /**
     * Returns the number of entries in the priority queue.
     *
     * @return The size of the priority queue.
     */
    public int size() {
        return heap.size();
    }

    /**
     * Inserts a new entry with the specified key and value into the priority queue.
     *
     * @param key   The key of the entry.
     * @param value The value of the entry.
     * @return The newly created entry.
     * @throws IllegalArgumentException If the key is not valid.
     */
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K, V> newest = new PQEntry<>(key, value);
        heap.add(newest);
        upheap(heap.size() - 1);
        return newest;
    }

    /**
     * Retrieves the minimum entry in the priority queue without removing it.
     *
     * @return The minimum entry, or null if the priority queue is empty.
     */
    public Entry<K, V> min() {
        if (heap.isEmpty()) return null;
        return heap.get(0);
    }

    /**
     * Removes and returns the minimum entry in the priority queue.
     *
     * @return The removed minimum entry, or null if the priority queue is empty.
     */
    public Entry<K, V> removeMin() {
        if (heap.isEmpty()) return null;
        Entry<K, V> answer = heap.get(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        downheap(0);
        return answer;
    }
}
