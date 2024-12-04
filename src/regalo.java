public class Regalo {
    private final String titulo;
    private final String descripcion;
    private final double precio;
    private final int prioridad;

    public Regalo(String titulo, String descripcion, double precio, int prioridad;) {
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
}
