package DAO;

import com.mycompany.gestordeturnos.Veterinario;
import java.util.List;

public interface VeterinarioDAO {
    Veterinario obtenerPorId(int id);
    List<Veterinario> obtenerTodos();
    void guardar(Veterinario veterinario);
    void actualizar(Veterinario veterinario);
    void eliminar(int id);
}
