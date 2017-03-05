package diploma.logic.controllers;

import diploma.logic.entities.ConnectionInstance;
import diploma.logic.repositories.ConnectionInstanceRepo;
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
@RequestMapping("/connectionInstance")
public class ConnectionInstanceController {

    @RequestMapping("/all")
    public String showConnectionInstanceList(Model model){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        ConnectionInstanceRepo repo = context.getBean(ConnectionInstanceRepo.class);
        List<ConnectionInstance> connectionInstanceList = repo.getAllConnectionInstanceList();
        model.addAttribute("connectionInstanceList", connectionInstanceList);
        return "connectionInstances";
    }
}
