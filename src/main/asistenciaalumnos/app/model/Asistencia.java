package asistenciaalumnos.app.model;

import javax.persistence.*;

import java.util.Date;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "Asistencia")
public class Asistencia extends Auditable<String>{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @OneToOne(orphanRemoval=true)
    @JoinColumn(name = "ID_CURSADA", referencedColumnName = "ID")
    private Cursada cursada;

    @Column(name = "FECHA", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @OneToMany(mappedBy = "asistencia",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<AsistenciaAlumno> asistenciaAlumnos;

    @PrePersist
    protected void onCreate() {
        this.creationDate = new Date();
        this.lastModifiedDate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.lastModifiedDate = new Date();
    }

    public Asistencia()
    {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cursada getCursada() {
        return cursada;
    }

    public void setCursada(Cursada cursada) {
        this.cursada = cursada;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Set<AsistenciaAlumno> getAsistenciaAlumnos() {
        return asistenciaAlumnos;
    }

    public void setAsistenciaAlumnos(Set<AsistenciaAlumno> asistenciaAlumnos) {
        this.asistenciaAlumnos = asistenciaAlumnos;
    }
}
