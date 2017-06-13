package diploma.logic.controllers;

import diploma.logic.algos.services.AcyclicDownTopAlgorithmService;
import diploma.logic.algos.services.StatService;
import diploma.logic.entities.IndividualTask;
import diploma.logic.entities.Request;
import diploma.logic.entities.MassProblem;
import diploma.logic.entities.stat.InsertStat;
import diploma.logic.graphs.Vertex;
import diploma.logic.graphs.prodsys.entities.DefiningAttribute;
import diploma.logic.graphs.prodsys.entities.Implication;
import diploma.logic.parsers.SQLFunctionParser;
import diploma.logic.parsers.SQLParser;
import diploma.logic.parsers.entities.QueryAttribute;
import diploma.logic.repositories.IndividualTaskRepo;
import diploma.logic.repositories.MassProblemRepo;
import diploma.logic.repositories.ParameterRepo;
import diploma.logic.repositories.StatAlgoRepo;
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
        IndividualTaskRepo individualTaskRepo = context.getBean(IndividualTaskRepo.class);
        StatAlgoRepo statAlgoRepo = context.getBean(StatAlgoRepo.class);

        List<IndividualTask> massProblemList = individualTaskRepo.findByMassProblemId(Integer.parseInt(request.getRequest()));
        AcyclicDownTopAlgorithmService acyclicDownTopAlgorithmService = new AcyclicDownTopAlgorithmService(AcyclicDownTopAlgorithmService.createImplicationList(massProblemList));
        List<DefiningAttribute> definingAttributeList = (List<DefiningAttribute>)acyclicDownTopAlgorithmService.getDefiningAttributes();

        Integer algoId = statAlgoRepo.getDefiningAttributesAlgoId();

        for(DefiningAttribute definingAttribute : definingAttributeList){
            statAlgoRepo.insertNewStat(new InsertStat(algoId, definingAttribute.getMeasure(), definingAttribute.getAttribute().getName(), "definingAttribute"));
        }

        model.addAttribute("vertexList", acyclicDownTopAlgorithmService.getVertexList());
        model.addAttribute("vertexConnectionList", acyclicDownTopAlgorithmService.getVertexConnectionList());
        model.addAttribute("definingAttributes", acyclicDownTopAlgorithmService.getDefiningAttributes());

        return "graphs/graph";
    }
}