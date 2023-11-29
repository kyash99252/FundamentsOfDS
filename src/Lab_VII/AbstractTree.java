package Lab_VII;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

/**
 * This is an abstract class for a tree which holds elements of type E.
 *
 * @param <E> the type of elements held by this tree
 */
public abstract class AbstractTree<E> implements Tree<E> {

    /**
     * Returns whether the position p is internal in the tree.
     *
     * @param p the position
     * @return true if the position p is internal, false otherwise
     */
    public boolean isInternal(Position<E> p) {
        return numChildren(p) > 0;
    }

    /**
     * Returns whether the position p is external in the tree.
     *
     * @param p the position
     * @return true if the position p is external, false otherwise
     */
    public boolean isExternal(Position<E> p) {
        return numChildren(p) == 0;
    }

    /**
     * Returns whether the position p is the root of the tree.
     *
     * @param p the position
     * @return true if the position p is the root, false otherwise
     */
    public boolean isRoot(Position<E> p) {
        return p == root();
    }

    /**
     * Returns whether the tree is empty.
     *
     * @return true if the tree is empty, false otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns the depth of the position p in the tree.
     *
     * @param p the position
     * @return the depth of the position p
     */
    public int depth(Position<E> p) {
        if (isRoot(p))
            return 0;
        else
            return 1 + depth(parent(p));
    }

    /**
     * Returns the height of the position p in the tree.
     *
     * @param p the position
     * @return the height of the position p
     */
    public int height(Position<E> p) {
        int h = 0; // base case if p is external
        for (Position<E> c : children(p))
            h = Math.max(h, 1 + height(c));
        return h;
    }

    /**
     * This is a private inner class for an iterator over the elements in the tree.
     */
    private class ElementIterator implements Iterator<E> {
        Iterator<Position<E>> posIterator = positions().iterator();

        public boolean hasNext() {
            return posIterator.hasNext();
        }

        public E next() {
            return posIterator.next().getElement(); // return element!
        }

        public void remove() {
            posIterator.remove();
        }
    }

    /**
     * Returns an iterator over the elements in the tree.
     *
     * @return an iterator over the elements in the tree
     */
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    /**
     * Adds the position p and its descendants to the given snapshot using a preorder traversal
     *
     * @param p the position
     * @param snapshot a list of positions
     */
    private void preorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        snapshot.add(p); // for preorder, we add position p before exploring subtrees
        for (Position<E> c : children(p))
            preorderSubtree(c, snapshot);
    }

    /**
     * Returns an iterable collection of positions of the tree, reported in preorder.
     *
     * @return an iterable collection of positions of the tree, reported in preorder
     */
    public Iterable<Position<E>> preorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty())
            preorderSubtree(root(), snapshot); // fill the snapshot recursively
        return snapshot;
    }

    /**
     * Adds the position p and its descendants to the given snapshot using a postorder traversal
     *
     * @param p the position
     * @param snapshot a list of positions
     */
    private void postorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        for (Position<E> c : children(p))
            postorderSubtree(c, snapshot);
        snapshot.add(p); // for postorder, we add position p after exploring subtrees
    }

    /**
     * Returns an iterable collection of positions of the tree, reported in postorder.
     *
     * @return an iterable collection of positions of the tree, reported in postorder
     */
    public Iterable<Position<E>> postorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty())
            postorderSubtree(root(), snapshot); // fill the snapshot recursively
        return snapshot;
    }

    /**
     * Returns an iterable collection of positions of the tree.
     *
     * @return an iterable collection of positions of the tree
     */
    public Iterable<Position<E>> positions() {
        return preorder();
    }
}

