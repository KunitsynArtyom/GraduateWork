package diploma.logic.controllers;

import diploma.logic.algos.ConnectionAlgorithm;
import diploma.logic.algos.entities.AlgoConnection;
import diploma.logic.algos.entities.AlgoConnectionInstance;
import diploma.logic.algos.entities.AlgoMassProblem;
import diploma.logic.algos.services.ConnectionAlgorithmService;
import diploma.logic.entities.*;
import diploma.logic.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/**
 * Created by Артём on 19.02.2017.
 */
@Controller
@RequestMapping("/connection")
public class ConnectionController {

    private ApplicationContext context;

    @Autowired
    public void context(ApplicationContext context) { this.context = context; }

    @RequestMapping("/all")
    public String showConnectionList(Model model){
        ConnectionRepo repo = context.getBean(ConnectionRepo.class);
        List<Connection> connectionList = repo.getAllConnectionList();
        List<String> connectionDistinctList = repo.getAllDistinctSDList();
        model.addAttribute("connectionList", connectionList);
        model.addAttribute("connectionDistinctList", connectionDistinctList);
        model.addAttribute("request", new Request(new String()));
        return "connections";
    }

    @RequestMapping("/{id}")
    public String showInfo(Model model, @PathVariable("id") Integer id){
        ConnectionRepo connectionRepo = context.getBean(ConnectionRepo.class);
        model.addAttribute("connection", connectionRepo.findById(id));
        return "info/connectionInfo";
    }

    @RequestMapping(value = "/all", method = RequestMethod.POST)
    public String chooseToParse(Model model, @ModelAttribute Request request) throws Exception {
        ConnectionRepo connectionRepo = context.getBean(ConnectionRepo.class);
        ConnectionStateRepo connectionStateRepo  = context.getBean(ConnectionStateRepo.class);
        ConnectionStateInstanceRepo connectionStateInstanceRepo  = context.getBean(ConnectionStateInstanceRepo.class);
        MassProblemRepo massProblemRepo = context.getBean(MassProblemRepo.class);

        List<Connection> connections = connectionRepo.findBySDId(Integer.parseInt(request.getRequest()));
        List<List<AlgoConnectionInstance>> connectionInstanceList = new ArrayList<List<AlgoConnectionInstance>>();
        Set<AlgoConnection> algoConnectionList = new LinkedHashSet<AlgoConnection>();
        ConnectionAlgorithmService connectionAlgorithmService = new ConnectionAlgorithmService();

        algoConnectionList = connectionAlgorithmService.getAlgoConnectionList(context, connections);
        List<Integer> distinctSDList = connectionStateRepo.getAllDistinctSDStateBySDId(Integer.parseInt(request.getRequest()));
        List<ConnectionStateInstance> connectionStateInstanceList = connectionStateInstanceRepo.getOrderedByConnectionInstanceList(Integer.parseInt(request.getRequest()));
        connectionInstanceList = connectionAlgorithmService.getAlgoConnectionInstanceList(context, distinctSDList, connectionStateInstanceList);
        List<MassProblem> massProblemList = massProblemRepo.findBySDId(Integer.parseInt(request.getRequest()));

        List<AlgoMassProblem> algoMassProblemList = new ArrayList<AlgoMassProblem>();
        AlgoMassProblem massProblem1 = new AlgoMassProblem("Mass Problem 1");
        AlgoMassProblem massProblem2 = new AlgoMassProblem("Mass Problem 2");
        algoMassProblemList.add(massProblem1);
        algoMassProblemList.add(massProblem2);
        algoMassProblemList.add(massProblem1);

        ConnectionAlgorithm connectionAlgorithm = new ConnectionAlgorithm();
        connectionAlgorithm.calculate(algoConnectionList, connectionInstanceList, algoMassProblemList);

        model.addAttribute("stabilityMap", connectionAlgorithm.getStability());
        model.addAttribute("inevitabilityMap", connectionAlgorithm.getInevitability());
        model.addAttribute("createProbabilityMap", connectionAlgorithm.getCreateProbability());
        model.addAttribute("destroyProbabilityMap", connectionAlgorithm.getDestroyProbability());
        return "connections/connectionAlgorithm";
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllException(Exception ex) {
        ModelAndView model = new ModelAndView("errors/error");

        model.addObject("errMsg", ex.getMessage());
        return model;
    }
}
