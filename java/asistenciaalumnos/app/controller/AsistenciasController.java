package asistenciaalumnos.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import asistenciaalumnos.app.model.Asistencia;
import asistenciaalumnos.app.service.AsistenciaService;

@RestController
@CrossOrigin(origins = "*", 
             methods= {RequestMethod.GET, 
                       RequestMethod.POST,
                       RequestMethod.PUT,
                       RequestMethod.DELETE})

public class AsistenciasController {

    @Autowired
    AsistenciaService asistenciaService;

    @GetMapping(path = "/")
    public String hello() throws Exception 
    {
        String message = asistenciaService.getHello();
        return message;
    }

    @GetMapping(path = "/alumnos")
    public ResponseEntity<?> asistencias() throws Exception 
    {
        List<Asistencia> asistencias = new ArrayList<Asistencia>();
        
        asistencias.addAll(asistenciaService.getAsistencias());
        
        return new ResponseEntity<List<Asistencia>>(asistencias, HttpStatus.OK);
    }

    @PostMapping(path = "/asistencias")
    public ResponseEntity<?> altaAsistencia(@RequestBody Asistencia asistencia) throws Exception
    {
    	Asistencia asistenciaResponse = asistenciaService.altaAsistencia(asistencia);

        return new ResponseEntity<Asistencia>(asistenciaResponse, HttpStatus.OK);
    }

    @PutMapping(path = "/asistencias")
    public ResponseEntity<?> modificacionAsistencia(@RequestBody Asistencia asistencia) throws Exception
    {
    	Asistencia asistenciaResponse = asistenciaService.modificacionAsistencia(asistencia);

        if (asistenciaResponse == null)
        {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Asistencia>(asistenciaResponse, HttpStatus.OK);
    }

    @DeleteMapping(path = "/asistencias/{id}")
    public ResponseEntity<?> bajaAsistencia(@PathVariable("id") Long id) throws Exception
    {
        asistenciaService.bajaAsistencia(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
