/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpdindustrial.tpdindustrial.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tpdindustrial.tpdindustrial.DAO.ofertaDAO;
import tpdindustrial.tpdindustrial.domain.oferta;

/**
 *
 * @author USUARIO
 */
@Service
public class ofertaserviceimplements implements ofertaservice{

    //Metodos CRUD de la aplicación
    
    @Autowired
    private ofertaDAO odao;
    
    @Override
    @Transactional(readOnly = true)
    public List<oferta> listaroferta() {
        return (List<oferta>) odao.findAll();
    }

    @Override
    @Transactional()
    public void guardaroferta(oferta o) {
        odao.save(o);
    }

    @Override
    @Transactional()
    public void eliminaroferta(oferta o) {
        odao.delete(o);
    }

    @Override
    @Transactional(readOnly = true)
    public oferta buscaroferta(oferta o) {
        return odao.findById(o.getCodigo()).orElse(null);
    }
    
    //Metodos y lógica del negocio

    List<Object> listaobjecto = new ArrayList<>();
    
    @Override
    public void procesodetalle(String servicio, int cantidad) {
        listaobjecto.add(servicio);
        
    }

    @Override
    public List<Object> recibiendoObjetos(String ser) {
        System.out.println("ser: ===> "+ser);
        int codigo = Integer.parseInt(ser);
        
        
        listaobjecto.add(ser);
        return listaobjecto;
    }
    
    
    
}
