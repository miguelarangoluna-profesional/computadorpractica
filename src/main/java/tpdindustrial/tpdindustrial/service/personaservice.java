/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tpdindustrial.tpdindustrial.service;

import java.util.List;
import tpdindustrial.tpdindustrial.domain.persona;

/**
 *
 * @author USUARIO
 */
public interface personaservice {
    public List<persona> listapersona();
    
    public void guardarpersona(persona p);
    
    public void eliminarpersona(persona p);
    
    public persona buscarpersona(persona p);
}
