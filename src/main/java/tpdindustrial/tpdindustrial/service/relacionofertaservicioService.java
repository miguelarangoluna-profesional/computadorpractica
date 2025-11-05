/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tpdindustrial.tpdindustrial.service;

import java.util.List;
import tpdindustrial.tpdindustrial.domain.relacionofertaservicio;

/**
 *
 * @author USUARIO
 */
public interface relacionofertaservicioService {
    public List<relacionofertaservicio> listarelaconofertaservicio();
    
    public void guardarelacionofertaservicio(relacionofertaservicio ros);
    
    public void eliminarelacionofertaservicio(relacionofertaservicio ros);
    
    public void guardarlistarelacionofertaservicio(List<relacionofertaservicio> glros);
    
    //metodos personalizados
    
    public relacionofertaservicio buscarelacionofertaservicio(relacionofertaservicio ros);
    
    public void detalleofertaservicioclienteempleado(List<Object> carrito,int code_cliente,int code_empleado);
    
    public List<relacionofertaservicio> listardetalleofertaservicio(Integer codigo);
    
    public Double totaldetalleofertaservicio(List<relacionofertaservicio> ros);
    
}
