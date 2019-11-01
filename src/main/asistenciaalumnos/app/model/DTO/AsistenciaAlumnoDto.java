package asistenciaalumnos.app.model.DTO;

import asistenciaalumnos.app.model.Alumno;
import asistenciaalumnos.app.model.Asistencia;
import asistenciaalumnos.app.model.AsistenciaAlumno;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class AsistenciaAlumnoDto {
    @JsonIgnore
    private final AsistenciaAlumno asistenciaAlumno;

    public AsistenciaAlumnoDto(AsistenciaAlumno asistenciaAlumno){this.asistenciaAlumno = asistenciaAlumno; }

    public Long getId(){return this.asistenciaAlumno.getId();}

    public AlumnoDto getAlumno(){
        return new AlumnoDto(this.asistenciaAlumno.getAlumno());
    }

    public AsistenciaDto getAsistencia(){
        return new AsistenciaDto(this.asistenciaAlumno.getAsistencia());
    }

    public Boolean getPresent(){return this.asistenciaAlumno.getPresent();}

}
