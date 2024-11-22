import java.util.ArrayList;

public class ListaDeseos {
    private final long id;
    private ArrayList<Producto> deseos;

    public ListaDeseos() {
        validarListaDeseos(id);
        this.id = id;
        this.deseos = new ArrayList<Producto>();
    }

    private void validarListaDeseos(long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El id de la lista no puede ser nulo y deber ser mayor a cero.");
        }
    }
}
