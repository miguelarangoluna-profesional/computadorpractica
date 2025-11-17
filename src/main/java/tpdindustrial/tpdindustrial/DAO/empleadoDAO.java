package tpdindustrial.tpdindustrial.DAO;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import tpdindustrial.tpdindustrial.domain.empleado;

public interface empleadoDAO extends JpaRepository<empleado,Integer> {
    
    public List<empleado> findByListaofertas_Cliente_Razonsocial(String razonsocial);  
}
