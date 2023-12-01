package Lab_VIII;

/**
 * An interface representing a priority queue.
 *
 * @param <K> The type of the key.
 * @param <V> The type of the value.
 */
public interface PriorityQueueInterface<K, V> {

    /**
     * Returns the number of entries in the priority queue.
     *
     * @return The size of the priority queue.
     */
    int size();

    /**
     * Checks whether the priority queue is empty.
     *
     * @return True if the priority queue is empty, false otherwise.
     */
    boolean isEmpty();

    /**
     * Inserts a new entry with the specified key and value into the priority queue.
     *
     * @param key   The key of the entry.
     * @param value The value of the entry.
     * @return The newly created entry.
     * @throws IllegalArgumentException If the key is not valid.
     */
    Entry<K, V> insert(K key, V value) throws IllegalArgumentException;

    /**
     * Retrieves the minimum entry in the priority queue without removing it.
     *
     * @return The minimum entry, or null if the priority queue is empty.
     */
    Entry<K, V> min();

    /**
     * Removes and returns the minimum entry in the priority queue.
     *
     * @return The removed minimum entry, or null if the priority queue is empty.
     */
    Entry<K, V> removeMin();
}
