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
    
    public void procesodetalle(String servicio, int cantidad);
    
    public List<Object> recibiendoObjetos(String servicio);
}
