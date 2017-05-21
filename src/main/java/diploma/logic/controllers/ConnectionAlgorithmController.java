package diploma.logic.controllers;

import diploma.logic.algos.ConnectionAlgorithm;
import diploma.logic.algos.entities.*;
import diploma.logic.algos.services.ConnectionAlgorithmService;
import diploma.logic.entities.Obj;
import diploma.logic.entities.*;
import diploma.logic.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

/**
 * Created by Артём on 17.04.2017.
 */
@Controller
@RequestMapping("/connectionAlgorithm")
public class ConnectionAlgorithmController {

    private ApplicationContext context;

    @Autowired
    public void context(ApplicationContext context) { this.context = context; }

    @RequestMapping("/")
    public String calculateMeasures(Model model){
        Set<AlgoConnection> connectionSet;
        Set<AlgoObj> objSet;
        List<List<AlgoConnectionInstance>> connectionInstanceList;
        List<AlgoMassProblem> massProblemList;

        objSet = new HashSet<AlgoObj>();
        connectionSet = new HashSet<AlgoConnection>();
        connectionInstanceList = new ArrayList<List<AlgoConnectionInstance>>();
        massProblemList = new ArrayList<AlgoMassProblem>();

        List<AlgoObjInstance> objectInstances1 = new ArrayList<AlgoObjInstance>();
        objectInstances1.add(new AlgoObjInstance("Винни-Пух"));
        objectInstances1.add(new AlgoObjInstance("Колобок"));
        AlgoObj obj1 = new AlgoObj("Книги", objectInstances1);

        List<AlgoObjInstance> objectInstances2 = new ArrayList<AlgoObjInstance>();
        objectInstances2.add(new AlgoObjInstance("Сказка"));
        AlgoObj obj2 = new AlgoObj("Жанр", objectInstances2);

        List<AlgoObjInstance> objectInstances3 = new ArrayList<AlgoObjInstance>();
        objectInstances3.add(new AlgoObjInstance("Милн"));
        objectInstances3.add(new AlgoObjInstance("Народ"));
        AlgoObj obj3 = new AlgoObj("Автор", objectInstances3);

        objSet.add(obj1);
        objSet.add(obj2);
        objSet.add(obj3);

        AlgoConnection conn1 = new AlgoConnection(obj1, obj2);
        AlgoConnection conn2 = new AlgoConnection(obj1, obj3);

        connectionSet.add(conn1);
        connectionSet.add(conn2);

        List<AlgoConnectionInstance> connectionInstanceList1 = new ArrayList<AlgoConnectionInstance>();
        connectionInstanceList1.add(new AlgoConnectionInstance("Винни-Пух", "Сказка"));
        connectionInstanceList1.add(new AlgoConnectionInstance("Винни-Пух", "Милн"));

        List<AlgoConnectionInstance> connectionInstanceList2 = new ArrayList<AlgoConnectionInstance>();
        connectionInstanceList2.add(new AlgoConnectionInstance("Винни-Пух", "Сказка"));
        connectionInstanceList2.add(new AlgoConnectionInstance("Колобок", "Сказка"));
        connectionInstanceList2.add(new AlgoConnectionInstance("Винни-Пух", "Милн"));
        connectionInstanceList2.add(new AlgoConnectionInstance("Колобок", "Народ"));

        List<AlgoConnectionInstance> connectionInstanceList3 = new ArrayList<AlgoConnectionInstance>();
        connectionInstanceList3.add(new AlgoConnectionInstance("Винни-Пух", "Сказка"));
        connectionInstanceList3.add(new AlgoConnectionInstance("Винни-Пух", "Милн"));

        List<AlgoConnectionInstance> connectionInstanceList4 = new ArrayList<AlgoConnectionInstance>();
        connectionInstanceList4.add(new AlgoConnectionInstance("Винни-Пух", "Сказка"));

        connectionInstanceList.add(connectionInstanceList1);
        connectionInstanceList.add(connectionInstanceList2);
        connectionInstanceList.add(connectionInstanceList3);
        connectionInstanceList.add(connectionInstanceList4);

        AlgoMassProblem massProblem1 = new AlgoMassProblem("Mass Problem 1");
        AlgoMassProblem massProblem2 = new AlgoMassProblem("Mass Problem 2");
        //MassProblem massProblem3 = new MassProblem("Mass Problem 3");
        massProblemList.add(massProblem1);
        massProblemList.add(massProblem2);
        massProblemList.add(massProblem1);

        ConnectionAlgorithm connectionAlgorithm = new ConnectionAlgorithm();
        connectionAlgorithm.calculate(connectionSet, connectionInstanceList, massProblemList);

        model.addAttribute("createProbabilityMap", connectionAlgorithm.getCreateProbability());
        return "connections/connectionAlgorithm";
    }
}
