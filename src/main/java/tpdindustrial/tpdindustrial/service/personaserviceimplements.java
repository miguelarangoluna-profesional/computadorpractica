package tpdindustrial.tpdindustrial.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tpdindustrial.tpdindustrial.DAO.personaDAO;
import tpdindustrial.tpdindustrial.domain.persona;

@Service
public class personaserviceimplements implements personaservice{

    @Autowired
    private personaDAO pdao;
    
    @Override
    @Transactional(readOnly = true)
    public List<persona> listapersona() {
        return (List<persona>) pdao.findAll();
    }

    @Override
    @Transactional
    public void guardarpersona(persona p) {
        pdao.save(p);
    }

    @Override
    @Transactional
    public void eliminarpersona(persona p) {
        pdao.delete(p);
    }

    @Override
    @Transactional(readOnly = true)
    public persona buscarpersona(persona p) {
        return pdao.findById(p.getCodigo()).orElse(null);
    }    
}