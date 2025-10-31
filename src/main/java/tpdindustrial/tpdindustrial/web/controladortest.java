/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpdindustrial.tpdindustrial.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tpdindustrial.tpdindustrial.domain.servicio;
import tpdindustrial.tpdindustrial.service.servicioservice;
import tpdindustrial.tpdindustrial.test.formadepago;
import tpdindustrial.tpdindustrial.test.listavarioselementos;

/**
 *
 * @author USUARIO
 */
@Controller
@Slf4j
public class controladortest {
    
    @Autowired
    private servicioservice sservice;
    
    @GetMapping("/prueba")
    public String test(Model modelo,RedirectAttributes redirectattrs){
        String m = "mensaje desde el metodo controlador de la clase test";
        int n = formadepago.SESENTA.getFormapago();
        List<formadepago> li = new ArrayList<>();
        for(formadepago f: formadepago.values()){
            System.out.println("forma de pago "+f);
            li.add(f);
        }
        li.forEach(System.out::println);
        modelo.addAttribute("listaenum",li);   
        redirectattrs.addFlashAttribute("mensaje", formadepago.NOVENTA.getFormapago()+" - "+n);
        redirectattrs.addFlashAttribute("listaenum", li);
        return "redirect:/";  
    }
    
    @GetMapping("/agregarlistaopciones")
    public String adicionarlistaopciones(@RequestParam("servicio") List<String> lista,@RequestParam("areasselecionadas") List<String> lista1){
        System.out.println("lista: "+lista);
        System.out.println("lista1: "+lista1);
        return "redirect:/";
    }
    
    @GetMapping("/pruebatest")
    public String testearprueba(Model modelo){
        
        for(listavarioselementos e: listavarioselementos.values()){
            System.out.println("elementos "+e.getElementos());
        }    
        List<listavarioselementos> lista = Arrays.asList(listavarioselementos.values());
        modelo.addAttribute("listadecomponentes",lista);
        
        return "test/listatest";
    }
    
    @GetMapping("/agregartest")
    public String agregatests(Model modelo){
        modelo.addAttribute("elementos1", listavarioselementos.values());
        modelo.addAttribute("elementos", sservice.listarservicio());
        return "test/formulariotest";
    }
    
    
    @GetMapping("/consultasespeciales")
    public String consultasespeciales(@RequestParam("nombre")String descripcion){
        servicio s = new servicio();
        System.out.println("name: "+descripcion);
        System.out.println("hola estas en la clase");
        s.setDescripcion(descripcion);
        sservice.buscarpordescripcion(descripcion);
        System.out.println("sservice:///====>>>> "+sservice.buscarpordescripcion(descripcion));
        return "redirect:/";
    }
    
    
}
