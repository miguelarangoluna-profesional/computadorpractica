package tpdindustrial.tpdindustrial.web;

import com.web.validation.spring.annotation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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

    @GetMapping("/listadodepersonas")
    public String listadodepersona(Model modelo) {
        modelo.addAttribute("listapersona", pservice.listapersona());
        return "persona/listarpersona";
    }

    @PostMapping("/guardarpersona")
    public String savepersona(@Valid persona p, Errors errores) {
        if (errores.hasErrors()) {
            return "persona/formulariopersona";
        }
        System.out.println("persona " + p);
        pservice.guardarpersona(p);
        return "redirect:/listadodepersonas";
    }

    @GetMapping("/eliminarpersona/{codigo}")
    public String deletepersona(persona p) {
        pservice.eliminarpersona(p);
        return "redirect:/listadodepersonas";
    }

    @GetMapping("/buscarnombre")
    public String findnombre(@RequestParam("nombre") String nombrebuscar, persona p, RedirectAttributes redirect) {
        System.out.println("nombre a buscar: " + nombrebuscar + "\n y la persona: " + p);
        var lista = pservice.buscarpornombre(nombrebuscar);
        System.out.println("Nombre buscado es: " + lista);
        String mensaje="";
        if (lista.isEmpty()) {
              mensaje = "¡¡¡¡ Vaya no se encontro el nombre!!!";
        }else{
            mensaje = "Se encontro el nombre: "+p.getNombre();
        }
        redirect.addFlashAttribute("mensaje", mensaje);    
        return "redirect:/";  
    }
}
