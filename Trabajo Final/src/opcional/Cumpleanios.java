package opcional;

import java.util.GregorianCalendar;


public class Cumpleanios extends Sucesos {
    public Cumpleanios() {
        super();
    }

    public Cumpleanios(String nombre, String lugar, GregorianCalendar fecha) {
        // TODO Implement this method
        super(nombre, lugar, fecha);
    }
    
    @Override
    public String toString() {
        // TODO Implement this method
        return super.toString()+ "un cumpleanios " ;
    }
}
