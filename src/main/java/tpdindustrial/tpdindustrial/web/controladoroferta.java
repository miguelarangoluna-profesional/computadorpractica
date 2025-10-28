package tpdindustrial.tpdindustrial.web;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tpdindustrial.tpdindustrial.domain.oferta;
import tpdindustrial.tpdindustrial.domain.servicio;
import tpdindustrial.tpdindustrial.service.clienteservice;
import tpdindustrial.tpdindustrial.service.empleadoservice;
import tpdindustrial.tpdindustrial.service.ofertaservice;
import tpdindustrial.tpdindustrial.service.servicioservice;

/**
 *
 * @author USUARIO
 */

@Controller
@Slf4j
public class controladoroferta {
    
    @Autowired
    private ofertaservice oferservice;
    
    @Autowired
    private clienteservice cliservice;
    
    @Autowired
    private empleadoservice empservice;
    
    @Autowired
    private servicioservice sservice;
    
    @GetMapping("/ventanaofertas")
    public String ventanaoferta(){
        return "redirect:/listaofertas";
    }
    
    @GetMapping("/listaofertas")
    public String listaofert(){
        return "ofertas/listaofertas";
    }
    
    
    @GetMapping("/addoferta")
    public String agregarofertas(oferta o,Model modelo){
        var listacliente = cliservice.listarcliente();
        var listaempleado = empservice.listarempleado();
        modelo.addAttribute("listacliente", listacliente);
        modelo.addAttribute("listaempleado",listaempleado);
        return "ofertas/formularioferta";
    }
      
   @GetMapping("/agregarservicioaoferta")
   public String agregarservicioferta(RedirectAttributes redirectattributes){
       String m = "hola";
       redirectattributes.addFlashAttribute("mensaje", "mensaje desde el controladoroferta metodo agregarservicioaoferta");
       return "redirect:/";
   }
}
 