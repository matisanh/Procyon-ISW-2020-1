package cl.procyon.proyecto.Modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "reservas")
@Entity
public class Reserva {
    @Id
    int id;
    @Column(name = "name")
    String name;

    public Reserva(){

    }

    public int getID(){
        return id;
    }
    public String getName(){
        return name;
    }
}