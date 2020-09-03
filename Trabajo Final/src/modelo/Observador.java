package modelo;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Observador implements Observer {
    private Usuario observado;
    private String estado;
    private ArrayList < String> bitacora;
    
    public Observador(Usuario usuario) {
        super();
        observado=usuario;
        usuario.addObserver(this);
        bitacora=new ArrayList <String> ();
    }

    @Override
    public void update(Observable usuario, Object object) {
        // TODO Implement this method
        if (observado!=usuario){
            throw new IllegalArgumentException();
        }
        else{
            bitacora.add((String)object);
            //System.out.println(object);
        }

    }
    public void mostrarBitacora(){
        int i;
        for (i=0;i<bitacora.size();i++){
            System.out.println(bitacora.get(i)+"\n");
        }
    }
}
