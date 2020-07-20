package cl.procyon.proyecto.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    // @GetMapping()
    // public List<Solicitud> obtenerporStatus(@RequestParam(name="status", required=false) boolean active){
    //     return solicitud.obtenerporStatus(active);
    // }

    @GetMapping()
    public List<Solicitud> solicitudesPor(@RequestParam(name = "status", required = false) Boolean active,
                           @RequestParam(name = "resourceType", required = false) Integer resource) throws Exception {
        return solicitud.solicitudesFiltro(active,resource);
    }

    @GetMapping("/")
    public List<Solicitud> listar() {
        return solicitud.obtenerAll();
    }

    @GetMapping("/solicitud")
    public Solicitud obtenerporId(@RequestParam(name="id", required=false) long id){
        return solicitud.obtenerporId(id);
    }

    @PostMapping()
    public void createSolicitud(@RequestBody Solicitud sol) {
        solicitud.crear(sol);
    }

    // Esta funcion solo será usada cuando la solicitud se confirme (o sea, se produzca la reserva)
    // pasando la solicitud/{id} de activate=true a activate=false
    @PutMapping()
    public void updateSolicitud(@RequestBody Solicitud sol) {
        if(!sol.getActive()){
            solicitud.desactivar(sol.getID());
        }
        else{
            solicitud.activar(sol.getID());
        }
    }
}