package estados;

import interfaces.State;

import modelo.Publicacion;
import modelo.Usuario;

public class PublicandoState implements State{
    private Usuario usuario;
    
    public PublicandoState(Usuario usuario) {
        super();
        this.usuario=usuario;
    }


    @Override
    public void nuevaPublicacion() {
        System.out.println("Error, el usuario " + usuario+" ya esta publicando una publicacion");
    }


    @Override
    public void eliminarAmigo() {
        // TODO Implement this method
    }

    @Override
    public void comentarPublicacion() {
        // TODO Implement this method
    }

    @Override
    public void interactuarPublicaciones() {
        // TODO Implement this method
    }

    @Override
    public void publicando() {
        // TODO Implement this method
    }
}
