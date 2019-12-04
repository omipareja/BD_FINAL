/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classDAO;

import classVO.concesionarioVO;
import classVO.marcaVO;
import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author JUAN MANUEL
 */
public class concesionarioDAO {
    
    
    //registrar
    
      public static String registrarconcesionarios(concesionarioVO concesionario) { //clase que permite hacer las 4 operaciones en las tablas
        String result = null, last = null;
        ConexionBD cc = new ConexionBD(); //creo clase conxeion base de datos
        Connection cn = cc.getConnection();//creo variable para iniciar la conexion
        PreparedStatement pst = null;  // sirve para hacer los llamados de la base
   
        String sql ="INSERT INTO concesionario values(?,?,?)";//sirve para hacer la consulta a la base si hubiera un valor decremental le pondria un null
        try{
            pst=cn.prepareStatement(sql);
            pst.setInt(1,concesionario.getId_concesionario() );//aca ponemos el objeto del campo con "?" que queremos rellenar
            pst.setString(2,concesionario.getDireccion_concesionario());
            pst.setString(3,concesionario.getNombre_concesionario());
            pst.execute();
            pst= cn.prepareStatement("SELECT MAX(id_concesionario) AS ID FROM  concesionario");
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                last=rs.getString(1);
                
            }
            
            result = "concesionario registrado con exito, ID"+last;
            
            
            
        }catch(SQLException e){
            
            result = "ERROR en la consulta"+e.getMessage();
            
        }finally{
            try{
                if (cn != null){
                    cn.close();
                    pst.close();
            }
        }catch(Exception e){
                result = "Error"+e;
                
                }
            
        }
    return result;
    
    }
      
      
      //actualizar 
      
         public static String actualizarconcesionarios(concesionarioVO concesionario) { //clase que permite hacer las 4 operaciones en las tablas
        String result = null, last = null;
        ConexionBD cc = new ConexionBD(); //creo clase conxeion base de datos
        Connection cn = cc.getConnection();//creo variable para iniciar la conexion
        PreparedStatement pst = null;  // sirve para hacer los llamados de la base
   
        String sql ="UPDATE concesionario SET  direccion_concesionario=?, nombre_concesionario=? WHERE id_concesionario=?";//sirve para hacer la consulta a la base si hubiera un valor decremental le pondria un null
        try{
            pst=cn.prepareStatement(sql);
           //aca ponemos el objeto del campo con "?" que queremos rellenar
            pst.setString(1,concesionario.getDireccion_concesionario());
            pst.setString(2,concesionario.getNombre_concesionario());
            pst.setInt(3,concesionario.getId_concesionario() );
           
            
            pst.execute();
            pst= cn.prepareStatement("SELECT MAX(id_concesionario) AS ID FROM  concesionario");
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                last=rs.getString(1);
                
            }
            
            result = "concesionario actualizado con exito, ID"+last;
            
            
            
        }catch(SQLException e){
            
            result = "ERROR en la consulta"+e.getMessage();
            
        }finally{
            try{
                if (cn != null){
                    cn.close();
                    pst.close();
            }
        }catch(Exception e){
                result = "Error"+e;
                
                }
            
        }
    return result;
    
    }
         
         
 //buscar
         
         
         

         public static concesionarioVO buscarconcesionarios(String clave) { //clase que permite hacer las 4 operaciones en las tablas
        concesionarioVO concesionario = new concesionarioVO();
        ConexionBD cc = new ConexionBD(); //creo clase conxeion base de datos
        Connection cn = cc.getConnection();//creo variable para iniciar la conexion
        PreparedStatement pst = null;  // sirve para hacer los llamados de la base
   
        String sql ="SELECT * FROM concesionario WHERE  id_concesionario=?";//sirve para hacer la consulta a la base si hubiera un valor decremental le pondria un null
        try{
            pst=cn.prepareStatement(sql);
            pst.setString(1, clave);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
              concesionario.setId_concesionario(Integer.parseInt(rs.getString(1)));
              concesionario.setDireccion_concesionario(rs.getString(2));
              concesionario.setNombre_concesionario(rs.getString(3));
            }
            
             concesionario.setResultado( "Busqueda Exitoso");
            
            
            
        }catch(SQLException e){
            
            concesionario.setResultado( "ERROR en la consulta"+e.getMessage());
            
        }finally{
            try{
                if (cn != null){
                    cn.close();
                    pst.close();
            }
        }catch(Exception e){
               concesionario.setResultado(  "Error"+e);
                
                }
            
        }
    return concesionario;
    
    }         
      
      
    //eliminar___________________________________________________-
    
         
      public static String eliminarconcesionarios(String clave) { //clase que permite hacer las 4 operaciones en las tablas
        String result = null;
        ConexionBD cc = new ConexionBD(); //creo clase conxeion base de datos
        Connection cn = cc.getConnection();//creo variable para iniciar la conexion
        PreparedStatement pst = null;  // sirve para hacer los llamados de la base
   
        String sql ="DELETE FROM concesionario WHERE  id_concesionario=?";//sirve para hacer la consulta a la base si hubiera un valor decremental le pondria un null
        try{
            pst=cn.prepareStatement(sql);
            pst.setString(1, clave);
           pst.executeUpdate();
            result= "concesionario eliminado con exito";
            
            
            
            
            
        }catch(SQLException e){
            
          result=( "ERROR en la consulta"+e.getMessage());
            
        }finally{
            try{
                if (cn != null){
                    cn.close();
                    pst.close();
            }
        }catch(Exception e){
              result=(  "Error"+e);
                
                }
            
        }
    return result;
    
    }         
      
      
public static ArrayList<concesionarioVO>getListconcesionario(){
     
     ArrayList<concesionarioVO> arrconcesionario = new ArrayList<concesionarioVO>();
      ConexionBD cc = new ConexionBD(); //creo clase conxeion base de datos
        Connection cn = cc.getConnection();//creo variable para iniciar la conexion
        PreparedStatement pst = null;  // sirve para hacer los llamados de la base
        concesionarioVO concesionario =null;
        String sql ="SELECT * FROM  concesionario";//sirve para hacer la consulta a la base si hubiera un valor decremental le pondria un null
        try{
            pst=cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            
             while(rs.next()){
              concesionario = new concesionarioVO();
              concesionario.setId_concesionario(Integer.parseInt(rs.getString(1)));
              concesionario.setNombre_concesionario(rs.getString(2));
              if(arrconcesionario.isEmpty()){
                  arrconcesionario.add(0,concesionario);
              }else{ 
                  arrconcesionario.add(concesionario);
                  
            }
             }
           
            
            
            
        }catch(SQLException e){
            
           JOptionPane.showMessageDialog(null,"ERROR en la consulta"+e.getMessage());
            
        }finally{
            try{
                if (cn != null){
                    cn.close();
                    pst.close();
            }
        }catch(Exception e){
               JOptionPane.showMessageDialog( null, "Error"+e);
                
                }
            
        }
    return arrconcesionario;
    
    }         
     
             
public static ArrayList<concesionarioVO>llenarTabla(){
    ArrayList<concesionarioVO> arrconce = new ArrayList<concesionarioVO>();
      ConexionBD cc = new ConexionBD(); //creo clase conxeion base de datos
        Connection cn = cc.getConnection();//creo variable para iniciar la conexion
        PreparedStatement pst = null;  // sirve para hacer los llamados de la bas
        concesionarioVO concesionario = null;
        String sql ="SELECT * FROM  concesionario";
        
          try{
            pst=cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
              concesionario  = new concesionarioVO();
              concesionario.setId_concesionario(Integer.parseInt(rs.getString(1)));
              concesionario.setDireccion_concesionario(rs.getString(2));
              concesionario.setNombre_concesionario(rs.getString(3));
              arrconce.add(concesionario);
            }
            
     
        }catch(SQLException e){
            
           JOptionPane.showMessageDialog(null,"ERROR en la consulta"+e.getMessage());
            
        }finally{
            try{
                if (cn != null){
                    cn.close();
                    pst.close();
            }
        }catch(Exception e){
                JOptionPane.showMessageDialog(null,  "Error"+e);
                
                }
            
        }
    return arrconce;

}

         
}     
         

