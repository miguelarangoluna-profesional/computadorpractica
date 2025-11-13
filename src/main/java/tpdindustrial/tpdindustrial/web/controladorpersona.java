package tpdindustrial.tpdindustrial.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tpdindustrial.tpdindustrial.domain.persona;
import tpdindustrial.tpdindustrial.service.personaservice;

/**
 *
 * @author USUARIO
 */
@Controller
@Slf4j
public class controladorpersona {

    @Autowired
    private personaservice pservice;

    @GetMapping("/ventanapersona")
    public String ventanapersona(Model modelo) {
        modelo.addAttribute("listapersona", pservice.listapersona());
        return "persona/listarpersona";
    }

    @GetMapping("/addpersona")
    public String agregapersona(persona p) {
        return "persona/formulariopersona";
    }
    
    @PostMapping("/guardarpersona")
    public String savepersona(persona p){
        System.out.println("persona "+p);
        return "redirect:/";
    }
}
