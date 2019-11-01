package asistenciaalumnos.app.model;

import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Administrativo extends Usuario{
    //dejo clase vacía por las dudas revisar como inicializar
    @PrePersist
    //seteo al crear q siempre va a ser un usuario de tipo docente a partir del id de Administrativo
    protected void onCreate() {
        this.getTipoUsuario().setId(1L);
    }

    public Administrativo()
    {
        super();
    }

}
