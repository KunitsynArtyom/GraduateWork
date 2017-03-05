package diploma.logic.controllers;

import diploma.logic.entities.SubjectDomain;
import diploma.logic.repositories.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Артём on 13.02.2017.
 */
@Controller
@RequestMapping("/subjectDomain")
public class SubjectDomainController {

    @RequestMapping("/all")
    public String showSubjectDomainList(Model model){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        SubjectDomainRepo repo = context.getBean(SubjectDomainRepo.class);
        List<SubjectDomain> subjectDomainList = repo.getAllSDList();
        model.addAttribute("subjectDomainList", subjectDomainList);
        return "subjectDomains";
    }

    @RequestMapping("/{id}")
    public String showInfo(Model model, @PathVariable("id") Integer id){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        SubjectDomainRepo sdRepo = context.getBean(SubjectDomainRepo.class);
        SubjectDomainStateRepo sdStateRepo = context.getBean(SubjectDomainStateRepo.class);
        ObjRepo objRepo = context.getBean(ObjRepo.class);
        ConnectionRepo connectionRepo = context.getBean(ConnectionRepo.class);
        MassProblemRepo massProblemRepo = context.getBean(MassProblemRepo.class);
        model.addAttribute("subjectDomain",  sdRepo.findById(id));
        model.addAttribute("subjectDomainStateList", sdStateRepo.findBySDId(id));
        model.addAttribute("objList", objRepo.findBySDId(id));
        model.addAttribute("connectionList", connectionRepo.findBySDId(id));
        model.addAttribute("massProblemList", massProblemRepo.findBySDId(id));
        return "info/subjectDomainInfo";
    }
}
