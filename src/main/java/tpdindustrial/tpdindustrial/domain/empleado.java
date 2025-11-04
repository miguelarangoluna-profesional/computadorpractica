package tpdindustrial.tpdindustrial.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;
import lombok.*;

@Entity
@Data
public class empleado implements Serializable {
    public static final long SerialversionUID=1l;
    
    @Id
    @Column(name = "codigo")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer codigo;
    
    @NotEmpty(message = "Debe digitar el cargo")
    private String cargo;
    
    @NotEmpty(message = "Debe digitar el correo")
    private String correo;
    
    private Double salario;
    
    
    private Integer celular;
    
    
    @ToString.Exclude
    @OneToMany(mappedBy = "empleado", cascade = {CascadeType.MERGE,CascadeType.PERSIST},fetch = FetchType.EAGER)
    private List<oferta> listaofertas;
    
}
