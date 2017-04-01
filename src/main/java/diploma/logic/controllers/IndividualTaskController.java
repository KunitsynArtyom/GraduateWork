package diploma.logic.controllers;

import diploma.logic.entities.IndividualTask;
import diploma.logic.repositories.IndividualTaskRepo;
import diploma.logic.repositories.ParameterValueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Артём on 23.02.2017.
 */
@Controller
@RequestMapping("/individualTask")
public class IndividualTaskController {

    private ApplicationContext context;

    @Autowired
    public void context(ApplicationContext context) { this.context = context; }

    @RequestMapping("/all")
    public String showIndividualTaskList(Model model){
        IndividualTaskRepo repo = context.getBean(IndividualTaskRepo.class);
        List<IndividualTask> individualTaskList = repo.getAllIndividualTaskList();
        model.addAttribute("individualTaskList", individualTaskList);
        return "individualTasks";
    }

    @RequestMapping("/{id}")
    public String showInfo(Model model, @PathVariable("id") Integer id){
        IndividualTaskRepo individualTaskRepo = context.getBean(IndividualTaskRepo.class);
        ParameterValueRepo parameterValueRepo = context.getBean(ParameterValueRepo.class);
        model.addAttribute("individualTask", individualTaskRepo.findById(id));
        model.addAttribute("parameterValueList", parameterValueRepo.findByIndividualTaskId(id));
        return "info/individualTaskInfo";
    }
}
