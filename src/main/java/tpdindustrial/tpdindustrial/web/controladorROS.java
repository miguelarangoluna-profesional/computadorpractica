/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpdindustrial.tpdindustrial.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tpdindustrial.tpdindustrial.service.relacionofertaservicioService;

/**
 *
 * @author USUARIO
 */
@Controller
@Slf4j
public class controladorROS {
    
    
    @Autowired
    private relacionofertaservicioService rosservice;
    
    @GetMapping("/detalleoferta/{codigo}")
    public String detalleofert(@PathVariable("codigo")Integer codigo){
        
        System.out.println("estas en el controlador detalle oferta: "+codigo);
        var lista = rosservice.listarelaconofertaservicio();
        lista.forEach(System.out::println);
        
        return "redirect:/";
    }
}
