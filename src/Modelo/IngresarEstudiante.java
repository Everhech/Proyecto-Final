/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class IngresarEstudiante {
    
    //Asignando espacio de memoria
    File archivo; // Variable para manipular el archivo
    FileWriter escribir;// Escribir en el archivo
    PrintWriter linea; // Escribir en el archivo

    public void RegistrarEstudiante(String identificacion, String nombres, String apellidos, String password) {
        
        archivo = new File ("DatosEstudiantes.txt");
        //Creamos un if para que cree el archivo y sino que use el archivo ya creado
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                escribir = new FileWriter(archivo);
                linea = new PrintWriter(escribir);
                linea.println(identificacion + "," + nombres + "," + apellidos + "," + password);
                String cadena = "El estudiante " + nombres + " " +apellidos +"\nIdentificado con cedula numero: "+ identificacion+"\nHa sido registrado con exito" ;
                JOptionPane.showMessageDialog(null, cadena , "Resultado De La Operacion", 1);
                linea.close();
                escribir.close();
            } catch (IOException ex) {
                Logger.getLogger(IngresarEstudiante.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                escribir = new FileWriter(archivo, true);
                linea = new PrintWriter(escribir);
                linea.println(identificacion + "," + nombres + "," + apellidos + "," + password);
                String cadena = "El estudiante " + nombres + " " +apellidos +"\nIdentificado con cedula numero: "+ identificacion+"\nHa sido registrado con exito" ;
                JOptionPane.showMessageDialog(null, cadena , "Resultado De La Operacion", 1);
                linea.close();
                escribir.close();
            } catch (IOException ex) {
                Logger.getLogger(IngresarEstudiante.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
