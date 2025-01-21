package WishfulGiving;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ListaRegalosTest {
    
    private static final double PRESUPUESTO_RESTANTE = 10.0;  
    private static final double COSTO_TOTAL_ESPERADO_JUAN = 90.0;
    private static final int SATISFACCION_TOTAL_ESPERADA_JUAN = 9;
    private static final double COSTO_TOTAL_ESPERADO_ANA = 40.0;
    private static final int SATISFACCION_TOTAL_ESPERADA_ANA = 7;
    private static final String TEST_DATA_PATH = "data/test_regalos.txt";
    
    @Test
    void calcularPresupuestoRestante() {
        List<ListaRegalos> listas = ListaRegalos.cargarListasDeTexto(TEST_DATA_PATH);
        ListaRegalos listaAna = listas.get(1);

        double presupuestoRestante = listaAna.calcularPresupuestoRestante();
        assertEquals(PRESUPUESTO_RESTANTE, presupuestoRestante,
                "El presupuesto restante calculado no es el esperado.");
    }

     @Test
    void compararSatisfaccionYCosto() {
        List<ListaRegalos> listas = ListaRegalos.cargarListasDeTexto(TEST_DATA_PATH);
        
        ListaRegalos listaJuan = listas.get(0);
        List<Regalo> regalosSeleccionadosJuan = listaJuan.obtenerRegalosDentroPresupuesto();

        double costoSeleccionadoJuan = regalosSeleccionadosJuan.stream()
                .map(Regalo::getPrecio)
                .reduce(0.0, Double::sum); 
        assertTrue(costoSeleccionadoJuan <= listaJuan.getPresupuesto(), "Se excede el presupuesto de Juan.");

        int satisfaccionSeleccionadaJuan = regalosSeleccionadosJuan.stream()
                .map(Regalo::getPrioridad)
                .reduce(0, Integer::sum); 
        assertEquals(SATISFACCION_TOTAL_ESPERADA_JUAN, satisfaccionSeleccionadaJuan, "La satisfacción total para Juan no es la esperada.");

        ListaRegalos listaAna = listas.get(1);
        List<Regalo> regalosSeleccionadosAna = listaAna.obtenerRegalosDentroPresupuesto();

        double costoSeleccionadoAna = regalosSeleccionadosAna.stream()
                .map(Regalo::getPrecio)
                .reduce(0.0, Double::sum);
        assertTrue(costoSeleccionadoAna <= listaAna.getPresupuesto(), "Se excede el presupuesto de Ana.");

        int satisfaccionSeleccionadaAna = regalosSeleccionadosAna.stream()
                .map(Regalo::getPrioridad)
                .reduce(0, Integer::sum);
        assertEquals(SATISFACCION_TOTAL_ESPERADA_ANA, satisfaccionSeleccionadaAna, "La satisfacción total para Ana no es la esperada.");
    }

    @Test
    void verificarAsignacionesSubóptimas() {
        List<ListaRegalos> listas = ListaRegalos.cargarListasDeTexto(TEST_DATA_PATH);

        ListaRegalos listaJuan = listas.get(0);
        List<Regalo> regalosSeleccionadosJuan = listaJuan.obtenerRegalosDentroPresupuesto();

        List<Regalo> regalosSuboptimosJuan = listaJuan.getRegalos()
                .stream()
                .sorted((r1, r2) -> Integer.compare(r1.getPrioridad(), r2.getPrioridad()))
                .toList();

        double costoSuboptimoJuan = 0.0;
        int satisfaccionSuboptimaJuan = 0;
        for (Regalo regalo : regalosSuboptimosJuan) {
            if (costoSuboptimoJuan + regalo.getPrecio() <= listaJuan.getPresupuesto()) {
                costoSuboptimoJuan += regalo.getPrecio();
                satisfaccionSuboptimaJuan += regalo.getPrioridad();
            }
        }

        int satisfaccionOptimaJuan = regalosSeleccionadosJuan.stream()
                .map(Regalo::getPrioridad)
                .reduce(0, Integer::sum);

        assertTrue(satisfaccionOptimaJuan > satisfaccionSuboptimaJuan,
                "La asignación óptima no maximiza la satisfacción para Juan.");
    }

}
