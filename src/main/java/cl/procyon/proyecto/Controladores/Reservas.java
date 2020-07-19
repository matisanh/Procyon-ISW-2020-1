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

import cl.procyon.proyecto.Modelos.Reserva;
import cl.procyon.proyecto.Servicios.ServicioReserva;


@CrossOrigin
@RestController
@RequestMapping("/reservas")
public class Reservas {

    @Autowired
    @Qualifier("servicioreserva")
    ServicioReserva reserva;

    @GetMapping("/")
    public List<Reserva> listar() {
        return reserva.obtenerAll();
    }

}