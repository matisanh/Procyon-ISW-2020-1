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

    public List<Solicitud> obtenerAll(){
        return repo.findAll();
    }

    public String getCurrentTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        return dtf.format(now);
    }
}