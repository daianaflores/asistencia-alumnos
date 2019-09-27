package asistenciaalumnos.app.service;

import asistenciaalumnos.app.model.Usuario;

import java.util.List;

public interface UsuarioService {

    String getHello() throws Exception;

    List<Usuario> getUsuarios() throws Exception;

    int altaUsuario(Usuario usuario) throws Exception;

    int modificacionUsuario(Usuario Usuario) throws Exception ;

    int bajaUsuario(Long id) throws Exception;


}
