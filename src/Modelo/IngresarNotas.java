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
public class IngresarNotas {

    //Asignando espacio de memoria
    File archivo;
    FileWriter escribir;// Escribir en el archivo
    PrintWriter linea; // Escribir en el archivo

    double notaFinal = 0;

    public void CalcularNotaFinal(String identificacion, double notaUno, double notaDos, double notaTres, String nombreMateria) {

        notaFinal = ((notaUno + notaDos + notaTres) / 3);
        RegistrarNotas(identificacion, notaUno, notaDos, notaTres, notaFinal, nombreMateria);
    }

    public void RegistrarNotas(String identificacion, double notaUno, double notaDos, double notaTres, double notaFinal, String materia) {
        // Preparando el archivo
        archivo = new File("NotasEstudiantes.txt");
        //Creamos un if para que cree el archivo y sino que use el archivo ya creado
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                //Sirve para escribir en una sola linea
                escribir = new FileWriter(archivo);
                // Sirve para escribir en varias lineas de texto 
                linea = new PrintWriter(escribir);
                linea.println("Identificacion: " + identificacion + " " + "Nota 1:" + notaUno + " " + "Nota Dos: " + notaDos + " " + "Nota 3: " + notaTres + " " + "Nota Final: " + this.notaFinal + " " + "Nombre Materia:" + materia + ",");
                String cadena = "Se han registrado las notas para el estudiante con cedula: " + identificacion + " \nNotas actualizadas de la materia: " + materia;
                JOptionPane.showMessageDialog(null, cadena, "Resultado Del Registro De Notas", 1);
                linea.close();
                escribir.close();

            } catch (IOException ex) {
                Logger.getLogger(IngresarNotas.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                //Sirve para escribir en una sola linea
                escribir = new FileWriter(archivo, true); // el true sirve para que no sobreescriba sobre lo ya escrito
                // Sirve para escribir en varias lineas de texto 
                linea = new PrintWriter(escribir);
                linea.println("Identificacion: " + identificacion + " " + "Nota 1: " + notaUno + " " + "Nota Dos: " + notaDos + " " + "Nota 3: " + notaTres + " " + "Nota Final: " + this.notaFinal + " " + "Nombre Materia:" + materia + ",");
                String cadena = "Se han registrado las notas para el estudiante con cedula: " + identificacion + " \nNotas actualizadas de la materia: " + materia;
                JOptionPane.showMessageDialog(null, cadena, "Resultado Del Registro De Notas", 1);
                linea.close();
                escribir.close();

            } catch (IOException ex) {
                Logger.getLogger(IngresarNotas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
