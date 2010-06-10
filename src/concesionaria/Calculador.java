package concesionaria;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JOptionPane;

//Esta clase realiza lectura y escritura de archivos 
public class Calculador {

    //Estos HashMaps se poblaran inicialmente con contenidos de varios
    //archivo.txt
    private HashMap diccionario_vehiculos = new HashMap();
    //coeficientes.txt
    private HashMap diccionario_coeficientes = new HashMap();




    /*Este es el constructor. Es un metodo que se dispara automaticamente
    durante la instancia de cualquier objeto de tipo Calculador */
    public Calculador() {
        /**
         * ===============================================================
         * Comienza lectura del archivo que contiene los impuestos y las
         * utilidades de cada vehiculo.
         * ===============================================================
         * Cuidado: este archivo debe esta ubicado en la raiz del proyecto,
         * no en src/concecionaria
         *
         * Contiene una información del tipo
         * 3010.30,41.5
         * 728.25,30.44
         * 2100.50,21.5
         *
         * Es decir,
         * primer linea: Transporte: 3010.30 de Impuestos al año, 41.5% de utilidades
         * segunda linea, particular: 728.25 de Impuestos al año, 30.44% de utilidades
         * tercer linea, carga: 2100.50 de Impuestos al año, 21.5% de utilidades
         */
        File archivo_vehiculos = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo_vehiculos = new File("archivo.txt");
            fr = new FileReader(archivo_vehiculos);
            br = new BufferedReader(fr);

            //linea leera lineas completas
            String linea;

            //enPedacitos recibirá las partes de esa linea que esten entre ,
            String[] enPedacitos = null;

            // Lectura del archivo:

            //-----------------------------------------------------------------
            //Primer linea, contiene vehiculos de transporte
            linea = br.readLine();//enlinea obtiene la primer linea

            //enPedacitos recibe cada unas de las palabras que estaban separadas x una ,
            //Quien le proporciona cada una, es split (separar)
            enPedacitos = linea.split(",");

            /*Si quisiera pasear por cada una de las palabras de enPedacitos:
            for (int i = 0; i < enPedacitos.length; i++) {
            System.out.println(enPedacitos[i]);
            } */

            //Ponemos (put) dentro de diccionario_vehiculos el valor que nos interesa.
            //Para encontrarlo mas tarde, le ponemos una palabra que lo identifique

            //Aqui es interesante observar el contenido del objeto diccionario_vehiculos usando
            //la ejecución Paso a Paso (F7)
            diccionario_vehiculos.put("transporte-impuestos", new Double(enPedacitos[0]));
            diccionario_vehiculos.put("transporte-utilidades", new Double(enPedacitos[1]));

            //-----------------------------------------------------------------
            //Segunda linea del archivo

            /*Si volvemos a ejecutar la proxima instrucción, el puntero al archivo (br)
            se trasladará a la siguiente linea del archivo, la que contiene los
            datos de los vehiculos particulares
             */
            linea = br.readLine();

            //Sobreescribimos la información que hay enPedacitos. Al fin y al cabo está
            //guardada en el diccionario_vehiculos
            enPedacitos = linea.split(",");

            //Seguimos alimentando nuestro diccionario_vehiculos, con palabras nuevas
            diccionario_vehiculos.put("particulares-impuestos", new Double(enPedacitos[0]));
            diccionario_vehiculos.put("particulares-utilidades", new Double(enPedacitos[1]));

            //-----------------------------------------------------------------
            //Tercer linea del archivo

            /*Si volvemos a ejecutar la proxima instrucción, el puntero al archivo (br)
            se trasladará a la siguiente linea del archivo, la que contiene los
            datos de los vehiculos particulares
             */
            linea = br.readLine();

            //Sobreescribimos la información que hay enPedacitos. Al fin y al cabo está
            //guardada en el diccionario_vehiculos
            enPedacitos = linea.split(",");

            //Seguimos alimentando nuestro diccionario_vehiculos, con palabras nuevas
            diccionario_vehiculos.put("carga-impuestos", new Double(enPedacitos[0]));
            diccionario_vehiculos.put("carga-utilidades", new Double(enPedacitos[1]));

            //Pongo a salvo el archivo contra cuelgues o caidas del sistema.
            //Si toda su información esta en RAM, no tiene sentido que siga abierto
            fr.close();
            br.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
         * ===============================================================
         * FIN lectura del archivo que contiene los impuestos y las
         * utilidades de cada vehiculo.
         * ===============================================================
         */



        /* ===============================================================
         * Comienza lectura del archivo que contiene los coeficientes
         * ===============================================================
         * Cuidado: este archivo, llamado coeficientes.txt debe esta ubicado en
         * la raiz del proyecto, no en src/concesionaria
         *
         * Contiene una información del tipo
         * 1965,1
         * 1966,2
         * ...
         * etc
         *
         * Es decir, mientras mas nuevo es el vehiculo, mas paga de impuesto.
         * Este valor cambia segun el pais: en USA es al reves, debido a la
         * contaminación que generan los autos viejos
         */


        File archivo_coeficientes = null;
        FileReader fr2 = null;
        BufferedReader br2 = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo_coeficientes = new File("coeficientes.txt");
            fr2 = new FileReader(archivo_coeficientes);
            br2 = new BufferedReader(fr2);

            //Linea leera lineas completas
            String linea;

            //enPedacitos recibirá las partes de esa linea que esten entre ,
            String[] enPedacitos = null;

            /*
             * Cualquiera sea el tipo de vehículo, el calculo del precio de venta se realiza mediante el siguiente método:
            Precio Venta = Precio de Fabrica * 1.21 + Utilidad + Impuestos

            Los impuestos  se obtienen de una tabla (archivo.txt) que contiene los valores correspondientes a cada tipo de vehículo. Estos valores deben poder modificarse si es necesario.

            Las utilidades  se obtienen de una tabla (archivo.txt) que contiene los valores correspondientes a cada marca de vehículo. Estos valores deben poder modificarse si es necesario.
             */


            // Lectura del archivo:
            //-----------------------------------------------------------------
            //Recorremos todo el archivo, mientras sea distinto de nulo
            while ((linea = br2.readLine()) != null) {
                enPedacitos = linea.split(",");

                /*Los diccionarios requieren de dos parametros: un valor (distinto)
                 * para encontrar univocamente el dato, y el dato en sí mismo).
                 * En este caso, podemos ocupar el año, que sabemos que no está repetido,
                 * como valor "llave" para encontrar un coeficiente en particular.
                 */
                this.diccionario_coeficientes.put(new Integer(enPedacitos[0]), new Integer(enPedacitos[1]));
            }

            //Pongo a salvo el archivo contra cuelgues o caidas del sistema.
            //Si toda su información esta en RAM, no tiene sentido que siga abierto
            fr2.close();
            br2.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
         * ===============================================================
         * FIN lectura del archivo que contiene los coeficientes.
         * ===============================================================
         */





    }//fin public static void main(String[] args) {

    /**
     * @return the diccionario_vehiculos
     */
    public HashMap getDiccionario_vehiculos() {
        return diccionario_vehiculos;
    }

    /**
     * @param diccionario_vehiculos the diccionario_vehiculos to set
     */
    public void setDiccionario_vehiculos(HashMap diccio) {
        //copio el nuevo diccionario sobre el viejo
        this.diccionario_vehiculos = diccio;

        //Actualizo el archivo.txt
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("archivo.txt", false));

            out.write(this.diccionario_vehiculos.get("transporte-impuestos") + ","
                    + this.diccionario_vehiculos.get("transporte-utilidades") + "\n");
            out.write(this.diccionario_vehiculos.get("particulares-impuestos") + ","
                    + this.diccionario_vehiculos.get("particulares-utilidades") + "\n");
            out.write(this.diccionario_vehiculos.get("carga-impuestos") + ","
                    + this.diccionario_vehiculos.get("carga-utilidades") + "\n");

            /*
            3010.3,41.5
            728.25,30.44
            2100.5,21.5
             */


            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JOptionPane.showMessageDialog(null, "Valores actualizados");
    }

    public HashMap getDiccionario_coeficientes() {
        return diccionario_coeficientes;
    }
}//Fin class


