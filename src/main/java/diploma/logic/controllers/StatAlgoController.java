package diploma.logic.controllers;

import diploma.logic.entities.stat.StatAlgo;
import diploma.logic.repositories.StatAlgoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Артём on 28.05.2017.
 */
@Controller
@RequestMapping("/statAlgo")
public class StatAlgoController {

    private ApplicationContext context;

    @Autowired
    public void context(ApplicationContext context) { this.context = context; }

    @RequestMapping("/all")
    public String showStat(Model model){
        StatAlgoRepo repo = context.getBean(StatAlgoRepo.class);
        List<StatAlgo> definingAttributesStatList = repo.getDefiningAttributeStatList();
        for(StatAlgo statAlgo : definingAttributesStatList){
            System.out.println(statAlgo.getStatName() + "   " + statAlgo.getStatValue());
        }
        return "";
    }
}
