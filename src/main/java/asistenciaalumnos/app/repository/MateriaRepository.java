package asistenciaalumnos.app.repository;

import asistenciaalumnos.app.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MateriaRepository extends JpaRepository<Materia, Long>
{
}
