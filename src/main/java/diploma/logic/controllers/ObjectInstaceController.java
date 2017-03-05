package diploma.logic.controllers;

import diploma.logic.entities.ObjectInstance;
import diploma.logic.repositories.ObjRepo;
import diploma.logic.repositories.ObjectInstanceRepo;
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

    @RequestMapping("/all")
    public String showObjectInstanceList(Model model){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        ObjectInstanceRepo repo = context.getBean(ObjectInstanceRepo.class);
        List<ObjectInstance> objectInstanceList = repo.getAllObjectInstanceList();
        model.addAttribute("objectInstanceList", objectInstanceList);
        return "objectInstances";
    }

    @RequestMapping("/{id}")
    public String showInfo(Model model, @PathVariable("id") Integer id){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        ObjectInstanceRepo objectInstanceRepo = context.getBean(ObjectInstanceRepo.class);
        ObjRepo objRepo = context.getBean(ObjRepo.class);
        model.addAttribute("objectInstance",  objectInstanceRepo.findById(id));
        model.addAttribute("objectList",  objRepo.findByObjInstanceId(id));
        return "info/objectInstanceInfo";
    }
}
