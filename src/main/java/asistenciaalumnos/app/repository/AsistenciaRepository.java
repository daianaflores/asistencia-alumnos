package main.java.asistenciaalumnos.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import asistenciaalumnos.app.model.Asistencia;

public interface AsistenciaRepository extends JpaRepository<Asistencia, Long>{

}
