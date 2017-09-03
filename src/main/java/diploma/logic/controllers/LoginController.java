package diploma.logic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Артём on 15.08.2017.
 */
@Controller
@RequestMapping("/")
public class LoginController {

    @RequestMapping(method=RequestMethod.GET)
    public String goHome(){
        return "home";
    }

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String goLogin(){
        return "login";
    }
}
