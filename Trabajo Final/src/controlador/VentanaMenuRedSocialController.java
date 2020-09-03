package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

import javax.swing.JOptionPane;

import modelo.Humano;

import modelo.PatronFactoryPublicaciones;
import modelo.RedSocial;
import modelo.Robot;
import modelo.Usuario;

import vista.VentanaMenuRedSocial;

public class VentanaMenuRedSocialController implements ActionListener{
    
    private VentanaMenuRedSocial vmrs;
    private Humano h;
    private HashMap<String,Usuario> lista;
    
    public VentanaMenuRedSocialController(Humano h, HashMap lista) {
        this.h=h;
        this.lista=lista;
        this.vmrs=new VentanaMenuRedSocial(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand().toUpperCase()){
        case "VER PUBLICACIONES": 
            new VentanaInteraccionController(this.h,this.lista);
            break;
        case "VIDEO": 
                this.vmrs.getJtfdur().setEditable(true);
                this.vmrs.getJtflugar().setEditable(false);
                
            
            break;
        case "TEXTO": 
            
            this.vmrs.getJtfdur().setEditable(false);
            this.vmrs.getJtflugar().setEditable(false);
            
            break;
        case "FOTO":
            this.vmrs.getJtfdur().setEditable(true);
            this.vmrs.getJtflugar().setEditable(true);
            break;
        case "CREAR PUBLICACION":
            this.h.nuevaPublicacion(this.vmrs.getBg2().getSelection().getActionCommand(),
                                    this.vmrs.getBg1().getSelection().getActionCommand(),
                                    this.vmrs.getJtfdescripcion().getText(), this.vmrs.getJtfres().getText(),
                                    this.vmrs.getJtflugar().getText(),
                                    new Double(this.vmrs.getJtfdur().getText()), new Integer(this.vmrs.getJtfvisibilidad().getText()));
            if (new Integer(this.vmrs.getJtfvisibilidad().getText())==1){
                RedSocial.getInstance().nuevaPublicacionNivel1(PatronFactoryPublicaciones.getPublicacion(this.vmrs.getBg2().getSelection().getActionCommand(),
                                    this.vmrs.getBg1().getSelection().getActionCommand(),
                                    this.vmrs.getJtfdescripcion().getText(), this.vmrs.getJtfres().getText(),
                                    this.vmrs.getJtflugar().getText(),
                                    new Double(this.vmrs.getJtfdur().getText()), new Integer(this.vmrs.getJtfvisibilidad().getText())));
            }
            break;
        case "GESTION AMIGOS":
            new VentanaAmigoController(this.h,this.lista);
            break;
        case "CREAR SUCESO":
            DateFormat df = new SimpleDateFormat("dd MM yyyy");
            Date date;
            try {
                date = df.parse(this.vmrs
                                    .getJtfFechaSuceso()
                                    .getText());
            } catch (ParseException f) {
                throw new InternalError();
            }
            Calendar cal = new GregorianCalendar();
            cal.setTime(date);
            this.h.nuevoSuceso(this.vmrs.getBg3().getSelection().getActionCommand(),
                               this.vmrs.getJtfNomSuceso().getText(),
                               this.vmrs.getJtfLugarSuceso().getText(), (GregorianCalendar)cal);
        }
        System.out.println(e.getActionCommand());
    }
}
