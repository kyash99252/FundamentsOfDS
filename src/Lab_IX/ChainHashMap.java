package Lab_IX;

import java.util.ArrayList;

/**
 * A hash map implementation using separate chaining for collision resolution.
 *
 * @param <K> The type of keys.
 * @param <V> The type of values.
 */
public class ChainHashMap<K, V> extends AbstractHashMap<K, V> {
    private UnsortedTableMap<K, V>[] table;

    /**
     * Constructs an empty ChainHashMap with default capacity and prime factor.
     */
    public ChainHashMap() {
        super();
    }

    /**
     * Constructs an empty ChainHashMap with a specified initial capacity.
     *
     * @param cap The initial capacity of the hash map.
     */
    public ChainHashMap(int cap) {
        super(cap);
    }

    /**
     * Constructs an empty ChainHashMap with a specified initial capacity and prime factor.
     *
     * @param cap The initial capacity of the hash map.
     * @param p   The prime factor for the hash map.
     */
    public ChainHashMap(int cap, int p) {
        super(cap, p);
    }

    /**
     * Creates the array of buckets for the hash map.
     */
    protected void createTable() {
        table = (UnsortedTableMap<K, V>[]) new UnsortedTableMap[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new UnsortedTableMap<>();
        }
    }

    /**
     * Retrieves the value associated with the specified key from the specified bucket.
     *
     * @param h The index of the bucket.
     * @param k The key whose associated value is to be retrieved.
     * @return The value associated with the specified key, or null if the key is not present.
     */
    protected V bucketGet(int h, K k) {
        UnsortedTableMap<K, V> bucket = table[h];
        if (bucket == null) {
            return null;
        }
        return bucket.get(k);
    }

    /**
     * Associates the specified value with the specified key in the specified bucket.
     *
     * @param h The index of the bucket.
     * @param k The key with which the specified value is to be associated.
     * @param v The value to be associated with the specified key.
     * @return The previous value associated with the key, or null if the key is not present.
     */
    protected V bucketPut(int h, K k, V v) {
        UnsortedTableMap<K, V> bucket = table[h];
        if (bucket == null) {
            bucket = table[h] = new UnsortedTableMap<>();
        }
        int oldSize = bucket.size();
        V answer = bucket.put(k, v);
        n += (bucket.size() - oldSize);
        return answer;
    }

    /**
     * Removes the entry with the specified key from the specified bucket.
     *
     * @param h The index of the bucket.
     * @param k The key of the entry to be removed.
     * @return The value associated with the removed key, or null if the key is not present.
     */
    protected V bucketRemove(int h, K k) {
        UnsortedTableMap<K, V> bucket = table[h];
        if (bucket == null) {
            return null;
        }
        int oldSize = bucket.size();
        V answer = bucket.remove(k);
        n -= (oldSize - bucket.size());
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
            if (table[h] != null) {
                for (Entry<K, V> entry : table[h].entrySet()) {
                    buffer.add(entry);
                }
            }
        }
        return buffer;
    }
}
