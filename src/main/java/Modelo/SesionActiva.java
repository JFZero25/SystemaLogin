package Modelo;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Representa la sesión de un usuario logueado.
 */
public class SesionActiva {
    private final Usuario usuario;
    private final ArrayList<Tarea> tasks= new ArrayList<>() ;
    private final Scanner scanner = new Scanner(System.in);
    private final DatosSesion datosSesion;
    private final GestorUsuarios gestorUsuarios;
    private final DatosLogin datosLogin;
    private final LocalDate creacion=LocalDate.now();
    private final String formato=creacion.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    public SesionActiva(Usuario usuario) throws IOException {
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
                break;
            case 2:
                mostrarTarea();
                break;
            case 3:
                break;
            default:
                System.out.println("Error de input");
                break;
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

    private void mostrarTarea(){
        if (tasks.isEmpty()){
            System.out.println("No hay tareas registradas");
            return;
        }
        for (Tarea t:tasks){
            String prioridad=switch (t.getPriority()){
                case 1->"Alta";
                case 2->"Media";
                case 3->"Baja";
                default -> "Desconocida";
            };
            System.out.println("- "+t.getDescripcion()+"(Prioridad: "+t.getPriority()+")");
        }
    }

    private void escribirTarea() {
        System.out.println("Escriba su tarea");
        String tarea= scanner.nextLine();
        System.out.println("Diga si la prioridad de la tarea es alta,media o baja");
        String prior=scanner.nextLine();
        Tarea nueva=new Tarea(tarea,prior);
        tasks.add(nueva);
        datosSesion.escribirTarea(tarea,prior);
        datosSesion.mostrarTareas();
        // TODO: Pedir tarea al usuario y delegar a datosSesion.
    }

    private void registrarUsuario() {
                System.out.println("Proporcione el usuario");
                String user=scanner.nextLine();
                System.out.println("Proporcione contraseña");
                String clave=scanner.nextLine();
                System.out.println("Proporcione su correo");
                String correo=scanner.nextLine();
                gestorUsuarios.registrar(user,clave,correo,formato);
                usuario.setClave(clave);
        // TODO: Usar GestorUsuarios para registrar un nuevo usuario.
    }
}