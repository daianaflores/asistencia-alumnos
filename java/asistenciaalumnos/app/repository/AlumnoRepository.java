package asistenciaalumnos.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import asistenciaalumnos.app.model.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long>
{
    
}