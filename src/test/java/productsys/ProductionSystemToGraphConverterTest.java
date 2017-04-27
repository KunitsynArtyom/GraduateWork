package productsys;

import diploma.logic.graphs.Graph;
import diploma.logic.graphs.Vertex;
import diploma.logic.graphs.VertexConnection;
import diploma.logic.algos.AcyclicDownTopAlgorithm;
import diploma.logic.graphs.prodsys.converters.ProductionSystemToGraphConverter;
import diploma.logic.graphs.prodsys.entities.DefiningAttribute;
import diploma.logic.graphs.prodsys.entities.Implication;
import diploma.logic.graphs.prodsys.entities.ProductionSystem;
import diploma.logic.parsers.entities.QueryAttribute;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Артём on 04.04.2017.
 */
public class ProductionSystemToGraphConverterTest {

    private Graph graph;
    private ProductionSystem<QueryAttribute> productionSystem;

    @Test
    public void testGetGraph() throws Exception {
        ProductionSystemToGraphConverter productionSystemToGraphConverter = new ProductionSystemToGraphConverter(productionSystem);
        graph = productionSystemToGraphConverter.getGraph();

        Collection<Vertex<QueryAttribute>> vertexList = graph.getVertexes();

        for(Vertex vertex : vertexList){
            System.out.println("Vertex:" + vertex.toString());
            Collection<VertexConnection<QueryAttribute>> outgoingConnections = vertex.getOutgoingConnections();
            Collection<VertexConnection<QueryAttribute>> ingoingConnections = vertex.getIngoingConnections();
            System.out.println("Outgoing:");
            for(VertexConnection vertexConnection1 : outgoingConnections){
                System.out.println(vertexConnection1.toString());
            }
            System.out.println("Ingoing:");
            for(VertexConnection vertexConnection2 : ingoingConnections){
                System.out.println(vertexConnection2.toString());
            }
        }
    }

    @Test
    public void testAcyclicDownTopAlgorithm() throws Exception {
        ProductionSystemToGraphConverter productionSystemToGraphConverter = new ProductionSystemToGraphConverter(productionSystem);
        graph = productionSystemToGraphConverter.getGraph();

        AcyclicDownTopAlgorithm acyclicDownTopAlgorithm = new AcyclicDownTopAlgorithm();
        Collection<DefiningAttribute> definingAttributes = acyclicDownTopAlgorithm.getDefiningAttribute(graph);

        for(DefiningAttribute definingAttribute : definingAttributes){
            System.out.println(definingAttribute.toString());
        }
    }

    @Before
    public void setUp(){
        ArrayList<QueryAttribute> arguments1 = new ArrayList<QueryAttribute>();
        QueryAttribute queryAttribute1 = new QueryAttribute("1");
        QueryAttribute queryAttribute2 = new QueryAttribute("2");
        QueryAttribute queryAttribute3 = new QueryAttribute("3");

        arguments1.add(queryAttribute1);
        arguments1.add(queryAttribute2);
        arguments1.add(queryAttribute3);

        QueryAttribute queryResult11 = new QueryAttribute("4");
        QueryAttribute queryResult12 = new QueryAttribute("6");
        ArrayList<QueryAttribute> results1 = new ArrayList<QueryAttribute>();
        results1.add(queryResult11);
        results1.add(queryResult12);

        ArrayList<QueryAttribute> arguments2 = new ArrayList<QueryAttribute>();
        QueryAttribute queryAttribute11 = new QueryAttribute("1");
        QueryAttribute queryAttribute12 = new QueryAttribute("3");
        QueryAttribute queryAttribute13 = new QueryAttribute("4");
        arguments2.add(queryAttribute11);
        arguments2.add(queryAttribute12);
        arguments2.add(queryAttribute13);

        QueryAttribute queryResult2 = new QueryAttribute("5");
        ArrayList<QueryAttribute> results2 = new ArrayList<QueryAttribute>();
        results2.add(queryResult2);

        List<Implication<QueryAttribute>> implicationList = new ArrayList<Implication<QueryAttribute>>();

        try {
            Implication<QueryAttribute> implication1 = new Implication(arguments1, results1);
            implicationList.add(implication1);
            Implication<QueryAttribute> implication2 = new Implication(arguments2, results2);
            implicationList.add(implication2);
        } catch (Exception ex) { }

        if(!implicationList.isEmpty()){
            productionSystem = new ProductionSystem(implicationList);
        }

    }
}
