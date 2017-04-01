package diploma.logic.controllers;

import diploma.logic.entities.MassProblem;
import diploma.logic.repositories.IndividualTaskRepo;
import diploma.logic.repositories.MassProblemRepo;
import diploma.logic.repositories.ParameterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
        model.addAttribute("massProblemList", massProblemList);
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
}
