/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GUI.java
 *
 * Created on 30/05/2010, 14:39:11
 */
package concesionaria;

import java.util.HashMap;

/**
 *
 * @author s
 */
public class GUI extends javax.swing.JFrame {

  Calculador calculadora = new Calculador();

  /** Creates new form GUI */
  public GUI() {

    initComponents();
    //Puebla arriba a la derecha, las cajas con valores obtenidos de los archivos

    //Usa un metodo publico de tipo getter para recibir una copia del diccionario
    HashMap p = calculadora.getDiccionario_vehiculos();

    //Saca del diccionario el primer valor
    Double unDouble = (Double) p.get("transporte-impuestos");//ojo q es Double
    //Lo convierte en una Cadena
    String unString = Double.toString(unDouble);
    //...Para poder mostrarlo en una caja de texto
    Caja1.setText(unString);
    
    
    //Saca del diccionario el segundo valor
    unDouble = (Double) p.get("transporte-utilidades");//ojo q es Double
    //Lo convierte en una Cadena
    unString = Double.toString(unDouble);
    //...Para poder mostrarlo en una caja de texto
    Caja2.setText(unString);
    
    //Saca del diccionario el tercer valor
    unDouble = (Double) p.get("particulares-impuestos");//ojo q es Double
    //Lo convierte en una Cadena
    unString = Double.toString(unDouble);
    //...Para poder mostrarlo en una caja de texto
    Caja3.setText(unString);

    //Saca del diccionario el cuarto valor
    unDouble = (Double) p.get("particulares-utilidades");//ojo q es Double
    //Lo convierte en una Cadena
    unString = Double.toString(unDouble);
    //...Para poder mostrarlo en una caja de texto
    Caja4.setText(unString);

    //Saca del diccionario el quinto valor
    unDouble = (Double) p.get("carga-impuestos");//ojo q es Double
    //Lo convierte en una Cadena
    unString = Double.toString(unDouble);
    //...Para poder mostrarlo en una caja de texto
    Caja5.setText(unString);

    //Saca del diccionario el sexto valor
    unDouble = (Double) p.get("carga-utilidades");//ojo q es Double
    //Lo convierte en una Cadena
    unString = Double.toString(unDouble);
    //...Para poder mostrarlo en una caja de texto
    Caja6.setText(unString);


    this.setVisible(true);
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    jButton1 = new javax.swing.JButton();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    Caja1 = new javax.swing.JTextField();
    Caja3 = new javax.swing.JTextField();
    Caja2 = new javax.swing.JTextField();
    Caja4 = new javax.swing.JTextField();
    Caja5 = new javax.swing.JTextField();
    Caja6 = new javax.swing.JTextField();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jLabel1.setText("Valores generales");

    jButton1.setText("Actualizar");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jLabel2.setText("Transporte");

    jLabel3.setText("Impuesto");

    jLabel4.setText("Utilidad");

    jLabel5.setText("Particular");

    jLabel6.setText("Carga");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButton1))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel2)
              .addComponent(jLabel5)
              .addComponent(jLabel6))
            .addGap(23, 23, 23)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addComponent(Caja5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Caja6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(layout.createSequentialGroup()
                .addComponent(Caja3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Caja4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4))
              .addGroup(layout.createSequentialGroup()
                .addComponent(Caja1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Caja2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        .addContainerGap(161, Short.MAX_VALUE))
    );

    layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Caja1, Caja2, Caja3, Caja4, Caja5, Caja6, jLabel2});

    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(jButton1))
        .addGap(14, 14, 14)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(jLabel4))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(Caja1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(Caja2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel5)
          .addComponent(Caja3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(Caja4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel6)
          .addComponent(Caja5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(Caja6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(144, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      //Un HashMap auxiliar donde guardar todas las cajas de texto
      HashMap aux = new HashMap();

      //Rellenando el diccionario auxiliar...
      aux.put("transporte-impuestos", new Double (Caja1.getText() ) );
      aux.put("transporte-utilidades", new Double (Caja2.getText() ) );
      aux.put("particulares-impuestos", new Double (Caja3.getText() ) );
      aux.put("particulares-utilidades", new Double (Caja4.getText() ) );
      aux.put("carga-impuestos", new Double (Caja5.getText() ) );
      aux.put("carga-utilidades", new Double (Caja6.getText() ) );

      calculadora.setDiccionario_vehiculos(aux);

    }//GEN-LAST:event_jButton1ActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {

      public void run() {
        new GUI().setVisible(true);
      }
    });
  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTextField Caja1;
  private javax.swing.JTextField Caja2;
  private javax.swing.JTextField Caja3;
  private javax.swing.JTextField Caja4;
  private javax.swing.JTextField Caja5;
  private javax.swing.JTextField Caja6;
  private javax.swing.JButton jButton1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  // End of variables declaration//GEN-END:variables
}