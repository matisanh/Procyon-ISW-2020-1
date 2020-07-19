package cl.procyon.proyecto.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cl.procyon.proyecto.Modelos.Solicitud;
import cl.procyon.proyecto.Servicios.ServicioSolicitud;

@CrossOrigin
@RestController
@RequestMapping("/solicitudes")
public class Solicitudes {

    @Autowired
    @Qualifier("serviciosolicitud")
    ServicioSolicitud solicitud;

    @GetMapping()
    public List<Solicitud> listar() {
        return solicitud.obtenerAll();
    }

    @PostMapping()
    public void createSolicitud(@RequestBody Solicitud sol) {
        solicitud.crear(sol);
    }
}