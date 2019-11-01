package asistenciaalumnos.app.service;

import asistenciaalumnos.app.model.Estado;
import asistenciaalumnos.app.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    EstadoRepository estadoRepository;

    public Estado findById(Long id){
        Optional<Estado> estado = estadoRepository.findById(id);
        if(estado.isPresent()){
            return estado.get();
        }else{
            return null;
        }
    }
}
