public class Producto {
    private final String nombre;

    public Producto(String nombre) {
        validarProducto(nombre);

        this.nombre = nombre.trim();
    }

    // Método de validación para Producto
    private void validarProducto(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del producto no puede ser nulo o vacío.");
        }
    }
}

