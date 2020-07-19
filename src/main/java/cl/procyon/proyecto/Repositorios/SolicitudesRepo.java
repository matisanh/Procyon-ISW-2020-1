package cl.procyon.proyecto.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.procyon.proyecto.Modelos.Solicitud;

@Repository("repositoriosolicitud")
public interface SolicitudesRepo extends JpaRepository<Solicitud, Integer> {
    public abstract Solicitud findById(long id);
    public abstract List<Solicitud> findAll();
}