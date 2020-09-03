package modelo;

public class Video extends Publicacion {
    private double duracion;
    private final static String[] descripciones={"Dos perritos jugando con una pelota","Gente entrenando Crossfit ","La corrida de Mar Del Plata",
                                                 "Como programar en java","Aprendiendo a bailar salsa"};
    private final static int cantDescripciones=5;
    private final static double[] duraciones={1.3,2.5,3.1,4.0,2.3};
    private final static int cantidadDuraciones= 5;
    public Video(String descripcion, double duracion, int visibilidad,String clasificacion) {
        super(descripcion, visibilidad,clasificacion);
        this.duracion = duracion;
    }
    
    @Override
    public String toString() {
        String cad="";
        cad+=" duracion: " + duracion ;
        return super.toString() + cad;
    }
    public String getDescripcion() {
        return super.getDescripcion();
    }

    public double getDuracion() {
        return duracion;
    }

    public static String getDescripciones(int i){
        return descripciones[i];
    }
    public static int getCantDescripciones(){
        return cantDescripciones;
    }
    
    public static double getDuraciones(int i){
        return duraciones[i];
    }
    public static int getCantidadDuraciones(){
        return cantidadDuraciones;
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
