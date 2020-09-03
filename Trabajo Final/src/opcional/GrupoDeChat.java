package opcional;

import excepciones.MiembroDelGrupoExistenteException;

import java.util.ArrayList;
import java.util.HashMap;

import modelo.Usuario;

public class GrupoDeChat {
    private String nombre;
    private HashMap <String,Usuario> grupo=new HashMap <String,Usuario> () ;
    
    public GrupoDeChat(String nombre) {
        super();
        this.nombre=nombre;
    }
    
    public void nuevoUsuarioJefe(Usuario usuario){
        grupo.put(usuario.getNombre(),usuario);
    }
    
    public void nuevoUsuario(Usuario usuario)  {
            usuario.notifica(usuario +" fue agregado a un grupo de chat");
            this.grupo.put(usuario.getNombre(),usuario);
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}