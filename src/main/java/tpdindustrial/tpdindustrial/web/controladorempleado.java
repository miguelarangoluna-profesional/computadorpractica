
package tpdindustrial.tpdindustrial.web;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
    
    
    @GetMapping("/buscarcliente")
    public String buscarporlciente(@RequestParam("razonsocial")String nomempresa,RedirectAttributes redirect){
        System.out.println("nombre de empresa es: "+nomempresa);
        var lista = eservice.buscarporempresa(nomempresa);
        lista.forEach(System.out::println);
        String anuncio="";
        if(lista.isEmpty()){
            anuncio="no hay clientes asociados";
            redirect.addFlashAttribute("anuncio",anuncio);
            return"redirect:/";
        }else{
            anuncio="los dados son: "+lista;
            redirect.addFlashAttribute("anuncio",anuncio);
            return "redirect:/";
        }
    }
   
    
}
