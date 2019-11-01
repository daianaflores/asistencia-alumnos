package asistenciaalumnos.app.model.DTO;

import asistenciaalumnos.app.model.Alumno;
import asistenciaalumnos.app.model.Cursada;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CursadaDto {

    @JsonIgnore
    private final Cursada cursada;

    public CursadaDto(Cursada cursada) {this.cursada = cursada;}

    public Long getId(){return this.cursada.getId();}

    public List<AlumnoDto> getAlumno(){
        Set<Alumno> aList = this.cursada.getAlumnos();
        return  aList.stream().map(it -> { return new AlumnoDto(it); }).collect(Collectors.toList());
    }

    public MateriaDto getMateria(){return new MateriaDto(this.cursada.getMateria());}

    public DocenteDto getDocente(){return new DocenteDto(this.cursada.getDocente());}

    public EstadoDto getEstado(){return  new EstadoDto(this.cursada.getEstado());}

    public Integer getYear(){return this.cursada.getYear();}

    public Integer getCuatrimestre(){return this.cursada.getCuatrimestre();}


}
