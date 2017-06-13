package diploma.logic.algos;

import diploma.logic.graphs.Graph;
import diploma.logic.graphs.Vertex;
import diploma.logic.graphs.VertexConnection;
import diploma.logic.graphs.prodsys.entities.DefiningAttribute;
import diploma.logic.parsers.entities.QueryAttribute;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicInteger;

public class AcyclicDownTopAlgorithm {

    private Collection<DefiningAttribute> definingAttributes;
    private Map<Vertex<QueryAttribute>, Double> attributesMeasures;
    private Map<Vertex<QueryAttribute>, AtomicInteger> numberOfUnprocessedChildren;
    private Queue<Vertex<QueryAttribute>> vertexesToProcess;
    private AtomicInteger numberOfUnprocessedVertexes;

    public AcyclicDownTopAlgorithm() {
        definingAttributes = new ConcurrentSkipListSet<DefiningAttribute>();
        numberOfUnprocessedChildren = new ConcurrentHashMap<Vertex<QueryAttribute>, AtomicInteger>();
        vertexesToProcess = new ConcurrentLinkedQueue<Vertex<QueryAttribute>>();
        attributesMeasures = new ConcurrentHashMap<Vertex<QueryAttribute>, Double>();
    }

    public Collection<DefiningAttribute> getDefiningAttributes(Graph graph) {
        try {
            Graph<QueryAttribute> attributesGraph = graph;
            initializeFields(attributesGraph);
            calculateMeasures();
            fillDefiningAttributesCollection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return definingAttributes;
    }

    private void fillDefiningAttributesCollection() {
        definingAttributes = new ArrayList<DefiningAttribute>();
        for (Map.Entry<Vertex<QueryAttribute>, Double> vertexDoubleEntry : attributesMeasures.entrySet()) {
            QueryAttribute attribute = vertexDoubleEntry.getKey().getValue();
            double measure = vertexDoubleEntry.getValue();
            DefiningAttribute definingAttribute = new DefiningAttribute(attribute, measure);
            definingAttributes.add(definingAttribute);
        }
    }

    private void initializeFields(Graph<QueryAttribute> attributesGraph) {

        Collection<Vertex<QueryAttribute>> vertexes = attributesGraph.getVertexes();

        numberOfUnprocessedVertexes = new AtomicInteger(vertexes.size());

        for(Vertex<QueryAttribute> vertex : vertexes){
            Integer numberOfChildren = calculateNumberOfChildren(vertex);
            numberOfUnprocessedChildren.put(vertex, new AtomicInteger(numberOfChildren));
            if(numberOfChildren == 0){
                vertexesToProcess.add(vertex);
            }
        }
    }

    private Integer calculateNumberOfChildren(Vertex<QueryAttribute> vertex) {
        return vertex.getOutgoingConnections().size();
    }

    private void calculateMeasures() {

        while(notAllVertexesWereProcessed()){
            if(vertexesToProcess.size() > 0){
                Vertex<QueryAttribute> nextVertex = getVertexAndUpdateCounter();
                calculateMeasure(nextVertex);
                updateParents(nextVertex);
            }
        }

    }

    private Vertex<QueryAttribute> getVertexAndUpdateCounter() {
        Vertex<QueryAttribute> nextVertex = vertexesToProcess.remove();
        numberOfUnprocessedVertexes.decrementAndGet();
        return nextVertex;
    }

    private void updateParents(Vertex<QueryAttribute> nextVertex) {
        Collection<VertexConnection<QueryAttribute>> ingoing = nextVertex.getIngoingConnections();
        for (VertexConnection<QueryAttribute> connection : ingoing) {
            Vertex<QueryAttribute> parent = connection.getParent();
            AtomicInteger numberOfRemainingChildren = numberOfUnprocessedChildren.get(parent);
            int updatedValue = numberOfRemainingChildren.decrementAndGet();
            if(updatedValue == 0){
                vertexesToProcess.add(parent);
            }
        }
    }

    private void calculateMeasure(Vertex<QueryAttribute> nextVertex) {
        double measure = 1;
        Collection<VertexConnection<QueryAttribute>> connections = nextVertex.getOutgoingConnections();
        for (VertexConnection<QueryAttribute> connection : connections) {
            double childMeasure = getPartOfChildMeasure(connection);
            measure += childMeasure;
        }
        attributesMeasures.put(nextVertex, measure);
    }

    private double getPartOfChildMeasure(VertexConnection<QueryAttribute> connection) {
        Vertex<QueryAttribute> vertex = connection.getChild();
        double measure = attributesMeasures.get(vertex);
        int numberOfParentsOfChild = vertex.getIngoingConnections().size();
        double result = measure / numberOfParentsOfChild;
        result = new BigDecimal(result).setScale(1, RoundingMode.UP).doubleValue();
        return result;
    }

    private boolean notAllVertexesWereProcessed() {
        return numberOfUnprocessedVertexes.get() != 0;
    }
}
