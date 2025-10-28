/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tpdindustrial.tpdindustrial.service;

import java.util.List;
import tpdindustrial.tpdindustrial.domain.oferta;

/**
 *
 * @author USUARIO
 */
public interface ofertaservice {
    public List<oferta> listaroferta();
    
    public void guardaroferta(oferta o);
    
    public void eliminaroferta(oferta o);
    
    public oferta buscaroferta(oferta o);
}
