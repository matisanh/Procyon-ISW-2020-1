package cl.procyon.proyecto.Modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Table(name = "solicitudes")
@Entity
public class Solicitud {
    @Id
    @GenericGenerator(name="incrementsolicitud", strategy="increment")
    @GeneratedValue(generator="incrementsolicitud")
    int id;
    @Column(name = "resource_type")
    int resource_type;
    @Column(name = "id_patient")
    int idPatient;
    @Column(name = "procedure_type")
    int procedureType;
    @Column(name = "date_reserve")
    String dateReserve;
    @Column(name = "id_requester")
    int idRequester;
    @Column(name = "active")
    boolean active;
    @Column(name = "date")
    String date;

    public Solicitud(){
    }

    // public Solicitud (int id, int resource_type, int id_patient, int procedure_type, String date_reserve, int id_requester, boolean active, String date){
    //     this.id = id;
    //     this.resource_type = resource_type;
    //     this.id_patient = id_patient;
    //     this.procedure_type = procedure_type;
    //     this.date_reserve = date_reserve;
    //     this.id_requester = id_requester;
    //     this.active = active;
    //     this.date = date;
    // }

    // public Solicitud (int id, int resource_type, int id_patient, int procedure_type, int id_requester, boolean active, String date){
    //     this.id = id;
    //     this.resource_type = resource_type;
    //     this.id_patient = id_patient;
    //     this.procedure_type = procedure_type;
    //     this.id_requester = id_requester;
    //     this.active = active;
    //     this.date = date;
    // }

    public int getID(){
        return this.id;
    }

    public int getResource_type(){
        return this.resource_type;
    }

    public int getIdPatient(){
        return this.idPatient;
    }

    public int getProcedureType(){
        return this.procedureType;
    }

    public int getIdRequester(){
        return this.idRequester;
    }
    public boolean getActive(){
        return this.active;
    }

    // Devuelve el bloque solicitado (si es que se especifico)
    public String getDateReserved(){
        return this.dateReserve;
    } 

    // Devuelve cuando fue creada la solicitud
    public String getLogDate(){
        return this.date;
    } 

    // Metodos para setear valores
    public void setResource(int resourceType){
        this.resource_type = resourceType;
    }

    public void setPaciente(int idPaciente){
        this.idPatient = idPaciente;
    }
    
    public void setProcedure(int procedureType){
        this.procedureType = procedureType;
    }
    public void setDateReserva(String dateReserva){
        this.dateReserve = dateReserva;
    }
    public void setRequester(int idRequester){
        this.idRequester = idRequester;
    }
    public void setStatus(boolean active){
        this.active = active;
    }

    public void setDateSolicitud(String dateSolicitud){
        this.date = dateSolicitud;
    }
    
}