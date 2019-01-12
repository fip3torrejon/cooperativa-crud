/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperativa.vista;

import java.awt.Color;

/**
 *
 * @author ftorrejon
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    
  /**
   * Creates new form VentanaPrincipal
   */
  
  //declaracion de atributos personalizados
  private final String operador;
  
  public VentanaPrincipal(String operador) {
    this.operador = operador;
    initComponents();
    
    labelSaludo.setText("Hola, " + operador);
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT
   * modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    labelTitulo = new javax.swing.JLabel();
    labelSubtitulo = new javax.swing.JLabel();
    enlaceSalir = new javax.swing.JLabel();
    botonARegistrar = new javax.swing.JButton();
    labelARegistrar = new javax.swing.JLabel();
    botonAModificar = new javax.swing.JButton();
    labelAModificar = new javax.swing.JLabel();
    botonABusqueda = new javax.swing.JButton();
    labelABuscar = new javax.swing.JLabel();
    labelSaludo = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    labelTitulo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    labelTitulo.setText("BASE DE DATOS");

    labelSubtitulo.setText("Archivo Radio Cooperativa");

    enlaceSalir.setText("Salir");
    enlaceSalir.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        enlaceSalirMouseClicked(evt);
      }
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        enlaceSalirMouseEntered(evt);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        enlaceSalirMouseExited(evt);
      }
    });

    botonARegistrar.setText("Registrar");
    botonARegistrar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        botonARegistrarActionPerformed(evt);
      }
    });

    labelARegistrar.setLabelFor(botonARegistrar);
    labelARegistrar.setText("<html>Acá podrás ingresar un nuevo archivo a la colección</html>");
    labelARegistrar.setInheritsPopupMenu(false);

    botonAModificar.setText("Modificar");
    botonAModificar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        botonAModificarActionPerformed(evt);
      }
    });

    labelAModificar.setLabelFor(botonARegistrar);
    labelAModificar.setText("<html>Acá podrás modificar o eliminar un archivo de la colección</html>");
    labelAModificar.setInheritsPopupMenu(false);

    botonABusqueda.setText("Buscar");
    botonABusqueda.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        botonABusquedaActionPerformed(evt);
      }
    });

    labelABuscar.setLabelFor(botonARegistrar);
    labelABuscar.setText("<html>Si quieres buscar en nuestra colección, éste es el lugar</html>");
    labelABuscar.setInheritsPopupMenu(false);

    labelSaludo.setText("Archivo Radio Cooperativa");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addComponent(labelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 223, Short.MAX_VALUE)
                .addComponent(labelSaludo))
              .addGroup(layout.createSequentialGroup()
                .addComponent(labelSubtitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(enlaceSalir))))
          .addGroup(layout.createSequentialGroup()
            .addGap(33, 33, 33)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
              .addComponent(botonARegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(botonAModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(botonABusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(labelARegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(labelAModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(labelABuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        .addGap(18, 18, 18))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(labelTitulo)
          .addComponent(labelSaludo))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(labelSubtitulo)
          .addComponent(enlaceSalir))
        .addGap(41, 41, 41)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(botonARegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(labelARegistrar))
        .addGap(40, 40, 40)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(botonAModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(labelAModificar))
        .addGap(38, 38, 38)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(botonABusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(labelABuscar))
        .addGap(34, 34, 34))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void botonARegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonARegistrarActionPerformed
    java.awt.EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        new VentanaRegistrar("OPERADOR DE PRUEBA").setVisible(true);
      }
    });
  }//GEN-LAST:event_botonARegistrarActionPerformed

  private void botonAModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAModificarActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_botonAModificarActionPerformed

  private void botonABusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonABusquedaActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_botonABusquedaActionPerformed

  private void enlaceSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enlaceSalirMouseClicked
    System.exit(0);
  }//GEN-LAST:event_enlaceSalirMouseClicked

  private void enlaceSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enlaceSalirMouseEntered
    enlaceSalir.setForeground(Color.BLUE);
  }//GEN-LAST:event_enlaceSalirMouseEntered

  private void enlaceSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enlaceSalirMouseExited
    enlaceSalir.setForeground(Color.BLACK);
  }//GEN-LAST:event_enlaceSalirMouseExited

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        new VentanaPrincipal("OPERADOR DE PRUEBA").setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton botonABusqueda;
  private javax.swing.JButton botonAModificar;
  private javax.swing.JButton botonARegistrar;
  private javax.swing.JLabel enlaceSalir;
  private javax.swing.JLabel labelABuscar;
  private javax.swing.JLabel labelAModificar;
  private javax.swing.JLabel labelARegistrar;
  private javax.swing.JLabel labelSaludo;
  private javax.swing.JLabel labelSubtitulo;
  private javax.swing.JLabel labelTitulo;
  // End of variables declaration//GEN-END:variables
}
