package tpdindustrial.tpdindustrial.web;

import ch.qos.logback.core.model.processor.PhaseIndicator;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tpdindustrial.tpdindustrial.domain.oferta;
import tpdindustrial.tpdindustrial.domain.relacionofertaservicio;
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
@SessionAttributes("lista1")
@Slf4j
public class controladoroferta {

    List<Object> listaobjeto = new ArrayList<>();

    @Autowired
    private ofertaservice oferservice;

    @Autowired
    private clienteservice cliservice;

    @Autowired
    private empleadoservice empservice;

    @Autowired
    private servicioservice sservice;
    
    

    @GetMapping("/ventanaofertas")
    public String ventanaoferta() {
        return "redirect:/listaofertas";
    }

    @GetMapping("/listaofertas")
    public String listaofert(Model modelo) {
        modelo.addAttribute("listaofertas", oferservice.listaroferta());
        return "ofertas/listaofertas";
    }

    @GetMapping("/addoferta")
    public String agregarofertas(oferta o, Model modelo) {
        modelo.addAttribute("listadeservicio", sservice.listarservicio());
        modelo.addAttribute("listacliente", cliservice.listarcliente());
        modelo.addAttribute("listaempleado", empservice.listarempleado());
        return "ofertas/formularioferta";
    }

    @ModelAttribute("lista1")
    public List<Object> crearcarrito() {
        return new ArrayList<>();
    }

    @GetMapping("/agregarservicioaoferta")
    public String agregarservicioferta(
            @RequestParam("seleccionservicio") String ser,
            @RequestParam("cantidad") int cant,
            @ModelAttribute("lista1") List<Object> carrito,
            @RequestParam Map<String,String> listamap,
            Model modelo, oferta o) {
        System.out.println("Lista antes de quitar un atributo de lisamap: "+listamap);
        System.out.println("carrito antes " + carrito);
        oferservice.recibiendoObjetos(carrito,ser, cant);
        System.out.println("carrito despues " + carrito);
        System.out.println("oferservice " + oferservice);
        String servicio = ser;
        System.out.println("el servicio seleccionado es: " + ser);
        carrito.forEach(System.out::println);
        listaobjeto.forEach(System.out::println);
        modelo.addAttribute("listadeservicio", sservice.listarservicio());
        modelo.addAttribute("listacliente", cliservice.listarcliente());
        modelo.addAttribute("listaempleado",empservice.listarempleado());
        modelo.addAttribute("listadeservicioseleccionado", carrito);
        System.out.println("carrito "+carrito);
        listamap.remove("cantidad");
        System.out.println("Lista despues de quitar un atributo de lisamap: en la clase controladoroferta "+listamap);
        return "ofertas/formularioferta";
    }
    
    @GetMapping("/limpiar")
    public String limpiar(HttpSession sesion){
        sesion.removeAttribute("lista1");
        return "redirect:/";
    }    
        
    @GetMapping("/limpiar1")
    public String limpiar1(SessionStatus status){
        status.setComplete();
        return "redirect:/";
    }   
    
    @PostMapping("/guardaroferta")
    public String saveoferta(
            oferta ofer,
            @ModelAttribute("lista1") List<Object> carrito,
            Model modelo,
            @RequestParam("cod_cliente") Integer codecliente,
            @RequestParam("cod_empleado") Integer codeempleado){
        System.out.println("los datos de la oferta son: "+ofer);
        System.out.println("===========*****========");
//        System.out.println("oferta: "+ofer);
//        System.out.println("carrito: "+carrito);
//        System.out.println("Codigo cliente: "+codecliente);
//        System.out.println("Codigo empleado: "+codeempleado);
        oferservice.registrarofertaydetalle(carrito, codecliente, codeempleado,ofer);
        return "redirect:/listaofertas";
    }
    
    
    
}
