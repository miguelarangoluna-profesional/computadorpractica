/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tpdindustrial.tpdindustrial.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import tpdindustrial.tpdindustrial.domain.cliente;

/**
 *
 * @author USUARIO
 */
public interface clienteDAO extends JpaRepository<cliente, Integer> {
    
}
