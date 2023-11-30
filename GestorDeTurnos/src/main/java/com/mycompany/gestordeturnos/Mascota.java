
package com.mycompany.gestordeturnos;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="MASCOTAS")
@Getter
@Setter
public class Mascota implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String nombre;

    public Mascota() {
    }

    public Mascota(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }         
}
