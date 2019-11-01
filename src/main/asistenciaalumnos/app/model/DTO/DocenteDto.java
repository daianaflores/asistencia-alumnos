package asistenciaalumnos.app.model.DTO;

import asistenciaalumnos.app.model.Docente;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class DocenteDto {

    @JsonIgnore
    private final Docente docente;

    public DocenteDto(Docente docente){this.docente = docente;}

    public Long getId(){return this.docente.getId();}


}
