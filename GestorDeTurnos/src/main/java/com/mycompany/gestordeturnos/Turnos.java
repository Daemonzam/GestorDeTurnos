package com.mycompany.gestordeturnos;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TURNOS")
@Getter
@Setter
public class Turnos implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    LocalDateTime fecha;
    @ManyToOne
    Mascota mascota;
    @OneToOne
    Veterinario veterinario;
    boolean confirmado;

    public Turnos() {
    }

    public Turnos(int id, String fecha, Mascota mascota, Veterinario veterinario) {
        this.id = id;
        this.mascota = mascota;
        this.veterinario = veterinario;
    }
    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    
    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }
    
}
