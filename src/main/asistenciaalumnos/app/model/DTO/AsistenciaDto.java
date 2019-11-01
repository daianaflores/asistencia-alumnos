package asistenciaalumnos.app.model.DTO;

import asistenciaalumnos.app.model.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.PublicKey;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AsistenciaDto {

    //ejemplo instanciar logger
    private static  final Logger LOGGER = LogManager.getLogger(AsistenciaDto.class);

    @JsonIgnore
    private final Asistencia asistencia;

    public AsistenciaDto(Asistencia asistencia){this.asistencia = asistencia;}

    public Long getId(){return  this.asistencia.getId();}

    public CursadaDto getCursada(){return  new CursadaDto(this.asistencia.getCursada());}

    public Date getFecha(){return this.asistencia.getFecha();}

    public List<AsistenciaAlumnoDto> getAsitenciaAlumno(){
        Set<AsistenciaAlumno> asistenciaAlumnoSet = this.asistencia.getAsistenciaAlumnos();
       return asistenciaAlumnoSet.stream().map(it -> {return new AsistenciaAlumnoDto(it); }).collect(Collectors.toList());
    }


/*
    public int getId(){   }
//es tipo INT o CURSADA?-->es tipo cursada revisar mapeo de clases en alumno por ejemplo
    public Cursada getIdCursada(){
        return this.asistencia.getIdCursada();
    }
//que tipo de fecha hay que usar?-->la fecha q está en la base, el dto no crea un objeto nuevo,
                                    sirve para devolver al front end un objeto existente
    public Date getFecha(){
        return this.asistencia.getFecha();
    }
//que tipo de dato hay que usar?-->booleano bit es en la base da datos sqlServer
    public boolean getIsPresent(){
        return this.asistencia.getIsPresent();
    }
*/




}
