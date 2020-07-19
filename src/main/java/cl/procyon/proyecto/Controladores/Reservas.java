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
import cl.procyon.proyecto.Repositorios.ReservasRepo;


@CrossOrigin
@RestController
@RequestMapping("/reserva")
public class Reservas {

    @Autowired
    private ReservasRepo repo;

    @GetMapping("/")
    public List<Reserva> listar() {
        return repo.findAll();
    }

    // Solicitud sol2 = new Solicitud(2,3,2,2,2,true,"2017-03-10 10:23:10");
    // @PostMapping("/create")
    // public void createSolicitud(@RequestBody Solicitud sol) {
    //     solicitudes.save(sol2);
    // }
}