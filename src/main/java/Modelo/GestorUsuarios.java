package Modelo;

import java.io.*;

/**
 * Registra nuevos usuarios en login.txt.
 */
public class GestorUsuarios {
    private final String archivo = "login.txt";

    public GestorUsuarios() throws IOException {
        File archivo = new File("login.txt");
        if (archivo.exists() && archivo.isFile()) {
            System.out.println("Archivo verificado");
        } else {
            archivo.createNewFile();
            System.out.println("Archivo creado con exito");
        }
        // TODO: Verificar existencia del archivo y crearlo si no existe.
        // TODO: Crear archivo si no existe.
    }

    public boolean usuarioExiste(String user){
        try(BufferedReader br =new BufferedReader(new FileReader(archivo))){
            String linea;
            while ((linea=br.readLine())!=null){
                if (linea.startsWith(user+";")){
                    return (true);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
        }
        return (false);
    }

    public boolean registrar(String user, String clave, String correo, String fecha) {
        if (usuarioExiste(user)){
            return(false);
        } else{
        String linea=user+";"+clave+";"+correo+";"+fecha+";";
        try(FileWriter writer =new FileWriter(archivo)){
            writer.write(linea);
            System.out.println("Usuario registrado");
            return (true);
        } catch (IOException e) {
            System.out.println("Error al ingresar datos");
            return (false);
        }
        // TODO: Agregar usuario al archivo login.txt.
    }
}}