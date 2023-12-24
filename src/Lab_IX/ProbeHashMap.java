package Lab_IX;

import java.util.ArrayList;

/**
 * A hash map implementation using linear probing for collision resolution.
 *
 * @param <K> The type of keys.
 * @param <V> The type of values.
 */
public class ProbeHashMap<K, V> extends AbstractHashMap<K, V> {
    private MapEntry<K, V>[] table;
    private MapEntry<K, V> DEFUNCT = new MapEntry<>(null, null);

    /**
     * Constructs an empty ProbeHashMap with default capacity and prime factor.
     */
    public ProbeHashMap() {
        super();
    }

    /**
     * Constructs an empty ProbeHashMap with a specified initial capacity.
     *
     * @param cap The initial capacity of the hash map.
     */
    public ProbeHashMap(int cap) {
        super(cap);
    }

    /**
     * Constructs an empty ProbeHashMap with a specified initial capacity and prime factor.
     *
     * @param cap The initial capacity of the hash map.
     * @param p   The prime factor for the hash map.
     */
    public ProbeHashMap(int cap, int p) {
        super(cap, p);
    }

    /**
     * Creates the array of entries for the hash map.
     */
    protected void createTable() {
        table = (MapEntry<K, V>[]) new MapEntry[capacity];
    }

    /**
     * Checks if the entry at the specified index in the array is available (null or DEFUNCT).
     *
     * @param j The index to check.
     * @return True if the entry is available, false otherwise.
     */
    private boolean isAvailable(int j) {
        return (table[j] == null || table[j] == DEFUNCT);
    }

    /**
     * Finds the slot for the given key in the hash map using linear probing.
     *
     * @param h The original hash code of the key.
     * @param k The key to find.
     * @return The index of the found slot or the negative of the first available slot.
     */
    private int findSlot(int h, K k) {
        int avail = -1;
        int j = h;
        do {
            if (isAvailable(j)) {
                if (avail == -1) avail = j;
                if (table[j] == null) break;
            } else if (table[j].getKey().equals(k)) return j;
            j = (j + 1) % capacity;
        } while (j != h);
        return -(avail + 1);
    }

    /**
     * Retrieves the value associated with the specified key from the specified slot.
     *
     * @param h The original hash code of the key.
     * @param k The key whose associated value is to be retrieved.
     * @return The value associated with the specified key, or null if the key is not present.
     */
    protected V bucketGet(int h, K k) {
        int j = findSlot(h, k);
        if (j < 0) return null;
        return table[j].getValue();
    }

    /**
     * Associates the specified value with the specified key in the specified slot.
     *
     * @param h The original hash code of the key.
     * @param k The key with which the specified value is to be associated.
     * @param v The value to be associated with the specified key.
     * @return The previous value associated with the key, or null if the key is not present.
     */
    protected V bucketPut(int h, K k, V v) {
        int j = findSlot(h, k);
        if (j >= 0) return table[j].setValue(v);
        table[-(j + 1)] = new MapEntry<>(k, v);
        n++;
        return null;
    }

    /**
     * Removes the entry with the specified key from the specified slot.
     *
     * @param h The original hash code of the key.
     * @param k The key of the entry to be removed.
     * @return The value associated with the removed key, or null if the key is not present.
     */
    protected V bucketRemove(int h, K k) {
        int j = findSlot(h, k);
        if (j < 0) return null;
        V answer = table[j].getValue();
        table[j] = DEFUNCT;
        n--;
        return answer;
    }

    /**
     * Returns an iterable collection of all entries in the hash map.
     *
     * @return An iterable collection of all entries in the hash map.
     */
    public Iterable<Entry<K, V>> entrySet() {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>();
        for (int h = 0; h < capacity; h++) {
            if (!isAvailable(h)) buffer.add(table[h]);
        }
        return buffer;
    }
}
