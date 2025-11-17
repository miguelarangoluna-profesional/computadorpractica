
package tpdindustrial.tpdindustrial.service;

import java.util.List;
import tpdindustrial.tpdindustrial.domain.empleado;

/**
 *
 * @author USUARIO
 */
public interface empleadoservice {
    public List<empleado> listarempleado();
    
    public void guardarempleado(empleado e);
    
    public void eliminarempleado(empleado e);
    
    public empleado buscarempleado(empleado e);
    
    //Consultas especiales
    
    public List<empleado> buscarporempresa(String nombre);
    
}
