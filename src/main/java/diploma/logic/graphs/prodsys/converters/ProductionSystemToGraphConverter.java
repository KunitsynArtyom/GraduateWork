package diploma.logic.graphs.prodsys.converters;


import diploma.logic.graphs.Graph;
import diploma.logic.graphs.Vertex;
import diploma.logic.graphs.VertexConnection;
import diploma.logic.graphs.prodsys.entities.Implication;
import diploma.logic.graphs.prodsys.entities.ProductionSystem;
import diploma.logic.parsers.entities.QueryAttribute;

import java.util.Collection;

public class ProductionSystemToGraphConverter {

    public static final String NEITHER_CREATED_VERTEX_IN_GRAPH_NOR_FOUND_ONE = "Neither created vertex in graph, nor found one";
    private ProductionSystem<QueryAttribute> productionSystem;
    private Graph<QueryAttribute> graph;

    public ProductionSystemToGraphConverter(ProductionSystem<QueryAttribute> productionSystem) {
        this.productionSystem = productionSystem;
    }

    private void run() throws Exception {
        graph = new Graph<QueryAttribute>();
        addConnectionsFromImplications();
    }

    private void addConnectionsFromImplications() throws Exception {
        Collection<Implication<QueryAttribute>> implications = productionSystem.getImplications();
        for (Implication<QueryAttribute> implication : implications) {
            addConnectionsFromImplication(implication);
        }
    }

    private void addConnectionsFromImplication(Implication<QueryAttribute> implication) throws Exception {
        Collection<QueryAttribute> results = implication.getResult();
        Collection<QueryAttribute> arguments = implication.getArguments();

        for(QueryAttribute result : results) {
            Vertex<QueryAttribute> resultVertex = createOrGetVertexFromGraph(result);

            for (QueryAttribute argument : arguments) {
                createConnectionIfNeeded(resultVertex, argument);
            }
        }

    }

    private void createConnectionIfNeeded(Vertex<QueryAttribute> resultVertex, QueryAttribute argument) throws Exception {
        Vertex<QueryAttribute> argumentVertex = createOrGetVertexFromGraph(argument);
        VertexConnection<QueryAttribute> connection = new VertexConnection<QueryAttribute>(argumentVertex, resultVertex);
        if(!argumentVertex.containsOutgoingConnection(connection)){
            argumentVertex.addOutgoingConnection(resultVertex);
        }

        if(!resultVertex.containsIngoingConnection(connection)){
            resultVertex.addIngoingConnection(argumentVertex);
        }
    }

    private Vertex<QueryAttribute> createOrGetVertexFromGraph(QueryAttribute result) throws Exception {
        Vertex<QueryAttribute> resultVertex = new Vertex<QueryAttribute>(result);
        resultVertex = addIfNeeded(resultVertex);
        return resultVertex;
    }

    private Vertex<QueryAttribute> addIfNeeded(Vertex<QueryAttribute> resultVertex) throws Exception {
        if(!graph.containsVertex(resultVertex)){
            graph.addVertex(resultVertex);
            return resultVertex;
        }else{
            Collection<Vertex<QueryAttribute>> vertexes = graph.getVertexes();
            for(Vertex<QueryAttribute> vertex : vertexes){
                if(resultVertex.equals(vertex)){
                    return vertex;
                }
            }
        }
        throw new Exception(NEITHER_CREATED_VERTEX_IN_GRAPH_NOR_FOUND_ONE);
    }

    public Graph<QueryAttribute> getGraph() throws Exception {
        if(graph == null){
            run();
        }
        return graph;
    }
}
