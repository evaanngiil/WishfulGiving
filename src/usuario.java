import java.util.ArrayList;

public class Usuario { 
    private String nombre;
    private ArrayList<Producto> listaDeseos;

    public Usuario(String nombre) {
        validarUsuario(nombre);
        this.nombre = nombre;
        this.listaDeseos = new ArrayList<Producto>();	
    }

    // Método de validación para Usuario
    private void validarUsuario(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del usuario no puede ser nulo o vacío.");
        }
    }
}
