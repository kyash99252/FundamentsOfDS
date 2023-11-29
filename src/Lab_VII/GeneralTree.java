package Lab_VII;

import java.util.ArrayList;
import java.util.List;

public class GeneralTree<E> {
    public static class Node<E> implements Position<E>{
        private E element;
        private Node<E> parent;
        private ArrayList<Position<E>> children;
        public Node(E e, Node<E> above, ArrayList<Position<E>> a){
            element = e;
            parent = above;
            children = a;
        }
        public E getElement(){return element;}
        public Node<E> getParent(){return parent;}
        public ArrayList<Position<E>> getChildren(){return children;}
        public void setElement(E e){element = e;}
        public void addChild(Position<E> p){children.add(p);}
    }
    protected Node<E> createNode(E e, Node<E> parent, ArrayList<Position<E>> a){
        return new Node<E>(e, parent, a);
    }
    protected Node<E> root = null;
    private int size = 0;
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException{
        if(!(p instanceof Node))
            throw new IllegalArgumentException("Not valid position type");
        Node<E> node = (Node<E>) p;
        if(node.getParent() == node)
            throw new IllegalArgumentException("p is no longer in the tree");
        return node;
    }
    public int size(){return size;}
    public boolean isEmpty(){return size == 0;}
    public Position<E> root(){return root;}
    public Position<E> parent(Position<E> p)throws IllegalArgumentException{
        Node<E> node = validate(p);
        return node.getParent();
    }
    public ArrayList<Position<E>> children(Position<E> p){
        Node<E> node = validate(p);
        return node.getChildren();
    }
    public int numChildren(Position<E> p){
        return children(p).size();
    }
    public boolean isInternal(Position<E> p){return numChildren(p) > 0;}
    public boolean isExternal(Position<E> p){return numChildren(p) == 0;}
    public boolean isRoot(Position<E> p){return p == root();}
    public Position<E> addRoot(E e) throws IllegalStateException{
        if(!isEmpty())
            throw new IllegalStateException("Tree is Not Empty");
        root = createNode(e, null, new ArrayList<>());
        size = 1;
        return root;
    }
    public E set(Position<E> p, E e) throws IllegalArgumentException{
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }
    public Position<E> addChild(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        Node<E> child = createNode(e, parent, new ArrayList<>());
        parent.addChild(child);
        size++;
        return child;
    }
    public int depth(Position<E> p){
        if(isRoot(p))
            return 0;
        else
            return 1 + depth(parent(p));
    }
    public Iterable<Position<E>> preorder(){
        List<Position<E>> snapshot = new ArrayList<>();
        if(!isEmpty())
            preorderSubtree(root(), snapshot);
        return snapshot;
    }
    private void preorderSubtree(Position<E> p, List<Position<E>> snapshot){
        snapshot.add(p);
        for(Position<E> c: children(p))
            preorderSubtree(c, snapshot);
    }
    private void postorderSubtree(Position<E> p, List<Position<E>> snapshot){
        for(Position<E> c: children(p))
            postorderSubtree(c, snapshot);
        snapshot.add(p);
    }
    public Iterable<Position<E>> postorder(){
        List<Position<E>> snapshot = new ArrayList<>();
        if(!isEmpty())
            postorderSubtree(root(), snapshot);
        return snapshot;
    }
    public Iterable<Position<E>> positions(){return preorder();}
}

