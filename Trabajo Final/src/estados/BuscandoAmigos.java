package estados;

import interfaces.State;

import modelo.Usuario;

public class BuscandoAmigos implements State {
    private Usuario usuario;
    public BuscandoAmigos(Usuario usuario) {
        super();
        this.usuario=usuario;
    }



    @Override
    public void nuevaPublicacion() {
        // TODO Implement this method
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
