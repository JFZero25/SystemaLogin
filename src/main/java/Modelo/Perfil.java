package Modelo;

import java.util.ArrayList;

public class Perfil {
    private String user;
    private String correo;
    private String date;

    public Perfil(String user){
        this.user=user;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCorreo(){
        return(correo);
    }

    public String getDate(){
        return (date);
    }

    public ArrayList<String> getPerfil(){
        ArrayList<String> regresar=new ArrayList<>();
        regresar.add(correo);
        regresar.add(date);
        return (regresar);
    }
}
