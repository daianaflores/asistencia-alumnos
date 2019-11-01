package asistenciaalumnos.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import asistenciaalumnos.app.model.DTO.AlumnoDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import asistenciaalumnos.app.model.Alumno;
import asistenciaalumnos.app.service.AlumnoService;

@RestController
@CrossOrigin(origins = "*", 
             methods= {RequestMethod.GET, 
                       RequestMethod.POST,
                       RequestMethod.PUT,
                       RequestMethod.DELETE})
public class AlumnoController 
{
    @Autowired
    AlumnoService alumnoService;

    //ejemplo instanciar logger
    private static  final Logger LOGGER = LogManager.getLogger(AlumnoController.class);


    @GetMapping(path = "/")
    public String hello() throws Exception 
    {
        //ejemplos de loggeo
        LOGGER.debug("Debugging log");
        LOGGER.info("Info log");
        LOGGER.warn("Hey, This is a warning!");
        LOGGER.error("Oops! We have an Error. OK");
        LOGGER.fatal("Damn! Fatal error. Please fix me.");
        String message = alumnoService.getHello();
        return message;

    }

    @GetMapping(path = "/alumnos")
    public ResponseEntity<?> alumnos() throws Exception 
    {

        List<AlumnoDto> alumnos = new ArrayList<AlumnoDto>();
        try {
            alumnos = alumnoService.getAlumnos();
        } catch (Exception ex) {
            //ejemplo de implementación
            LOGGER.error(HttpStatus.INTERNAL_SERVER_ERROR);
            ex.printStackTrace();
            return new ResponseEntity<List<AlumnoDto>>(alumnos, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<List<AlumnoDto>>(alumnos, HttpStatus.OK);
    }

    @PostMapping(path = "/alumnos")
    public ResponseEntity<?> altaAlumno(@RequestBody Alumno alumno) throws Exception
    {
        Alumno alumnoResponse = alumnoService.altaAlumno(alumno);
        AlumnoDto alumnoDto = new AlumnoDto(alumno);

        return new ResponseEntity<AlumnoDto>(alumnoDto, HttpStatus.OK);
    }

    @PutMapping(path = "/alumnos")
    public ResponseEntity<?> modificacionAlumno(@RequestBody Alumno alumno) throws Exception
    {
        Alumno alumnoResponse = alumnoService.modificacionAlumno(alumno);
        AlumnoDto alumnoDto = new AlumnoDto(alumnoResponse);
        if (alumnoResponse == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<AlumnoDto>(alumnoDto, HttpStatus.OK);
    }

    @DeleteMapping(path = "/alumnos/{id}")
    public ResponseEntity<?> bajaAlumno(@PathVariable("id") Long id) throws Exception
    {
        alumnoService.bajaAlumno(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}