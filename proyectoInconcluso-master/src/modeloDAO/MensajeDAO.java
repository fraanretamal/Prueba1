
package modeloDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Mensaje;
import modelo.Usuario;

public class MensajeDAO {
    
    Conexion con;
    public MensajeDAO() {
        con = new Conexion();
    }
    
    public ArrayList<Usuario> getMensajes() throws SQLException {

        ArrayList<Mensaje> mensajes = new ArrayList();
        Connection accesoBD = con.getConexion();

        try {
            String sql = "SELECT * FROM mensaje";
            Statement st = accesoBD.createStatement();
            ResultSet resultados = st.executeQuery(sql);

            while (resultados.next()) {
                int id = Integer.parseInt(resultados.getString("id_mensaje"));
                //falta emisor y receptor
                String contenido = resultados.getString("contenido");

                mensajes.add(new Mensaje(id,contenido));
            }
            accesoBD.close();
            return mensajes;
        } catch (Exception e) {
            System.out.println("Error");
            accesoBD.close();
            return null;
        }
    }
    
    
    
    
}
