package asistenciaalumnos.app.repository;

import asistenciaalumnos.app.model.Cursada;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursadaRepository extends JpaRepository<Cursada, Long> {
}
