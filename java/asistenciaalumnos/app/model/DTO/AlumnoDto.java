package asistenciaalumnos.app.model.DTO;

import asistenciaalumnos.app.model.Alumno;
import asistenciaalumnos.app.model.Contacto;
import asistenciaalumnos.app.model.Estado;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class AlumnoDto {

    @JsonIgnore
    private final Alumno alumno;

    public AlumnoDto(Alumno alumno){this.alumno = alumno;}

    public Long getDNI(){return this.alumno.getDNI();}

    public String getNombre(){
        return this.alumno.getNombre();
    }

    public String getApellido(){
        return this.alumno.getApellido();
    }

    public String getFullName(){
        return this.alumno.getApellido()+" "+this.alumno.getNombre();
    }

    public Long getMatricula(){
        return this.alumno.getMatricula();
    }

    public Contacto getContacto(){
        return this.alumno.getContacto();
    }

    public Estado getEstado(){
        return this.alumno.getEstado();
    }

    public String getEmail(){
        return this.alumno.getEmail();
    }

}
