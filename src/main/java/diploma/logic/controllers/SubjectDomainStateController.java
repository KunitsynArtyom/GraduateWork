package diploma.logic.controllers;

import diploma.logic.entities.SubjectDomainState;
import diploma.logic.repositories.ConnectionStateRepo;
import diploma.logic.repositories.SubjectDomainStateRepo;
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
@RequestMapping("/subjectDomainState")
public class SubjectDomainStateController {

    @RequestMapping("/all")
    public String showSubjectDomainStateList(Model model){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        SubjectDomainStateRepo repo = context.getBean(SubjectDomainStateRepo.class);
        List<SubjectDomainState> subjectDomainStateList = repo.getAllSDStateList();
        model.addAttribute("subjectDomainStateList", subjectDomainStateList);
        return "subjectDomainStates";
    }

    @RequestMapping("/{id}")
    public String showInfo(Model model, @PathVariable("id") Integer id){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        SubjectDomainStateRepo subjectDomainStateRepo = context.getBean(SubjectDomainStateRepo.class);
        ConnectionStateRepo connectionStateRepo = context.getBean(ConnectionStateRepo.class);
        model.addAttribute("subjectDomainState",  subjectDomainStateRepo.findById(id));
        model.addAttribute("connectionStateList",  connectionStateRepo.findBySDId(id));
        return "info/subjectDomainStateInfo";
    }
}
