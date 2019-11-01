package asistenciaalumnos.app.service;

import asistenciaalumnos.app.model.Contacto;
import asistenciaalumnos.app.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactoService {

    @Autowired
    ContactoRepository contactoRepository;

    //verifico q exista el objeto, si existe me lo traigo
    public Contacto findById(Long id){
        Optional<Contacto> contacto=contactoRepository.findById(id);
        if(contacto.isPresent()){
            return contacto.get();
        }else{
            return null;
        }
    }

}
