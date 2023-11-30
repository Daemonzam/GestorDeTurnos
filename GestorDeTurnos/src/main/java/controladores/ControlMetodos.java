package controladores;

import com.mycompany.gestordeturnos.Mascota;
import com.mycompany.gestordeturnos.Turnos;
import com.mycompany.gestordeturnos.Veterinario;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class ControlMetodos {
    ControllerMascotaJpa controlMascota = new ControllerMascotaJpa();
    public void crearMascota(Mascota mascota){
        controlMascota.crearMascota(mascota);
    }
    ControllerTurnosJpa controlTurnos = new ControllerTurnosJpa();
    public void crearTurnos(Turnos turnos){
        controlTurnos.crearTurnos(turnos);
    }
    ControllerVeterinarioJpa controlVeterinario = new ControllerVeterinarioJpa();
    public void crearVeterinario(Veterinario veterinario){
        controlVeterinario.crearVeterinario(veterinario);
    }
    public void agendarTurno(Mascota mascota, Veterinario veterinario) {
        Turnos nuevoTurno = new Turnos();
        nuevoTurno.setMascota(mascota);
        nuevoTurno.setVeterinario(veterinario);
        nuevoTurno.setFecha(LocalDateTime.now());
       
        if (mascota.getId() == 0) {
            crearMascota(mascota);
        }
        crearTurnos(nuevoTurno);
    }

         public void confirmarTurno(int idTurno, Veterinario veterinario) {
         Turnos turno = obtenerTurnoPorId(idTurno);

        if (turno != null) {            
            if (turno.getVeterinario().getId() == veterinario.getId()) {
                
                turno.setConfirmado(true);
               
                actualizarTurno(turno);
                System.out.println("El turno ha sido confirmado por el veterinario: " + veterinario.getNombre());
            } else {
                System.out.println("El veterinario no tiene permisos para confirmar este turno.");
            }
        } else {
            System.out.println("El turno con ID " + idTurno + " no existe.");
            }
    }

    public void actualizarTurno(Turnos turno) {
        TurnosJpaController controladorTurnos = new TurnosJpaController();
        
        try {
            controladorTurnos.actualizar(turno);
        } catch (Exception e) {
                      
        }
    }
    public Turnos obtenerTurnoPorId(int idTurno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_GestorDeTurnos");
        EntityManager em = emf.createEntityManager();

        Turnos turno = null;
        try {
            
            turno = em.find(Turnos.class, idTurno);
        } catch (Exception e) {
                      
        } finally {
            em.close();
            emf.close();
        }

        return turno; 
    }

    public List<Turnos> obtenerTurnosDisponibles() {
        
        List<Turnos> turnosDisponibles = new ArrayList<>();

        
        turnosDisponibles.add(new Turnos(1, "2023-12-01T09:00", new Mascota(1, "Milo"), new Veterinario(1, "Juan")));
        turnosDisponibles.add(new Turnos(2, "2023-12-02T10:00", new Mascota(2, "Luna"), new Veterinario(2, "Joako")));
        turnosDisponibles.add(new Turnos(3, "2023-12-03T11:00", new Mascota(3, "Simba"), new Veterinario(3, "German")));

        return turnosDisponibles;
    }
    public List<Mascota> obtenerMascotasDisponibles() {
        TypedQuery<Mascota> query = ControllerMascotaJpa.createQuery("SELECT m FROM Mascota m WHERE m.disponible = true", Mascota.class);
        return query.getResultList();
    }

    // Método para obtener veterinarios disponibles utilizando JPA
    public List<Veterinario> obtenerVeterinariosDisponibles() {
        TypedQuery<Veterinario> query = ControllerVeterinarioJpa.createQuery("SELECT v FROM Veterinario v WHERE v.disponible = true", Veterinario.class);
        return query.getResultList();
    }

   
}
