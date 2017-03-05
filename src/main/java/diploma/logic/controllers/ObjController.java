package diploma.logic.controllers;

import diploma.logic.entities.Obj;
import diploma.logic.repositories.AttributeRepo;
import diploma.logic.repositories.ObjRepo;
import diploma.logic.repositories.ObjectListRepo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
/**
 * Created by Артём on 18.02.2017.
 */
@Controller
@RequestMapping("/object")
public class ObjController {

    @RequestMapping("/all")
    public String showObjectList(Model model){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        ObjRepo repo = context.getBean(ObjRepo.class);
        List<Obj> objectList = repo.getAllObjList();
        model.addAttribute("objectList", objectList);
        return "objects";
    }

    @RequestMapping("/{id}")
    public String showInfo(Model model, @PathVariable("id") Integer id){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        ObjRepo objRepo = context.getBean(ObjRepo.class);
        AttributeRepo attributeRepo = context.getBean(AttributeRepo.class);
        ObjectListRepo objectListRepo = context.getBean(ObjectListRepo.class);
        model.addAttribute("object",  objRepo.findById(id));
        model.addAttribute("attributeList",  attributeRepo.findByObjId(id));
        model.addAttribute("objectListsList",  objectListRepo.findByObjId(id));
        return "info/objectInfo";
    }
}
