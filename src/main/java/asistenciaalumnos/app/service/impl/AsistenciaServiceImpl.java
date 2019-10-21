package main.java.asistenciaalumnos.app.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

import asistenciaalumnos.app.model.Asistencia;
import asistenciaalumnos.app.repository.AsistenciaRepository;
import asistenciaalumnos.app.service.AsistenciaService;

@Service

public class AsistenciaServiceImpl {

	@Autowired
	AsistenciaRepository asistenciaRepository;

    @Override
    public String getHello() throws Exception
    {
        String message = "Hello World from API REST Spring Boot!!";
        return message;
    }

    @Override
    public List<Asistencia> getAsistencias() throws Exception
    {
        List<Asistencia> asistencias = asistenciaRepository.findAll();
        return asistencias;
    }

    @Override
    public Asistencia tomaAsistencia(Asistencia asistencia) throws Exception 
    {
    	Asistencia asistenciaResponse = asistenciaRepository.saveAndFlush(asistencia);
        return asistenciaResponse;
    }

    @Override
    public Asistencia modificacionAsistencia(Asistencia asistencia) throws Exception 
    {
        boolean asistenciaExist = asistenciaRepository.existsById(asistencia.getDNI());
        if (!alumnoExist)
        {
            return null;
        }
        Asistencia asistenciaResponse = asistenciaRepository.saveAndFlush(asistencia);
        return asistenciaResponse;
    }

}
