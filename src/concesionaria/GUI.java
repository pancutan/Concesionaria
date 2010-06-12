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

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultListModel;

import javax.swing.JOptionPane;

/**
 *
 * @author s
 */
public class GUI extends javax.swing.JFrame {

  Calculador calculadora = new Calculador();
  Double valorCoeficiente;
  //pruebasss////////////////////////////////////////////
  //  Vector<TransporteCarga> v = (Vector)calculadora.getVectorCarga();
  //String[] arreglo;
  Object unObjeto;
  //pruebasss/////////////////////////////////////////////////////////
  DefaultListModel modelo = new DefaultListModel();

  private Vector<TransporteCarga> vectorCarga = new Vector<TransporteCarga>();

  /** Creates new form GUI */
  public GUI() {

    initComponents();



    /*for(int i = 1; i<=10; i++){
    this.modelo.addElement(i);
    }*/

    //?   String [] arreglo = new String[9];

    //Instancio un stock, que va a poseer un vector encapsulado adentro, con los
    //vehiculos a dispocisión presentes en stock.txt
    Stock unStock = new Stock();

    //Le pido a unStock una copia del vector
    vectorCarga = unStock.getVectorCarga();

    //Preparo algunas variables locales para recibir alguna cadenas procedentes
    //de los objetos del vector

    String marca;
    String color;
    int anioFabricac;
    String tipoCombustible;
    double precFabrica;

    //recorro mi copia del vector
    for (int i = 0; i < vectorCarga.size(); i++) {

      //lo siguiente es valido
      //System.out.println(vectorCarga.firstElement().marca.toString());

      //tambien es valido
      //System.out.println(vectorCarga.elementAt(i).marca.toString());

      //?
      //Object <vectorCarga> o =<vectorCarga> vectorCarga.elementAt(i);

      marca = (String) vectorCarga.elementAt(i).marca.toString();
      color = (String) vectorCarga.elementAt(i).color.toString();
      anioFabricac = (int) vectorCarga.elementAt(i).anioFabricac;
      tipoCombustible = (String) vectorCarga.elementAt(i).tipoCombustible.toString();
      precFabrica = (Double) vectorCarga.elementAt(i).precFabrica;

      //cadena es una la concatenacion de las caracteristicas del vehiculo, para mostar en la JList
      String cadena = marca + " " + color + ", modelo " + anioFabricac
              + ", a " + tipoCombustible + ", Px de fab: " + precFabrica;

      this.modelo.addElement(cadena);

      //muestro en consola, para debuggear nomas sin F4
      System.out.println(cadena);


      //?
      //arreglo[i] = (String) vectorCarga.elementAt(i).getMarca();
      //System.out.println(arreglo[i]);

    }
/*
    this.modelo.addElement("ppp");
    this.modelo.addElement("ppp");
    this.modelo.addElement("ppp");
    this.modelo.addElement("ppp");
*/
    
    //pruebasss



    //Puebla arriba a la derecha, las cajas con valores obtenidos de los archivos

    //--------- COMIENZA LLENADO DE CAJAS SUPERIORES ----------------

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

    //--------- FIN LLENADO DE CAJAS SUPERIORES ----------------



    //~~~~~~~ COMIENZA LLENADO DE CAJA DE COEFICIENTE ~~~~~~~~~~
    //Usa un metodo publico de tipo getter para recibir una copia del diccionario
    HashMap q = calculadora.getDiccionario_coeficientes();

    //Buscando año en curso
    Calendar ahora = Calendar.getInstance();
    Integer anio = ahora.get(Calendar.YEAR);

    //Seteando año en curso sobre el Label "Anio"
    Anio.setText(anio.toString());

    //Buscando en el diccionario q, el valorCoeficiente. Para lograrlo, buscamos entre
    //las llaves, una que se denomine "2010" (como cadena, cuidado!)

    //Lo dejo como atributo, ya que será de utilidad cuando pulsen el valor Cotizar
    valorCoeficiente = (Double) q.get(2010);


    //Seteando valorCoeficiente que corresponde al año en curso
    Coeficiente.setText(valorCoeficiente.toString());

    /*
    //Saca del diccionario el primer valor
    Double otroDouble = (Double) p.get("transporte-impuestos");//ojo q es Double
    //Lo convierte en una Cadena
    String unString = Double.toString(unDouble);
    //...Para poder mostrarlo en una caja de texto
    Caja1.setText(unString);
     */

    //~~~~~~~ FIN LLENADO DE CAJA DE COEFICIENTE ~~~~~~~~~~


    //######## COMIENZA LLENADO DE JLists con Vehiculos ###############

//    Vector<TransporteCarga> v = (Vector)calculadora.getVectorCarga();



    //######## FIN LLENADO DE JLists con Vehiculos ####################


    this.setVisible(true);
  }//Constructor

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

    jLabel1 = new javax.swing.JLabel();
    jButton1 = new javax.swing.JButton();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    Caja1 = new javax.swing.JTextField();
    Caja3 = new javax.swing.JTextField();
    Caja2 = new javax.swing.JTextField();
    Caja4 = new javax.swing.JTextField();
    Caja5 = new javax.swing.JTextField();
    Caja6 = new javax.swing.JTextField();
    jLabel7 = new javax.swing.JLabel();
    Anio = new javax.swing.JLabel();
    jLabel8 = new javax.swing.JLabel();
    Coeficiente = new javax.swing.JLabel();
    BotonGUITransporte = new javax.swing.JButton();
    BotonGUIParticular = new javax.swing.JButton();
    BotonGUICarga = new javax.swing.JButton();
    jLabel2 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    CajaValorReajuste = new javax.swing.JTextField();
    CajaCuotas = new javax.swing.JTextField();
    BotonCotizar = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    Lista1 = new javax.swing.JList();
    jScrollPane2 = new javax.swing.JScrollPane();
    Lista2 = new javax.swing.JList();
    jScrollPane3 = new javax.swing.JScrollPane();
    Lista3 = new javax.swing.JList();
    jLabel9 = new javax.swing.JLabel();
    EtiquetaSeguro = new javax.swing.JLabel();
    jLabel10 = new javax.swing.JLabel();
    jLabel11 = new javax.swing.JLabel();
    jLabel12 = new javax.swing.JLabel();
    jLabel13 = new javax.swing.JLabel();
    jLabel14 = new javax.swing.JLabel();
    EtiquetaVehiculoElegido = new javax.swing.JLabel();
    EtiquetaPrecioVenta = new javax.swing.JLabel();
    jLabel15 = new javax.swing.JLabel();
    EtiquetaValordeCuota = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jLabel1.setText("Valores generales");

    jButton1.setText("Actualizar");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jLabel3.setText("Impuesto");

    jLabel4.setText("Utilidad");

    jLabel7.setText("Coeficiente correspondiente al año en curso:");

    Anio.setText("jLabel8");

    jLabel8.setText("->");

    Coeficiente.setText("jLabel9");

    BotonGUITransporte.setText("Transporte");
    BotonGUITransporte.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        BotonGUITransporteActionPerformed(evt);
      }
    });

    BotonGUIParticular.setText("Particular");

    BotonGUICarga.setText("Carga");

    jLabel2.setText("Escoja vehiculo de nuestro stock:");

    jLabel5.setText("Valor de Reajuste");

    jLabel6.setText("Cuotas");

    CajaCuotas.setText("1");

    BotonCotizar.setText("Cotizar");
    BotonCotizar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        BotonCotizarActionPerformed(evt);
      }
    });

    Lista1.setModel(new javax.swing.AbstractListModel() {
      String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
      public int getSize() { return strings.length; }
      public Object getElementAt(int i) { return strings[i]; }
    });
    Lista1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    jScrollPane1.setViewportView(Lista1);

    Lista2.setModel(new javax.swing.AbstractListModel() {
      String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
      public int getSize() { return strings.length; }
      public Object getElementAt(int i) { return strings[i]; }
    });
    Lista2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    jScrollPane2.setViewportView(Lista2);

    Lista3.setModel(modelo);
    Lista3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    jScrollPane3.setViewportView(Lista3);

    jLabel9.setText("Seguro:");

    jLabel10.setText("Precio de Venta:");

    jLabel11.setText("Impuesto");

    jLabel12.setText("Utilidad");

    jLabel13.setText("Impuesto");

    jLabel14.setText("Utilidad");

    org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, Lista3, org.jdesktop.beansbinding.ELProperty.create("${selectedElement}"), EtiquetaVehiculoElegido, org.jdesktop.beansbinding.BeanProperty.create("text"));
    bindingGroup.addBinding(binding);

    jLabel15.setText("Valor de la cuota:");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(96, 96, 96)
            .addComponent(jLabel11)
            .addGap(31, 31, 31)
            .addComponent(jLabel12))
          .addComponent(jLabel2)
          .addGroup(layout.createSequentialGroup()
            .addComponent(BotonGUITransporte)
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4))
              .addGroup(layout.createSequentialGroup()
                .addComponent(Caja1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Caja2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jButton1))
          .addGroup(layout.createSequentialGroup()
            .addComponent(BotonGUIParticular)
            .addGap(18, 18, 18)
            .addComponent(Caja3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(Caja4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel7)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(Anio))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
              .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Coeficiente))
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                  .addComponent(jLabel6)
                  .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  .addComponent(CajaCuotas, 0, 0, Short.MAX_VALUE)
                  .addComponent(CajaValorReajuste, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotonCotizar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addComponent(EtiquetaVehiculoElegido)
              .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EtiquetaPrecioVenta))
              .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EtiquetaValordeCuota))
              .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EtiquetaSeguro, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
          .addGroup(layout.createSequentialGroup()
            .addGap(24, 24, 24)
            .addComponent(BotonGUICarga)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(Caja5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel13))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel14)
              .addComponent(Caja6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        .addGap(138, 138, 138))
    );

    layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BotonGUICarga, BotonGUIParticular, BotonGUITransporte, Caja1, Caja2, Caja3, Caja4, Caja5, Caja6, jButton1, jLabel3});

    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel7)
          .addComponent(Anio)
          .addComponent(jLabel8)
          .addComponent(Coeficiente))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel1)
              .addComponent(jButton1))
            .addGap(14, 14, 14)
            .addComponent(jLabel2)
            .addGap(9, 9, 9)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel4)
              .addComponent(jLabel3))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(Caja1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(Caja2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addComponent(BotonGUITransporte)))
          .addComponent(BotonCotizar, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(CajaValorReajuste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel5))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(CajaCuotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel6))))
        .addGap(6, 6, 6)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addGroup(layout.createSequentialGroup()
            .addGap(4, 4, 4)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel11)
              .addComponent(jLabel12))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(BotonGUIParticular)
              .addComponent(Caja3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(Caja4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addGroup(layout.createSequentialGroup()
            .addComponent(EtiquetaVehiculoElegido)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel10)
              .addComponent(EtiquetaPrecioVenta))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(EtiquetaSeguro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(jLabel9))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel15)
              .addComponent(EtiquetaValordeCuota))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel13)
              .addComponent(jLabel14))
            .addGap(6, 6, 6)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(Caja5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(Caja6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addComponent(BotonGUICarga))))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jScrollPane3)
          .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(150, Short.MAX_VALUE))
    );

    layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BotonGUICarga, BotonGUIParticular, BotonGUITransporte, Caja1, Caja2, Caja3, Caja4, Caja5, Caja6});

    bindingGroup.bind();

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      //Un HashMap auxiliar donde guardar todas las cajas de texto
      HashMap aux = new HashMap();

      //Rellenando el diccionario auxiliar...
      aux.put("transporte-impuestos", new Double(Caja1.getText()));
      aux.put("transporte-utilidades", new Double(Caja2.getText()));
      aux.put("particulares-impuestos", new Double(Caja3.getText()));
      aux.put("particulares-utilidades", new Double(Caja4.getText()));
      aux.put("carga-impuestos", new Double(Caja5.getText()));
      aux.put("carga-utilidades", new Double(Caja6.getText()));

      calculadora.setDiccionario_vehiculos(aux);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void BotonGUITransporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGUITransporteActionPerformed
      /*GUITransporte ListaT = new GUITransporte();
      JOptionPane.showMessageDialog(null, "Valor seleccionado" + ListaT.getTransporteSeleccionado());
       * 
       */
      //CajaVehiculoSeleccionado.setText(ListaT.getTransporteSeleccionado().toString());
    }//GEN-LAST:event_BotonGUITransporteActionPerformed

    private void BotonCotizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCotizarActionPerformed

      //el operador ha ingresado lo necesario?
      if (Lista3.isSelectionEmpty()) {
        JOptionPane.showMessageDialog(null, "Debe escoger un vehiculo antes de comenzar la cotización");
      }

      if (CajaValorReajuste.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Indique un valor de reajuste");
      }



      /* Segun postulado:
       * "Cualquiera sea el tipo de vehículo, el calculo del precio de venta se realiza
       * mediante el siguiente método:
       *
       * Precio Venta = Precio de Fabrica * 1.21 + Utilidad + Impuestos"
       */

      /* Busco el precio de fabrica a partir de la etiqueta EtiquetaVehiculoElegido
       * y lo convierto a double para trabajarlo enseguida
       */

      String PrecioFabricaAConvertir = EtiquetaVehiculoElegido.getText();

      //Recordar postulado: Use control de excepciones ante posibles errores

      try {
        String[] PrecioFabricaAConvertirEnPedacitos = PrecioFabricaAConvertir.split(":");

        double pxFabrica = Double.valueOf(PrecioFabricaAConvertirEnPedacitos[1]).doubleValue();

        double utilidad = Double.valueOf(Caja6.getText()).doubleValue();
        double impuestos = Double.valueOf(Caja5.getText()).doubleValue();

        double pxVenta = pxFabrica * 1.21 + utilidad + impuestos;

        //Lo dejamos en dos decimales... no sea que la multiplicacion arroje cualquier cosa
        DecimalFormat formateador = new DecimalFormat("####.##");

        EtiquetaPrecioVenta.setText(formateador.format(pxVenta));


        /* Además cada vez que se vende un vehículo este debe ser asegurado.
         * Para calcular el valor del seguro se emplea el siguiente método:
         * Seguro = Precio de venta * Coeficiente (registrado en un archivo y que
         * varia según el año de fabricación del vehículo) + reajuste (ingresado
         * por el operador en el momento de realizar el cálculo.
         */

        double reajuste = Double.valueOf(CajaValorReajuste.getText()).doubleValue();

        Double seguro = pxVenta * valorCoeficiente + reajuste;
        EtiquetaSeguro.setText(formateador.format(seguro));

        /*
         * Si el vehículo de vende financiado, el valor de la cuota se calcula
         * mediante el siguiente método:
         * Cuota = (Precio de venta  + Seguro) * Interés Anual / Número de Cuotas
         *
         * "Interes Anual" es el coeficiente anual correspondiente al año en curso ?         *
         */
        double cuotas = Double.valueOf(CajaCuotas.getText()).doubleValue();


        Double interesAnual = 1.002;
        //double cuota = pxVenta + seguro * valorCoeficiente / cuotas;
        //             (200000  +  2000)   * 1.002 / 10

        double cuota = (pxVenta + seguro) * interesAnual / cuotas;

        EtiquetaValordeCuota.setText(formateador.format(cuota));



      } catch (java.lang.NumberFormatException e) {
        System.out.println("La caja conteniendo el valor de reajuste debe ser llenada\n"
                + " Caso contrario, atrapamos la excepción: " + e.getMessage());

      } catch (java.lang.NullPointerException e) {
        System.out.println("Atrapando excepción: si la Lista de vehiculos no ha sido seleccionada, no \n"
                + "hay manera de calcular el px de venta ");
      }


    }//GEN-LAST:event_BotonCotizarActionPerformed


    //señores, el main, por si lo desea ejecutar desde aqui en lugar desde el Main.java
  public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {

      public void run() {
        new GUI().setVisible(true);
      }
    });
  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel Anio;
  private javax.swing.JButton BotonCotizar;
  private javax.swing.JButton BotonGUICarga;
  private javax.swing.JButton BotonGUIParticular;
  private javax.swing.JButton BotonGUITransporte;
  private javax.swing.JTextField Caja1;
  private javax.swing.JTextField Caja2;
  private javax.swing.JTextField Caja3;
  private javax.swing.JTextField Caja4;
  private javax.swing.JTextField Caja5;
  private javax.swing.JTextField Caja6;
  private javax.swing.JTextField CajaCuotas;
  private javax.swing.JTextField CajaValorReajuste;
  private javax.swing.JLabel Coeficiente;
  private javax.swing.JLabel EtiquetaPrecioVenta;
  private javax.swing.JLabel EtiquetaSeguro;
  private javax.swing.JLabel EtiquetaValordeCuota;
  private javax.swing.JLabel EtiquetaVehiculoElegido;
  private javax.swing.JList Lista1;
  private javax.swing.JList Lista2;
  private javax.swing.JList Lista3;
  private javax.swing.JButton jButton1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel11;
  private javax.swing.JLabel jLabel12;
  private javax.swing.JLabel jLabel13;
  private javax.swing.JLabel jLabel14;
  private javax.swing.JLabel jLabel15;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane3;
  private org.jdesktop.beansbinding.BindingGroup bindingGroup;
  // End of variables declaration//GEN-END:variables
}
