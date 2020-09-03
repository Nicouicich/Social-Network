package modelo;

import estados.BuscandoAmigos;
import estados.CreandoPublicacionState;


import estados.InteractuandoPublicacionState;
import estados.UsuarioCreadoState;

import interfaces.IPublicacion;

import interfaces.State;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Observable;

import java.util.Observer;
import java.util.Random;

import opcional.GrupoDeChat;
import opcional.PatronFactorySucesos;
import opcional.Sucesos;


public abstract class Usuario extends Observable {
    protected String nombre;
    public ArrayList<Usuario> amigos,solicitudesDeAmistad,sugerencias;
    protected ArrayList <IPublicacion> publicaciones;
    protected ArrayList <GrupoDeChat> ArrayGrupos;
    protected ArrayList <Sucesos> listaEventos;
    protected State estado;
    

    public Usuario(String nombre) {
        super();
        this.nombre=nombre;
        amigos=new  ArrayList<Usuario> ();
        solicitudesDeAmistad = new  ArrayList<Usuario> ();
        publicaciones=new ArrayList <IPublicacion> ();
        sugerencias = new  ArrayList<Usuario> ();
        listaEventos= new ArrayList <Sucesos> ();
        estado= new UsuarioCreadoState(this);
        ArrayGrupos= new ArrayList<GrupoDeChat>();
        
    }
    
    public void nuevoSuceso(String tipo,String nombre,String lugar,GregorianCalendar fecha){
        Sucesos suceso= PatronFactorySucesos.getSuceso(tipo, nombre, lugar, fecha);
        if (suceso!=null){
            listaEventos.add(suceso);
            for (int n=0;n<amigos.size();n++){
                suceso.nuevoIntegrante(amigos.get(n));
                
            }
        }
    }
    
    
    
    public void nuevaSolicitud (Usuario usuario){
        if (usuario.solicitudesDeAmistad.contains(usuario)==false && usuario.amigos.contains(this.getNombre())==false){
            
            usuario.solicitudesDeAmistad.add(this);
            System.out.println("Nueva solicitud de amistad entre:" + usuario + " y " + this);
        }
        
    }
    
    public IPublicacion nuevaPublicacion(){
        //String tipo,String descripcion,double resolucion, String lugar,double duracion,int visibilidad
        IPublicacion publicacion =null;
        Random r= new Random();
        int i=r.nextInt(2);
        int j=r.nextInt(2);
    
    
        String clasificacion,tipo,descripcion,resolucion, lugar;
        double duracion;
        int visibilidad;
        
        if (j==1){
            clasificacion="COMERCIAL";
        }
        else
            clasificacion="SOCIAL";
        
        visibilidad=(int) (Math.random() * 3) + 1;
        switch(i){
        
        
        case 0:tipo ="FOTO"; 
            j=r.nextInt(Foto.getCantDescripciones());
            descripcion=Foto.getDescripciones(j);
            
            resolucion="1920 x 1080";
            duracion=0;
            
            j=r.nextInt(Publicacion.getCantLugares());
            lugar=Publicacion.getLugar(j);
        break;
        case 1: tipo="VIDEO";
            resolucion=null;   
            j=r.nextInt(Video.getCantDescripciones());
            descripcion=Video.getDescripciones(j);
            
            j=r.nextInt(Video.getCantidadDuraciones());
            duracion=Video.getDuraciones(j);
            
            j=r.nextInt(Publicacion.getCantLugares());
            lugar=Publicacion.getLugar(j);
            
        break;
        
        default:tipo="TEXTO";
            resolucion=null;
            duracion=0;
            lugar=null;
            
            j=r.nextInt(Texto.getCantDescripciones());
            descripcion=Texto.getDescripciones(j);
            
        break;
        }
        
        publicacion = PatronFactoryPublicaciones.getPublicacion(clasificacion,tipo,descripcion, resolucion, lugar, duracion, visibilidad);

        estado= new CreandoPublicacionState(this);
        return publicacion;
    }
    
    public void responderSolicitud(Usuario usuario,String respuesta){
        setChanged();
        notifyObservers(this + " esta respondiendo una solicitud de amistad.\n");
        System.out.println("A VER SI ESTA EN MIS AMIGOS : "+this.amigos.contains(usuario));
        if (!this.amigos.contains(usuario)){
            if (respuesta.equalsIgnoreCase("ACEPTAR")){
                System.out.println("SE ACEPTO UNA SOLICITUD\n ");
                usuario.amigos.add( this); //me agrego como amigo en el otro robot
                
                this.amigos.add(usuario); //agrego al robot como amigo y dsps lo elimino de las solicitudes
                System.out.println(this + "Ahora es amigo de: " + usuario + "\n");

                agregarSugerencias(usuario);
                setChanged();
                notifyObservers(this + " acepto la solicitud de amistad de "+ usuario+".\n");
            }
            else{
                setChanged();
                notifyObservers(this + " rechazo la solicitud de amistad de "+ usuario+".\n");
            }

            this.solicitudesDeAmistad.remove(usuario);

        }
    }
    public void agregarSugerencias(Usuario usuario){
        int i;
        System.out.println("CANTIDAD AMIGOS:" +usuario.amigos.size());
        for (i=0;i<usuario.amigos.size();i++){
            if (usuario.amigos.get(i)!=this)
                usuario.amigos.get(i).sugerencias.add( this);

        }
        
        
        for (i=0;i<amigos.size();i++){
            if(amigos.get(i)!=usuario)
                amigos.get(i).sugerencias.add( usuario);        
        }
    }

    
    
    
    
    public void nuevoGrupo(String nombre)  {
        GrupoDeChat chat = new GrupoDeChat(nombre);
        chat.nuevoUsuarioJefe(this);
        ArrayGrupos.add(chat);
        setChanged();
        notifyObservers(this + " creo un nuevo grupo privado de chat.\n");
        Random r= new Random();
        for (int i=0;i<amigos.size();i++){
            int j=r.nextInt(2);
            if (j==1){
                chat.nuevoUsuario(amigos.get(i));
            }
        }
    }
    
  
 
  public IPublicacion mostrarPublicacionAAmigo(Usuario usuario){
        int i;
        Random r = new Random();
        if (publicaciones.size()!=0){
            i= r.nextInt(publicaciones.size());
    
            return publicaciones.get(i);
        }
        else
            return null;
    }
    
    public void mostrarPublicaciones(){
        int i;
        for (i=0;i<publicaciones.size();i++){
                System.out.println(this.publicaciones.get(i));
        }
        
    }

     
    /*public void buscarUsuarios(String nombre){
        estado= new BuscandoAmigos(this);
        RedSocial.getInstance().buscarUsuario(nombre);
        if (!estaAmigos(nombre))
            
    }
    */
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    
    }

    public void setEstado(State estado) {
        this.estado = estado;
    }

    public State getEstado() {
        return estado;
    }

    public String getNombre() {
        return nombre;
    }


    @Override
    public String toString() {
        return this.nombre;
    }
    
    public boolean estaAmigos(Usuario usuario){
        return amigos.contains(usuario);
    }

    public IPublicacion getPublicacionAlAzar (){
        int i;
        estado= new InteractuandoPublicacionState(this);
        IPublicacion p;

            p=RedSocial.getInstance().getPublicacionAzar();
    
        if (p==null){
            i=0;
            while(i<amigos.size() && p==null){
                p=amigos.get(i).mostrarPublicacionAAmigo(this);
                i++;
            }
        }
        
        return p;

    }
    
    public void mostrarSolicitudes(){
        int i;
        System.out.println("Cantidad de solicitudes: "+solicitudesDeAmistad.size());
        for (i=0;i<solicitudesDeAmistad.size();i++){
            System.out.println(solicitudesDeAmistad.get(i) +  " aaa\n");
        }
    }
    
    public void mostrarAmigos(){
        int i;
        System.out.println("AMIGOS:  " + amigos.size());
        for (i=0;i<amigos.size();i++){
            System.out.println(amigos.get(i) + "\n");
        }
    }

    public void notifica(String string) {
        System.out.println(string);
    }
}
