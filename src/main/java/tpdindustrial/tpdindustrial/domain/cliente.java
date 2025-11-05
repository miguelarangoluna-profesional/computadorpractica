package tpdindustrial.tpdindustrial.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;
import lombok.*;

/**
 *
 * @author USUARIO
 */
@Entity
@Data
public class cliente implements Serializable{
    public static final long SerialversionUId = 1l;
    
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer codigo;
    
    
    @NotEmpty(message = "El campo razonsocial no debe estar vacio")
    private String razonsocial;
    
    private long nit;
    
    private String contacto;
    
    private String direccion;
    
    private String correo;
    
    private long celular;
}
