package modelo;

import java.lang.reflect.Array;

public class Foto extends Publicacion {
    private String lugar, resolucion;
    private final static String[] descripciones={" Festejando mi cumple con @Jose, @Carolina, y @Pablo","Aca nos encontramos con @Juan y @Lucas estudiando para los parciales",
        "Una fotito del finde con toda la familia","Una foto de mi perro para todos mis seguidores!!","El paisaje mas hermoso!"};
    private final static int cantDescripciones=5;

    public Foto(String descripcion, String lugar, String resolucion, int visibilidad,String clasificacion) {
        super(descripcion, visibilidad,clasificacion);
        this.lugar = lugar;
        this.resolucion = resolucion;
        
    }
    public static int getCantDescripciones(){
        return cantDescripciones;
    }
    @Override
    public String toString() {
        String cad="";
        cad+=" lugar: " + lugar + " resolucion: "+resolucion;
        return super.toString() + cad;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getLugar() {
        return lugar;
    }

    public String getResolucion() {
        return resolucion;
    }
    public static String getDescripciones(int i){
        return descripciones[i];
    }

    @Override
    public void añadirVisto() {
        // TODO Implement this method
    }

    @Override
    public int getVistos() {
        // TODO Implement this method
        return 0;
    }
}
