package modelo;

import Util.UtilThread;

import interfaces.IPublicacion;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Observer;
import java.util.Random;

public class Robot extends Usuario implements Runnable {
   
    
    public Robot(String nombre,Observer o) {
        super(nombre);
        this.addObserver(o);
        RedSocial.getInstance().nuevoRobot(this);
    }

    public String getNombre() {
        return super.nombre;
    }
    public Robot getRobot(){
        return this;
    }
    
    public void interactuarConPublicacion(IPublicacion publicacion){
        int i;
        setChanged();
        notifyObservers(this + " esta viendo publicaciones .\n");
        Random r= new Random();
        
        i = r.nextInt(3);
        
        switch (i){
        case 0 : publicacion.añadirLike();
        break;
        case 1: publicacion.añadirVisto();
        break;
        
        }
    }


    @Override
    public void run() {
        
        Random r = new Random();
        int i,t;
        
        //AGREGO AMIGOS
        for (i=0;i<10;i++){
            Usuario usuario= RedSocial.getInstance().getUsuarioAzar();
            System.out.println(usuario);
            if (!super.estaAmigos(usuario) && usuario!=this && solicitudesDeAmistad.contains(usuario)==true){
                System.out.println(this + " envia solicitud de amistad a " +  usuario);
                
                usuario.nuevaSolicitud(this);
            }
            
            UtilThread.espera();
            
        }
        UtilThread.espera();

        for (i=0;i<10;i++){
            
            if (super.solicitudesDeAmistad.size()>0){
                int j= r.nextInt(super.solicitudesDeAmistad.size());
                System.out.println(solicitudesDeAmistad.size() + " " + j);

                Usuario usuario1 = solicitudesDeAmistad.get(j);
                System.out.println(usuario1);
                j=r.nextInt(2);
                if (j==1){//ACEPTO
                    super.responderSolicitud(usuario1, "ACEPTAR");
                }
                else
                    super.responderSolicitud(usuario1, "RECHAZAR");
            }
            UtilThread.espera();

        }
        
        for (t=0;t<10;t++){
           
            
            i = r.nextInt(5);

            switch (i){
            
                case 0: //BUSCANDO USUARIO
                    Usuario usuario= RedSocial.getInstance().getUsuarioAzar();
                    if (super.estaAmigos(usuario)){
                        usuario.nuevaSolicitud(this);
                    }
                break;
                case 1: //RESPONDIENDO SOLICITUDES
                if (super.solicitudesDeAmistad.size()>0){
                    int j= r.nextInt(super.solicitudesDeAmistad.size());
                    Usuario usuario1 = solicitudesDeAmistad.get(j);
                    j=r.nextInt(2);
                    if (j==1){//ACEPTO
                        super.responderSolicitud(usuario1, "ACEPTAR");
                    }
                    else
                        super.responderSolicitud(usuario1, "RECHAZAR");
                }
                break;
                case 2: //CREANDO SUCESO
                    String tipo, nombre, lugar;
                    GregorianCalendar fecha=new GregorianCalendar();
                    int n;
                    n=r.nextInt(Publicacion.getCantLugares());
                    lugar=Publicacion.getLugar(n);
                    n=r.nextInt(3);
                    fecha.set(2019, r.nextInt(12), r.nextInt(28));
                    nombre="Nuevo evento";
                    switch (n){
                    case 0 : tipo="Cumpleanios";
                    break;
                    case 1: tipo="Evento";
                    break;
                    default :tipo="Reunion";
                    break;
                    }
                    
                    super.nuevoSuceso(tipo, nombre, lugar, fecha);
                break;
                
                case 3: //CREANDO GRUPO DE CHAT
                    System.out.println("CREANDO GRUPO DE CHAAAT");
                     int j=r.nextInt(20);
                    super.nuevoGrupo("Nuevo grupo de chat: "+i);
                break;
                case 4: //VIENDO PUBLICACION E INTERACTUANDO
                    IPublicacion publicacion = super.getPublicacionAlAzar();
                    if (publicacion!=null){
                        interactuarConPublicacion(publicacion);
                    }
                    else{
                        setChanged();
                        notifyObservers("No hay publicacion para interactuar\n");
                    }
                break;
                case 5: //CREANDO PUBLICACION
                    publicacion=nuevaPublicacion();
                    UtilThread.espera();
                    RedSocial.getInstance().publicar(this, publicacion);
                    UtilThread.espera();
                    RedSocial.getInstance().terminarPublicacion(this, publicacion);

                }
            UtilThread.espera();
            
            
            
    }     
        
        
        
    }
}
