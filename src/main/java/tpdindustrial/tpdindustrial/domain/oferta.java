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
public class oferta implements Serializable {
    public static final long SerialversionUID=1l;
    
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer codigo;
    
    private String descripcion;
    
    private String formapago;
    
    private LocalDate fechacreacion;
    
    private String codicioncomercial;
    
    @JoinColumn(name = "cod_empleado",referencedColumnName = "codigo")
    @ManyToOne()
    private empleado empleado;
     
       
    @JoinColumn(name = "cod_cliente",referencedColumnName = "codigo")
    @ManyToOne()
    private cliente cliente;
            
}
