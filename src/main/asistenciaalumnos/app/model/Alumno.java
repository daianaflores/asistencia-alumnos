package asistenciaalumnos.app.model;


import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Alumnos")
public class Alumno extends Auditable<String>{
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "MATRICULA", unique = true, nullable = false)
	private Long matricula;

	@Column(name = "nombre", length = 30, nullable = false)
	private String nombre;

	@Column(name = "apellido", length = 30, nullable = false)
	private String apellido;

	@Column(name = "email", length = 100, nullable = false)
	private String email;

	@Column(name = "fechaNacimiento", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaNacimiento;

	@Column(name = "DNI", nullable = false)
	private Long DNI;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ESTADO", nullable = false)
	private Estado estado;

	@OneToOne(orphanRemoval=true)
	@JoinColumn(name = "ID_CONTACTO", referencedColumnName = "ID")
	private Contacto contacto;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ID_CURSADA", nullable = false)
	private Cursada cursada;

	@OneToMany(mappedBy = "alumno",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
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

	public Alumno()
	{
		super();
	}

	public Long getDNI() {
		return DNI;
	}

	public void setDNI(Long DNI) {
		this.DNI = DNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	public Cursada getCursada() {
		return cursada;
	}

	public void setCursada(Cursada cursada) {
		this.cursada = cursada;
	}

	public Set<AsistenciaAlumno> getAsistenciaAlumnos() {
		return asistenciaAlumnos;
	}

	public void setAsistenciaAlumnos(Set<AsistenciaAlumno> asistenciaAlumnos) {
		this.asistenciaAlumnos = asistenciaAlumnos;
	}
}