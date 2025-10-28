package tpdindustrial.tpdindustrial.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public List<servicio> listarservicio() {
        return (List<servicio>) sservice.findAll();
    }

    @Override
    public void guardarservicio(servicio s) {
        sservice.save(s);
    }

    @Override
    public void eliminarservicio(servicio s) {
        sservice.delete(s);
    }

    @Override
    public servicio buscarservicio(servicio s) {
        return sservice.findById(s.getCodigo()).orElse(null);
    }
    
}
