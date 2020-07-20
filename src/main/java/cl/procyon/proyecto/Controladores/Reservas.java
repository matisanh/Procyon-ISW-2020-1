package cl.procyon.proyecto.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.procyon.proyecto.Modelos.Reserva;
import cl.procyon.proyecto.Servicios.ServicioReserva;


@CrossOrigin
@RestController
@RequestMapping("/reservas")
public class Reservas {

    @Autowired
    @Qualifier("servicioreserva")
    ServicioReserva reserva;

    // Parametros sobre /reservas
    @GetMapping()
    public List<Reserva> reservasPor(
        @RequestParam(name = "idSolicitud", required = false) Integer idSolicitud,
        @RequestParam(name = "dateReserved", required = false) String dateReserved,
        @RequestParam(name = "reservedBlock", required = false) Integer reservedBlock,
        @RequestParam(name = "resourceType", required = false) Integer resourceType,
        @RequestParam(name = "resourceID", required = false) Integer resourceID)            
    throws Exception {
        return reserva.reservaFiltro(idSolicitud,dateReserved,reservedBlock,resourceType,resourceID);
    }

    @GetMapping("/")
    public List<Reserva> listar() {
        return reserva.obtenerAll();
    }

    @GetMapping("/reserva/{id}")
    public Reserva reservaID(@PathVariable("id") long id) {
        return reserva.obtenerporId(id);
    }

    @PutMapping("/reserva/{id}")
    public boolean actualizaReserva(@PathVariable("id") long id, @RequestBody Reserva res) {
        return reserva.actualizar(id,res);
    }

    @PostMapping()
    public void createSolicitud(@RequestBody Reserva res) {
        reserva.crear(res);
    }

}