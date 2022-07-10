/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.IngresarNotas;
public class IngresarNotasController {    
   
    
    public void RecibirDatos(String identificacion,double nota1,double nota2,double nota3,String materia){
       
     IngresarNotas IngresarNotasModelo = new IngresarNotas();
     IngresarNotasModelo.CalcularNotaFinal(identificacion,nota1, nota2, nota3,materia);
    }
    
   
    
}
