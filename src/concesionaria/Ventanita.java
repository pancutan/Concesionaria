/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Ventanita.java
 *
 * Created on 30/05/2010, 13:59:42
 */

package concesionaria;

/**
 *
 * @author s
 */
public class Ventanita extends javax.swing.JFrame {

    /** Creates new form Ventanita */
    public Ventanita() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    TempTextField = new javax.swing.JTextField();
    jLabel1 = new javax.swing.JLabel();
    convertButton = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Concesionaria");

    jLabel1.setText("jLabel1");

    convertButton.setText("Convert");
    convertButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        convertButtonActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(41, 41, 41)
            .addComponent(jLabel1))
          .addGroup(layout.createSequentialGroup()
            .addGap(90, 90, 90)
            .addComponent(TempTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(convertButton)))
        .addContainerGap(74, Short.MAX_VALUE))
    );

    layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {TempTextField, convertButton});

    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(69, 69, 69)
        .addComponent(jLabel1)
        .addGap(32, 32, 32)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(30, 30, 30)
            .addComponent(convertButton))
          .addComponent(TempTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(65, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void convertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convertButtonActionPerformed
      jLabel1.setText("dfsdfsdfsdf");
    }//GEN-LAST:event_convertButtonActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventanita().setVisible(true);
            }
        });
    }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JTextField TempTextField;
  private javax.swing.JButton convertButton;
  private javax.swing.JLabel jLabel1;
  // End of variables declaration//GEN-END:variables

}