package Modelo;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Vista.OpcionesEstudiante;
import Vista.OpcionesDocente;

public class Seguridad {

    String[] docentes = null;
    private static int intentos = 0;
    boolean iniciar=false;
//Metodo que nos lee el archivo txt y lo almacena para luego validarlo

    public boolean ValidarEnListaDocentes(String Usuario, String Password) {
        try {
            FileReader fr = null;
            String cadena = "";
            boolean encontrado = false;
            String linea; //Necesario para leer las comas
            
            File f = new File("Docentes.txt");
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                String[] contacto = linea.split(","); //Almacena informacion en comas
                //Se iguala para saber si existe
                if (Usuario.equalsIgnoreCase(contacto[0]) && Password.equals(contacto[1])) {
                    cadena = "Ha ingresado como Docente: " + "\nBienvenido: " + Usuario;
                    JOptionPane.showMessageDialog(null, cadena, "Inicio de sesion", JOptionPane.INFORMATION_MESSAGE);
                    intentos = 0;
                    encontrado = true; iniciar=true;
                    OpcionesDocente AbrirDocenteOpciones = new OpcionesDocente();
                    AbrirDocenteOpciones.setLocationRelativeTo(AbrirDocenteOpciones);
                    AbrirDocenteOpciones.setVisible(true);
                    break;
                }
            }
            intentos++;
            if (encontrado == false) {
                iniciar=false;
                setIntentos(intentos);
                cadena = "Clave y/o Contraseña Inconrrecta. LLeva usted: " + intentos + " intentos fallidos";
                JOptionPane.showMessageDialog(null, cadena, "Inicio de Sesion", JOptionPane.ERROR_MESSAGE);
            }
            if (intentos > 2) {
                cadena = "Limite de intentos alcanzado. Ha finalizado el programa";
                JOptionPane.showMessageDialog(null, cadena, "Inicio de sesion", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        } catch (IOException ex) {
            Logger.getLogger(Seguridad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return iniciar;
    }

    public boolean ValidarEnListaEstudiantes(String Usuario, String Password) {
        try {
            FileReader fr = null;
            String cadena = "";
            boolean encontrado = false;
            String linea;

            File f = new File("DatosEstudiantes.txt");
            fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            while ((linea = br.readLine()) != null) {
                String[] contacto = linea.split(",");
                if (Usuario.equalsIgnoreCase(contacto[1]) && Password.equals(contacto[3])) {
                    cadena = "Ha ingresado como Estudiante: " + "\nBienvenido: " + Usuario;
                    JOptionPane.showMessageDialog(null, cadena, "Inicio de sesion", JOptionPane.INFORMATION_MESSAGE);
                    intentos = 0;
                    encontrado = true; iniciar=true;
                    OpcionesEstudiante AbrirEstudianteOpciones = new OpcionesEstudiante();
                    AbrirEstudianteOpciones.setLocationRelativeTo(AbrirEstudianteOpciones);
                    AbrirEstudianteOpciones.setVisible(true);
                    break;
                }
            }
            intentos++;
            if (encontrado == false) {
                setIntentos(intentos);
                iniciar = false;
                cadena = "Clave y/o Contraseña Inconrrecta. LLeva usted: " + intentos + " intentos fallidos";
                JOptionPane.showMessageDialog(null, cadena, "Inicio de Sesion", JOptionPane.ERROR_MESSAGE);
            }
            if (intentos > 2) {
                cadena = "Limite de intentos alcanzado. Ha finalizado el programa";
                JOptionPane.showMessageDialog(null, cadena, "Inicio de sesion", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        } catch (IOException ex) {
            Logger.getLogger(Seguridad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return iniciar;
    }   

    //Getters and Setters
    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }
}
