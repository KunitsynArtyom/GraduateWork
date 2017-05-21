package diploma.logic.controllers;

import diploma.logic.entities.ObjectInstance;
import diploma.logic.repositories.ObjRepo;
import diploma.logic.repositories.ObjectInstanceRepo;
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
@RequestMapping("/objectInstance")
public class ObjectInstaceController {

    private ApplicationContext context;

    @Autowired
    public void context(ApplicationContext context) { this.context = context; }

    @RequestMapping("/all")
    public String showObjectInstanceList(Model model){
        ObjectInstanceRepo repo = context.getBean(ObjectInstanceRepo.class);
        List<ObjectInstance> objectInstanceList = repo.getAllObjectInstanceList();
        model.addAttribute("objectInstanceList", objectInstanceList);
        return "objectInstances";
    }

    @RequestMapping("/{id}")
    public String showInfo(Model model, @PathVariable("id") Integer id){
        ObjectInstanceRepo objectInstanceRepo = context.getBean(ObjectInstanceRepo.class);
        ObjRepo objRepo = context.getBean(ObjRepo.class);
        model.addAttribute("objectInstance",  objectInstanceRepo.findById(id));
        return "info/objectInstanceInfo";
    }
}
