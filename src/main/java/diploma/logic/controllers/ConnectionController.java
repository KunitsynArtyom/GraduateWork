package diploma.logic.controllers;

import diploma.logic.algos.ConnectionAlgorithm;
import diploma.logic.algos.entities.AlgoConnection;
import diploma.logic.algos.entities.AlgoConnectionInstance;
import diploma.logic.algos.entities.AlgoMassProblem;
import diploma.logic.algos.services.ConnectionAlgorithmService;
import diploma.logic.algos.services.StatService;
import diploma.logic.entities.*;
import diploma.logic.entities.stat.InsertStat;
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
        model.addAttribute("connectionInstanceList", connectionRepo.findBySDId(id));
        return "info/connectionInfo";
    }

    @RequestMapping(value = "/all", method = RequestMethod.POST)
    public String chooseToParse(Model model, @ModelAttribute Request request) throws Exception {
        ConnectionRepo connectionRepo = context.getBean(ConnectionRepo.class);
        ConnectionStateRepo connectionStateRepo  = context.getBean(ConnectionStateRepo.class);
        ConnectionStateInstanceRepo connectionStateInstanceRepo  = context.getBean(ConnectionStateInstanceRepo.class);
        MassProblemRepo massProblemRepo = context.getBean(MassProblemRepo.class);
        IndividualTaskRepo individualTaskRepo = context.getBean(IndividualTaskRepo.class);
        StatAlgoRepo statAlgoRepo = context.getBean(StatAlgoRepo.class);

        List<Connection> connections = connectionRepo.findBySDId(Integer.parseInt(request.getRequest()));
        List<List<AlgoConnectionInstance>> connectionInstanceList = new ArrayList<List<AlgoConnectionInstance>>();
        Set<AlgoConnection> algoConnectionList = new LinkedHashSet<AlgoConnection>();
        ConnectionAlgorithmService connectionAlgorithmService = new ConnectionAlgorithmService();

        algoConnectionList = connectionAlgorithmService.getAlgoConnectionList(context, connections);
        List<Integer> distinctSDList = connectionStateRepo.getAllDistinctSDStateBySDId(Integer.parseInt(request.getRequest()));
        List<ConnectionStateInstance> connectionStateInstanceList = connectionStateInstanceRepo.getOrderedByConnectionInstanceList(Integer.parseInt(request.getRequest()));
        connectionInstanceList = connectionAlgorithmService.getAlgoConnectionInstanceList(context, distinctSDList, connectionStateInstanceList);

        List<AlgoMassProblem> algoMassProblemList = new ArrayList<AlgoMassProblem>();
        List<IndividualTask> individualTaskList = individualTaskRepo.getOrderedIndividualTaskListForSD(Integer.parseInt(request.getRequest()));

        for(IndividualTask individualTask : individualTaskList){
            algoMassProblemList.add(new AlgoMassProblem(massProblemRepo.findById(individualTask.getMassProblemId()).getName()));
        }

        ConnectionAlgorithm connectionAlgorithm = new ConnectionAlgorithm();
        connectionAlgorithm.calculate(algoConnectionList, connectionInstanceList, algoMassProblemList);

        StatService statService = new StatService();
        List<InsertStat> stabilityInsertList = statService.convertToInsertStatList(connectionAlgorithm.getStability(),
                statAlgoRepo.getConnectionsAlgoId(), "Stability");
        List<InsertStat> inevitabilityInsertList = statService.convertToInsertStatList(connectionAlgorithm.getInevitability(),
                statAlgoRepo.getConnectionsAlgoId(), "Inevitability");
        List<InsertStat> createProbabilityInsertList = statService.convertToInsertConnectionStatList(connectionAlgorithm.getCreateProbability(),
                statAlgoRepo.getConnectionsAlgoId(), "Create Probability");
        List<InsertStat> destroyProbabilityInsertList = statService.convertToInsertConnectionStatList(connectionAlgorithm.getDestroyProbability(),
                statAlgoRepo.getConnectionsAlgoId(), "Destroy Probability");

        for(InsertStat insertStat : stabilityInsertList){
            statAlgoRepo.insertNewStat(insertStat);
        }

        for(InsertStat insertStat : inevitabilityInsertList){
            statAlgoRepo.insertNewStat(insertStat);
        }

        for(InsertStat insertStat : createProbabilityInsertList){
            statAlgoRepo.insertNewStat(insertStat);
        }

        for(InsertStat insertStat : destroyProbabilityInsertList){
            statAlgoRepo.insertNewStat(insertStat);
        }

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
