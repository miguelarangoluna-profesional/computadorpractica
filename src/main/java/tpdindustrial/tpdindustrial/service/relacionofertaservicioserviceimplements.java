package tpdindustrial.tpdindustrial.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tpdindustrial.tpdindustrial.DAO.relacionofertaservicioDAO;
import tpdindustrial.tpdindustrial.domain.relacionofertaservicio;

@Service
public class relacionofertaservicioserviceimplements implements relacionofertaservicioService{
  
    @Autowired
    private relacionofertaservicioDAO rosdao;
    
    @Override
    public List<relacionofertaservicio> listarelaconofertaservicio() {
        return (List<relacionofertaservicio>) rosdao.findAll();
    }

    @Override
    public void guardarelacionofertaservicio(relacionofertaservicio ros) {
        rosdao.save(ros);
    }

    @Override
    public void eliminarelacionofertaservicio(relacionofertaservicio ros) {
        rosdao.delete(ros);
    }

    @Override
    public relacionofertaservicio buscarelacionofertaservicio(relacionofertaservicio ros) {
        return rosdao.findById(ros.getCodigo()).orElse(null);
    }

    
    //CONSULTAS ESPECIALES
    @Override
    public void detalleofertaservicioclienteempleado(List<Object> carrito, int code_cliente, int code_empleado) {
        System.out.println(" Estas en el metodo detalleofertaservicioclienteempleado ");
    }

    @Override
    @Transactional
    public void guardarlistarelacionofertaservicio(List<relacionofertaservicio> glros) {
        rosdao.saveAll(glros);
    }

    @Override
    public List<relacionofertaservicio> listardetalleofertaservicio(Integer codigo) {
        List<relacionofertaservicio> lista = rosdao.findByOfertaCodigo(codigo);
        return lista;
    }

    @Override
    public Double totaldetalleofertaservicio(List<relacionofertaservicio> ros) {
        Double t = 0.0;
        for(relacionofertaservicio r:ros){
            t= t+r.getValortotal();
        }
        System.out.println("total: ===>> "+t);
        return t;
    }

    @Override
    public List<Object[]> consultageneraldetalleoferta(int codigo) {
        return rosdao.consultadetalledelaoferta(codigo);
    }

    @Override
    public void convertirconsultageneraldetalleoferta(List<Object[]> ob) {
        var dato = ob;
        List<Map<String,String>> listamapa = new ArrayList<>();
        for(Object[] o:dato){
            Map<String,String> mapa = new HashMap();
            Integer relacionofertaserviciocodigorelacionofertaservicio = (Integer)o[0];
            Double relacionofertaserviciovalortotal = (Double)o[1];
            Integer relacionofertaserviciocod_oferta = (Integer)o[2];
            Integer relacionofertaserviciocod_servicio = (Integer)o[3];
            Integer relacionofertaserviciocantidad = (Integer)o[4];
            Integer serviciocodigoservicio = (Integer)o[5];
            Integer serviciovalorunitario = (Integer)o[8];
            Integer clientecodigocliente = (Integer)o[9];
            long clientecelular = (long)o[10]; //
            long clientenit = (long)o[14]; //
            Integer ofertacod_empleado = (Integer)o[16];
            Integer ofertacod_cliente = (Integer)o[17];
            Integer ofertacodigooferta = (Integer)o[22];
            Integer empleadocodigoempleado = (Integer)o[23];
            Integer empleadocelular = (Integer)o[25];
            Double empleadosalario = (Double)o[27];
            mapa.put("relacionofertaservicio.codigorelacionofertaservicio",relacionofertaserviciocodigorelacionofertaservicio.toString());
            mapa.put("relacionofertaservicio.valortotal",relacionofertaserviciovalortotal.toString());
            mapa.put("relacionofertaservicio.cod_oferta",relacionofertaserviciocod_oferta.toString());
            mapa.put("relacionofertaservicio.cod_servicio",relacionofertaserviciocod_servicio.toString());
            mapa.put("relacionofertaservicio.cantidad",relacionofertaserviciocantidad.toString());
            mapa.put("servicio.codigoservicio",serviciocodigoservicio.toString());
            mapa.put("servicio.descripcion", (String)o[6]);
            mapa.put("servicio.fechacreacion",(String)o[7]);
            mapa.put("servicio.valorunitario",serviciovalorunitario.toString());
            mapa.put("cliente.codigocliente",clientecodigocliente.toString());
            mapa.put("cliente.celular",String.valueOf(clientecelular));
            mapa.put("cliente.contacto",(String)o[11]);
            mapa.put("cliente.correo",(String)o[12]);
            mapa.put("cliente.direccion",(String)o[13]);
            mapa.put("cliente.nit",String.valueOf(clientenit));
            mapa.put("cliente.razonsocial",(String)o[15]);
            mapa.put("oferta.cod_empleado",ofertacod_empleado.toString());
            mapa.put("oferta.cod_cliente",ofertacod_cliente.toString());
            mapa.put("oferta.formapago",(String)o[18]);
            mapa.put("oferta.fechacreacion",(String)o[19]);
            mapa.put("oferta.descripcion",(String)o[20]);
            mapa.put("oferta.codicioncomercial",(String)o[21]);
            mapa.put("oferta.codigooferta",ofertacodigooferta.toString());
            mapa.put("empleado.codigoempleado",empleadocodigoempleado.toString());
            mapa.put("empleado.cargo",(String)o[24]);
            mapa.put("empleado.celular",empleadocelular.toString());
            mapa.put("empleado.correo",(String)o[26]);
            mapa.put("empleado.salario",empleadosalario.toString());
//             LocalDate fecha = LocalDate.of(1980,12,14);
//             for(Map.Entry<String,String> mp:mapa.entrySet()){
//                
//            }
            listamapa.add(mapa);
        }
        listamapa.forEach(System.out::println);
    }
}
