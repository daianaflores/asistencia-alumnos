package asistenciaalumnos.app.repository;

import asistenciaalumnos.app.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
}
