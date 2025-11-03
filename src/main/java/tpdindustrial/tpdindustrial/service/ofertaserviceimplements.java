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
import tpdindustrial.tpdindustrial.domain.cliente;
import tpdindustrial.tpdindustrial.domain.empleado;
import tpdindustrial.tpdindustrial.domain.oferta;
import tpdindustrial.tpdindustrial.domain.relacionofertaservicio;
import tpdindustrial.tpdindustrial.domain.servicio;

/**
 *
 * @author USUARIO
 */
@Service
public class ofertaserviceimplements implements ofertaservice {

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

    //Metodos y lógica del negocio adicionales
    @Autowired
    private servicioservice sservice;
    
    @Autowired
    private clienteservice clientservice;
    
    @Autowired
    private empleadoservice empleservice;

    @Autowired
    private relacionofertaservicioService rosservice;
    
    
    @Override
    public void recibiendoObjetos(List<Object>carrito,String ser, int cantidad) {
        System.out.println("ser: ===> " + ser);
        int codigo = Integer.parseInt(ser);
        servicio s = new servicio();
        s.setCodigo(codigo);
        s = sservice.buscarservicio(s);
        s.getDescripcion();
        s.getValorunitario();
        int total = s.getValorunitario()*cantidad;
        List<Object> detalle = new ArrayList<>();
        detalle.add(s.getCodigo());
        detalle.add(s.getDescripcion());
        detalle.add(cantidad);
        detalle.add(s.getValorunitario());
        detalle.add(total);
        carrito.add(detalle);
    }

    @Override
    public void registrarofertaydetalle(List<Object> carrito, int codecliente, int codempleado) {
        List<Object> detalleoferta = new ArrayList<>();
        List<relacionofertaservicio> detalleofertaservicio= new ArrayList<>();
        
        cliente c = new cliente();
        empleado e = new empleado();
        oferta ofert = new oferta();
        c.setCodigo(codecliente);
        e.setCodigo(codempleado);
        c = clientservice.buscarcliente(c);
        e = empleservice.buscarempleado(e);
        
        ofert.setCliente(c);
        ofert.setEmpleado(e);
        guardaroferta(ofert);
        System.out.println("oferta guardada "+ofert);
        
       
        c = clientservice.buscarcliente(c);
        e = empleservice.buscarempleado(e);
        List<servicio> ls = new ArrayList<>();
        System.out.println("estas en la linea 101");
        for(Object o:carrito){
            relacionofertaservicio ros = new relacionofertaservicio();
            List<Object> fila = (List<Object>) o;
            Integer id = (Integer) fila.get(0);
            String nombreservicio = (String) fila.get(1);
            
            System.out.println("nombreservicio "+nombreservicio);
            ls= sservice.buscarpordescripcion(nombreservicio);
            System.out.println("lista de servicios "+ls);
            Integer cantidad = (Integer) fila.get(2);
            Integer preciounitario = (Integer) fila.get(3);
            Integer total = (Integer) fila.get(4);
            fila.forEach(System.out::println);
            ros.setCantidad(cantidad);
//            ros.setServicio();
//            ros.setValortotal(total); 
            detalleofertaservicio.add(ros);
        }
        detalleofertaservicio.forEach(System.out::println);
        System.out.println("los datos recibidos son: "+carrito+" - "+" Informacion cliente: "+c+" informacion empleado: "+e);
    }
    
    
}
