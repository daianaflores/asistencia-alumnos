package asistenciaalumnos.app.service;

import asistenciaalumnos.app.configs.UserDetails;
import asistenciaalumnos.app.model.Cursada;
import asistenciaalumnos.app.model.DTO.CursadaDto;
import asistenciaalumnos.app.repository.CursadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CursadaService {

    @Autowired
    CursadaRepository cursadaRepository;

    public Cursada findById(Long id){
        Optional<Cursada> cursada = cursadaRepository.findById(id);
        if(cursada.isPresent()){
            return cursada.get();
        }else{
            return null;
        }
    }

    public List<CursadaDto> findAll(){
        List<Cursada> cList = cursadaRepository.findAll();
        List<CursadaDto> cursadaDtoList = cList.stream().map(it -> new CursadaDto(it)).collect(Collectors.toList());
        return cursadaDtoList;
    }
    @Transactional
    public void updateCursada(Cursada cursada, UserDetails user){
        //me traigo la cursada ya grabada para modificar sus propiedades y luego lo vuelvo a grabar
        Cursada cursadaDb = findById(cursada.getId());
        bindProperties(cursadaDb,user,new Date());
        save(cursadaDb);
    }


    //grabar objeto en base de datos
    public void save(Cursada cursada){cursadaRepository.save(cursada);}

    //metodo para setear los campos de auditoría
    public Cursada bindProperties(Cursada cObject, UserDetails user, Date currentDate){
        if(cObject.getId() != null ){
            cObject.setAuditableUpdate(currentDate,user.getUsername());
        }else{
            cObject.setAuditable(currentDate,user.getUsername());
        }
        return cObject;
    }

}
