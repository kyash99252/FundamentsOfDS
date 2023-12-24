package Lab_IX;

import java.util.Iterator;

/**
 * This abstract class provides a skeletal implementation of the Map interface, to minimize the effort required to implement this interface.
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public abstract class AbstractMap<K, V> implements Map<K, V> {

    /**
     * Returns true if this map contains no key-value pairs.
     *
     * @return true if this map contains no key-value pairs
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * This class represents a key-value mapping contained in a map.
     *
     * @param <K> the type of keys maintained by this map
     * @param <V> the type of mapped values
     */
    protected static class MapEntry<K, V> implements Entry<K, V> {
        private K k;
        private V v;

        /**
         * Constructs an instance of the MapEntry with the specified key and value.
         *
         * @param key the key represented by this entry
         * @param value the value represented by this entry
         */
        public MapEntry(K key, V value) {
            k = key;
            v = value;
        }

        /**
         * Returns the key corresponding to this entry.
         *
         * @return the key corresponding to this entry
         */
        public K getKey() {
            return k;
        }

        /**
         * Returns the value corresponding to this entry.
         *
         * @return the value corresponding to this entry
         */
        public V getValue() {
            return v;
        }

        /**
         * Replaces the key corresponding to this entry with the specified key.
         *
         * @param key new key to be stored in this entry
         */
        protected void setKey(K key) {
            k = key;
        }

        /**
         * Replaces the value corresponding to this entry with the specified value.
         *
         * @param value new value to be stored in this entry
         * @return old value previously associated with the entry
         */
        protected V setValue(V value) {
            V old = v;
            v = value;
            return old;
        }
    }

    /**
     * This private class provides an implementation of the Iterator interface for keys in the map.
     */
    private class KeyIterator implements Iterator<K> {
        private Iterator<Entry<K, V>> entries = entrySet().iterator();

        /**
         * Returns true if the iteration has more elements.
         *
         * @return true if the iteration has more elements
         */
        public boolean hasNext() {
            return entries.hasNext();
        }

        /**
         * Returns the next key in the iteration.
         *
         * @return the next key in the iteration
         */
        public K next() {
            return entries.next().getKey();
        }

        /**
         * The remove operation is not supported by this iterator.
         *
         * @throws UnsupportedOperationException if the remove operation is not supported by this iterator
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * This private class provides an implementation of the Iterable interface for keys in the map.
     */
    private class KeyIterable implements Iterable<K> {

        /**
         * Returns an iterator over keys in the map.
         *
         * @return an iterator over keys in the map
         */
        public Iterator<K> iterator() {
            return new KeyIterator();
        }
    }

    /**
     * Returns an iterable over keys in the map.
     *
     * @return an iterable over keys in the map
     */
    public Iterable<K> keySet() {
        return new KeyIterable();
    }

    /**
     * This private class provides an implementation of the Iterator interface for values in the map.
     */
    private class ValueIterator implements Iterator<V> {
        private Iterator<Entry<K, V>> entries = entrySet().iterator();

        /**
         * Returns true if the iteration has more elements.
         *
         * @return true if the iteration has more elements
         */
        public boolean hasNext() {
            return entries.hasNext();
        }

        /**
         * Returns the next value in the iteration.
         *
         * @return the next value in the iteration
         */
        public V next() {
            return entries.next().getValue();
        }

        /**
         * The remove operation is not supported by this iterator.
         *
         * @throws UnsupportedOperationException if the remove operation is not supported by this iterator
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * This private class provides an implementation of the Iterable interface for values in the map.
     */
    private class ValueIterable implements Iterable<V> {

        /**
         * Returns an iterator over values in the map.
         *
         * @return an iterator over values in the map
         */
        public Iterator<V> iterator() {
            return new ValueIterator();
        }
    }

    /**
     * Returns an iterable over values in the map.
     *
     * @return an iterable over values in the map
     */
    public Iterable<V> values() {
        return new ValueIterable();
    }
}

