package diploma.logic.controllers;

import diploma.logic.entities.AttributeValue;
import diploma.logic.repositories.AttributeValueRepo;
import diploma.logic.repositories.ObjectStateRepo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by Артём on 21.02.2017.
 */
@Controller
@RequestMapping("/attributeValue")
public class AttributeValueController {

    @RequestMapping("/all")
    public String showAttributeValueList(Model model){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        AttributeValueRepo repo = context.getBean(AttributeValueRepo.class);
        List<AttributeValue> attributeValueList = repo.getAllAttributeValueList();
        model.addAttribute("attributeValueList", attributeValueList);
        return "attributeValues";
    }

    @RequestMapping("/{id}")
    public String showInfo(Model model, @PathVariable("id") Integer id){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        AttributeValueRepo attributeValueRepo = context.getBean(AttributeValueRepo.class);
        ObjectStateRepo objectStateRepo = context.getBean(ObjectStateRepo.class);
        model.addAttribute("attributeValue",  attributeValueRepo.findById(id));
        model.addAttribute("objectStateList",  objectStateRepo.findByAttributeValueId(id));
        return "info/attributeValueInfo";
    }
}
