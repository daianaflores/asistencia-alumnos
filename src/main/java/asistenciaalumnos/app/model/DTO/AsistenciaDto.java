package main.java.asistenciaalumnos.app.model.DTO;

import asistenciaalumnos.app.model.Alumno;
import asistenciaalumnos.app.model.Contacto;
import asistenciaalumnos.app.model.Estado;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class AsistenciaDto {

    @JsonIgnore
    private final Asistencia asistencia;

    public AsistenciaDto(Asistencia asistencia){this.asistencia = asistencia;}

    public int getId(){
        return this.asistencia.getId();
    }
//es tipo INT o CURSADA?
    public Cursada getIdCursada(){
        return this.asistencia.getIdCursada();
    }
//que tipo de fecha hay que usar?
    public datetime getFecha(){
        return this.asistencia.getFecha();
    }
//que tipo de dato hay que usar?
    public bit getIsPresent(){
        return this.asistencia.getIsPresent();
    }

}
