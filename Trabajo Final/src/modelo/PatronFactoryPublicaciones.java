package modelo;

import decorators.DecoratorPublicacionComercial;
import decorators.DecoratorPublicacionSocial;

import interfaces.IPublicacion;

public class PatronFactoryPublicaciones {

    public static IPublicacion getPublicacion (String clasificacion,String tipo,String descripcion,String resolucion, String lugar,double duracion,int visibilidad){
        IPublicacion publicacion =null;
        Publicacion encapsulado =null;
        
        if (tipo.equalsIgnoreCase("FOTO")){
            encapsulado= new Foto(descripcion,lugar,resolucion,visibilidad,"FOTO");
        }
        else
            if (tipo.equalsIgnoreCase("VIDEO")){
                encapsulado= new Video(descripcion,duracion,visibilidad,"VIDEO");
        }
            else
                if (tipo.equalsIgnoreCase("TEXTO"))
                    encapsulado=new Texto(descripcion,visibilidad,"TEXTO");
        

        if (encapsulado!=null){
            if (clasificacion.equalsIgnoreCase("COMERCIAL")){
                publicacion= new DecoratorPublicacionComercial(encapsulado);
            }
            else
                if (clasificacion.equalsIgnoreCase("SOCIAL")){
                    publicacion= new DecoratorPublicacionSocial(encapsulado);

                }

        }
            
        return publicacion;
    }
}
