package cl.procyon.proyecto.Repositorios;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.procyon.proyecto.Modelos.Solicitud;

@Repository("repositoriosolicitud")
public interface SolicitudesRepo extends JpaRepository<Solicitud, Serializable> {
    public abstract Solicitud findById(long id);
    public abstract List<Solicitud> findAll();
    public abstract List<Solicitud> findByActive(boolean active);
    public abstract List<Solicitud> findByresourceType(int resourceType);
    public abstract List<Solicitud> findByActiveAndResourceType(boolean active, int resourceType);
}