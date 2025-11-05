package tpdindustrial.tpdindustrial.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tpdindustrial.tpdindustrial.service.relacionofertaservicioService;

@Controller
@Slf4j
public class controladorROS {

    @Autowired
    private relacionofertaservicioService rosservice;

    @GetMapping("/detalleoferta/{codigo}")
    public String detalleofert(@PathVariable("codigo") Integer codigo,
            Model modelo) {
        var listaros = rosservice.listardetalleofertaservicio(codigo);
        modelo.addAttribute("condiciones", listaros.get(0).getOferta().getCodicioncomercial());
        modelo.addAttribute("formadepago", listaros.get(0).getOferta().getFormapago());
        modelo.addAttribute("empleado", listaros.get(0).getOferta().getEmpleado().getCargo());
        modelo.addAttribute("detalleoferta", listaros);
        return "detalleofertaservicio/listardetalleofertaservicio";
    }
}
