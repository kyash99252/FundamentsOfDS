package Lab_IX;

/**
 * An interface representing an entry in a key-value pair.
 *
 * @param <K> The type of the key.
 * @param <V> The type of the value.
 */
public interface Entry<K, V> {

    /**
     * Retrieves the key of this entry.
     *
     * @return The key associated with this entry.
     */
    K getKey();

    /**
     * Retrieves the value of this entry.
     *
     * @return The value associated with this entry.
     */
    V getValue();
}
