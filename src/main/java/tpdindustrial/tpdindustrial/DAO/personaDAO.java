/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tpdindustrial.tpdindustrial.DAO;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import tpdindustrial.tpdindustrial.domain.persona;

/**
 *
 * @author USUARIO
 */
public interface personaDAO extends JpaRepository<persona,Integer>{
    
    public List<persona> findByNombre(String nombre);
    
}
