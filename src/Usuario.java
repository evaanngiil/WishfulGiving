public class Usuario {
    private final long id;  
    private String nombre;
    private ListaDeseos listaDeseos;    

    public Usuario(long id, String nombre, ListaDeseos listaDeseos) {
        validarUsuario(id, nombre, listaDeseos);
        this.id = id;
        this.nombre = nombre.trim();
        this.listaDeseos = listaDeseos():
    }

    // Método de validación para Usuario
    private void validarUsuario(long id, String nombre, ListaDeseos listaDeseos) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El id del usuario no puede ser nulo y deber ser mayor a cero.");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del usuario no puede ser nulo o vacío.");
        }
	    if (listaDeseos == null) {
            throw new IllegalArgumentException("La lista de deseos no puede ser nula.");
        }
        
    }
}
