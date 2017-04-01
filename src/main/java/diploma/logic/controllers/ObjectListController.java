package diploma.logic.controllers;

import diploma.logic.entities.ObjectList;
import diploma.logic.repositories.ObjectListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Артём on 21.02.2017.
 */
@Controller
@RequestMapping("/objectList")
public class ObjectListController {

    private ApplicationContext context;

    @Autowired
    public void context(ApplicationContext context) { this.context = context; }

    @RequestMapping("/all")
    public String showObjectListList(Model model){
        ObjectListRepo repo = context.getBean(ObjectListRepo.class);
        List<ObjectList> objectListsList = repo.getAllObjectListsList();
        model.addAttribute("objectListsList", objectListsList);
        return "objectLists";
    }
}
