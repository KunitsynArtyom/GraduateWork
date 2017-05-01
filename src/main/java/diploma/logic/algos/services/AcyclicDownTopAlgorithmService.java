package diploma.logic.algos.services;

import diploma.logic.algos.AcyclicDownTopAlgorithm;
import diploma.logic.graphs.Graph;
import diploma.logic.graphs.Vertex;
import diploma.logic.graphs.VertexConnection;
import diploma.logic.graphs.prodsys.converters.ProductionSystemToGraphConverter;
import diploma.logic.graphs.prodsys.entities.DefiningAttribute;
import diploma.logic.graphs.prodsys.entities.Implication;
import diploma.logic.graphs.prodsys.entities.ProductionSystem;
import diploma.logic.parsers.entities.QueryAttribute;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Артём on 02.05.2017.
 */
public class AcyclicDownTopAlgorithmService {
    private List<Implication<QueryAttribute>> implicationList;
    private Graph graph;
    private Collection<Vertex<QueryAttribute>> vertexList;
    private List<VertexConnection<QueryAttribute>> vertexConnectionList;

    public AcyclicDownTopAlgorithmService(List<Implication<QueryAttribute>> implicationList) {
        this.implicationList = implicationList;
        initializeGraph();
    }

    public Collection<Vertex<QueryAttribute>> getVertexList() {
        return vertexList;
    }

    public List<VertexConnection<QueryAttribute>> getVertexConnectionList() {
        return vertexConnectionList;
    }

    public Collection<DefiningAttribute> getDefiningAttributes() {
        AcyclicDownTopAlgorithm acyclicDownTopAlgorithm = new AcyclicDownTopAlgorithm();
        return acyclicDownTopAlgorithm.getDefiningAttribute(graph);
    }

    private void initializeVertexList() {
        this.vertexList = graph.getVertexes();
    }

    private void initializeVertexConnectionList() {
        this.vertexConnectionList = new ArrayList<VertexConnection<QueryAttribute>>();

        for (Vertex vertex : vertexList) {
            Collection<VertexConnection<QueryAttribute>> outgoingConnections = vertex.getOutgoingConnections();
            vertexConnectionList.addAll(outgoingConnections);
        }
    }

    private void initializeGraph() {
        ProductionSystem<QueryAttribute> productionSystem = new ProductionSystem(implicationList);
        ProductionSystemToGraphConverter productionSystemToGraphConverter = new ProductionSystemToGraphConverter(productionSystem);
        try {
            this.graph = productionSystemToGraphConverter.getGraph();
        } catch (Exception e) {
            e.printStackTrace();
        }
        initializeVertexList();
        initializeVertexConnectionList();
    }
}
