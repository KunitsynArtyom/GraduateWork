package diploma.logic.controllers;

import diploma.logic.algos.services.AcyclicDownTopAlgorithmService;
import diploma.logic.entities.Request;
import diploma.logic.entities.MassProblem;
import diploma.logic.graphs.prodsys.entities.Implication;
import diploma.logic.parsers.SQLFunctionParser;
import diploma.logic.parsers.SQLParser;
import diploma.logic.parsers.entities.QueryAttribute;
import diploma.logic.repositories.IndividualTaskRepo;
import diploma.logic.repositories.MassProblemRepo;
import diploma.logic.repositories.ParameterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Артём on 19.02.2017.
 */
@Controller
@RequestMapping("/massProblem")
public class MassProblemController {

    private ApplicationContext context;

    @Autowired
    public void context(ApplicationContext context) { this.context = context; }

    @RequestMapping("/all")
    public String showMassProblemList(Model model){
        MassProblemRepo repo = context.getBean(MassProblemRepo.class);
        List<MassProblem> massProblemList = repo.getAllMassProblemList();
        List<String> massProblemDistinctList = repo.getAllDistinctSDList();
        model.addAttribute("massProblemList", massProblemList);
        model.addAttribute("massProblemDistinctList", massProblemDistinctList);
        model.addAttribute("request", new Request(new String()));
        return "massProblems";
    }

    @RequestMapping("/{id}")
    public String showInfo(Model model, @PathVariable("id") Integer id){
        MassProblemRepo massProblemRepo = context.getBean(MassProblemRepo.class);
        ParameterRepo parameterRepo = context.getBean(ParameterRepo.class);
        IndividualTaskRepo individualTaskRepo = context.getBean(IndividualTaskRepo.class);
        model.addAttribute("massProblem",  massProblemRepo.findById(id));
        model.addAttribute("parameterList",  parameterRepo.findByMassProblemId(id));
        model.addAttribute("individualTaskList",  individualTaskRepo.findByMassProblemId(id));
        return "info/massProblemInfo";
    }

    @RequestMapping(value = "/all", method = RequestMethod.POST)
    public String parseSD(Model model, @ModelAttribute Request request){
        MassProblemRepo massProblemRepo = context.getBean(MassProblemRepo.class);
        List<MassProblem> massProblemList = massProblemRepo.findBySDId(Integer.parseInt(request.getRequest()));
//        List<List<String>> parsedFunctionQueryList = new ArrayList<List<String>>();
//        List<Implication<QueryAttribute>> implicationList = new ArrayList<Implication<QueryAttribute>>();
//
//        for (MassProblem massProblem : massProblemList) {
//            parsedFunctionQueryList.add(new SQLFunctionParser(massProblem.getName()).parseSQLFunction());
//        }
//
//        for (List<String> list : parsedFunctionQueryList) {
//            implicationList.add(new SQLParser(list).getImplication());
//        }

        AcyclicDownTopAlgorithmService acyclicDownTopAlgorithmService = new AcyclicDownTopAlgorithmService(AcyclicDownTopAlgorithmService.createImplicationList(massProblemList));

        model.addAttribute("vertexList", acyclicDownTopAlgorithmService.getVertexList());
        model.addAttribute("vertexConnectionList", acyclicDownTopAlgorithmService.getVertexConnectionList());
        model.addAttribute("definingAttributes", acyclicDownTopAlgorithmService.getDefiningAttributes());

        return "graphs/graph";
    }

}
