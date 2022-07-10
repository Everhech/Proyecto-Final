package Controlador;

import Modelo.ListaAlumnos;

/**
 *
 * @author Administrador
 */
public class ListaAlumnosController {

    ListaAlumnos AbrirListaAlumnos = new ListaAlumnos();

    public void AccederModelo() {
        AbrirListaAlumnos.LeerListaAlumnos();
    }
}
