package WishfulGiving;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Regalo {
    private String titulo;
    private String descripcion;
    private double precio;
    private int prioridad;
    
    // Constructor por defecto para Jackson (instanciar objeto con JSON)
    public Regalo() {}
    
    @JsonCreator
    public Regalo(@JsonProperty("titulo") String titulo,
            @JsonProperty("descripcion") String descripcion,
            @JsonProperty("precio") double precio,
            @JsonProperty("prioridad") int prioridad) {
        if (titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException("El titulo del regalo no puede estar vacío.");
        }
        if (descripcion == null || descripcion.isEmpty()) {
            throw new IllegalArgumentException("La descripcion del regalo no puede estar vacía.");
        }
        if (precio < 0) {
            throw new IllegalArgumentException("El precio del regalo debe ser un valor positivo.");
        }
        if (prioridad < 1 || prioridad > 5) {
                throw new IllegalArgumentException("La prioridad debe estar entre 1 y 5.");
        }
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.prioridad = prioridad;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public int getPrioridad() {
        return prioridad;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
}
