package cl.procyon.proyecto.Modelos;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Table(name = "reservas")
@Entity
public class Reserva {
    @Id
    @GenericGenerator(name = "incrementreserva", strategy = "increment")
    @GeneratedValue(generator = "incrementreserva")
    long id;
    // La idSolicitud se permite nulo pues podria haber una reserva "directa", sin solicitud
    @Column(name = "idSolicitud")
    int idSolicitud;
    @Column(name = "idPaciente", nullable = false)
    int idPaciente;
    @Column(name = "resourceType", nullable = false)
    int resourceType;
    @Column(name = "resourceID", nullable = false)
    int resourceID;
    @Column(name = "procedureType", nullable = false)
    int procedureType;
    @Column(name = "dateReserved", nullable = false)
    String dateReserved;
    @Column(name = "reservedBlock", nullable = false)
    int reservedBlock;
    @Column(name = "nReservedBlocks", nullable = false)
    int nReservedBlocks;
    @Column(name = "dateLog", nullable = false)
    String dateLog;
    @Column(name = "status", nullable = false)
    String status;

    public Reserva(){
    }

    public long getID(){
        return this.id;
    }
    public int getidSolicitud(){
        return this.idSolicitud;
    }
    public int getidPaciente(){
        return this.idPaciente;
    }
    public int getresourceType(){
        return this.resourceType;
    }
    public int getresourceID(){
        return this.resourceID;
    }
    public int getprocedureType(){
        return this.procedureType;
    }
    public String getDateReserved(){
        return this.dateReserved;
    }
    public int getReservedBlock(){
        return this.reservedBlock;
    }
    public int getnReservedBlocks(){
        return this.nReservedBlocks;
    }
    public List<Integer> getblocksReserved(){
        int firstBlock = this.reservedBlock;
        int lastBlock = firstBlock + this.nReservedBlocks;
        List<Integer> blocks = IntStream.range(firstBlock, lastBlock).boxed().collect(Collectors.toList());
        return blocks;
    }
    public String getDateLog(){
        return this.dateLog;
    }
    public String getStatus(){
        return this.status;
    }


    // Setear valores a la reserva

    public void setID(long id){
        this.id = id;
    }
    public void setidSolicitud(int idSolicitud){
        this.idSolicitud = idSolicitud;
    }
    public void setidPaciente(int idPaciente){
        this.idPaciente = idPaciente;
    }
    public void setresourceType(int resourceType){
        this.resourceType = resourceType;
    }
    public void setresourceID(int resourceID){
        this.resourceID = resourceID;
    }
    public void setprocedureType(int procedureType){
        this.procedureType = procedureType;
    }
    public void setdateReserved(String dateReserved){
        this.dateReserved = dateReserved;
    }
    public void setReservedBlock(int reservedBlock){
        this.reservedBlock = reservedBlock;
    }
    public void setnReservedBlocks(int nReservedBlocks){
        this.nReservedBlocks = nReservedBlocks;
    }
    public void setDateLog(String dateLog){
        this.dateLog = dateLog;
    }
    public void setStatus(String status){
        this.status = status;
    }

    
}