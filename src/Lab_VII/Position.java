package Lab_VII;

/**
 * This is an interface for a position which holds an element of type E.
 *
 * @param <E> the type of element held by this position
 */
public interface Position<E> {

    /**
     * Returns the element held by this position.
     *
     * @return the element at this position
     * @throws IllegalStateException if an illegal state is encountered
     */
    E getElement() throws IllegalStateException;
}

