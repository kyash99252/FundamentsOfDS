package Lab_VIII;

import java.util.Comparator;

/**
 * A default comparator implementation that relies on the natural order of elements.
 *
 * @param <E> The type of elements to be compared.
 */
public class DefaultComparator<E> implements Comparator<E> {

    /**
     * Compares two elements for order using their natural order.
     *
     * @param a The first element to be compared.
     * @param b The second element to be compared.
     * @return A negative integer, zero, or a positive integer if the first element is less than, equal to,
     *         or greater than the second element, respectively.
     * @throws ClassCastException If the elements are not comparable.
     */
    @Override
    public int compare(E a, E b) throws ClassCastException {
        return ((Comparable<E>) a).compareTo(b);
    }
}
