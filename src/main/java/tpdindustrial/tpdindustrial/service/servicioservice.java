package tpdindustrial.tpdindustrial.service;

import java.util.List;
import tpdindustrial.tpdindustrial.domain.servicio;


public interface servicioservice {
    public List<servicio> listarservicio();
    
    public void guardarservicio(servicio s);
    
    public void eliminarservicio(servicio s);
    
    public servicio buscarservicio(servicio s);
}
