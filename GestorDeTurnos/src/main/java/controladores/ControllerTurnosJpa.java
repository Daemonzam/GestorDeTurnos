package controladores;

import com.mycompany.gestordeturnos.Turnos;

public class ControllerTurnosJpa {
    TurnosJpaController turnosJpa = new TurnosJpaController();
    public void crearTurnos(Turnos turnos){
        turnosJpa.create(turnos);
    }
}
