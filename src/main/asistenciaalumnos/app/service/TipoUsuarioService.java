package asistenciaalumnos.app.service;

import asistenciaalumnos.app.model.TipoUsuario;
import asistenciaalumnos.app.repository.TipoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TipoUsuarioService {

   @Autowired
    TipoUsuarioRepository tipoUsuarioRepository;

    public TipoUsuario findById(Long id){
        Optional<TipoUsuario> tipoUsuario = tipoUsuarioRepository.findById(id);
        if(tipoUsuario.isPresent()){
            return tipoUsuario.get();
        }else{
            return null;
        }
    }
}
