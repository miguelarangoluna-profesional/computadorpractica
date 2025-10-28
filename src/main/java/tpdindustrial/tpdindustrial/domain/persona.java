/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpdindustrial.tpdindustrial.domain;

import jakarta.persistence.*;
import java.io.*;
import lombok.*;

/**
 *
 * @author USUARIO
 */
@Entity
@Data
public class persona implements Serializable {
    private static final long SerialiversionUID=1L;
    
    
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer codigo;
    
    private String nombre;
    
    private String apellido;
    
    private String direccion;
    
    private String correo;
    
    private String celular;
}
