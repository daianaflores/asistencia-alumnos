package asistenciaalumnos.app.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "CURSADA")
public class Cursada extends Auditable<String>{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @OneToOne(orphanRemoval=true)
    @JoinColumn(name = "ID_MATERIA", referencedColumnName = "ID")
    private Materia materia;

    @OneToOne(orphanRemoval=true)
    @JoinColumn(name = "ID_ALUMNO", referencedColumnName = "ID")
    private Alumno alumno;

    //va a tabla tipo Docente o Usuario? no se entiende el script de DB
    @OneToOne(orphanRemoval=true)
    @JoinColumn(name = "ID_DOCENTE", referencedColumnName = "ID")
    private Docente docente;

    @OneToOne(orphanRemoval=true)
    @JoinColumn(name = "ID_ESTADO", referencedColumnName = "ID")
    private Estado estado;

    @Column(name = "ANIO", nullable = false)
    private Integer year;

    @Column(name = "CUATRIMESTRE", nullable = false)
    private Integer cuatrimestre;

    public Cursada()
    {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(Integer cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }
}
