package Modelo;

import Modelo.ConsolaLogin;

import java.io.IOException;

/**
 * Clase principal del sistema.
 * Contiene el método main para lanzar la aplicación.
 */
public class Inicio {
    public static void main(String[] args) throws IOException {
        ConsolaLogin consola = new ConsolaLogin();
        consola.menu();
    }
}