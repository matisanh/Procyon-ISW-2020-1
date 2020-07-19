package cl.procyon.proyecto.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import cl.procyon.proyecto.Modelos.Reserva;

public interface ReservasRepo extends JpaRepository<Reserva, Integer> {
    
}