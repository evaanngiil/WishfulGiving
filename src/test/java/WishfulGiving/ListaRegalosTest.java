package WishfulGiving;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ListaRegalosTest {
    private static final double PRESUPUESTO_RESTANTE_ANA = 5.0;
    private static final double COSTO_TOTAL_ESPERADO_JUAN = 90.0;
    private static final int SATISFACCION_TOTAL_ESPERADA_JUAN = 9;
    private static final double COSTO_TOTAL_ESPERADO_ANA = 45.0;
    private static final int SATISFACCION_TOTAL_ESPERADA_ANA = 10;
    private static final String TEST_DATA_PATH = "data/test_regalos.txt";

    @Test
    void calcularPresupuestoRestante() {
        GestorListaRegalos gestor = GestorListaRegalos.cargarListasDeTexto(TEST_DATA_PATH);

        ListaRegalos listaAna = gestor.obtenerListasPorPropietario("Evan").stream()
                .filter(lista -> lista.getDestinatario().equals("Ana"))
                .findFirst()
                .orElseThrow(() -> new AssertionError("No se encontró la lista para Ana."));

        double presupuestoRestante = listaAna.calcularPresupuestoRestante();
        assertEquals(PRESUPUESTO_RESTANTE_ANA, presupuestoRestante,
                "El presupuesto restante calculado no es el esperado.");
    }

    @Test
    void compararSatisfaccionYCosto() {
        GestorListaRegalos gestor = GestorListaRegalos.cargarListasDeTexto(TEST_DATA_PATH);

        verificarSatisfaccionYCosto(gestor, "Evan", "Juan", COSTO_TOTAL_ESPERADO_JUAN, SATISFACCION_TOTAL_ESPERADA_JUAN);
        verificarSatisfaccionYCosto(gestor, "Evan", "Ana", COSTO_TOTAL_ESPERADO_ANA, SATISFACCION_TOTAL_ESPERADA_ANA);
    }

    @Test
    void verificarAsignacionesSubóptimas() {
        GestorListaRegalos gestor = GestorListaRegalos.cargarListasDeTexto(TEST_DATA_PATH);

        verificarSatisfaccionYSuboptima(gestor, "Evan", "Juan", 100.0);
        verificarSatisfaccionYSuboptima(gestor, "Evan", "Ana", 50.0);
    }

    private void verificarSatisfaccionYCosto(GestorListaRegalos gestor, String propietario, String destinatario, double costoEsperado, int satisfaccionEsperada) {
        ListaRegalos lista = gestor.obtenerListasPorPropietario(propietario).stream()
                .filter(l -> l.getDestinatario().equals(destinatario))
                .findFirst()
                .orElseThrow(() -> new AssertionError("No se encontró la lista para " + destinatario));

        List<Regalo> regalosSeleccionados = lista.obtenerRegalosDentroPresupuesto();

        double costoSeleccionado = regalosSeleccionados.stream()
                .map(Regalo::getPrecio)
                .reduce(0.0, Double::sum);
        assertEquals(costoEsperado, costoSeleccionado, "El costo total para " + destinatario + " no es el esperado.");

        int satisfaccionSeleccionada = regalosSeleccionados.stream()
                .mapToInt(Regalo::getPrioridad)
                .sum();
        assertEquals(satisfaccionEsperada, satisfaccionSeleccionada, "La satisfacción total para " + destinatario + " no es la esperada.");
    }

    private void verificarSatisfaccionYSuboptima(GestorListaRegalos gestor, String propietario, String destinatario, double presupuesto) {
        ListaRegalos lista = gestor.obtenerListasPorPropietario(propietario).stream()
                .filter(list -> list.getDestinatario().equals(destinatario))
                .findFirst()
                .orElseThrow(() -> new AssertionError("No se encontró la lista para " + destinatario));

        List<Regalo> regalosSeleccionadosOptimos = lista.obtenerRegalosDentroPresupuesto();
        int satisfaccionOptima = regalosSeleccionadosOptimos.stream()
                .mapToInt(Regalo::getPrioridad)
                .sum();

        List<Regalo> regalosSeleccionadosPorCosto = lista.obtenerRegalosPorCostoMinimo();
        int satisfaccionSuboptima = regalosSeleccionadosPorCosto.stream()
                .mapToInt(Regalo::getPrioridad)
                .sum();

        assertTrue(satisfaccionOptima > satisfaccionSuboptima,
                "La asignación óptima no maximiza la satisfacción para " + destinatario);
    }
}
