public class Regalo {
    private final String nombre;
    private final double precio;
    private final int prioridad;

    public Regalo(String nombre, double precio, int prioridad;) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del regalo no puede estar vacío.");
        }
        if (precio < 0) {
            throw new IllegalArgumentException("El precio del regalo debe ser un valor positivo.");
        }
        if (prioridad < 1 || prioridad > 5) {
                throw new IllegalArgumentException("La prioridad debe estar entre 1 y 5.");
        }
        this.nombre = nombre;
        this.precio = precio;
        this.prioridad = prioridad;
    }
}
