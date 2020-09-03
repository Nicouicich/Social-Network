package decorators;

import interfaces.IPublicacion;

import modelo.Publicacion;
import modelo.Usuario;

public abstract class Decorator implements IPublicacion {
    protected IPublicacion publicacion;

    public Decorator(IPublicacion p) {
        super();
        this.publicacion=p;
    }


    @Override
    public boolean estaEtiquetado(Usuario usuario) {
        return publicacion.estaEtiquetado(usuario);
    }
}
