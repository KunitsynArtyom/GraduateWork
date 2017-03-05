package diploma.logic.controllers;

import diploma.logic.entities.Connection;
import diploma.logic.repositories.ConnectionRepo;
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
@RequestMapping("/connection")
public class ConnectionController {

    @RequestMapping("/all")
    public String showConnectionList(Model model){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        ConnectionRepo repo = context.getBean(ConnectionRepo.class);
        List<Connection> connectionList = repo.getAllConnectionList();
        model.addAttribute("connectionList", connectionList);
        return "connections";
    }

    @RequestMapping("/{id}")
    public String showInfo(Model model, @PathVariable("id") Integer id){
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        ConnectionRepo connectionRepo = context.getBean(ConnectionRepo.class);
        model.addAttribute("connection", connectionRepo.findById(id));
        return "info/connectionInfo";
    }
}
