package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.BandejaEntrada;
import javax.swing.JOptionPane;
import modelo.Usuario;
import modeloDAO.UsuarioDAO;
import vista.Login;

public class LoginController implements ActionListener {

    private Login vLogin;

    public LoginController(Login vLogin) {
        this.vLogin = vLogin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("ingresar")) {

            String nombre = vLogin.getNombreTf().getText(); //nombre obtenido

            UsuarioDAO uDAO = new UsuarioDAO(); //No modificar

            ArrayList<Usuario> usuarios = null;
            try {
                usuarios = uDAO.getUsuarios();
            } catch (SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            boolean nombreExisteEnBD = false;
            int id = -1;
            for (int i = 0; i < usuarios.size(); i++) {

                if (usuarios.get(i).getNombre().equals(nombre)) {
                    nombreExisteEnBD = true;
                    id = usuarios.get(i).getId_usuario();
                    break;
                }

            }

            if (nombreExisteEnBD) {
                BandejaEntrada bandejaVentana = new BandejaEntrada(id);//sería el Id del usuario logueado
                bandejaVentana.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(vLogin, "Error el usuariono existe en la BD", "ERROR", JOptionPane.ERROR);
            }
        }

    }

}
