package diploma.logic.controllers;

import diploma.logic.graphs.Graph;
import diploma.logic.graphs.Vertex;
import diploma.logic.graphs.VertexConnection;
import diploma.logic.algos.AcyclicDownTopAlgorithm;
import diploma.logic.graphs.prodsys.converters.ProductionSystemToGraphConverter;
import diploma.logic.graphs.prodsys.entities.DefiningAttribute;
import diploma.logic.graphs.prodsys.entities.Implication;
import diploma.logic.graphs.prodsys.entities.ProductionSystem;
import diploma.logic.parsers.entities.QueryAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Артём on 06.04.2017.
 */
@Controller
@RequestMapping("/graph")
public class GraphController {

    private ApplicationContext context;

    @Autowired
    public void context(ApplicationContext context) { this.context = context; }


    @RequestMapping("/graph")
    public String showGraph(Model model) throws Exception {

        Graph graph;
        ProductionSystem<QueryAttribute> productionSystem;

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

        productionSystem = new ProductionSystem(implicationList);

        ProductionSystemToGraphConverter productionSystemToGraphConverter = new ProductionSystemToGraphConverter(productionSystem);
        graph = productionSystemToGraphConverter.getGraph();

        Collection<Vertex<QueryAttribute>> vertexList = graph.getVertexes();
        List<VertexConnection<QueryAttribute>> vertexConnectionList = new ArrayList<VertexConnection<QueryAttribute>>();

        for(Vertex vertex : vertexList) {
            Collection<VertexConnection<QueryAttribute>> outgoingConnections = vertex.getOutgoingConnections();
            vertexConnectionList.addAll(outgoingConnections);
        }

        AcyclicDownTopAlgorithm acyclicDownTopAlgorithm = new AcyclicDownTopAlgorithm();
        Collection<DefiningAttribute> definingAttributes = acyclicDownTopAlgorithm.getDefiningAttribute(graph);

        model.addAttribute("vertexList", vertexList);
        model.addAttribute("vertexConnectionList", vertexConnectionList);
        model.addAttribute("definingAttributes", definingAttributes);
        return "graphs/graph";
    }
}
