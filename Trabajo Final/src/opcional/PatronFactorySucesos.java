package opcional;

import decorators.DecoratorPublicacionComercial;
import decorators.DecoratorPublicacionSocial;

import java.util.GregorianCalendar;

import modelo.Foto;
import modelo.Publicacion;
import modelo.Texto;
import modelo.Video;


public class PatronFactorySucesos {
    public PatronFactorySucesos() {
        super();
    }
    
    public static Sucesos getSuceso (String tipo,String nombre,String lugar,GregorianCalendar fecha){
        Sucesos suceso = null;
        
        if (tipo.equalsIgnoreCase("CUMPLEANIOS")){
            suceso= new Cumpleanios( nombre, lugar, fecha);
        }
        else
            if (tipo.equalsIgnoreCase("EVENTO"))
                suceso= new Evento( nombre, lugar, fecha);
            
            else
                if (tipo.equalsIgnoreCase("REUNION"))
                    suceso=new Reunion( nombre, lugar, fecha);        
        return suceso;


    
    }
}
