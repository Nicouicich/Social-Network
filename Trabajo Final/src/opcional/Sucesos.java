package opcional;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import modelo.Usuario;
import java.util.HashMap;

public class Sucesos {
    protected String nombre,lugar;
    protected GregorianCalendar fecha;
    protected ArrayList <Usuario> integrantes= new ArrayList <Usuario>();
    
    public Sucesos() {
        super();
        System.out.println("SUCESO CREADO CON EXITO");
    }

    public Sucesos(String nombre, String lugar, GregorianCalendar fecha) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.fecha = fecha;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }
    
    public void nuevoIntegrante (Usuario usuario){
        if (integrantes.contains(usuario)==false){
            usuario.notifica("Se agrego a " + usuario+ " a el evento " +this);
            integrantes.add(usuario);
        }
    }
    public void mostrarIntegrantes(){
        int i;
        for (i=0;i<integrantes.size();i++){
            System.out.println(integrantes.get(i) + "\n");
        }
    }

    public String getLugar() {
        return lugar;
    }

    @Override
    public String toString() {
        // TODO Implement this method
        return "El suceso es: ";
    }
}
