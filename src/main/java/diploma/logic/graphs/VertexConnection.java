package diploma.logic.graphs;

public class VertexConnection<T> {

    private Vertex<T> child;
    private Vertex<T> parent;

    public VertexConnection(Vertex<T> parent, Vertex<T> child) {
        this.child = child;
        this.parent = parent;
    }

    public Vertex<T> getChild() {
        return child;
    }

    public Vertex<T> getParent() {
        return parent;
    }

    @Override public boolean equals(Object otherObject){
        if(this == otherObject){
            return  true;
        }

        if(!(otherObject instanceof VertexConnection)){
            return false;
        }
        VertexConnection<T> other = (VertexConnection<T>) otherObject;
        return vertexesAreEqual(other);
    }

    private boolean vertexesAreEqual(VertexConnection<T> other) {
        return this.child.equals(other.child) && this.parent.equals(other.parent);
    }

    @Override
    public String toString(){
        return "[(" + parent + ") --> (" + child + ")]";
    }
}
