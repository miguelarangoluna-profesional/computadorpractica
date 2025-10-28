/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpdindustrial.tpdindustrial.web;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tpdindustrial.tpdindustrial.test.formadepago;

/**
 *
 * @author USUARIO
 */
@Controller
@Slf4j
public class controladortest {
    
    
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
    
}
