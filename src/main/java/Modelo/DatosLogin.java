package Modelo;

import java.io.*;
import java.util.ArrayList;
import java.io.File;

/**
 * Gestiona el archivo login.txt.
 */
public class DatosLogin {
    private final ArrayList<String> credenciales = new ArrayList<>();

    public DatosLogin() throws IOException {
        crearArchivoSiNoExiste();
        cargarUsuarios();
    }

    /**
     * Devuelve la lista de credenciales cargadas.
     */
    public ArrayList<String> getCredenciales() {
        return credenciales;
    }

    /**
     * Crea el archivo login.txt si no existe.
     */
    private void crearArchivoSiNoExiste() throws IOException {
        File archivo = new File( "login.txt");
        if (archivo.exists() && archivo.isFile()) {
            System.out.println("Archivo verificado");
        } else {
            archivo.createNewFile();
            System.out.println("Archivo creado con exito");
        }
        // TODO: Verificar existencia del archivo y crearlo si no existe.
    }

    /**
     * Carga los pares usuario;clave desde el archivo a la lista.
     */
    private ArrayList<String> cargarUsuarios() {
        try (BufferedReader br = new BufferedReader(new FileReader("login.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (!linea.isEmpty() && linea.endsWith(";")) {
                    credenciales.add(linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
        return credenciales;
    }
    // TODO: Leer línea por línea y agregar solo las válidas al ArrayList.
}