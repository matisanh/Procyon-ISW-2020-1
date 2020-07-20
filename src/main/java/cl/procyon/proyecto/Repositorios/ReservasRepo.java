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
/*     La busqueda por ID Solicitud retorna una lista pues una solicitud puede reservar varios recursos
    y por lo tanto, se desencadenan varias reservas de recursos */
    public abstract List<Reserva> findByIdSolicitud(int idSolicitud);
    public abstract List<Reserva> findByDateReservedAndResourceTypeAndResourceID(String dateReserved, int resourceType, int resourceID);
    public abstract Reserva findByresourceTypeAndResourceIDAndDateReservedAndReservedBlock(int resourceType, int resourceID, String dateReserved, int reservedBlock);
}