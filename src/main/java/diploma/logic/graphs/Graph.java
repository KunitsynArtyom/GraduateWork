package diploma.logic.graphs;

import java.util.Collection;
import java.util.HashSet;

public class Graph<T> {

    private Collection<Vertex<T>> vertexes = new HashSet<Vertex<T>>();

    public void addVertex(Vertex<T> vertex) {
        vertexes.add(vertex);
    }

    public boolean containsVertex(Vertex<T> vertex){
        return vertexes.contains(vertex);
    }

    public Collection<Vertex<T>> getVertexes() {
        return new HashSet<Vertex<T>>(vertexes);
    }
}
