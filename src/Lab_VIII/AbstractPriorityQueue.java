package Lab_VIII;

import java.util.Comparator;

/**
 * An abstract base class for implementing a priority queue.
 *
 * @param <K> The type of the key.
 * @param <V> The type of the value.
 */
public abstract class AbstractPriorityQueue<K, V> implements PriorityQueueInterface<K, V> {

    /**
     * An internal class representing an entry in the priority queue.
     *
     * @param <K> The type of the key.
     * @param <V> The type of the value.
     */
    protected static class PQEntry<K, V> implements Entry<K, V> {
        private K k;
        private V v;

        /**
         * Constructs a new entry with the given key and value.
         *
         * @param key   The key of the entry.
         * @param value The value of the entry.
         */
        public PQEntry(K key, V value) {
            k = key;
            v = value;
        }

        /**
         * Retrieves the key of this entry.
         *
         * @return The key associated with this entry.
         */
        public K getKey() {
            return k;
        }

        /**
         * Retrieves the value of this entry.
         *
         * @return The value associated with this entry.
         */
        public V getValue() {
            return v;
        }

        /**
         * Sets a new key for this entry.
         *
         * @param key The new key for this entry.
         */
        protected void setKey(K key) {
            k = key;
        }

        /**
         * Sets a new value for this entry.
         *
         * @param value The new value for this entry.
         */
        protected void setValue(V value) {
            v = value;
        }
    }

    private Comparator<K> comp;

    /**
     * Constructs a priority queue with the specified comparator.
     *
     * @param c The comparator to be used for comparing keys.
     */
    protected AbstractPriorityQueue(Comparator<K> c) {
        comp = c;
    }

    /**
     * Constructs a priority queue using the default comparator.
     */
    protected AbstractPriorityQueue() {
        this(new DefaultComparator<K>());
    }

    /**
     * Compares two entries for order using the priority queue's comparator.
     *
     * @param a The first entry to be compared.
     * @param b The second entry to be compared.
     * @return A negative integer, zero, or a positive integer if the first entry is less than, equal to,
     *         or greater than the second entry, respectively.
     */
    protected int compare(Entry<K, V> a, Entry<K, V> b) {
        return comp.compare(a.getKey(), b.getKey());
    }

    /**
     * Checks if the given key is valid and comparable using the priority queue's comparator.
     *
     * @param key The key to be checked.
     * @return True if the key is valid and comparable, false otherwise.
     * @throws IllegalArgumentException If the key is not valid.
     */
    protected boolean checkKey(K key) throws IllegalArgumentException {
        try {
            return (comp.compare(key, key) == 0);
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Incompatible key");
        }
    }

    /**
     * Checks if the priority queue is empty.
     *
     * @return True if the priority queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }
}
