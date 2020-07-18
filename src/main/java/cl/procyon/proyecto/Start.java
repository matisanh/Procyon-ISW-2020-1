package cl.procyon.proyecto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class Start {
    @RequestMapping(value="/", method=RequestMethod.GET)
    public @ResponseBody String start(){
        return "NKalde y Rudolf lo + Grande 👹";
    }

    
}
