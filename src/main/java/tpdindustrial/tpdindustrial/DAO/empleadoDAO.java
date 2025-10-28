package tpdindustrial.tpdindustrial.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import tpdindustrial.tpdindustrial.domain.empleado;

public interface empleadoDAO extends JpaRepository<empleado,Integer> {
    
}
