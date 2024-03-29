/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import classDAO.modeloDAO;
import classVO.modeloVO;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JUAN MANUEL
 */
public class Informacion_Modelo extends javax.swing.JPanel {

    /**
     * Creates new form Informacion_Modelo
     */
    public Informacion_Modelo() {
        initComponents();
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
        tabla_modelo = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jScrollPane1.setViewportView(tabla_modelo);

        jButton1.setText("Cargar Datos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel modelo = new  DefaultTableModel();
        modelo.addColumn("ID Modelo");
        modelo.addColumn("ID Marca");
         modelo.addColumn("Caballos de Fuerza");
        modelo.addColumn("Nombre");
        tabla_modelo.setModel(modelo);
        Object[] arrmarca = new Object[4];
        
        for(modeloVO conce: modeloDAO.llenarmodelo()){
          arrmarca[0] = conce.getId_modelo();
          arrmarca[1] = conce.getId_marca();
          arrmarca[2] = conce.getCaballos_fuerza();
          arrmarca[3] = conce.getNombre_modelo();
          modelo.addRow(arrmarca);
        }
        
        tabla_modelo.setModel(modelo);
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_modelo;
    // End of variables declaration//GEN-END:variables
}
