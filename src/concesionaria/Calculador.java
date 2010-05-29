package concesionaria;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Calculador {

  public Calculador() {

    /**
     * Comienza lectura de archivo
     */
    File archivo = null;
    FileReader fr = null;
    BufferedReader br = null;

    try {
      // Apertura del fichero y creacion de BufferedReader para poder
      // hacer una lectura comoda (disponer del metodo readLine()).
      archivo = new File("archivo.txt");
      fr = new FileReader(archivo);
      br = new BufferedReader(fr);

      String linea;

      /*
       * Cualquiera sea el tipo de vehículo, el calculo del precio de venta se realiza mediante el siguiente método:
      Precio Venta = Precio de Fabrica * 1.21 + Utilidad + Impuestos

      Los impuestos  se obtienen de una tabla (archivo.txt) que contiene los valores correspondientes a cada tipo de vehículo. Estos valores deben poder modificarse si es necesario.

      Las utilidades  se obtienen de una tabla (archivo.txt) que contiene los valores correspondientes a cada marca de vehículo. Estos valores deben poder modificarse si es necesario.
       */


      // Lectura del fichero

      //DICCIONARIO DE archivo.txt:
      //impuestos,utilidades(%),coeficiente

      //-----------------------------------------------------------------
      //Primer linea, contiene vehiculos de transporte
      linea = br.readLine();
      String[] transporte = null;
      transporte = linea.split(",");

      //recorre el arreglo
      for (int i = 0; i < transporte.length; i++) {
        System.out.println(transporte[i]);
      }
      //-----------------------------------------------------------------

      //Segunda linea, contiene vehiculos particulares
      linea = br.readLine();
      String[] particulares = null;
      particulares = linea.split(",");

      //recorre el arreglo
      for (int i = 0; i < particulares.length; i++) {
        System.out.println(particulares[i]);
      }

      //Tercer linea, contiene vehiculos de carga
      linea = br.readLine();
      String[] carga = null;
      carga = linea.split(",");

      //recorre el arreglo
      for (int i = 0; i < carga.length; i++) {
        System.out.println(carga[i]);
      }


      fr.close();
      br.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }







  }//fin public static void main(String[] args) {
}//Fin public class Main {


