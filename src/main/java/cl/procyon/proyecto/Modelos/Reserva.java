package cl.procyon.proyecto.Modelos;

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
    @GenericGenerator(name="incrementreserva", strategy="increment")
    @GeneratedValue(generator="incrementreserva")
    long id;
    @Column(name = "idSolicitud")
    int idSolicitud;
    @Column(name = "idPaciente")
    int idPaciente;
    @Column(name = "resourceType")
    int resourceType;
    @Column(name = "resourceID")
    int resourceID;
    @Column(name = "procedureType")
    int procedureType;
    @Column(name = "dateReserved")
    String dateReserved;
    @Column(name = "reservedBlock")
    int reservedBlock;
    @Column(name = "nReservedBlocks")
    int nReservedBlocks;
    @Column(name = "dateLog")
    String dateLog;
    @Column(name = "status")
    String status;

    public Reserva(){
    }

    public long getID(){
        return this.id;
    }
    public int getIDSolicitud(){
        return this.idSolicitud;
    }
    public int getIDPaciente(){
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
    public int getNumberReservedBlocks(){
        return this.nReservedBlocks;
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
    public void setIDSolicitud(int idSolicitud){
        this.idSolicitud = idSolicitud;
    }
    public void setIDPaciente(int idPaciente){
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
    public void setDateReserved(String dateReserved){
        this.dateReserved = dateReserved;
    }
    public void setReservedBlock(int reservedBlock){
        this.reservedBlock = reservedBlock;
    }
    public void setNumberReservedBlocks(int nReservedBlocks){
        this.nReservedBlocks = nReservedBlocks;
    }
    public void setDateLog(String dateLog){
        this.dateLog = dateLog;
    }
    public void setStatus(String status){
        this.status = status;
    }

    
}