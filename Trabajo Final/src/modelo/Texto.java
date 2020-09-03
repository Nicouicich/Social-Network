package modelo;

public  class Texto extends Publicacion {
    
    
    private final static String[] descripciones={" Extrañando mi familia!!","Me voy a jugar al futbol!",
        "Tengo mucho suenio, me voy a ir a dormir.","Espero aprobar programacion!!","Quiero ir a la cordillera!!"};
    private final static int cantDescripciones=5;
    
    
    public Texto(String descripcion, int visibilidad,String clasificacion) {
        super(descripcion, visibilidad,clasificacion);
    }
    
    public static String getDescripciones(int i){
        return descripciones[i];
    }
    public static int getCantDescripciones(){
        return cantDescripciones;
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
