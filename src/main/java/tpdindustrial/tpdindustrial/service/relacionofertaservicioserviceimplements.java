package tpdindustrial.tpdindustrial.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    @Override
    public void detalleofertaservicioclienteempleado(List<Object> carrito, int code_cliente, int code_empleado) {
        System.out.println(" Estas en el metodo detalleofertaservicioclienteempleado ");
    }

    @Override
    @Transactional
    public void guardarlistarelacionofertaservicio(List<relacionofertaservicio> glros) {
        rosdao.saveAll(glros);
    }

    @Override
    public List<relacionofertaservicio> listardetalleofertaservicio(Integer codigo) {
        List<relacionofertaservicio> lista = rosdao.findByOfertaCodigo(codigo);//quitar
        return lista;
    }
    
    
    
}
