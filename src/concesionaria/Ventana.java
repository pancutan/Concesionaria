package concesionaria;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.peer.PanelPeer;
import javax.swing.JFrame;
import javax.swing.JPanel;

//JFrame son Ventanas Swing en Java, capaces de correr sobre cualquier SO
public class Ventana extends JFrame {

  //Segun la pag 145 de Java, La Guia Total del Programador, un JPanel
  //Creamos una ventana. Por comodidad, la declaramos como un atributo.
  JPanel PanelPrincipal = new JPanel();

  public Ventana() {

    //En este constructor le daremos forma:

    //Titulo a la ventana
    super("Concesionaria");

    //Dimensiones
    PanelPrincipal.setPreferredSize(new Dimension(300, 250));

    //Y borde
    PanelPrincipal.setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();

    c.fill = GridBagConstraints.HORIZONTAL;





    super.pack();
    super.setVisible(true);

  }
}
