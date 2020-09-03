package interfaces;

import modelo.Usuario;

public interface IPublicacion {
    public  String getTipoPublicacion();
    
    public int getVisibilidad();
    public void setVisibilidad(int num);


    public String getDescripcion();

    public boolean estaEtiquetado(Usuario usuario);
    public void añadirLike();

    public int getLikes() ;

    public void añadirComentario( ) ;

    public int getComentarios();

    public void añadirVisto();

    public int getVistos();

    public void añadirEtiqueta();

    public int getEtiquetas();
    
}
