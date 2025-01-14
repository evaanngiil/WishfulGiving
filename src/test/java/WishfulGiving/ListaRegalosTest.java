package WishfulGiving;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ListaRegalosTest {
    
    private static final int REGALOS_DENTRO_PRESUPUESTO = 2;
    private static final String TEST_JSON_PATH = "data/test_regalos.json";

    @Test
    void obtenerRegalosDentroDelPresupuesto() {
        List<ListaRegalos> listas = JsonLoader.cargarListasDeRegalos(TEST_JSON_PATH);
        ListaRegalos listaJuan = listas.get(0);

        List<Regalo> regalosSeleccionados = listaJuan.obtenerRegalosDentroPresupuesto();

        List<Regalo> regalosEsperados = List.of(
                new Regalo("Enter de peluche", "Un enter de peluche enorme para desahogarme cuando me estreso haciendo código", 20.0, 5),
                new Regalo("Libro", "Un libro sobre Testing en Java super intersante que en algun lugar de la mancha", 20.0, 3)
        );

        boolean sonIguales = regalosEsperados.size() == regalosSeleccionados.size()
                && regalosEsperados.stream().allMatch(esperado
                        -> regalosSeleccionados.stream().anyMatch(seleccionado
                        -> seleccionado.getTitulo().equals(esperado.getTitulo())));

        assertTrue(sonIguales, "Los regalos seleccionados no coinciden exactamente con los regalos esperados.");
    }
    
    @Test
    void calcularPresupuestoRestante() {
        var listas = JsonLoader.cargarListasDeRegalos(TEST_JSON_PATH);
        
        ListaRegalos listaAna = listas.get(1);

        double presupuestoRestante = listaAna.calcularPresupuestoRestante();
        assertEquals(10.0, presupuestoRestante,
                "El presupuesto restante calculado no es el esperado.");
    }

    