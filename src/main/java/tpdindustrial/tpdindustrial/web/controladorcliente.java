/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpdindustrial.tpdindustrial.web;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tpdindustrial.tpdindustrial.domain.cliente;
import tpdindustrial.tpdindustrial.service.clienteservice;

/**
 *
 * @author USUARIO
 */
@Controller
@Slf4j
public class controladorcliente {
    
    @Autowired
    private clienteservice clienteservice;
    
    @GetMapping("/ventanacliente")
    public String ventanacliente(Model modelo){
        return "redirect:/listacliente";  
    } 
    
    @GetMapping("/listacliente")
    public String listarclientes(Model modelo){
        var lista = clienteservice.listarcliente();
        modelo.addAttribute("listacliente", lista);
        return "clientes/listacliente";  
    }
    
    @GetMapping("/addcliente")
    public String addcliente(cliente c){
        return "clientes/formulariocliente";
    }
    
    @PostMapping("/guardarcliente")
    public String guardacliente(@Valid cliente c, Errors errores){
        if(errores.hasErrors()){
            return "clientes/formulariocliente"; 
        }
        clienteservice.guardarcliente(c);
        return "redirect:/listacliente";
    }
    
    
    
}
