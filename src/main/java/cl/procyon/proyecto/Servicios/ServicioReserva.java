package cl.procyon.proyecto.Servicios;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cl.procyon.proyecto.Modelos.Reserva;
import cl.procyon.proyecto.Repositorios.ReservasRepo;

@Service("servicioreserva")
public class ServicioReserva {
    @Autowired
    @Qualifier("repositorioreserva")
    ReservasRepo repo;

    public boolean crear(Reserva reserva){

        try{
            // Agrego la fecha de la reserva, desde la hora del servidor
            reserva.setDateLog(getCurrentTime());
            reserva.setStatus("Reservado");
            repo.save(reserva);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public Reserva obtenerporId(long id){
        return repo.findById(id);
    }

	public void updateStatus(long id, String status) {
        Reserva sol = repo.findById(id);
        sol.setStatus(status);
        repo.save(sol);
    }
    
    public List<Reserva> obtenerAll(){
        return repo.findAll();
    }

    // public List<Reserva> obtenerporStatus(boolean active){
    //     return repo.findByActive(active);
    // }

    // public List<Reserva> reservaesFiltro(Boolean active, Integer resourceType) {
    //     if(!(resourceType == null)&!(active == null)){
    //         return repo.findByActiveAndResourceType(active, resourceType);
    //     }
    //     else if(!(resourceType == null)){
    //         return repo.findByresourceType(resourceType.intValue());
    //     }
    //     else if(!(active == null)){
    //         return repo.findByActive(active);
    //     }
    //     return null;
    // }
    
    public String getCurrentTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        return dtf.format(now);
    }

}