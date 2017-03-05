package diploma.logic.controllers;

import diploma.logic.entities.ConnectionState;
import diploma.logic.repositories.ConnectionStateRepo;
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
@RequestMapping("/connectionState")
public class ConnectionStateController {

    @RequestMapping("/all")
    public String showConnectionStateList(Model model){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        ConnectionStateRepo repo = context.getBean(ConnectionStateRepo.class);
        List<ConnectionState> connectionStateList = repo.getAllConnectionStateList();
        model.addAttribute("connectionStateList", connectionStateList);
        return "connectionStates";
    }
}
