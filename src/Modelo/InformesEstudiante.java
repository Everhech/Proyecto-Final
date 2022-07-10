/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vista.InformeGeneral;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Administrador
 */
public class InformesEstudiante {

    static int lineasTotales;
    static int totalCoincidencias;

    public void InformeGeneral() {
        JOptionPane.showMessageDialog(null, "Todavia no implementado");
    }

    public void InformeDetallado(String Identificacion) {
        try {
            String Estudiante, IdNotas, materia, EstadoMateria, cadena = "";
            Identificacion = buscarPalabra();
            //Asignando espacio de memoria al archivo txt
            //File archivo = new File("NotasEstudiantes.txt");
            // Asignando espacio de memoria al Scanner
            //        Scanner sc = new Scanner(System.in);
            // PALABRA A BUSCAR EN EL TECLADO
//            System.out.print("Informe del estudiante identificado con C.C. : " + Identificacion);
//            String palabra = Identificacion;
//            System.out.println("");
            // LLAMADA AL METODO PARA LEER EL ARCHIVO Y HACER LA BUSQUEDA
            // buscarPalabra(archivo, Identificacion);
            FileReader frI, frN = null;
            String lineaE, lineaN;

            File archivoDatos = new File("DatosEstudiantes.txt");
            frI = new FileReader(archivoDatos);
            BufferedReader br = new BufferedReader(frI);
            File archivoNotas = new File("NotasEstudiantes.txt");
            frN = new FileReader(archivoNotas);
            BufferedReader brN = new BufferedReader(frN);
            try {
                while ((lineaE = br.readLine()) != null) {
                    String[] IdEstudiante = lineaE.split(",");
                    //Estudiante = IdEstudiante[0];
                    while ((lineaN = brN.readLine()) != null) {
                        String[] Estado = lineaN.split(",");
                        IdNotas = Estado[0];
                        materia = Estado[5];
                        for (int i = 0; i < Estado.length; i++) {
                            if (Estado[i].equals(Identificacion)) {
                                if (Double.parseDouble(Estado[4]) >= 3.0) {
                                    EstadoMateria = "Aprovado";
                                } else {
                                    EstadoMateria = "No Aprovado";
                                }
                                cadena = "Materia: " + materia + "\nEstudiante: " + IdEstudiante[1] + " \nNotas: \nNota 1: " + Estado[1] + " \nNota 2: " + Estado[2] + " \nNota 3: " + Estado[3] + " \nNota Final: " + Estado[4] + "\nEstado de Materia: " + EstadoMateria;
                                JOptionPane.showMessageDialog(null, cadena, "Informe Detallado", WIDTH);
                            }
                        }
                    }
                    brN.close();
                    frN.close();

                    frI.close();
                    br.close();

                }
            } catch (IOException ex) {
                Logger.getLogger(InformeGeneral.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InformesEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String buscarPalabra() {
        String palabra;
        palabra = JOptionPane.showInputDialog(null, "Digite su identificacion: ", "Buscar Informe", WIDTH);
        return palabra;
    }
}
