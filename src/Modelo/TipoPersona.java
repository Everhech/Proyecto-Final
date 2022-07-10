package Modelo;

import Vista.SeleccionTipoPersona;

/**
 *
 * @author Administrador
 */
public class TipoPersona {

    SeleccionTipoPersona Seleccion = new SeleccionTipoPersona();

    public void IniciarTipoPersona() {
        Seleccion.setVisible(true);
    }

    public void CerrarTipoPersona() {
        //Seleccion.setVisible(false);
        Seleccion.dispose();
    }
}
