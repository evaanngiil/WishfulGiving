import java.util.ArrayList;

public class ListaRegalos {
    private final String destinatario;
    private final float presupuesto;
    private final ArrayList<ElementoLista> regalos;

    public ListaRegalos(String destinatario, float presupuesto) {
        if (destinatario == null || destinatario.isEmpty()) {
            throw new IllegalArgumentException("El nombre del destinatario no puede estar vacío.");
        }
        if (presupuestoTotal < 0) {
            throw new IllegalArgumentException("El presupuesto debe ser un valor positivo.");
        }
        this.destinatario = destinatario;
        this.presupuesto = presupuesto;
        this.regalos = new ArrayList<>();
    }

    public static class ElementoLista {
        private final Regalo regalo;
        private final int prioridad;

        public ElementoLista(Regalo regalo, Prioridad prioridad) {
            if (regalo == null || prioridad == null) {
                throw new IllegalArgumentException("El regalo y la prioridad no pueden ser nulos.");
            }
            if (prioridad < 1 || prioridad > 5) {
                throw new IllegalArgumentException("La prioridad debe estar entre 1 y 5.");
            }
            this.regalo = regalo;
            this.prioridad = prioridad;
        }
    }
}
