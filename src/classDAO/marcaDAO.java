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
 *,
 * @author JUAN MANUEL
 * en la claase DAO interactuo con las tablas
 */
public class marcaDAO {
    
    //INSERTAR---------------------------------------------------------------------------------------
    public static String registrarmarcas(marcaVO marca) { //clase que permite hacer las 4 operaciones en las tablas
        String result = null, last = null;
        ConexionBD cc = new ConexionBD(); //creo clase conxeion base de datos
        Connection cn = cc.getConnection();//creo variable para iniciar la conexion
        PreparedStatement pst = null;  // sirve para hacer los llamados de la base
   
        String sql ="INSERT INTO marca values(?,?,?)";//sirve para hacer la consulta a la base si hubiera un valor decremental le pondria un null
        try{
            pst=cn.prepareStatement(sql);
            pst.setInt(1,marca.getId_marca() );//aca ponemos el objeto del campo con "?" que queremos rellenar
            pst.setString(2,marca.getNombre_marca() );
            pst.setInt(3,marca.getId_concesionario());
            pst.execute();
            pst= cn.prepareStatement("SELECT MAX(id_marca) AS ID FROM  marca");
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                last=rs.getString(1);
                
            }
            
            result = "marca registrada con exito, ID"+last;
            
            
            
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
        
        
     public static String actualizarmarcas(marcaVO marca) { //clase que permite hacer las 4 operaciones en las tablas
        String result = null, last = null;
        ConexionBD cc = new ConexionBD(); //creo clase conxeion base de datos
        Connection cn = cc.getConnection();//creo variable para iniciar la conexion
        PreparedStatement pst = null;  // sirve para hacer los llamados de la base
   
        String sql ="UPDATE marca SET nombre_marca=?,id_concesionario=? WHERE id_marca = ? ";//sirve para hacer la consulta a la base si hubiera un valor decremental le pondria un null
        try{
            pst=cn.prepareStatement(sql);
          //aca ponemos el objeto del campo con "?" que queremos rellenar
            pst.setString(1,marca.getNombre_marca() );
            pst.setInt(2,marca.getId_concesionario());
              pst.setInt(3,marca.getId_marca() );
            pst.execute();
            pst= cn.prepareStatement("SELECT MAX(id_marca) AS ID FROM  marca");
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                last=rs.getString(1);
                
            }
            
            result = "marca actualizada con exito, ID"+ marca.getId_marca() ;
            
            
            
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
    
     
        public static marcaVO buscarmarcas(String clave) { //clase que permite hacer las 4 operaciones en las tablas
        marcaVO marca = new  marcaVO();   
        ConexionBD cc = new ConexionBD(); //creo clase conxeion base de datos
        Connection cn = cc.getConnection();//creo variable para iniciar la conexion
        PreparedStatement pst = null;  // sirve para hacer los llamados de la base
   
        String sql ="SELECT * FROM marca WHERE id_marca =? ";//sirve para hacer la consulta a la base si hubiera un valor decremental le pondria un null
        try{
            pst=cn.prepareStatement(sql);
            pst.setString(1, clave);
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()){
                marca.setId_marca(Integer.parseInt(rs.getString(1)));//esto me obtiene todos los ID de la base
                marca.setNombre_marca((rs.getString(2)));
                marca.setId_concesionario((rs.getInt(3)));
            }
            
            marca.setResultado ("Busqueda exitosa") ;
            
            
            
        }catch(SQLException e){
            
            marca.setResultado ( "ERROR en la consulta"+e.getMessage());
            
        }finally{
            try{
                if (cn != null){
                    cn.close();
                    pst.close();
            }
        }catch(Exception e){
                marca.setResultado("Error"+e);
                
                }
            
        }
    return marca;
    
    
    
    
    
}
        
        //eliminar
        
 public static String eliminarmarcas(String clave) { //clase que permite hacer las 4 operaciones en las tablas
        String result = null;
        ConexionBD cc = new ConexionBD(); //creo clase conxeion base de datos
        Connection cn = cc.getConnection();//creo variable para iniciar la conexion
        PreparedStatement pst = null; 
   
        String sql ="DELETE FROM marca where id_marca=?";//sirve para hacer la consulta a la base si hubiera un valor decremental le pondria un null
        try{
            pst=cn.prepareStatement(sql);
            pst.setString(1, clave);
            pst.executeUpdate();
            result = "Marca eliminado con exito";
      
            
            
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
        
    
 public static ArrayList<marcaVO>getListmarca(){
     
     ArrayList<marcaVO> arrmarca = new ArrayList<marcaVO>();
     //se copia la esctrutura buscar desde conexion
     
        ConexionBD cc = new ConexionBD(); //creo clase conxeion base de datos
        Connection cn = cc.getConnection();//creo variable para iniciar la conexion
        PreparedStatement pst = null;  // sirve para hacer los llamados de la base
        marcaVO marca =null;
   
        String sql ="SELECT * FROM marca ";//sirve para hacer la consulta a la base si hubiera un valor decremental le pondria un null
        try{
            pst=cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()){
                marca = new marcaVO();
                marca.setId_marca(Integer.parseInt(rs.getString(1)));//esto me obtiene todos los ID de la base
                marca.setNombre_marca((rs.getString(2)));
               if(arrmarca.isEmpty()){
                   arrmarca.add(0,marca);
               }else{
                   arrmarca.add(marca);
                   
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
    return arrmarca;
    
    
    
    
    
}
 
 public static ArrayList<marcaVO>llenarmarca(){
    ArrayList<marcaVO> arrmarca = new ArrayList<marcaVO>();
      ConexionBD cc = new ConexionBD(); //creo clase conxeion base de datos
        Connection cn = cc.getConnection();//creo variable para iniciar la conexion
        PreparedStatement pst = null;  // sirve para hacer los llamados de la bas
        marcaVO marca = null;
        String sql ="SELECT * FROM  marca";
        
          try{
            pst=cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
              marca  = new marcaVO();
              marca.setId_marca(Integer.parseInt(rs.getString(1)));
              marca.setNombre_marca(rs.getString(2));
              marca.setId_concesionario(Integer.parseInt(rs.getString(3)));
              arrmarca.add(marca);
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
    return arrmarca;

}
     

 // prueba Inner join
 
  public static ArrayList<marcaVO>union(){
    ArrayList<marcaVO> arrmarca = new ArrayList<marcaVO>();
      ConexionBD cc = new ConexionBD(); //creo clase conxeion base de datos
        Connection cn = cc.getConnection();//creo variable para iniciar la conexion
        PreparedStatement pst = null;  // sirve para hacer los llamados de la bas
        marcaVO marca = null;
        concesionarioVO concesionario = null;
        
        
        
        String sql ="SELECT * FROM  marca, concesionario WHERE  marca.id_concesionario = concesionario.id_concesionario";
        
          try{
            pst=cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
              marca  = new marcaVO();
              concesionario = new concesionarioVO();
              marca.setId_marca(Integer.parseInt(rs.getString(1)));
              marca.setNombre_marca(rs.getString(2));
              marca.setId_concesionario(Integer.parseInt(rs.getString(3)));
              concesionario.setId_concesionario(Integer.parseInt(rs.getString(4)));
              concesionario.setDireccion_concesionario(rs.getString(5));
              concesionario.setNombre_concesionario(rs.getString(6));
              arrmarca.add(marca);
             
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
    return arrmarca;

}
 
 
 
 
}