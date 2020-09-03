package interfaces;

import modelo.Usuario;

public interface IPublicacion {
    public  String getTipoPublicacion();
    
    public int getVisibilidad();
    public void setVisibilidad(int num);


    public String getDescripcion();

    public boolean estaEtiquetado(Usuario usuario);
    public void a�adirLike();

    public int getLikes() ;

    public void a�adirComentario( ) ;

    public int getComentarios();

    public void a�adirVisto();

    public int getVistos();

    public void a�adirEtiqueta();

    public int getEtiquetas();
    
}
