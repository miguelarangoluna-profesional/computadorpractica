package tpdindustrial.tpdindustrial.DAO;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tpdindustrial.tpdindustrial.domain.relacionofertaservicio;


public interface relacionofertaservicioDAO extends JpaRepository<relacionofertaservicio,Integer>{
    List<relacionofertaservicio> findByOfertaCodigo(Integer codigo); 
    
     //consulta especial 
    @Query(value="""
                 SELECT 
                        relacionofertaservicio.codigorelacionofertaservicio,
                 	relacionofertaservicio.valortotal,
                 	relacionofertaservicio.cod_oferta,
                 	relacionofertaservicio.cod_servicio,
                 	relacionofertaservicio.cantidad,
                 	servicio.codigoservicio,
                 	servicio.descripcion,
                 	servicio.fechacreacion,
                 	servicio.valorunitario,
                 	cliente.codigocliente,
                 	cliente.celular,
                 	cliente.contacto,
                 	cliente.correo,
                 	cliente.direccion,
                 	cliente.nit,
                 	cliente.razonsocial,
                 	oferta.cod_empleado,
                 	oferta.cod_cliente,
                 	oferta.formapago,
                 	oferta.fechacreacion,
                 	oferta.descripcion,
                 	oferta.codicioncomercial,
                 	oferta.codigooferta,
                 	empleado.codigoempleado,
                 	empleado.cargo,
                 	empleado.celular,
                 	empleado.correo,
                 	empleado.salario
                 FROM relacionofertaservicio
                 	INNER JOIN oferta ON 
                 	 relacionofertaservicio.cod_oferta = oferta.codigooferta 
                 	INNER JOIN cliente ON 
                 	 oferta.cod_cliente = cliente.codigocliente 
                 	INNER JOIN empleado ON 
                 	 oferta.cod_empleado = empleado.codigoempleado 
                 	INNER JOIN servicio ON 
                 	 relacionofertaservicio.cod_servicio = servicio.codigoservicio 
                 WHERE 
                 	 oferta.codigooferta =:codeoferta
                 """,nativeQuery = true)
    public List<Object[]> consultadetalledelaoferta(@Param("codeoferta") int codigo);
    
      
    
    public List<relacionofertaservicio> findByOfertaCodigo_EmpleadoCodigo_Codigo(Integer codigo);
    

    
    
}
