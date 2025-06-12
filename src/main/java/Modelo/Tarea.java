package Modelo;

/**
 * Representa una tarea individual del usuario.
 */
public class Tarea {
    private String descripcion;
    private String priority;

    /**
     * Constructor que inicializa la descripción de la tarea.
     *
     * @param descripcion contenido de la tarea
     */
    public Tarea(String descripcion, String priority) {
        this.descripcion=descripcion;
        this.priority=priority.toLowerCase();
        // TODO: Inicializar descripción
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPriority(){
        switch (priority){
            case "alta":return 1;
            case "media":return 2;
            case "baja":return 3;
            default:return 4;
        }
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPriority(String priority){
        this.priority=priority;
    }
}
