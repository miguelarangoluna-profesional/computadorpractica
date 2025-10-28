
package tpdindustrial.tpdindustrial.web;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tpdindustrial.tpdindustrial.domain.empleado;
import tpdindustrial.tpdindustrial.service.empleadoservice;


@Controller
@Slf4j
public class controladorempleado {
    
    @Autowired
    private empleadoservice eservice;
    
    @GetMapping("/ventanaempleado")
    public String ventanempleado(Model modelo){
        var lista = eservice.listarempleado();
        modelo.addAttribute("listaempleados", lista);
        return "empleados/listaempleados";
    }
    
    @GetMapping("/addempleado")
    public String agregarempleado(empleado e){
        return "empleados/formularioempleado";
    }
    
    @PostMapping("/guardarempleado")
    public String guadaempleado(@Valid empleado e, Errors errores){
        if(errores.hasErrors()){
            return "empleados/formularioempleado";
        }
        eservice.guardarempleado(e);
        return "redirect:/ventanaempleado";
    }
    
}
