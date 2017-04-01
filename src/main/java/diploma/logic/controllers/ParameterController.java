package diploma.logic.controllers;

import diploma.logic.entities.Parameter;
import diploma.logic.repositories.ParameterRepo;
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
@RequestMapping("/parameter")
public class ParameterController {

    private ApplicationContext context;

    @Autowired
    public void context(ApplicationContext context) { this.context = context; }

    @RequestMapping("/all")
    public String showParameterList(Model model){
        ParameterRepo repo = context.getBean(ParameterRepo.class);
        List<Parameter> parameterList = repo.getAllParameterList();
        model.addAttribute("parameterList", parameterList);
        return "parameters";
    }

    @RequestMapping("/{id}")
    public String showInfo(Model model, @PathVariable("id") Integer id){
        ParameterRepo parameterRepo = context.getBean(ParameterRepo.class);
        ParameterValueRepo parameterValueRepo = context.getBean(ParameterValueRepo.class);
        model.addAttribute("parameter",  parameterRepo.findById(id));
        model.addAttribute("parameterValueList",  parameterValueRepo.findByParameterId(id));
        return "info/parameterInfo";
    }
}
