package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.HashMap;

import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import modelo.Humano;
import modelo.Publicacion;
import modelo.RedSocial;
import modelo.Usuario;

import vista.VentanaInteraccion;
import vista.VentanaMenuRedSocial;

public class VentanaInteraccionController implements ActionListener{
    
    private Humano h;
    private HashMap<String,Usuario> lista;
    private DefaultListModel<Publicacion> lp1;
    private VentanaInteraccion vin;

    public VentanaInteraccionController(Humano humano, HashMap<String, Usuario> lista) {
        this.h=humano;
        this.lista=lista;
        this.vin=new VentanaInteraccion(h);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand().toUpperCase()){
        case "DETALLE": 
            
            break;
        case "ACTUALIZA":
            Iterator it= RedSocial.getInstance().getPublicaciones().iterator();
            while(it.hasNext()){
                Publicacion p=(Publicacion)it.next();
                if (p.getVisibilidad()==1){
                    this.lp1.addElement(p);
                }else{
                    if (p.getVisibilidad()==2){
                        this.lp1.addElement(p);
                    }
                }
                this.vin.actualizaListas(lp1);
            }
        
        }
        System.out.println(e.getActionCommand());
    }
}
