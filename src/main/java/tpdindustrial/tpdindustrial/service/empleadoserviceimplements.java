/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpdindustrial.tpdindustrial.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tpdindustrial.tpdindustrial.DAO.empleadoDAO;
import tpdindustrial.tpdindustrial.domain.empleado;

/**
 *
 * @author USUARIO
 */
@Service
public class empleadoserviceimplements implements empleadoservice {

    @Autowired
    private empleadoDAO edao;
    
    @Override
    @Transactional(readOnly = true)
    public List<empleado> listarempleado() {
        return (List<empleado>) edao.findAll();
    }

    @Override
    @Transactional
    public void guardarempleado(empleado e) {
        edao.save(e);
    }

    @Override
    @Transactional
    public void eliminarempleado(empleado e) {
        edao.delete(e);
    }

    @Override
    @Transactional(readOnly = true)
    public empleado buscarempleado(empleado e) {
        return edao.findById(e.getCodigo()).orElse(null);
    }
    
}
