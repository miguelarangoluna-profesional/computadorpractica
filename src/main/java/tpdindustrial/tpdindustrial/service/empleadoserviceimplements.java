package tpdindustrial.tpdindustrial.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tpdindustrial.tpdindustrial.DAO.empleadoDAO;
import tpdindustrial.tpdindustrial.domain.empleado;


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
    
    //consultas especiales

    @Override
    public List<empleado> buscarporempresa(String nombre) {
        return edao.findByListaofertas_Cliente_Razonsocial(nombre);
    }
    
}
