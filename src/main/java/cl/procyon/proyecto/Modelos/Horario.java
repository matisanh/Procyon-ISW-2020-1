package cl.procyon.proyecto.Modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "bloque_horario")
@Entity
public class Horario {
    @Id
    int id;
    @Column(name = "hora")
    String hora;

    public int getBloque(){
        return this.id;
    }

    public String getHora(){
        return this.hora;
    }
}