package Modelo;

import Modelo.DatosSesion;
import Modelo.GestorUsuarios;
import Modelo.Usuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Representa la sesión de un usuario logueado.
 */
public class SesionActiva {
    private final Usuario usuario;
    private final Tarea tasks;
    private final Scanner scanner = new Scanner(System.in);
    private final DatosSesion datosSesion;
    private final GestorUsuarios gestorUsuarios;
    private final DatosLogin datosLogin;

    public SesionActiva(Tarea tasks, Usuario usuario) throws IOException {
        this.tasks = tasks;
        this.datosSesion = new DatosSesion(usuario.getNombre());
        this.gestorUsuarios=new GestorUsuarios();
        this.datosLogin=new DatosLogin();
        this.usuario=usuario;
    }

    /**
     * Ciclo de operaciones disponibles en sesión.
     */
    public void menuSesion() {
        boolean admin=check(usuario, datosLogin);
        if (admin) {
            mostrarOpcionesAdmin();
            ejecutarAdmin();
        } else {
            mostrarOpciones();
            ejecutar();
        }

        // TODO: Mostrar opciones según si el usuario es admin o no.
        // TODO: Escribir tareas.
        // TODO: Registrar usuarios (solo admin).
        // TODO: Salir de sesión.
    }

    private boolean check(Usuario usuario, DatosLogin datos) {
        ArrayList<String> credenciales = datos.getCredenciales();
        for (String linea : credenciales) {
            String[] partes = linea.split(";");
            if (partes.length >= 2 && partes[0].equals(usuario.getNombre())) {
                String clave = partes[1];
                return partes[0].equalsIgnoreCase("admin") && clave.equals("1234");
            }
        } return false;
    }

    private void mostrarOpciones() {
        System.out.println("1-Registrar tarea");
        System.out.println("2-Salir");
    }

    private void mostrarOpcionesAdmin() {
        System.out.println("1-Registrar tarea");
        System.out.println("2-Agregar usuario");
        System.out.println("3-Salir");
    }

    private void ejecutar() {
        int opcion= scanner.nextInt();
        switch(opcion) {
            case 1:
                escribirTarea();
            case 2:
                break;
            default:
                System.out.println("Error de input");
    }}

    private void ejecutarAdmin() {
            int opcion= scanner.nextInt();
            switch(opcion) {
                case 1:
                    escribirTarea();
                case 2:
                    registrarUsuario();
                case 3:
                    break;
                default:
                    System.out.println("Error de input");
        }}

    private void escribirTarea() {
                String tarea= scanner.nextLine();
                tasks.setDescripcion(tarea);
                datosSesion.escribirTarea(tarea);
                datosSesion.mostrarTareas();
        // TODO: Pedir tarea al usuario y delegar a datosSesion.
    }

    private void registrarUsuario() {
                System.out.println("Proporcione el usuario");
                String user=scanner.nextLine();
                System.out.println("Proporcione contraseña");
                String clave=scanner.nextLine();
                gestorUsuarios.registrar(user,clave);
                usuario.setClave(clave);
        // TODO: Usar GestorUsuarios para registrar un nuevo usuario.
    }
}