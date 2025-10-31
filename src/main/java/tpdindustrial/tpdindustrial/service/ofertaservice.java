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
    
    //metodos para agregar
    public void recibiendoObjetos(List<Object> carrito, String servicio, int cantidad);
    
    public void registrarofertaydetalle(List<Object>carrito,int codecliente,int codempleado);
    
    
    
}
