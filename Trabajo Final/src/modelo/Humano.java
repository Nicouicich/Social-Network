package modelo;

import estados.CreandoPublicacionState;

import interfaces.IPublicacion;

import java.io.Serializable;

import java.util.Observer;

public class Humano extends Usuario {
    private static  Humano Instance=null;
    
    private Humano(String nombre,Observer o) {
        super(nombre);
        this.addObserver(o);
    }
    
    public static Humano getInstance(Observer o){
        if (Instance==null)
            Instance=new Humano("Creador",o);
        
        return Instance;
    }

    public String getNombre(){
        return super.getNombre();
    }

    public void nuevaPublicacion(String string, String string1, String string2, String string3, String string4,
                                 Double double1, Integer integer) {
        IPublicacion publicacion =null;
        
        publicacion = PatronFactoryPublicaciones.getPublicacion(string,string1,string2, string3, string4, double1, integer);

        estado= new CreandoPublicacionState(this);
        RedSocial.getInstance().publicar(this, publicacion);
    }
}
