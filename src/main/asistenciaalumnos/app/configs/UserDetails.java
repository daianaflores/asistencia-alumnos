package asistenciaalumnos.app.configs;

import asistenciaalumnos.app.model.TipoUsuario;
import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {
    private String id;
    private String username;
    private TipoUsuario tipoUsuario;
}
