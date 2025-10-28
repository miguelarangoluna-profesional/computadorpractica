package tpdindustrial.tpdindustrial.web;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tpdindustrial.tpdindustrial.domain.servicio;
import tpdindustrial.tpdindustrial.service.servicioservice;

/**
 *
 * @author USUARIO
 */
@Controller
@Slf4j
public class controladorservicio {

    @Autowired
    private servicioservice sservice;

    @GetMapping("/ventanaservicio")
    public String ventanaservicio() {
        return "redirect:/listaservicio";
    }

    @GetMapping("/addservicio")
    public String listarservicio1(servicio s,Model modelo) {
        var lista = sservice.listarservicio();
        modelo.addAttribute("listaservicio", lista);
        return "servicio/formularioservicio";
    }
    
    @GetMapping("/listaservicio")
    public String listarservicio(servicio s,Model modelo) {
        var lista = sservice.listarservicio();
        modelo.addAttribute("listaservicio", lista);
        return "servicio/listarservicio";
    }

    @PostMapping("/guardarservicio")
    public String guardarservicio(@Valid servicio s, Errors errores) {
        if (errores.hasErrors()) {
            return "servicio/formularioservicio";
        }
        sservice.guardarservicio(s);
        return "redirect:/listaservicio";
    }
    
    
    @GetMapping("/editarservicio/{codigo}")
    public String editservicio(servicio s){
        System.out.println("servicio "+s);
        return "redirect:/";
    }
    
    @GetMapping("/eliminarservicio")
    public String deleteservicio(servicio s){
//        System.out.println("servicio "+s);
        sservice.eliminarservicio(s);
        return "redirect:/listaservicio";
    }

}
