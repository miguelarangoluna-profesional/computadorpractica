/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpdindustrial.tpdindustrial.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.*;

/**
 *
 * @author USUARIO
 */
@Entity
@Data
public class servicio implements Serializable{
    public static final long SerialversionUID=1l;
    
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer codigo;
    
    private String descripcion;
    
    private LocalDate fechacreacion;
    
    private Integer valorunitario;
    
}
