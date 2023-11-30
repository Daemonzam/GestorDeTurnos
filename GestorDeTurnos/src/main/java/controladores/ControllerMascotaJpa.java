
package controladores;

import com.mycompany.gestordeturnos.Mascota;
import javax.persistence.TypedQuery;


public class ControllerMascotaJpa {

    static TypedQuery<Mascota> createQuery(String select_m_FROM_Mascota_m_WHERE_mdisponible, Class<Mascota> aClass) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    MascotaJpaController mascotaJpa = new MascotaJpaController();
    
    public void crearMascota(Mascota mascota){
        mascotaJpa.create(mascota);
    }
}
