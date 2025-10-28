package tpdindustrial.tpdindustrial.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tpdindustrial.tpdindustrial.DAO.clienteDAO;
import tpdindustrial.tpdindustrial.domain.cliente;

@Service
public class clienteserviceimplements implements clienteservice{

    @Autowired
    private clienteDAO cdao;
    
    @Override
    @Transactional(readOnly = true)
    public List<cliente> listarcliente() {
        return (List<cliente>) cdao.findAll();
    }
 
    @Override
    @Transactional()
    public void guardarcliente(cliente c) {
        cdao.save(c);
    }

    @Override
    @Transactional()
    public void eliminarcliente(cliente c) {
        cdao.delete(c);
    }

    @Override
    @Transactional(readOnly = true)
    public cliente buscarcliente(cliente c) {
        return cdao.findById(c.getCodigo()).orElse(null);
    }
    
}
