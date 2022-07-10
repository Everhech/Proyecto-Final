/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ListaAlumnos {

    File archivo;
    FileReader leer;
    String cadena;
    BufferedReader almacenamiento;
    String renglon= "";
    
    public void LeerListaAlumnos() {
        try {
            int registro = 1;
            archivo = new File("DatosEstudiantes.txt");
            leer = new FileReader(archivo);
            almacenamiento = new BufferedReader(leer);
            cadena = "";
            
            
            while(cadena!=null){
                try {
                    cadena = almacenamiento.readLine();
                    
                    if (cadena!=null) {
                        System.out.println(cadena);
                        renglon = renglon +cadena + "\n";
//                        JOptionPane.showMessageDialog(null, "cadena:" + cadena + "\nMostrando datos del registro #" + registro);
//                        registro++;
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ListaAlumnos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                almacenamiento.close();//Cerrar BufferReader
                leer.close(); //Cerrar Lector
            } catch (IOException ex) {
                Logger.getLogger(ListaAlumnos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                    } catch (FileNotFoundException ex) {
            Logger.getLogger(ListaAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, renglon, "Mostrando Todos los archivos", 0);
    }

}
