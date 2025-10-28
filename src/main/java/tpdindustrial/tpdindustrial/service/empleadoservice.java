/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
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
}
