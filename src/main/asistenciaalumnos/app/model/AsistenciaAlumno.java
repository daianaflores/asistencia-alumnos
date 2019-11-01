package asistenciaalumnos.app.model;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "AsistenciaAlumno")
public class AsistenciaAlumno extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "IS_PRESENT")
    private Boolean isPresent;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="ID_ALUMNO",nullable = false)
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="ID_ASISTENCIA",nullable = false)
    private Asistencia asistencia;

    @PrePersist
    protected void onCreate() {
        this.creationDate = new Date();
        this.lastModifiedDate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.lastModifiedDate = new Date();
    }

    public AsistenciaAlumno(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getPresent() {
        return isPresent;
    }

    public void setPresent(Boolean present) {
        isPresent = present;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Asistencia getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Asistencia asistencia) {
        this.asistencia = asistencia;
    }
}
