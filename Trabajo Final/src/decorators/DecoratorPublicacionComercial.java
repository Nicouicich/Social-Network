package decorators;

import interfaces.IPublicacion;

import modelo.Publicacion;

public class DecoratorPublicacionComercial extends Decorator {

    private int vistos=0;


    public DecoratorPublicacionComercial(IPublicacion publicacion) {
        super(publicacion);
    }

    @Override
    public String getTipoPublicacion() {
        return publicacion.getTipoPublicacion() + " Comercial";
    }

    public int getVistos() {
        return vistos;
    }

    public void nuevoVisto(){
        vistos++;
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
        return "Publicacion Comercial " + publicacion.toString();
    }

    @Override
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
        publicacion.añadirVisto();
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
}
