package Lab_IX;

/**
 * This interface represents a map, a data structure that can store key-value pairs.
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public interface Map<K, V> {

    /**
     * Returns the number of key-value pairs in this map.
     *
     * @return the number of key-value pairs in this map
     */
    int size();

    /**
     * Returns true if this map contains no key-value pairs.
     *
     * @return true if this map contains no key-value pairs
     */
    boolean isEmpty();

    /**
     * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     *
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or null if this map contains no mapping for the key
     */
    V get(K key);

    /**
     * Associates the specified value with the specified key in this map.
     *
     * @param key the key with which the specified value is to be associated
     * @param value the value to be associated with the specified key
     * @return the previous value associated with key, or null if there was no mapping for key
     */
    V put(K key, V value);

    /**
     * Removes the mapping for a key from this map if it is present.
     *
     * @param key the key whose mapping is to be removed from the map
     * @return the previous value associated with key, or null if there was no mapping for key
     */
    V remove(K key);

    /**
     * Returns a Set view of the keys contained in this map.
     *
     * @return a set view of the keys contained in this map
     */
    Iterable<K> keySet();

    /**
     * Returns a Collection view of the values contained in this map.
     *
     * @return a collection view of the values contained in this map
     */
    Iterable<V> values();

    /**
     * Returns a Set view of the mappings contained in this map.
     *
     * @return a set view of the mappings contained in this map
     */
    Iterable<Entry<K, V>> entrySet();
}
