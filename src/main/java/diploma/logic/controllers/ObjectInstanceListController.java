package diploma.logic.controllers;

import diploma.logic.entities.ObjectInstanceList;
import diploma.logic.repositories.ObjectInstanceListRepo;
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

    @RequestMapping("/all")
    public String showObjectInstanceListList(Model model){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        ObjectInstanceListRepo repo = context.getBean(ObjectInstanceListRepo.class);
        List<ObjectInstanceList> objectInstanceListsList = repo.getAllObjectInstanceListsList();
        model.addAttribute("objectInstanceListsList", objectInstanceListsList);
        return "objectInstanceLists";
    }
}
