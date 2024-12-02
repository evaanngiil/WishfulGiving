public class Regalo {
    private final String nombre;
    private final double precio;

    public Regalo(String nombre, double precio) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del regalo no puede estar vacío.");
        }
        if (precio < 0) {
            throw new IllegalArgumentException("El precio del regalo debe ser un valor positivo.");
        }
        this.nombre = nombre;
        this.precio = precio;
    }
}
