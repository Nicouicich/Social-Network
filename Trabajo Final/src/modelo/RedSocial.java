package modelo;

import estados.ComentandoState;

import estados.PublicandoState;

import excepciones.UsuarioInexistenteException;

import interfaces.IPublicacion;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Random;

public class RedSocial {
    private static  RedSocial Instance=null;
    private ArrayList <Usuario> usuarios;
    private ArrayList <IPublicacion> publicaciones;
    private static Humano usuarioHumano;
    
    protected Usuario publicador=null;
    protected boolean publicando=false;
    
    
    private RedSocial() {
        super();
        usuarios=new ArrayList <Usuario>();
        publicaciones= new ArrayList <IPublicacion> ();
    }
    
    public static RedSocial getInstance(){
        if (Instance==null)
            Instance=new RedSocial();
        
        return Instance;
    }
    
    public int getCantUsuarios(){
        return usuarios.size();
    }
    public void nuevoHumano(Humano humano){
        usuarioHumano=humano;
        usuarios.add(humano);
    }
    
    public void nuevoRobot(Robot robot){
        usuarios.add(robot);
    }
    
    public void eliminaRobot(Robot robot){
        int i;
        if (usuarios.contains(robot)){
            for (i=0;i<usuarios.size();i++)
                if (usuarios.get(i)==robot)
                    usuarios.remove(i);
        }
    }
    
    public void nuevaPublicacionNivel1 (IPublicacion publicacion){
        
        this.publicaciones.add(publicacion);
    }
    
    public void mostrarPublicaciones(){
        int i;
        
        for (i=0;i<publicaciones.size();i++)
            System.out.println(publicaciones.get(i) +" \n");
    }
    
    public void mostrarUsuarios(){
        int i;
        for (i=0;i<usuarios.size();i++){
            System.out.println(usuarios.get(i) + "\n");
        }
    }
    
    public Usuario getUsuario (String nombre) throws UsuarioInexistenteException{
        int i=0;
        Usuario usuario =null;
        while(i<usuarios.size()){
            if (usuarios.get(i).getNombre().equalsIgnoreCase(nombre))
                usuario= usuarios.get(i);
            i++;
        }
        if (usuario==null)
            throw new UsuarioInexistenteException();
        return usuario;
    }
    
    
    
    public synchronized void publicar(Usuario usuario,IPublicacion publicacion){
        
        System.out.println("@"+usuario+ " intenta publicar una " + publicacion.getTipoPublicacion() + "\n");
        while (publicando== true){
            try{
              
                System.out.println(" Recurso ocupado, " +"@"+usuario+ " espera.");

                wait();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            
        }
        
        System.out.println("@ "+usuario+ " esta publicando " + publicacion.getTipoPublicacion()+ "\n");
        this.publicador=usuario;
        this.publicando=true;
        usuario.setEstado(new PublicandoState(usuario));

        notifyAll();
    }
    
    public synchronized void terminarPublicacion(Usuario usuario,IPublicacion publicacion){

        while (publicando==true && publicador!=usuario){
            try{
                
                System.out.println("Recurso ocupado, " +"@"+usuario+ " espera.");

                wait();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            
        }
        publicando=false;
        
        System.out.println("@"+usuario+ " finalizo la publicacion " + publicacion.getTipoPublicacion()+ "\n");
        publicador=null;
        usuario.publicaciones.add(publicacion);

        RedSocial.getInstance().nuevaPublicacionNivel1(publicacion);
        
        notifyAll();
    }
    
    
    public synchronized void comentar(Usuario publicador,Usuario comentador,Publicacion publicacion){
        //setChanged();
        //notifyObservers("@"+this+ "intenta comentar una publicacion de  " + usuario+ "\n");
        System.out.println("@"+comentador+ "intenta comentar una publicacion de  " + publicador+ "\n");

        while (publicando==true){
            try{
                //setChanged();
                //notifyObservers("Recurso ocupado, " +"@"+this+ "espera.");
                System.out.println("Recurso ocupado, " +"@"+comentador+ "espera.");

                wait();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            
        }
        publicando=true;
        comentador.setEstado(new ComentandoState(comentador));
        System.out.println("@"+comentador + " esta comentando en la publicacion de " +publicador +":"+ publicacion.getTipoPublicacion()+ "\n");
        this.publicador=comentador;
        notifyAll();
    }
    
    public synchronized void finalizarComentario(Usuario publicador,Usuario comentador,Publicacion publicacion){
        
        
        while (publicando==true && this.publicador!=comentador){
            try{
                System.out.println("@"+this+ "intenta comentar una publicacion de  " + publicador+ "\n");
                
                wait();
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
            
        }
        publicando=false;
        System.out.println("@"+this+ "finalizo el comentario en la publicacion de" + publicacion.toString()+ "\n");
        publicador=null;
        publicacion.comentarios.add("FRASE ALEATORIA");

        notifyAll();
    }
    
    public Usuario buscarUsuario(String nombre){
        int i=0;
        Usuario usuario=null;
 
            while (i<usuarios.size() && usuarios.get(i).getNombre()!=nombre){
                i++;
            }
            if (i<usuarios.size()){
                if (usuarios.get(i).getNombre().equalsIgnoreCase(nombre))
                    usuario= usuarios.get(i);
            }
            return usuario;
    }
    
    public void setPublicador(Usuario p) {
        publicador = p;
    }

    public Usuario getPublicador() {
        return publicador;
    }

    public void setPublicando(boolean p) {
        this.publicando = p;
    }

    public boolean isPublicando() {
        return publicando;
    }    
    
    public Usuario getUsuarioAzar(){
        Random r = new Random();
        int i= r.nextInt(usuarios.size());
        return usuarios.get(i);
        
    }
    public IPublicacion getPublicacionAzar(){
        Random r = new Random();
        if(publicaciones.size()!=0){
            int i= r.nextInt(publicaciones.size());
            return publicaciones.get(i);
        }
        else
            return null;
        
    }

    public ArrayList<IPublicacion> getPublicaciones() {
        return publicaciones;
    }
}
