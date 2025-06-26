package Modelo;

import java.io.*;

/**
 * Maneja las tareas personales de un usuario autenticado.
 */
public class DatosSesion {
    private final String nombreArchivo;
    String ruta="/home/jf/IdeaProjects/SistemaLogin/src/main/java/Modelo";

    public DatosSesion(String usuario) throws IOException {
        this.nombreArchivo = usuario + "tareas.txt";
        crearArchivoSiNoExiste();
    }

    /**
     * Crea el archivo de tareas si no existe.
     */
    private void crearArchivoSiNoExiste() throws IOException {
        File archivo = new File(ruta + File.separator + nombreArchivo);
        if (archivo.exists() && archivo.isFile()) {
            System.out.println("Archivo verificado");
        } else {
            archivo.createNewFile();
            System.out.println("Archivo creado con exito");
        }
        // TODO: Verificar existencia del archivo y crearlo si no existe.
    }

    /**
     * Escribe una nueva tarea al final del archivo.
     *
     * @param tarea Texto de la tarea.
     * @return true si se guardó correctamente, false si ocurrió un error.
     */
    public void escribirTarea(String tarea, String prior) {
        String linea=tarea+";"+prior+";";
        try(FileWriter writer =new FileWriter(ruta+File.separator+nombreArchivo,true)){
            writer.write(linea);
        } catch (IOException e) {
            System.out.println("Error al ingresar datos");
        }
        // TODO: Implementar escritura en el archivo.
    }

    /**
     * Muestra todas las tareas almacenadas en el archivo.
     */
    public void mostrarTareas() {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            System.out.println("Contenido del archivo:");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        // TODO: Leer y mostrar cada línea del archivo.
    }
}