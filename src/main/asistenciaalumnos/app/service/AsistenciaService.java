package asistenciaalumnos.app.service;

import java.util.List;

import asistenciaalumnos.app.model.Asistencia;

public interface AsistenciaService {
    String getHello() throws Exception;

    List<Asistencia> getAsistencias() throws Exception;

    Asistencia tomaAsistencia(Asistencia asistencia) throws Exception;

    Asistencia modificacionAsistencia(Asistencia asistencia) throws Exception ;

    Asistencia altaAsistencia (Asistencia asistencia) throws  Exception ;

    void bajaAsistencia(Long id) throws Exception;

}
