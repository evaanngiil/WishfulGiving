package WishfulGiving;

public class Regalo {
    private String titulo;
    private String descripcion;
    private double precio;
    private int prioridad;
    
    private static final int PRIORIDAD_MAX = 5;
    private static final int PRIORIDAD_MIN = 1;
    private static final int PRECIO_MIN = 0;
    
    public Regalo() {}
    
    public Regalo( String titulo,
            String descripcion,
             double precio,
             int prioridad) {
        if (titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException("El titulo del regalo no puede estar vacío.");
        }
        if (descripcion == null || descripcion.isEmpty()) {
            throw new IllegalArgumentException("La descripcion del regalo no puede estar vacía.");
        }
        if (precio < PRECIO_MIN) {
            throw new IllegalArgumentException("El precio del regalo debe ser un valor positivo.");
        }
        if (prioridad < PRIORIDAD_MIN || prioridad > PRIORIDAD_MAX) {
            throw new IllegalArgumentException("La prioridad debe estar entre " + PRIORIDAD_MIN + " y " + PRIORIDAD_MAX + ".");        }
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.prioridad = prioridad;
    }
    
    /**
     * Calcula la relación entre la prioridad y el precio del regalo.
     * @return Relación prioridad/precio.
     */
    public double getRelacionPrioridadPrecio() {
        return prioridad / precio;
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
