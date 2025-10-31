package tpdindustrial.tpdindustrial.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tpdindustrial.tpdindustrial.DAO.serviciosDAO;
import tpdindustrial.tpdindustrial.domain.servicio;

/**
 *
 * @author USUARIO
 */
@Service
public class servicioserviceimplements implements servicioservice{

    @Autowired
    private serviciosDAO sservice;
    
    @Override
    @Transactional(readOnly = true)
    public List<servicio> listarservicio() {
        return (List<servicio>) sservice.findAll();
    }

    @Override
    @Transactional()
    public void guardarservicio(servicio s) {
        sservice.save(s);
    }

    @Override
    @Transactional()
    public void eliminarservicio(servicio s) {
        sservice.delete(s);
    }

    @Override
    @Transactional(readOnly = true)
    public servicio buscarservicio(servicio s) {
        return sservice.findById(s.getCodigo()).orElse(null);
    }

    @Override
    public List<servicio> buscarpordescripcion(String nombre) {
        return sservice.findByDescripcion(nombre);
    }
    
}
