package asistenciaalumnos.app.model.DTO;

import asistenciaalumnos.app.model.Cursada;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class CursadaDto {

    @JsonIgnore
    private final Cursada cursada;

    public CursadaDto(Cursada cursada) {this.cursada = cursada;}

    public Long getId(){return this.cursada.getId();}

    public AlumnoDto getAlumno(){ return new AlumnoDto(this.cursada.getAlumno());}

    public MateriaDto getMateria(){return new MateriaDto(this.cursada.getMateria());}

    public DocenteDto getDocente(){return new DocenteDto(this.cursada.getDocente());}

    public EstadoDto getEstado(){return  new EstadoDto(this.cursada.getEstado());}

    public Integer getYear(){return this.cursada.getYear();}

    public Integer getCuatrimestre(){return this.cursada.getCuatrimestre();}


}
