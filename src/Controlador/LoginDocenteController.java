package Controlador;

import Modelo.Seguridad;

public class LoginDocenteController {
    //Asignando espacio de memoria

    Seguridad VerificarLista = new Seguridad();

    public void RecibirDatos(String user, String contraseña) {
        
        VerificarLista.ValidarEnListaDocentes(user, contraseña);
    }

}
