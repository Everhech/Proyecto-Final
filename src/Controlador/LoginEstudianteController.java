package Controlador;

import Modelo.Seguridad;

public class LoginEstudianteController {

    //Asignando espacio de memoria
    Seguridad VerificarLista = new Seguridad();

    public boolean RecibirDatos(String User, String Contrasena) {
        return VerificarLista.ValidarEnListaEstudiantes(User, Contrasena);
    }
}
