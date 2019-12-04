
package conexion;

import java.sql.Connection; //conectamos la base
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class ConexionBD {
    
    Connection conectar = null;
    public ConexionBD(){
        try{ 
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://localhost/proyecto_final","root","");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    
    
    public Connection  getConnection(){
        return conectar;
    }
    
    
    public void desconectar (){
        conectar = null;
    }
}
