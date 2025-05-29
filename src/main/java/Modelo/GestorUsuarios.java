package Modelo;

import java.io.*;

/**
 * Registra nuevos usuarios en login.txt.
 */
public class GestorUsuarios {
    private final String archivo = "login.txt";
    private final String ruta="/home/jf/IdeaProjects/SistemaLogin/src/main/java/Modelo";

    public GestorUsuarios() throws IOException {
        File archivo = new File(ruta + File.separator + "login.txt");
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

    public boolean registrar(String user, String clave) {
        if (usuarioExiste(user)){
            return(false);
        } else{
        String linea=user+";"+clave+";";
        try(FileWriter writer =new FileWriter(ruta,true)){
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