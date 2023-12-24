package Lab_IX;

import java.util.ArrayList;
import java.util.Random;

/**
 * This abstract class provides a skeletal implementation of the Map interface, to minimize the effort required to implement this interface.
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public abstract class AbstractHashMap<K, V> extends AbstractMap<K, V> {
    protected int n = 0; // The number of entries in the dictionary
    protected int capacity; // The capacity of the hash table
    private int prime; // The prime factor
    private long scale, shift; // The shift and scaling factors

    /**
     * Constructs an instance of the AbstractHashMap with the specified capacity and prime factor.
     *
     * @param cap the initial capacity
     * @param p the prime factor
     */
    public AbstractHashMap(int cap, int p) {
        prime = p;
        capacity = cap;
        Random rand = new Random();
        scale = rand.nextInt(prime - 1) + 1;
        shift = rand.nextInt(prime);
        createTable();
    }

    /**
     * Constructs an instance of the AbstractHashMap with the specified capacity and prime factor 109345121.
     *
     * @param cap the initial capacity
     */
    public AbstractHashMap(int cap) {
        this(cap, 109345121);
    }

    /**
     * Constructs an instance of the AbstractHashMap with the default capacity 17 and prime factor 109345121.
     */
    public AbstractHashMap() {
        this(17);
    }

    /**
     * Returns the number of key-value pairs in this map.
     *
     * @return the number of key-value pairs in this map
     */
    public int size() {
        return n;
    }

    /**
     * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     *
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or null if this map contains no mapping for the key
     */
    public V get(K key) {
        return bucketGet(hashValue(key), key);
    }

    /**
     * Removes the mapping for a key from this map if it is present.
     *
     * @param key the key whose mapping is to be removed from the map
     * @return the previous value associated with key, or null if there was no mapping for key
     */
    public V remove(K key) {
        return bucketRemove(hashValue(key), key);
    }

    /**
     * Associates the specified value with the specified key in this map.
     *
     * @param key the key with which the specified value is to be associated
     * @param value the value to be associated with the specified key
     * @return the previous value associated with key, or null if there was no mapping for key
     */
    public V put(K key, V value) {
        V answer = bucketPut(hashValue(key), key, value);
        if (n > capacity/2) {
            resize(2 * capacity - 1);
        }
        return answer;
    }

    /**
     * Hash function applying MAD method to default hash code.
     *
     * @param key the key to be hashed
     * @return the output hash value
     */
    private int hashValue(K key) {
        return (int) ((Math.abs(key.hashCode()*scale + shift) % prime) % capacity);
    }

    /**
     * Resizes the hash table to keep the load factor <= 0.5.
     *
     * @param newCap the new capacity
     */
    private void resize(int newCap) {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>(n);
        for (Entry<K, V> e: entrySet()) {
            buffer.add(e);
        }
        capacity = newCap;
        createTable();
        n = 0;
        for(Entry<K, V> e: buffer) {
            put(e.getKey(), e.getValue());
        }
    }

    /**
     * Creates a new table of capacity equal to the current capacity.
     */
    protected abstract void createTable();

    /**
     * Returns the value associated with the specified key in the bucket with the hash value h. If no such key exists, returns null.
     *
     * @param h the hash value of the bucket
     * @param k the key
     * @return the associated value, or null if no such key exists
     */
    protected abstract V bucketGet(int h, K k);

    /**
     * Associates the specified key with the specified value in the bucket with the hash value h. If the key already exists, replaces the old value with the new one and returns the old value. If the key does not exist, adds the entry to the bucket and returns null.
     *
     * @param h the hash value of the bucket
     * @param k the key
     * @param v the value
     * @return the old value, or null if no such key exists
     */
    protected abstract V bucketPut(int h, K k, V v);

    /**
     * Removes the entry with the specified key in the bucket with the hash value h and returns its value. If no such key exists, returns null.
     *
     * @param h the hash value of the bucket
     * @param k the key
     * @return the removed value, or null if no such key exists
     */
    protected abstract V bucketRemove(int h, K k);
}