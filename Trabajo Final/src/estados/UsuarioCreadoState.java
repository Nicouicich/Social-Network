package estados;

import interfaces.State;

import modelo.Usuario;

public class UsuarioCreadoState implements State {
    private Usuario usuario;

    public UsuarioCreadoState(Usuario usuario) {
        super();
        this.usuario=usuario;
    }

    @Override
    public void nuevaPublicacion() {
        // TODO Implement this method
        System.out.println("El usuario procede a crear una publicacion");
    }

    @Override
    public void eliminarAmigo() {
        // TODO Implement this method
        System.out.println("El usuario no tiene amigos, recien fue creado");
    }

    @Override
    public void comentarPublicacion() {
        // TODO Implement this method
        System.out.println("El usuario no esta interactuando con ningunga publicacion");
    }

    @Override
    public void interactuarPublicaciones() {
        // TODO Implement this method
        System.out.println("El usuario procede a interactuar con una publicacion");
    }

    @Override
    public void publicando() {
        // TODO Implement this method
        System.out.println("El usuario no puede publicar porque recien fue creado");
    }
}
