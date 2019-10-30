package asistenciaalumnos.app.service;

import java.util.List;

import asistenciaalumnos.app.model.Alumno;
import asistenciaalumnos.app.model.DTO.AlumnoDto;

public interface AlumnoService
{
    String getHello() throws Exception;

    List<AlumnoDto> getAlumnos() throws Exception;

    Alumno altaAlumno(Alumno alumno) throws Exception;

    Alumno modificacionAlumno(Alumno alumno) throws Exception ;

    void bajaAlumno(Long id) throws Exception;
}