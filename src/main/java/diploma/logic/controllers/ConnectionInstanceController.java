package diploma.logic.controllers;

import diploma.logic.entities.ConnectionInstance;
import diploma.logic.repositories.ConnectionInstanceRepo;
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
@RequestMapping("/connectionInstance")
public class ConnectionInstanceController {

    private ApplicationContext context;

    @Autowired
    public void context(ApplicationContext context) { this.context = context; }

    @RequestMapping("/all")
    public String showConnectionInstanceList(Model model){
        ConnectionInstanceRepo repo = context.getBean(ConnectionInstanceRepo.class);
        List<ConnectionInstance> connectionInstanceList = repo.getAllConnectionInstanceList();
        model.addAttribute("connectionInstanceList", connectionInstanceList);
        return "connectionInstances";
    }

    @RequestMapping("/{id}")
    public String showInfo(Model model, @PathVariable("id") Integer id){
        ConnectionInstanceRepo connectionInstanceRepo = context.getBean(ConnectionInstanceRepo.class);
        model.addAttribute("connectionInstance", connectionInstanceRepo.findById(id));
        return "info/connectionInstanceInfo";
    }
}
