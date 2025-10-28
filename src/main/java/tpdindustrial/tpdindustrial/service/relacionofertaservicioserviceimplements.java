package tpdindustrial.tpdindustrial.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tpdindustrial.tpdindustrial.DAO.relacionofertaservicioDAO;
import tpdindustrial.tpdindustrial.domain.relacionofertaservicio;

@Service
public class relacionofertaservicioserviceimplements implements relacionofertaservicioService{

    @Autowired
    private relacionofertaservicioDAO rosdao;
    
    @Override
    public List<relacionofertaservicio> listarelaconofertaservicio() {
        return (List<relacionofertaservicio>) rosdao.findAll();
    }

    @Override
    public void guardarelacionofertaservicio(relacionofertaservicio ros) {
        rosdao.save(ros);
    }

    @Override
    public void eliminarelacionofertaservicio(relacionofertaservicio ros) {
        rosdao.delete(ros);
    }

    @Override
    public relacionofertaservicio buscarelacionofertaservicio(relacionofertaservicio ros) {
        return rosdao.findById(ros.getCodigo()).orElse(null);
    }
    
}
