/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import main.LoginBD;

/**
 *
 * @author JUAN MANUEL
 */
public class MetodoLogin {
    
    public int validar_ingreso(){
        ConexionBD cc = new ConexionBD(); //creo clase conxeion base de datos
        Connection cn = cc.getConnection();//creo variable para iniciar la conexion
        PreparedStatement pst = null;
        String usuario = LoginBD.usuario.getText();
        String contraseña =String.valueOf(LoginBD.contraseña.getPassword());
        int resultado=0;
        
        String sql="SELECT * FROM usuarios WHERE nombreUsuario = '"+usuario+"' AND claveUsuario = '"+contraseña+"'";
        
            try {
            
         pst=cn.prepareStatement(sql);
          ResultSet rs = pst.executeQuery();
          
          if(rs.next()){
              resultado =1;
          }
          
              
        
    }catch(SQLException e){
    
}
    
    return resultado;
        
    }
}
    
