package Modelo;

import Modelo.Login;
import Modelo.SesionActiva;
import Modelo.DatosLogin;

import java.io.IOException;
import java.util.Scanner;

/**
 * Vista principal del sistema.
 * Interactúa con el usuario mediante consola.
 */
public class ConsolaLogin {
    private final Scanner scanner = new Scanner(System.in);
    private final DatosLogin datos = new DatosLogin();
    private final Login login =new Login();

    public ConsolaLogin() throws IOException {
    }

    /**
     * Controla el ciclo principal del menú del sistema.
     */
    public void menu() throws IOException {
        mostrarOpciones();
        ejecutar();
        // TODO: Mostrar opciones en un bucle con switch.
        // TODO: Permitir iniciar sesión o salir del sistema.
    }

    private void ejecutar() throws IOException {
        int opcion= scanner.nextInt();
        switch(opcion) {
            case 1:
                manejarLogin();
            case 2:
                break;
            default:
                System.out.println("Error de input");
        }

    }

    /**
     * Solicita usuario y contraseña y maneja la autenticación.
     */
    private void manejarLogin() throws IOException {
        System.out.println("diga su usuario");
        String usuario=scanner.nextLine();
        System.out.println("Proporcione contraseña");
        String password= scanner.nextLine();
        if (login.autenticar(usuario, password)){
            System.out.println("Identidad confirmada");
        } else {
            System.out.println("Error de usuario o contraseña");
        }
        // TODO: Pedir usuario y contraseña.
        // TODO: Llamar a login.autenticar().
        // TODO: Si es correcto, iniciar SesionActiva.
    }

    /**
     * Muestra el menú principal.
     */
    private void mostrarOpciones() {
        System.out.println("Bienvenido al menu");
        System.out.println("1-Iniciar session");
        System.out.println("2-Salir");
        // TODO: Imprimir menú "1. Iniciar sesión", "2. Salir".
    }
}