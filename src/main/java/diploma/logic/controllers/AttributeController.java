package diploma.logic.controllers;

import diploma.logic.entities.Attribute;
import diploma.logic.repositories.AttributeRepo;
import diploma.logic.repositories.AttributeValueRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Артём on 19.02.2017.
 */

@Controller
@RequestMapping("/attribute")
public class AttributeController {

    private ApplicationContext context;

    @Autowired
    public void context(ApplicationContext context) { this.context = context; }

    @RequestMapping("/all")
    public String showAttributeList(Model model){
        AttributeRepo repo = context.getBean(AttributeRepo.class);
        List<Attribute> attributeList = repo.getAllAttributeList();
        model.addAttribute("attributeList", attributeList);
        return "attributes";
    }

    @RequestMapping("/{id}")
    public String showInfo(Model model, @PathVariable("id") Integer id){
        AttributeRepo attributeRepo = context.getBean(AttributeRepo.class);
        AttributeValueRepo attributeValueRepo = context.getBean(AttributeValueRepo.class);
        model.addAttribute("attribute",  attributeRepo.findById(id));
        model.addAttribute("attributeValueList",  attributeValueRepo.findByAttributeId(id));
        return "info/attributeInfo";
    }
}
