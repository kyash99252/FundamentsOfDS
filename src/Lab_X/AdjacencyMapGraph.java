package Lab_X;


import Lab_IX.Map;
import Lab_IX.ProbeHashMap;

public class AdjacencyMapGraph<V, E> implements Graph<V, E> {
    public int numVertices() {
        return 0;
    }

    @Override
    public Iterable<Vertex<V>> vertices() {
        return null;
    }

    @Override
    public int numEdges() {
        return 0;
    }

    @Override
    public Iterable<Edge<E>> edges() {
        return null;
    }

    @Override
    public Edge<E> getEdge(Vertex<V> u, Vertex<V> v) {
        return null;
    }

    @Override
    public Vertex<V>[] endVertices(Edge<E> e) {
        return new Vertex[0];
    }

    @Override
    public Vertex<V> opposite(Vertex<V> v, Edge<E> e) {
        return null;
    }

    @Override
    public int outDegree(Vertex<V> v) {
        return 0;
    }

    @Override
    public int inDegree(Vertex<V> v) {
        return 0;
    }

    @Override
    public Iterable<Edge<E>> outgoingEdges(Vertex<V> v) {
        return null;
    }

    @Override
    public Iterable<Edge<E>> incomingEdges(Vertex<V> v) {
        return null;
    }

    @Override
    public Vertex<V> insertVertex(V element) {
        return null;
    }

    @Override
    public Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E element) {
        return null;
    }

    private class InnerVertex<V> implements Vertex<V> {
        private V element;
        private Position<Vertex<V>> pos;
        private Map<Vertex<V>, Edge<E>> outgoing, incoming;
        public InnerVertex(V elem, boolean graphIsDirected) {
            element = elem;
            outgoing = new ProbeHashMap<>();
            if (graphIsDirected) {
                incoming = new ProbeHashMap<>();
            } else {
                incoming = outgoing;
            }
        }
        public V getElement() { return element; }
        public void setPosition(Position<Vertex<V>> p) { pos = p; }
        public Position<Vertex<V>> getPosition() { return pos; }
        public Map<Vertex<V>, Edge<E>> getOutgoing() { return outgoing; }
        public Map<Vertex<V>, Edge<E>> getIncoming() { return incoming; }
    }
    private class InnerEdge<E> implements Edge<E> {
        private E element;
        private Position<Edge<E>> pos;
        private Vertex<V>[] endpoints;
        public InnerEdge(Vertex<V> u, Vertex<V> v, E elem) {
            element = elem;
            endpoints = (Vertex<V>[]) new Vertex[]{ u, v };
        }
        public E getElement() { return element; }
        public Vertex<V>[] getEndpoints() { return endpoints; }
        public void setPosition(Position<Edge<E>> p) { pos = p; }

        public Position<Edge<E>> getPosition() { return pos; }
    }
}
