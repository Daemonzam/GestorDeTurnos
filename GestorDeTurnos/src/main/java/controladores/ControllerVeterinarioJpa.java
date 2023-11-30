package controladores;

import com.mycompany.gestordeturnos.Veterinario;
import javax.persistence.TypedQuery;

public class ControllerVeterinarioJpa {

    static TypedQuery<Veterinario> createQuery(String select_v_FROM_Veterinario_v_WHERE_vdispon, Class<Veterinario> aClass) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    VeterinarioJpaController veterinarioJpa = new VeterinarioJpaController();
    
    public void crearVeterinario(Veterinario veterinario){
        veterinarioJpa.create(veterinario);
    }
    
}
