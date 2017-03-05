package diploma.logic.controllers;

import diploma.logic.entities.ObjectState;
import diploma.logic.repositories.ObjectStateRepo;
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
@RequestMapping("/objectState")
public class ObjectStateController {

    @RequestMapping("/all")
    public String showObjectListList(Model model){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        ObjectStateRepo repo = context.getBean(ObjectStateRepo.class);
        List<ObjectState> objectStateList = repo.getAllObjectStateList();
        model.addAttribute("objectStateList", objectStateList);
        return "objectStates";
    }
}
