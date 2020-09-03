package opcional;

import java.util.GregorianCalendar;


public class Reunion extends Sucesos {
    public Reunion() {
        super();
    }

    public Reunion(String nombre, String lugar, GregorianCalendar fecha) {
        // TODO Implement this method
        super(nombre, lugar, fecha);
    }
    
    @Override
    public String toString() {
        // TODO Implement this method
        return  super.toString()+ "una reunion" ;
    }
}
