package asistenciaalumnos.app.repository;

import asistenciaalumnos.app.model.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Long>
{
}
