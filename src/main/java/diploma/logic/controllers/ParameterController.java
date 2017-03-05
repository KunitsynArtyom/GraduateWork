package diploma.logic.controllers;

import diploma.logic.entities.Parameter;
import diploma.logic.repositories.ParameterRepo;
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
@RequestMapping("/parameter")
public class ParameterController {

    @RequestMapping("/all")
    public String showParameterList(Model model){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        ParameterRepo repo = context.getBean(ParameterRepo.class);
        List<Parameter> parameterList = repo.getAllParameterList();
        model.addAttribute("parameterList", parameterList);
        return "parameters";
    }

    @RequestMapping("/{id}")
    public String showInfo(Model model, @PathVariable("id") Integer id){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        ParameterRepo parameterRepo = context.getBean(ParameterRepo.class);
        model.addAttribute("parameter",  parameterRepo.findById(id));
        return "info/parameterInfo";
    }
}
