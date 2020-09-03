package opcional;

import java.util.GregorianCalendar;


public class Evento extends Sucesos {
    public Evento() {
        super();
    }

    public Evento(String nombre, String lugar, GregorianCalendar fecha) {
        // TODO Implement this method
        super(nombre, lugar, fecha);
    }
    @Override
    public String toString() {
        // TODO Implement this method
        return super.toString()+ "un evento " ;
    }
}
