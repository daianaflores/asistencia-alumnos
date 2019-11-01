package asistenciaalumnos.app.repository;

import asistenciaalumnos.app.model.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsistenciaRepository extends JpaRepository<Asistencia, Long> {
}
