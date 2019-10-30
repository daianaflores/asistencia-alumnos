package asistenciaalumnos.app.model.DTO;

import asistenciaalumnos.app.model.Estado;
import asistenciaalumnos.app.model.Materia;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class MateriaDto {

    @JsonIgnore
    private final Materia materia;

    public MateriaDto(Materia materia){this.materia = materia;}

    public Long getId(){return this.materia.getId();}

    public String getDescription(){return this.materia.getDescripcion();}

}
