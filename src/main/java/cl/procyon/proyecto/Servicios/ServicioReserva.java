package cl.procyon.proyecto.Servicios;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.CollectionUtils;
import org.springframework.stereotype.Service;

import cl.procyon.proyecto.Modelos.Reserva;
import cl.procyon.proyecto.Modelos.Solicitud;
import cl.procyon.proyecto.Repositorios.ReservasRepo;

@Service("servicioreserva")
public class ServicioReserva {
    @Autowired
    @Qualifier("repositorioreserva")
    ReservasRepo repo;

    @Autowired
    @Qualifier("serviciosolicitud")
    ServicioSolicitud solicitud;

    public boolean crear(Reserva reserva){

        try{
            /* Primero hay que verificar que el bloque que se esta reservando ya no este tomado
            Esto lo verifico comparando aritmeticamente si el block solicitado  si el tipo . 
            Otra solucion a esto podria ser almacenar los bloques reservados como lista.*/

            if(checkReservedBlock(reserva)){
                return false;
            }
            // Agrego la fecha de la reserva, desde la hora del servidor
            reserva.setDateLog(getCurrentTime());
            reserva.setStatus("Reservado");

            
            // Adicionalmente, si la reserva tiene un ID de solicitud, esta solicitud es desactivada
            if(reserva.getidSolicitud() != 0){
                solicitud.desactivar(reserva.getidSolicitud());
            }
            
            repo.save(reserva);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean actualizar(long id, Reserva reserva){
        reserva.setID(id);
        reserva.setDateLog(getCurrentTime());
        reserva.setStatus("Reservado");
        if(!checkReservedBlock(reserva)){
            System.out.println("Uf Men");
            repo.save(reserva);
            return true;
        }
        else{
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

    public List<Reserva> reservaFiltro(Integer idSolicitud, String dateReserved, Integer reservedBlock, Integer resourceType, Integer resourceID) {
        if (!(idSolicitud == null)&!(dateReserved==null)&!(reservedBlock==null)&!(reservedBlock==null)&!(resourceType==null)&!(resourceID==null)){
            return null;
        }
        else if(!(dateReserved==null)&!(resourceType==null)&!(resourceID==null)){
            return repo.findByDateReservedAndResourceTypeAndResourceID(dateReserved, resourceType, resourceID);
        }
        else if(!(idSolicitud == null)){
            return repo.findByIdSolicitud(idSolicitud);
        }
        return repo.findByStatus("Reservado");
    }
    
    public String getCurrentTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        return dtf.format(now);
    }

    // Con esta funcion verifico si todos los bloques especificados (block+nBlock) estan disponibles
    public boolean checkReservedBlock(Reserva reserva){
        int resID = reserva.getresourceID();
        int resType = reserva.getresourceType();
        String date = reserva.getDateReserved();
        int firstBlock = reserva.getReservedBlock();
        int lastBlock = firstBlock + reserva.getnReservedBlocks();
        List<Integer> blocks = IntStream.range(firstBlock, lastBlock).boxed().collect(Collectors.toList());

        // TODO: Hay que mejorar este algoritmo
        List<Reserva> ResList = repo.findByDateReservedAndResourceTypeAndResourceID(date, resType, resID);
        for(Reserva res : ResList ){
            int TargetfirstBlock = res.getReservedBlock();
            int TargetlastBlock = TargetfirstBlock + res.getnReservedBlocks();
            List<Integer> TargetBlocks = IntStream.range(TargetfirstBlock, TargetlastBlock).boxed().collect(Collectors.toList());

            if(CollectionUtils.containsAny(TargetBlocks,blocks)){
                return true;
            }
        }
        return false;
    }

}