package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;

import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import javax.swing.ListModel;

import modelo.Humano;
import modelo.RedSocial;

import modelo.Robot;
import modelo.Usuario;

import vista.Ventana;
import vista.VentanaInteraccion;
import vista.VentanaMenuRedSocial;

public class VentanaController implements ActionListener,Observer{
    private RedSocial rd;
    private Ventana v;
    private Humano h;
    private HashMap<String,Usuario> lista;
    public VentanaController() {
        super();
        this.lista = new HashMap<String, Usuario>();
        this.v=new Ventana(this);
    }


    public void setRd(RedSocial rd) {
        this.rd = rd;
    }

    public RedSocial getRd() {
        return rd;
    }

    public void setV(Ventana v) {
        this.v = v;
    }

    public Ventana getV() {
        return v;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand().toUpperCase()){
        case "CREAR RED SOCIAL": 
            this.rd=RedSocial.getInstance();
            this.v.redSocialCreada();
            break;
        case "VER RED SOCIAL": 
                
                new VentanaMenuRedSocialController(this.h,lista);
                
            
            break;
        case "CREAR HUMANO": 
            this.h= Humano.getInstance(this);
            this.lista.put(h.getNombre(), h);
            this.v.actualizaListas(this.lista.values().iterator());
            this.v.getCHumano().setEnabled(false);
            break;
        case "CREAR ROBOT":
            String nombre=JOptionPane.showInputDialog(this.v,"Ingrese nombre robot");
            Robot r1=new Robot(nombre,this);
            this.lista.put(nombre, r1);
            this.v.actualizaListas(this.lista.values().iterator());
            Thread t=new Thread(r1);
            t.start();
        }
        System.out.println(e.getActionCommand());
    }

    @Override
    public void update(Observable observable, Object object) {
        if (!lista.containsValue(observable) || this.h!=observable)
            throw new IllegalArgumentException();
        String mensaje= (String)object;
        this.v.agregarMensaje(mensaje);
    }
}
