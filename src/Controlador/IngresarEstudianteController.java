/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.IngresarEstudiante;

/**
 *
 * @author Administrador
 */
public class IngresarEstudianteController {
    
    public void RecibirDatos(String identificacion,String Nombres,String Apellidos,String Password){
        IngresarEstudiante IngresarEstudianteModelo = new IngresarEstudiante();
        IngresarEstudianteModelo.RegistrarEstudiante(identificacion, Nombres, Apellidos, Password);
    }
    
}
