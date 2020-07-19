package cl.procyon.proyecto.Repositorios;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.procyon.proyecto.Modelos.Reserva;

@Repository("repositorioreserva")
public interface ReservasRepo extends JpaRepository<Reserva, Serializable> {
    public abstract Reserva findById(long id);
    public abstract List<Reserva> findAll();
    public abstract List<Reserva> findByStatus(String status);
}