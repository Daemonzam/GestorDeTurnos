package DAO;

import com.mycompany.gestordeturnos.Turnos;
import java.util.List;

public interface TurnosDAO {
    Turnos obtenerPorId(int id);
    List<Turnos> obtenerTodos();
    void guardar(Turnos turnos);
    void actualizar(Turnos turnos);
    void eliminar(int id);
}
