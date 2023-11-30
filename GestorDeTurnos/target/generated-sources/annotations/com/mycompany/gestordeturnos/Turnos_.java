package com.mycompany.gestordeturnos;

import com.mycompany.gestordeturnos.Mascota;
import com.mycompany.gestordeturnos.Veterinario;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-11-30T16:38:23", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Turnos.class)
public class Turnos_ { 

    public static volatile SingularAttribute<Turnos, LocalDateTime> fecha;
    public static volatile SingularAttribute<Turnos, Veterinario> veterinario;
    public static volatile SingularAttribute<Turnos, Mascota> mascota;
    public static volatile SingularAttribute<Turnos, Boolean> confirmado;
    public static volatile SingularAttribute<Turnos, Integer> id;

}