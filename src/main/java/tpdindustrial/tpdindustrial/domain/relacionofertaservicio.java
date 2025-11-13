/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpdindustrial.tpdindustrial.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.*;

/**
 *
 * @author USUARIO
 */
@Entity
@Data
public class relacionofertaservicio implements Serializable {
    public static final long SerialversionUID=1l;
    
    @Id
    @Column(name = "codigorelacionofertaservicio")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer codigo;
    
    private int cantidad;
    
    private Double valortotal;
    
    @JoinColumn(name = "cod_oferta",referencedColumnName = "codigooferta")
    @ManyToOne
    private oferta oferta;
    
    @JoinColumn(name = "cod_servicio",referencedColumnName = "codigoservicio")
    @ManyToOne
    private servicio servicio;
    
    
}
