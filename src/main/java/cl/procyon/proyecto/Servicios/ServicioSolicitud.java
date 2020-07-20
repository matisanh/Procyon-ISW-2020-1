package cl.procyon.proyecto.Servicios;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import cl.procyon.proyecto.Modelos.Solicitud;
import cl.procyon.proyecto.Repositorios.SolicitudesRepo;

@Service("serviciosolicitud")
public class ServicioSolicitud {
    @Autowired
    @Qualifier("repositoriosolicitud")
    SolicitudesRepo repo;

    public boolean crear(Solicitud solicitud){

        try{
            // Agrego la fecha de la solicitud, desde la hora del servidor
            solicitud.setDateSolicitud(getCurrentTime());  
            repo.save(solicitud);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public Solicitud obtenerporId(long id){
        return repo.findById(id);
    }

    public void desactivar(long id) {
        Solicitud sol = repo.findById(id);
        sol.setStatus(false);
        repo.save(sol);
	}

	public void activar(long id) {
        Solicitud sol = repo.findById(id);
        sol.setStatus(true);
        repo.save(sol);
    }
    
    public List<Solicitud> obtenerAll(){
        return repo.findAll();
    }

    public List<Solicitud> obtenerporStatus(boolean active){
        return repo.findByActive(active);
    }
    public List<Solicitud> solicitudesFiltro(Boolean active, Integer resourceType) {
        if(!(resourceType == null)&!(active == null)){
            return repo.findByActiveAndResourceType(active, resourceType);
        }
        else if(!(resourceType == null)){
            return repo.findByresourceType(resourceType.intValue());
        }
        else if(!(active == null)){
            return repo.findByActive(active);
        }
        return repo.findByActive(true);
    }
    
    public String getCurrentTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        return dtf.format(now);
    }

}