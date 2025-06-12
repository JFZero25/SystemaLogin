package Modelo;

import java.util.ArrayList;

/**
 * Clase que representa a un usuario del sistema.
 */
public class Usuario {
    private String nombre;
    private String clave;
    private Perfil perfil;

    /**
     * Constructor que inicializa los atributos del usuario.
     *
     * @param nombre nombre del usuario
     * @param clave clave del usuario
     */
    public Usuario(String nombre, String clave) {
        this.nombre=nombre;
        this.clave=clave;
        this.perfil= new Perfil(nombre);
        // TODO: Inicializar atributos nombre y clave
    }

    public String getNombre() {
        return nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public ArrayList<String> getPerfil(){
        ArrayList<String> info= perfil.getPerfil();
        return (info);
    }
}