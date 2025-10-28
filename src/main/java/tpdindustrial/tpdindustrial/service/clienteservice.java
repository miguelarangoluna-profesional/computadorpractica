/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tpdindustrial.tpdindustrial.service;

import java.util.List;
import tpdindustrial.tpdindustrial.domain.cliente;

/**
 *
 * @author USUARIO
 */
public interface clienteservice {
    public List<cliente> listarcliente();
    
    public void guardarcliente(cliente c);
    
    public void eliminarcliente(cliente c);
    
    public cliente buscarcliente(cliente c);
}
