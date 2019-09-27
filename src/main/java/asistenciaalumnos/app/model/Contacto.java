package asistenciaalumnos.app.model;

import com.sun.xml.internal.bind.v2.TODO;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "Contacto")
public class Contacto extends Auditable<String> {


    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    /*Faltan campos?
    * falta referencia a entidad 'Tipo Contacto', no se entiende relación ni funcionalidad
    * */

    @Column(name = "descripcion", length = 500, nullable = false)
    private String descripcion;



    @PrePersist
    protected void onCreate() {
        this.creationDate = new Date();
        this.lastModifiedDate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.lastModifiedDate = new Date();
    }

    public Contacto()
    {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
