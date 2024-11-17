public class ElementoLista {
    private final long id;
    private Producto producto;

    public ElementoLista(long id, Producto producto) {
        validarElementoLista(id, producto);
        this.id = id;
        this.producto = producto;
    }

    // Método de validación para ElementoDeseo
    private void validarElementoLista(long id, Producto producto) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El id del elemento no puede ser nulo y deber ser mayor a cero.");
        }
        if (producto == null) {
            throw new IllegalArgumentException("El elemento debe tener un producto.");
        }
    }
}