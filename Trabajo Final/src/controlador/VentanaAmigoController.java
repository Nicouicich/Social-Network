package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.HashMap;

import javax.swing.JOptionPane;

import modelo.Humano;
import modelo.RedSocial;
import modelo.Robot;
import modelo.Usuario;

import vista.VentanaAmigos;

public class VentanaAmigoController implements ActionListener{
    private Humano h;
    private HashMap<String,Usuario> lista;
    private VentanaAmigos va;
    

    VentanaAmigoController(Humano humano, HashMap<String, Usuario> usuario) {
        this.va=new VentanaAmigos(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand().toUpperCase()){
        case "AGREGAR AMIGO": 
            if(RedSocial.getInstance().buscarUsuario(this.va.getJtfagrego().getText())==null)
                JOptionPane.showMessageDialog(this.va, "existe");
            else
                JOptionPane.showMessageDialog(this.va, "no existe usuario");
            break;
        case "ELIMINAR AMIGO": 
                
                new VentanaMenuRedSocialController(this.h,lista);
                
            
            break;
        
        }
        System.out.println(e.getActionCommand());
    }
}
