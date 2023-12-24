package Lab_IX;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class provides a concrete implementation of a map using an unsorted table.
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public class UnsortedTableMap<K, V> extends AbstractMap<K, V> {

    /**
     * The underlying storage for the map of entries.
     */
    private ArrayList<MapEntry<K, V>> table = new ArrayList<>();

    /**
     * Constructs an empty map.
     */
    public UnsortedTableMap() { }

    /**
     * Returns the index of an entry with equal key, or -1 if none found.
     *
     * @param key the key
     * @return index of key in table (or -1 if not found)
     */
    private int findIndex(K key) {
        int n = table.size();
        for (int j = 0; j < n; j++) {
            if (table.get(j).getKey().equals(key)) {
                return j;
            }
        }
        return -1;
    }

    /**
     * Returns the number of entries in the map.
     *
     * @return the number of entries in the map
     */
    public int size() {
        return table.size();
    }

    /**
     * Returns the value associated with the specified key, or null if no such entry exists.
     *
     * @param key the key
     * @return the associated value, or null if no such entry exists
     */
    public V get(K key) {
        int j = findIndex(key);
        if (j == -1) return null;
        return table.get(j).getValue();
    }

    /**
     * Associates the given value with the given key. If an entry with
     * the key was already in the map, this replaced the previous value
     * with the new one and returns the old value. Otherwise, a new
     * entry is added and null is returned.
     *
     * @param key the key
     * @param value the value
     * @return the previous value, or null if no such entry exists
     */
    public V put(K key, V value) {
        int j = findIndex(key);
        if (j == -1) {
            table.add(new MapEntry<>(key, value));
            return null;
        } else {
            return table.get(j).setValue(value);
        }
    }

    /**
     * Removes the entry with the specified key, if present, and returns its value.
     * If no such entry exists, returns null.
     *
     * @param key the key
     * @return the previous value, or null if no such entry exists
     */
    public V remove(K key) {
        int j = findIndex(key);
        int n = size();
        if (j == -1) return null;
        V answer = table.get(j).getValue();
        if (j != n - 1) {
            table.set(j, table.get(n - 1));
        }
        table.remove(n - 1);
        return answer;
    }

    /**
     * Support for public keySet method...
     */
    private class EntryIterator implements Iterator<Entry<K, V>> {
        private int j = 0;
        public boolean hasNext() {
            return j < table.size();
        }
        public Entry<K, V> next() {
            if (j == table.size()) throw new NoSuchElementException();
            return table.get(j++);
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Support for public keySet method...
     */
    private class EntryIterable implements Iterable<Entry<K, V>> {
        public Iterator<Entry<K, V>> iterator() {
            return new EntryIterator();
        }
    }

    /**
     * Returns an iterable collection of all key-value entries of the map.
     *
     * @return iterable collection of the map's entries
     */
    public Iterable<Entry<K, V>> entrySet() {
        return new EntryIterable();
    }
}
