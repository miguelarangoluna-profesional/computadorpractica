/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpdindustrial.tpdindustrial.reportes;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tpdindustrial.tpdindustrial.service.relacionofertaservicioService;

  
@Service
public class imprimereporte {
    private final reportepdf reporte;
    
    public imprimereporte(reportepdf rpdf){
        this.reporte=rpdf;
    }    
    
    public void printreportdetalle(List<?> datos){
        try {
            System.out.println("estamos dentro del metodo printreporte");
            var datos1 = datos; 
            Map<String, Object> parametros = new HashMap<>();
            LocalDate fecha = LocalDate.now();
            String titulo="Descripcion cotizacion:";
            parametros.put("fecha", fecha.toString());
            parametros.put("Titulo", "Descripcion de la cotizacion");
//            parametros.put("Logo", this.getClass().getResourceAsStream("/reportes/LOGO TPDI.png"));
            byte[] pdf = reporte.generarReporte("cotizacionversion1", parametros, datos);
            Path ruta = Paths.get("C:\\Users\\USUARIO\\Documents\\Reportespractica\\Miguelarangoluna1.pdf");
            Files.write(ruta,pdf);
            System.out.println("Reporte generado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
