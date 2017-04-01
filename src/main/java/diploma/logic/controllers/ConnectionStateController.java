package diploma.logic.controllers;

import diploma.logic.entities.ConnectionState;
import diploma.logic.repositories.ConnectionStateRepo;
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
@RequestMapping("/connectionState")
public class ConnectionStateController {

    private ApplicationContext context;

    @Autowired
    public void context(ApplicationContext context) { this.context = context; }

    @RequestMapping("/all")
    public String showConnectionStateList(Model model){
        ConnectionStateRepo repo = context.getBean(ConnectionStateRepo.class);
        List<ConnectionState> connectionStateList = repo.getAllConnectionStateList();
        model.addAttribute("connectionStateList", connectionStateList);
        return "connectionStates";
    }

    @RequestMapping("/{id}")
    public String showInfo(Model model, @PathVariable("id") Integer id){
        ConnectionStateRepo connectionStateRepo = context.getBean(ConnectionStateRepo.class);
        model.addAttribute("connectionState", connectionStateRepo.findById(id));
        return "info/connectionStateInfo";
    }
}
