package asistenciaalumnos.app.controller;


import asistenciaalumnos.app.configs.CurrentUser;
import asistenciaalumnos.app.configs.UserDetails;
import asistenciaalumnos.app.model.Cursada;
import asistenciaalumnos.app.model.DTO.CursadaDto;
import asistenciaalumnos.app.service.CursadaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "*",
        methods= {RequestMethod.GET,
                RequestMethod.POST,
                RequestMethod.PUT,
                RequestMethod.DELETE})
public class CursadaController {

    @Autowired
    CursadaService cursadaService;

    private static  final Logger LOGGER = LogManager.getLogger(AlumnoController.class);

    @GetMapping(path = "/cursadas")
    public ResponseEntity<?> alumnos() throws Exception
    {
        List<CursadaDto> cursadas = new ArrayList<CursadaDto>();
        try {
            cursadas = cursadaService.findAll();
        } catch (Exception ex) {
            LOGGER.error(HttpStatus.INTERNAL_SERVER_ERROR);
            ex.printStackTrace();
            return new ResponseEntity<List<CursadaDto>>(cursadas, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<CursadaDto>>(cursadas, HttpStatus.OK);
    }

    @PutMapping(path = "/updateCursada")
    public ResponseEntity<?> modificacionCursada(HttpServletRequest request, @CurrentUser UserDetails user,
                                                 @RequestParam("cursada")Cursada cursada,
                                                 @RequestParam("fecha") Date fecha  ) throws Exception {
        Cursada cursadaResponse = cursadaService.findById(cursada.getId());
        if(Objects.isNull(cursadaResponse)){
            LOGGER.error(HttpStatus.NOT_FOUND);
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        CursadaDto cursadaDto = new CursadaDto(cursadaResponse);
        cursadaService.updateCursada(cursada,user);
        return new ResponseEntity<CursadaDto>(cursadaDto,HttpStatus.OK);
    }


    @PostMapping(path = "/newCursada")
    public ResponseEntity<?> altaCursada(HttpServletRequest request, @CurrentUser UserDetails user,
                                         @RequestParam("cursada")Cursada cursada,
                                         @RequestParam("fecha") Date fecha  ) throws Exception {
        Cursada cursadaResponse = cursadaService.bindProperties(cursada, user, fecha);
        try {
            cursadaService.save(cursadaResponse);
        }catch (Exception e){
            LOGGER.error(e);
            LOGGER.error(HttpStatus.INTERNAL_SERVER_ERROR);
            e.printStackTrace();
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        CursadaDto cursadaDto = new CursadaDto(cursadaResponse);
        return new ResponseEntity<CursadaDto>(cursadaDto, HttpStatus.OK);
    }







}
