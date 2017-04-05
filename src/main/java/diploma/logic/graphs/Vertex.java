package diploma.logic.graphs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class Vertex<T> {

    private T value;
    private Collection<VertexConnection<T>> outgoingConnections = new HashSet<VertexConnection<T>>();
    private Collection<VertexConnection<T>> ingoingConnections = new HashSet<VertexConnection<T>>();

    public Vertex(T value) {
        this.value = value;
    }

    public void addOutgoingConnection(Vertex<T> end) {
        VertexConnection<T> connection = new VertexConnection<T>(this, end);
        outgoingConnections.add(connection);
    }

    public void removeConnection(VertexConnection<T> connection){
        outgoingConnections.remove(connection);
        ingoingConnections.remove(connection);
    }

    public void addIngoingConnection(Vertex<T> start){
        VertexConnection<T> connection = new VertexConnection<T>(start, this);
        ingoingConnections.add(connection);
    }

    public boolean containsOutgoingConnection(VertexConnection<T> connection){
        return outgoingConnections.contains(connection);
    }

    public boolean containsIngoingConnection(VertexConnection<T> connection){
        return ingoingConnections.contains(connection);
    }

    public Collection<VertexConnection<T>> getOutgoingConnections() {
        return new ArrayList<VertexConnection<T>>(outgoingConnections);
    }

    public Collection<VertexConnection<T>> getIngoingConnections() {
        return new ArrayList<VertexConnection<T>>(ingoingConnections);
    }

    public T getValue() {
        return value;
    }

    @Override
    public boolean equals(Object otherObject){
        if(this == otherObject){
            return  true;
        }

        if(!(otherObject instanceof Vertex)){
            return false;
        }

        Vertex<T> other = (Vertex<T>) otherObject;
        return this.value.equals(other.value);
    }

    @Override
    public int hashCode(){
        return this.value.hashCode();
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
