/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JUAN MANUEL
 */
public class Marca_Ascendente extends javax.swing.JPanel {

    /**
     * Creates new form Marca_Ascendente
     */
    public Marca_Ascendente() {
        initComponents();
        cargarunion();
    }

    
    public void cargarunion(){
        DefaultTableModel modelo = (DefaultTableModel)tabla_ascendente.getModel();
        modelo.setRowCount(0);
         ConexionBD cc = new ConexionBD(); //creo clase conxeion base de datos
        Connection cn = cc.getConnection();//creo variable para iniciar la conexion
        PreparedStatement pst = null;  // sirve para hacer los llamados de la base
        String sql ="SELECT *FROM marca ORDER BY id_marca DESC ";
        
        try {
            
         pst=cn.prepareStatement(sql);
          ResultSet rs = pst.executeQuery();
          while(rs.next()){
              Vector v =new Vector();
              v.add(rs.getInt(1));
              v.add(rs.getString(2));
               v.add(rs.getInt(3));
               modelo.addRow(v);
               tabla_ascendente.setModel(modelo);
              
              
          }
              
             
        
    }catch(SQLException e){
    
}
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_ascendente = new javax.swing.JTable();

        tabla_ascendente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nombre", "ID Concesionario"
            }
        ));
        jScrollPane1.setViewportView(tabla_ascendente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_ascendente;
    // End of variables declaration//GEN-END:variables
}
