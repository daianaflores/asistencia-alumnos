package asistenciaalumnos.app.model.DTO;

import asistenciaalumnos.app.model.Contacto;
import asistenciaalumnos.app.model.Estado;
import asistenciaalumnos.app.model.TipoUsuario;
import asistenciaalumnos.app.model.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class UsuarioDto {
    @JsonIgnore
    private final Usuario usuario;

    public UsuarioDto(Usuario usuario){
        this.usuario = usuario;
    }

    public Long getId(){return this.usuario.getId(); }

    public TipoUsuario getTipoUsuario(){
        return this.usuario.getTipoUsuario();
    }

    public String getNombre(){
        return this.usuario.getNombre();
    }

    public String getApelido(){
        return this.usuario.getApellido();
    }

    public String getFulnnName(){
        return this.usuario.getApellido()+" "+this.usuario.getNombre();
    }

    public Long getDNI(){
        return this.usuario.getDni();
    }

    public Date getFechaNacimiento(){
        return  this.usuario.getFechaDeNacimiento();
    }

    public Long getLegajo(){
        return this.usuario.getLegajo();
    }

    public Estado getEstado(){return this.usuario.getEstado();}

    public Contacto getContacto(){return this.usuario.getContacto();}

}
