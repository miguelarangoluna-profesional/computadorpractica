package tpdindustrial.tpdindustrial.web;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import tpdindustrial.tpdindustrial.reportes.reportepdf;
import tpdindustrial.tpdindustrial.service.clienteservice;

@Controller
public class controladoreporte {

    private final reportepdf reportpdf;

    public controladoreporte(reportepdf report) {
        this.reportpdf = report;
    }

    @Autowired
    private clienteservice cservice; 
    
    @GetMapping("/generareporte")
    public ResponseEntity<byte[]> generareporte(){
        try {
//            List<Map<String, Object>> datos1 = new ArrayList<>();
//            datos1.add(Map.of());
            var datos = cservice.listarcliente();
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("Titulo", "listado de oferta");
            parametros.put("Logo", this.getClass().getResourceAsStream("/reportes/LOGO TPDI.png"));
            byte[] pdf = reportpdf.generarReporte("reportecliente", parametros, datos);
            Path ruta = Paths.get("C:\\Users\\USUARIO\\Documents\\Reportespractica\\reporteprueba1.pdf");
            Files.write(ruta, pdf);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=reporte_cliente.pdf")
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(pdf);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
