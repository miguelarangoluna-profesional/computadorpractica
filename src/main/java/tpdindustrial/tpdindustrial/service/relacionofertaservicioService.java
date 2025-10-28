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
    
    public relacionofertaservicio buscarelacionofertaservicio(relacionofertaservicio ros);
}
