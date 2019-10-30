package asistenciaalumnos.app.controller;


import asistenciaalumnos.app.model.DTO.UsuarioDto;
import asistenciaalumnos.app.model.Usuario;
import asistenciaalumnos.app.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*",
        methods= {RequestMethod.GET,
                RequestMethod.POST,
                RequestMethod.PUT,
                RequestMethod.DELETE})
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping(path = "/")
    public String hello() throws Exception
    {
        String message = usuarioService.getHello();
        return message;
    }
    @GetMapping(path = "/usuarios")
    public ResponseEntity<?> usuarios() throws Exception
    {
        List<UsuarioDto> usuarios = new ArrayList<UsuarioDto>();
        try {
            usuarios = usuarioService.getUsuarios();
        } catch (Exception e){
            return new ResponseEntity<List<UsuarioDto>>(usuarios, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<UsuarioDto>>(usuarios, HttpStatus.OK);
    }



    //service devuelve int no instancia de usuario
    /*@PostMapping(path = "/usuarios")
    public ResponseEntity<?> altaUsuario(@RequestBody Usuario usuario) throws Exception
    {

        Usuario suarioResponse = usuarioService.altaUsuario(usuario);

        return new ResponseEntity<>(, HttpStatus.OK);
    }*/



    //metodo modificado según service
    @PutMapping(path = "/usuarios")
    public ResponseEntity<?> modificacionUsuario(@RequestBody Usuario usuario) throws Exception
    {
        Integer suarioResponse = usuarioService.modificacionUsuario(usuario);
        if (suarioResponse == null)
        {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/usuarios/{id}")
    public ResponseEntity<?> bajaUsuario(@PathVariable("id") Long id) throws Exception
    {
        usuarioService.bajaUsuario(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
