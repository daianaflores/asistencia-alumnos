package asistenciaalumnos.app.model.DTO;

import asistenciaalumnos.app.model.Estado;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class EstadoDto {

    @JsonIgnore
    private final Estado estado;

    public EstadoDto(Estado estado){this.estado = estado;}

    public Long getId(){return this.estado.getId();}

    public String getDescription(){return this.estado.getDescripcion();}


}
