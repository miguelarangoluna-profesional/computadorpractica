/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpdindustrial.tpdindustrial.reportes;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class reportepdf {
    // Genera un PDF desde un archivo .jasper que ya está compilado
    public byte[] generarReporte(String nombreReporte, Map<String, Object> parametros, List<?> datos) throws Exception {
        // Cargar el archivo .jasper desde resources/reportes/
        ClassPathResource resource = new ClassPathResource("reportes/" + nombreReporte + ".jasper");
        try (InputStream inputStream = resource.getInputStream()) {
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(datos);
            JasperPrint jasperPrint = JasperFillManager.fillReport(inputStream, parametros, dataSource);
            return JasperExportManager.exportReportToPdf(jasperPrint);
        }
    }
}
