
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTextArea;
import modelo.Mensaje;
import modeloDAO.MensajeDAO;
import vista.NuevoMensaje;

public class MensajeController implements ActionListener {
   
    private NuevoMensaje Nmsj;
 
    
    public MensajeController(NuevoMensaje Nmsj) {
        this.Nmsj = Nmsj;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MensajeDAO mensjDAO = new MensajeDAO();  
    }
    
     public void cargarMensajes(){
        MensajeDAO mensjDAO = new MensajeDAO();
        ArrayList<Mensaje> mensajes = new ArrayList<>();
        
        try{
            mensajes = mensjDAO.getMensajes(); 
            JTextArea cuerpoMensajeTA = Nmsj.getCuerpoMensajeTA();
        
            mensajes.removeAllItems();
            for (int i = 0; i < mensajes.size(); i++) {
 
                cuerpoMensajeTA.add(Nmsj);
            }

            Nmsj.setCuerpoMensajeTA(cuerpoMensajeTA);
        }catch(Exception e){
            System.out.println("Hubo un error al cargar los mensajes");
        }
        
        
        
        
    }
}
