import java.util.ArrayList;

public class ListaRegalos {
    private final String destinatario;
    private final float presupuesto;
    private final ArrayList<Regalo> regalos;

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
}
