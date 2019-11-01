package asistenciaalumnos.app.repository;

import asistenciaalumnos.app.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoRepository extends JpaRepository<Contacto, Long>
{
}
