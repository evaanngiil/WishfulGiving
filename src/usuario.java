public class Usuario { 
    private String nombre;
    private ListaDeseos listaDeseos;    

    public Usuario( String nombre, ListaDeseos listaDeseos) {
        validarUsuario(nombre, listaDeseos);
        this.id = id;
        this.nombre = nombre.trim();
        this.listaDeseos = listaDeseos():
    }

    // Método de validación para Usuario
    private void validarUsuario(String nombre, ListaDeseos listaDeseos) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del usuario no puede ser nulo o vacío.");
        }
	    if (listaDeseos == null) {
            throw new IllegalArgumentException("La lista de deseos no puede ser nula.");
        }
        
    }
}
