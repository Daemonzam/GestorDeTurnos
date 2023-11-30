package DAO;

import com.mycompany.gestordeturnos.Mascota;
import java.util.List;

public interface MascotaDao {
    Mascota obtenerPorId(int id);
    List<Mascota> obtenerTodos();
    void guardar(Mascota mascota);
    void actualizar(Mascota mascota);
    void eliminar(int id);  
    
}
