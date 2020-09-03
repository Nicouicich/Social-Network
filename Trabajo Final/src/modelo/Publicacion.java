package modelo;

import interfaces.IPublicacion;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Publicacion implements IPublicacion{
    protected String descripcion,tipoPublicacion=null;
    protected int visibilidad;
    protected ArrayList <String> comentarios=new ArrayList <String> ();;
    protected HashMap <String,Usuario> etiquetas= new HashMap <String,Usuario> ();
    protected int cantLikes=0,cantComentarios=0,cantEtiquetas=0;

    protected final static String[] lugares={" Bayahibe","El Caribe","Mar del plata","Jujuy","Barcelona","España","Cipolleti","Roca"};
    private final static int cantidadLugares=8;
    
    
    
    
    public Publicacion(String descripcion,int visibilidad,String clasificacion) {
        this.descripcion = descripcion;
        this.visibilidad=visibilidad;
        
        this.tipoPublicacion=clasificacion;
        //comentarios=new ArrayList <String> ();
        //etiquetas = new HashMap <String,Usuario> ();
    }
    public void agregarEtiquetas(Usuario usuario){
        etiquetas.put(usuario.getNombre(), usuario);
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void recibirComentario (String comentario){
        comentarios.add(comentario);
    }

    public String getTipoPublicacion() {
        return tipoPublicacion;
    }

    public int getVisibilidad() {
        return visibilidad;
    }
    public void setVisibilidad(int num){
        
        switch (num){
        case 1:
        case 2:
        case 3:
            this.visibilidad=num;
        break;
            default: //ACA PODRIA TIRAR UNA EXCEPCION SI SE INGRESA UN NUMERO NO VALIDO PERO CON LA VENTANA SE HARIA CLICK?

        }
        
    }
    public boolean estaEtiquetado (Usuario usuario){
        
        if (etiquetas.get(usuario.getNombre())!=null)
            return true;
        else
            return false;
    }

    public void setTipoPublicacion(String tipoPublicacion) {
        this.tipoPublicacion = tipoPublicacion;
    }

    @Override
    public String toString() {
        String cad="";
        cad+="tipo publicacion: "+ getTipoPublicacion()+", Descripcion: " + this.getDescripcion() + " Visibilidad: " + this.visibilidad + "\n";
        return cad;
    }
    
    public static int getCantLugares(){
        return cantidadLugares;
    }
    public static String getLugar(int i){
        return lugares[i];
    }
    

    public void añadirLike() {
        this.cantLikes += 1;
    }

    public int getLikes() {
        return cantLikes;
    }

    public void añadirComentario( ) {
        this.cantComentarios  += 1;
    }

    public int getComentarios() {
        return cantComentarios;
    }

 
    public void añadirEtiqueta() {
        this.cantEtiquetas += 1;
    }

    public int getEtiquetas() {
        return cantEtiquetas;
    }
    

}
