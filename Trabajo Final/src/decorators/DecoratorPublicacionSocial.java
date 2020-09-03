package decorators;

import interfaces.IPublicacion;

import modelo.Publicacion;
import modelo.Usuario;

public class DecoratorPublicacionSocial extends Decorator {

    public DecoratorPublicacionSocial(IPublicacion p) {
        super(p);
    }

    @Override
    public String getTipoPublicacion() {
        return publicacion.getTipoPublicacion() + " Social";
    }
    @Override
    public int getVisibilidad() {
        
        return publicacion.getVisibilidad();
    }

    @Override
    public void setVisibilidad(int num) {
        // TODO Implement this method
        publicacion.setVisibilidad(num);
    }
    @Override
    public String getDescripcion() {
        // TODO Implement this method
        return publicacion.getDescripcion();
    }
    
    public String toString(){
        return "Publicacion Social " + publicacion.toString();
    }

    public void añadirLike() {
        // TODO Implement this method
        publicacion.añadirLike();
    }

    @Override
    public int getLikes() {
        // TODO Implement this method
        
        return publicacion.getLikes();
    }

    @Override
    public void añadirComentario() {
        // TODO Implement this method
        publicacion.añadirComentario();
    }

    @Override
    public int getComentarios() {
        // TODO Implement this method
        return publicacion.getComentarios();
    }

    @Override
    public void añadirVisto() {
        // TODO Implement this method
    }

    @Override
    public void añadirEtiqueta() {
        // TODO Implement this method
        publicacion.añadirEtiqueta();
    }

    @Override
    public int getEtiquetas() {
        // TODO Implement this method
        return publicacion.getEtiquetas();
    }

    @Override
    public int getVistos() {
        // TODO Implement this method
        return 0;
    }
}
