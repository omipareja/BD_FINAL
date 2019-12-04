/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classDAO;

import classVO.marcaVO;
import classVO.modeloVO;
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
public class modeloDAO {
    
        //INSERTAR---------------------------------------------------------------------------------------
    public static String registrarmodelos(modeloVO modelo) { //clase que permite hacer las 4 operaciones en las tablas
        String result = null, last = null;
        ConexionBD cc = new ConexionBD(); //creo clase conxeion base de datos
        Connection cn = cc.getConnection();//creo variable para iniciar la conexion
        PreparedStatement pst = null;  // sirve para hacer los llamados de la base
   
        String sql ="INSERT INTO modelo values(?,?,?,?)";//sirve para hacer la consulta a la base si hubiera un valor decremental le pondria un null
        try{
            pst=cn.prepareStatement(sql);
            pst.setInt(1,modelo.getId_modelo() );//aca ponemos el objeto del campo con "?" que queremos rellenar
            pst.setInt(2,modelo.getId_marca() );
            pst.setString(3,modelo.getCaballos_fuerza());
            pst.setString(4, modelo.getNombre_modelo());
            pst.execute();
            pst= cn.prepareStatement("SELECT MAX(id_modelo) AS ID FROM  modelo");
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                last=rs.getString(1);
                
            }
            
            result = "modelo registrado con exito, ID"+last;
            
            
            
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
    
    
    //ACTUALIZAR----------------------------------------------------------------------------------------------
        
        
     public static String actualizarmodelos(modeloVO modelo) { //clase que permite hacer las 4 operaciones en las tablas
        String result = null, last = null;
        ConexionBD cc = new ConexionBD(); //creo clase conxeion base de datos
        Connection cn = cc.getConnection();//creo variable para iniciar la conexion
        PreparedStatement pst = null;  // sirve para hacer los llamados de la base
   
        String sql ="UPDATE modelo SET id_marca=?,caballos_fuerzaModelo=?,nombre_modelo=? WHERE id_modelo = ? ";//sirve para hacer la consulta a la base si hubiera un valor decremental le pondria un null
        try{
            pst=cn.prepareStatement(sql);
          //aca ponemos el objeto del campo con "?" que queremos rellenar
            pst.setInt(1,modelo.getId_marca() );
            pst.setString(2,modelo.getCaballos_fuerza());
            pst.setString(3, modelo.getNombre_modelo());
              pst.setInt(4,modelo.getId_modelo());
            pst.execute();
            pst= cn.prepareStatement("SELECT modelo(id_modelo) AS ID FROM  modelo");
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                last=rs.getString(1);
                
            }
            
            result = "modelo actualizada con exito, ID"+ modelo.getId_modelo() ;
            
            
            
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
     
     
     
//buscar____________________________________________________
    
     
        public static modeloVO buscarmodelos(String clave) { //clase que permite hacer las 4 operaciones en las tablas
        modeloVO modelo = new  modeloVO();   
        ConexionBD cc = new ConexionBD(); //creo clase conxeion base de datos
        Connection cn = cc.getConnection();//creo variable para iniciar la conexion
        PreparedStatement pst = null;  // sirve para hacer los llamados de la base
   
        String sql ="SELECT * FROM modelo WHERE id_modelo =? ";//sirve para hacer la consulta a la base si hubiera un valor decremental le pondria un null
        try{
            pst=cn.prepareStatement(sql);
            pst.setString(1, clave);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()){
                modelo.setId_modelo((Integer.parseInt(rs.getString(1))));//esto me obtiene todos los ID de la base
                modelo.setId_marca((rs.getInt(2)));
                modelo.setCaballos_fuerza((rs.getString(3)));
                modelo.setNombre_modelo(rs.getString(4));
            }
            
            modelo.setResultado ("Busqueda exitosa") ;
            
            
            
        }catch(SQLException e){
            
            modelo.setResultado ( "ERROR en la consulta"+e.getMessage());
            
        }finally{
            try{
                if (cn != null){
                    cn.close();
                    pst.close();
            }
        }catch(Exception e){
                modelo.setResultado("Error"+e);
                
                }
            
        }
    return modelo;
    
    
    
    
    
}
        
        //eliminar
        
 public static String eliminarmodelos(String clave) { //clase que permite hacer las 4 operaciones en las tablas
        String result = null;
        ConexionBD cc = new ConexionBD(); //creo clase conxeion base de datos
        Connection cn = cc.getConnection();//creo variable para iniciar la conexion
        PreparedStatement pst = null; 
   
        String sql ="DELETE FROM modelo where id_modelo=?";//sirve para hacer la consulta a la base si hubiera un valor decremental le pondria un null
        try{
            pst=cn.prepareStatement(sql);
            pst.setString(1, clave);
            pst.executeUpdate();
            result = "Modelo eliminado con exito";
      
            
            
        }catch(SQLException e){
            
         result = "error en la consulta" + e.getMessage();
        }finally{
            try{
                if (cn != null){
                    cn.close();
                    pst.close();
            }
        }catch(Exception e){
               result="Error"+e;
                
                }
            
        }
    return result;
    
    
    
    
    
}        
        
    
 public static ArrayList<modeloVO>getListmodelo(){
     
     ArrayList<modeloVO> arrmodelo = new ArrayList<modeloVO>();
     //se copia la esctrutura buscar desde conexion
     
        ConexionBD cc = new ConexionBD(); //creo clase conxeion base de datos
        Connection cn = cc.getConnection();//creo variable para iniciar la conexion
        PreparedStatement pst = null;  // sirve para hacer los llamados de la base
        modeloVO modelo =null;
   
        String sql ="SELECT * FROM modelo ";//sirve para hacer la consulta a la base si hubiera un valor decremental le pondria un null
        try{
            pst=cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()){
                modelo = new modeloVO();
                modelo.setId_modelo(Integer.parseInt(rs.getString(1)));//esto me obtiene todos los ID de la base
                modelo.setId_modelo(Integer.parseInt(rs.getString(1)));
               if(arrmodelo.isEmpty()){
                   arrmodelo.add(0,modelo);
               }else{
                   arrmodelo.add(modelo);
                   
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
               JOptionPane.showMessageDialog(null,"Error"+e);
                
                }
            
        }
    return arrmodelo;
    
    
    
    
    
}
 
  public static ArrayList<modeloVO>llenarmodelo(){
    ArrayList<modeloVO> arrmodelo = new ArrayList<modeloVO>();
      ConexionBD cc = new ConexionBD(); //creo clase conxeion base de datos
        Connection cn = cc.getConnection();//creo variable para iniciar la conexion
        PreparedStatement pst = null;  // sirve para hacer los llamados de la bas
        modeloVO modelo = null;
        String sql ="SELECT * FROM modelo";
        
          try{
            pst=cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
              modelo  = new modeloVO();
              modelo.setId_modelo(Integer.parseInt(rs.getString(1)));
               modelo.setId_marca(Integer.parseInt(rs.getString(2)));
              modelo.setCaballos_fuerza(rs.getString(3));
              modelo.setNombre_modelo(rs.getString(4));
           //   marca.setId_concesionario(Integer.parseInt(rs.getString(3)));
              arrmodelo.add(modelo);
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
    return arrmodelo;

}
            
    
}
