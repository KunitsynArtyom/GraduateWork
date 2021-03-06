package diploma.logic.controllers;

import diploma.logic.entities.ParameterValue;
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
 * Created by Артём on 05.03.2017.
 */
@Controller
@RequestMapping("/parameterValue")
public class ParameterValueController {

    private ApplicationContext context;

    @Autowired
    public void context(ApplicationContext context) { this.context = context; }

    @RequestMapping("/all")
    public String showParameterValueList(Model model){
        ParameterValueRepo repo = context.getBean(ParameterValueRepo.class);
        List<ParameterValue> parameterValueList = repo.getAllParameterValueList();
        model.addAttribute("parameterValueList", parameterValueList);
        return "parameterValues";
    }

    @RequestMapping("/{id}")
    public String showInfo(Model model, @PathVariable("id") Integer id){
        ParameterValueRepo parameterValueRepo = context.getBean(ParameterValueRepo.class);
        model.addAttribute("parameterValue",  parameterValueRepo.findById(id));
        return "info/parameterValueInfo";
    }
}
