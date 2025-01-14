package WishfulGiving;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ListaRegalosTest {
    
    private static final int REGALOS_DENTRO_PRESUPUESTO = 2;
    private static final List<Regalo> REGALOS_ESPERADOS = List.of(
            new Regalo("Enter de peluche", "Un enter de peluche enorme para desahogarme cuando me estreso haciendo código", 20.0, 5),
            new Regalo("Monopoly 64 peones", "Monopoly con destacados de oro y plata y con hasta 64 peones", 70.0, 4)
    );
    private static final String TEST_JSON_PATH = "data/test_regalos.json";

    @Test
    void obtenerRegalosDentroDelPresupuesto() {
        List<ListaRegalos> listas = JsonLoader.cargarListasDeRegalos(TEST_JSON_PATH);
        ListaRegalos listaJuan = listas.get(0);

        List<Regalo> regalosSeleccionados = listaJuan.obtenerRegalosDentroPresupuesto();

        boolean sonIguales = REGALOS_ESPERADOS.size() == regalosSeleccionados.size()
                && REGALOS_ESPERADOS.stream().allMatch(esperado
                        -> regalosSeleccionados.stream().anyMatch(seleccionado
                        -> seleccionado.getTitulo().equals(esperado.getTitulo())));
        
        assertTrue(sonIguales, "Los regalos seleccionados no coinciden exactamente con los regalos esperados.");
    }

    @Test
    void maximizarSatisfaccion() {
        List<ListaRegalos> listas = JsonLoader.cargarListasDeRegalos(TEST_JSON_PATH);
        ListaRegalos lista = listas.get(0);

        List<Regalo> regalosSeleccionados = lista.obtenerRegalosDentroPresupuesto();

        int prioridadSeleccionada = regalosSeleccionados.stream().mapToInt(Regalo::getPrioridad).sum();
        int prioridadEsperada = REGALOS_ESPERADOS.stream().mapToInt(Regalo::getPrioridad).sum();

        assertEquals(prioridadEsperada, prioridadSeleccionada, "La prioridad total calculada no maximiza la satisfacción dentro del presupuesto.");
        assertTrue(regalosSeleccionados.size() <= REGALOS_DENTRO_PRESUPUESTO, "El número de regalos seleccionados no debe exceder los disponibles dentro del presupuesto.");
    }
    
    @Test
    void calcularPresupuestoRestante() {
        var listas = JsonLoader.cargarListasDeRegalos(TEST_JSON_PATH);
        
        ListaRegalos listaAna = listas.get(1);

        double presupuestoRestante = listaAna.calcularPresupuestoRestante();
        assertEquals(10.0, presupuestoRestante,
                "El presupuesto restante calculado no es el esperado.");
    }
}
