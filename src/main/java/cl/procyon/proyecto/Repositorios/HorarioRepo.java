package cl.procyon.proyecto.Repositorios;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.procyon.proyecto.Modelos.Horario;

@Repository("repositorioshorario")
public interface HorarioRepo extends JpaRepository<Horario, Serializable> {
    
}