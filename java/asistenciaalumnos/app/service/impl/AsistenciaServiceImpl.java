package asistenciaalumnos.app.service.impl;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import asistenciaalumnos.app.model.DTO.AsistenciaDto;
import asistenciaalumnos.app.service.AsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import asistenciaalumnos.app.model.Asistencia;
import asistenciaalumnos.app.repository.AsistenciaRepository;
import javax.transaction.Transactional;


@Service
@Transactional
public class AsistenciaServiceImpl implements AsistenciaService {

	@Autowired
	AsistenciaRepository asistenciaRepository;


	//xq se sigue usando el metodo helloWorld?
    @Override
    public String getHello() throws Exception
    {
        String message = "Hello World from API REST Spring Boot!!";
        return message;
    }

    @Override
    public List<Asistencia> getAsistencias() throws Exception
    {
        List<Asistencia> asistencias = asistenciaRepository.findAll();
        List<AsistenciaDto> asistenciaDtoList = asistencias.stream().map(i -> new AsistenciaDto(i)).collect(Collectors.toList());

        return asistencias;
    }

    @Override
    //mal corregir
    public Asistencia tomaAsistencia(Asistencia asistencia) throws Exception 
    {
    	Asistencia asistenciaResponse = asistenciaRepository.saveAndFlush(asistencia);
        return asistenciaResponse;
    }

    @Override
    //mal corregir
    public Asistencia modificacionAsistencia(Asistencia asistencia) throws Exception 
    {   //dejo el método comentado y uso forma más sencilla de verificar asistencia
        //arreglo metodo anterior, no estaba apuntado a la propiedad requerida correctamente
     /* boolean asistenciaExist = asistenciaRepository.existsById(asistencia.getCursada().getAlumno().getDNI());
        if (!alumnoExist)
        {
            return null;
        }*/
        asistencia = findById(asistencia.getId());
        Asistencia asistenciaResponse = asistenciaRepository.saveAndFlush(asistencia);
        return asistenciaResponse;
    }

    @Override
    public Asistencia altaAsistencia(Asistencia asistencia) throws Exception {
        return null;
    }

    @Override
    public void bajaAsistencia(Long id) throws Exception {

        //hacer borrado logico con seteo de columna en estado 'dado de baja'

    }


    public Asistencia findById(Long id){
        Optional<Asistencia> asistencia = asistenciaRepository.findById(id);
        if(asistencia.isPresent()){
            return asistencia.get();
        }else{
            return null;
        }
    }

}
