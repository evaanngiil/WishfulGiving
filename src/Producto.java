public class Producto {
    private final String nombre;
    private final double precio;  
    
    public Producto(String nombre, double precio) {
        validarProducto(nombre, precio);
        this.nombre = nombre.trim();
        this.precio = precio;
    }

    // Método de validación para Producto
    private void validarProducto(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del producto no puede ser nulo o vacío.");
        }
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio del producto debe ser mayor a cero.");
        }
    }
}

