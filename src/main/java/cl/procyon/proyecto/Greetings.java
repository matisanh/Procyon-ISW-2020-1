package cl.procyon.proyecto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Greetings {

    @RequestMapping("/saludar")
    public @ResponseBody String greeting(){
        return "Wena Man";
    }
}