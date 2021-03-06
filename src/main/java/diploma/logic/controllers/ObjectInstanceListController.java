package diploma.logic.controllers;

import diploma.logic.entities.ObjectInstance;
import diploma.logic.entities.ObjectInstanceList;
import diploma.logic.repositories.ObjectInstanceListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Артём on 21.02.2017.
 */
@Controller
@RequestMapping("/objectInstanceList")
public class ObjectInstanceListController {

    private ApplicationContext context;

    @Autowired
    public void context(ApplicationContext context) { this.context = context; }

    @RequestMapping("/all")
    public String showObjectInstanceListList(Model model){
        ObjectInstanceListRepo repo = context.getBean(ObjectInstanceListRepo.class);
        List<ObjectInstanceList> objectInstanceListsList = repo.getAllObjectInstanceListsList();
        model.addAttribute("objectInstanceListsList", objectInstanceListsList);
        return "objectInstanceLists";
    }
}
