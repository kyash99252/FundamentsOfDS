package Lab_VII;

import java.util.Iterator;

/**
 * This is an interface for a tree which holds elements of type E.
 *
 * @param <E> the type of elements held by this tree
 */
public interface Tree<E> extends Iterable<E> {

    /**
     * Returns the root position of the tree.
     *
     * @return the root position
     */
    Position<E> root();

    /**
     * Returns the parent of the position p in the tree.
     *
     * @param p the position
     * @return the parent of the position p
     * @throws IllegalArgumentException if p is not a valid position
     */
    Position<E> parent(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns an iterable collection of the children of the position p in the tree.
     *
     * @param p the position
     * @return the children of the position p
     * @throws IllegalArgumentException if p is not a valid position
     */
    Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns the number of children of the position p in the tree.
     *
     * @param p the position
     * @return the number of children of the position p
     * @throws IllegalArgumentException if p is not a valid position
     */
    int numChildren(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns whether the position p is internal in the tree.
     *
     * @param p the position
     * @return true if the position p is internal, false otherwise
     * @throws IllegalArgumentException if p is not a valid position
     */
    boolean isInternal(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns whether the position p is external in the tree.
     *
     * @param p the position
     * @return true if the position p is external, false otherwise
     * @throws IllegalArgumentException if p is not a valid position
     */
    boolean isExternal(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns whether the position p is the root of the tree.
     *
     * @param p the position
     * @return true if the position p is the root, false otherwise
     * @throws IllegalArgumentException if p is not a valid position
     */
    boolean isRoot(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns the size of the tree.
     *
     * @return the size of the tree
     */
    int size();

    /**
     * Returns whether the tree is empty.
     *
     * @return true if the tree is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns an iterator over the elements in the tree.
     *
     * @return an iterator over the elements in the tree
     */
    Iterator<E> iterator();

    /**
     * Returns an iterable collection of the positions in the tree.
     *
     * @return the positions in the tree
     */
    Iterable<Position<E>> positions();
}

