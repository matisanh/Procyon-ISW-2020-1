package cl.procyon.proyecto.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.procyon.proyecto.Modelos.Horario;
import cl.procyon.proyecto.Repositorios.HorarioRepo;

@CrossOrigin
@RestController
@RequestMapping("/horarios")
public class Horarios {

    @Autowired
    HorarioRepo horario;

    @GetMapping()
    public List<Horario> listar() {
        return horario.findAll();
    }

}