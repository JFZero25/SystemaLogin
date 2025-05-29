package Modelo;

import Modelo.DatosLogin;

import java.io.IOException;

/**
 * Clase encargada de la lógica de autenticación.
 */
public class Login {

    /**
     * Verifica si las credenciales son válidas.
     *
     * @param usuario nombre ingresado
     * @param clave contraseña ingresada
     * @return true si son válidas, false si no
     */
    static boolean autenticar(String usuario, String clave) throws IOException {
        String intento=usuario+";"+clave+";";
        DatosLogin datos=new DatosLogin();
        for (String linea : datos.getCredenciales()) {
            if (linea.equals(intento)) {
                return true;
            }
        }
        return false;
    }
}